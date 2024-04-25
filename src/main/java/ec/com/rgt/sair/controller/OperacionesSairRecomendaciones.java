package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairRecomendacionesDAO;
import ec.com.rgt.sair.hbm.RecomendacionHistorica;
import ec.com.rgt.sair.hbm.SairArea;
import ec.com.rgt.sair.hbm.SairAreasAdam;
import ec.com.rgt.sair.hbm.SairDocConclusionDocumento;
import ec.com.rgt.sair.hbm.SairDocReservacionCodigo;
import ec.com.rgt.sair.hbm.SairEstadoComplementario;
import ec.com.rgt.sair.hbm.SairEstadoReco;
import ec.com.rgt.sair.hbm.SairEstadosPrincipal;
import ec.com.rgt.sair.hbm.SairRecAreas;
import ec.com.rgt.sair.hbm.SairRecConclusionReco;
import ec.com.rgt.sair.hbm.SairRecDependencia;
import ec.com.rgt.sair.hbm.SairRecDiscusion;
import ec.com.rgt.sair.hbm.SairRecRecomendacion;

public class OperacionesSairRecomendaciones {

	DAO dao = new DAO();
	SairRecomendacionesDAO objSairRecomendaciones = new SairRecomendacionesDAO();

	public List<SairRecRecomendacion> FindSairRecomendaciones(String hqlRecomen)
			 {
		List<SairRecRecomendacion> lstSairRecomendaciones = new ArrayList<SairRecRecomendacion>();
		lstSairRecomendaciones = objSairRecomendaciones
				.findRecomendaciones(hqlRecomen);
		return lstSairRecomendaciones;
	}
	
	
	public List<SairRecDependencia> FindSairRecDependencia(String hqlDependencia)
			 {
		List<SairRecDependencia> lstSairRecDependencia = new ArrayList<SairRecDependencia>();
		lstSairRecDependencia = objSairRecomendaciones
				.findRecDependencia(hqlDependencia);
		return lstSairRecDependencia;
	}
	
	public List<SairRecDiscusion> findSairRecDiscusion(String hqlRecDiscusion){
		List<SairRecDiscusion> lstSairRecConclusionesRecomend = new ArrayList<SairRecDiscusion>();
		lstSairRecConclusionesRecomend = objSairRecomendaciones.findSairRecDiscusion(hqlRecDiscusion);
		return lstSairRecConclusionesRecomend;
	}
	
	
	public List<RecomendacionHistorica> findRecomendacionHistoricas(String hqlRecoHis)
	         {
         List<RecomendacionHistorica> lstRecomendacionHistorica = new ArrayList<RecomendacionHistorica>();
         lstRecomendacionHistorica = objSairRecomendaciones
		         .findRecomendacionH(hqlRecoHis);
         return lstRecomendacionHistorica;
    }
	
	public List<SairRecConclusionReco> findConclusionesRecomends(String hqlRecoConcl)
             {
          List<SairRecConclusionReco> lstConclusionesRecomends = new ArrayList<SairRecConclusionReco>();
          lstConclusionesRecomends = objSairRecomendaciones
                 .findRecConclusionesRec(hqlRecoConcl);
          return lstConclusionesRecomends;
    }
    
