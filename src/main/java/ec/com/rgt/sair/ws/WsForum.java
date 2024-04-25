package ec.com.rgt.sair.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.com.rgt.sair.controller.OperacionesPantalla;
import ec.com.rgt.sair.dao.OperacionesForum;
import ec.com.rgt.sair.hbm.SairForumQuestions;
import ec.com.rgt.sair.hbm.SairForumRespuesta;
import ec.com.rgt.sair.hbm.SairForumTag;
import ec.com.rgt.sair.hbm.SairPantalla;
import ec.com.rgt.sair.hbm.SairPantallaUsuario;

@WebService()
public class WsForum {
	OperacionesForum forum= new OperacionesForum();
	
	@WebMethod(operationName = "findTag")
	public List<SairForumTag> findTag(@WebParam(name="hql")String hql){
		return forum.findTag(hql);
	}
	
	@WebMethod(operationName = "findQuestion")
	public List<SairForumQuestions> findQuestion(@WebParam(name="hql")String hql){
		return forum.findQuestion(hql);
	}
	
	@WebMethod(operationName = "findRespuesta")
	public List<SairForumRespuesta> findRespuesta(@WebParam(name="hql")String hql){
		return forum.findRespuesta(hql);
	}
	
	@WebMethod(operationName = "SaveOrDateTag")
	public int SaveOrDateTag(@WebParam(name="tag")SairForumTag tag){
		return forum.SaveOrDateTag(tag);
	}
	
	@WebMethod(operationName = "SaveOrDateQuestions")
	public int SaveOrDateQuestions(@WebParam(name="questions")SairForumQuestions questions){
		return forum.SaveOrDateQuestions(questions);
	}
	
	@WebMethod(operationName = "SaveOrDateRespuesta")
	public int SaveOrDateRespuesta(@WebParam(name="respuesta")SairForumRespuesta respuesta){
		return forum.SaveOrDateRespuesta(respuesta);
	}
	
	@WebMethod(operationName = "findPantalla")
	public List<SairPantalla> findPantalla(@WebParam(name="hql")String hql){
		OperacionesPantalla pantalla=new OperacionesPantalla();
		return pantalla.findPantalla(hql);
	}
	
	@WebMethod(operationName = "findPantallaUsuario")
	public List<SairPantallaUsuario> findPantallaUsuario(@WebParam(name="hql")String hql){
		OperacionesPantalla pantalla=new OperacionesPantalla();
		return pantalla.findPantallaUsuario(hql);
	}
	
	@WebMethod(operationName = "saveOrdatePantallaUsuario")
	public int saveOrdatePantallaUsuario(@WebParam(name="pantallaUsuario")SairPantallaUsuario pantallaUsuario){
		OperacionesPantalla pantalla=new OperacionesPantalla();
		return pantalla.saveOrdatePantallaUsuario(pantallaUsuario);
	}
	
	@WebMethod(operationName = "deletePantallaUsuario")
	public int deletePantallaUsuario(@WebParam(name="idUsuario")String idUsuario,@WebParam(name="idPantalla")String idPantalla){
		OperacionesPantalla pantalla=new OperacionesPantalla();
		if(idPantalla==null){
			return pantalla.deletePantallaUsuario(idUsuario);
		}else{
			return pantalla.deletePantallaUsuario(idUsuario,idPantalla);
		}
		
	}
}
