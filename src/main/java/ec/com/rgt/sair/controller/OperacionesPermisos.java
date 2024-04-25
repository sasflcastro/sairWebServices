package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.PermisosDAO;
import ec.com.rgt.sair.hbm.Permisos;

@SuppressWarnings("unchecked")
public class OperacionesPermisos {
	
	DAO dao = new DAO();
	PermisosDAO Obj_PermisosDAO = new PermisosDAO();
	
	public List<Permisos> ListaPermisos() throws Exception {
        List<Permisos> LstPermisos = new ArrayList<Permisos>();
        LstPermisos = Obj_PermisosDAO.ListaPermisos();
        return LstPermisos;
    }
	
	public List<Permisos> ConsultaPermiso(BigDecimal IdPermiso) throws Exception {
        List<Permisos> LstPermisos = new ArrayList<Permisos>();
        LstPermisos = Obj_PermisosDAO.ConsultaPermiso(IdPermiso);
        return LstPermisos;
    }
	
	public List<Permisos> findPermisos(String hqlPermiso) throws Exception {
        List<Permisos> LstPermisos = new ArrayList<Permisos>();
        LstPermisos = Obj_PermisosDAO.findPermisos(hqlPermiso);
        return LstPermisos;
    }
	
	public List<Mensaje> IngresaPermisos(BigDecimal IdPermiso, String NombrePermiso, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado, int TipoTransc) throws Exception {
        List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        Permisos obj_Permisos = new Permisos();
        obj_Permisos.setIdPermiso(IdPermiso);
        obj_Permisos.setNombrePermiso(NombrePermiso);
        obj_Permisos.setUsuarioIngreso(UsuarioIngreso);
        obj_Permisos.setFechaInicio(FechaInicio);
        obj_Permisos.setUsuarioModificacion(UsuarioModificacion);
        obj_Permisos.setFechaBaja(FechaBaja);
        obj_Permisos.setEstado(Estado);
        int estado = dao.saveOrUpdate(obj_Permisos, obj_Permisos.getClass());
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
