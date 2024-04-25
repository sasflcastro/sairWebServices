package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairParRutinaDAO;
import ec.com.rgt.sair.hbm.SairConfiguraRutina;
import ec.com.rgt.sair.hbm.SairDocReservacionCodigo;
import ec.com.rgt.sair.hbm.SairMgConfigTablero;
import ec.com.rgt.sair.hbm.SairMgDetalleProcesos;
import ec.com.rgt.sair.hbm.SairMgRutinas;
import ec.com.rgt.sair.hbm.SairMgTableroProcesos;
import ec.com.rgt.sair.hbm.SairParDeficiencia;
import ec.com.rgt.sair.hbm.SairParDetalleRutina;
import ec.com.rgt.sair.hbm.SairParPeriodicidad;
import ec.com.rgt.sair.hbm.SairParPoliticas;
import ec.com.rgt.sair.hbm.SairParProgramaRutina;
import ec.com.rgt.sair.hbm.SairParRutina;
import ec.com.rgt.sair.hbm.SairPoliticaProcedimiento;
import ec.com.rgt.sair.hbm.SairPoliticaProceso;
import ec.com.rgt.sair.hbm.SairPoliticaSubProceso;
import ec.com.rgt.sair.hbm.SairPoliticasRutinas;
import ec.com.rgt.sair.hbm.SairRutinaProceso;
import ec.com.rgt.sair.hbm.SairTipoPlan;

public class OperacionesSairParRutina {

	DAO dao = new DAO();
	SairParRutinaDAO ObjSairParRutina = new SairParRutinaDAO();


	public List<SairParRutina> FindSairParRutina(String hqlRutina)
	{
		List<SairParRutina> LstSairParRutina = new ArrayList<SairParRutina>();
		LstSairParRutina = ObjSairParRutina.findRutina(hqlRutina);
		return LstSairParRutina;
	}

	public List<SairConfiguraRutina> findConfiguraRutina(String hqlConRut)
	{
		List<SairConfiguraRutina> LstSairParRutina = new ArrayList<SairConfiguraRutina>();
		LstSairParRutina = ObjSairParRutina.findConfiguraRutina(hqlConRut);
		return LstSairParRutina;
	}

	public List<SairParDeficiencia> FindSairParDeficiencia(String hqlDeficiencia)
	{
		List<SairParDeficiencia> LstSairParDeficiencia = new ArrayList<SairParDeficiencia>();
		LstSairParDeficiencia = ObjSairParRutina.findDefiencia(hqlDeficiencia);
		return LstSairParDeficiencia;
	}

	public List<SairTipoPlan> findTipoPlan(String hqlTipoPlan)
	{
		List<SairTipoPlan> LstSairParDeficiencia = new ArrayList<SairTipoPlan>();
		LstSairParDeficiencia = ObjSairParRutina.findTipoPlan(hqlTipoPlan);
		return LstSairParDeficiencia;
	}

	public List<SairPoliticaProcedimiento> findProcedimiento(String hqlProcedimiento)
	{
		List<SairPoliticaProcedimiento> LstSair = new ArrayList<SairPoliticaProcedimiento>();
		LstSair = ObjSairParRutina.findProcedimiento(hqlProcedimiento);
		return LstSair;
	}
	public List<SairPoliticaProceso> findProceso(String hqlProceso)
	{
		List<SairPoliticaProceso> LstSair = new ArrayList<SairPoliticaProceso>();
		LstSair = ObjSairParRutina.findProceso(hqlProceso);
		return LstSair;
	}
	public List<SairPoliticaSubProceso> findSubProceso(String hqlSubProceso)
	{
		List<SairPoliticaSubProceso> LstSair = new ArrayList<SairPoliticaSubProceso>();
		LstSair = ObjSairParRutina.findSubProceso(hqlSubProceso); 
		return LstSair;
	}


	public List<SairParProgramaRutina> findProgramaRutina(String hqlPrograma)
	{
		List<SairParProgramaRutina> LstSair = new ArrayList<SairParProgramaRutina>();
		LstSair = ObjSairParRutina.findProgramaRutina(hqlPrograma);
		return LstSair;
	}

	public List<SairParDetalleRutina> findDetalleRutina(String hqlDetalle)
	{
		List<SairParDetalleRutina> LstSair = new ArrayList<SairParDetalleRutina>();
		LstSair = ObjSairParRutina.findDetalleRutina(hqlDetalle);
		return LstSair;
	}

	public List<SairParPeriodicidad> findParPeriodicidad(String hqlPeriodicidad)
	{
		List<SairParPeriodicidad> LstSair = new ArrayList<SairParPeriodicidad>();
		LstSair = ObjSairParRutina.findPeriodicidad(hqlPeriodicidad);
		return LstSair;
	}

