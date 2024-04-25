package ec.com.rgt.sair.ws;
 
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.jws.*;

import ec.com.rgt.sair.controller.*;
import ec.com.rgt.sair.hbm.*;
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_usuarios {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
	@WebMethod(operationName = "getCuentas")
	public List<SairDocCuentas> getCuentas(@WebParam(name="hql")String hql){
		OperacionesUsuario Obj_Operaciones = new OperacionesUsuario();
		return Obj_Operaciones.getCuentas(hql);
	}
	
	@WebMethod(operationName = "borrarCuentas")
	public int borrarCuentas(@WebParam(name="hql")String hql){
		OperacionesUsuario Obj_Operaciones = new OperacionesUsuario();
		return Obj_Operaciones.borrarCuentas(hql);
	}
	
	@WebMethod(operationName = "guardarCuenta")
	public int guardarCuenta(@WebParam(name="cuentas")SairDocCuentas cuentas){
		OperacionesUsuario Obj_Operaciones = new OperacionesUsuario();
		return Obj_Operaciones.guardarCuenta(cuentas);
	}
	
    @WebMethod(operationName = "ListaUsuarios")
    public List<Usuarios> ListaUsuarios(@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
    	OperacionesUsuario Obj_Operaciones = new OperacionesUsuario();
    	List<Usuarios> aplicacionesList = new ArrayList<Usuarios>();
    	aplicacionesList = Obj_Operaciones.ListaUsuarios();
    	aux=false;
        return aplicacionesList;
    	}else{
        	return null;
        }
    }
    

	@WebMethod(operationName = "ConsultaUsuario")
    public List<Usuarios> ConsultaUsuario(@WebParam(name="IdUsuario")String IdUsuario,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
		if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
    	OperacionesUsuario Obj_Operaciones = new OperacionesUsuario();
    	List<Usuarios> aplicacionesList = new ArrayList<Usuarios>();
    	aplicacionesList = Obj_Operaciones.ConsultaUsuario(IdUsuario.toUpperCase());
    	aux=false;
    	return aplicacionesList;
    	}else{
        	return null;
        }
    }
	
	
	@WebMethod(operationName = "IngresaUsuario")
	public List<Mensaje> IngresaUsuario(@WebParam(name="IdUsuario")String IdUsuario, @WebParam(name="Clave")String Clave, @WebParam(name="NombresCompletos")String NombresCompletos, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaIngreso")Date FechaIngreso, @WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado, @WebParam(name="Nombre")String Nombre, @WebParam(name="Apellido")String Apellido, @WebParam(name="Email1")String Email1, @WebParam(name="Email2")String Email2, @WebParam(name="firma")String firma, @WebParam(name="Codigo")String Codigo, @WebParam(name="JefeInmediato")String JefeInmediato, @WebParam(name="sairArea")SairArea sairArea, @WebParam(name="Cargo")String Cargo, @WebParam(name="PrimerIngreso")String PrimerIngreso, @WebParam(name="fechaExpiracionClave")Date fechaExpiracionClave, @WebParam(name="numIntentos")BigDecimal numIntentos, @WebParam(name="TipoTransc")int TipoTransc)  {
		
		OperacionesUsuario Obj_Operaciones = new OperacionesUsuario();
    	List<Mensaje> aplicacionesList = new ArrayList<Mensaje>();
    	aplicacionesList = Obj_Operaciones.IngresaUsuario(IdUsuario.toUpperCase(), Clave, NombresCompletos!=null?NombresCompletos.toUpperCase():null, UsuarioIngreso, UsuarioModificacion, FechaIngreso, FechaBaja, Estado, Nombre!=null?Nombre.toUpperCase():null, Apellido!=null?Apellido.toUpperCase():null, Email1, Email2, firma, Codigo, JefeInmediato, sairArea, Cargo, PrimerIngreso, fechaExpiracionClave, numIntentos, TipoTransc);
    	
    	return aplicacionesList;
    	
    }
	

	@WebMethod(operationName = "findUsuarios")
    public List<Usuarios> findUsuarios(@WebParam(name="hqlUsuarios")String hqlUsuarios) throws IllegalBlockSizeException, BadPaddingException, IOException  {
		
		OperacionesUsuario Obj_Operaciones = new OperacionesUsuario();
    	List<Usuarios> ListUsuarios = new ArrayList<Usuarios>();
    	ListUsuarios = Obj_Operaciones.findUsuarios(hqlUsuarios);
    	
    	return ListUsuarios;
    	
	}
	
	/*Carlos Panta
	 * Usuarios AD
	 * */
	@WebMethod(operationName = "findUsuariosAD")
    public List<UsuariosAD> findUsuariosAD(@WebParam(name="hqlUsuariosAD")String hqlUsuariosAD)  {
		
		OperacionesUsuario Obj_Operaciones = new OperacionesUsuario();
    	List<UsuariosAD> ListUsuariosAD = new ArrayList<UsuariosAD>();
    	ListUsuariosAD = Obj_Operaciones.FindUsuarioAD(hqlUsuariosAD);
    	return ListUsuariosAD;
    	
	}
	
}