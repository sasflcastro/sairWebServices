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

public class ws_roles {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
	@WebMethod(operationName = "BuscaRoles")
    public List<Roles> ListaRoles(String HqlRoles) throws Exception {
    	OperacionesRoles Obj_Operaciones = new OperacionesRoles();
    	List<Roles> ListRoles = new ArrayList<Roles>();
    	ListRoles = Obj_Operaciones.BuscaRoles(HqlRoles);
        return ListRoles;
    }
	
	/*@WebMethod(operationName = "ListaRoles")
    public List<Roles> ListaRoles() throws Exception {
    	OperacionesRoles Obj_Operaciones = new OperacionesRoles();
    	List<Roles> ListRoles = new ArrayList<Roles>();
    	ListRoles = Obj_Operaciones.ListaRoles();
        return ListRoles;
    }
    
	@SuppressWarnings("unchecked")
	@WebMethod(operationName = "ConsultaRoles")
    public List<Roles> ConsultaRoles(@WebParam(name="IdRol")BigDecimal IdRol) throws Exception {
		OperacionesRoles Obj_Operaciones = new OperacionesRoles();
    	List<Roles> ListRoles = new ArrayList<Roles>();
    	ListRoles = Obj_Operaciones.ConsultaRoles(IdRol);
        return ListRoles;
    }*/
	
	@WebMethod(operationName = "findRoles")
	public List<Roles> findRoles(@WebParam(name="hqlRol")String hqlRol,
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
		OperacionesRoles Obj_Operaciones = new OperacionesRoles();
    	List<Roles> ListRoles = new ArrayList<Roles>();
    	ListRoles = Obj_Operaciones.findRoles(hqlRol);
    	aux=false;
        return ListRoles;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaRoles")
    public List<Mensaje> IngresaRoles(@WebParam(name="IdRol")BigDecimal IdRol, @WebParam(name="NombreRol")String NombreRol, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado, @WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesRoles Obj_Operaciones = new OperacionesRoles();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaRoles(IdRol, NombreRol, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
}