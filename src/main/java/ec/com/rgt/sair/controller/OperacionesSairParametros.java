package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairParametrosDAO;
import ec.com.rgt.sair.hbm.SairParametros;

@SuppressWarnings("unchecked")
public class OperacionesSairParametros {

	DAO dao = new DAO();
	SairParametrosDAO Obj_SairParametrosDAO = new SairParametrosDAO();

	public List<SairParametros> ConsultaSairParametros(BigDecimal IdParametro)
			throws Exception {
		List<SairParametros> LstSairParametros = new ArrayList<SairParametros>();
		LstSairParametros = Obj_SairParametrosDAO
				.ConsultaParametros(IdParametro);
		return LstSairParametros;
	}
	
	public List<SairParametros> ConsultaPadre(BigDecimal IdPadre)
			throws Exception {
		List<SairParametros> LstSairParametros = new ArrayList<SairParametros>();
		LstSairParametros = Obj_SairParametrosDAO
				.ConsultaPadre(IdPadre);
		return LstSairParametros;
	}

	public List<SairParametros> FindSairParametros(String HqlParametros)
			throws Exception {
		List<SairParametros> LstSairParametros = new ArrayList<SairParametros>();
		LstSairParametros = Obj_SairParametrosDAO.findParametros(HqlParametros);
		return LstSairParametros;
	}

	public List<Mensaje> IngresaSairParametros(BigDecimal idParametro,
			String nombre, String detalle, String valor, String UsuarioIngreso,
			Date FechaInicio, String UsuarioModificacion,
			Date fechaModificacion, String Estado, BigDecimal valorNumerico,
			BigDecimal idPadre, int TipoTransc) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairParametros obj_SairParametros = new SairParametros();
		obj_SairParametros.setIdParametro(idParametro);
		obj_SairParametros.setNombre(nombre);
		obj_SairParametros.setDetalle(detalle);
		obj_SairParametros.setValor(valor);
		obj_SairParametros.setUsuarioIngreso(UsuarioIngreso);
		obj_SairParametros.setFechaInicio(FechaInicio);
		obj_SairParametros.setUsuarioModificacion(UsuarioModificacion);
		obj_SairParametros.setFechaModificacion(fechaModificacion);
		obj_SairParametros.setEstado(Estado);
		obj_SairParametros.setValorNumerico(valorNumerico);
		obj_SairParametros.setIdPadre(idPadre);
		int estado = dao.saveOrUpdate(obj_SairParametros,
				obj_SairParametros.getClass());
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
