package ec.com.rgt.sair.ws;
 
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.controller.OperacionesSairObservaciones;
import ec.com.rgt.sair.hbm.SairObsAccionAdm;
import ec.com.rgt.sair.hbm.SairObsComentarioAic;
import ec.com.rgt.sair.hbm.SairObsTipoFalta;
import ec.com.rgt.sair.hbm.SairObservaciones;
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_sair_observaciones {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
	
	 @WebMethod(operationName = "IngresaSairObservaciones")
	    public List<Mensaje> IngresaSairObservaciones( 
	    		@WebParam(name="sairObservaciones")SairObservaciones sairObservaciones,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)  {	
	    	if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
			OperacionesSairObservaciones Obj_Operaciones = new OperacionesSairObservaciones();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	try {
				mensajeList = Obj_Operaciones.IngresaSairObservaciones(sairObservaciones, TipoTransc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	 
	 
	 
	 
	 @WebMethod(operationName = "IngresaSairObsTipoFalta")
	    public List<Mensaje> IngresaSairObsTipoFalta( 
	    		@WebParam(name="sairObsTipoFalta")SairObsTipoFalta sairObsTipoFalta,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)  {	
	    	if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
			OperacionesSairObservaciones Obj_Operaciones = new OperacionesSairObservaciones();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	try {
				mensajeList = Obj_Operaciones.IngresaSairObsTipoFalta(sairObsTipoFalta, TipoTransc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	 
	 @WebMethod(operationName = "IngresaSairObsAccionAdm")
	    public List<Mensaje> IngresaSairObsAccionAdm( 
	    		@WebParam(name="sairObsAccionAdm")SairObsAccionAdm sairObsAccionAdm,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)  {	
	    	if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
			OperacionesSairObservaciones Obj_Operaciones = new OperacionesSairObservaciones();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	try {
				mensajeList = Obj_Operaciones.IngresaSairObsAccionADM(sairObsAccionAdm, TipoTransc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	 
	 
	 @WebMethod(operationName = "IngresaSairObsComentarioAic")
	    public List<Mensaje> IngresaSairObsComentarioAic( 
	    		@WebParam(name="sairObsComentarioAic")SairObsComentarioAic sairObsComentarioAic,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)  {	
	    	if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
			OperacionesSairObservaciones Obj_Operaciones = new OperacionesSairObservaciones();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	try {
				mensajeList = Obj_Operaciones.IngresaSairObsComentarioAic(sairObsComentarioAic, TipoTransc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	 
}