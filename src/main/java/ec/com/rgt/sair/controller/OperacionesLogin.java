package ec.com.rgt.sair.controller;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.LoginDAO;
import ec.com.rgt.sair.dao.UsuariosDAO;
import ec.com.rgt.sair.hbm.Aplicaciones;
import ec.com.rgt.sair.hbm.Menues;
import ec.com.rgt.sair.hbm.Permisos;
import ec.com.rgt.sair.hbm.Rsa;
import ec.com.rgt.sair.hbm.Usuarios;

@SuppressWarnings("rawtypes")
public class OperacionesLogin {

    DAO dao = new DAO();
    List lst_rsa = dao.find("from Rsa r where r.idRsa = (select max(idRsa) from Rsa)");
    Rsa rsa = (Rsa) lst_rsa.get(0);
    RSA encriptar = new RSA(new BigInteger(rsa.getValorN().toString()), 
                            new BigInteger(rsa.getPublicoE().toString()),
                            new BigInteger(rsa.getPrivadoD().toString()));
    LoginDAO grupos = new LoginDAO();
    UsuariosDAO user = new UsuariosDAO();
    //BigInteger[] encriptado;
    BigInteger e,n;
    String clave_encriptada = "",llave_publica;
    //BlowfishCipher cifrado = new BlowfishCipher();

    public String obtenerKeyPublica() {
        String resultado = "";
        resultado = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<elements>\n"
                + "<element>\n"
                + "<valorn>" + rsa.getValorN() + "</valorn>\n"
                + "<publicae>" + rsa.getPublicoE() + "</publicae>\n"
                + "</element>"
                + "<mensaje_respuesta>Exito</mensaje_respuesta>\n"
                + "<mensaje_tecnico>Exito</mensaje_tecnico>\n"
                + "</elements>";

        return resultado;
    }

    /*private String desencripta(BigInteger[] encriptado) {

		DocumentBuilder llave;
		try {
			llave = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			llave_publica = obtenerKeyPublica();
			is.setCharacterStream(new StringReader(llave_publica));
			Document doc = llave.parse(is);
			NodeList nodes = doc.getElementsByTagName("element");
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);
				NodeList valorn = element.getElementsByTagName("valorn");
				NodeList publica = element.getElementsByTagName("publicae");
				Element ele_n = (Element) valorn.item(0);
				Element ele_e = (Element) publica.item(0);
				e = new BigInteger(getCharacterDataFromElement(ele_e));
				n = new BigInteger(getCharacterDataFromElement(ele_n));
			}
			BigInteger[] desencriptado = new BigInteger[encriptado.length];

			for (int i = 0; i < desencriptado.length; i++) {
				desencriptado[i] = encriptado[i].modPow(e, n);
			}

			char[] charArray = new char[desencriptado.length];

			for (int i = 0; i < charArray.length; i++) {
				charArray[i] = (char) (desencriptado[i].intValue());
			}

			return (new String(charArray));
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}

		
	}*/

	/*private  String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}*/
	
    public String consultarGrupos(String usuario, BigDecimal idAplicacion) {

        String resultado = "", encabezado;
        encabezado = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<elements>\n";
        List grp = grupos.buscarGruposDeUsuario(usuario, idAplicacion);
        if (grp.size() > 0) {
            for (int i = 0; i < grp.size(); i++) {
                BigDecimal id_grupo = (BigDecimal) grp.get(i);
                List lst_grupo = grupos.obtenerNombreDeGrupo(id_grupo);
                String nombre_grupo = (String) lst_grupo.get(0);
                if (i == 0) {
                    resultado = encabezado
                            + "<element>\n"
                            + "<idGrupo>" + id_grupo + "</idGrupo>\n"
                            + "<nombreGrupo>" + nombre_grupo.trim() + "</nombreGrupo>\n"
                            + "</element>";
                } else {
                    resultado = resultado
                            + "<element>\n"
                            + "<idGrupo>" + id_grupo + "</idGrupo>\n"
                            + "<nombreGrupo>" + nombre_grupo.trim() + "</nombreGrupo>\n"
                            + "</element>";
                }

            }
            resultado = resultado
                    + "<id>1</id>\n"
                    + "<mensaje_respuesta>Exito</mensaje_respuesta>\n"
                    + "<mensaje_tecnico>Exito</mensaje_tecnico>\n"
                    + "</elements>";
        } else {
            resultado = encabezado
                    + "<id>0</id>\n"
                    + "<mensaje_respuesta>Error</mensaje_respuesta>\n"
                    + "<mensaje_tecnico>No existe el usuario</mensaje_tecnico>\n"
                    + "</elements>";
        }
        /*encriptado = encriptar.encripta(resultado);
        return encriptado;*/
        return resultado;
    }

