package ec.com.rgt.sair.ws;
 
import java.math.BigDecimal;
import java.util.*;

import javax.jws.*;

import ec.com.rgt.sair.controller.*;
import ec.com.rgt.sair.hbm.*;
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_permisos {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
    @WebMethod(operationName = "ListaPermisos")
    public List<Permisos> ListaPermisos(@WebParam(name="usuario")String usuario,
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
    	OperacionesPermisos Obj_Operaciones = new OperacionesPermisos();
    	List<Permisos> ListPermisos = new ArrayList<Permisos>();
    	ListPermisos = Obj_Operaciones.ListaPermisos();
    	aux=false;
        return ListPermisos;
    	}else{
        	return null;
        }
    }
    
	@WebMethod(operationName = "ConsultaPermiso")
    public List<Permisos> ConsultaPermiso(@WebParam(name="IdPermiso")BigDecimal IdPermiso,
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
		OperacionesPermisos Obj_Operaciones = new OperacionesPermisos();
    	List<Permisos> ListPermisos = new ArrayList<Permisos>();
    	ListPermisos = Obj_Operaciones.ConsultaPermiso(IdPermiso);
    	aux=false;
    	return ListPermisos;
    	}else{
        	return null;
        }
    }
	
	 @WebMethod(operationName = "findPermisos")
	    public List<Permisos> findPermisos(@WebParam(name="hqlPermiso")String hqlPermiso,
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
	    	OperacionesPermisos Obj_Operaciones = new OperacionesPermisos();
	    	List<Permisos> ListPermisos = new ArrayList<Permisos>();
	    	ListPermisos = Obj_Operaciones.findPermisos(hqlPermiso);
	    	aux=false;
	    	return ListPermisos;
	    	}else{
	        	return null;
	        }
	    }
	
	@WebMethod(operationName = "IngresaPermiso")
    public List<Mensaje> IngresaPermiso(@WebParam(name="IdPermiso")BigDecimal IdPermiso, @WebParam(name="NombrePermiso")String NombrePermiso, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado, @WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesPermisos Obj_Operaciones = new OperacionesPermisos();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaPermisos(IdPermiso, NombrePermiso, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
}