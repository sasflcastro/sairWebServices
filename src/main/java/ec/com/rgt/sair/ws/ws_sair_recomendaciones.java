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
import ec.com.rgt.sair.controller.OperacionesSairRecomendaciones;
import ec.com.rgt.sair.hbm.RecomendacionHistorica;
import ec.com.rgt.sair.hbm.SairArea;
import ec.com.rgt.sair.hbm.SairAreasAdam;
import ec.com.rgt.sair.hbm.SairDocConclusionDocumento;
import ec.com.rgt.sair.hbm.SairDocReservacionCodigo;
import ec.com.rgt.sair.hbm.SairEstadoComplementario;
import ec.com.rgt.sair.hbm.SairEstadoReco;
import ec.com.rgt.sair.hbm.SairEstadosPrincipal;
import ec.com.rgt.sair.hbm.SairRecAreas;
import ec.com.rgt.sair.hbm.SairRecConclusionReco;
import ec.com.rgt.sair.hbm.SairRecDependencia;
import ec.com.rgt.sair.hbm.SairRecDiscusion;
import ec.com.rgt.sair.hbm.SairRecRecomendacion;

 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_sair_recomendaciones {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
    
    @WebMethod(operationName = "findRecomendacion")
    public List<SairRecRecomendacion> findRecomendacion(@WebParam(name="hqlRecomen")String hqlRecomen,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
	    	OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
	    	List<SairRecRecomendacion> listSairFormato = new ArrayList<SairRecRecomendacion>();
	    	listSairFormato = Obj_Operaciones.FindSairRecomendaciones(hqlRecomen);
	        return listSairFormato;
	}
    
    @WebMethod(operationName = "findSairRecDiscusion")
    public List<SairRecDiscusion> findSairRecDiscusion(@WebParam(name="hqlRecDiscusion")String hqlRecDiscusion,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
    	OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<SairRecDiscusion> listSairRecConclusiones = new ArrayList<SairRecDiscusion>();
    	listSairRecConclusiones = Obj_Operaciones.findSairRecDiscusion(hqlRecDiscusion);
    	return listSairRecConclusiones;
	}
    
    @WebMethod(operationName = "findRecDependencia")
    public List<SairRecDependencia> findRecDependencia(@WebParam(name="hqlDependencia")String hqlDependencia,
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
    	OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<SairRecDependencia> listSairRecDependencia = new ArrayList<SairRecDependencia>();
    	listSairRecDependencia = Obj_Operaciones.FindSairRecDependencia(hqlDependencia);
    	aux=false;
    	return listSairRecDependencia;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findRecomendacionHistorica")
    public List<RecomendacionHistorica> findRecomendacionHistorica(@WebParam(name="hqlRecoHis")String hqlRecoHis,
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
    	OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<RecomendacionHistorica> listRecomendacionHis = new ArrayList<RecomendacionHistorica>();
    	listRecomendacionHis = Obj_Operaciones.findRecomendacionHistoricas(hqlRecoHis);
    	aux=false;
    	return listRecomendacionHis;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findRecConclusionesRec")
    public List<SairRecConclusionReco> findConclusionesRecomends(@WebParam(name="hqlRecoConcl")String hqlRecoConcl,
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
    	OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<SairRecConclusionReco> listRecConclusionesRec = new ArrayList<SairRecConclusionReco>();
    	listRecConclusionesRec = Obj_Operaciones.findConclusionesRecomends(hqlRecoConcl);
    	aux=false;
    	return listRecConclusionesRec;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "IngresaSairRecomendacion")
    public List<Mensaje> IngresaSairRecomendacion( 
    			
    		
    		@WebParam(name="sairRecRecomendacion")SairRecRecomendacion sairRecRecomendacion,
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
    	System.out.println(sairRecRecomendacion.getRevisionpolitica()+" bd");
    	if(aux){
		OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairRecomendaciones(sairRecRecomendacion, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "IngresaSairRecDependencia")
    public List<Mensaje> IngresaSairRecDependencia( 
    			
    		@WebParam(name="idSecuencial")BigDecimal idSecuencial,
    		@WebParam(name="sairRecRecomendacionByIdRecomendacion")SairRecRecomendacion sairRecRecomendacionByIdRecomendacion,
    		@WebParam(name="sairEstadosPrincipal")SairEstadosPrincipal sairEstadosPrincipal,
    		@WebParam(name="sairRecRecomendacionByIdRecoDependiente")SairRecRecomendacion sairRecRecomendacionByIdRecoDependiente,
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
		OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairRecDependencia(idSecuencial, sairRecRecomendacionByIdRecomendacion, sairEstadosPrincipal, sairRecRecomendacionByIdRecoDependiente, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "deleteSairRecDependencia")
    public List<Mensaje> deleteSairRecDependencia( 
    			
    		@WebParam(name="idSecuencial")BigDecimal idSecuencial,
    		@WebParam(name="sairRecRecomendacionByIdRecomendacion")SairRecRecomendacion sairRecRecomendacionByIdRecomendacion,
    		@WebParam(name="sairEstadosPrincipal")SairEstadosPrincipal sairEstadosPrincipal,
    		@WebParam(name="sairRecRecomendacionByIdRecoDependiente")SairRecRecomendacion sairRecRecomendacionByIdRecoDependiente,
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
		OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.deleteSairRecDependencia(idSecuencial, sairRecRecomendacionByIdRecomendacion, sairEstadosPrincipal, sairRecRecomendacionByIdRecoDependiente, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "deleteSairRecomendacion")
    public List<Mensaje> deleteSairRecomendacion( 
    			
    		@WebParam(name="idRecomendacion")BigDecimal idRecomendacion,
    		@WebParam(name="sairDocReservacionCodigo")SairDocReservacionCodigo sairDocReservacionCodigo,
    		@WebParam(name="sairArea")SairArea sairArea, 
    		@WebParam(name="sairAreasAdam")SairAreasAdam sairAreasAdam, 
    		@WebParam(name="sairEstadoComplementario")SairEstadoComplementario sairEstadoComplementario, 
    		@WebParam(name="personaEncargada")String personaEncargada, 
    		@WebParam(name="gerenteEncargado")String gerenteEncargado,
    		@WebParam(name="descripcion")String descripcion, 
    		@WebParam(name="fechaAtencionTotal")Date fechaAtencionTotal,
    		@WebParam(name="fechaCompromiso")Date fechaCompromiso, 
    		@WebParam(name="fechaRespuesta")Date fechaRespuesta,
    		@WebParam(name="fechaDeBaja")Date fechaDeBaja, 
    		@WebParam(name="dependeProveedor")String dependeProveedor,
    		@WebParam(name="codigo")String codigo, 
    		@WebParam(name="numero")BigDecimal numero,
    		@WebParam(name="comentario")String comentario, 
    		@WebParam(name="fechaIngreso")Date fechaIngreso,
    		@WebParam(name="ano")BigDecimal ano, 
    		@WebParam(name="areaEvaluada")String areaEvaluada,
    		@WebParam(name="estado")String estado,
    		@WebParam(name="fechaRespuestaRevision")Date fechaRespuestaRevision,
    		@WebParam(name="automatica")BigDecimal automatica,
    		@WebParam(name="diasSinRespuesta")BigDecimal diasSinRespuesta,
    		@WebParam(name="fechaDeEmision")Date fechaDeEmision,
    		@WebParam(name="sairEstadoReco")SairEstadoReco sairEstadoReco,
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
		OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.deleteSairRecomendaciones(idRecomendacion, sairDocReservacionCodigo, sairArea,  
    			sairEstadoComplementario, sairAreasAdam, personaEncargada, gerenteEncargado, descripcion, fechaAtencionTotal, fechaCompromiso, 
    			fechaRespuesta, fechaDeBaja, dependeProveedor, codigo, numero, comentario, fechaIngreso, ano, areaEvaluada, fechaDeEmision, 
    			estado, automatica, diasSinRespuesta, fechaRespuestaRevision, sairEstadoReco, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "IngresaSairRecDiscusion") 
    public List<Mensaje> IngresaSairRecDiscusion( 
    		 @WebParam(name="idDiscusion")BigDecimal idDiscusion,
			 @WebParam(name="sairRecRecomendacion")SairRecRecomendacion sairRecRecomendacion,
			 @WebParam(name="idUsuario")String idUsuario, 
			 @WebParam(name="discusion")String discusion,
			 @WebParam(name="estados")String estados, 
			 @WebParam(name="fechaIngreso")Date fechaIngreso,
			 @WebParam(name="url")String url,
			 @WebParam(name="extencion")String extencion,
			 @WebParam(name="leido")String leido,
			 @WebParam(name="idUsuarioDir")String idUsuarioDir,
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
    	OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairRecDiscusion(idDiscusion, sairRecRecomendacion, idUsuario, estados, discusion, fechaIngreso, url, extencion,leido,idUsuarioDir ,TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "IngresaRecomendacionHistorica") 
    public List<Mensaje> IngresaRecomendacionHistorica( 
    		 @WebParam(name="idRecomendacionHistorica")BigDecimal idRecomendacionHistorica,
    		 @WebParam(name="sairDocReservacionCodigo")SairDocReservacionCodigo sairDocReservacionCodigo,
    		 @WebParam(name="sairEstadoComplementario")SairEstadoComplementario sairEstadoComplementario,
    		 @WebParam(name="sairDocConclusionDocumento")SairDocConclusionDocumento sairDocConclusionDocumento,
    		 @WebParam(name="sairArea")SairArea sairArea, 
    		 @WebParam(name="sairAreasAdam")SairAreasAdam sairAreasAdam,
    		 @WebParam(name="idRecomendacion")BigDecimal idRecomendacion, 
    		 @WebParam(name="personaEncargada")String personaEncargada,
			 @WebParam(name="gerenteEncargado")String gerenteEncargado, 
			 @WebParam(name="descripcion")String descripcion, 
			 @WebParam(name="evaluacion")BigDecimal evaluacion,
			 @WebParam(name="fechaAtencionTotal")Date fechaAtencionTotal, 
			 @WebParam(name="fechaCompromiso")Date fechaCompromiso, 
			 @WebParam(name="fechaRespuesta")Date fechaRespuesta,
			 @WebParam(name="fechaDeBaja")Date fechaDeBaja, 
			 @WebParam(name="dependeProveedor")String dependeProveedor, 
			 @WebParam(name="codigo")String codigo,
			 @WebParam(name="numero")BigDecimal numero, 
			 @WebParam(name="fechaIngreso")Date fechaIngreso, 
			 @WebParam(name="ano")BigDecimal ano,
			 @WebParam(name="atendida")String atendida, 
			 @WebParam(name="areaEvaluada")String areaEvaluada, 
			 @WebParam(name="estado")String estado,
			 @WebParam(name="conclusion")String conclusion, 
			 @WebParam(name="comentario")String comentario,  
			 @WebParam(name="fechaActualizacion")Date fechaActualizacion, 
			 @WebParam(name="fechaDeEmision")Date fechaDeEmision,
			 @WebParam(name="errorOperativo")String errorOperativo,
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
    	OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaRecomendacionHistorica(idRecomendacionHistorica, sairDocReservacionCodigo, sairEstadoComplementario, sairDocConclusionDocumento, sairArea, sairAreasAdam, idRecomendacion, personaEncargada, gerenteEncargado, descripcion, evaluacion, fechaAtencionTotal, fechaCompromiso, fechaRespuesta, fechaDeBaja, dependeProveedor, codigo, numero, fechaIngreso, ano, atendida, areaEvaluada, estado, conclusion, comentario, fechaActualizacion,fechaDeEmision,errorOperativo, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
    
    
    @WebMethod(operationName = "IngresaSairRecConclusionReco") 
    public List<Mensaje> IngresaSairRecConclusionReco( 
    		 @WebParam(name="sairRecConclusionReco")SairRecConclusionReco sairRecConclusionReco,
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
    	OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairRecConclusionReco(sairRecConclusionReco, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "deleteSairRecConclusionReco") 
    public List<Mensaje> deleteSairRecConclusionReco( 
			
    		@WebParam(name="sairRecRecomendacionByIdRecoDependiente")SairRecConclusionReco sairRecConclusionReco,
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
		OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.deleteSairRecConclusionReco(sairRecConclusionReco);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "IngresaSairRecAreas")
    public List<Mensaje> IngresaSairRecAreas( 
    			
    		
    		@WebParam(name="sairRecAreas")SairRecAreas sairRecAreas,
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
		OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairRecAreas(sairRecAreas, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "findSairRecAreas")
    public List<SairRecAreas> findSairRecAreas(@WebParam(name="hqlRecAreas")String hqlRecAreas,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
    	OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<SairRecAreas> listSairRecAreas = new ArrayList<SairRecAreas>();
    	listSairRecAreas = Obj_Operaciones.findSairRecAreas(hqlRecAreas);
    	return listSairRecAreas;
	}
    
    @WebMethod(operationName = "deleteSairRecAreas") 
    public List<Mensaje> deleteSairRecAreas( 
			
    		@WebParam(name="sairRecAreas")SairRecAreas sairRecAreas,
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
		OperacionesSairRecomendaciones Obj_Operaciones = new OperacionesSairRecomendaciones();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.deleteSairRecAreas(sairRecAreas);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
}