    public String consultarAplicacion() {
    	String resultado = "", encabezado;
        encabezado = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<elements>\n";
        @SuppressWarnings("unchecked")
		List<Aplicaciones> lst_grupo =grupos.obtenerAplicacion();
        if(lst_grupo!=null){
        	int i=0;
        	for (Aplicaciones aplicaciones : lst_grupo) {
        		if (i == 0) {
                    resultado = encabezado
                            + "<element>\n"
                            + "<idAplicacion>" + aplicaciones.getIdAplicacion() + "</idAplicacion>\n"
                            + "<nombre>" + aplicaciones.getDescripcion() + "</nombre>\n"
                            + "</element>";
                } else {
                    resultado = resultado
                            + "<element>\n"
                            + "<idAplicacion>" + aplicaciones.getIdAplicacion() + "</idAplicacion>\n"
                            + "<nombre>" + aplicaciones.getDescripcion() + "</nombre>\n"
                            + "</element>";
                }
        		i++;
			}
        	resultado = resultado
                    + "<id>1</id>\n"
                    + "<mensaje_respuesta>Exito</mensaje_respuesta>\n"
                    + "<mensaje_tecnico>Exito</mensaje_tecnico>\n"
                    + "</elements>";
        }else{
        	resultado = encabezado
                    + "<id>0</id>\n"
                    + "<mensaje_respuesta>Error</mensaje_respuesta>\n"
                    + "<mensaje_tecnico>Error al consultar datos</mensaje_tecnico>\n"
                    + "</elements>";
        }
        /*return encriptado = encriptar.encripta(resultado);*/
        return resultado;
    }
    
    public String consultarAplicacion(String grupo) {

        String resultado = "", encabezado;
        encabezado = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<elements>\n";
        List lst_grupo = grupos.obtenerIdGrupo(grupo);
        if (lst_grupo.size() > 0) {
        	BigDecimal id_grupo = (BigDecimal) lst_grupo.get(0);
            List grp = grupos.obtenerAplicacion(id_grupo);
            if (grp.size() > 0) {
                for (int i = 0; i < grp.size(); i++) {
                	BigDecimal id_aplicacion = (BigDecimal) grp.get(i);
                    if (i == 0) {
                        resultado = encabezado
                                + "<element>\n"
                                + "<idAplicacion>" + id_aplicacion + "</idAplicacion>\n"
                                + "</element>";
                    } else {
                        resultado = resultado
                                + "<element>\n"
                                + "<idAplicacion>" + id_aplicacion + "</idAplicacion>\n"
                                + "</element>";
                    }

                }
                resultado = resultado
                        + "<id>1</id>\n"
                        + "<mensaje_respuesta>Exito</mensaje_respuesta>\n"
                        + "<mensaje_tecnico>Exito</mensaje_tecnico>\n"
                        + "</elements>";
            } else {
                resultado = encabezado
                        + "<id>0</id>\n"
                        + "<mensaje_respuesta>Error</mensaje_respuesta>\n"
                        + "<mensaje_tecnico>No hay aplicacion asociada al grupo</mensaje_tecnico>\n"
                        + "</elements>";
            }
        } else {
            resultado = encabezado
                    + "<id>0</id>\n"
                    + "<mensaje_respuesta>Error</mensaje_respuesta>\n"
                    + "<mensaje_tecnico>Grupo incorrecto</mensaje_tecnico>\n"
                    + "</elements>";
        }
        /*encriptado = encriptar.encripta(resultado);
        return encriptado;*/
        return resultado;
    }


    public String validaUsuario(String usuario, String clave) {
        String valida = "";
        List lst_user = grupos.validarUsuario(usuario, clave);
        if (lst_user.size() > 0) {
            valida = "Ok";
        }
        return valida;
    }

