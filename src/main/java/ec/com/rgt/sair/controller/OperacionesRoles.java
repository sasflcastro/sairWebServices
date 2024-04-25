package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.RolesDAO;
import ec.com.rgt.sair.hbm.Roles;

@SuppressWarnings("unchecked")
public class OperacionesRoles {
	
	DAO dao = new DAO();
	RolesDAO Obj_RolesDAO = new RolesDAO();
	
	public List<Roles> BuscaRoles(String HqlRoles) throws Exception {
        List<Roles> LstRoles = new ArrayList<Roles>();
        LstRoles = Obj_RolesDAO.BuscaRoles(HqlRoles);
        return LstRoles;
    }
	
	/*public List<Roles> ListaRoles() throws Exception {
        List<Roles> LstRoles = new ArrayList<Roles>();
        LstRoles = Obj_RolesDAO.ListaRoles();
        return LstRoles;
    }
	
	public List<Roles> ConsultaRoles(BigDecimal IdRol) throws Exception {
        List<Roles> LstRoles = new ArrayList<Roles>();
        LstRoles = Obj_RolesDAO.ConsultaRol(IdRol);
        return LstRoles;
    }*/
	
	public List<Roles> findRoles(String hqlRol) throws Exception {
        List<Roles> LstRoles = new ArrayList<Roles>();
        LstRoles = Obj_RolesDAO.findRol(hqlRol);
        return LstRoles;
    }
	
	public List<Mensaje> IngresaRoles(BigDecimal IdRol, String NombreRol, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado, int TipoTransc) throws Exception {
        List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        Roles obj_Roles = new Roles();
        obj_Roles.setIdRol(IdRol);
        obj_Roles.setNombreRol(NombreRol);
        obj_Roles.setUsuarioIngreso(UsuarioIngreso);
        obj_Roles.setFechaInicio(FechaInicio);
        obj_Roles.setUsuarioModificacion(UsuarioModificacion);
        obj_Roles.setFechaBaja(FechaBaja);
        obj_Roles.setEstado(Estado);
        int estado = dao.saveOrUpdate(obj_Roles, obj_Roles.getClass());
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
