package ec.com.rgt.sair.ws;
 
import java.math.BigDecimal;
import java.util.*;

import javax.jws.*;

import ec.com.rgt.sair.controller.*;
import ec.com.rgt.sair.dao.Conexion;
import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.hbm.*;
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_diccionario {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
    @WebMethod(operationName = "conexion")
    public ArrayList<String> conexion(@WebParam(name="sql")String sql)  {
    	//Conexion Obj_Operaciones = new Conexion();
    	DAO Obj_Operaciones = new DAO();
    	ArrayList<String> ListSairParRutina = new ArrayList<String>();
    	ListSairParRutina = Obj_Operaciones.Sqlquery(sql);
    	return ListSairParRutina;
	}
    
    @WebMethod(operationName = "deleteMasivoSQL")
    public int deleteMasivoSQL(@WebParam(name="sql")String sql)  {
    	DAO dao = new DAO();
    	int res = dao.deleteMasivoSQL(sql);
    	return res;
	}
    
    @WebMethod(operationName = "llenarTblAmxE")
    public String llenarTblAmxE(
    		@WebParam(name="fecha")String fecha,
    		@WebParam(name="numCap")int numCap,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
    	String var="";
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
    	Conexion Obj_Operaciones = new Conexion();
    	var = Obj_Operaciones.llenaTblAmxEnvio(fecha, numCap);
    	aux=false;
    	}else{
        }
    	return var;
	}
    
    @WebMethod(operationName = "ejecutarRepContravencion")
    public String ejecutarRepContravencion(
    		@WebParam(name="feca")String feca,
    		@WebParam(name="fecb")String fecb,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
    	String var="";
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
    	Conexion Obj_Operaciones = new Conexion();
    	var = Obj_Operaciones.ejecutarRepContravencion(feca,fecb);
    	aux=false;
    	}else{
        }
    	return var;
	}
    
    @WebMethod(operationName = "PresentaAmx")
    public String PresentaAmx ()  {
    	String var="";
    	Conexion Obj_Operaciones = new Conexion();
    	var = Obj_Operaciones.PresentaAmx();
    	return var;
	}
        
    @WebMethod(operationName = "llenaTblAmx")
    public String llenaTblAmx ()  {
    	String var="";
    	Conexion Obj_Operaciones = new Conexion();
    	var = Obj_Operaciones.llenaTblAmx();
    	return var;
	}
    
    @WebMethod(operationName = "CallProcSecResetAD")
    public Boolean CallProcSecResetAD ()  {
    	Boolean var=false;
    	var = Conexion.CallProcessResetSecUsuariosAD();
    	return var;
	}
    
    @WebMethod(operationName = "FindSairFormato")
    public List<SairFormato> FindSairFormato(@WebParam(name="hqlFormato")String hqlFormato,
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
		OperacionesSairFormato Obj_Operaciones = new OperacionesSairFormato();
    	List<SairFormato> ListSairFormato = new ArrayList<SairFormato>();
    	ListSairFormato = Obj_Operaciones.FindSairFormato(hqlFormato);
    	aux=false;
    	return ListSairFormato;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "IngresaSairFormato")
    public List<Mensaje> IngresaSairFormato(@WebParam(name="idFormato")BigDecimal idFormato, 
    		@WebParam(name="tabla")String tabla, @WebParam(name="campos")String campos, 
    		@WebParam(name="orden")BigDecimal orden, @WebParam(name="estadof")String estadof,
    		@WebParam(name="obligatorio")String obligatorio,
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
    	OperacionesSairFormato Obj_Operaciones = new OperacionesSairFormato();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.IngresaSairFormato(idFormato, tabla, campos, orden, estadof,obligatorio, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "DeleteSairFormato")
    public List<Mensaje> DeleteSairFormato(@WebParam(name="idFormato")BigDecimal idFormato, 
    		@WebParam(name="tabla")String tabla, @WebParam(name="campos")String campos, 
    		@WebParam(name="orden")BigDecimal orden, @WebParam(name="estadof")String estadof, 
    		@WebParam(name="obligatorio")String obligatorio,
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
    	OperacionesSairFormato Obj_Operaciones = new OperacionesSairFormato();
    	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
    	ListMensaje = Obj_Operaciones.DeleteSairFormato(idFormato, tabla, campos, orden, estadof,obligatorio, TipoTransc);
    	aux=false;
    	return ListMensaje;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "CallProcess")
    public boolean CallProcess()  {
        return  Conexion.CallProcess();
	}
    
    /*JGILCES REC MONO TEST*/
    @WebMethod(operationName = "CallProcessRecMono")
    public Boolean CallLlenarTablaRecoMono() {
    	return Conexion.CallProcessRecMono();
    }
    /********************************************/
    
    @WebMethod(operationName = "CallLlenarRecoAbiertas")
    public Boolean CallLlenarRecoAbiertas(
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion)  {
    	Boolean var=false;
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
    	Conexion Obj_Operaciones = new Conexion();
    	var = Obj_Operaciones.CallProcessLlenarRecoAbiertas();
    	aux=false;
    	}else{
        }
    	return var;
	}
    
    @WebMethod(operationName = "callPrimerSeguimiento")
    public boolean callPrimerSeguimiento(@WebParam(name="fecha")String fecha){
    	Conexion Obj_Operaciones = new Conexion();
    	return Obj_Operaciones.callPrimerSeguimiento(fecha);
	}
    
    @WebMethod(operationName = "getMasivoConclusionRec")
    public String getMasivoConclusionRec(@WebParam(name="usuario")String usuario,@WebParam(name="idAreaev")BigDecimal idAreaev,@WebParam(name="idSubarea")BigDecimal idSubarea,
    		@WebParam(name="grtEnc")String grtEnc,@WebParam(name="prsEnc")String prsEnc,@WebParam(name="item")String item,@WebParam(name="idReservacion")BigDecimal idReservacion){
    	Conexion Obj_Operaciones = new Conexion();
    	return Obj_Operaciones.getMasivoConclusionRec(usuario, idAreaev, idSubarea, grtEnc, prsEnc, item, idReservacion);
	}
    
}