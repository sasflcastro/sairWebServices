package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairFrecuenciaComentarioDAO;
import ec.com.rgt.sair.hbm.SairFrecuencia;
import ec.com.rgt.sair.hbm.SairParComentarioRutina;

public class OperacionesSair_FrecuenciaComentario {

	DAO dao = new DAO();
	SairFrecuenciaComentarioDAO ObjSairParRutina = new SairFrecuenciaComentarioDAO();
	
	public List<SairFrecuencia> findFrecuencia(String hqlFrecuencia)
			throws Exception {
		List<SairFrecuencia> LstSairFrecuencia = new ArrayList<SairFrecuencia>();
		LstSairFrecuencia = ObjSairParRutina.findFrecuencia(hqlFrecuencia);
		return LstSairFrecuencia;
	}
	
	public List<SairParComentarioRutina> findComentario(String hqlComentario)
			throws Exception {
		List<SairParComentarioRutina> LstSairComentario = new ArrayList<SairParComentarioRutina>();
		LstSairComentario = ObjSairParRutina.findComentario(hqlComentario);
		return LstSairComentario;
	}
	
	public List<Mensaje> IngresaFrecuencia(BigDecimal idFrecuencia,
			String nombreFrecuencia,int TipoTransc) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairFrecuencia obj_SairParD= new SairFrecuencia();
		obj_SairParD.setIdFrecuencia(idFrecuencia);
		obj_SairParD.setNombreFrecuencia(nombreFrecuencia);
		obj_SairParD.setEstado("A");
		int estado = dao.saveOrUpdate(obj_SairParD,
				obj_SairParD.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado == 1) {
			Obj_Mensaje.setIdMensaje(1);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Ingreso Exitoso");

			} else {

				Obj_Mensaje.setMensaje("Actualizacion Exitosa");

			}

		} else {
			Obj_Mensaje.setIdMensaje(0);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Ingreso Fallido");

			} else {

				Obj_Mensaje.setMensaje("Actualizacion Fallida");

			}
		}
		LstMensaje.add(Obj_Mensaje);
		return LstMensaje;
	}
	
	public List<Mensaje> IngresaParComenatrio(BigDecimal idComentario,
			String observacion, String est, int TipoTransc) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairParComentarioRutina obj_SairParD= new SairParComentarioRutina();
		
		obj_SairParD.setIdComentario(idComentario);
		obj_SairParD.setObservacion(observacion);
		obj_SairParD.setEstado(est);
		
		int estado = dao.saveOrUpdate(obj_SairParD,
				obj_SairParD.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado == 1) {
			Obj_Mensaje.setIdMensaje(1);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Ingreso Exitoso");

			} else {

				Obj_Mensaje.setMensaje("Actualizacion Exitosa");

			}

		} else {
			Obj_Mensaje.setIdMensaje(0);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Ingreso Fallido");

			} else {

				Obj_Mensaje.setMensaje("Actualizacion Fallida");

			}
		}
		LstMensaje.add(Obj_Mensaje);
		return LstMensaje;
	}
	
}
