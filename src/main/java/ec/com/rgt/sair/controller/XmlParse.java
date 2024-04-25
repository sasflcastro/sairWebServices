package ec.com.rgt.sair.controller;

import ec.com.rgt.sair.hbm.SairObsLocalidad;
import ec.com.rgt.sair.hbm.SairAreasAdam;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.util.NoSuchElementException;
import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.io.StringReader;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilderFactory;
import ec.com.rgt.sair.hbm.SairGerente;
import ec.com.rgt.sair.dao.UtilsDAO;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import ec.com.rgt.sair.dao.ConexionADAM;
import java.util.ResourceBundle;

public class XmlParse
{
    static ResourceBundle props;
    
    static {
        XmlParse.props = ResourceBundle.getBundle("EIS");
    }
    
    public static void main(final String[] s) {
        ConexionADAM.updateDepartamentos();
    }
    
    public static String getWS(final String idServicioInformacion) throws IOException {
        final URL url = new URL(XmlParse.props.getString("url"));
        final HttpURLConnection conexion = (HttpURLConnection)url.openConnection();
        conexion.setDoOutput(true);
        conexion.setRequestMethod("POST");
        conexion.setRequestProperty("Content-Type", "text/xml");
        conexion.setRequestProperty("Accept-Charset", "UTF-8");
        final OutputStreamWriter writer = new OutputStreamWriter(conexion.getOutputStream());
        writer.write("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://axis/EISApiOnlineWS.wsdl/types/\">                             <soapenv:Header/>                             <soapenv:Body>                                <typ:eipConsumeServicioElement>                                   <typ:dsId>" + XmlParse.props.getString("jdbc") + "</typ:dsId>" + "                                   <typ:pnIdServicioInformacion>" + idServicioInformacion + "</typ:pnIdServicioInformacion>" + "                                   <typ:pvParametroBind1></typ:pvParametroBind1>" + "                                   <typ:pvParametroBind2></typ:pvParametroBind2>" + "                                   <typ:pvParametroBind3></typ:pvParametroBind3>" + "                                   <typ:pvParametroBind4></typ:pvParametroBind4>" + "                                   <typ:pvParametroBind5></typ:pvParametroBind5>" + "                                </typ:eipConsumeServicioElement>" + "                             </soapenv:Body>" + "                          </soapenv:Envelope>");
        writer.close();
        final InputStreamReader reader = new InputStreamReader(conexion.getInputStream(), "UTF-8");
        final BufferedReader br = new BufferedReader(reader);
        String tmp = null;
        String respuest = "";
        while ((tmp = br.readLine()) != null) {
            respuest = String.valueOf(respuest) + tmp;
        }
        reader.close();
        return respuest;
    }
    
    public static String getTrama(final String idServicioInformacion) {
        try {
            return getWS(idServicioInformacion);
        }
        catch (IOException e) {
            final UtilsDAO dao = new UtilsDAO();
            dao.savelog("EIS", "CRON", "getTrama", "IOException", 88, e.getMessage(), "SEGURIDAD", 3);
            return null;
        }
    }
    
