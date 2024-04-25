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

public class ws_aplicaciones {

	/**
	 * Web service operation
	 */

	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();

	@WebMethod(operationName = "ListaAplicaciones")
	public List<Aplicaciones> ListaAplicaciones(@WebParam(name="usuario")String usuario,
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
			OperacionesAplicaciones Obj_Operaciones = new OperacionesAplicaciones();
			List<Aplicaciones> aplicacionesList = new ArrayList<Aplicaciones>();
			aplicacionesList = Obj_Operaciones.ListaAplicaciones();
			aux=false;
			return aplicacionesList;
		}else{
			return null;
		}
	}

	@WebMethod(operationName = "ConsultaAplicacion")
	public List<Aplicaciones> ConsultaAplicacion(@WebParam(name="IdAplicacion")BigDecimal IdAplicacion,
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
			OperacionesAplicaciones Obj_Operaciones = new OperacionesAplicaciones();
			List<Aplicaciones> aplicacionesList = new ArrayList<Aplicaciones>();
			aplicacionesList = Obj_Operaciones.ConsultaAplicacion(IdAplicacion);
			aux=false;
			return aplicacionesList;
		}else{
			return null;
		}
	}

	@WebMethod(operationName = "IngresaAplicacion")
	public List<Mensaje> IngresaAplicacion(@WebParam(name="IdAplicacion")BigDecimal IdAplicacion, 
			@WebParam(name="Descripcion")String Descripcion, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, 
			@WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, 
			@WebParam(name="FechaBaja")Date FechaBaja, @WebParam(name="Estado")String Estado, 
			@WebParam(name="TipoTransc")int TipoTransc, @WebParam(name="usuario")String usuario,
			@WebParam(name="password")String password, @WebParam(name="Autenticacion")String Autenticacion) throws Exception {
		if(Autenticacion!=null&&usuario!=null&&password!=null)
		{
			if(Autenticacion.equals("AD"))
				aux=ws.authenticate(usuario, password);
			if(Autenticacion.equals("FS"))
				aux=ws.authenticateFS(usuario, password);
		}
		if(aux){
			OperacionesAplicaciones Obj_Aplicaciones = new OperacionesAplicaciones();
			List<Mensaje> aplicacionesList = new ArrayList<Mensaje>();
			aplicacionesList = Obj_Aplicaciones.IngresaAplicacion(IdAplicacion, Descripcion, UsuarioIngreso, FechaInicio, UsuarioModificacion, FechaBaja, Estado, TipoTransc);
			aux=false;
			return aplicacionesList;
		}else{
			return null;
		}
	}

	@WebMethod(operationName = "findAplicaciones")
	public List<Aplicaciones> findAplicaciones(@WebParam(name="hqlAplicaciones")String hqlAplicaciones,
			@WebParam(name="usuario")String usuario, @WebParam(name="password")String password, 
			@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
		if(Autenticacion!=null&&usuario!=null&&password!=null)
		{
			if(Autenticacion.equals("AD"))
				aux=ws.authenticate(usuario, password);
			if(Autenticacion.equals("FS"))
				aux=ws.authenticateFS(usuario, password);
		}
		if(aux){
			OperacionesAplicaciones Obj_Operaciones = new OperacionesAplicaciones();
			List<Aplicaciones> ListAplicaciones = new ArrayList<Aplicaciones>();
			ListAplicaciones = Obj_Operaciones.findAplicaciones(hqlAplicaciones);
			aux=false;
			return ListAplicaciones;
		}else{
			return null;
		}
	}

	@WebMethod(operationName = "findCalEventos")
	public List<SairCalEventos> findCalEventos(@WebParam(name="hqlCalEventos")String hqlCalEventos,
			@WebParam(name="usuario")String usuario, @WebParam(name="password")String password, 
			@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
		if(Autenticacion!=null&&usuario!=null&&password!=null)
		{
			if(Autenticacion.equals("AD"))
				aux=ws.authenticate(usuario, password);
			if(Autenticacion.equals("FS"))
				aux=ws.authenticateFS(usuario, password);
		}
		if(aux){
			OperacionesAplicaciones Obj_Operaciones = new OperacionesAplicaciones();
			List<SairCalEventos> ListAplicaciones = new ArrayList<SairCalEventos>();
			ListAplicaciones = Obj_Operaciones.findCalEventos(hqlCalEventos);
			aux=false;
			return ListAplicaciones;
		}else{
			return null;
		}
	}

	@WebMethod(operationName = "saveOrUpdateCalEventos")
	public List<Mensaje> saveOrUpdateCalEventos(
			@WebParam(name="sairCalEventos")SairCalEventos sairCalEventos,
			@WebParam(name="TipoTransc")int TipoTransc, @WebParam(name="usuario")String usuario,
			@WebParam(name="password")String password, @WebParam(name="Autenticacion")String Autenticacion) throws Exception {
		if(Autenticacion!=null&&usuario!=null&&password!=null)
		{
			if(Autenticacion.equals("AD"))
				aux=ws.authenticate(usuario, password);
			if(Autenticacion.equals("FS"))
				aux=ws.authenticateFS(usuario, password);
		}
		if(aux){
			OperacionesAplicaciones Obj_Aplicaciones = new OperacionesAplicaciones();
			List<Mensaje> aplicacionesList = new ArrayList<Mensaje>();
			aplicacionesList = Obj_Aplicaciones.saveOrUpdateCalEventos(sairCalEventos, TipoTransc);
			aux=false;
			return aplicacionesList;
		}else{
			return null;
		}
	}


	@WebMethod(operationName = "findCalTipoEventos")
	public List<SairCalTipoEvento> findCalTipoEventos(@WebParam(name="hqlCalTipoEventos")String hqlCalTipoEventos,
			@WebParam(name="usuario")String usuario, @WebParam(name="password")String password, 
			@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
		if(Autenticacion!=null&&usuario!=null&&password!=null)
		{
			if(Autenticacion.equals("AD"))
				aux=ws.authenticate(usuario, password);
			if(Autenticacion.equals("FS"))
				aux=ws.authenticateFS(usuario, password);
		}
		if(aux){
			OperacionesAplicaciones Obj_Operaciones = new OperacionesAplicaciones();
			List<SairCalTipoEvento> ListAplicaciones = new ArrayList<SairCalTipoEvento>();
			ListAplicaciones = Obj_Operaciones.findCalTipoEventos(hqlCalTipoEventos);
			aux=false;
			return ListAplicaciones;
		}else{
			return null;
		}
	}

	@WebMethod(operationName = "saveUsuarioInvitado")
	public List<Mensaje> saveUsuarioInvitado(
			@WebParam(name="sairRecoUsuarioInvitado")SairRecoUsuarioInvitado sairRecoUsuarioInvitado,
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
			OperacionesAplicaciones Obj_Aplicaciones = new OperacionesAplicaciones();
			List<Mensaje> aplicacionesList = new ArrayList<Mensaje>();
			aplicacionesList = Obj_Aplicaciones.saveUsuarioInvitado(sairRecoUsuarioInvitado);
			aux=false;
			return aplicacionesList;
		}else{
			return null;
		}
	}

	@WebMethod(operationName = "deleteUsuarioInvitado")
	public List<Mensaje> deleteUsuarioInvitado(
			@WebParam(name="sairRecoUsuarioInvitado")SairRecoUsuarioInvitado sairRecoUsuarioInvitado,
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
			OperacionesAplicaciones Obj_Operaciones = new OperacionesAplicaciones();
			List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
			ListMensaje = Obj_Operaciones.deleteUsuarioInvitado(sairRecoUsuarioInvitado);
			aux=false;
			return ListMensaje;
		}else{
			return null;
		}
	}	



	@WebMethod(operationName = "findSairRecoUsuarioInvitado")
	public List<SairRecoUsuarioInvitado> findSairRecoUsuarioInvitado(
			@WebParam(name="hqlUsuarioInvitado")String hqlUsuarioInvitado,
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
			OperacionesAplicaciones Obj_Operaciones = new OperacionesAplicaciones();
			List<SairRecoUsuarioInvitado> ListAplicaciones = new ArrayList<SairRecoUsuarioInvitado>();
			ListAplicaciones = Obj_Operaciones.findSairRecoUsuarioInvitado(hqlUsuarioInvitado);
			aux=false;
			return ListAplicaciones;
		}else{
			return null;
		}
	}
	
	@WebMethod(operationName = "saveUsuarioMasivo")
	public List<Mensaje> saveUsuarioMasivo(
			@WebParam(name="sairRecoUsuarioMasivo")SairRecoUsuarioMasivo sairRecoUsuarioMasivo,
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
			OperacionesAplicaciones Obj_Aplicaciones = new OperacionesAplicaciones();
			List<Mensaje> aplicacionesList = new ArrayList<Mensaje>();
			aplicacionesList = Obj_Aplicaciones.saveUsuarioMasivo(sairRecoUsuarioMasivo);
			aux=false;
			return aplicacionesList;
		}else{
			return null;
		}
	}

	@WebMethod(operationName = "deleteUsuarioMasivo")
	public List<Mensaje> deleteUsuarioMasivo(
			@WebParam(name="sairRecoUsuarioMasivo")SairRecoUsuarioMasivo sairRecoUsuarioMasivo,
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
			OperacionesAplicaciones Obj_Operaciones = new OperacionesAplicaciones();
			List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
			ListMensaje = Obj_Operaciones.deleteUsuarioMasivo(sairRecoUsuarioMasivo);
			aux=false;
			return ListMensaje;
		}else{
			return null;
		}
	}	

	@WebMethod(operationName = "findSairRecoUsuarioMasivo")
	public List<SairRecoUsuarioMasivo> findSairRecoUsuarioMasivo(
			@WebParam(name="hqlUsuarioMasivo")String hqlUsuarioMasivo,
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
			OperacionesAplicaciones Obj_Operaciones = new OperacionesAplicaciones();
			List<SairRecoUsuarioMasivo> ListAplicaciones = new ArrayList<SairRecoUsuarioMasivo>();
			ListAplicaciones = Obj_Operaciones.findSairRecoUsuarioMasivo(hqlUsuarioMasivo);
			aux=false;
			return ListAplicaciones;
		}else{
			return null;
		}
	}

}