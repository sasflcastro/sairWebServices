package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.GruposMenuDAO;
import ec.com.rgt.sair.hbm.GruposMenu;
import ec.com.rgt.sair.hbm.GruposMenuId;


public class OperacionesGruposMenu {
	
	DAO dao = new DAO();
	GruposMenuDAO Obj_GruposMenuDAO = new GruposMenuDAO();
	
	@SuppressWarnings("unchecked")
	public List<GruposMenu> ListaGruposMenu() throws Exception {
        List<GruposMenu> LstGruposMenu = new ArrayList<GruposMenu>();
        LstGruposMenu = Obj_GruposMenuDAO.ListaGruposMenu();
        return LstGruposMenu;
    }
	
	@SuppressWarnings("unchecked")
	public List<GruposMenu> ConsultaGruposMenu(BigDecimal IdGrupo, BigDecimal IdMenu) throws Exception {
        List<GruposMenu> LstGruposMenu = new ArrayList<GruposMenu>();
        LstGruposMenu = Obj_GruposMenuDAO.ConsultaGruposMenu(IdGrupo, IdMenu);
        return LstGruposMenu;
    }
	
	@SuppressWarnings("unchecked")
	public List<GruposMenu> findGruposMenu(String hqlGruposMenues) throws Exception {
        List<GruposMenu> LstGruposMenu = new ArrayList<GruposMenu>();
        LstGruposMenu = Obj_GruposMenuDAO.findGruposMenu(hqlGruposMenues);
        return LstGruposMenu;
    }
	
	
	public List<Mensaje> IngresaGruposMenu(BigDecimal IdGrupo, BigDecimal IdMenu, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado) throws Exception {
        List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        GruposMenuId Obj_GruposMenuId = new GruposMenuId();
        Obj_GruposMenuId.setIdGrupo(IdGrupo);
        Obj_GruposMenuId.setIdMenu(IdMenu);
        GruposMenu Obj_GruposMenu = new GruposMenu();
        Obj_GruposMenu.setId(Obj_GruposMenuId);
        Obj_GruposMenu.setUsuarioIngreso(UsuarioIngreso);
        Obj_GruposMenu.setFechaInicio(FechaInicio);
        Obj_GruposMenu.setUsuarioModificacion(UsuarioModificacion);
        Obj_GruposMenu.setFechaBaja(FechaBaja);
        Obj_GruposMenu.setEstado(Estado);
        int estado = dao.saveOrUpdate(Obj_GruposMenu, Obj_GruposMenu.getClass());
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
	
	public void deleteaGruposMenu(BigDecimal IdGrupo, BigDecimal IdMenu, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado) throws Exception {
        GruposMenuId Obj_GruposMenuId = new GruposMenuId();
        Obj_GruposMenuId.setIdGrupo(IdGrupo);
        Obj_GruposMenuId.setIdMenu(IdMenu);
        GruposMenu Obj_GruposMenu = new GruposMenu();
        Obj_GruposMenu.setId(Obj_GruposMenuId);
        Obj_GruposMenu.setUsuarioIngreso(UsuarioIngreso);
        Obj_GruposMenu.setFechaInicio(FechaInicio);
        Obj_GruposMenu.setUsuarioModificacion(UsuarioModificacion);
        Obj_GruposMenu.setFechaBaja(FechaBaja);
        Obj_GruposMenu.setEstado(Estado);
        dao.delete(Obj_GruposMenu, Obj_GruposMenu.getClass());
       
    }

}
