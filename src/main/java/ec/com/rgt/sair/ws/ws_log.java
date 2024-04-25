package ec.com.rgt.sair.ws;
 
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.dao.LogDAO;
import ec.com.rgt.sair.dao.UtilsDAO;
import ec.com.rgt.sair.hbm.SairDocAlcance;
import ec.com.rgt.sair.hbm.SairDocAntecedente;
import ec.com.rgt.sair.hbm.SairLog;
import ec.com.rgt.sair.hbm.SairNotificacion;
import ec.com.rgt.sair.hbm.SairReportes;
import ec.com.rgt.sair.hbm.SairTipoLog;
 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_log {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	
    @WebMethod(operationName = "findTipoLog")
    public List<SairTipoLog> findTipoLog(@WebParam(name="hql_tipoLog")String hql_tipoLog,
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
    	LogDAO Obj_Operaciones = new LogDAO();
    	List<SairTipoLog> aplicacionesList = new ArrayList<SairTipoLog>();
    	aplicacionesList = Obj_Operaciones.findTipoLog(hql_tipoLog);
    	aux=false;
        return aplicacionesList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "findLog")
    public List<SairLog> findLog(@WebParam(name="hql_Log")String hql_Log,
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
    	LogDAO Obj_Operaciones = new LogDAO();
    	List<SairLog> aplicacionesList = new ArrayList<SairLog>();
    	aplicacionesList = Obj_Operaciones.findLog(hql_Log);
    	aux=false;
        return aplicacionesList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "findSairNotificacion")
    public List<SairNotificacion> findSairNotificacion(@WebParam(name="hql_notificacion")String hql_notificacion,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
    	LogDAO Obj_Operaciones = new LogDAO();
    	List<SairNotificacion> aplicacionesList = new ArrayList<SairNotificacion>();
    	aplicacionesList = Obj_Operaciones.findSairNotificacion(hql_notificacion);
        return aplicacionesList;
    }
    
    @WebMethod(operationName = "findAntecedente")
    public List<SairDocAntecedente> findAntecedente(@WebParam(name="hql")String hql,
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
	    	LogDAO Obj_Operaciones = new LogDAO();
	    	List<SairDocAntecedente> aplicacionesList = new ArrayList<SairDocAntecedente>();
	    	aplicacionesList = Obj_Operaciones.findAntecedente(hql);
	    	aux=false;
	        return aplicacionesList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "findAlcance")
    public List<SairDocAlcance> findAlcance(@WebParam(name="hql")String hql,
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
	    	LogDAO Obj_Operaciones = new LogDAO();
	    	List<SairDocAlcance> aplicacionesList = new ArrayList<SairDocAlcance>();
	    	aplicacionesList = Obj_Operaciones.findAlcance(hql);
	    	aux=false;
	        return aplicacionesList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "findSairReportes")
    public List<SairReportes> findSairReportes(@WebParam(name="hql_SairReportes")String hql_SairReportes,
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
    	LogDAO Obj_Operaciones = new LogDAO();
    	List<SairReportes> aplicacionesList = new ArrayList<SairReportes>();
    	aplicacionesList = Obj_Operaciones.findSairReportes(hql_SairReportes);
    	aux=false;
        return aplicacionesList;
    	}else{
        	return null;
        }
    }
 
	@WebMethod(operationName = "ingresaLog")
    public Mensaje ingresaLog(@WebParam(name="sairlog")SairLog sairlog,
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
		LogDAO Obj_Operaciones = new LogDAO();
    	Mensaje aplicacionesList = new Mensaje();
    	aplicacionesList = Obj_Operaciones.ingresaLog(sairlog);
    	aux=false;
    	return aplicacionesList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "ingresaSairReportes")
    public Mensaje ingresaSairReportes(@WebParam(name="sairReportes")SairReportes sairReportes,
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
		LogDAO Obj_Operaciones = new LogDAO();
    	Mensaje aplicacionesList = new Mensaje();
    	aplicacionesList = Obj_Operaciones.ingresaSairReportes(sairReportes);
    	aux=false;
    	return aplicacionesList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "deleteSairReportes")
    public Mensaje deleteSairReportes(@WebParam(name="sairReportes")SairReportes sairReportes,
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
		LogDAO Obj_Operaciones = new LogDAO();
    	Mensaje aplicacionesList = new Mensaje();
    	aplicacionesList = Obj_Operaciones.deleteSairReportes(sairReportes);
    	aux=false;
    	return aplicacionesList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "ingresaNotificacion")
    public Mensaje ingresaNotificacion(@WebParam(name="sairNotificacion")SairNotificacion sairNotificacion,
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
		LogDAO Obj_Operaciones = new LogDAO();
    	Mensaje aplicacionesList = new Mensaje();
    	aplicacionesList = Obj_Operaciones.ingresaNotificacion(sairNotificacion);
    	aux=false;
    	return aplicacionesList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "ingresaSairDocAntecedente")
    public Mensaje ingresaSairDocAntecedente(@WebParam(name="alcance")SairDocAntecedente antecedente,
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
			LogDAO Obj_Operaciones = new LogDAO();
	    	Mensaje aplicacionesList = new Mensaje();
	    	aplicacionesList = Obj_Operaciones.ingresaSairDocAntecedente(antecedente);
	    	aux=false;
	    	return aplicacionesList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "ingresaSairDocAlcance")
    public Mensaje ingresaSairDocAlcance(@WebParam(name="alcance")SairDocAlcance alcance,
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
			LogDAO Obj_Operaciones = new LogDAO();
	    	Mensaje aplicacionesList = new Mensaje();
	    	aplicacionesList = Obj_Operaciones.ingresaSairDocAlcance(alcance);
	    	aux=false;
	    	return aplicacionesList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "deleteLog")
    public Mensaje deleteLog(@WebParam(name="sairlog")SairLog sairlog,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
    	Mensaje aplicacionesList=UtilsDAO.eliminarLog();
		return aplicacionesList;
	}
	
	@WebMethod(operationName = "deletesairNotificacion")
    public Mensaje deletesairNotificacion(@WebParam(name="sairNotificacion")SairNotificacion sairNotificacion,
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
		LogDAO Obj_Operaciones = new LogDAO();
    	Mensaje aplicacionesList = new Mensaje();
    	aplicacionesList = Obj_Operaciones.deletesairNotificacion(sairNotificacion);
    	aux=false;
    	return aplicacionesList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "deleteSairAlcance")
    public Mensaje deleteSairAlcance(@WebParam(name="alcance")SairDocAlcance alcance,
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
			LogDAO Obj_Operaciones = new LogDAO();
	    	Mensaje aplicacionesList = new Mensaje();
	    	aplicacionesList = Obj_Operaciones.deleteSairAlcance(alcance);
	    	aux=false;
	    	return aplicacionesList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "deleteSairAntecedente")
    public Mensaje deleteSairAntecedente(@WebParam(name="antecedente")SairDocAntecedente antecedente,
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
			LogDAO Obj_Operaciones = new LogDAO();
	    	Mensaje aplicacionesList = new Mensaje();
	    	aplicacionesList = Obj_Operaciones.deleteSairAntecedente(antecedente);
	    	aux=false;
	    	return aplicacionesList;
    	}else{
        	return null;
        }
	}
    
}