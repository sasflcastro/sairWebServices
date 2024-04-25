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

public class ws_grupos {
 
    /**
     * Web service operation
     */
	
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
    @WebMethod(operationName = "BuscaGrupos")
    public List<Grupos> BuscaGrupos(@WebParam(name="HqlGrupos")String HqlGrupos,
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
    	OperacionesGrupos Obj_Operaciones = new OperacionesGrupos();
    	List<Grupos> ListGrupos = new ArrayList<Grupos>();
    	ListGrupos = Obj_Operaciones.BuscaGrupos(HqlGrupos);
    	aux=false;
        return ListGrupos;
    	}else{
        	return null;
        }
    }
    
	/*@SuppressWarnings("unchecked")
	@WebMethod(operationName = "ConsultaGrupo")
    public List<Grupos> ConsultaGrupo(@WebParam(name="IdGrupo")BigDecimal IdGrupo) throws Exception {
		OperacionesGrupos Obj_Operaciones = new OperacionesGrupos();
    	List<Grupos> ListGrupos = new ArrayList<Grupos>();
    	ListGrupos = Obj_Operaciones.ConsultaGrupo(IdGrupo);
        return ListGrupos;
    }
	
	@SuppressWarnings("unchecked")
	@WebMethod(operationName = "BuscaGrupo")
    public List<Grupos> BuscaGrupo(@WebParam(name="NombreGrupo")String NombreGrupo, @WebParam(name="Estado")String Estado) throws Exception {
		OperacionesGrupos Obj_Operaciones = new OperacionesGrupos();
    	List<Grupos> ListGrupos = new ArrayList<Grupos>();
    	ListGrupos = Obj_Operaciones.BuscaGrupo(NombreGrupo, Estado);
        return ListGrupos;
    }*/
	
	@WebMethod(operationName = "IngresaGrupo")
    public List<Mensaje> IngresaGrupo(@WebParam(name="IdGrupo")BigDecimal IdGrupo, @WebParam(name="NombreGrupo")String NombreGrupo, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado, @WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesGrupos Obj_Operaciones = new OperacionesGrupos();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaGrupo(IdGrupo, NombreGrupo, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
}