	public List<Mensaje> IngresaSairRecomendaciones(SairRecRecomendacion sairRecRecomendacion, int TipoTransc)
			 {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao
				.saveOrUpdate(sairRecRecomendacion, sairRecRecomendacion.getClass());
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
	
	public List<Mensaje> IngresaSairRecDependencia(
			BigDecimal idSecuencial,
			SairRecRecomendacion sairRecRecomendacionByIdRecomendacion,
			SairEstadosPrincipal sairEstadosPrincipal,
			SairRecRecomendacion sairRecRecomendacionByIdRecoDependiente,
			int TipoTransc)	 {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairRecDependencia obj_SairRecDependencia = new SairRecDependencia();

		obj_SairRecDependencia.setIdSecuencial(idSecuencial);
		obj_SairRecDependencia.setSairRecRecomendacionByIdRecomendacion(sairRecRecomendacionByIdRecomendacion);
		obj_SairRecDependencia.setSairEstadosPrincipal(sairEstadosPrincipal);
		obj_SairRecDependencia.setSairRecRecomendacionByIdRecoDependiente(sairRecRecomendacionByIdRecoDependiente);
	

		int estado = dao
				.saveOrUpdate(obj_SairRecDependencia, obj_SairRecDependencia.getClass());
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
	
	
	public List<Mensaje> deleteSairRecDependencia(
			BigDecimal idSecuencial,
			SairRecRecomendacion sairRecRecomendacionByIdRecomendacion,
			SairEstadosPrincipal sairEstadosPrincipal,
			SairRecRecomendacion sairRecRecomendacionByIdRecoDependiente,
			int TipoTransc)	 {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairRecDependencia obj_SairRecDependencia = new SairRecDependencia();

		obj_SairRecDependencia.setIdSecuencial(idSecuencial);
		obj_SairRecDependencia.setSairRecRecomendacionByIdRecomendacion(sairRecRecomendacionByIdRecomendacion);
		obj_SairRecDependencia.setSairEstadosPrincipal(sairEstadosPrincipal);
		obj_SairRecDependencia.setSairRecRecomendacionByIdRecoDependiente(sairRecRecomendacionByIdRecoDependiente);
		

		int estado = dao
				.delete(obj_SairRecDependencia, obj_SairRecDependencia.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado == 1) {
			Obj_Mensaje.setIdMensaje(1);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Eliminacion Exitoso");

			} else {

				Obj_Mensaje.setMensaje("Actualizacion Exitosa");

			}

		} else {
			Obj_Mensaje.setIdMensaje(0);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Eliminacion Fallido");

			} else {

				Obj_Mensaje.setMensaje("Actualizacion Fallida");

			}
		}
		LstMensaje.add(Obj_Mensaje);
		return LstMensaje;
	}
	

	public List<Mensaje> deleteSairRecConclusionReco(
			SairRecConclusionReco sairRecConclusionReco)	 {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();int estado = dao
				.delete(sairRecConclusionReco, sairRecConclusionReco.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado == 1) {
			Obj_Mensaje.setIdMensaje(1);
			Obj_Mensaje.setMensaje("Eliminacion Exitoso");

		} else {
			Obj_Mensaje.setIdMensaje(0);
			Obj_Mensaje.setMensaje("Eliminacion Fallido");
		}
		LstMensaje.add(Obj_Mensaje);
		return LstMensaje;
	}


