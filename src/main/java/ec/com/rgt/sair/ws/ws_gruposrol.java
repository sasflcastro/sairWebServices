
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
import ec.com.rgt.sair.controller.OperacionesGruposRoles;
import ec.com.rgt.sair.hbm.GruposRoles;
 
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_gruposrol {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
    @WebMethod(operationName = "ListaGruposRoles")
    public List<GruposRoles> ListaGruposRoles(@WebParam(name="usuario")String usuario,
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
    	OperacionesGruposRoles Obj_Operaciones = new OperacionesGruposRoles();
    	List<GruposRoles> ListGruposRoles = new ArrayList<GruposRoles>();
    	ListGruposRoles = Obj_Operaciones.ListaGruposRoles();
    	aux=false;
    	return ListGruposRoles;
    	}else{
        	return null;
        }
    }
    
	@WebMethod(operationName = "ConsultaGrupoRoles")
    public List<GruposRoles> ConsultaGrupoRoles(@WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="IdRol")BigDecimal IdRol,
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
    	OperacionesGruposRoles Obj_Operaciones = new OperacionesGruposRoles();
    	List<GruposRoles> ListGruposRoles = new ArrayList<GruposRoles>();
    	ListGruposRoles = Obj_Operaciones.ConsultaGruposRoles(IdGrupo, IdRol);
    	aux=false;
    	return ListGruposRoles;
    	}else{
        	return null;
        }
    }
    

   	@WebMethod(operationName = "ConsultaGrupoRoleshql")
       public List<GruposRoles> ConsultaGrupoRoleshql(@WebParam(name="hqlGruposRoles")String hqlGruposRoles,
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
    	OperacionesGruposRoles Obj_Operaciones = new OperacionesGruposRoles();
       	List<GruposRoles> ListGruposRoles = new ArrayList<GruposRoles>();
       	ListGruposRoles = Obj_Operaciones.ConsultaGruposRoles(hqlGruposRoles);
       	aux=false;
           return ListGruposRoles;
    	}else{
        	return null;
        }
       }
    

	@WebMethod(operationName = "ConsultaGrupoRoles1")
    public List<GruposRoles> ConsultaGrupoRoles1(@WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="IdRol")BigDecimal IdRol,
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
    	OperacionesGruposRoles Obj_Operaciones = new OperacionesGruposRoles();
    	List<GruposRoles> ListGruposRoles = new ArrayList<GruposRoles>();
    	ListGruposRoles = Obj_Operaciones.ConsultaGruposRoles1(IdGrupo, IdRol);
    	aux=false;
    	return ListGruposRoles;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaGrupoRoles")
    public List<Mensaje> IngresaGrupoRoles(@WebParam(name="IdRol")BigDecimal IdRol, @WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,
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
		OperacionesGruposRoles Obj_Operaciones = new OperacionesGruposRoles();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaGruposRoles(IdGrupo, IdRol, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "EliminaGrupoRoles")
    public List<Mensaje> EliminaGrupoRoles(@WebParam(name="IdRol")BigDecimal IdRol, @WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,
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
		OperacionesGruposRoles Obj_Operaciones = new OperacionesGruposRoles();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.EliminaGruposRoles(IdGrupo, IdRol, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
}
