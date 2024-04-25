package ec.com.rgt.sair.ws;
 
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.controller.OperacionesSairDocumentos;
import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.UtilsDAO;
import ec.com.rgt.sair.hbm.SairDocAjusteCorreccion;
import ec.com.rgt.sair.hbm.SairDocAnexoDocumento;
import ec.com.rgt.sair.hbm.SairDocArnp;
import ec.com.rgt.sair.hbm.SairDocConclusionDocumento;
import ec.com.rgt.sair.hbm.SairDocDiscusionInf;
import ec.com.rgt.sair.hbm.SairDocInformes;
import ec.com.rgt.sair.hbm.SairDocMemorando;
import ec.com.rgt.sair.hbm.SairDocPasos;
import ec.com.rgt.sair.hbm.SairDocPlantillaDocumento;
import ec.com.rgt.sair.hbm.SairDocRequerimientoCorrecc;
import ec.com.rgt.sair.hbm.SairDocReservacionCodigo;
import ec.com.rgt.sair.hbm.SairDocRiesgoDocumento;
import ec.com.rgt.sair.hbm.SairDocTipoEvento;
import ec.com.rgt.sair.hbm.SairDocTipoHallazgo;
import ec.com.rgt.sair.hbm.SairEstadosPrincipal;
import ec.com.rgt.sair.hbm.SairRecConclusionReco;
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_sairdocdocumentos {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	UtilsDAO dao = new UtilsDAO();
    
    @WebMethod(operationName = "FindSairDocInformes")
    public List<SairDocInformes> FindSairDocInformes(@WebParam(name="Hqlinforme")String Hqlinforme,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
    	/*if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){*/
	    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
	    	List<SairDocInformes> ListSairDocInformes = new ArrayList<SairDocInformes>();
	    	ListSairDocInformes = Obj_Operaciones.FindSairDocInformes(Hqlinforme);
	    	aux=false;
	    	return ListSairDocInformes;
    	/*}else{
        	return null;
        }*/
	}
    
    @WebMethod(operationName = "FindSairDocAjusteCorreccion")
    public List<SairDocAjusteCorreccion> FindSairDocAjusteCorreccion(@WebParam(name="hql")String hql,
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
    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<SairDocAjusteCorreccion> ListSairDocInformes = new ArrayList<SairDocAjusteCorreccion>();
    	ListSairDocInformes = Obj_Operaciones.FindSairDocAjusteCorreccion(hql);
    	aux=false;
    	return ListSairDocInformes;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "FindSairDocMemorando")
    public List<SairDocMemorando> FindSairDocMemorando(@WebParam(name="Hqlmemorando")String Hqlmemorando,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
    	/*if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){*/
	    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
	    	List<SairDocMemorando> ListSairDocMemorando = new ArrayList<SairDocMemorando>();
	    	ListSairDocMemorando = Obj_Operaciones.FindSairDocMemorando(Hqlmemorando);
	    	aux=false;
	    	return ListSairDocMemorando;
    	/*}else{
        	return null;
        }*/
	}
    
    @WebMethod(operationName = "FindSairDocArnp")
    public List<SairDocArnp> FindSairDocArnp(@WebParam(name="Hqlarnp")String Hqlarnp,
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
	    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
	    	List<SairDocArnp> ListSairDocArnp = new ArrayList<SairDocArnp>();
	    	ListSairDocArnp = Obj_Operaciones.FindSairDocArnp(Hqlarnp);
	    	aux=false;
	    	return ListSairDocArnp;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "FindSairDocRequerimientoC")
    public List<SairDocRequerimientoCorrecc> FindSairDocRequerimientoC(@WebParam(name="Hqlrc")String Hqlrc,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
    	/*if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){*/
	    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
	    	List<SairDocRequerimientoCorrecc> LstSairDocRequerimientoC = new ArrayList<SairDocRequerimientoCorrecc>();
	    	LstSairDocRequerimientoC = Obj_Operaciones.FindSairDocRequerimientoC(Hqlrc);
	    	aux=false;
	    	return LstSairDocRequerimientoC;
    	/*}else{
        	return null;
        }*/
	}


    @WebMethod(operationName = "FindSairDocConclusionDocumento")
    public List<SairDocConclusionDocumento> FindSairDocConclusionDocumento(@WebParam(name="Hqlconclusion")String Hqlconclusion,
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
    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<SairDocConclusionDocumento> LstSairDocConclusionDocumento = new ArrayList<SairDocConclusionDocumento>();
    	LstSairDocConclusionDocumento = Obj_Operaciones.FindSairDocConclusionDocumento(Hqlconclusion);
    	aux=false;
    	return LstSairDocConclusionDocumento;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "FindSairRecConclusionReco")
    public List<SairRecConclusionReco> FindSairRecConclusionReco(@WebParam(name="hqlRecCon")String hqlRecCon,
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
    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<SairRecConclusionReco> LstSairRecConclusionReco = new ArrayList<SairRecConclusionReco>();
    	LstSairRecConclusionReco = Obj_Operaciones.FindSairRecConclusionReco(hqlRecCon);
    	aux=false;
    	return LstSairRecConclusionReco;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "FindSairDocPlantillaDocumento")
    public List<SairDocPlantillaDocumento> FindSairDocPlantillaDocumento(@WebParam(name="hqlPlantillaDoc")String hqlPlantillaDoc,
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
    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<SairDocPlantillaDocumento> LstSairDocPlantillaDocumento = new ArrayList<SairDocPlantillaDocumento>();
    	LstSairDocPlantillaDocumento = Obj_Operaciones.FindSairDocPlantillaDocumento(hqlPlantillaDoc);
    	
    	//SairDocPlantillaDocumento objFinal = Obj_Operaciones.ObtenerPlantillaDocumento(LstSairDocPlantillaDocumento.get(0));
    	//LstSairDocPlantillaDocumento = new ArrayList<SairDocPlantillaDocumento>();
    	//LstSairDocPlantillaDocumento.add(objFinal);
    	
    	aux=false;
    	return LstSairDocPlantillaDocumento;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "FindSairDocAnexoDocumento")
    public List<SairDocAnexoDocumento> FindSairDocAnexoDocumento(@WebParam(name="hqlAnexoDoc")String hqlAnexoDoc,
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
    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<SairDocAnexoDocumento> LstSairDocAnexoDocumento = new ArrayList<SairDocAnexoDocumento>();
    	LstSairDocAnexoDocumento = Obj_Operaciones.FindAnexoDocumentos(hqlAnexoDoc);
    	aux=false;
    	return LstSairDocAnexoDocumento;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findSairDocDiscusionInf")
    public List<SairDocDiscusionInf> findSairDocDiscusionInf(@WebParam(name="hqlSairDocDiscusionInf")String hqlSairDocDiscusionInf,
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
    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<SairDocDiscusionInf> LstSairDocAnexoDocumento = new ArrayList<SairDocDiscusionInf>();
    	LstSairDocAnexoDocumento = Obj_Operaciones.findSairDocDiscusionInf(hqlSairDocDiscusionInf);
    	aux=false;
    	return LstSairDocAnexoDocumento;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findSairDocPasos")
    public List<SairDocPasos> findSairDocPasos(@WebParam(name="hqlSairDocPasos")String hqlSairDocPasos,
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
    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<SairDocPasos> LstSairDocPasos = new ArrayList<SairDocPasos>();
    	LstSairDocPasos = Obj_Operaciones.findSairDocPasos(hqlSairDocPasos);
    	aux=false;
    	return LstSairDocPasos;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findSairDocReservacionCodigo")
    public List<SairDocReservacionCodigo> findSairDocReservacionCodigo(@WebParam(name="hqlReservacion")String hqlReservacion,
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
    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<SairDocReservacionCodigo> LstSairDocPasos = new ArrayList<SairDocReservacionCodigo>();
    	LstSairDocPasos = Obj_Operaciones.findSairDocReservacionCodigo(hqlReservacion);
    	aux=false;
    	return LstSairDocPasos;
    	}else{
        	return null;
        }
	}
     	
	@WebMethod(operationName = "IngresaSairDocInformes")
    public List<Mensaje> IngresaSairDocInformes( 
    		@WebParam(name="obj_SairInformes")SairDocInformes obj_SairInformes,
    		@WebParam(name="TipoTransc")int TipoTransc,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
		dao.savelog("TEST", "TEST", "TEST", "DENTRO DE INGRESA SAIR DOC INFORMES", 712, "BIEN", "", 2);
		if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
			dao.savelog("TEST", "TEST", "TEST", "DENTRO DE AUTENTICACION", 712, "BIEN", "", 2);
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
		dao.savelog("TEST", "TEST", "TEST", "FUERA DE AUTENTICACION", 712, "BIEN", "", 2);
    	if(aux){
    		dao.savelog("TEST", "TEST", "TEST", "DENTRO DE AUX", 712, "BIEN", "", 2);
		OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairDocInformes(obj_SairInformes, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	
	@WebMethod(operationName = "IngresaSairDocMemorando")
    public List<Mensaje> IngresaSairDocMemorando( 
    		@WebParam(name="obj_SairDocMemorando")SairDocMemorando obj_SairDocMemorando,
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
		OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	//ClobAdapter s=new ClobAdapter();
    	mensajeList = Obj_Operaciones.IngresaSairDocMemorando(obj_SairDocMemorando, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	
	@WebMethod(operationName = "IngresaSairDocArnp")
    public List<Mensaje> IngresaSairDocArnp( 
    		@WebParam(name="obj_SairArnp")SairDocArnp obj_SairArnp,
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
		OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairDocArnp(obj_SairArnp, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	
	@WebMethod(operationName = "IngresaSairDocRC")
    public List<Mensaje> IngresaSairDocRC( 
    		
    		
    		@WebParam(name="obj_SairDocRC")SairDocRequerimientoCorrecc obj_SairDocRC,
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
		OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairDocRC(obj_SairDocRC, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	
	@WebMethod(operationName = "IngresaSairDocRiesgoRc")
    public List<Mensaje> IngresaSairDocRiesgoRc( 
    		
    		
    		@WebParam(name="idReisgoRc")BigDecimal idReisgoRc,
    		@WebParam(name="sairDocRequerimientoCorrecc")SairDocRequerimientoCorrecc sairDocRequerimientoCorrecc,
    		@WebParam(name="sairDocRiesgoDocumento")SairDocRiesgoDocumento sairDocRiesgoDocumento,
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
		OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairDocRiesgoRC(idReisgoRc, sairDocRequerimientoCorrecc, sairDocRiesgoDocumento, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	
	@WebMethod(operationName = "IngresaSairDocConclusionDocumento")
    public List<Mensaje> IngresaSairDocConclusionDocumento(@WebParam(name="obj_SairDocConclusionD")SairDocConclusionDocumento obj_SairDocConclusionD,
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
		OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairDocConclusionDocumento(obj_SairDocConclusionD, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	
	@WebMethod(operationName = "IngresaSairDocPasos")
    public List<Mensaje> IngresaSairDocPasos( 
    		
    		@WebParam(name="idPasos")BigDecimal idPasos,
    		@WebParam(name="sairDocReservacionCodigo")SairDocReservacionCodigo sairDocReservacionCodigo,
			@WebParam(name="idUsuario")String idUsuario,
			@WebParam(name="fechaIngreso")Date fechaIngreso,
			@WebParam(name="estado")String estado, 
			@WebParam(name="pasos")String pasos,
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
		OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairDocPasos(idPasos, sairDocReservacionCodigo, idUsuario, fechaIngreso, estado, pasos, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	
	
	@WebMethod(operationName = "deleteSairDocConclusionDocumento") 
    public List<Mensaje> deleteSairDocConclusionDocumento( @WebParam(name="obj_SairDocConclusionD")SairDocConclusionDocumento obj_SairDocConclusionD,
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
		OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.deleteSairDocConclusionDocumento(obj_SairDocConclusionD, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaSairDocPlantillaDocumento")
    public List<Mensaje> IngresaSairDocPlantillaDocumento( 
    		@WebParam(name="obj_SairDocPlantillaD")SairDocPlantillaDocumento obj_SairDocPlantillaD,
			@WebParam(name="TipoTransc")int TipoTransc)  {
		
		//String detalle = obj_SairDocPlantillaD.getDetalle();
		//SairDocPlantillaDocumento tmpObject = obj_SairDocPlantillaD;
		//obj_SairDocPlantillaD.setDetalle(null);
		OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairDocPlantillaDocumento(obj_SairDocPlantillaD, TipoTransc);
    	//tmpObject.setDetalle(detalle);
    	//try {
		//	Obj_Operaciones.IngresaClobDataOnTableUpdate(tmpObject);
		//} catch (IOException e) {
		//	e.printStackTrace();
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
    	return mensajeList;
    }
	
	 public List<Mensaje> IngresaSairDocAnexoDocumento( 
	    		
	    		
			 @WebParam(name="idAnexoDocumento")BigDecimal idAnexoDocumento,
			 @WebParam(name="sairDocReservacionCodigo")SairDocReservacionCodigo sairDocReservacionCodigo,
			 @WebParam(name="sairEstadosPrincipal")SairEstadosPrincipal sairEstadosPrincipal, 
			 @WebParam(name="descripcion")String descripcion,
			 @WebParam(name="documentoAnexado")String documentoAnexado, 
			 @WebParam(name="rutaCompartida")String rutaCompartida,
			 @WebParam(name="fechaIngreso")Date fechaIngreso, 
			 @WebParam(name="fechaActualizacion")Date fechaActualizacion, 
			 @WebParam(name="idEstadoComp")BigDecimal idEstadoComp, 
			 @WebParam(name="extension")String extension,
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
			OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.IngresaSairDocAnexoDocumento(idAnexoDocumento, sairDocReservacionCodigo, sairEstadosPrincipal, descripcion, documentoAnexado, rutaCompartida, fechaIngreso, fechaActualizacion, idEstadoComp,extension, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	 
	 @WebMethod(operationName = "deleteSairDocAnexoDocumento") 	
	    public List<Mensaje> deleteSairDocAnexoDocumento( 
	    		 @WebParam(name="idAnexoDocumento")BigDecimal idAnexoDocumento,
				 @WebParam(name="sairDocReservacionCodigo")SairDocReservacionCodigo sairDocReservacionCodigo,
				 @WebParam(name="sairEstadosPrincipal")SairEstadosPrincipal sairEstadosPrincipal, 
				 @WebParam(name="descripcion")String descripcion,
				 @WebParam(name="documentoAnexado")String documentoAnexado, 
				 @WebParam(name="rutaCompartida")String rutaCompartida,
				 @WebParam(name="fechaIngreso")Date fechaIngreso, 
				 @WebParam(name="fechaActualizacion")Date fechaActualizacion, 
				 @WebParam(name="idEstadoComp")BigDecimal idEstadoComp, 
				 @WebParam(name="extension")String extension,
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
		 OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.deleteSairDocAnexoDocumento(idAnexoDocumento, sairDocReservacionCodigo, sairEstadosPrincipal, descripcion, documentoAnexado, rutaCompartida, fechaIngreso, fechaActualizacion, idEstadoComp,extension, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	
	 @WebMethod(operationName = "IngresaSairDocDiscusionInf") 
	    public List<Mensaje> IngresaSairDocDiscusionInf( 
	    		 @WebParam(name="idDiscusion")BigDecimal idDiscusion,
				 @WebParam(name="sairDocReservacionCodigo")SairDocReservacionCodigo sairDocReservacionCodigo,
				 @WebParam(name="idUsuario")String idUsuario, 
				 @WebParam(name="discusion")String discusion,
				 @WebParam(name="estados")String estados, 
				 @WebParam(name="fechaIngreso")Date fechaIngreso,
				 @WebParam(name="url")String url,
				 @WebParam(name="extencion")String extencion,
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
		 OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.IngresaSairDocDiscusionInf(idDiscusion, sairDocReservacionCodigo, idUsuario, estados, discusion, fechaIngreso,url,extencion, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	 
	 @WebMethod(operationName = "deleteSairDocDiscusionInf") 
	    public List<Mensaje> deleteSairDocDiscusionInf( 
	    		 @WebParam(name="idDiscusion")BigDecimal idDiscusion,
				 @WebParam(name="sairDocReservacionCodigo")SairDocReservacionCodigo sairDocReservacionCodigo,
				 @WebParam(name="idUsuario")String idUsuario, 
				 @WebParam(name="discusion")String discusion,
				 @WebParam(name="estados")String estados, 
				 @WebParam(name="fechaIngreso")Date fechaIngreso,
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
		 OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.deleteSairDocDiscusionInf(idDiscusion, sairDocReservacionCodigo, idUsuario, estados, discusion, fechaIngreso, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	 
	 
	 @WebMethod(operationName = "deleteSairDocPasos") 
	    public List<Mensaje> deleteSairDocPasos( 
	    		
	    		@WebParam(name="idPasos")BigDecimal idPasos,
	    		@WebParam(name="sairDocReservacionCodigo")SairDocReservacionCodigo sairDocReservacionCodigo,
				@WebParam(name="idUsuario")String idUsuario,
				@WebParam(name="fechaIngreso")Date fechaIngreso,
				@WebParam(name="estado")String estado, 
				@WebParam(name="pasos")String pasos,
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
		 OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.deleteSairDocPasos(idPasos, sairDocReservacionCodigo, idUsuario, fechaIngreso, estado, pasos, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	 
	 
	 @WebMethod(operationName = "deleteSairDocRiesgoRc") 
	    public List<Mensaje> deleteSairDocRiesgoRc( 
	    		
	    		@WebParam(name="idReisgoRc")BigDecimal idReisgoRc,
	    		@WebParam(name="sairDocRequerimientoCorrecc")SairDocRequerimientoCorrecc sairDocRequerimientoCorrecc,
				@WebParam(name="sairDocRiesgoDocumento")SairDocRiesgoDocumento sairDocRiesgoDocumento,
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
		 OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.deleteSairDocRiesgoRc(idReisgoRc, sairDocRequerimientoCorrecc, sairDocRiesgoDocumento, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	 
	@WebMethod(operationName = "FindSairDocTipoHallazgo")
	public List<SairDocTipoHallazgo> FindSairDocTipoHallazgo(@WebParam(name="Hqlrc")String Hqlrc,
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
			 OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
			 List<SairDocTipoHallazgo> LstSairDocTipoHallazgo = new ArrayList<SairDocTipoHallazgo>();
			 LstSairDocTipoHallazgo = Obj_Operaciones.FindSairDocTipoHallazgo(Hqlrc);
			 aux=false;
			 return LstSairDocTipoHallazgo;	
		 }else{
			 return null;
	     }
	}
	
	@WebMethod(operationName = "IngresaSairDocTipoHallazgo")
	public List<Mensaje> IngresaSairDocTipoHallazgo(
			@WebParam(name="idTipoHallazgo")BigDecimal idTipoHallazgo,
			@WebParam(name="nombre")String nombre, 
			@WebParam(name="estado")String estado,
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
    		OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    		List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    		mensajeList = Obj_Operaciones.IngresaSairDocTipoHallazgoInf(idTipoHallazgo, nombre, estado, TipoTransc);
    		aux=false;
    		return mensajeList;
    	}else{
        	return null;
        }
    }		
		
	@WebMethod(operationName = "FindSairDocTipoEvento")
	public List<SairDocTipoEvento> FindSairDocTipoEvento(@WebParam(name="Hqlrc")String Hqlrc,
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
			 OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
			 List<SairDocTipoEvento> LstSairDocTipoEvento = new ArrayList<SairDocTipoEvento>();
			 LstSairDocTipoEvento = Obj_Operaciones.FindSairDocTipoEvento(Hqlrc);
			 aux=false;
			 return LstSairDocTipoEvento;	
		 }else{
			 return null;
	     }
	}	
	
	@WebMethod(operationName = "IngresaSairDocTipoEvento")
	public List<Mensaje> IngresaSairDocTipoEvento(
			@WebParam(name="idTipoEvento")BigDecimal idTipoEvento,
			@WebParam(name="nombre")String nombre, 
			@WebParam(name="estado")String estado,
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
    		OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    		List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    		mensajeList = Obj_Operaciones.IngresaSairDocTipoEventoInf(idTipoEvento, nombre, estado, TipoTransc);
    		aux=false;
    		return mensajeList;
    	}else{
        	return null;
        }
    }	
	
}