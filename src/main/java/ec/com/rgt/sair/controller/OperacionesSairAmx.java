package ec.com.rgt.sair.controller;

import java.util.ArrayList;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairAmxDAO;
import ec.com.rgt.sair.hbm.SairAmxDocumento;
import ec.com.rgt.sair.hbm.SairAmxUnidMedMacro;
import ec.com.rgt.sair.hbm.SairAmxUnidadMedida;

public class OperacionesSairAmx {
	DAO dao = new DAO();
	SairAmxDAO ObjSairAmxDAO = new SairAmxDAO();
	public List<SairAmxUnidadMedida> FindSairAmxUnidadMedida(String hqlSairAmxUnidadMedida)
			throws Exception {
		List<SairAmxUnidadMedida> LstSairAmxUnidadMedida = new ArrayList<SairAmxUnidadMedida>();
		LstSairAmxUnidadMedida = ObjSairAmxDAO.findSairAmxUnidadMedida(hqlSairAmxUnidadMedida);
		return LstSairAmxUnidadMedida;
	}
	public List<SairAmxDocumento> FindSairAmxDocumento(String hqlSairAmxDocumento)
			throws Exception {
		List<SairAmxDocumento> LstSairAmxDocumento = new ArrayList<SairAmxDocumento>();
		LstSairAmxDocumento = ObjSairAmxDAO.findSairAmxDocumento(hqlSairAmxDocumento);
		return LstSairAmxDocumento;
	}
	public List<Mensaje> SaveOrUpdateSairAmxUnidadMedida(SairAmxUnidadMedida obj_SairAmxUnidadMedida,int TipoTransc) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(obj_SairAmxUnidadMedida,
				obj_SairAmxUnidadMedida.getClass());
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
	public List<Mensaje> SaveOrUpdateSairAmxDocumento(SairAmxDocumento obj_SairAmxDocumento,int TipoTransc) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(obj_SairAmxDocumento,
				obj_SairAmxDocumento.getClass());
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
	
	public List<SairAmxUnidMedMacro> FindSairAmxUnidMedMacro(String hqlSairAmxUnidMedMacro)
			throws Exception {
		List<SairAmxUnidMedMacro> LstSairAmxUnidMedMacro = new ArrayList<SairAmxUnidMedMacro>();
		LstSairAmxUnidMedMacro = ObjSairAmxDAO.findSairAmxUnidMedMacro(hqlSairAmxUnidMedMacro);
		return LstSairAmxUnidMedMacro;
	}
}
