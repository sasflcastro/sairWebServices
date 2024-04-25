package ec.com.rgt.sair.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.dao.Conexion;
import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.hbm.ActaAvance;
import ec.com.rgt.sair.hbm.SairActaComentario;
import ec.com.rgt.sair.hbm.SairActaCorresponsable;
import ec.com.rgt.sair.hbm.SairActaEstatus;
import ec.com.rgt.sair.hbm.SairActaProyecto;
import ec.com.rgt.sair.hbm.SairActaTipo;
import ec.com.rgt.sair.hbm.SairActaTipos;

@WebService()
public class Ws_Actas {

	@WebMethod(operationName = "ingresaProyecto")
	public int ingresaProyecto(@WebParam(name = "proyecto") SairActaProyecto proyecto,
			@WebParam(name = "tipo") int tipo) {
		DAO dao = new DAO();
		if (tipo == 0) {
			return dao.saveOrUpdate(proyecto, proyecto.getClass());
		} else {
			return dao.delete(proyecto, proyecto.getClass());
		}
	}

	@WebMethod(operationName = "ingresaTipoActa")
	public int ingresaTipoActa(@WebParam(name = "tipoActa") SairActaTipos tipoActa, @WebParam(name = "tipo") int tipo) {
		DAO dao = new DAO();
		if (tipo == 0) {
			return dao.saveOrUpdate(tipoActa, tipoActa.getClass());
		} else {
			return dao.delete(tipoActa, tipoActa.getClass());
		}
	}

	@WebMethod(operationName = "ingresaCorresponsable")
	public int ingresaCorresponsable(@WebParam(name = "corresponsable") SairActaCorresponsable corresponsable,
			@WebParam(name = "tipo") int tipo) {
		DAO dao = new DAO();
		if (tipo == 0) {
			return dao.saveOrUpdate(corresponsable, corresponsable.getClass());
		} else {
			return dao.delete(corresponsable, corresponsable.getClass());
		}
	}

	@WebMethod(operationName = "ingresaComentario")
	public int ingresaComentario(@WebParam(name = "corresponsable") SairActaComentario comentario,
			@WebParam(name = "tipo") int tipo) {
		DAO dao = new DAO();
		if (tipo == 0) {
			return dao.saveOrUpdate(comentario, comentario.getClass());
		} else {
			return dao.delete(comentario, comentario.getClass());
		}
	}

	@SuppressWarnings("unchecked")
	@WebMethod(operationName = "ConsultaProyecto")
	public List<SairActaProyecto> ConsultaProyecto(@WebParam(name = "hql") String hql) {
		DAO dao = new DAO();
		return dao.find(hql);
	}

	@SuppressWarnings("unchecked")
	@WebMethod(operationName = "ConsultaEstatus")
	public List<SairActaEstatus> ConsultaEstatus() {
		DAO dao = new DAO();
		return dao.find("from SairActaEstatus a where a.estado='A' order by a.nobre");
	}

	@SuppressWarnings("unchecked")
	@WebMethod(operationName = "ConsultaTipo")
	public List<SairActaTipo> ConsultaTipo() {
		DAO dao = new DAO();
		return dao.find("from SairActaTipo a where a.estado='A'");
	}

	@SuppressWarnings("unchecked")
	@WebMethod(operationName = "ConsultaTipoActa")
	public List<SairActaTipos> ConsultaTipoActa() {
		DAO dao = new DAO();
		return dao.find("from SairActaTipos a where a.estado='A'");
	}

	@SuppressWarnings("unchecked")
	@WebMethod(operationName = "ConsultaCorresponsable")
	public List<SairActaCorresponsable> ConsultaCorresponsable(@WebParam(name = "hql") String hql) {
		DAO dao = new DAO();
		return dao.find(hql);
	}

	@SuppressWarnings("unchecked")
	@WebMethod(operationName = "ConsultaComentario")
	public List<SairActaComentario> ConsultaComentario(@WebParam(name = "hql") String hql) {
		DAO dao = new DAO();
		return dao.find(hql);
	}

	@WebMethod(operationName = "NotificarComentario")
	public List<SairActaProyecto> NotificarComentario(@WebParam(name = "usuario") String usuario) {
		return Conexion.getNotificaComentario(usuario);
	}

	public List<Mensaje> getFechas(@WebParam(name = "id_proyecto") int id_proyecto, @WebParam(name = "mes") int mes) {
		DAO dao = new DAO();
		@SuppressWarnings("rawtypes")
		List result = dao.findNative(
				"select to_char(c.fecha_ingreso,'MM/YYYY') from sair_acta_comentario c where c.id_proyecto= "
						+ id_proyecto + " and to_number(to_char(c.fecha_ingreso,'MM'))<" + mes
						+ " and to_char(c.fecha_ingreso,'YYYY')=to_char(sysdate,'YYYY') group by to_char(c.fecha_ingreso,'MM/YYYY')");
		if (!(result.isEmpty() || result.get(
				0) instanceof Object[])) {/*
											 * // Several columns in the result List<Object[]> resultList =
											 * (List<Object[]>) result; // The rest of your current code here } else {
											 */
			// Only one column in the result
			@SuppressWarnings("unchecked")
			List<Object> resultList = (List<Object>) result;
			List<Mensaje> list = new ArrayList<Mensaje>();
			for (Object object : resultList) {
				Mensaje mensaje = new Mensaje();
				mensaje.setMensaje((String) object);
				mensaje.setIdMensaje(id_proyecto);
				list.add(mensaje);
			}
			return list;
		}
		return null;
	}
	
	@WebMethod(operationName = "ingresaAvance")
	public int ingresaAvance(@WebParam(name = "actaAvance") ActaAvance actaAvance) {
		DAO dao = new DAO();
		return dao.saveOrUpdate(actaAvance, ActaAvance.class);
	}
	

}
