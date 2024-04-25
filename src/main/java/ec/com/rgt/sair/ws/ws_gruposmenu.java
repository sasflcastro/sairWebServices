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
import ec.com.rgt.sair.controller.OperacionesGruposMenu;
import ec.com.rgt.sair.hbm.GruposMenu;
 
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_gruposmenu {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
	@WebMethod(operationName = "ListaGruposMenu")
    public List<GruposMenu> ListaGruposMenu(@WebParam(name="usuario")String usuario,
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
    	OperacionesGruposMenu Obj_Operaciones = new OperacionesGruposMenu();
    	List<GruposMenu> ListGruposMenu = new ArrayList<GruposMenu>();
    	ListGruposMenu = Obj_Operaciones.ListaGruposMenu();
    	aux=false;
        return ListGruposMenu;
    	}else{
        	return null;
        }
    }
    

	@WebMethod(operationName = "ConsultaGruposMenu")
    public List<GruposMenu> ConsultaGruposMenu(@WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="IdMenu")BigDecimal IdMenu,
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
		OperacionesGruposMenu Obj_Operaciones = new OperacionesGruposMenu();
    	List<GruposMenu> ListGruposMenu = new ArrayList<GruposMenu>();
    	ListGruposMenu = Obj_Operaciones.ConsultaGruposMenu(IdGrupo, IdMenu);
    	aux=false;
    	return ListGruposMenu;
    	}else{
        	return null;
        }
    }
    
	@WebMethod(operationName = "findGruposMenu")
    public List<GruposMenu> findGruposMenu(@WebParam(name="hqlGruposMenues")String hqlGruposMenues,
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
		OperacionesGruposMenu Obj_Operaciones = new OperacionesGruposMenu();
    	List<GruposMenu> ListGruposMenu = new ArrayList<GruposMenu>();
    	ListGruposMenu = Obj_Operaciones.findGruposMenu(hqlGruposMenues);
    	aux=false;
    	return ListGruposMenu;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaGruposMenu")
    public List<Mensaje> IngresaGruposMenu(@WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="IdMenu")BigDecimal IdMenu, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,
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
		OperacionesGruposMenu Obj_GruposMenu = new OperacionesGruposMenu();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_GruposMenu.IngresaGruposMenu(IdGrupo, IdMenu, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "deleteaGruposMenu")
    public void deleteaGruposMenu(@WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="IdMenu")BigDecimal IdMenu, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,
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
		OperacionesGruposMenu Obj_GruposMenu = new OperacionesGruposMenu();
    	Obj_GruposMenu.deleteaGruposMenu(IdGrupo, IdMenu, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado);
    	aux=false;
    	}
    }
    
}