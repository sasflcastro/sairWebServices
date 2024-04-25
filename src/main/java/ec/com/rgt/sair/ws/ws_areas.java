package ec.com.rgt.sair.ws;
 
import java.math.BigDecimal;
import java.util.*;

import javax.jws.*;

import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.controller.OperacionesAreas;
import ec.com.rgt.sair.hbm.SairArea;
import ec.com.rgt.sair.hbm.SairAreasAdam;
import ec.com.rgt.sair.hbm.SairSubArea;
import ec.com.rgt.sair.hbm.SairSubAreaDestinatario;


 
/**
 * @author GeekZero@Devtroce
 */
@WebService()

public class ws_areas {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
    
	@WebMethod(operationName = "findAreasAdam")
    public List<SairAreasAdam> findAreasAdam(@WebParam(name="hqlAreaAdam")String hqlAreaAdam,
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
    	OperacionesAreas Obj_Operaciones = new OperacionesAreas();
    	List<SairAreasAdam> areasList = new ArrayList<SairAreasAdam>();
    	areasList = Obj_Operaciones.findAreaAdam(hqlAreaAdam);
    	aux=false;
    	return areasList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "IngresaArea")
	public List<Mensaje> IngresaArea(@WebParam(name="IdArea")BigDecimal IdArea, @WebParam(name="Descripcion")String Descripcion, @WebParam(name="Estado")String Estado, @WebParam(name="AbreviaturaDep")String AbreviaturaDep, @WebParam(name="AbreviaturaArea")String AbreviaturaArea, @WebParam(name="AbreviaturaGeneral")String AbreviaturaGeneral, @WebParam(name="Orden")String Orden, @WebParam(name="FechaIngreso")Date FechaIngreso, @WebParam(name="JefeArea")String JefeArea,@WebParam(name="email")String email,@WebParam(name="idOperacion")String idOperacion, @WebParam(name="TipoTransc")int TipoTransc,
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
		OperacionesAreas Obj_Areas = new OperacionesAreas();
    	List<Mensaje> aplicacionesList = new ArrayList<Mensaje>();
    	aplicacionesList = Obj_Areas.IngresaArea(IdArea, Descripcion, Estado, AbreviaturaDep, AbreviaturaArea, AbreviaturaGeneral, Orden, FechaIngreso, JefeArea,email,idOperacion, TipoTransc);
    	aux=false;
    	return aplicacionesList;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "findAreas")
    public List<SairArea> findAreas(@WebParam(name="hqlArea")String hqlArea, 
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
		OperacionesAreas Obj_Operaciones = new OperacionesAreas();
    	List<SairArea> areasList = new ArrayList<SairArea>();
    	areasList = Obj_Operaciones.findAreas(hqlArea);
    	aux=false;
    	return areasList;
    	}else{
        	return null;
        }
	}
    
	@WebMethod(operationName = "findSubAreas")
    public List<SairSubArea> findSubAreas(@WebParam(name="hqlSubArea")String hqlSubArea, 
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
		OperacionesAreas Obj_Operaciones = new OperacionesAreas();
    	List<SairSubArea> SubareasList = new ArrayList<SairSubArea>();
    	SubareasList = Obj_Operaciones.findSubAreas(hqlSubArea);
    	aux=false;
    	return SubareasList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "findSubAreasDestinatario")
    public List<SairSubAreaDestinatario> findSubAreasDestinatario(@WebParam(name="hqlSubArea")String hqlSubArea, 
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
		OperacionesAreas Obj_Operaciones = new OperacionesAreas();
    	List<SairSubAreaDestinatario> SubareasList = new ArrayList<SairSubAreaDestinatario>();
    	SubareasList = Obj_Operaciones.findSubAreasDestinatario(hqlSubArea);
    	aux=false;
    	return SubareasList;
    	}else{
        	return null;
        }
	}
	
	@WebMethod(operationName = "IngresaSairSubAreaE")
    public List<Mensaje> IngresaSairSubAreaE( 
    			
    		@WebParam(name="sairSubArea")SairSubArea sairSubArea,
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
    		OperacionesAreas Obj_Operaciones = new OperacionesAreas();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairSubAreaE(sairSubArea, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "IngresaSairSubAreaDestinatario")
    public List<Mensaje> IngresaSairSubAreaDestinatario( 
    			
    		@WebParam(name="sairSubArea")SairSubAreaDestinatario sairSubArea,
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
    		OperacionesAreas Obj_Operaciones = new OperacionesAreas();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairSubAreaDestinatario(sairSubArea, TipoTransc);
    	aux=false;
    	return mensajeList;
    	}else{
        	return null;
        }
    }
	
	@WebMethod(operationName = "DeleteSairSubAreaDestinatario")
    public void DeleteSairSubAreaDestinatario( 
    		@WebParam(name="idSubArea")BigDecimal idSubArea,
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
    		OperacionesAreas Obj_Operaciones = new OperacionesAreas();
    		Obj_Operaciones.DeleteSairSubAreaDestinatario(idSubArea);
    		aux=false;
    	}
    }
}