    public static SairGerente[] parseTrama() {
        SairGerente[] gerentes = null;
        try {
            final DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            final InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(getTrama(XmlParse.props.getString("IdServicioInformacionUser"))));
            System.out.println("--> SERVICIO DE INFORMACIO USUARIOS: " + XmlParse.props.getString("IdServicioInformacionUser"));
            System.out.println("--> RESULTADO: " + getTrama(XmlParse.props.getString("IdServicioInformacionUser")));
            final Document doc = db.parse(is);
            final NodeList pnerrorOut = doc.getElementsByTagName("ns0:pnerrorOut");
            final Node node = pnerrorOut.item(0);
            final String res = node.getTextContent();
            if (res.equals("0")) {
                final NodeList pvresultadoOut = doc.getElementsByTagName("ns0:pvresultadoOut");
                final Node elements = pvresultadoOut.item(0);
                final String result = elements.getTextContent();
                final StringTokenizer st = new StringTokenizer(result, XmlParse.props.getString("Separador_Registro"));
                gerentes = new SairGerente[st.countTokens()];
                int i = 0;
                while (st.hasMoreTokens()) {
                    final String fila = st.nextToken();
                    final StringTokenizer stk = new StringTokenizer(fila, String.valueOf(XmlParse.props.getString("Separador_Parametro")) + XmlParse.props.getString("Separador_Columna"));
                    gerentes[i] = new SairGerente();
                    int j = 0;
                    try {
                        while (stk.hasMoreTokens()) {
                            stk.nextToken();
                            if (j == 0) {
                                gerentes[i].setIdGerente(new BigDecimal(stk.nextToken()));
                            }
                            if (j == 1) {
                                gerentes[i].setNombre(stk.nextToken());
                            }
                            if (j == 2) {
                                gerentes[i].setApellido(stk.nextToken());
                                gerentes[i].setNombresCompletos(String.valueOf(gerentes[i].getApellido()) + " " + gerentes[i].getNombre());
                            }
                            if (j == 3) {
                                gerentes[i].setUsuario(stk.nextToken());
                            }
                            if (j == 4) {
                                gerentes[i].setCargo(stk.nextToken());
                            }
                            if (j == 5) {
                                try {
                                    gerentes[i].setIdJefe(new BigDecimal(stk.nextToken()));
                                }
                                catch (NumberFormatException ex2) {}
                            }
                            if (j == 6) {
                                try {
                                    gerentes[i].setIdDepartamento(new BigDecimal(stk.nextToken()));
                                }
                                catch (NumberFormatException ex3) {}
                            }
                            if (j == 7) {
                                try {
                                    gerentes[i].setIdArea(new BigDecimal(stk.nextToken()));
                                }
                                catch (NumberFormatException ex4) {}
                            }
                            if (j == 8) {
                                gerentes[i].setProvincia(stk.nextToken());
                            }
                            if (j == 9) {
                                gerentes[i].setCedula(stk.nextToken());
                            }
                            if (j == 10) {
                                gerentes[i].setIdLocalidad(stk.nextToken());
                            }
                            if (j == 11) {
                                gerentes[i].setEmail(stk.nextToken());
                            }
                            ++j;
                        }
                    }
                    catch (NoSuchElementException ex5) {}
                    ++i;
                }
            }
        }
        catch (ParserConfigurationException | SAXException | IOException ex6) {
            final Exception ex = null;
            final Exception e = ex;
            final UtilsDAO dao = new UtilsDAO();
            dao.savelog("EIS", "CRON", "parseTrama", "ParserConfigurationException", 155, e.getMessage(), "SEGURIDAD", 3);
        }
        return gerentes;
    }
    
    public static SairAreasAdam[] parseTramaDepar() {
        SairAreasAdam[] area = null;
        try {
            System.out.println("--> DENTRO DE BLOQUE TRY");
            System.out.println("--> LINEA 191");
            final DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            System.out.println("--> LINEA 193");
            final InputSource is = new InputSource();
            System.out.println("--> LINEA 196");
            is.setCharacterStream(new StringReader(getTrama(XmlParse.props.getString("IdServicioInformacionDepa"))));
            System.out.println("--> SERVICIO DE INFORMACIO DEPARTAMENTOS: " + XmlParse.props.getString("IdServicioInformacionDepa"));
            System.out.println("--> RESULTADO: " + getTrama(XmlParse.props.getString("IdServicioInformacionDepa")));
            final Document doc = db.parse(is);
            final NodeList pnerrorOut = doc.getElementsByTagName("ns0:pnerrorOut");
            final Node node = pnerrorOut.item(0);
            final String res = node.getTextContent();
            if (res.equals("0")) {
                final NodeList pvresultadoOut = doc.getElementsByTagName("ns0:pvresultadoOut");
                final Node elements = pvresultadoOut.item(0);
                final String result = elements.getTextContent();
                final StringTokenizer st = new StringTokenizer(result, XmlParse.props.getString("Separador_Registro"));
                area = new SairAreasAdam[st.countTokens()];
                int i = 0;
                while (st.hasMoreTokens()) {
                    final String fila = st.nextToken();
                    final StringTokenizer stk = new StringTokenizer(fila, String.valueOf(XmlParse.props.getString("Separador_Parametro")) + XmlParse.props.getString("Separador_Columna"));
                    area[i] = new SairAreasAdam();
                    int j = 0;
                    try {
                        while (stk.hasMoreTokens()) {
                            stk.nextToken();
                            if (j == 0) {
                                area[i].setIdDepartamento(new BigDecimal(stk.nextToken()));
                            }
                            if (j == 1) {
                                area[i].setDescripcion(stk.nextToken());
                            }
                            if (j == 2) {
                                area[i].setCuenta(stk.nextToken());
                            }
                            if (j == 3) {
                                area[i].setCodiSfsf(stk.nextToken());
                            }
                            ++j;
                        }
                    }
                    catch (NoSuchElementException ex2) {}
                    ++i;
                }
            }
        }
        catch (ParserConfigurationException | SAXException | IOException ex3) {
            final Exception ex = null;
            final Exception e = ex;
            final UtilsDAO dao = new UtilsDAO();
            dao.savelog("EIS", "CRON", "parseTramaDepar", "ParserConfigurationException", 155, e.getMessage(), "SEGURIDAD", 3);
        }
        return area;
    }
    
    public static SairObsLocalidad[] parseTramaAgencia() {
        SairObsLocalidad[] localidads = null;
        try {
            final DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            final InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(getTrama(XmlParse.props.getString("IdServicioInformacionAg"))));
            final Document doc = db.parse(is);
            final NodeList pnerrorOut = doc.getElementsByTagName("ns0:pnerrorOut");
            final Node node = pnerrorOut.item(0);
            final String res = node.getTextContent();
            if (res.equals("0")) {
                final NodeList pvresultadoOut = doc.getElementsByTagName("ns0:pvresultadoOut");
                final Node elements = pvresultadoOut.item(0);
                final String result = elements.getTextContent();
                final StringTokenizer st = new StringTokenizer(result, XmlParse.props.getString("Separador_Registro"));
                localidads = new SairObsLocalidad[st.countTokens()];
                int i = 0;
                while (st.hasMoreTokens()) {
                    final String fila = st.nextToken();
                    final StringTokenizer stk = new StringTokenizer(fila, String.valueOf(XmlParse.props.getString("Separador_Parametro")) + XmlParse.props.getString("Separador_Columna"));
                    localidads[i] = new SairObsLocalidad();
                    int j = 0;
                    try {
                        while (stk.hasMoreTokens()) {
                            stk.nextToken();
                            if (j == 0) {
                                localidads[i].setIdLocalidad(stk.nextToken());
                            }
                            if (j == 1) {
                                localidads[i].setNombre(stk.nextToken().trim());
                                String nombre_real = localidads[i].getNombre();
                                if (nombre_real.indexOf(" ") <= 4) {
                                    nombre_real = nombre_real.substring(nombre_real.indexOf(" ") + 1, nombre_real.length());
                                }
                                localidads[i].setNombreReal(nombre_real);
                            }
                            if (j == 2) {
                                localidads[i].setDireccion(stk.nextToken());
                            }
                            localidads[i].setEstado("A");
                            ++j;
                        }
                    }
                    catch (NoSuchElementException ex2) {}
                    ++i;
                }
            }
        }
        catch (ParserConfigurationException | SAXException | IOException ex3) {
            final Exception ex = null;
            final Exception e = ex;
            e.printStackTrace();
            final UtilsDAO dao = new UtilsDAO();
            dao.savelog("EIS", "CRON", "parseTramaAgencia", "ParserConfigurationException", 155, e.getMessage(), "SEGURIDAD", 3);
        }
        return localidads;
    }
}