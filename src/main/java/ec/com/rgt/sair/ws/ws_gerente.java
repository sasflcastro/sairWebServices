package ec.com.rgt.sair.ws;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.jws.*;

import ec.com.rgt.sair.controller.*;
import ec.com.rgt.sair.hbm.SairGerente;
import ec.com.rgt.sair.hbm.SairUnidadGerente;

@WebService()
public class ws_gerente {
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	OperacionesUnidad unidad=new OperacionesUnidad();
	
	//@SuppressWarnings("unchecked")
	@WebMethod(operationName = "findGerente")
    public List<SairGerente> findGerente(@WebParam(name="hqlGerente")String hqlGerente,
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
		OperacionesGerente Obj_Operaciones = new OperacionesGerente();
    	List<SairGerente> GrtsList = new ArrayList<SairGerente>();
    	GrtsList = Obj_Operaciones.findGerente(hqlGerente);
    	aux=false;
    	return GrtsList;
    	}else{
        	return null;
        }
	}
	
	
	@WebMethod(operationName = "SaveorUpdateGerente")
    public int SaveorUpdateGerente(@WebParam(name="gerente")SairGerente gerente,
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
		OperacionesGerente Obj_Operaciones = new OperacionesGerente();
    	int i = Obj_Operaciones.SaveorUpdateGerente(gerente);
    	aux=false;
    	return i;
    	}else{
        	return 0;
        }
	}
	
	
	@WebMethod(operationName = "findAllGerentes")
	/**
	 * @param idGerente :es el id gerente
	 * @return retorna una lista de personas que estan bajo el cargo del gerente, jefes y supervisor
	 */
    public List<SairGerente> findAllGerentes(@WebParam(name="idGerente")BigDecimal idGerente,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion) {
		if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
		OperacionesGerente Obj_Operaciones = new OperacionesGerente();
    	List<SairGerente> GrtsList = new ArrayList<SairGerente>();
    	GrtsList = Obj_Operaciones.findAllGerentes(idGerente);
    	aux=false;
    	return GrtsList;
    	}else{
        	return null;
        }
	}
	
	//unidad gerente
 	
 	@WebMethod(operationName = "findUnidadGerente")
 	public List<SairUnidadGerente> findUnidadGerente(@WebParam(name="hql")String hql){
 		return unidad.findUnidadGerente(hql);
 	}

 	@WebMethod(operationName = "deleteUnidadGerente")
 	public int deleteUnidadGerente(@WebParam(name="idUnidadGerente")BigDecimal idUnidadGerente){
 		return unidad.deleteUnidadGerente(idUnidadGerente);
 	}
 	
 	@WebMethod(operationName = "insertUnidadGerente")
 	public int insertUnidadGerente(@WebParam(name="unidadGerente")SairUnidadGerente unidadGerente){
 		return unidad.insertUnidadGerente(unidadGerente);
 	}
}
