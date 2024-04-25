package ec.com.rgt.sair.ws;
 
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.*;

import ec.com.rgt.sair.controller.*;
import ec.com.rgt.sair.hbm.*;
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_menus {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
    @WebMethod(operationName = "ListaMenues")
    public List<Menues> ListaMenues(@WebParam(name="usuario")String usuario,
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
    	OperacionesMenues Obj_Operaciones = new OperacionesMenues();
    	List<Menues> ListMenues = new ArrayList<Menues>();
    	ListMenues = Obj_Operaciones.ListaMenues();
    	aux=false;
        return ListMenues;
    	}else{
        	return null;
        }
    }
    

	@WebMethod(operationName = "ConsultaMenues")
    public List<Menues> ConsultaMenues(@WebParam(name="IdMenu")BigDecimal IdMenu,
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
		OperacionesMenues Obj_Operaciones = new OperacionesMenues();
    	List<Menues> ListMenues = new ArrayList<Menues>();
    	ListMenues = Obj_Operaciones.ConsultaMenues(IdMenu);
    	aux=false;
        return ListMenues;
    	}else{
        	return null;
        }
    }
	

	@WebMethod(operationName = "findMenues")
    public List<Menues> findMenues(@WebParam(name="hqlMenu")String hqlMenu,
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
		OperacionesMenues Obj_Operaciones = new OperacionesMenues();
    	List<Menues> ListMenues = new ArrayList<Menues>();
    	ListMenues = Obj_Operaciones.findMenues(hqlMenu);
    	aux=false;
        return ListMenues;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaMenues")
    public List<Mensaje> IngresaMenues(@WebParam(name="IdMenu")BigDecimal IdMenu, @WebParam(name="IdMenuPadre")BigDecimal IdMenuPadre, @WebParam(name="Descripcion")String Descripcion, @WebParam(name="RutaAcceso")String RutaAcceso, @WebParam(name="Orden")BigDecimal Orden, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,@WebParam(name="idAplicacion") BigDecimal idAplicacion, @WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesMenues Obj_Operaciones = new OperacionesMenues();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaMenu(IdMenu, IdMenuPadre, Descripcion, RutaAcceso, Orden, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado,idAplicacion, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "deleteMenu")
    public void deleteMenu(@WebParam(name="IdMenu")BigDecimal IdMenu, @WebParam(name="IdMenuPadre")BigDecimal IdMenuPadre, @WebParam(name="Descripcion")String Descripcion, @WebParam(name="RutaAcceso")String RutaAcceso, @WebParam(name="Orden")BigDecimal Orden, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado,
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
		OperacionesMenues Obj_Operaciones = new OperacionesMenues();
    	Obj_Operaciones.deleteMenu(IdMenu, IdMenuPadre, Descripcion, RutaAcceso, Orden, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado);
    	aux=false;
    	}
    }
    
}