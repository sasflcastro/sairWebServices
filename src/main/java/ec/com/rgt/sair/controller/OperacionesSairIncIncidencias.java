package ec.com.rgt.sair.controller;

import java.util.ArrayList;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairIncIncidenciasDAO;
import ec.com.rgt.sair.hbm.SairIncIncidencia;
import ec.com.rgt.sair.hbm.SairIncTipo;
import ec.com.rgt.sair.hbm.TblProceAmx;
import ec.com.rgt.sair.hbm.TblProceAmxEnvia;

public class OperacionesSairIncIncidencias 
{
	SairIncIncidenciasDAO objSairIncIncidencias = new SairIncIncidenciasDAO();
	
	public List<SairIncIncidencia>FindSairIncIncidencias(String hqlInc)
	 {
		List<SairIncIncidencia> lstSairIncidencias = new ArrayList<SairIncIncidencia>();
		lstSairIncidencias = objSairIncIncidencias
				.findIncIncidencias(hqlInc);
		return lstSairIncidencias;
	 }
	public List<SairIncTipo>FindSairIncTipoIncidencias(String hqlInc)
	 {
		List<SairIncTipo> lstSairTipoIncidencias = new ArrayList<SairIncTipo>();
		lstSairTipoIncidencias = objSairIncIncidencias
				.findIncTipo(hqlInc);
		return lstSairTipoIncidencias;
	 }
	
	public List<TblProceAmx>findTblAmx(String hqlAmxs)
	 {
		List<TblProceAmx> lstTblAmxs = new ArrayList<TblProceAmx>();
		lstTblAmxs = objSairIncIncidencias.findAmxs(hqlAmxs);
		return lstTblAmxs;
	 }
	
	public List<TblProceAmxEnvia>findTblAmxsEnvia(String hqlAmxE)
	 {
		List<TblProceAmxEnvia> lstTblAmxsE = new ArrayList<TblProceAmxEnvia>();
		lstTblAmxsE = objSairIncIncidencias.findAmxEnvias(hqlAmxE);
		return lstTblAmxsE;
	 }
	
	public List<Mensaje> IngresaTblProceAmx(TblProceAmx tblProceAmx, int TipoTransc){
		DAO dao = new DAO();
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(tblProceAmx, tblProceAmx.getClass());
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
	
	public List<Mensaje> IngresaSairIncIncidencias(SairIncIncidencia sairIncIncidencia, int TipoTransc){
		DAO dao = new DAO();
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairIncIncidencia, sairIncIncidencia.getClass());
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