    public int actualizaClave(String usuario, String clave) {
        List lst_user = dao.find("from Usuarios u where u.idUsuario = '" + usuario + "'");
        Usuarios user_actual = (Usuarios) lst_user.get(0);
        //clave_encriptada = cifrado.encripta(clave);
        clave_encriptada = JBlowfish.encrypt(clave);
        user_actual.setClave(clave_encriptada);
        int estado = dao.saveOrUpdate(user_actual, user_actual.getClass());
        return estado;
    }

    public int seteaFechaExpClave(String usuario) {
        int estado = 0;
        List lst_user = dao.find("from Usuarios u where u.idUsuario = '" + usuario + "'");
        Usuarios user_actual = (Usuarios) lst_user.get(0);
        user_actual.setFechaExpiracionClave(null);
        estado = dao.saveOrUpdate(user_actual, user_actual.getClass());
        return estado;
    }

    public String obtenerFechaExpiraClave(String usuario) {
        String mensaje = "No tiene fecha de expiracion";
        Date fecha_exp_clave = null;

        List lst_usuario = dao.find("from Usuarios u where u.idUsuario = '" + usuario + "'");
        if(lst_usuario.size()>0){
        Usuarios usuario_new = (Usuarios) lst_usuario.get(0);
        fecha_exp_clave = usuario_new.getFechaExpiracionClave();}
        if (fecha_exp_clave == null) {
            return mensaje;
        } else {
            return fecha_exp_clave.toString().trim();
        }
    }

    public String obtenerArbol(String idGrupo, BigDecimal idAplicacion) {

        String resultado = "", encabezado;
        BigDecimal id_grupo = null ;
        try {
            List lst_grupo = grupos.obtenerIdGrupo(idGrupo);
            id_grupo =  (BigDecimal) lst_grupo.get(0);
        } catch (java.lang.IndexOutOfBoundsException e) {
            Logger.getLogger(OperacionesLogin.class.getName()).log(Level.SEVERE, null, e);
        }
        encabezado = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<elements>\n";
        List grp = grupos.obtenerArbolMenu(id_grupo,idAplicacion);
        try {
            for (int i = 0; i < grp.size(); i++) {
                Menues menu_arbol = (Menues) grp.get(i);
                if (i == 0) {
                	if(menu_arbol.getIdMenuPadre()==null){
                		resultado = encabezado
                                + "<element>\n"
                                + "<idMenu>" + (menu_arbol.getIdMenu()).toString() + "</idMenu>\n"
                                + "<menues>0</menues>\n"
                                + "<descripcion>" + menu_arbol.getDescripcion().trim() + "</descripcion>\n"
                                + "<rutaAcceso>" + menu_arbol.getRutaAcceso().trim().toString() + "</rutaAcceso>\n"
                                + "<orden>" + menu_arbol.getOrden() + "</orden>\n"
                                + "<estado>" + menu_arbol.getEstado() + "</estado>\n"
                                + "</element>";
                	}else{
                    resultado = encabezado
                            + "<element>\n"
                            + "<idMenu>" + (menu_arbol.getIdMenu()).toString() + "</idMenu>\n"
                            + "<menues>" + menu_arbol.getIdMenuPadre() + "</menues>\n"
                            + "<descripcion>" + menu_arbol.getDescripcion().trim() + "</descripcion>\n"
                            + "<rutaAcceso>" + menu_arbol.getRutaAcceso().trim().toString() + "</rutaAcceso>\n"
                            + "<orden>" + menu_arbol.getOrden() + "</orden>\n"
                            + "<estado>" + menu_arbol.getEstado() + "</estado>\n"
                            + "</element>";
                    }
                } else {
                	if(menu_arbol.getIdMenuPadre()==null){
                		resultado = resultado
                                + "<element>\n"
                                + "<idMenu>" + (menu_arbol.getIdMenu()).toString() + "</idMenu>\n"
                                + "<menues>0</menues>\n"
                                + "<descripcion>" + menu_arbol.getDescripcion().trim() + "</descripcion>\n"
                                + "<rutaAcceso>" + menu_arbol.getRutaAcceso().trim().toString() + "</rutaAcceso>\n"
                                + "<orden>" + menu_arbol.getOrden() + "</orden>\n"
                                + "<estado>" + menu_arbol.getEstado() + "</estado>\n"
                                + "</element>";
                	}else{
                    resultado = resultado
                            + "<element>\n"
                            + "<idMenu>" + (menu_arbol.getIdMenu()).toString() + "</idMenu>\n"
                            + "<menues>" + menu_arbol.getIdMenuPadre() + "</menues>\n"
                            + "<descripcion>" + menu_arbol.getDescripcion().trim() + "</descripcion>\n"
                            + "<rutaAcceso>" + menu_arbol.getRutaAcceso().trim().toString() + "</rutaAcceso>\n"
                            + "<orden>" + menu_arbol.getOrden() + "</orden>\n"
                            + "<estado>" + menu_arbol.getEstado() + "</estado>\n"
                            + "</element>";
                    }
                }

            }
        } catch (NullPointerException ex) {
            Logger.getLogger(OperacionesLogin.class.getName()).log(Level.SEVERE, null, ex);

        }
        resultado = resultado
                + "<mensaje_respuesta>Exito</mensaje_respuesta>\n"
                + "<mensaje_tecnico>Exito</mensaje_tecnico>\n"
                + "</elements>";
       /* encriptado = encriptar.encripta(resultado);
        return encriptado;*/
        return resultado;

    }
    
    

