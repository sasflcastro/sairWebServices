package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairParCheckListDAO;
import ec.com.rgt.sair.hbm.SairDocConRiesgo;
import ec.com.rgt.sair.hbm.SairDocImpacto;
import ec.com.rgt.sair.hbm.SairDocPrioridad;
import ec.com.rgt.sair.hbm.SairParCheckList;
import ec.com.rgt.sair.hbm.SairParCheckListCabecera;
import ec.com.rgt.sair.hbm.SairParDetalleCheckList;

public class OperacionesSairParCheckList {

	DAO dao = new DAO();
	SairParCheckListDAO Obj_SairParCheckListDAO = new SairParCheckListDAO();

	public List<SairParCheckList> FindSairParCheckList(String HqlCheckList)
			{
		List<SairParCheckList> LstSairParCheckList = new ArrayList<SairParCheckList>();
		LstSairParCheckList = Obj_SairParCheckListDAO.findCheckList(HqlCheckList);
		return LstSairParCheckList;
	}

	public List<Mensaje> IngresaSairParCheckList(SairParCheckList obj_SairParCheckList, int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();		
		int est = dao.saveOrUpdate(obj_SairParCheckList,obj_SairParCheckList.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (est == 1) {
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
	
	
	/*********************************************/
	
	public List<SairParCheckListCabecera> FindSairParCheckListCabecera(String HqlCabCheckList)
			{
		List<SairParCheckListCabecera> LstSairParCheckListCab = 
				new ArrayList<SairParCheckListCabecera>();
		LstSairParCheckListCab = Obj_SairParCheckListDAO.findCabCheckList(HqlCabCheckList);
		return LstSairParCheckListCab;
	}

	public List<Mensaje> IngresaSairParCheckListCabecera(BigDecimal cabId, String cabNombre,
			Date cabFecha, String est, int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairParCheckListCabecera obj_SairParCheckListCab = new SairParCheckListCabecera();
		obj_SairParCheckListCab.setCabId(cabId);
		obj_SairParCheckListCab.setCabNombre(cabNombre);
		obj_SairParCheckListCab.setCabFecha(cabFecha);
		obj_SairParCheckListCab.setEstado(est);
		
		int estado = dao.saveOrUpdate(obj_SairParCheckListCab,obj_SairParCheckListCab.getClass());
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
	
	public List<SairDocConRiesgo> findConclusionRiesgo(String HqlConRiesgo){
		List<SairDocConRiesgo> LstSairParCheckListDet = new ArrayList<SairDocConRiesgo>();
		LstSairParCheckListDet = Obj_SairParCheckListDAO.findConclusionRiesgo(HqlConRiesgo);
		return LstSairParCheckListDet;
	}
	
	
	public List<SairDocPrioridad> findPrioridad(String HqlPrioridad){
		List<SairDocPrioridad> LstSairParCheckListDet = new ArrayList<SairDocPrioridad>();
		LstSairParCheckListDet = Obj_SairParCheckListDAO.findPrioridad(HqlPrioridad);
		return LstSairParCheckListDet;
	}
	
	public List<SairDocImpacto> findImpacto(String HqlImpacto){
		List<SairDocImpacto> LstSairParCheckListDet = new ArrayList<SairDocImpacto>();
		LstSairParCheckListDet = Obj_SairParCheckListDAO.findImpacto(HqlImpacto);
		return LstSairParCheckListDet;
	}
	
	/*********************************************/

	public List<SairParDetalleCheckList> FindSairParCheckListDetalle(String HqlDetCheckList)
			{
		List<SairParDetalleCheckList> LstSairParCheckListDet = new ArrayList<SairParDetalleCheckList>();
		LstSairParCheckListDet = Obj_SairParCheckListDAO.findDetCheckList(HqlDetCheckList);
		return LstSairParCheckListDet;
	}

	public List<Mensaje> IngresaSairParCheckListDetalle(BigDecimal idDetalle,
			SairParCheckList sairParCheckList, BigDecimal orden, String nombre,
			String observaciones,Date fecha, String est, int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairParDetalleCheckList obj_SairParCheckListDet = new SairParDetalleCheckList();
		obj_SairParCheckListDet.setIdDetalle(idDetalle);
		obj_SairParCheckListDet.setSairParCheckList(sairParCheckList);
		obj_SairParCheckListDet.setOrden(orden);
		obj_SairParCheckListDet.setNombre(nombre);
		obj_SairParCheckListDet.setObservaciones(observaciones);
		obj_SairParCheckListDet.setFecha(fecha);
		obj_SairParCheckListDet.setEstado(est);
		
		int estado = dao.saveOrUpdate(obj_SairParCheckListDet,obj_SairParCheckListDet.getClass());
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
	
	
	public List<Mensaje> IngresaSairDocConRiesgo( SairDocConRiesgo conRiesgo ,int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(conRiesgo,conRiesgo.getClass());
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
	
	@SuppressWarnings("unchecked")
	public void DeleteSairDocConRiesgo( BigDecimal idConclusion) {
		List<SairDocConRiesgo> LstMensaje = new ArrayList<SairDocConRiesgo>();
		LstMensaje=dao.find("from SairDocConRiesgo s where s.sairDocConclusionDocumento.idConclusionDocumento="+idConclusion);
		for (int i = 0; i < LstMensaje.size(); i++) {
			SairDocConRiesgo conRiesgo=LstMensaje.get(i);
			dao.delete(conRiesgo,conRiesgo.getClass());
		}

	}

}
