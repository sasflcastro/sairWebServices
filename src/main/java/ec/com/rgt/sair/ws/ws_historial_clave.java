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
import ec.com.rgt.sair.controller.OperacionesHistorialClave;
import ec.com.rgt.sair.hbm.HistoricoClaves;


@WebService()
public class ws_historial_clave {
	
	 Boolean aux=false;
	 LdapAutenticationWS ws=new LdapAutenticationWS();
		@WebMethod(operationName = "ConsultaHistorial")
	    public String ConsultaHistorial(@WebParam(name="Clave")String Clave,@WebParam(name="idUsuario")String idUsuario,
	    		@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
		 if(Autenticacion!=null&&idUsuario!=null&&Clave!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(idUsuario, Clave);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(idUsuario, Clave);
	    	}
	    	if(aux){
	    	OperacionesHistorialClave operacionesHistorialClave = new OperacionesHistorialClave();
	    	String SairParametrosList = operacionesHistorialClave.ValidaHistorialClave(Clave, idUsuario);
	    	aux=false;
	        return SairParametrosList;
	    	}else{
	        	return null;
	        }
	    }
	    

		@WebMethod(operationName = "findHistorialClave")
	    public List<HistoricoClaves> findHistorialClave(@WebParam(name="HqlHistorial")String HqlHistorial,
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
	    	OperacionesHistorialClave operacionesHistorialClave = new OperacionesHistorialClave();
	    	List<HistoricoClaves> SairParametrosList = new ArrayList<HistoricoClaves>();
	    	SairParametrosList = operacionesHistorialClave.findHistorial(HqlHistorial);
	    	aux=false;
	    	return SairParametrosList;
	    	}else{
	        	return null;
	        }
		}
		
		@WebMethod(operationName = "IngresaHistorialClave")
	    public List<Mensaje> IngresaHistorialClave(@WebParam(name="idHistorico")BigDecimal idHistorico, @WebParam(name="idUsuario")String idUsuario, @WebParam(name="claveAnterior")String claveAnterior,
	    		@WebParam(name="claveNueva")String claveNueva, @WebParam(name="usuarioCambio")String usuarioCambio, @WebParam(name="fechaCambio")Date fechaCambio, @WebParam(name="TipoTransc")int TipoTransc,
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
			OperacionesHistorialClave operacionesHistorialClave = new OperacionesHistorialClave();
	    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
	    	mensajeList = operacionesHistorialClave.IngresaHistorialClave(idHistorico, idUsuario, claveAnterior, claveNueva, fechaCambio, usuarioCambio, TipoTransc);
	    	aux=false;
	    	return mensajeList;
	    	}else{
	        	return null;
	        }
	    }

}
