package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.GruposDAO;
import ec.com.rgt.sair.hbm.Grupos;


public class OperacionesGrupos {
	
	DAO dao = new DAO();
	GruposDAO Obj_GruposDAO = new GruposDAO();
	
	@SuppressWarnings("unchecked")
	public List<Grupos> BuscaGrupos( String HqlGrupos) throws Exception {
        List<Grupos> LstGrupos = new ArrayList<Grupos>();
        LstGrupos = Obj_GruposDAO.BuscaGrupos(HqlGrupos);
        return LstGrupos;
    }
	
	/*public List<Grupos> ConsultaGrupo(BigDecimal IdGrupo) throws Exception {
        List<Grupos> LstGrupos = new ArrayList<Grupos>();
        LstGrupos = Obj_GruposDAO.ConsultaGrupo(IdGrupo);
        return LstGrupos;
    }
	
	public List<Grupos> BuscaGrupo(String NombreGrupo, String estado) throws Exception {
        List<Grupos> LstGrupos = new ArrayList<Grupos>();
        LstGrupos = Obj_GruposDAO.BuscaGrupo(NombreGrupo, estado);
        return LstGrupos;
    }*/
	
	public List<Mensaje> IngresaGrupo(BigDecimal IdGrupo, String NombreGrupo, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado, int TipoTransc) throws Exception {
        List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        Grupos obj_Grupos = new Grupos();
        obj_Grupos.setIdGrupo(IdGrupo);
        obj_Grupos.setNombreGrupo(NombreGrupo);
        obj_Grupos.setUsuarioIngreso(UsuarioIngreso);
        obj_Grupos.setFechaInicio(FechaInicio);
        obj_Grupos.setUsuarioModificacion(UsuarioModificacion);
        obj_Grupos.setFechaBaja(FechaBaja);
        obj_Grupos.setEstado(Estado);
        int estado = dao.saveOrUpdate(obj_Grupos, obj_Grupos.getClass());
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
