package ec.com.rgt.sair.controller;

import java.util.ArrayList;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairObservacionesDAO;
import ec.com.rgt.sair.hbm.SairCiudad;
import ec.com.rgt.sair.hbm.SairObsAccionAdm;
import ec.com.rgt.sair.hbm.SairObsComentarioAic;
import ec.com.rgt.sair.hbm.SairObsDetallesFaltas;
import ec.com.rgt.sair.hbm.SairObsTipoFalta;
import ec.com.rgt.sair.hbm.SairObservaciones;
import ec.com.rgt.sair.hbm.SairPlantillas;

public class OperacionesSairObservaciones {

	
	SairObservacionesDAO ObjSairObservaciones = new SairObservacionesDAO();

	public List<SairObservaciones> FindSairObservaciones(String hqlObserv)  {
		List<SairObservaciones> lstSairDocObservaciones = new ArrayList<SairObservaciones>();
		// UtilsDAO.savelog("SEGURIDAD", "CRON", "start", "JobBriefCD2 entro",48, "",user, 3,user,clave,autent);
		lstSairDocObservaciones = ObjSairObservaciones
				.findObservaciones(hqlObserv);
		return lstSairDocObservaciones;
	}

	public List<SairObservaciones> FindSairReporteBrief(String hqlObserv)  {
		List<SairObservaciones> lstSairDocObservaciones = new ArrayList<SairObservaciones>();
		lstSairDocObservaciones = ObjSairObservaciones
				.findReporteBrief(hqlObserv);
		return lstSairDocObservaciones;
	}
	
	public List<SairObsComentarioAic> FindObsComentarioAic(String hqlObsComentarioAic)  {
		List<SairObsComentarioAic> lstSairObsComentarioAic = new ArrayList<SairObsComentarioAic>();
		lstSairObsComentarioAic = ObjSairObservaciones
				.findObsComentarioAic(hqlObsComentarioAic);
		return lstSairObsComentarioAic;
	}
	
	public List<SairObsDetallesFaltas> FindObsDetallesFaltas(String hqlObsDetallesFaltas)  {
		List<SairObsDetallesFaltas> lstSairObsDetallesFaltas = new ArrayList<SairObsDetallesFaltas>();
		lstSairObsDetallesFaltas = ObjSairObservaciones
				.findObsDetallesFaltas(hqlObsDetallesFaltas);
		return lstSairObsDetallesFaltas;
	}
	
	public List<SairObsAccionAdm> FindObsAccionAdm(String hqlObsAccionAdm)  {
		List<SairObsAccionAdm> lstSairObsAccionAdm = new ArrayList<SairObsAccionAdm>();
		lstSairObsAccionAdm = ObjSairObservaciones
				.findObsAccionAdm(hqlObsAccionAdm);
		return lstSairObsAccionAdm;
	}

	public List<SairPlantillas> findSairPlantillas(String hqlPlantilla)
			 {
		List<SairPlantillas> lstSairPlantillas = new ArrayList<SairPlantillas>();
		lstSairPlantillas = ObjSairObservaciones
				.findPlantillas(hqlPlantilla);
		return lstSairPlantillas;
	}
	
	public List<SairCiudad> findSairCiudad(String hqlCiudad)
			 {
		List<SairCiudad> lstSairCiudad = new ArrayList<SairCiudad>();
		lstSairCiudad = ObjSairObservaciones.findCiudad(hqlCiudad);
		return lstSairCiudad;
	}
	
	public List<SairObsTipoFalta> findSairObsTipoFalta(String hqlTipoFalta)
			 {
		List<SairObsTipoFalta> lstSairObsTipoFalta = new ArrayList<SairObsTipoFalta>();
		lstSairObsTipoFalta = ObjSairObservaciones.findObsTipoFalta(hqlTipoFalta);
		return lstSairObsTipoFalta;
	}
	
	
	
	public List<Mensaje> IngresaSairObservaciones(SairObservaciones sairObservaciones, int TipoTransc)  {
		DAO dao = new DAO();
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairObservaciones, sairObservaciones.getClass());
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
	
	public List<Mensaje> IngresaSairCiudad(SairCiudad sairCiudad, int TipoTransc)  {
		DAO dao = new DAO();
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairCiudad, sairCiudad.getClass());
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
	
	
	public List<Mensaje> IngresaSairObsTipoFalta(SairObsTipoFalta sairObsTipoFalta, int TipoTransc)  {
		DAO dao = new DAO();
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairObsTipoFalta, sairObsTipoFalta.getClass());
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
	
	public List<Mensaje> IngresaSairObsAccionADM(SairObsAccionAdm sairObsAccionAdm, int TipoTransc)  {
		DAO dao = new DAO();
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairObsAccionAdm, sairObsAccionAdm.getClass());
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
	
	
	public List<Mensaje> IngresaSairObsComentarioAic(SairObsComentarioAic sairObsComentarioAic, int TipoTransc)  {
		DAO dao = new DAO();
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairObsComentarioAic, sairObsComentarioAic.getClass());
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
