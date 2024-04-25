package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairFormatoDAO;
import ec.com.rgt.sair.hbm.SairFormato;

public class OperacionesSairFormato {

	DAO dao = new DAO();
	SairFormatoDAO ObjSairFormato = new SairFormatoDAO();
	
	
	public List<SairFormato> FindSairFormato(String hqlFormato) {
		List<SairFormato> LstSairFormato = new ArrayList<SairFormato>();
		LstSairFormato = ObjSairFormato.findFormato(hqlFormato);
		return LstSairFormato;
	}

	public List<Mensaje> IngresaSairFormato(BigDecimal idFormato,
			String tabla, String campos, BigDecimal orden, String estadof,String obligatorio,int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairFormato obj_SairFormato = new SairFormato();
		obj_SairFormato.setIdFormato(idFormato);
		obj_SairFormato.setTabla(tabla);
		obj_SairFormato.setCampos(campos);
		obj_SairFormato.setOrden(orden);
		obj_SairFormato.setEstado(estadof);
		obj_SairFormato.setObligatorio(obligatorio);
		int estado = dao.saveOrUpdate(obj_SairFormato,
				obj_SairFormato.getClass());
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
	
	public List<Mensaje> DeleteSairFormato(BigDecimal idFormato,
			String tabla, String campos, BigDecimal orden, String estadof,String obligatorio,int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairFormato obj_SairFormato = new SairFormato();
		obj_SairFormato.setIdFormato(idFormato);
		obj_SairFormato.setTabla(tabla);
		obj_SairFormato.setCampos(campos);
		obj_SairFormato.setOrden(orden);
		obj_SairFormato.setEstado(estadof);
		obj_SairFormato.setObligatorio(obligatorio);
		int estado = dao.delete(obj_SairFormato,
				obj_SairFormato.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado == 1) {
			Obj_Mensaje.setIdMensaje(1);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Eliminacion Exitoso");

			} else {

				Obj_Mensaje.setMensaje("Eliminacion Exitosa");

			}

		} else {
			Obj_Mensaje.setIdMensaje(0);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Eliminacion Fallido");

			} else {

				Obj_Mensaje.setMensaje("Eliminacion Fallida");

			}
		}
		LstMensaje.add(Obj_Mensaje);
		return LstMensaje;
	}
}
