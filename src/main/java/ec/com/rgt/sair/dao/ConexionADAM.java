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
import ec.com.rgt.sair.hbm.SairParametros;

public class ConexionADAM
{
    public static void main(final String[] arg) {
    	updateUsuarios();
    }
    
    public static void updateUsuarios() {
        System.out.println("-----ACTUALIZACION DE USUARIOS OPER-----");
        final DAO dao = new DAO();
       
        final List<String> lis = new ArrayList<String>();
        System.out.println("CONSULTA DE USUARIOS DE OPERACIONES");
        //luisana
        List c = dao.find(" from SairParametros where nombre = 'MIGRACION_SAIR_USUARIOS'");
		String banderaMigracion ="S";
		if(c.size()>0){
			SairParametros claves=(SairParametros) c.get(0);
			banderaMigracion=String.valueOf(claves.getValor());
		}
        
        
        List<SairGerente> usuarios = new ArrayList<>();
        
        usuarios.add(new SairGerente(BigDecimal.valueOf(30000027), "STEVEN ULLON", "SULLON", BigDecimal.valueOf(30001117), BigDecimal.valueOf(05001203), "GERENTE CENTROS DE ATENCION AL CLIENTE", "CEDE?O MARTINEZ", "A", "CHRISTIAN ESTUARDO CEDENO MARTINEZ", BigDecimal.valueOf(05001600), "GUAYAS", "0950395244", null,null,null,"sullon@CLARO.COM.EC","30000028"));
        //usuarios.add(new SairGerente(BigDecimal.valueOf(20001957), "MARIA JOSE", "MVALDIVO", BigDecimal.valueOf(30003087), BigDecimal.valueOf(05001604), "ANALISTA DE TALENTO HUMANO", "VALDIVIESO RODRIGUEZ", "A", "MARIA JOSE VALDIVIESO RODRIGUEZ", BigDecimal.valueOf(05001600), "PICHINCHA", "1717516130", null,null,null,"MVALDIVO@CLARO.COM.EC","20001957"));
        usuarios.add(new SairGerente(BigDecimal.valueOf(30000029), "NESTOR IVAN", "NPARADA", BigDecimal.valueOf(30000044), BigDecimal.valueOf(05001004), "GERENTE DE PROYECTOS Y PROCESOS", "PARADA BETANCOURT", "A", "NESTOR IVAN PARADA BETANCOURT", BigDecimal.valueOf(05002000), "GUAYAS", "0911337285", null,null,null,"NPARADA@CLARO.COM.EC","30000029"));
        //usuarios.add(new SairGerente(BigDecimal.valueOf(30000029), "NESTOR IVAN", "NPARADA", BigDecimal.valueOf(30000044), BigDecimal.valueOf(05001004), "GERENTE DE PROYECTOS Y PROCESOS", "PARADA BETANCOURT", "A", "NESTOR IVAN PARADA BETANCOURT", BigDecimal.valueOf(05002000), "GUAYAS", "0999999999", null,null,null,"NPARADA@CLARO.COM.EC", BigDecimal.valueOf(30000029)));

        SairGerente[] gerentes = usuarios.toArray(new SairGerente[0]);
        //final SairGerente[] gerentes = XmlParse.parseTrama();
        //fin luisana
        

        if (banderaMigracion.equals("S")) {
            System.out.println("MIGRACION DE INFORMACION SF A SAIR");
            System.out.println((gerentes != null) ? "CONSULTA CON RESULTADOS" : "CONSULTA SIN RESULTADOS - TERMINA METODO DE ACT USUARIOS");
            if (gerentes != null) {
                System.out.println("TOMA CADA USUARIO DE LA TRAMA");
                for (int i = 0; i < gerentes.length; ++i) {
                    final SairGerente sf = gerentes[i];
                    System.out.println("CONSULTA SAIR_GERENTE POR CEDULA: " + sf.getCedula().toString());
                    try {
                    
                        final List<SairGerente> l = (List<SairGerente>) dao.find("from SairGerente a where a.cedula= '" + sf.getCedula()+"'");
                        
                        System.out.println("SE PROCEDE A VALIDAR INFORMACION DEL USUARIO EN SAIR CON EL USUARIO EN SF, SE ACTUALIZA INFORMACIÓN DE SER NECESARIO");
                        for (int j = 0; j < l.size(); ++j) {
                            boolean ban = false;
                            SairGerente sair = new SairGerente();
                            sair = l.get(j);
                            
                            if (sair.getCodigosf() == null) {
      
                            	sair.setCodigosf(sf.getCodigosf());
                                dao.saveOrUpdate((Object) sair, (Class) sair.getClass());
                                System.out.println("ACTUALIZO codigo sf alf usuario " + sair.getCedula());
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error during database query: " + e.getMessage());
                    }
                }
            }
        
 
     	 
        } else {

        
        System.out.println((gerentes != null) ? "CONSULTA CON RESULTADOS" : "CONSULTA SIN RESULTADOS - TERMINA METODO DE ACT USUARIOS");
        if (gerentes != null) {
            System.out.println("TOMA CADA USUARIO DE LA TRAMA");
            for (int i = 0; i < gerentes.length; ++i) {
                final SairGerente adam = gerentes[i];
                System.out.println("ID USUARIO A PROCESAR: " + adam.getCodigosf().toString() + " NAME: " + adam.getUsuario());
                lis.add(adam.getCodigosf().toString());
                System.out.println("CONSULTA SAIR_GERENTE POR USUARIO: " + adam.getCodigosf().toString());
                final List<SairGerente> l = (List<SairGerente>)dao.find("from SairGerente a where a.codigosf= " + adam.getCodigosf().toString());
                if (l.isEmpty()) {
                	
                    final List<SairGerente> l2 = (List<SairGerente>)dao.find("from SairGerente a where a.cedula= " + adam.getCedula().toString());
                    if (l2 == null) {
	                    System.out.println("NO EXISTE USUARIO EN SAIR_GERENTE " + adam.getCodigosf().toString());
	                    System.out.println("SE CREA NUEVO USUARIO EN SAIR_GERENTE CON ESTADO 'A'");
	                    adam.setEstado("A");
	                    dao.saveOrUpdate((Object)adam, (Class)adam.getClass());
	                    System.out.println("NUEVO U " + adam.getCodigosf());
                    } 
               }
                
                System.out.println("SE PRODECE A VALIDAR INFORMACION DEL USUARIO EN SAIR CON EL USUARIO EN SF, SE ACTUALIZA INFORMACI\u00d3N DE SER NECESARIO");
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
                                ban = !areasAdam.getCedula().trim().toUpperCase().equals(adam.getCedula().trim().toUpperCase());//consultar a jimmy
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
            final List<SairGerente> lista = (List<SairGerente>)dao.find("from SairGerente g where g.estado='A' order by g.codigosf");
            for (int k = 0; k < lista.size(); ++k) {
                final SairGerente gerent = lista.get(k);
                boolean elimina = true;
                for (String adam2 : lis) {
                    if (gerent.getCodigosf() != null && gerent.getCodigosf().toString().equals(adam2)) {
                        elimina = false;
                        break;
                    } else if (gerent.getCodigosf() == null) {
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
    }
    
    public static void updateDepartamentos() {
        System.out.println("------ACTUALIZACION DE DEPARTAMENTOS------");
        
        final DAO dao = new DAO();
        final List<String> idDepartamentoOperList = new ArrayList<String>();
        System.out.println("CONSULTA DE DEPARTAMENTOS A OPERACIONES");
        //final SairAreasAdam[] departamentosOper = XmlParse.parseTramaDepar();
        List<SairAreasAdam> usuarios = new ArrayList<>();
        
        usuarios.add(new SairAreasAdam(BigDecimal.valueOf(05001601),"TALENTO HUMANO", null,"A",null,null,"05001601"));
        usuarios.add(new SairAreasAdam(BigDecimal.valueOf(05001601),"TALENTO HUMANO", null,"A",null,null,"05001601"));
        usuarios.add(new SairAreasAdam(BigDecimal.valueOf(05001601),"TALENTO HUMANO", null,"A",null,null,"05001601"));
    //    usuarios.add(new SairAreasAdam(BigDecimal.valueOf(05001601),"TALENTO HUMANO", null,'A',null,null,'05001601');
    //    usuarios.add(new SairAreasAdam(BigDecimal.valueOf(05001601),"TALENTO HUMANO", null,'A',null,null,'05001601');

       
        SairAreasAdam[] SF = usuarios.toArray(new SairAreasAdam[0]);

        
        System.out.println((SF != null) ? "CONSULTA CON RESULTADOS" : "CONSULTA SIN RESULTADOS - TERMINA METODO DE ACT DEPARTAMENTOS");
        if (SF != null) {
            System.out.println("TOMA CADA DEPART DE LA TRAMA");
            for (int i = 0; i < SF.length; ++i) {
                final SairAreasAdam departamentosSf = SF[i];
                System.out.println("ID DEPARTAMENTO A PROCESAR: " + departamentosSf.getCodigosf() + " NAME: " + departamentosSf.getDescripcion());
                idDepartamentoOperList.add(departamentosSf.getCodigosf().toString());
                System.out.println("CONSULTA AREA SAIR PARA EL DEPARTAMENTO " + departamentosSf.getCodigosf());
                final List<SairAreasAdam> areaAdamsList = (List<SairAreasAdam>)dao.find("from SairAreasAdam a where trim(a.Codigosf)='" + departamentosSf.getCodigosf().trim() + "'");
                if (areaAdamsList == null || areaAdamsList.isEmpty()) {
                    System.out.println("NO EXISTE AREA PARA EL DEPARTAMENTO " + departamentosSf.getCodigosf());
                    System.out.println("SE CREA NUEVO DEPARTAMENTO EN SAIR_AREAS_ADAMS CON ESTADO 'A'");
                    final List<String> maxAreaAdam = (List<String>)dao.Sqlquery("select max(id_departamento) + 1 from sair_areas_adam");
                    final Long idDepart = Long.valueOf(maxAreaAdam.get(0));
                    departamentosSf.setIdDepartamento(BigDecimal.valueOf(idDepart));
                    departamentosSf.setCuenta("0");
                    departamentosSf.setEstado("A");
                    dao.saveOrUpdate((Object)departamentosSf, (Class)departamentosSf.getClass());
                    System.out.println("NUEVO D " + departamentosSf.getCodigosf().trim());
                }
                System.out.println("SE PRODECE A VALIDAR INFORMACION DEL AREA EN SAIR CON EL DEPARTAMENTO EN OPER, SE ACTUALIZA INFORMACION DE SER NECESARIO");
                if (areaAdamsList != null) {
                    for (int j = 0; j < areaAdamsList.size(); ++j) {
                        boolean ban = false;
                        SairAreasAdam areaAdam = new SairAreasAdam();
                        areaAdam = areaAdamsList.get(j);
                        try {
                            ban = !areaAdam.getDescripcion().trim().toUpperCase().equals(departamentosSf.getDescripcion().trim().toUpperCase());
                            if (!ban) {
                                ban = !areaAdam.getCodigosf().trim().toUpperCase().equals(departamentosSf.getCodigosf().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = !areaAdam.getCuenta().trim().toUpperCase().equals(departamentosSf.getCuenta().trim().toUpperCase());
                            }
                            if (!ban) {
                                ban = areaAdam.getEstado().equals("I");
                            }
                        }
                        catch (Exception e) {
                            ban = true;
                        }
                        if (ban) {
                            areaAdam.setDescripcion(departamentosSf.getDescripcion());
                            areaAdam.setCodigosf(departamentosSf.getCodigosf());
                            areaAdam.setCuenta(departamentosSf.getCuenta());
                            areaAdam.setEstado("A");
                            dao.saveOrUpdate((Object)areaAdam, (Class)areaAdam.getClass());
                            System.out.println("ACTUALIZO DEPTO " + areaAdam.getCodigosf());
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
                    if (areaAdam2.getCodigosf() != null && areaAdam2.getCodigosf().toString().equals(idDepartOper)) {
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