	public List<Mensaje> deleteSairRecomendaciones(BigDecimal idRecomendacion,
			SairDocReservacionCodigo sairDocReservacionCodigo,
			SairArea sairArea, 
			SairEstadoComplementario sairEstadoComplementario,SairAreasAdam sairAreasAdam, String personaEncargada,
			String gerenteEncargado, String descripcion, 
			Date fechaAtencionTotal, Date fechaCompromiso, Date fechaRespuesta,
			Date fechaDeBaja, String dependeProveedor, String codigo,
			BigDecimal numero, String comentario, Date fechaIngreso,
			BigDecimal ano, String areaEvaluada,Date fechaDeEmision,String estados,
			BigDecimal automatica,BigDecimal diasSinRespuesta,Date fechaRespuestaRevision,
			SairEstadoReco sairEstadoReco, int TipoTransc)
			 {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairRecRecomendacion obj_SairRecomen = new SairRecRecomendacion();

		obj_SairRecomen.setIdRecomendacion(idRecomendacion);
		obj_SairRecomen.setSairDocReservacionCodigo(sairDocReservacionCodigo);
		obj_SairRecomen.setSairArea(sairArea);
		obj_SairRecomen.setSairEstadoComplementario(sairEstadoComplementario);
		obj_SairRecomen.setSairAreasAdam(sairAreasAdam);
		obj_SairRecomen.setPersonaEncargada(personaEncargada);
		obj_SairRecomen.setGerenteEncargado(gerenteEncargado);
		obj_SairRecomen.setDescripcion(descripcion);
		obj_SairRecomen.setAutomatica(automatica);
		obj_SairRecomen.setDiasSinRespuesta(diasSinRespuesta);
		obj_SairRecomen.setFechaRespuestaRevision(fechaRespuestaRevision);
		obj_SairRecomen.setSairEstadoReco(sairEstadoReco);
		obj_SairRecomen.setFechaAtencionTotal(fechaAtencionTotal);
		obj_SairRecomen.setFechaCompromiso(fechaCompromiso);
		obj_SairRecomen.setFechaRespuesta(fechaRespuesta);
		obj_SairRecomen.setFechaDeBaja(fechaDeBaja);
		obj_SairRecomen.setDependeProveedor(dependeProveedor);
		obj_SairRecomen.setCodigo(codigo);
		obj_SairRecomen.setNumero(numero);
		obj_SairRecomen.setComentario(comentario);
		obj_SairRecomen.setFechaIngreso(fechaIngreso);
		obj_SairRecomen.setAno(ano);
		obj_SairRecomen.setAreaEvaluada(areaEvaluada);
		obj_SairRecomen.setEstado(estados);

		int estado = dao
				.delete(obj_SairRecomen, obj_SairRecomen.getClass());
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
	
	public List<Mensaje> IngresaSairRecDiscusion(
			BigDecimal idDiscusion,
			SairRecRecomendacion sairRecRecomendacion,
			String idUsuario,
			String estados, 
			String discusion,
			Date fechaIngreso,String url,String extencion,String leido,String idUsuarioDir,
			int TipoTransc) throws Exception {
		
	
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairRecDiscusion obj_SairDocConclusionD = new SairRecDiscusion();
		obj_SairDocConclusionD.setIdDiscusion(idDiscusion);
		obj_SairDocConclusionD.setSairRecRecomendacion(sairRecRecomendacion);
		obj_SairDocConclusionD.setDiscusion(discusion);
		obj_SairDocConclusionD.setEstado(estados);
		obj_SairDocConclusionD.setIdUsuario(idUsuario);
		obj_SairDocConclusionD.setFechaIngreso(fechaIngreso);
		obj_SairDocConclusionD.setUrl(url);		
		obj_SairDocConclusionD.setExtencion(extencion);	
		obj_SairDocConclusionD.setLeido(leido);
		obj_SairDocConclusionD.setIdUsuarioDir(idUsuarioDir);
		int estado = dao.saveOrUpdate(obj_SairDocConclusionD,
				obj_SairDocConclusionD.getClass());
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
	
	
	public List<Mensaje> IngresaRecomendacionHistorica(
			BigDecimal idRecomendacionHistorica,
			SairDocReservacionCodigo sairDocReservacionCodigo,
			SairEstadoComplementario sairEstadoComplementario,
			SairDocConclusionDocumento sairDocConclusionDocumento,
			SairArea sairArea, 
			SairAreasAdam sairAreasAdam,
			BigDecimal idRecomendacion, 
			String personaEncargada,
			String gerenteEncargado, 
			String descripcion, 
			BigDecimal evaluacion,
			Date fechaAtencionTotal, 
			Date fechaCompromiso, 
			Date fechaRespuesta,
			Date fechaDeBaja, 
			String dependeProveedor, 
			String codigo,
			BigDecimal numero, 
			Date fechaIngreso, 
			BigDecimal ano,
			String atendida, 
			String areaEvaluada, 
			String estado,
			String conclusion, 
			String comentario, 
			Date fechaActualizacion,Date fechaDeEmision,String errorOperativo, 
			int TipoTransc) throws Exception {
		
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		RecomendacionHistorica obj_SairDocConclusionD = new RecomendacionHistorica();
		
		obj_SairDocConclusionD.setIdRecomendacionHistorica(idRecomendacionHistorica);
		obj_SairDocConclusionD.setSairDocReservacionCodigo(sairDocReservacionCodigo);
		obj_SairDocConclusionD.setSairEstadoComplementario(sairEstadoComplementario);
		obj_SairDocConclusionD.setSairDocConclusionDocumento(sairDocConclusionDocumento);
		obj_SairDocConclusionD.setSairArea(sairArea);
		obj_SairDocConclusionD.setSairAreasAdam(sairAreasAdam);
		obj_SairDocConclusionD.setIdRecomendacion(idRecomendacion);
		obj_SairDocConclusionD.setPersonaEncargada(personaEncargada);
		obj_SairDocConclusionD.setGerenteEncargado(gerenteEncargado);
		obj_SairDocConclusionD.setDescripcion(descripcion);
		obj_SairDocConclusionD.setEvaluacion(evaluacion);
		obj_SairDocConclusionD.setFechaAtencionTotal(fechaAtencionTotal);
		obj_SairDocConclusionD.setFechaCompromiso(fechaCompromiso);
		obj_SairDocConclusionD.setFechaRespuesta(fechaRespuesta);
		obj_SairDocConclusionD.setFechaDeBaja(fechaDeBaja);
		obj_SairDocConclusionD.setDependeProveedor(dependeProveedor);
		obj_SairDocConclusionD.setCodigo(codigo);
		obj_SairDocConclusionD.setNumero(numero);
		obj_SairDocConclusionD.setFechaIngreso(fechaIngreso);
		obj_SairDocConclusionD.setAno(ano);
		obj_SairDocConclusionD.setAtendida(atendida);
		obj_SairDocConclusionD.setAreaEvaluada(areaEvaluada);
		obj_SairDocConclusionD.setEstado(estado);
		obj_SairDocConclusionD.setConclusion(conclusion);
		obj_SairDocConclusionD.setComentario(comentario);
		obj_SairDocConclusionD.setFechaActualizacion(fechaActualizacion);
		obj_SairDocConclusionD.setFechaDeEmision(fechaDeEmision);	
		obj_SairDocConclusionD.setErrorOperativo(errorOperativo);
		//obj_SairDocConclusionD.setPersonaEncargada(revisionPolitica);
		int estado1 = dao.saveOrUpdate(obj_SairDocConclusionD,
				obj_SairDocConclusionD.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado1 == 1) {
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
	
	public List<Mensaje> IngresaSairRecConclusionReco(SairRecConclusionReco sairRecConclusionReco, 
			int TipoTransc) {
		
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		
		int estado = dao.saveOrUpdate(sairRecConclusionReco,
				sairRecConclusionReco.getClass());
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
	
	public List<Mensaje> IngresaSairRecAreas(SairRecAreas sairRecAreas, 
			int TipoTransc) {
		
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		
		int estado = dao.saveOrUpdate(sairRecAreas,
				sairRecAreas.getClass());
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
	
	public List<SairRecAreas> findSairRecAreas(String hqlRecAreas){
		List<SairRecAreas> lstSairRecAreas = new ArrayList<SairRecAreas>();
		lstSairRecAreas = objSairRecomendaciones.findSairRecAreas(hqlRecAreas);
		return lstSairRecAreas;
	}
	
	public List<Mensaje> deleteSairRecAreas(
			SairRecAreas sairRecAreas)	 {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();int estado = dao
				.delete(sairRecAreas, sairRecAreas.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado == 1) {
			Obj_Mensaje.setIdMensaje(1);
			Obj_Mensaje.setMensaje("Eliminacion Exitoso");

		} else {
			Obj_Mensaje.setIdMensaje(0);
			Obj_Mensaje.setMensaje("Eliminacion Fallido");
		}
		LstMensaje.add(Obj_Mensaje);
		return LstMensaje;
	}
	
	
}





















