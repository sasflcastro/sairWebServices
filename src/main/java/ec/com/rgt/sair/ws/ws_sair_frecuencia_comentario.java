package ec.com.rgt.sair.ws;

import java.math.BigDecimal;
import java.util.*;

import javax.jws.*;

import ec.com.rgt.sair.controller.*;
import ec.com.rgt.sair.hbm.*;
 
@WebService()

public class ws_sair_frecuencia_comentario {
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
	 @WebMethod(operationName = "findSairFrecuencia")
	    public List<SairFrecuencia> findSairFrecuencia(@WebParam(name="hqlFrecuencia")String hqlFrecuencia,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
		 if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
		 OperacionesSair_FrecuenciaComentario Obj_Operaciones = new OperacionesSair_FrecuenciaComentario();
	    	List<SairFrecuencia> ListSairParDefi = new ArrayList<SairFrecuencia>();
	    	ListSairParDefi = Obj_Operaciones.findFrecuencia(hqlFrecuencia);
	    	aux=false;
	    	return ListSairParDefi;
	    	}else{
	        	return null;
	        }
		}
	    
	    @WebMethod(operationName = "findSairParComentario")
	    public List<SairParComentarioRutina> findSairParComentario(@WebParam(name="hqlComentario")String hqlComentario,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
	    	if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
	    	OperacionesSair_FrecuenciaComentario Obj_Operaciones = new OperacionesSair_FrecuenciaComentario();
	    	List<SairParComentarioRutina> ListSairParDefi = new ArrayList<SairParComentarioRutina>();
	    	ListSairParDefi = Obj_Operaciones.findComentario(hqlComentario);
	    	aux=false;
	    	return ListSairParDefi;
	    	}else{
	        	return null;
	        }
		}
	    
	    @WebMethod(operationName = "IngresaSairFrecuencia")
	    public List<Mensaje> IngresaSairFrecuencia(
	    		@WebParam(name="idFrecuencia")BigDecimal idFrecuencia,
	    		@WebParam(name="nombreFrecuencia")String nombreFrecuencia,@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
	    	if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
	    	OperacionesSair_FrecuenciaComentario Obj_Operaciones = new OperacionesSair_FrecuenciaComentario();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.IngresaFrecuencia(idFrecuencia, nombreFrecuencia, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	    
		@WebMethod(operationName = "IngresaSairParComentarioRutina")
	    public List<Mensaje> IngresaSairParComentarioRutina(
	    		@WebParam(name="idComentario")BigDecimal idComentario,
	    		@WebParam(name="observacion")String observacion, @WebParam(name="estado")String estado, @WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
			if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
			OperacionesSair_FrecuenciaComentario Obj_Operaciones = new OperacionesSair_FrecuenciaComentario();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.IngresaParComenatrio(idComentario, observacion, estado, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	
}
