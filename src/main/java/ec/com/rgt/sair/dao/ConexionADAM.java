package ec.com.rgt.sair.dao;

import ec.com.rgt.sair.hbm.UsuariosAD;
import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.hbm.SairObsLocalidad;
import ec.com.rgt.sair.hbm.SairAreasAdam;
import java.math.BigDecimal;
import java.util.List;
import ec.com.rgt.sair.hbm.SairGerente;
import ec.com.rgt.sair.controller.XmlParse;
import java.util.ArrayList;

public class ConexionADAM
{
    public static void main(final String[] arg) {
        updateDepartamentos();
    }
    
    public static void updateUsuarios() {
        System.out.println("-----ACTUALIZACION DE USUARIOS OPER-----");
        final DAO dao = new DAO();
        final List<String> lis = new ArrayList<String>();
        System.out.println("CONSULTA DE USUARIOS DE OPERACIONES");
        final SairGerente[] gerentes = XmlParse.parseTrama();
        System.out.println((gerentes != null) ? "CONSULTA CON RESULTADOS" : "CONSULTA SIN RESULTADOS - TERMINA METODO DE ACT USUARIOS");
        if (gerentes != null) {
            System.out.println("TOMA CADA USUARIO DE LA TRAMA");
            for (int i = 0; i < gerentes.length; ++i) {
                final SairGerente adam = gerentes[i];
                System.out.println("ID USUARIO A PROCESAR: " + adam.getIdGerente().toString() + " NAME: " + adam.getUsuario());
                lis.add(adam.getIdGerente().toString());
                System.out.println("CONSULTA SAIR_GERENTE POR USUARIO: " + adam.getIdGerente().toString());
                final List<SairGerente> l = (List<SairGerente>)dao.find("from SairGerente a where a.idGerente=" + adam.getIdGerente());
                if (l.isEmpty()) {
                    System.out.println("NO EXISTE USUARIO EN SAIR_GERENTE " + adam.getIdGerente().toString());
                    System.out.println("SE CREA NUEVO USUARIO EN SAIR_GERENTE CON ESTADO 'A'");
                    adam.setEstado("A");
                    dao.saveOrUpdate((Object)adam, (Class)adam.getClass());
                    System.out.println("NUEVO U " + adam.getIdGerente());
                }
                System.out.println("SE PRODECE A VALIDAR INFORMACION DEL USUARIO EN SAIR CON EL USUARIO EN OPER, SE ACTUALIZA INFORMACI\u00d3N DE SER NECESARIO");
                for (int j = 0; j < l.size(); ++j) {
                    boolean ban = false;
                    SairGerente areasAdam = new SairGerente();
                    areasAdam = l.get(j);
                    try {
                        if (areasAdam.getExepcion() == null || !areasAdam.getExepcion().equals("S")) {
                            ban = !areasAdam.getNombre().trim().toUpperCase().equals(adam.getNombre().trim().toUpperCase());
                            if (!ban) {
                                ban = !areasAdam.getApellido().trim().toUpperCase().equals(adam.getApellido().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = !areasAdam.getUsuario().trim().toUpperCase().equals(adam.getUsuario().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = !areasAdam.getCargo().trim().toUpperCase().equals(adam.getCargo().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = !areasAdam.getIdJefe().toString().trim().toUpperCase().equals(adam.getIdJefe().toString().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = !areasAdam.getIdDepartamento().toString().trim().toUpperCase().equals(adam.getIdDepartamento().toString().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = !areasAdam.getIdArea().toString().trim().toUpperCase().equals(adam.getIdArea().toString().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = !areasAdam.getProvincia().trim().toUpperCase().equals(adam.getProvincia().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = !areasAdam.getCedula().trim().toUpperCase().equals(adam.getCedula().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = !areasAdam.getIdLocalidad().toString().trim().toUpperCase().equals(adam.getIdLocalidad().toString().trim().toUpperCase());
                            }
                            final String mail = (areasAdam.getEmail() != null) ? areasAdam.getEmail().trim().toUpperCase() : " ";
                            if (!ban) {
                                ban = !adam.getEmail().trim().toUpperCase().equals(mail);
                            }
                            if (!ban) {
                                ban = areasAdam.getEstado().equals("I");
                            }
                        }
                    }
                    catch (Exception e) {
                        ban = true;
                    }
                    if (ban) {
                        areasAdam.setNombre(adam.getNombre());
                        areasAdam.setApellido(adam.getApellido());
                        areasAdam.setUsuario(adam.getUsuario());
                        areasAdam.setCargo(adam.getCargo());
                        areasAdam.setIdJefe(adam.getIdJefe());
                        areasAdam.setIdDepartamento(adam.getIdDepartamento());
                        areasAdam.setNombresCompletos(adam.getNombresCompletos());
                        areasAdam.setIdArea(adam.getIdArea());
                        areasAdam.setProvincia(adam.getProvincia());
                        areasAdam.setCedula(adam.getCedula());
                        areasAdam.setIdLocalidad(adam.getIdLocalidad());
                        areasAdam.setEstado("A");
                        areasAdam.setEmail(adam.getEmail());
                        dao.saveOrUpdate((Object)areasAdam, (Class)areasAdam.getClass());
                        System.out.println("ACTUALIZO USUARIO " + areasAdam.getIdGerente());
                    }
                }
            }
        }
        if (!lis.isEmpty()) {
            final List<SairGerente> lista = (List<SairGerente>)dao.find("from SairGerente g where g.estado='A' order by g.idGerente");
            for (int k = 0; k < lista.size(); ++k) {
                final SairGerente gerent = lista.get(k);
                boolean elimina = true;
                for (int m = 0; m < lis.size(); ++m) {
                    final String adam2 = lis.get(m);
                    if (gerent.getIdGerente().toString().equals(adam2)) {
                        elimina = false;
                        break;
                    }
                }
                if (elimina && (gerent.getExepcion() == null || !gerent.getExepcion().equals("S"))) {
                    System.out.println("eliminado U " + gerent.getUsuario());
                    gerent.setEstado("I");
                    dao.saveOrUpdate((Object)gerent, (Class)gerent.getClass());
                }
            }
        }
    }
    
    public static void updateDepartamentos() {
        System.out.println("------ACTUALIZACION DE DEPARTAMENTOS------");
        final DAO dao = new DAO();
        final List<String> idDepartamentoOperList = new ArrayList<String>();
        System.out.println("CONSULTA DE DEPARTAMENTOS A OPERACIONES");
        final SairAreasAdam[] departamentosOper = XmlParse.parseTramaDepar();
        System.out.println((departamentosOper != null) ? "CONSULTA CON RESULTADOS" : "CONSULTA SIN RESULTADOS - TERMINA METODO DE ACT DEPARTAMENTOS");
        if (departamentosOper != null) {
            System.out.println("TOMA CADA DEPART DE LA TRAMA");
            for (int i = 0; i < departamentosOper.length; ++i) {
                final SairAreasAdam departamentoOper = departamentosOper[i];
                System.out.println("ID DEPARTAMENTO A PROCESAR: " + departamentoOper.getCodiSfsf() + " NAME: " + departamentoOper.getDescripcion());
                idDepartamentoOperList.add(departamentoOper.getCodiSfsf().toString());
                System.out.println("CONSULTA AREA SAIR PARA EL DEPARTAMENTO " + departamentoOper.getCodiSfsf());
                final List<SairAreasAdam> areaAdamsList = (List<SairAreasAdam>)dao.find("from SairAreasAdam a where trim(a.codiSfsf)='" + departamentoOper.getCodiSfsf().trim() + "'");
                if (areaAdamsList == null || areaAdamsList.isEmpty()) {
                    System.out.println("NO EXISTE AREA PARA EL DEPARTAMENTO " + departamentoOper.getCodiSfsf());
                    System.out.println("SE CREA NUEVO DEPARTAMENTO EN SAIR_AREAS_ADAMS CON ESTADO 'A'");
                    final List<String> maxAreaAdam = (List<String>)dao.Sqlquery("select max(id_departamento) + 1 from sair_areas_adam");
                    final Long idDepart = Long.valueOf(maxAreaAdam.get(0));
                    departamentoOper.setIdDepartamento(BigDecimal.valueOf(idDepart));
                    departamentoOper.setCuenta("0");
                    departamentoOper.setEstado("A");
                    dao.saveOrUpdate((Object)departamentoOper, (Class)departamentoOper.getClass());
                    System.out.println("NUEVO D " + departamentoOper.getCodiSfsf().trim());
                }
                System.out.println("SE PRODECE A VALIDAR INFORMACION DEL AREA EN SAIR CON EL DEPARTAMENTO EN OPER, SE ACTUALIZA INFORMACION DE SER NECESARIO");
                if (areaAdamsList != null) {
                    for (int j = 0; j < areaAdamsList.size(); ++j) {
                        boolean ban = false;
                        SairAreasAdam areaAdam = new SairAreasAdam();
                        areaAdam = areaAdamsList.get(j);
                        try {
                            ban = !areaAdam.getDescripcion().trim().toUpperCase().equals(departamentoOper.getDescripcion().trim().toUpperCase());
                            if (!ban) {
                                ban = !areaAdam.getCodiSfsf().trim().toUpperCase().equals(departamentoOper.getCodiSfsf().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = !areaAdam.getCuenta().trim().toUpperCase().equals(departamentoOper.getCuenta().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = areaAdam.getEstado().equals("I");
                            }
                        }
                        catch (Exception e) {
                            ban = true;
                        }
                        if (ban) {
                            areaAdam.setDescripcion(departamentoOper.getDescripcion());
                            areaAdam.setCodiSfsf(departamentoOper.getCodiSfsf());
                            areaAdam.setCuenta(departamentoOper.getCuenta());
                            areaAdam.setEstado("A");
                            dao.saveOrUpdate((Object)areaAdam, (Class)areaAdam.getClass());
                            System.out.println("ACTUALIZO DEPTO " + areaAdam.getCodiSfsf());
                        }
                    }
                }
            }
        }
        if (!idDepartamentoOperList.isEmpty()) {
            final List<SairAreasAdam> areaAdamsList2 = (List<SairAreasAdam>)dao.find("from SairAreasAdam g where g.estado='A' order by g.idDepartamento");
            for (int k = 0; k < areaAdamsList2.size(); ++k) {
                final SairAreasAdam areaAdam2 = areaAdamsList2.get(k);
                boolean elimina = true;
                for (int l = 0; l < idDepartamentoOperList.size(); ++l) {
                    final String idDepartOper = idDepartamentoOperList.get(l);
                    if (areaAdam2.getCodiSfsf() != null && areaAdam2.getCodiSfsf().toString().equals(idDepartOper)) {
                        elimina = false;
                        break;
                    }
                }
                if (elimina) {
                    System.out.println("eliminado D " + areaAdam2.getDescripcion());
                    areaAdam2.setEstado("I");
                    dao.saveOrUpdate((Object)areaAdam2, (Class)areaAdam2.getClass());
                }
            }
        }
    }
    
    public static void updateAgencias() {
        final DAO dao = new DAO();
        final List<String> lis = new ArrayList<String>();
        final SairObsLocalidad[] gerentes = XmlParse.parseTramaAgencia();
        if (gerentes != null) {
            for (int i = 0; i < gerentes.length; ++i) {
                final SairObsLocalidad adam = gerentes[i];
                lis.add(adam.getIdLocalidad());
                final List<SairObsLocalidad> l = (List<SairObsLocalidad>)dao.find("from SairObsLocalidad a where a.idLocalidad='" + adam.getIdLocalidad() + "'");
                if (l.isEmpty()) {
                    adam.setEstado("A");
                    dao.saveOrUpdate((Object)adam, (Class)adam.getClass());
                    System.out.println("NUEVO A " + adam.getIdLocalidad());
                }
                for (int j = 0; j < l.size(); ++j) {
                    boolean ban = false;
                    SairObsLocalidad areasAdam = new SairObsLocalidad();
                    areasAdam = l.get(j);
                    try {
                        ban = !areasAdam.getNombre().trim().toUpperCase().equals(adam.getNombre().trim().toUpperCase());
                        if (!ban) {
                            ban = !areasAdam.getDireccion().trim().toUpperCase().equals(adam.getDireccion().trim().toUpperCase());
                        }
                        if (!ban) {
                            ban = areasAdam.getEstado().equals("I");
                        }
                    }
                    catch (Exception e) {
                        ban = true;
                    }
                    if (ban) {
                        areasAdam.setNombre(adam.getNombre());
                        areasAdam.setNombreReal(adam.getNombreReal());
                        areasAdam.setDireccion(adam.getDireccion());
                        areasAdam.setEstado("A");
                        dao.saveOrUpdate((Object)areasAdam, (Class)areasAdam.getClass());
                        System.out.println("actualizo A " + areasAdam.getIdLocalidad());
                    }
                }
            }
        }
        if (!lis.isEmpty()) {
            final List<SairObsLocalidad> lista = (List<SairObsLocalidad>)dao.find("from SairObsLocalidad g where g.estado='A' order by g.idLocalidad");
            for (int k = 0; k < lista.size(); ++k) {
                final SairObsLocalidad gerent = lista.get(k);
                boolean elimina = true;
                for (int m = 0; m < lis.size(); ++m) {
                    final String adam2 = lis.get(m);
                    if (gerent.getIdLocalidad().toString().equals(adam2)) {
                        elimina = false;
                        break;
                    }
                }
                if (elimina) {
                    System.out.println("eliminado A " + gerent.getNombre());
                    gerent.setEstado("I");
                    dao.saveOrUpdate((Object)gerent, (Class)gerent.getClass());
                }
            }
        }
    }
    
    public static void updateUsuariosAD() {
        System.out.println("------ACTUALIZACION DE USUARIOS AD------");
        final DAO dao = new DAO();
        final ArrayList<String> ad = (ArrayList<String>)dao.Sqlquery("select count(*) from usuarios_ad");
        System.out.println("--> SE CUENTAN LOS REGISTROS EN USUARIOS_AD: " + ad.get(0));
        System.out.println("--> SI HAY USUARIOS EN USUARIOS_A, VACIA LA TABLA EXCEPTO AQUELLOS USUARIOS TEC Y SIS.");
        if (!ad.isEmpty()) {
            final int n = Integer.parseInt(ad.get(0));
            if (n > 0) {
                System.out.println("--> VACIANDO TABLA USUARIOS_AD");
            }
        }
        System.out.println("--> SE CONSULTA LA TABLA USUARIOS_AD");
        final List<UsuariosAD> adnew = (List<UsuariosAD>)dao.find("from UsuariosAD");
        if (adnew.isEmpty()) {
            System.out.println("--> SE REINICIA LA SECUENCIA DE USUARIOS_AD");
            Conexion.CallProcessResetSecUsuariosAD();
        }
        System.out.println("--> CRON SINCRONIZACION EN MARCHA");
        System.out.println("--> CONSULTANDO SAIR_AREAS_ADAM");
        final List<SairAreasAdam> area = (List<SairAreasAdam>)dao.find("from SairAreasAdam where estado='A' order by descripcion");
        if (!area.isEmpty()) {
            System.out.println("--> EXISTEN AREAS A PROCESAR");
            final LdapAutenticationWS ws = new LdapAutenticationWS();
            for (int i = 0; i < area.size(); ++i) {
                if (area.get(i).getInicial() != null) {
                    final String areaAdam = (area.get(i).getInicial() != null) ? area.get(i).getInicial().trim() : area.get(i).getCodiAdam().trim();
                    if (!areaAdam.equals("SIS") && !areaAdam.equals("TEC")) {
                        System.out.println("--> [" + areaAdam + "]: SE OBTIENE USUARIOS DEL AD POR AREA");
                        final List<Mensaje> m = (List<Mensaje>)ws.getUsersAreaAD(areaAdam, area.get(i).getCodiAdam());
                        if (!m.isEmpty()) {
                            System.out.println("Sincronizacion de AD a SAIR: area " + areaAdam + " " + m.get(0).getMensaje());
                        }
                        else {
                            System.out.println("Error: No se pudo actualizar los usuarios con el filtro " + areaAdam);
                        }
                    }
                    else {
                        System.out.println("Sincronizacion de AD a SAIR: El area " + areaAdam + " no entro en proceso.");
                    }
                }
                else {
                    System.out.println("No existe Inicial para Area " + area.get(i).getDescripcion());
                }
            }
        }
        System.out.println("Cron Sincronizacion finalizado");
    }
}