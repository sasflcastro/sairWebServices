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
import ec.com.rgt.sair.controller.OperacionesSairAmx;
import ec.com.rgt.sair.controller.OperacionesSairParRutina;
import ec.com.rgt.sair.hbm.SairAmxDocumento;
import ec.com.rgt.sair.hbm.SairAmxUnidMedMacro;
import ec.com.rgt.sair.hbm.SairAmxUnidadMedida;
import ec.com.rgt.sair.hbm.SairConfiguraRutina;
import ec.com.rgt.sair.hbm.SairDocReservacionCodigo;
import ec.com.rgt.sair.hbm.SairMgConfigTablero;
import ec.com.rgt.sair.hbm.SairMgDetalleProcesos;
import ec.com.rgt.sair.hbm.SairMgRutinas;
import ec.com.rgt.sair.hbm.SairMgTableroProcesos;
import ec.com.rgt.sair.hbm.SairParDeficiencia;
import ec.com.rgt.sair.hbm.SairParDetalleRutina;
import ec.com.rgt.sair.hbm.SairParPeriodicidad;
import ec.com.rgt.sair.hbm.SairParPoliticas;
import ec.com.rgt.sair.hbm.SairParProgramaRutina;
import ec.com.rgt.sair.hbm.SairParRutina;
import ec.com.rgt.sair.hbm.SairPoliticaProcedimiento;
import ec.com.rgt.sair.hbm.SairPoliticaProceso;
import ec.com.rgt.sair.hbm.SairPoliticaSubProceso;
import ec.com.rgt.sair.hbm.SairPoliticasRutinas;
import ec.com.rgt.sair.hbm.SairRutinaProceso;
import ec.com.rgt.sair.hbm.SairTipoPlan;
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_sairparrutina {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
    
    @WebMethod(operationName = "FindSairParRutina")
    public List<SairParRutina> FindSairParRutina(@WebParam(name="Hqlrutina")String Hqlrutina,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)   {
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<SairParRutina> ListSairParRutina = new ArrayList<SairParRutina>();
    	ListSairParRutina = Obj_Operaciones.FindSairParRutina(Hqlrutina);
    	aux=false;
    	return ListSairParRutina;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findConfiguraRutina")
    public List<SairConfiguraRutina> findConfiguraRutina(@WebParam(name="hqlConRut")String hqlConRut,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)   {
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<SairConfiguraRutina> ListSairParRutina = new ArrayList<SairConfiguraRutina>();
    	ListSairParRutina = Obj_Operaciones.findConfiguraRutina(hqlConRut);
    	aux=false;
    	return ListSairParRutina;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "IngresaSairConfiguraRutina")
    public List<Mensaje> IngresaSairConfiguraRutina(@WebParam(name="configuraRutina")SairConfiguraRutina configuraRutina,
    		@WebParam(name="TipoTransc")int TipoTransc,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)   {
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<Mensaje> ListSairParRutina = new ArrayList<Mensaje>();
    	ListSairParRutina = Obj_Operaciones.IngresaSairConfiguraRutina(configuraRutina, TipoTransc);
    	aux=false;
    	return ListSairParRutina;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "DeleteSairConfiguraRutina")
    public List<Mensaje> DeleteSairConfiguraRutina(@WebParam(name="configuraRutina")SairConfiguraRutina configuraRutina,
    		@WebParam(name="TipoTransc")int TipoTransc,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)   {
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<Mensaje> ListSairParRutina = new ArrayList<Mensaje>();
    	ListSairParRutina = Obj_Operaciones.DeleteSairConfiguraRutina(configuraRutina, TipoTransc);
    	aux=false;
    	return ListSairParRutina;
    	}else{
        	return null;
        }
	}
    
    
    @WebMethod(operationName = "FindSairParDeficiencia")
    public List<SairParDeficiencia> FindSairParDeficiencia(@WebParam(name="Hqldefi")String Hqldefi,
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
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<SairParDeficiencia> ListSairParDefi = new ArrayList<SairParDeficiencia>();
    	ListSairParDefi = Obj_Operaciones.FindSairParDeficiencia(Hqldefi);
    	aux=false;
    	return ListSairParDefi;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findSairTipoPlan")
    public List<SairTipoPlan> findSairTipoPlan(@WebParam(name="hqlTipoPlan")String hqlTipoPlan,
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
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<SairTipoPlan> ListSairParDefi = new ArrayList<SairTipoPlan>();
    	ListSairParDefi = Obj_Operaciones.findTipoPlan(hqlTipoPlan);
    	aux=false;
    	return ListSairParDefi;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findSairPoliticaProcedimiento")
    public List<SairPoliticaProcedimiento> findSairPoliticaProcedimiento(@WebParam(name="hqlProcedimiento")String hqlProcedimiento,
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
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<SairPoliticaProcedimiento> ListSairParDefi = new ArrayList<SairPoliticaProcedimiento>();
    	ListSairParDefi = Obj_Operaciones.findProcedimiento(hqlProcedimiento);
    	aux=false;
    	return ListSairParDefi;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findSairPoliticaProceso")
    public List<SairPoliticaProceso> findSairPoliticaProceso(@WebParam(name="hqlProceso")String hqlProceso,
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
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<SairPoliticaProceso> ListSairParDefi = new ArrayList<SairPoliticaProceso>();
    	ListSairParDefi = Obj_Operaciones.findProceso(hqlProceso);
    	aux=false;
    	return ListSairParDefi;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findSairPoliticaSubProceso")
    public List<SairPoliticaSubProceso> findSairPoliticaSubProceso(@WebParam(name="hqlSubProceso")String hqlSubProceso,
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
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<SairPoliticaSubProceso> ListSairParDefi = new ArrayList<SairPoliticaSubProceso>();
    	ListSairParDefi = Obj_Operaciones.findSubProceso(hqlSubProceso);
    	aux=false;
    	return ListSairParDefi;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findProgramaRutina")
    public List<SairParProgramaRutina> findProgramaRutina(@WebParam(name="hqlPrograma")String hqlPrograma,
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
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<SairParProgramaRutina> ListSairParDefi = new ArrayList<SairParProgramaRutina>();
    	ListSairParDefi = Obj_Operaciones.findProgramaRutina(hqlPrograma);
    	aux=false;
    	return ListSairParDefi;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findDetalleRutina")
    public List<SairParDetalleRutina> findDetalleRutina(@WebParam(name="hqlDetalle")String hqlDetalle,
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
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<SairParDetalleRutina> ListSairParDefi = new ArrayList<SairParDetalleRutina>();
    	ListSairParDefi = Obj_Operaciones.findDetalleRutina(hqlDetalle);
    	aux=false;
    	return ListSairParDefi;
    	}else{
        	return null;
        }
	}
    
    
    @WebMethod(operationName = "findParPeriodicidad")
    public List<SairParPeriodicidad> findParPeriodicidad(@WebParam(name="hqlPeriodicidad")String hqlPeriodicidad,
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
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<SairParPeriodicidad> ListSairParDefi = new ArrayList<SairParPeriodicidad>();
    	ListSairParDefi = Obj_Operaciones.findParPeriodicidad(hqlPeriodicidad);
    	aux=false;
    	return ListSairParDefi;
    	}else{
        	return null;
        }
	}
    
    
    @WebMethod(operationName = "findrRutinaProcesos")
    public List<SairRutinaProceso> findrRutinaProcesos(@WebParam(name="hqlRutPro")String hqlRutPro,
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
    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<SairRutinaProceso> ListSairRutinaProceso = new ArrayList<SairRutinaProceso>();
    	ListSairRutinaProceso = Obj_Operaciones.findRutinaProcesos(hqlRutPro);
    	aux=false;
    	return ListSairRutinaProceso;
    	}else{
        	return null;
        }
	}
    
    
	
	@WebMethod(operationName = "IngresaSairParRutina")
    public List<Mensaje> IngresaSairParRutina(
    		@WebParam(name="SairParRutina")SairParRutina  sairParRutina,
    		@WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairParRutina(sairParRutina, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaSairParDeficiencia")
    public List<Mensaje> IngresaSairParDeficiencia(
    		@WebParam(name="idDefi")BigDecimal idDefi,
    		@WebParam(name="deficiencia")String deficiencia, @WebParam(name="estado")String estado, @WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairParDeficiencia(idDefi, deficiencia, estado, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaSairTipoPlan")
    public List<Mensaje> IngresaSairTipoPlan(
    		@WebParam(name="idTipoPlan")BigDecimal idTipoPlan,
    		@WebParam(name="nombreTipoPlan")String nombreTipoPlan, @WebParam(name="estado")String estado, @WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairTipoPlan(idTipoPlan, nombreTipoPlan, estado, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaSairPoliticaProcedimiento")
    public List<Mensaje> IngresaSairPoliticaProcedimiento(
    		@WebParam(name="SairPoliticaProcedimiento")SairPoliticaProcedimiento  sairPoliticaProcedimiento,
    		@WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairPoliticaProcedimiento(sairPoliticaProcedimiento, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaSairParProgramaRutina")
    public List<Mensaje> IngresaSairParProgramaRutina(
    		@WebParam(name="idProgramaRutina")BigDecimal idProgramaRutina,@WebParam(name="anio")BigDecimal anio,@WebParam(name="estado")String estado,@WebParam(name="mes")BigDecimal mes,
    		@WebParam(name="semana1")BigDecimal semana1,@WebParam(name="semana2")BigDecimal semana2,@WebParam(name="semana3")BigDecimal semana3,
    		@WebParam(name="semana4")BigDecimal semana4, @WebParam(name="sairParRutina")SairParRutina sairParRutina,@WebParam(name="idPeriodicidad")BigDecimal idPeriodicidad,@WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairParProgramaRutina(idProgramaRutina, anio, estado, mes, semana1, semana2, semana3, semana4, sairParRutina,idPeriodicidad, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "DeleteSairParProgramaRutina")
    public List<Mensaje> DeleteSairParProgramaRutina(
    		@WebParam(name="idProgramaRutina")BigDecimal idProgramaRutina,@WebParam(name="anio")BigDecimal anio,@WebParam(name="estado")String estado,@WebParam(name="mes")BigDecimal mes,
    		@WebParam(name="semana1")BigDecimal semana1,@WebParam(name="semana2")BigDecimal semana2,@WebParam(name="semana3")BigDecimal semana3,
    		@WebParam(name="semana4")BigDecimal semana4, @WebParam(name="sairParRutina")SairParRutina sairParRutina,@WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.DeleteSairParProgramaRutina(idProgramaRutina, anio, mes, semana1, semana2, semana3, semana4, estado, sairParRutina, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaSairParDetalleRutina")
    public List<Mensaje> IngresaSairParDetalleRutina(
    		@WebParam(name="idDetalleRutina")BigDecimal idDetalleRutina,@WebParam(name="sairParRutina")SairParRutina sairParRutina,
    		@WebParam(name="sairDocReservacionCodigo")SairDocReservacionCodigo sairDocReservacionCodigo,
    		@WebParam(name="idAsignado")String idAsignado,@WebParam(name="idEjecutor")String idEjecutor,
    		@WebParam(name="fechaEjecucion")Date fechaEjecucion,@WebParam(name="afirmaNiega")String afirmaNiega,
    		@WebParam(name="semanaEmitido")BigDecimal semanaEmitido, @WebParam(name="justificado")String justificado,
    		@WebParam(name="estado")String estado,@WebParam(name="comentario")String comentario,
    		@WebParam(name="anio")BigDecimal anio,@WebParam(name="mes")BigDecimal mes,@WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairParDetalleRutina(idDetalleRutina, sairParRutina, sairDocReservacionCodigo, idAsignado, idEjecutor, fechaEjecucion, afirmaNiega, semanaEmitido, justificado, estado, comentario, anio, mes, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "deleteSairParDetalleRutina")
    public List<Mensaje> deleteSairParDetalleRutina(
    		@WebParam(name="detalleRutina")SairParDetalleRutina detalleRutina,@WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.DeleteSairParDetalleRutina(detalleRutina, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	
	 @WebMethod(operationName = "IngresaSairRutinaProceso") 
	    public List<Mensaje> IngresaSairRutinaProceso( 
	    		 @WebParam(name="sairRutinaProceso")SairRutinaProceso sairRutinaProceso,
				 @WebParam(name="TipoTransc")int TipoTransc,
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
	    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.IngresaSairRutinaProceso(sairRutinaProceso, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	 
	 @WebMethod(operationName = "DeleteSairRutinaProceso") 
	    public List<Mensaje> DeleteSairRutinaProceso( 
	    		 @WebParam(name="sairRutinaProceso")SairRutinaProceso sairRutinaProceso,
				 @WebParam(name="TipoTransc")int TipoTransc,
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
	    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.DeleteSairRutinaProceso(sairRutinaProceso, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	 

		OperacionesSairAmx operacion = new OperacionesSairAmx();
	    
	    @WebMethod(operationName = "FindSairAmxUnidadMedida")
	    public List<SairAmxUnidadMedida> FindSairAmxUnidadMedida(@WebParam(name="HqlSairAmxUnidadMedida")String HqlSairAmxUnidadMedida,
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
	    	List<SairAmxUnidadMedida> ListSairAmxUnidadMedida = new ArrayList<SairAmxUnidadMedida>();
	    	ListSairAmxUnidadMedida = operacion.FindSairAmxUnidadMedida(HqlSairAmxUnidadMedida);
	    	aux=false;
	    	return ListSairAmxUnidadMedida;
	    	}else{
	        	return null;
	        }
		}
	    
	    @WebMethod(operationName = "FindSairAmxUnidMedMacro")
	    public List<SairAmxUnidMedMacro> FindSairAmxUnidMedMacro(@WebParam(name="HqlSairAmxUnidMedMacro")String HqlSairAmxUnidMedMacro,
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
	    	List<SairAmxUnidMedMacro> ListSairAmxUnidMedMacro = new ArrayList<SairAmxUnidMedMacro>();
	    	ListSairAmxUnidMedMacro = operacion.FindSairAmxUnidMedMacro(HqlSairAmxUnidMedMacro);
	    	aux=false;
	    	return ListSairAmxUnidMedMacro;
	    	}else{
	        	return null;
	        }
		}
	    
	    @WebMethod(operationName = "FindSairAmxDocumento")
	    public List<SairAmxDocumento> FindSairAmxDocumento(@WebParam(name="HqlSairAmxDocumento")String HqlSairAmxDocumento,
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
	    	List<SairAmxDocumento> ListSairAmxDocumento = new ArrayList<SairAmxDocumento>();
	    	ListSairAmxDocumento = operacion.FindSairAmxDocumento(HqlSairAmxDocumento);
	    	aux=false;
	    	return ListSairAmxDocumento;
	    	}else{
	        	return null;
	        }
		}
	    @WebMethod(operationName = "SaveOrUpdateSairAmxUnidadMedida") 
	    public List<Mensaje> SaveOrUpdateSairAmxUnidadMedida( 
	    		 @WebParam(name="sairAmxUnidadMedida")SairAmxUnidadMedida sairAmxUnidadMedida,
				 @WebParam(name="TipoTransc")int TipoTransc,
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
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = operacion.SaveOrUpdateSairAmxUnidadMedida(sairAmxUnidadMedida, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	    @WebMethod(operationName = "SaveOrUpdateSairAmxDocumento") 
	    public List<Mensaje> SaveOrUpdateSairAmxDocumento( 
	    		 @WebParam(name="sairAmxDocumento")SairAmxDocumento sairAmxDocumento,
				 @WebParam(name="TipoTransc")int TipoTransc,
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
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = operacion.SaveOrUpdateSairAmxDocumento(sairAmxDocumento, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	    
	    @WebMethod(operationName = "IngresaSairMgRutinas")
		public List<Mensaje> IngresaSairMgRutinas(@WebParam(name="mgRutina")SairMgRutinas mgRutina,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)   {
	    	if(Autenticacion!=null&&usuario!=null&&password!=null){
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
		    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<Mensaje> ListSairMgRutinas = new ArrayList<Mensaje>();
		    	ListSairMgRutinas = Obj_Operaciones.IngresaSairMgRutina(mgRutina, TipoTransc);
		    	aux=false;
		    	return ListSairMgRutinas;
	    	}else{
	        	return null;
	        }
	    }		
			
		@WebMethod(operationName = "FindSairMgRutinas")
		public List<SairMgRutinas> FindSairMgRutinas(@WebParam(name="HqlMgrutina")String HqlMgrutina,
				 @WebParam(name="usuario")String usuario,
				 @WebParam(name="password")String password,
				 @WebParam(name="Autenticacion")String Autenticacion)  {
		
			 if(Autenticacion!=null&&usuario!=null&&password!=null){
				 if(Autenticacion.equals("AD"))
					 aux=ws.authenticate(usuario, password);
				 if(Autenticacion.equals("FS"))
					 aux=ws.authenticateFS(usuario, password);
			 }
			 if(aux){
				OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<SairMgRutinas> ListSairMgRutinas = new ArrayList<SairMgRutinas>();
		    	ListSairMgRutinas = Obj_Operaciones.FindSairMgRutina(HqlMgrutina);
		    	aux=false;
		    	return ListSairMgRutinas;
		    }else{
		       	return null;
		    }
		}
		
		@WebMethod(operationName = "DeleteSairMgRutinas")
	    public List<Mensaje> DeleteSairMgRutinas(@WebParam(name="mgRutinas")SairMgRutinas mgRutinas,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)   {
	    	if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
		    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<Mensaje> ListSairMgRutinas = new ArrayList<Mensaje>();
		    	ListSairMgRutinas = Obj_Operaciones.DeleteSairMgRutinas(mgRutinas, TipoTransc);
		    	aux=false;
		    	return ListSairMgRutinas;
	    	}else{
	        	return null;
	        }
		}
		
		@WebMethod(operationName = "IngresaSairMgTableroProcesos")
		public List<Mensaje> IngresaSairMgTableroProcesos(@WebParam(name="mgTabProceso")SairMgTableroProcesos mgTabProceso,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)   {
	    	if(Autenticacion!=null&&usuario!=null&&password!=null){
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
		    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<Mensaje> ListSairMgTabProceso = new ArrayList<Mensaje>();
		    	ListSairMgTabProceso = Obj_Operaciones.IngresaSairMgTableroProceso(mgTabProceso, TipoTransc);
		    	aux=false;
		    	return ListSairMgTabProceso;
	    	}else{
	        	return null;
	        }
	    }		
			
		@WebMethod(operationName = "FindSairMgTableroProcesos")
		public List<SairMgTableroProcesos> FindSairMgTableroProcesos(@WebParam(name="HqlMgTabProceso")String HqlMgTabProceso,
				 @WebParam(name="usuario")String usuario,
				 @WebParam(name="password")String password,
				 @WebParam(name="Autenticacion")String Autenticacion)  {
		
			 if(Autenticacion!=null&&usuario!=null&&password!=null){
				 if(Autenticacion.equals("AD"))
					 aux=ws.authenticate(usuario, password);
				 if(Autenticacion.equals("FS"))
					 aux=ws.authenticateFS(usuario, password);
			 }
			 if(aux){
				OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<SairMgTableroProcesos> ListSairMgTabProceso = new ArrayList<SairMgTableroProcesos>();
		    	ListSairMgTabProceso = Obj_Operaciones.FindSairMgTableroProceso(HqlMgTabProceso);
		    	aux=false;
		    	return ListSairMgTabProceso;
		    }else{
		       	return null;
		    }
		}
		
		@WebMethod(operationName = "IngresaSairMgDetalleProcesos")
		public List<Mensaje> IngresaSairMgDetalleProcesos(@WebParam(name="mgDetalleProceso")SairMgDetalleProcesos mgDetalleProceso,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)   {
	    	if(Autenticacion!=null&&usuario!=null&&password!=null){
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
		    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<Mensaje> ListSairMgDetProceso = new ArrayList<Mensaje>();
		    	ListSairMgDetProceso = Obj_Operaciones.IngresaSairMgDetalleProceso(mgDetalleProceso, TipoTransc);
		    	aux=false;
		    	return ListSairMgDetProceso;
	    	}else{
	        	return null;
	        }
	    }		
			
		@WebMethod(operationName = "FindSairMgDetalleProcesos")
		public List<SairMgDetalleProcesos> FindSairMgDetalleProcesos(@WebParam(name="HqlMgDetaProceso")String HqlMgDetaProceso,
				 @WebParam(name="usuario")String usuario,
				 @WebParam(name="password")String password,
				 @WebParam(name="Autenticacion")String Autenticacion)  {
		
			 if(Autenticacion!=null&&usuario!=null&&password!=null){
				 if(Autenticacion.equals("AD"))
					 aux=ws.authenticate(usuario, password);
				 if(Autenticacion.equals("FS"))
					 aux=ws.authenticateFS(usuario, password);
			 }
			 if(aux){
				OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<SairMgDetalleProcesos> ListSairMgDetProceso = new ArrayList<SairMgDetalleProcesos>();
		    	ListSairMgDetProceso = Obj_Operaciones.FindSairMgDetalleProceso(HqlMgDetaProceso);
		    	aux=false;
		    	return ListSairMgDetProceso;
		    }else{
		       	return null;
		    }
		}
		
		@WebMethod(operationName = "DeleteSairMgDetalleProcesos")
	    public List<Mensaje> DeleteSairMgDetalleProcesos(@WebParam(name="mgRutinas")SairMgDetalleProcesos mgDetaProceso,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)   {
	    	if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
		    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<Mensaje> ListSairMgDetaProceso = new ArrayList<Mensaje>();
		    	ListSairMgDetaProceso = Obj_Operaciones.DeleteSairMgDetalleProceso(mgDetaProceso, TipoTransc);
		    	aux=false;
		    	return ListSairMgDetaProceso;
	    	}else{
	        	return null;
	        }
		}
		
		@WebMethod(operationName = "IngresaSairMgConfigTablero")
		public List<Mensaje> IngresaSairMgConfigTablero(@WebParam(name="mgConfigTablero")SairMgConfigTablero mgConfigTablero,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)   {
	    	if(Autenticacion!=null&&usuario!=null&&password!=null){
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
		    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<Mensaje> ListSairMgConfigTab = new ArrayList<Mensaje>();
		    	ListSairMgConfigTab = Obj_Operaciones.IngresaSairMgConfigTablero(mgConfigTablero, TipoTransc);
		    	aux=false;
		    	return ListSairMgConfigTab;
	    	}else{
	        	return null;
	        }
	    }		
			
		@WebMethod(operationName = "FindSairMgConfigTablero")
		public List<SairMgConfigTablero> FindSairMgConfigTablero(@WebParam(name="HqlMgConfigTablero")String HqlMgConfigTablero,
				 @WebParam(name="usuario")String usuario,
				 @WebParam(name="password")String password,
				 @WebParam(name="Autenticacion")String Autenticacion)  {
		
			 if(Autenticacion!=null&&usuario!=null&&password!=null){
				 if(Autenticacion.equals("AD"))
					 aux=ws.authenticate(usuario, password);
				 if(Autenticacion.equals("FS"))
					 aux=ws.authenticateFS(usuario, password);
			 }
			 if(aux){
				OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<SairMgConfigTablero> ListSairMgConfigTablero = new ArrayList<SairMgConfigTablero>();
		    	ListSairMgConfigTablero = Obj_Operaciones.FindSairMgConfigTablero(HqlMgConfigTablero);
		    	aux=false;
		    	return ListSairMgConfigTablero;
		    }else{
		       	return null;
		    }
		}
		
		@WebMethod(operationName = "DeleteSairMgConfigTablero")
	    public List<Mensaje> DeleteSairMgConfigTablero(@WebParam(name="mgConfigTab")SairMgConfigTablero mgConfigTab,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)   {
	    	if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
		    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<Mensaje> ListSairMgConfigTablero = new ArrayList<Mensaje>();
		    	ListSairMgConfigTablero = Obj_Operaciones.DeleteSairMgConfigTablero(mgConfigTab, TipoTransc);
		    	aux=false;
		    	return ListSairMgConfigTablero;
	    	}else{
	        	return null;
	        }
		}
		
		@WebMethod(operationName = "IngresaSairParPoliticas")
		public List<Mensaje> IngresaSairParPoliticas(@WebParam(name="sairParPoliticas")SairParPoliticas sairParPoliticas,
	    		@WebParam(name="TipoTransc")int TipoTransc,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion)   {
	    	if(Autenticacion!=null&&usuario!=null&&password!=null){
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	if(aux){
		    	OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
		    	mensajeList = Obj_Operaciones.IngresaSairParPoliticas(sairParPoliticas, TipoTransc);
		    	aux=false;
		    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }		
			
		@WebMethod(operationName = "findSairParPoliticas")
		public List<SairParPoliticas> findSairParPoliticas(@WebParam(name="hqlParPltc")String hqlParPltc,
				 @WebParam(name="usuario")String usuario,
				 @WebParam(name="password")String password,
				 @WebParam(name="Autenticacion")String Autenticacion)  {
			OperacionesSairParRutina Obj_Operaciones = new OperacionesSairParRutina();
		    List<SairParPoliticas> listSairParPoliticas = new ArrayList<SairParPoliticas>();
		    listSairParPoliticas = Obj_Operaciones.findSairParPoliticas(hqlParPltc);
		    return listSairParPoliticas;
		}
		
		OperacionesSairParRutina opr = new OperacionesSairParRutina();
	    
	    @WebMethod(operationName = "FindSairPoliticasRutinas")
	    public List<SairPoliticasRutinas> FindSairPoliticasRutinas(@WebParam(name="HqlSairPoliticasRutinas")String HqlSairPoliticasRutinas,
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
	    	List<SairPoliticasRutinas> ListSairPoliticasRutinas = new ArrayList<SairPoliticasRutinas>();
	    	ListSairPoliticasRutinas = opr.FindSairPoliticasRutinas(HqlSairPoliticasRutinas);
	    	aux=false;
	    	return ListSairPoliticasRutinas;
	    	}else{
	        	return null;
	        }
		}
	    
	    @WebMethod(operationName = "SaveOrUpdateSairPoliticasRutinas") 
	    public List<Mensaje> SaveOrUpdateSairPoliticasRutinas( 
	    		 @WebParam(name="sairPoliticasRutinas")SairPoliticasRutinas sairPoliticasRutinas,
				 @WebParam(name="TipoTransc")int TipoTransc,
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
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = opr.SaveOrUpdateSairPoliticasRutinas(sairPoliticasRutinas, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	
}