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
import ec.com.rgt.sair.controller.OperacionesGruposUsuarios;
import ec.com.rgt.sair.hbm.GruposUsuarios;
 
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_gruposusuarios {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
	@WebMethod(operationName = "ListaGruposUsuarios")
    public List<GruposUsuarios> ListaGruposUsuarios(@WebParam(name="usuario")String usuario,
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
    	OperacionesGruposUsuarios Obj_Operaciones = new OperacionesGruposUsuarios();
    	List<GruposUsuarios> ListGruposUsuarios = new ArrayList<GruposUsuarios>();
    	ListGruposUsuarios = Obj_Operaciones.ListaGruposUsuarios();
    	aux=false;
    	return ListGruposUsuarios;
    	}else{
        	return null;
        }
    }
    

	@WebMethod(operationName = "ConsultaGruposUsuarios")
    public List<GruposUsuarios> ConsultaGruposUsuarios(@WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="IdUsuario")String IdUsuario,
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
    	OperacionesGruposUsuarios Obj_Operaciones = new OperacionesGruposUsuarios();
    	List<GruposUsuarios> ListGruposUsuarios = new ArrayList<GruposUsuarios>();
    	ListGruposUsuarios = Obj_Operaciones.ConsultaGruposUsuarios(IdGrupo, IdUsuario);
    	aux=false;
    	return ListGruposUsuarios;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaGruposUsuarios")
    public List<Mensaje> IngresaGruposUsuarios(@WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="IdUsuario")String IdUsuario, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,
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
		OperacionesGruposUsuarios Obj_Operaciones = new OperacionesGruposUsuarios();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaGruposUsuarios(IdGrupo, IdUsuario, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "EliminaGruposUsuarios")
    public List<Mensaje> EliminaGruposUsuarios(@WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="IdUsuario")String IdUsuario, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,
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
		OperacionesGruposUsuarios Obj_Operaciones = new OperacionesGruposUsuarios();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.EliminaGruposUsuarios(IdGrupo, IdUsuario, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
	@WebMethod(operationName = "findGruposUsuarios")
    public List<GruposUsuarios> findGruposUsuarios(@WebParam(name="hqlGruposUsuarios")String hqlGruposUsuarios,
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
		OperacionesGruposUsuarios Obj_Operaciones = new OperacionesGruposUsuarios();
    	List<GruposUsuarios> ListGruposUsuarios = new ArrayList<GruposUsuarios>();
    	ListGruposUsuarios = Obj_Operaciones.findGruposUsuarios(hqlGruposUsuarios);
    	aux=false;
    	return ListGruposUsuarios;
    	}else{
        	return null;
        }
	}
}