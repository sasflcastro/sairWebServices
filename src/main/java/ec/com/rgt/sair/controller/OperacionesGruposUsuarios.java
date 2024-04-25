package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.GruposUsuariosDAO;
import ec.com.rgt.sair.hbm.GruposUsuarios;
import ec.com.rgt.sair.hbm.GruposUsuariosId;
import ec.com.rgt.sair.hbm.Usuarios;


public class OperacionesGruposUsuarios {
	
	DAO dao = new DAO();
	GruposUsuariosDAO Obj_GruposUsuariosDAO = new GruposUsuariosDAO();
	
	@SuppressWarnings("unchecked")
	public List<GruposUsuarios> ListaGruposUsuarios() throws Exception {
        List<GruposUsuarios> LstGruposUsuarios = new ArrayList<GruposUsuarios>();
        LstGruposUsuarios = Obj_GruposUsuariosDAO.ListaGruposUsuarios();
        return LstGruposUsuarios;
    }
	
	@SuppressWarnings("unchecked")
	public List<GruposUsuarios> ConsultaGruposUsuarios(BigDecimal IdGrupo, String IdUsuario) throws Exception {
		List<GruposUsuarios> LstGruposUsuarios = new ArrayList<GruposUsuarios>();
		LstGruposUsuarios = Obj_GruposUsuariosDAO.ConsultaGruposUsuarios(IdGrupo, IdUsuario);
        return LstGruposUsuarios;
    }
	
	@SuppressWarnings("unchecked")
	public List<GruposUsuarios> findGruposUsuarios(String hqlGruposUsuarios) throws Exception {
        List<GruposUsuarios> LstGruposUsuarios = new ArrayList<GruposUsuarios>();
        LstGruposUsuarios = Obj_GruposUsuariosDAO.findGruposUsuarios(hqlGruposUsuarios);
        List<GruposUsuarios> LstUsuarios1 = new ArrayList<GruposUsuarios>();
        OperacionesUsuario operacionesUsuario=new OperacionesUsuario();
        
        List<String> claves = new ArrayList<String>();
        
        for(GruposUsuarios gu: LstGruposUsuarios) {
        	String clave_ = new String(gu.getUsuarios().getClave());
        	claves.add(clave_);
        }
        
        for (int i = 0; i < LstGruposUsuarios.size(); i++) {
        	GruposUsuarios usuar = (GruposUsuarios) LstGruposUsuarios.get(i);
        	String clave = claves.get(i);
        	usuar.getUsuarios().setClave(operacionesUsuario.stripNonValidXMLCharacters(JBlowfish.decrypt(clave)));
        	LstUsuarios1.add(usuar);
        	
        }
        return LstUsuarios1;
	}
	
	public List<Mensaje> IngresaGruposUsuarios(BigDecimal IdGrupo, String IdUsuario, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		GruposUsuariosId Obj_GruposUsuariosId = new GruposUsuariosId();
        Obj_GruposUsuariosId.setIdGrupo(IdGrupo);
        Obj_GruposUsuariosId.setIdUsuario(IdUsuario);
        GruposUsuarios Obj_GruposUsuarios = new GruposUsuarios();
        Obj_GruposUsuarios.setId(Obj_GruposUsuariosId);
        Obj_GruposUsuarios.setUsuarioIngreso(UsuarioIngreso);
        Obj_GruposUsuarios.setFechaInicio(FechaInicio);
        Obj_GruposUsuarios.setUsuarioModificacion(UsuarioModificacion);
        Obj_GruposUsuarios.setFechaBaja(FechaBaja);
        Obj_GruposUsuarios.setEstado(Estado);
        int estado = dao.saveOrUpdate(Obj_GruposUsuarios, Obj_GruposUsuarios.getClass());
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
	
	public List<Mensaje> EliminaGruposUsuarios(BigDecimal IdGrupo, String IdUsuario, String UsuarioIngreso, Date FechaInicio, String UsuarioModificacion, Date FechaBaja, String Estado) throws Exception {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		GruposUsuariosId Obj_GruposUsuariosId = new GruposUsuariosId();
        Obj_GruposUsuariosId.setIdGrupo(IdGrupo);
        Obj_GruposUsuariosId.setIdUsuario(IdUsuario);
        GruposUsuarios Obj_GruposUsuarios = new GruposUsuarios();
        Obj_GruposUsuarios.setId(Obj_GruposUsuariosId);
        Obj_GruposUsuarios.setUsuarioIngreso(UsuarioIngreso);
        Obj_GruposUsuarios.setFechaInicio(FechaInicio);
        Obj_GruposUsuarios.setUsuarioModificacion(UsuarioModificacion);
        Obj_GruposUsuarios.setFechaBaja(FechaBaja);
        Obj_GruposUsuarios.setEstado(Estado);
        int estado = dao.delete(Obj_GruposUsuarios, Obj_GruposUsuarios.getClass());
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
