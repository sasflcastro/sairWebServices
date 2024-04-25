package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.GruposAplicacionesDAO;
import ec.com.rgt.sair.hbm.GruposAplicaciones;
import ec.com.rgt.sair.hbm.GruposAplicacionesId;


public class OperacionesGruposAplicaciones {
	
	DAO dao = new DAO();
	GruposAplicacionesDAO Obj_GruposAplicacionesDAO = new GruposAplicacionesDAO();
	
	@SuppressWarnings("unchecked")
	public List<GruposAplicaciones> ListaGruposAplicaciones() throws Exception {
        List<GruposAplicaciones> LstGruposAplicaciones = new ArrayList<GruposAplicaciones>();
        LstGruposAplicaciones = Obj_GruposAplicacionesDAO.ListaGruposAplicaciones();
        return LstGruposAplicaciones;
    }
	
	@SuppressWarnings("unchecked")
	public List<GruposAplicaciones> ConsultaGruposAplicaciones(BigDecimal IdGrupo, BigDecimal IdAplicacion) throws Exception {
        List<GruposAplicaciones> LstGruposAplicaciones = new ArrayList<GruposAplicaciones>();
        LstGruposAplicaciones = Obj_GruposAplicacionesDAO.ConsultaGruposAplicaciones(IdGrupo, IdAplicacion);
        return LstGruposAplicaciones;
    }
	
	@SuppressWarnings("unchecked")
	public List<GruposAplicaciones> findGruposAplicaciones(String hqlGruposAplicaciones) throws Exception {
        List<GruposAplicaciones> LstGruposAplicaciones = new ArrayList<GruposAplicaciones>();
        LstGruposAplicaciones = Obj_GruposAplicacionesDAO.findGruposAplicaciones(hqlGruposAplicaciones);
        return LstGruposAplicaciones;
	}
	
	public List<Mensaje> IngresaGrupoAplicacion(BigDecimal IdGrupo, BigDecimal IdAplicacion, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado) throws Exception {
        List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        GruposAplicacionesId Obj_GruposAplicacionesId = new GruposAplicacionesId();
        Obj_GruposAplicacionesId.setIdAplicacion(IdAplicacion);
        Obj_GruposAplicacionesId.setIdGrupo(IdGrupo);
        GruposAplicaciones Obj_GruposAplicaciones = new GruposAplicaciones();
        Obj_GruposAplicaciones.setId(Obj_GruposAplicacionesId);
        Obj_GruposAplicaciones.setUsuarioIngreso(UsuarioIngreso);
        Obj_GruposAplicaciones.setFechaInicio(FechaInicio);
        Obj_GruposAplicaciones.setUsuarioModificacion(UsuarioModificacion);
        Obj_GruposAplicaciones.setFechaBaja(FechaBaja);
        Obj_GruposAplicaciones.setEstado(Estado);
        int estado = dao.saveOrUpdate(Obj_GruposAplicaciones, Obj_GruposAplicaciones.getClass());
        Mensaje Obj_Mensaje = new Mensaje();
        if (estado == 1) {
        	Obj_Mensaje.setIdMensaje(1);
        	Obj_Mensaje.setMensaje("Ingreso Exitoso");
        }else{
        	Obj_Mensaje.setIdMensaje(0);
        	Obj_Mensaje.setMensaje("Ingreso Fallido");
        }
        LstMensaje.add(Obj_Mensaje);
        return LstMensaje;
    }
	
	public List<Mensaje> EliminaGrupoAplicacion(BigDecimal IdGrupo, BigDecimal IdAplicacion, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado) throws Exception {
        List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        GruposAplicacionesId Obj_GruposAplicacionesId = new GruposAplicacionesId();
        Obj_GruposAplicacionesId.setIdAplicacion(IdAplicacion);
        Obj_GruposAplicacionesId.setIdGrupo(IdGrupo);
        GruposAplicaciones Obj_GruposAplicaciones = new GruposAplicaciones();
        Obj_GruposAplicaciones.setId(Obj_GruposAplicacionesId);
        Obj_GruposAplicaciones.setUsuarioIngreso(UsuarioIngreso);
        Obj_GruposAplicaciones.setFechaInicio(FechaInicio);
        Obj_GruposAplicaciones.setUsuarioModificacion(UsuarioModificacion);
        Obj_GruposAplicaciones.setFechaBaja(FechaBaja);
        Obj_GruposAplicaciones.setEstado(Estado);
        int estado = dao.delete(Obj_GruposAplicaciones, Obj_GruposAplicaciones.getClass());
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

}
