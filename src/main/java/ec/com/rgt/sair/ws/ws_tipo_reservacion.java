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
import ec.com.rgt.sair.controller.OperacionesSairDocComplementos;
import ec.com.rgt.sair.hbm.SairDocDestinatario;
import ec.com.rgt.sair.hbm.SairDocEscalamiento;
import ec.com.rgt.sair.hbm.SairDocInformes;
import ec.com.rgt.sair.hbm.SairDocPlantilla;
import ec.com.rgt.sair.hbm.SairDocReservacionCodigo;
import ec.com.rgt.sair.hbm.SairDocRiesgoDocumento;
import ec.com.rgt.sair.hbm.SairDocRiesgoInforme;
import ec.com.rgt.sair.hbm.SairDocTipoDocumento;
import ec.com.rgt.sair.hbm.SairDocTipoInforme;
import ec.com.rgt.sair.hbm.SairEstadoComplementario;
import ec.com.rgt.sair.hbm.SairEstadoReco;
import ec.com.rgt.sair.hbm.SairEstadosPrincipal;
import ec.com.rgt.sair.hbm.SairParRutina;
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_tipo_reservacion {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
    
    @WebMethod(operationName = "findReservacion")
    public List<SairDocReservacionCodigo> findReservacion(@WebParam(name="hqlReservacion")String hqlReservacion,
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
		OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<SairDocReservacionCodigo> ListSairFormato = new ArrayList<SairDocReservacionCodigo>();
    	ListSairFormato = Obj_Operaciones.findReservacion(hqlReservacion);
    	aux=false;
        return ListSairFormato;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findTipoDocumento")
    public List<SairDocTipoDocumento> findTipoDocumento(@WebParam(name="hqlTipo")String hqlTipo,
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
		OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<SairDocTipoDocumento> ListSairFormato = new ArrayList<SairDocTipoDocumento>();
    	ListSairFormato = Obj_Operaciones.findTipoDocumento(hqlTipo);
    	aux=false;
    	return ListSairFormato;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findTipoInforme")
    public List<SairDocTipoInforme> findTipoInforme(@WebParam(name="hqlTipoInfo")String hqlTipoInfo,
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
		OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<SairDocTipoInforme> ListSairFormato = new ArrayList<SairDocTipoInforme>();
    	ListSairFormato = Obj_Operaciones.findTipoInforme(hqlTipoInfo);
    	aux=false;
    	return ListSairFormato;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findEstadosP")
    public List<SairEstadosPrincipal> findEstadosP(@WebParam(name="hqlEstadosPr")String hqlEstadosPr,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
		OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<SairEstadosPrincipal> ListSairFormato = new ArrayList<SairEstadosPrincipal>();
    	ListSairFormato = Obj_Operaciones.findEstadosP(hqlEstadosPr);
    	return ListSairFormato;
	}
    
    
    @WebMethod(operationName = "findRiesgoInform")
    public List<SairDocRiesgoInforme> findRiesgoInform(@WebParam(name="hqlRiesgoInform")String hqlRiesgoInform,
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
		OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<SairDocRiesgoInforme> ListSairFormato = new ArrayList<SairDocRiesgoInforme>();
    	ListSairFormato = Obj_Operaciones.findRiesgInfo(hqlRiesgoInform);
    	aux=false;
    	return ListSairFormato;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findDestinatario")
    public List<SairDocDestinatario> findDestinatario(@WebParam(name="hqlDestinatario")String hqlDestinatario,
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
		OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<SairDocDestinatario> ListSairFormato = new ArrayList<SairDocDestinatario>();
    	ListSairFormato = Obj_Operaciones.findDestinatario(hqlDestinatario);
    	aux=false;
    	return ListSairFormato;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findRiesgoDoc")
    public List<SairDocRiesgoDocumento> findRiesgoDoc(@WebParam(name="hqlRiesgoDoc")String hqlRiesgoDoc,
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
		OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<SairDocRiesgoDocumento> ListSairFormato = new ArrayList<SairDocRiesgoDocumento>();
    	ListSairFormato = Obj_Operaciones.findRiesgoDoc(hqlRiesgoDoc);
    	aux=false;
    	return ListSairFormato;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findPlantilla")
    public List<SairDocPlantilla> findPlantilla(@WebParam(name="hqlPlantilla")String hqlPlantilla,
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
		OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<SairDocPlantilla> ListSairFormato = new ArrayList<SairDocPlantilla>();
    	ListSairFormato = Obj_Operaciones.findPlantilla(hqlPlantilla);
    	aux=false;
    	return ListSairFormato;
    	}else{
        	return null;
        }
	}

    
    @WebMethod(operationName = "findSairEstadoComplementario")
    public List<SairEstadoComplementario> findSairEstadoComplementariol(@WebParam(name="hqlSairEstadoComplementario")String hqlSairEstadoComplementario,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion){
		OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<SairEstadoComplementario> ListSairFormato = new ArrayList<SairEstadoComplementario>();
    	ListSairFormato = Obj_Operaciones.findSairEstadoComplementariol(hqlSairEstadoComplementario);
    	return ListSairFormato;
	}
    
    @WebMethod(operationName = "findSairEstadoReco")
    public List<SairEstadoReco> findSairEstadoReco(@WebParam(name="hqlSairEstadoReco")String hqlSairEstadoReco,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion){
		OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<SairEstadoReco> ListSairFormato = new ArrayList<SairEstadoReco>();
    	ListSairFormato = Obj_Operaciones.findSairEstadoReco(hqlSairEstadoReco);
    	return ListSairFormato;
	}
    
    @WebMethod(operationName = "findSairDocEscalamiento")
    public List<SairDocEscalamiento> findSairDocEscalamiento(@WebParam(name="hqlEscalamiento")String hqlEscalamiento,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion){
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
		OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<SairDocEscalamiento> ListSairFormato = new ArrayList<SairDocEscalamiento>();
    	ListSairFormato = Obj_Operaciones.findSairDocEscalamiento(hqlEscalamiento);
    	aux=false;
    	return ListSairFormato;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "IngresaPlantilla")
    public List<Mensaje> IngresaPlantilla(@WebParam(name="idPlantilla")BigDecimal idPlantilla, 
    		@WebParam(name="idPlantillaHijo")BigDecimal idPlantillaHijo, 
    		@WebParam(name="nombre")String nombre, 
    		@WebParam(name="plantilla")String plantilla, 
    		@WebParam(name="fechaIngreso")Date fechaIngreso, 
    		@WebParam(name="usuarioIngreso")String usuarioIngreso, 
    		@WebParam(name="estado")String estado,
    		@WebParam(name="sairParRutina")SairParRutina sairParRutina,
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
    	OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaPlantilla(idPlantilla, idPlantillaHijo, nombre, plantilla, fechaIngreso, usuarioIngreso, estado, sairParRutina, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "IngresaEscalamiento")
    public List<Mensaje> IngresaEscalamiento(@WebParam(name="document")SairDocEscalamiento document,
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
    	OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaEscalamiento(document, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "IngresaReservacionCodigo")
    public List<Mensaje> IngresaReservacionCodigo(
    		@WebParam(name="sairDocReservacionCodigo")SairDocReservacionCodigo sairDocReservacionCodigo, 
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
    	OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaReservacionCodigo(sairDocReservacionCodigo, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "IngresaRiesgoDocumento")
    public List<Mensaje> IngresaRiesgoDocumento(@WebParam(name="idRiesgo")BigDecimal idRiesgo, @WebParam(name="descripcion")String descripcion, 
    		@WebParam(name="fechaIngreso")Date fechaIngreso, @WebParam(name="fechaActualizacion")Date fechaActualizacion, @WebParam(name="usuarioIngreso")String usuarioIngreso,
    		@WebParam(name="usuarioActualizacion")String usuarioActualizacion, @WebParam(name="estado")String estado, @WebParam(name="TipoTransc")int TipoTransc,
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
    	OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaRiesgoDoc(idRiesgo, descripcion, fechaIngreso, fechaActualizacion, usuarioIngreso, usuarioActualizacion, estado, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "deletePlantilla")
    public List<Mensaje> deletePlantilla(@WebParam(name="idPlantilla")BigDecimal idPlantilla, 
    		@WebParam(name="idPlantillaHijo")BigDecimal idPlantillaHijo, 
    		@WebParam(name="nombre")String nombre, 
    		@WebParam(name="plantilla")String plantilla, 
    		@WebParam(name="fechaIngreso")Date fechaIngreso, 
    		@WebParam(name="usuarioIngreso")String usuarioIngreso, 
    		@WebParam(name="estado")String estado,
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
    	OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.deletePlantilla(idPlantilla, idPlantillaHijo, nombre, plantilla, fechaIngreso, usuarioIngreso, estado, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "IngresaSairDocRiesgoInforme")
    public List<Mensaje> IngresaSairDocRiesgoInforme(@WebParam(name="idRiesgoInforme")BigDecimal idRiesgoInforme, @WebParam(name="idEstadoComp")BigDecimal idEstadoComp, 
    		@WebParam(name="sairDocInformes")SairDocInformes sairDocInformes, @WebParam(name="sairDocRiesgoDocumento")SairDocRiesgoDocumento sairDocRiesgoDocumento,
    		@WebParam(name="sairEstadosPrincipal")SairEstadosPrincipal sairEstadosPrincipal, @WebParam(name="TipoTransc")int TipoTransc,
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
    	OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaSairDocRiesgoInforme(idRiesgoInforme, idEstadoComp, sairDocInformes, sairDocRiesgoDocumento, sairEstadosPrincipal, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
    
    @WebMethod(operationName = "IngresaDestinatario")
    public List<Mensaje> IngresaDestinatario(@WebParam(name="idDestinatario")BigDecimal idDestinatario,
    		@WebParam(name="sairDocReservacionCodigo")SairDocReservacionCodigo sairDocReservacionCodigo, 
    		@WebParam(name="emailPara")String emailPara, 
    		@WebParam(name="emailCopia")String emailCopia,
    		@WebParam(name="usuarioEnvio")String usuarioEnvio,
    		@WebParam(name="fechaRegistro")Date fechaRegistro,
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
    	OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaDestinatario(idDestinatario, sairDocReservacionCodigo, emailPara, fechaRegistro, emailCopia, usuarioEnvio, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "ingresaTipoDoc")
    public List<Mensaje> ingresaTipoDoc(@WebParam(name="idDestinatario")SairDocTipoDocumento docTipoDocumento,
    		@WebParam(name="TipoTransc")int tipoTransc)  {
    	OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.ingresaTipoDoc(docTipoDocumento, tipoTransc);
    	return ListMensaje;
    }
    
    @WebMethod(operationName = "ingresaSairPrioridad")
    public String ingresaSairPrioridad(@WebParam(name="priorid")String priorid,@WebParam(name="eOperativo")String eOperativo,@WebParam(name="eTecnologico")String eTecnologico,
    		@WebParam(name="vRecuperar")BigDecimal vRecuperar,@WebParam(name="vDevolver")BigDecimal vDevolver,@WebParam(name="cRecuperar")BigDecimal cRecuperar,@WebParam(name="cDevolver")BigDecimal cDevolver,
    		@WebParam(name="cSinAfectacion")BigDecimal cSinAfectacion,@WebParam(name="usuario")String usuario,@WebParam(name="tipoTransc")int tipoTransc)  {
    	OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
    	return Obj_Operaciones.ingresaSairPrioridad(priorid, vRecuperar, vDevolver, cRecuperar, cDevolver, cSinAfectacion, eOperativo, eTecnologico,usuario, tipoTransc);

    }
    
}