package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairAreaDAO;
import ec.com.rgt.sair.hbm.SairArea;
import ec.com.rgt.sair.hbm.SairAreasAdam;
import ec.com.rgt.sair.hbm.SairSubArea;
import ec.com.rgt.sair.hbm.SairSubAreaDestinatario;

public class OperacionesAreas {

	DAO dao = new DAO();
	SairAreaDAO Obj_AreaDAO = new SairAreaDAO();

	@SuppressWarnings("unchecked")
	public List<SairArea> ListaAreas() throws Exception {
		List<SairArea> LstAreas = new ArrayList<SairArea>();
		LstAreas = Obj_AreaDAO.ListaAreas();
		return LstAreas;
	}

	@SuppressWarnings("unchecked")
	public List<SairArea> ConsultaArea(BigDecimal IdArea)
			throws Exception {
		List<SairArea> LstAreas = new ArrayList<SairArea>();
		LstAreas = Obj_AreaDAO
				.ConsultaArea(IdArea);
		return LstAreas;
	}

	@SuppressWarnings("unchecked")
	public List<SairAreasAdam> ConsultaAreaAdam(BigDecimal IdAreaAdam)
			throws Exception {
		List<SairAreasAdam> LstAreasAdam = new ArrayList<SairAreasAdam>();
		LstAreasAdam = Obj_AreaDAO.ConsultaAreaAdam(IdAreaAdam);
		return LstAreasAdam;
	}
	
	@SuppressWarnings("unchecked")
	public List<SairAreasAdam> findAreaAdam(String hqlAreaAdam)
			throws Exception {
		List<SairAreasAdam> LstAreasAdam = new ArrayList<SairAreasAdam>();
		LstAreasAdam = Obj_AreaDAO.findAreasAdam(hqlAreaAdam);
		return LstAreasAdam;
	}
	
	@SuppressWarnings("unchecked")
	public List<SairArea> findAreas(String hqlArea)
			throws Exception {
		List<SairArea> LstAreas = new ArrayList<SairArea>();
		LstAreas = Obj_AreaDAO.findAreas(hqlArea);
		return LstAreas;
	}
	
	@SuppressWarnings("unchecked")
	public List<SairSubArea> findSubAreas(String hqlArea)
			throws Exception {
		List<SairSubArea> LstSubAreas = new ArrayList<SairSubArea>();
		LstSubAreas = Obj_AreaDAO.findSubAreas(hqlArea);
		return LstSubAreas;
	}
	
	@SuppressWarnings("unchecked")
	public List<SairSubAreaDestinatario> findSubAreasDestinatario(String hqlArea)
			throws Exception {
		List<SairSubAreaDestinatario> LstSubAreas = new ArrayList<SairSubAreaDestinatario>();
		LstSubAreas = Obj_AreaDAO.findSubAreas(hqlArea);
		return LstSubAreas;
	}

	public List<Mensaje> IngresaArea(BigDecimal idArea,  String descripcion, String estado, String abreviaturaDep, String abreviaturaArea, String abreviaturaGeneral, String orden, Date fechaIngreso, String jefeArea,String email,String idOperacion, int TipoTransc) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairArea obj_Area = new SairArea();
		obj_Area.setIdArea(idArea);
		obj_Area.setDescripcion(descripcion);
		obj_Area.setEstado(estado);
		obj_Area.setAbreviaturaDep(abreviaturaDep);
		obj_Area.setAbreviaturaArea(abreviaturaArea);
		obj_Area.setAbreviaturaGeneral(abreviaturaGeneral);
		obj_Area.setOrden(orden);
		obj_Area.setFechaIngreso(fechaIngreso);
		obj_Area.setJefeArea(jefeArea);
		obj_Area.setEmail(email);
		obj_Area.setIdOperacion(idOperacion);
		int est = dao.saveOrUpdate(obj_Area,
				obj_Area.getClass());
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
	
	public List<Mensaje> IngresaSairSubAreaE(SairSubArea sairSubArea, int TipoTransc){
		DAO dao = new DAO();
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairSubArea, sairSubArea.getClass());
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

	public List<Mensaje> IngresaSairSubAreaDestinatario(SairSubAreaDestinatario sairSubAreaDestinatario, int TipoTransc){
		DAO dao = new DAO();
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairSubAreaDestinatario, sairSubAreaDestinatario.getClass());
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
	public void DeleteSairSubAreaDestinatario( BigDecimal idSubArea) {
		List<SairSubAreaDestinatario> LstMensaje = new ArrayList<SairSubAreaDestinatario>();
		LstMensaje=dao.find("from SairSubAreaDestinatario s where s.idSubArea="+idSubArea);
		for (int i = 0; i < LstMensaje.size(); i++) {
			SairSubAreaDestinatario conRiesgo=LstMensaje.get(i);
			dao.delete(conRiesgo,conRiesgo.getClass());
		}

	}
}
