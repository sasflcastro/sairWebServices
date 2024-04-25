package ec.com.rgt.sair.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.hbm.ActaAvance;

@WebService()
public class Ws_AvanceProyectos {

	@WebMethod(operationName = "ingresaAvanceProyecto")
	public int ingresaAvanceProyecto(@WebParam(name="ActaAvance") ActaAvance actaAvance){
		DAO dao=new DAO();		
			return dao.saveOrUpdate(actaAvance, ActaAvance.class);		
	}
}
