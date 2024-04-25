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

public class ws_sairparametros {
 
    /**
     * Web service operation
     */
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	

	@WebMethod(operationName = "ConsultaSairParametros")
    public List<SairParametros> ConsultaSairParametros(@WebParam(name="IdParametro")BigDecimal IdParametro) throws Exception {
    	
    	OperacionesSairParametros Obj_Operaciones = new OperacionesSairParametros();
    	List<SairParametros> SairParametrosList = new ArrayList<SairParametros>();
    	SairParametrosList = Obj_Operaciones.ConsultaSairParametros(IdParametro);
    	
    	return SairParametrosList;
    	
    }

	@WebMethod(operationName = "ConsultaPadreParametro")
    public List<SairParametros> ConsultaPadreParametro(@WebParam(name="IdPadre")BigDecimal IdPadre) throws Exception {
    	
    	OperacionesSairParametros Obj_Operaciones = new OperacionesSairParametros();
    	List<SairParametros> SairPadreList = new ArrayList<SairParametros>();
    	SairPadreList = Obj_Operaciones.ConsultaPadre(IdPadre);
    	
    	return SairPadreList;
    	
    }
    

	@WebMethod(operationName = "FindSairParametros")
    public List<SairParametros> FindSairParametros(@WebParam(name="HqlParametros")String HqlParametros) throws Exception {
    	
    	OperacionesSairParametros Obj_Operaciones = new OperacionesSairParametros();
    	List<SairParametros> ListSairParametros = new ArrayList<SairParametros>();
    	ListSairParametros = Obj_Operaciones.FindSairParametros(HqlParametros);
    	
    	return ListSairParametros;
    	
	}
	
	@WebMethod(operationName = "IngresaSairParametros")
    public List<Mensaje> IngresaSairParametros(@WebParam(name="IdParametro")BigDecimal idParametro, @WebParam(name="Nombre")String nombre, @WebParam(name="Detalle")String detalle, @WebParam(name="Valor")String valor, @WebParam(name="UsuarioIngreso")String UsuarioIngreso, @WebParam(name="FechaInicio")Date FechaInicio, @WebParam(name="UsuarioModificacion")String UsuarioModificacion, @WebParam(name="FechaModificacion")Date fechaModificacion, @WebParam(name="Estado")String Estado, @WebParam(name="ValorNumerico")BigDecimal valorNumerico, @WebParam(name="IdPadre")BigDecimal idPadre, @WebParam(name="TipoTransc")int TipoTransc,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion) throws Exception {

		OperacionesSairParametros Obj_Operaciones = new OperacionesSairParametros();
    	List<Mensaje> mensajeList = new ArrayList<Mensaje>();
    	mensajeList = Obj_Operaciones.IngresaSairParametros(idParametro, nombre, detalle, valor, UsuarioIngreso, FechaInicio, UsuarioModificacion, fechaModificacion, Estado, valorNumerico, idPadre, TipoTransc);
    	aux=false;
    	return mensajeList;
    }
	
    
}