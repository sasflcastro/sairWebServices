package ec.com.rgt.sair.ws;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.controller.OperacionesSairDocComplementos;
import ec.com.rgt.sair.controller.OperacionesUnidad;
import ec.com.rgt.sair.dao.Conexion;
import ec.com.rgt.sair.dao.ConexionADAM;
import ec.com.rgt.sair.dao.PlanAnualAic;
import ec.com.rgt.sair.hbm.SairEstadoComplementario;
import ec.com.rgt.sair.hbm.SairEstadoReco;
import ec.com.rgt.sair.hbm.SairEstados;
import ec.com.rgt.sair.hbm.SairParUnidadRutina;

@WebService()
public class ws_conexionAdam {
	 Boolean aux=false;
	 LdapAutenticationWS ws=new LdapAutenticationWS();

	 OperacionesUnidad unidad=new OperacionesUnidad();
	  

	 	@WebMethod(operationName = "updateUsuarios")
	    public void updateUsuarios() throws URISyntaxException, IOException, InterruptedException {
	 		System.out.println("INICIAL EL METODO UPDATE USUARIOS");
	 		//ConexionADAM.updateDepartamentos();
	    	ConexionADAM.updateUsuarios();
	    	//ConexionADAM.updateUsuariosAD();
	    }
	 	
	 	@WebMethod(operationName = "getPlanAnualAIC")
	    public List<PlanAnualAic> getPlanAnualAIC(@WebParam(name="anio")int anio,@WebParam(name="mes")int mes) {
	 		//Conexion conexion=new Conexion();
	 		List<PlanAnualAic> list=Conexion.getPlanAnualAIC(anio, mes);
			return list;
	    }
	 	
	 	 @WebMethod(operationName = "IngresaEstadoComplementario")
	     public List<Mensaje> IngresaEstadoComplementario(@WebParam(name="complementario")SairEstadoComplementario complementario,
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
	     	OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
	     	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
	     	ListMensaje = Obj_Operaciones.IngresaEstadoComplementario(complementario, TipoTransc);
	     	aux=false;
	     	return ListMensaje;
	     	}else{
	         	return null;
	         }
	     }
	     
	     @WebMethod(operationName = "IngresaEstadoReco")
	     public List<Mensaje> IngresaEstadoReco(@WebParam(name="estadoReco")SairEstadoReco estadoReco,
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
	     	OperacionesSairDocComplementos Obj_Operaciones = new OperacionesSairDocComplementos();
	     	List<Mensaje> ListMensaje = new ArrayList<Mensaje>();
	     	ListMensaje = Obj_Operaciones.IngresaEstadoReco(estadoReco, TipoTransc);
	     	aux=false;
	     	return ListMensaje;
	     	}else{
	         	return null;
	         }
	     }
	     
	     @WebMethod(operationName = "regularizaDiscusion")
		    public void regularizaDiscusion() {
	    	 	Conexion.CallProcessRegularizaDiscusion();
		    }
	     
	     //unida rutina
	 	
	 	@WebMethod(operationName = "findUnidadRutina")
	 	public List<SairParUnidadRutina> findUnidadRutina(@WebParam(name="hql")String hql){
	 		return unidad.findUnidadRutina(hql);
	 	}

	 	@WebMethod(operationName = "deleteUnidadRutina")
	 	public int deleteUnidadRutina(@WebParam(name="idSubArea")BigDecimal idSubArea,@WebParam(name="idRutina")BigDecimal idRutina){
	 		return unidad.deleteUnidadRutina(idSubArea, idRutina);
	 	}
	 	
	 	@WebMethod(operationName = "insertUnidadRutina")
	 	public int insertUnidadRutina(@WebParam(name="parUnidadRutina")SairParUnidadRutina parUnidadRutina){
	 		return unidad.insertUnidadRutina(parUnidadRutina);
	 	}
	 	
	 	@WebMethod(operationName="buscarEstadosReco")
	 	public List<SairEstados> BuscarEstadosSair(){
	 		return unidad.buscarEstadosReco();
	 	}
	 	
	 	@WebMethod(operationName="getReporte")
	 	public String getReporte(String usuario,String idEstado,String idSubArea,String idDepartamento){
	 		return Conexion.getReporte(usuario, idEstado, idSubArea, idDepartamento);
	 	}
	 	
	 	@WebMethod(operationName = "insRecMonoInf")
	    public void recMonoInf() {
    	 	Conexion.CallProcessRecMonoInf();
	    }
}
