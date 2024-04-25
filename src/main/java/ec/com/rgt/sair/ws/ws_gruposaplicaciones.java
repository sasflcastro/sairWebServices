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
import ec.com.rgt.sair.controller.OperacionesGruposAplicaciones;
import ec.com.rgt.sair.hbm.GruposAplicaciones;
 
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_gruposaplicaciones {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
    @WebMethod(operationName = "ListaGruposAplicaciones")
    public List<GruposAplicaciones> ListaGruposAplicaciones(@WebParam(name="usuario")String usuario,
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
    	OperacionesGruposAplicaciones Obj_Operaciones = new OperacionesGruposAplicaciones();
    	List<GruposAplicaciones> ListGruposAplicaciones = new ArrayList<GruposAplicaciones>();
    	ListGruposAplicaciones = Obj_Operaciones.ListaGruposAplicaciones();
    	aux=false;
        return ListGruposAplicaciones;
    	}else{
        	return null;
        }
    }
    

	@WebMethod(operationName = "ConsultaGrupoAplicaciones")
    public List<GruposAplicaciones> ConsultaGrupoAplicaciones(@WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="IdAplicacion")BigDecimal IdAplicacion,
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
		OperacionesGruposAplicaciones Obj_Operaciones = new OperacionesGruposAplicaciones();
    	List<GruposAplicaciones> ListGruposAplicaciones = new ArrayList<GruposAplicaciones>();
    	ListGruposAplicaciones = Obj_Operaciones.ConsultaGruposAplicaciones(IdGrupo, IdAplicacion);
    	aux=false;
    	return ListGruposAplicaciones;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaGrupoAplicacion")
    public List<Mensaje> IngresaGrupoAplicacion(@WebParam(name="IdAplicacion")BigDecimal IdAplicacion, @WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,
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
		OperacionesGruposAplicaciones Obj_GrupoAplicaciones = new OperacionesGruposAplicaciones();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_GrupoAplicaciones.IngresaGrupoAplicacion(IdGrupo, IdAplicacion, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "EliminaGrupoAplicacion")
    public List<Mensaje> EliminaGrupoAplicacion(@WebParam(name="IdAplicacion")BigDecimal IdAplicacion, @WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,
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
		OperacionesGruposAplicaciones Obj_GrupoAplicaciones = new OperacionesGruposAplicaciones();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_GrupoAplicaciones.EliminaGrupoAplicacion(IdGrupo, IdAplicacion, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    

	@WebMethod(operationName = "findGrupoAplicacion")
    public List<GruposAplicaciones> findGruposAplicaciones(@WebParam(name="hqlGruposAplicaciones")String hqlGruposAplicaciones,
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
		OperacionesGruposAplicaciones Obj_Operaciones = new OperacionesGruposAplicaciones();
    	List<GruposAplicaciones> ListGruposAplicaciones = new ArrayList<GruposAplicaciones>();
    	ListGruposAplicaciones = Obj_Operaciones.findGruposAplicaciones(hqlGruposAplicaciones);
    	aux=false;
    	return ListGruposAplicaciones;
    	}else{
        	return null;
        }
	}
	
}