    public String  obtenerPermisos(String nombreGrupo) {
        String resultado = "", encabezado;
        encabezado = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<elements>\n";
        List lst_grupo = grupos.obtenerIdGrupo(nombreGrupo);
        if (lst_grupo.size() > 0) {
        	BigDecimal idGrupo = (BigDecimal) lst_grupo.get(0);
            List lst_permisos = grupos.obtenerPermisos(idGrupo);
            if (lst_permisos.size() > 0) {
                for (int i = 0; i < lst_permisos.size(); i++) {
                    Permisos permiso = (Permisos) lst_permisos.get(i);
                    if (i == 0) {
                        resultado = encabezado
                                + "<element>\n"
                                + "<idPermiso>" + permiso.getIdPermiso() + "</idPermiso>\n"
                                + "</element>";
                    } else {
                        resultado = resultado
                                + "<element>\n"
                                + "<idPermiso>" + permiso.getIdPermiso() + "</idPermiso>\n"
                                + "</element>";
                    }

                }
                resultado = resultado
                        + "<idGrupo>" + idGrupo + "</idGrupo>\n"
                        + "<id>1</id>\n"
                        + "<mensaje_respuesta>Exito</mensaje_respuesta>\n"
                        + "<mensaje_tecnico>Exito</mensaje_tecnico>\n"
                        + "</elements>";
            } else {
                resultado = encabezado
                        + "<id>0</id>\n"
                        + "<mensaje_respuesta>Error</mensaje_respuesta>\n"
                        + "<mensaje_tecnico>No se cargaron correctamente permisos</mensaje_tecnico>\n"
                        + "</elements>";
            }
        } else {
            resultado = encabezado
                    + "<id>0</id>\n"
                    + "<mensaje_respuesta>Error</mensaje_respuesta>\n"
                    + "<mensaje_tecnico>Grupo incorrecto</mensaje_tecnico>\n"
                    + "</elements>";
        }
        /*encriptado = encriptar.encripta(resultado);
        return encriptado;*/
        return resultado;
    }
    
    @SuppressWarnings("unchecked")
	public List<Permisos> obtenerAllPermisos(String nombreGrupo){
    	List<Permisos> lst_permisos=null;
    	List lst_grupo = grupos.obtenerIdGrupo(nombreGrupo);
        if (lst_grupo.size() > 0) {
        	BigDecimal idGrupo = (BigDecimal) lst_grupo.get(0);
            lst_permisos = grupos.obtenerPermisos(idGrupo);
        }
        return lst_permisos;
    }
    
    public List<Mensaje> DeleteUserAD()
    {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		Mensaje Obj_Mensaje = new Mensaje();
		try
		{
			DAO dao=new DAO();
			dao.deleteAllTable("usuarios_ad");
			Obj_Mensaje.setIdMensaje(1);
			Obj_Mensaje.setMensaje("Eliminacion Exitoso");
			LstMensaje.add(Obj_Mensaje);
			return LstMensaje;
		}catch(Exception e)
		{
			Obj_Mensaje.setIdMensaje(0);
			Obj_Mensaje.setMensaje("Eliminacion Fallido");
			return LstMensaje;
		}
	}
}
