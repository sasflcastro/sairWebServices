package ec.com.rgt.sair.ws;
 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.controller.OperacionesRolesPermisos;
import ec.com.rgt.sair.hbm.RolesPermisos;
 
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_rolespermisos {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
	@WebMethod(operationName = "ListaRolesPermisos")
    public List<RolesPermisos> ListaRolesPermisos(@WebParam(name="usuario")String usuario,
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
    	OperacionesRolesPermisos Obj_Operaciones = new OperacionesRolesPermisos();
    	List<RolesPermisos> ListRolesPermisos = new ArrayList<RolesPermisos>();
    	ListRolesPermisos = Obj_Operaciones.ListaRolesPermisos();
    	aux=false;
    	return ListRolesPermisos;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "findRolesPermisos")
    public List<RolesPermisos> findRolesPermisos(@WebParam(name="hqlRolesPermisos")String hqlRolesPermisos,
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
    	OperacionesRolesPermisos Obj_Operaciones = new OperacionesRolesPermisos();
    	List<RolesPermisos> ListRolesPermisos = new ArrayList<RolesPermisos>();
    	ListRolesPermisos = Obj_Operaciones.findRolesPermisos(hqlRolesPermisos);
    	aux=false;
    	return ListRolesPermisos;
    	}else{
        	return null;
        }
    }
    
	@WebMethod(operationName = "ConsultaRolesPermisos")
    public List<RolesPermisos> ConsultaRolesPermisos(@WebParam(name="IdRol")BigDecimal IdRol, @WebParam(name="IdPermiso")BigDecimal IdPermiso,
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
    	OperacionesRolesPermisos Obj_Operaciones = new OperacionesRolesPermisos();
    	List<RolesPermisos> ListRolesPermisos = new ArrayList<RolesPermisos>();
    	ListRolesPermisos = Obj_Operaciones.ConsultaRolesPermisos(IdRol, IdPermiso);
    	aux=false;
    	return ListRolesPermisos;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaRolesPermisos")
    public List<Mensaje> IngresaRolesPermisos(@WebParam(name="IdRol")BigDecimal IdRol, @WebParam(name="IdPermiso")BigDecimal IdPermiso, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,
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
		OperacionesRolesPermisos Obj_RolesPermisos = new OperacionesRolesPermisos();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_RolesPermisos.IngresaRolesPermisos(IdRol, IdPermiso, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "deleteRolesPermisos")
    public void deleteRolesPermisos(@WebParam(name="IdRol")BigDecimal IdRol, @WebParam(name="IdPermiso")BigDecimal IdPermiso, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,
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
		OperacionesRolesPermisos Obj_RolesPermisos = new OperacionesRolesPermisos();
    	Obj_RolesPermisos.deleteRolesPermisos(IdRol, IdPermiso, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado);
    	aux=false;
    	}
    }
    
}