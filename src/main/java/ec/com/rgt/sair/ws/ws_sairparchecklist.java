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

public class ws_sairparchecklist {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();

	@WebMethod(operationName = "FindSairParCheckList")
    public List<SairParCheckList> FindSairParCheckList(@WebParam(name="HqlCheckList")String HqlCheckList,
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
    	OperacionesSairParCheckList Obj_Operaciones = new OperacionesSairParCheckList();
    	List<SairParCheckList> SairParCheckList = new ArrayList<SairParCheckList>();
    	SairParCheckList = Obj_Operaciones.FindSairParCheckList(HqlCheckList);
    	aux=false;
    	return SairParCheckList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "IngresaSairParCheckList")
    public List<Mensaje> IngresaSairParCheckList( @WebParam(name="sairParCheckList")SairParCheckList sairParCheckList, 
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
		OperacionesSairParCheckList Obj_Operaciones = new OperacionesSairParCheckList();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairParCheckList(sairParCheckList, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	
	/***************************************/
	

		@WebMethod(operationName = "FindSairParCheckListCabecera")
	    public List<SairParCheckListCabecera> FindSairParCheckListCabecera(@WebParam(name="HqlCheckList")String HqlCheckList,
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
	    	OperacionesSairParCheckList Obj_Operaciones = new OperacionesSairParCheckList();
	    	List<SairParCheckListCabecera> SairParCheckListCab = new ArrayList<SairParCheckListCabecera>();
	    	SairParCheckListCab = Obj_Operaciones.FindSairParCheckListCabecera(HqlCheckList);
	    	aux=false;
	    	return SairParCheckListCab;
	    	}else{
	        	return null;
	        }
		}
		
		@WebMethod(operationName = "IngresaSairParCheckListCabecera")
	    public List<Mensaje> IngresaSairParCheckListCabecera(@WebParam(name="cabId")BigDecimal cabId, @WebParam(name="cabNombre")String cabNombre, @WebParam(name="cabFecha")Date cabFecha, @WebParam(name="estado")String estado, @WebParam(name="TipoTransc")int TipoTransc,
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
			OperacionesSairParCheckList Obj_Operaciones = new OperacionesSairParCheckList();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.IngresaSairParCheckListCabecera(cabId, cabNombre, cabFecha, estado, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
	
	/***************************************/
    

		@WebMethod(operationName = "FindSairParCheckListDetalle")
	    public List<SairParDetalleCheckList> FindSairParCheckListDetalle(@WebParam(name="HqlDetCheckList")String HqlDetCheckList,
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
	    	OperacionesSairParCheckList Obj_Operaciones = new OperacionesSairParCheckList();
	    	List<SairParDetalleCheckList> SairParCheckListDet = new ArrayList<SairParDetalleCheckList>();
	    	SairParCheckListDet = Obj_Operaciones.FindSairParCheckListDetalle(HqlDetCheckList);
	    	aux=false;
	    	return SairParCheckListDet;
	    	}else{
	        	return null;
	        }
		}
		
		@WebMethod(operationName = "IngresaSairParCheckListDetalle")
	    public List<Mensaje> IngresaSairParCheckListDetalle(@WebParam(name="idDetalle")BigDecimal idDetalle, @WebParam(name="sairParCheckList")SairParCheckList sairParCheckList, @WebParam(name="orden")BigDecimal orden, @WebParam(name="nombre")String nombre,  @WebParam(name="observaciones")String observaciones,@WebParam(name="fecha")Date fecha,@WebParam(name="estado")String estado, @WebParam(name="TipoTransc")int TipoTransc,
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
			OperacionesSairParCheckList Obj_Operaciones = new OperacionesSairParCheckList();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = Obj_Operaciones.IngresaSairParCheckListDetalle(idDetalle, sairParCheckList, orden, nombre, observaciones,fecha, estado, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
		
		@WebMethod(operationName = "IngresaSairDocConRiesgo")
	    public List<Mensaje> IngresaSairDocConRiesgo(@WebParam(name="conRiesgo")SairDocConRiesgo conRiesgo,@WebParam(name="TipoTransc")int TipoTransc,
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
				OperacionesSairParCheckList Obj_Operaciones = new OperacionesSairParCheckList();
		    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
		    	mensajeList = Obj_Operaciones.IngresaSairDocConRiesgo(conRiesgo, TipoTransc);
		    	aux=false;
		    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }
		
		@WebMethod(operationName = "DeleteSairDocConRiesgo")
	    public void DeleteSairDocConRiesgo(@WebParam(name="idConclusion")BigDecimal idConclusion,
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
				OperacionesSairParCheckList Obj_Operaciones = new OperacionesSairParCheckList();
		    	Obj_Operaciones.DeleteSairDocConRiesgo(idConclusion);
		    	aux=false;
	    	}
	    }
		
		@WebMethod(operationName = "findPrioridad")
	    public List<SairDocPrioridad> findPrioridad(@WebParam(name="HqlPrioridad")String HqlPrioridad,
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
	    	OperacionesSairParCheckList Obj_Operaciones = new OperacionesSairParCheckList();
	    	List<SairDocPrioridad> SairParCheckListDet = new ArrayList<SairDocPrioridad>();
	    	SairParCheckListDet = Obj_Operaciones.findPrioridad(HqlPrioridad);
	    	aux=false;
	    	return SairParCheckListDet;
	    	}else{
	        	return null;
	        }
		}
		
		@WebMethod(operationName = "findConclusionRiesgo")
	    public List<SairDocConRiesgo> findConclusionRiesgo(@WebParam(name="HqlConRiesgo")String HqlConRiesgo,
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
	    	OperacionesSairParCheckList Obj_Operaciones = new OperacionesSairParCheckList();
	    	List<SairDocConRiesgo> SairParCheckListDet = new ArrayList<SairDocConRiesgo>();
	    	SairParCheckListDet = Obj_Operaciones.findConclusionRiesgo(HqlConRiesgo);
	    	aux=false;
	    	return SairParCheckListDet;
	    	}else{
	        	return null;
	        }
		}
		
		@WebMethod(operationName = "findImpacto")
	    public List<SairDocImpacto> findImpacto(@WebParam(name="HqlImpacto")String HqlImpacto,
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
	    	OperacionesSairParCheckList Obj_Operaciones = new OperacionesSairParCheckList();
	    	List<SairDocImpacto> SairParCheckListDet = new ArrayList<SairDocImpacto>();
	    	SairParCheckListDet = Obj_Operaciones.findImpacto(HqlImpacto);
	    	aux=false;
	    	return SairParCheckListDet;
	    	}else{
	        	return null;
	        }
		}
		
}