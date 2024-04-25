package ec.com.rgt.sair.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.controller.OperacionesObs;
import ec.com.rgt.sair.controller.OperacionesSairObservaciones;
import ec.com.rgt.sair.hbm.SairCiudad;
import ec.com.rgt.sair.hbm.SairObsAccionAdm;
import ec.com.rgt.sair.hbm.SairObsComentarioAic;
import ec.com.rgt.sair.hbm.SairObsDetallesFaltas;
import ec.com.rgt.sair.hbm.SairObsTipoFalta;
import ec.com.rgt.sair.hbm.SairPlantillas;

@WebService()
public class WsObs2 {
OperacionesObs forum= new OperacionesObs();
Boolean aux=false;
LdapAutenticationWS ws=new LdapAutenticationWS();
	
	@WebMethod(operationName = "findObsDetallesFaltas")
    public List<SairObsDetallesFaltas> findObsDetallesFaltas(@WebParam(name="hqlObsDetallesFaltas")String hqlObsDetallesFaltas,
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
		OperacionesSairObservaciones ObjSairObservaciones = new OperacionesSairObservaciones();
    	List<SairObsDetallesFaltas> ListObsDetallesFaltas = new ArrayList<SairObsDetallesFaltas>();
    	try {
			ListObsDetallesFaltas = ObjSairObservaciones.FindObsDetallesFaltas(hqlObsDetallesFaltas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	aux=false;
    	return ListObsDetallesFaltas;
    	}else{
        	return null;
        }
	}
	
	
	@WebMethod(operationName = "findObsAccionAdm")
    public List<SairObsAccionAdm> findObsAccionAdm(@WebParam(name="hqlObsAccionAdm")String hqlObsAccionAdm,
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
		OperacionesSairObservaciones ObjSairObservaciones = new OperacionesSairObservaciones();
    	List<SairObsAccionAdm> ListObsAccionAdm = new ArrayList<SairObsAccionAdm>();
    	try {
			ListObsAccionAdm = ObjSairObservaciones.FindObsAccionAdm(hqlObsAccionAdm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	aux=false;
    	return ListObsAccionAdm;
    	}else{
        	return null;
        }
	}
	
	
	
	@WebMethod(operationName = "findObsTipoFalta")
    public List<SairObsTipoFalta> findObsTipoFalta(@WebParam(name="hqlObsTipoFalta")String hqlObsTipoFalta,
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
		OperacionesSairObservaciones ObjSairObservaciones = new OperacionesSairObservaciones();
    	List<SairObsTipoFalta> ListObsTipoFalta = new ArrayList<SairObsTipoFalta>();
    	try {
    		ListObsTipoFalta = ObjSairObservaciones.findSairObsTipoFalta(hqlObsTipoFalta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	aux=false;
    	return ListObsTipoFalta;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "findCiudad")
	public List<SairCiudad> findCiudad(@WebParam(name="hqlCiudad")String hqlCiudad,
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
		OperacionesSairObservaciones ObjSairObservaciones = new OperacionesSairObservaciones();
		List<SairCiudad> ListCiudad = new ArrayList<SairCiudad>();
		try {
			ListCiudad = ObjSairObservaciones.findSairCiudad(hqlCiudad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aux=false;
		return ListCiudad;
		}else{
	    	return null;
	    }
	}
	
	@WebMethod(operationName = "IngresaSairCiudad")
    public List<Mensaje> IngresaSairCiudad( 
    		@WebParam(name="SairCiudad")SairCiudad sairCiudad,
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
		OperacionesSairObservaciones Obj_Operaciones = new OperacionesSairObservaciones();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	try {
			mensajeList = Obj_Operaciones.IngresaSairCiudad(sairCiudad, TipoTransc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }

	@WebMethod(operationName = "findObsComentarioAic")
    public List<SairObsComentarioAic> findObsComentarioAic(@WebParam(name="hqlObsComentarioAic")String hqlObsComentarioAic,
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
		OperacionesSairObservaciones ObjSairObservaciones = new OperacionesSairObservaciones();
    	List<SairObsComentarioAic> ListObsComentarioAic = new ArrayList<SairObsComentarioAic>();
    	try {
			ListObsComentarioAic = ObjSairObservaciones.FindObsComentarioAic(hqlObsComentarioAic);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	aux=false;
    	return ListObsComentarioAic;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "findPlantillas")
    public List<SairPlantillas> findPlantillas(@WebParam(name="hqlPlantillas")String hqlPlantillas,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion) throws Exception  {
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
		OperacionesSairObservaciones ObjSairObservaciones = new OperacionesSairObservaciones();
    	List<SairPlantillas> ListSairPlantilla = new ArrayList<SairPlantillas>();
    	ListSairPlantilla = ObjSairObservaciones.findSairPlantillas(hqlPlantillas);
    	aux=false;
    	return ListSairPlantilla;
    	}else{
        	return null;
        }
	}
	
}