	public List<SairRutinaProceso> findRutinaProcesos(String hqlRutPro)
	{
		List<SairRutinaProceso> LstSair = new ArrayList<SairRutinaProceso>();
		LstSair = ObjSairParRutina.findRutinaProceso(hqlRutPro);
		return LstSair;
	}

	public List<Mensaje> IngresaSairParRutina(SairParRutina obj_SairParRutina, int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(obj_SairParRutina,obj_SairParRutina.getClass());
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

	public List<Mensaje> IngresaSairParDeficiencia(BigDecimal idDefi,
			String deficiencia, String est, int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairParDeficiencia obj_SairParD= new SairParDeficiencia();
		obj_SairParD.setIdDeficiencia(idDefi);
		obj_SairParD.setDeficiencia(deficiencia);
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

	public List<Mensaje> IngresaSairTipoPlan(BigDecimal idTipoPlan,
			String nombreTipoPlan, String est, int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairTipoPlan obj_SairParD= new SairTipoPlan();
		obj_SairParD.setIdTipoPlan(idTipoPlan);
		obj_SairParD.setNombreTipoPlan(nombreTipoPlan);
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

	public List<Mensaje> IngresaSairPoliticaProcedimiento(SairPoliticaProcedimiento obj_SairParPoliticaPro, int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(obj_SairParPoliticaPro, obj_SairParPoliticaPro.getClass());
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

	public List<Mensaje> IngresaSairParProgramaRutina(BigDecimal idProgramaRutina,BigDecimal anio,String estad,BigDecimal mes,
			BigDecimal semana1,BigDecimal semana2,BigDecimal semana3,BigDecimal semana4,SairParRutina sairParRutina,BigDecimal idPeriodicidad,int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairParProgramaRutina obj_SairParD= new SairParProgramaRutina();
		obj_SairParD.setIdProgramaRutina(idProgramaRutina);
		obj_SairParD.setAnio(anio);
		obj_SairParD.setEstado(estad);
		obj_SairParD.setMes(mes);
		obj_SairParD.setSemana1(semana1);obj_SairParD.setSemana2(semana2);obj_SairParD.setSemana3(semana3);obj_SairParD.setSemana4(semana4);
		obj_SairParD.setSairParRutina(sairParRutina);
		obj_SairParD.setIdPeriodicidad(idPeriodicidad);
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

	public List<Mensaje> DeleteSairParProgramaRutina(BigDecimal idProgramaRutina,
			BigDecimal anio, BigDecimal mes, BigDecimal semana1,BigDecimal semana2,BigDecimal semana3,
			BigDecimal semana4, String estadof,SairParRutina sairParRutina, int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairParProgramaRutina obj_SairFormato = new SairParProgramaRutina();
		obj_SairFormato.setIdProgramaRutina(idProgramaRutina);
		obj_SairFormato.setAnio(anio);
		obj_SairFormato.setEstado(estadof);
		obj_SairFormato.setMes(mes);
		obj_SairFormato.setSairParRutina(sairParRutina);
		obj_SairFormato.setSemana1(semana1);
		obj_SairFormato.setSemana2(semana2);
		obj_SairFormato.setSemana3(semana3);
		obj_SairFormato.setSemana4(semana4);
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
	public List<Mensaje> IngresaSairParDetalleRutina(BigDecimal idDetalleRutina,SairParRutina sairParRutina
			,SairDocReservacionCodigo sairDocReservacionCodigo,String idAsignado,
			String idEjecutor,Date fechaEjecucion,String afirmaNiega,BigDecimal semanaEmitido,
			String justificado,String Estado,String comentario,BigDecimal anio,BigDecimal mes,int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairParDetalleRutina obj_SairParD= new SairParDetalleRutina();
		obj_SairParD.setIdDetalleRutina(idDetalleRutina);
		obj_SairParD.setSairParRutina(sairParRutina);
		obj_SairParD.setSairDocReservacionCodigo(sairDocReservacionCodigo);
		obj_SairParD.setIdAsignado(idAsignado);
		obj_SairParD.setIdEjecutor(idEjecutor);
		obj_SairParD.setFechaEjecucion(fechaEjecucion);
		obj_SairParD.setAfirmaNiega(afirmaNiega);
		obj_SairParD.setSemanaEmitido(semanaEmitido);
		obj_SairParD.setJustificado(justificado);
		obj_SairParD.setEstado(Estado);
		obj_SairParD.setComentario(comentario);
		obj_SairParD.setAnio(anio);
		obj_SairParD.setMes(mes);
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

	public List<Mensaje> DeleteSairParDetalleRutina(SairParDetalleRutina detalleRutina, int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();

		int estado = dao.delete(detalleRutina,detalleRutina.getClass());
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

	public List<Mensaje> IngresaSairRutinaProceso(SairRutinaProceso sairRutinaProceso, 
			int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();

		int estado = dao.saveOrUpdate(sairRutinaProceso,
				sairRutinaProceso.getClass());
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

	public List<Mensaje> DeleteSairRutinaProceso(SairRutinaProceso sairRutinaProceso, 
			int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();

		int estado = dao.delete(sairRutinaProceso,
				sairRutinaProceso.getClass());
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

	public List<Mensaje> DeleteSairConfiguraRutina(SairConfiguraRutina configuraRutina, 
			int TipoTransc)  {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();

		int estado = dao.delete(configuraRutina,configuraRutina.getClass());
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

	public List<Mensaje> IngresaSairConfiguraRutina(SairConfiguraRutina configuraRutina, 
			int TipoTransc)  {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();

		int estado = dao.saveOrUpdate(configuraRutina,configuraRutina.getClass());
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
	
	
	public List<Mensaje> IngresaSairMgRutina(SairMgRutinas mgRutinas, int TipoTransc){
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(mgRutinas,mgRutinas.getClass());
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
	
	public List<SairMgRutinas> FindSairMgRutina(String hqlMgRutina)
	{
		List<SairMgRutinas> LstSairMgRutinas = new ArrayList<SairMgRutinas>();
		LstSairMgRutinas = ObjSairParRutina.findMgRutina(hqlMgRutina);
		return LstSairMgRutinas;
	}
	
	public List<Mensaje> DeleteSairMgRutinas(SairMgRutinas mgRutina, int TipoTransc)  {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.delete(mgRutina,mgRutina.getClass());
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
	
	public List<Mensaje> IngresaSairMgTableroProceso(SairMgTableroProcesos mgTabProceso, int TipoTransc){
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(mgTabProceso,mgTabProceso.getClass());
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
	
	public List<SairMgTableroProcesos> FindSairMgTableroProceso(String hqlMgTabProceso){
		List<SairMgTableroProcesos> LstSairMgTabProceso = new ArrayList<SairMgTableroProcesos>();
		LstSairMgTabProceso = ObjSairParRutina.findMgTableroProceso(hqlMgTabProceso);
		return LstSairMgTabProceso;
	}
	
	public List<Mensaje> IngresaSairMgDetalleProceso(SairMgDetalleProcesos mgDetalleProceso, int TipoTransc){
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(mgDetalleProceso,mgDetalleProceso.getClass());
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
	
	public List<SairMgDetalleProcesos> FindSairMgDetalleProceso(String hqlMgDetaProceso){
		List<SairMgDetalleProcesos> LstSairMgDetaProceso = new ArrayList<SairMgDetalleProcesos>();
		LstSairMgDetaProceso = ObjSairParRutina.findMgDetalleProceso(hqlMgDetaProceso);
		return LstSairMgDetaProceso;
	}
	
	public List<Mensaje> DeleteSairMgDetalleProceso(SairMgDetalleProcesos mgDetaProceso, int TipoTransc)  {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.delete(mgDetaProceso,mgDetaProceso.getClass());
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
	
	public List<Mensaje> IngresaSairMgConfigTablero(SairMgConfigTablero mgConfigTablero, int TipoTransc){
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(mgConfigTablero,mgConfigTablero.getClass());
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
	
	public List<SairMgConfigTablero> FindSairMgConfigTablero(String hqlMgConfigTablero){
		List<SairMgConfigTablero> LstSairMgConfigTab = new ArrayList<SairMgConfigTablero>();
		LstSairMgConfigTab = ObjSairParRutina.findMgConfigTablero(hqlMgConfigTablero);
		return LstSairMgConfigTab;
	}
	
	public List<Mensaje> DeleteSairMgConfigTablero(SairMgConfigTablero mgConfigTablero, int TipoTransc)  {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.delete(mgConfigTablero,mgConfigTablero.getClass());
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

	public List<Mensaje> IngresaSairParPoliticas(SairParPoliticas sairParPoliticas, int TipoTransc){
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairParPoliticas,sairParPoliticas.getClass());
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
	
	public List<SairParPoliticas> findSairParPoliticas(String hqlParPltc){
		List<SairParPoliticas> lstSairParPoliticas = new ArrayList<SairParPoliticas>();
		lstSairParPoliticas = ObjSairParRutina.findSairParPoliticas(hqlParPltc);
		return lstSairParPoliticas;
	}
	
	public List<SairPoliticasRutinas> FindSairPoliticasRutinas(String hqlSairPoliticasRutinas)
			throws Exception {
		List<SairPoliticasRutinas> LstSairPoliticasRutinas = new ArrayList<SairPoliticasRutinas>();
		LstSairPoliticasRutinas = ObjSairParRutina.findSairPoliticasRutinas(hqlSairPoliticasRutinas);
		return LstSairPoliticasRutinas;
	}
	
	public List<Mensaje> SaveOrUpdateSairPoliticasRutinas(SairPoliticasRutinas obj_SairPoliticasRutinas,int TipoTransc) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(obj_SairPoliticasRutinas,
				obj_SairPoliticasRutinas.getClass());
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



