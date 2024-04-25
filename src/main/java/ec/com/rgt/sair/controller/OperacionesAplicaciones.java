package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.AplicacionesDAO;
import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.hbm.Aplicaciones;
import ec.com.rgt.sair.hbm.SairCalEventos;
import ec.com.rgt.sair.hbm.SairCalTipoEvento;
import ec.com.rgt.sair.hbm.SairRecoUsuarioInvitado;
import ec.com.rgt.sair.hbm.SairRecoUsuarioMasivo;

public class OperacionesAplicaciones {

	DAO dao = new DAO();
	AplicacionesDAO Obj_AplicacionesDAO = new AplicacionesDAO();

	@SuppressWarnings("unchecked")
	public List<Aplicaciones> ListaAplicaciones() throws Exception {
		List<Aplicaciones> LstAplicaciones = new ArrayList<Aplicaciones>();
		LstAplicaciones = Obj_AplicacionesDAO.ListaAplicaciones();
		return LstAplicaciones;
	}

	@SuppressWarnings("unchecked")
	public List<Aplicaciones> ConsultaAplicacion(BigDecimal IdAplicacion)
			throws Exception {
		List<Aplicaciones> LstAplicaciones = new ArrayList<Aplicaciones>();
		LstAplicaciones = Obj_AplicacionesDAO
				.ConsultaAplicaciones(IdAplicacion);
		return LstAplicaciones;
	}

	@SuppressWarnings("unchecked")
	public List<Aplicaciones> findAplicaciones(String hqlAplicaciones)
			throws Exception {
		List<Aplicaciones> LstAplicaciones = new ArrayList<Aplicaciones>();
		LstAplicaciones = Obj_AplicacionesDAO.findAplicaciones(hqlAplicaciones);
		return LstAplicaciones;
	}

	@SuppressWarnings("unchecked")
	public List<SairCalEventos> findCalEventos(String hqlCalEventos)
			throws Exception {
		List<SairCalEventos> LstAplicaciones = new ArrayList<SairCalEventos>();
		LstAplicaciones = Obj_AplicacionesDAO.findCalEventos(hqlCalEventos);
		return LstAplicaciones;
	}

	@SuppressWarnings("unchecked")
	public List<SairCalTipoEvento> findCalTipoEventos(String hqlCalTipoEventos)
			throws Exception {
		List<SairCalTipoEvento> LstAplicaciones = new ArrayList<SairCalTipoEvento>();
		LstAplicaciones = Obj_AplicacionesDAO.findCalTipoEventos(hqlCalTipoEventos);
		return LstAplicaciones;
	}

	@SuppressWarnings("unchecked")
	public List<SairRecoUsuarioInvitado> findSairRecoUsuarioInvitado(String hqlUsuarioInvitado)
			throws Exception {
		List<SairRecoUsuarioInvitado> LstAplicaciones = new ArrayList<SairRecoUsuarioInvitado>();
		LstAplicaciones = Obj_AplicacionesDAO.findSairRecoUsuarioInvitado(hqlUsuarioInvitado);
		return LstAplicaciones;
	}
	
	public List<Mensaje> saveOrUpdateCalEventos(SairCalEventos sairCalEventos,int TipoTransc) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairCalEventos, sairCalEventos.getClass());
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

	public List<Mensaje> saveUsuarioInvitado(SairRecoUsuarioInvitado sairRecoUsuarioInvitado) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairRecoUsuarioInvitado, sairRecoUsuarioInvitado.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado == 1) {
			Obj_Mensaje.setIdMensaje(1);
			Obj_Mensaje.setMensaje("Ingreso Exitoso");
		} else {
			Obj_Mensaje.setIdMensaje(0);
			Obj_Mensaje.setMensaje("Ingreso Fallido");
		}
		LstMensaje.add(Obj_Mensaje);
		return LstMensaje;
	}
	
	public List<Mensaje> deleteUsuarioInvitado(SairRecoUsuarioInvitado sairRecoUsuarioInvitado) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        int estado =  dao.delete(sairRecoUsuarioInvitado, sairRecoUsuarioInvitado.getClass());       
        Mensaje Obj_Mensaje = new Mensaje();
        if (estado == 1) {
        	Obj_Mensaje.setIdMensaje(1);
        	Obj_Mensaje.setMensaje("Eliminacion Exitosa");
        }else{
        	Obj_Mensaje.setIdMensaje(0);
        	Obj_Mensaje.setMensaje("Eliminacion Fallida");
        }
        LstMensaje.add(Obj_Mensaje);
        return LstMensaje;
    }
	
	
	public List<Mensaje> IngresaAplicacion(BigDecimal IdAplicacion,
			String Descripcion, String UsuarioIngreso, Date FechaInicio,
			String UsuarioModificacion, Date FechaBaja, String Estado,
			int TipoTransc) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		Aplicaciones obj_Aplicaciones = new Aplicaciones();
		obj_Aplicaciones.setIdAplicacion(IdAplicacion);
		obj_Aplicaciones.setDescripcion(Descripcion);
		obj_Aplicaciones.setUsuarioIngreso(UsuarioIngreso);
		obj_Aplicaciones.setFechaInicio(FechaInicio);
		obj_Aplicaciones.setUsuarioModificacion(UsuarioModificacion);
		obj_Aplicaciones.setFechaBaja(FechaBaja);
		obj_Aplicaciones.setEstado(Estado);
		int estado = dao.saveOrUpdate(obj_Aplicaciones,
				obj_Aplicaciones.getClass());
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
	
	public List<Mensaje> saveUsuarioMasivo(SairRecoUsuarioMasivo sairRecoUsuarioMasivo) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(sairRecoUsuarioMasivo, sairRecoUsuarioMasivo.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado == 1) {
			Obj_Mensaje.setIdMensaje(1);
			Obj_Mensaje.setMensaje("Ingreso Exitoso");
		} else {
			Obj_Mensaje.setIdMensaje(0);
			Obj_Mensaje.setMensaje("Ingreso Fallido");
		}
		LstMensaje.add(Obj_Mensaje);
		return LstMensaje;
	}
	
	public List<Mensaje> deleteUsuarioMasivo(SairRecoUsuarioMasivo sairRecoUsuarioMasivo) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        int estado =  dao.delete(sairRecoUsuarioMasivo, sairRecoUsuarioMasivo.getClass());       
        Mensaje Obj_Mensaje = new Mensaje();
        if (estado == 1) {
        	Obj_Mensaje.setIdMensaje(1);
        	Obj_Mensaje.setMensaje("Eliminacion Exitosa");
        }else{
        	Obj_Mensaje.setIdMensaje(0);
        	Obj_Mensaje.setMensaje("Eliminacion Fallida");
        }
        LstMensaje.add(Obj_Mensaje);
        return LstMensaje;
    }
	
	@SuppressWarnings("unchecked")
	public List<SairRecoUsuarioMasivo> findSairRecoUsuarioMasivo(String hqlUsuarioMasivo)
			throws Exception {
		List<SairRecoUsuarioMasivo> LstAplicaciones = new ArrayList<SairRecoUsuarioMasivo>();
		LstAplicaciones = Obj_AplicacionesDAO.findSairRecoUsuarioInvitado(hqlUsuarioMasivo);
		return LstAplicaciones;
	}

}
