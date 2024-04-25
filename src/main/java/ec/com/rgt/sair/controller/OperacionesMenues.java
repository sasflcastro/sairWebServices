package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.MenuesDAO;
import ec.com.rgt.sair.hbm.Menues;

@SuppressWarnings("unchecked")
public class OperacionesMenues {
	
	DAO dao = new DAO();
	MenuesDAO Obj_MenuesDAO = new MenuesDAO();
	
	
	public List<Menues> ListaMenues() throws Exception {
        List<Menues> LstMenues = new ArrayList<Menues>();
        LstMenues = Obj_MenuesDAO.ListaMenues();
        return LstMenues;
    }
	
	public List<Menues> ConsultaMenues(BigDecimal IdMenu) throws Exception {
        List<Menues> LstMenues = new ArrayList<Menues>();
        LstMenues = Obj_MenuesDAO.ConsultaMenues(IdMenu);
        return LstMenues;
    }
	
	public List<Menues> findMenues(String hqlMenu) throws Exception {
        List<Menues> LstMenues = new ArrayList<Menues>();
        LstMenues = Obj_MenuesDAO.findMenues(hqlMenu);
        return LstMenues;
    }
	
	public List<Mensaje> IngresaMenu(BigDecimal IdMenu, BigDecimal IdMenuPadre, String Descripcion, String RutaAcceso, BigDecimal Orden, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado,BigDecimal idAplicacion, int TipoTransc) {
        List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        //Menues Obj_MenuPadre = new Menues();
        //Obj_MenuPadre.setIdMenu(IdMenuPadre);
        Menues Obj_Menues = new Menues();
        Obj_Menues.setIdMenu(IdMenu);
        Obj_Menues.setIdMenuPadre(IdMenuPadre);
        Obj_Menues.setDescripcion(Descripcion);
        Obj_Menues.setRutaAcceso(RutaAcceso);
        Obj_Menues.setOrden(Orden);
        Obj_Menues.setUsuarioIngreso(UsuarioIngreso);
        Obj_Menues.setFechaInicio(FechaInicio);
        Obj_Menues.setUsuarioModificacion(UsuarioModificacion);
        Obj_Menues.setFechaBaja(FechaBaja);
        Obj_Menues.setEstado(Estado);
        Obj_Menues.setIdAplicacion(idAplicacion);
        int estado = dao.saveOrUpdate(Obj_Menues, Obj_Menues.getClass());
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
	
	public void deleteMenu(BigDecimal IdMenu, BigDecimal IdMenuPadre, String Descripcion, String RutaAcceso, BigDecimal Orden, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado) throws Exception {
        //Menues Obj_MenuPadre = new Menues();
        //Obj_MenuPadre.setIdMenu(IdMenuPadre);
        Menues Obj_Menues = new Menues();
        Obj_Menues.setIdMenu(IdMenu);
        Obj_Menues.setIdMenuPadre(IdMenuPadre);
        Obj_Menues.setDescripcion(Descripcion);
        Obj_Menues.setRutaAcceso(RutaAcceso);
        Obj_Menues.setOrden(Orden);
        Obj_Menues.setUsuarioIngreso(UsuarioIngreso);
        Obj_Menues.setFechaInicio(FechaInicio);
        Obj_Menues.setUsuarioModificacion(UsuarioModificacion);
        Obj_Menues.setFechaBaja(FechaBaja);
        Obj_Menues.setEstado(Estado);
        dao.delete(Obj_Menues, Obj_Menues.getClass());
        
	}
}
