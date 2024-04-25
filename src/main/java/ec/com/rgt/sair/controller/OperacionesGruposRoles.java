package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.GruposRolesDAO;
import ec.com.rgt.sair.hbm.GruposRoles;
import ec.com.rgt.sair.hbm.GruposRolesId;


public class OperacionesGruposRoles {
	
	DAO dao = new DAO();
	GruposRolesDAO Obj_GruposRolesDAO = new GruposRolesDAO();
	
	@SuppressWarnings("unchecked")
	public List<GruposRoles> ListaGruposRoles() throws Exception {
        List<GruposRoles> LstGruposRoles = new ArrayList<GruposRoles>();
        LstGruposRoles = Obj_GruposRolesDAO.ListaGruposRoles();
        return LstGruposRoles;
    }
	
	@SuppressWarnings("unchecked")
	public List<GruposRoles> ConsultaGruposRoles(BigDecimal IdGrupo, BigDecimal IdRol) throws Exception {
        List<GruposRoles> LstGruposRoles = new ArrayList<GruposRoles>();
        LstGruposRoles = Obj_GruposRolesDAO.ConsultaGruposRoles(IdGrupo, IdRol);
        return LstGruposRoles;
    }
	
	@SuppressWarnings("unchecked")
	public List<GruposRoles> ConsultaGruposRoles(String hqlGruposRoles) throws Exception {
        List<GruposRoles> LstGruposRoles = new ArrayList<GruposRoles>();
        LstGruposRoles = Obj_GruposRolesDAO.ConsultaGruposRoles(hqlGruposRoles);
        return LstGruposRoles;
    }
	
	@SuppressWarnings("unchecked")
	public List<GruposRoles> ConsultaGruposRoles1(BigDecimal IdGrupo, BigDecimal IdRol) throws Exception {
        List<GruposRoles> LstGruposRoles = new ArrayList<GruposRoles>();
        LstGruposRoles = Obj_GruposRolesDAO.ConsultaGruposRoles1(IdGrupo, IdRol);
        return LstGruposRoles;
    }
	
	public List<Mensaje> IngresaGruposRoles(BigDecimal IdGrupo, BigDecimal IdRol, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado) throws Exception {
        List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        GruposRolesId Obj_GruposRolesId = new GruposRolesId();
        Obj_GruposRolesId.setIdGrupo(IdGrupo);
        Obj_GruposRolesId.setIdRol(IdRol);
        GruposRoles Obj_GruposRoles = new GruposRoles();
        Obj_GruposRoles.setId(Obj_GruposRolesId);
        Obj_GruposRoles.setUsuarioIngreso(UsuarioIngreso);
        Obj_GruposRoles.setFechaInicio(FechaInicio);
        Obj_GruposRoles.setUsuarioModificacion(UsuarioModificacion);
        Obj_GruposRoles.setFechaBaja(FechaBaja);
        Obj_GruposRoles.setEstado(Estado);
        int estado = dao.saveOrUpdate(Obj_GruposRoles, Obj_GruposRoles.getClass());
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
	
	public List<Mensaje> EliminaGruposRoles(BigDecimal IdGrupo, BigDecimal IdRol, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado) throws Exception {
        List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        GruposRolesId Obj_GruposRolesId = new GruposRolesId();
        Obj_GruposRolesId.setIdGrupo(IdGrupo);
        Obj_GruposRolesId.setIdRol(IdRol);
        GruposRoles Obj_GruposRoles = new GruposRoles();
        Obj_GruposRoles.setId(Obj_GruposRolesId);
        Obj_GruposRoles.setUsuarioIngreso(UsuarioIngreso);
        Obj_GruposRoles.setFechaInicio(FechaInicio);
        Obj_GruposRoles.setUsuarioModificacion(UsuarioModificacion);
        Obj_GruposRoles.setFechaBaja(FechaBaja);
        Obj_GruposRoles.setEstado(Estado);
        int estado = dao.delete(Obj_GruposRoles, Obj_GruposRoles.getClass());
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
