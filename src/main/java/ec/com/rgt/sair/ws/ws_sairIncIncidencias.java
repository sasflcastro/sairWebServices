package ec.com.rgt.sair.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.controller.OperacionesSairIncIncidencias;
import ec.com.rgt.sair.hbm.SairIncIncidencia;
import ec.com.rgt.sair.hbm.SairIncTipo;
import ec.com.rgt.sair.hbm.TblProceAmx;
import ec.com.rgt.sair.hbm.TblProceAmxEnvia;
@WebService()
public class ws_sairIncIncidencias {

Boolean aux=false;
LdapAutenticationWS ws=new LdapAutenticationWS();
    
    @WebMethod(operationName = "findIncIncidencias")
    public List<SairIncIncidencia> findIncIncidencias(@WebParam(name="hqlInc")String hqlInc,
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
    	OperacionesSairIncIncidencias Obj_Operaciones = new OperacionesSairIncIncidencias();
    	List<SairIncIncidencia> listSairFormato = new ArrayList<SairIncIncidencia>();
    	listSairFormato = Obj_Operaciones.FindSairIncIncidencias(hqlInc);
    	aux=false;
        return listSairFormato;
    	}else{
        	return null;
        }
	}
    
    
    @WebMethod(operationName = "findIncTipoIncidencias")
    public List<SairIncTipo> findIncTipoIncidencias(@WebParam(name="hqlIncTipo")String hqlIncTipo,
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
    	OperacionesSairIncIncidencias Obj_Operaciones = new OperacionesSairIncIncidencias();
    	List<SairIncTipo> listSairFormato = new ArrayList<SairIncTipo>();
    	listSairFormato = Obj_Operaciones.FindSairIncTipoIncidencias(hqlIncTipo);
    	aux=false;
        return listSairFormato;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findTblAmx")
    public List<TblProceAmx> findTblAmx(@WebParam(name="hqlAmx")String hqlAmx,
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
    	OperacionesSairIncIncidencias Obj_Operaciones = new OperacionesSairIncIncidencias();
    	List<TblProceAmx> listSairFormato = new ArrayList<TblProceAmx>();
    	listSairFormato = Obj_Operaciones.findTblAmx(hqlAmx);
    	aux=false;
        return listSairFormato;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "findTblAmxsEnvia")
    public List<TblProceAmxEnvia> findTblAmxsEnvia(@WebParam(name="hqlAmxE")String hqlAmxE,
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
    	OperacionesSairIncIncidencias Obj_Operaciones = new OperacionesSairIncIncidencias();
    	List<TblProceAmxEnvia> listSairFormato = new ArrayList<TblProceAmxEnvia>();
    	listSairFormato = Obj_Operaciones.findTblAmxsEnvia(hqlAmxE);
    	aux=false;
        return listSairFormato;
    	}else{
        	return null;
        }
	}
    
    @WebMethod(operationName = "IngresaTblProceAmx")
    public List<Mensaje> IngresaTblProceAmx( 
    			
    		@WebParam(name="tblProceAmx")TblProceAmx tblProceAmx,
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
		OperacionesSairIncIncidencias Obj_Operaciones = new OperacionesSairIncIncidencias();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaTblProceAmx(tblProceAmx, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
    
    @WebMethod(operationName = "IngresaSairIncIncidencia")
    public List<Mensaje> IngresaSairIncIncidencia( 
    			
    		@WebParam(name="sairIncIncidencia")SairIncIncidencia sairIncIncidencia,
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
		OperacionesSairIncIncidencias Obj_Operaciones = new OperacionesSairIncIncidencias();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairIncIncidencias(sairIncIncidencia, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
}
