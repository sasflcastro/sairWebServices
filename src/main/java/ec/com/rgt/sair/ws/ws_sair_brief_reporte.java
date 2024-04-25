package ec.com.rgt.sair.ws;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.controller.OperacionesObs;
import ec.com.rgt.sair.controller.OperacionesSairObservaciones;
import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.UtilsDAO;
import ec.com.rgt.sair.hbm.SairObsAccionAdm;
import ec.com.rgt.sair.hbm.SairObsComentarioAic;
import ec.com.rgt.sair.hbm.SairObsLocalidad;
import ec.com.rgt.sair.hbm.SairObsTipoFalta;
import ec.com.rgt.sair.hbm.SairObsTipoJustificacion;
import ec.com.rgt.sair.hbm.SairObservaciones;
 
/**
 * @author MarioMurillo
 * Agarrate bien porque este codigo lo realize con las ganas del diablo, es algo(totalmente) brusco el codigo asi que
 * aqui lograras formar, caracter y paciencia.
 */
@WebService()

public class ws_sair_brief_reporte {
	OperacionesObs forum= new OperacionesObs();
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
		
		@WebMethod(operationName = "findLocalidad")
		public List<SairObsLocalidad> findLocalidad(@WebParam(name="hql")String hql){
			return forum.findLocalidad(hql);
		}
		
		@WebMethod(operationName = "findTipoJustificacion")
		public List<SairObsTipoJustificacion> findTipoJustificacion(@WebParam(name="hql")String hql){
			return forum.findTipoJustificacion(hql);
		}
		
		
		
		@WebMethod(operationName = "findObservaciones")
	    public List<SairObservaciones> findObservaciones(@WebParam(name="hqlObservaciones")String hqlObservaciones,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion) {
    		UtilsDAO dao=new UtilsDAO();

    		dao.savelog("DAO", "DAO", "find2", "QueryException "+"SEGUNDO WS ", 49, ""+"SEGUNDO WS ", "SEGURIDAD", 3);
	    	if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
			OperacionesSairObservaciones ObjSairObservaciones = new OperacionesSairObservaciones();
	    	List<SairObservaciones> ListSairObs = new ArrayList<SairObservaciones>();
	    	try {

	    		dao.savelog("DAO", "DAO", "find2", "QueryException "+hqlObservaciones, 49," ttt "+hqlObservaciones, "SEGURIDAD", 3);
	    		ListSairObs = ObjSairObservaciones.FindSairObservaciones(hqlObservaciones);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
	    	aux=false;
	    	return ListSairObs;
	    	}else{
	        	return null;
	        }
		}
		
		 private static void close(ResultSet rs, Statement s, Connection c) {
		        try { if (rs != null) rs.close(); } catch (Exception e) {}
		        try { if (s != null) s.close(); } catch (Exception e) {}
		        try { if (c != null) c.close(); } catch (Exception e) {}
		    }
		 

		
		
		
	}
