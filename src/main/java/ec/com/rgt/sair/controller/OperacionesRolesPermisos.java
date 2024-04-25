package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.RolesPermisosDAO;
import ec.com.rgt.sair.hbm.RolesPermisos;
import ec.com.rgt.sair.hbm.RolesPermisosId;

@SuppressWarnings("unchecked")
public class OperacionesRolesPermisos {
	
	DAO dao = new DAO();
	RolesPermisosDAO Obj_RolesPermisosDAO = new RolesPermisosDAO();
	
	public List<RolesPermisos> ListaRolesPermisos() throws Exception {
        List<RolesPermisos> LstRolesPermisos = new ArrayList<RolesPermisos>();
        LstRolesPermisos = Obj_RolesPermisosDAO.ListaRolesPermisos();
        return LstRolesPermisos;
    }
	
	public List<RolesPermisos> ConsultaRolesPermisos(BigDecimal IdRol, BigDecimal IdPermiso) throws Exception {
        List<RolesPermisos> LstRolesPermisos = new ArrayList<RolesPermisos>();
        LstRolesPermisos = Obj_RolesPermisosDAO.ConsultaRolesPermisos(IdRol, IdPermiso);
        return LstRolesPermisos;
    }
	
	public List<RolesPermisos> findRolesPermisos(String hqlRolesPermisos) throws Exception {
        List<RolesPermisos> LstRolesPermisos = new ArrayList<RolesPermisos>();
        LstRolesPermisos = Obj_RolesPermisosDAO.findRolesPermisos(hqlRolesPermisos);
        return LstRolesPermisos;
    }
	
	public List<Mensaje> IngresaRolesPermisos(BigDecimal IdRol, BigDecimal IdPermiso, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado) throws Exception {
        List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        RolesPermisosId Obj_RolesPermisosId = new RolesPermisosId();
        Obj_RolesPermisosId.setIdRol(IdRol);
        Obj_RolesPermisosId.setIdPermiso(IdPermiso);
        RolesPermisos Obj_RolesPermisos = new RolesPermisos();
        Obj_RolesPermisos.setId(Obj_RolesPermisosId);
        Obj_RolesPermisos.setUsuarioIngreso(UsuarioIngreso);
        Obj_RolesPermisos.setFechaInicio(FechaInicio);
        Obj_RolesPermisos.setUsuarioModificacion(UsuarioModificacion);
        Obj_RolesPermisos.setFechaBaja(FechaBaja);
        Obj_RolesPermisos.setEstado(Estado);
        int estado = dao.saveOrUpdate(Obj_RolesPermisos, Obj_RolesPermisos.getClass());
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
	
	@SuppressWarnings("unused")
	public void deleteRolesPermisos(BigDecimal IdRol, BigDecimal IdPermiso, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado) throws Exception {
        List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        RolesPermisosId Obj_RolesPermisosId = new RolesPermisosId();
        Obj_RolesPermisosId.setIdRol(IdRol);
        Obj_RolesPermisosId.setIdPermiso(IdPermiso);
        RolesPermisos Obj_RolesPermisos = new RolesPermisos();
        Obj_RolesPermisos.setId(Obj_RolesPermisosId);
        Obj_RolesPermisos.setUsuarioIngreso(UsuarioIngreso);
        Obj_RolesPermisos.setFechaInicio(FechaInicio);
        Obj_RolesPermisos.setUsuarioModificacion(UsuarioModificacion);
        Obj_RolesPermisos.setFechaBaja(FechaBaja);
        Obj_RolesPermisos.setEstado(Estado);
        dao.delete(Obj_RolesPermisos, Obj_RolesPermisos.getClass());

    }

}
