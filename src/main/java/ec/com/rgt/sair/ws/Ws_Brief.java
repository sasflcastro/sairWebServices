package ec.com.rgt.sair.ws;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.UtilsDAO;
import ec.com.rgt.sair.hbm.SairBriAccionArea;
import ec.com.rgt.sair.hbm.SairBriAcciones;
import ec.com.rgt.sair.hbm.SairBriAnexos;
import ec.com.rgt.sair.hbm.SairBriBrief;
import ec.com.rgt.sair.hbm.SairBriEstados;
import ec.com.rgt.sair.hbm.SairBriEstatus;
import ec.com.rgt.sair.hbm.SairBriProgramacion;
import ec.com.rgt.sair.hbm.SairBriSolicitud;
import ec.com.rgt.sair.hbm.SairDocReservacionCodigo;

@WebService()
public class Ws_Brief {
	DAO dao=new DAO();
	
	@WebMethod(operationName = "insertaBrief")
	public int insertaBrief(SairBriBrief arg0, int arg1){
		int i=0;
		if(arg1==0){
			i=dao.saveOrUpdate(arg0, arg0.getClass());
		}else{
			i=dao.delete(arg0, arg0.getClass());
		}
		return i;
	}
	
	@WebMethod(operationName = "insertaAnexo")
	public int insertaAnexo(SairBriAnexos arg0, int arg1){
		int i=0;
		if(arg1==0){
			i=dao.saveOrUpdate(arg0, arg0.getClass());
		}else{
			i=dao.delete(arg0, arg0.getClass());
		}
		return i;
	}
	
	@WebMethod(operationName = "insertaSolicitud")
	public int insertaSolicitud(int op, SairBriSolicitud solicitud, SairDocReservacionCodigo codigo, String idUsuarioRecibe){
		int i=0;
		try {
		i=dao.saveOrUpdate(solicitud, solicitud.getClass());
		if(op==0){
			SairBriProgramacion programacion=new SairBriProgramacion();
			programacion.setIdProgramacion(BigDecimal.ZERO);
			programacion.setIdUsuario(solicitud.getIdUsuario());
			programacion.setIdUsuarioRecibe(idUsuarioRecibe);
			@SuppressWarnings("unchecked")
			List<SairBriSolicitud> l=dao.find("from SairBriSolicitud s where s.idUsuario='"+solicitud.getIdUsuario()+"' and to_char(s.fechaCreacion,'dd/MM/yyyy')=to_char(sysdate,'dd/MM/yyyy') order by idSolicitud desc ");
			programacion.setSairBriSolicitud(l.get(0));
			SairDocReservacionCodigo sairDocReservacionCodigo=new SairDocReservacionCodigo();sairDocReservacionCodigo.setIdSecuenciaReservaCodigo(codigo.getIdSecuenciaReservaCodigo());
			programacion.setSairDocReservacionCodigo(sairDocReservacionCodigo);
			programacion.setSairBriEstados(new SairBriEstados(new BigDecimal(1)));
			i=dao.saveOrUpdate(programacion, programacion.getClass());
			SairBriBrief b =new SairBriBrief(BigDecimal.ZERO);
			UtilsDAO utilsDAO=new UtilsDAO();
			b.setCodigo(utilsDAO.generaCodigo(codigo.getSairArea().getIdArea(), solicitud.getIdUsuario()));
			b.setIdUsuario(idUsuarioRecibe);
			b.setAsunto("A");
			b.setFechaCreacion(new Date());
			b.setEstado("A");
			b.setIdArea(codigo.getSairArea().getIdArea());
			@SuppressWarnings("unchecked")
			List<SairBriProgramacion> list=dao.find("from SairBriProgramacion p where p.idUsuario='"+programacion.getIdUsuario()+"' and p.sairBriSolicitud.idSolicitud="+programacion.getSairBriSolicitud().getIdSolicitud()+" order by idProgramacion desc");
			b.setSairBriProgramacion(list.get(0));
			i=dao.saveOrUpdate(b, b.getClass());
			list.get(0).setCodigo(b.getCodigo());
			i=dao.saveOrUpdate(list.get(0), list.get(0).getClass());
		}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(Ws_Brief.class.getName()).log(Level.SEVERE, e.getMessage() );
		}
		return i;
	}
	
	@WebMethod(operationName = "insertaSolicitud2")
	public int insertaSolicitud2(int op, SairBriSolicitud solicitud, BigDecimal idArea,String idUsuarioRecibe){
		int i=0;
		try {
		i=dao.saveOrUpdate(solicitud, solicitud.getClass());
		if(op==0){
			SairBriProgramacion programacion=new SairBriProgramacion();
			programacion.setIdProgramacion(BigDecimal.ZERO);
			programacion.setIdUsuario(solicitud.getIdUsuario());
			programacion.setIdUsuarioRecibe(idUsuarioRecibe);
			@SuppressWarnings("unchecked")
			List<SairBriSolicitud> l=dao.find("from SairBriSolicitud s where s.idUsuario='"+solicitud.getIdUsuario()+"' and to_char(s.fechaCreacion,'dd/MM/yyyy')=to_char(sysdate,'dd/MM/yyyy') order by idSolicitud desc ");
			programacion.setSairBriSolicitud(l.get(0));
			programacion.setSairBriEstados(new SairBriEstados(new BigDecimal(1)));
			i=dao.saveOrUpdate(programacion, programacion.getClass());
			SairBriBrief b =new SairBriBrief(BigDecimal.ZERO);
			UtilsDAO utilsDAO=new UtilsDAO();
			b.setCodigo(utilsDAO.generaCodigo(idArea, solicitud.getIdUsuario()));
			b.setIdUsuario(idUsuarioRecibe);
			b.setAsunto("A");
			b.setFechaCreacion(new Date());
			b.setEstado("A");
			b.setIdArea(idArea);
			@SuppressWarnings("unchecked")
			List<SairBriProgramacion> list=dao.find("from SairBriProgramacion p where p.idUsuario='"+programacion.getIdUsuario()+"' and p.sairBriSolicitud.idSolicitud="+programacion.getSairBriSolicitud().getIdSolicitud()+" order by idProgramacion desc");
			b.setSairBriProgramacion(list.get(0));
			i=dao.saveOrUpdate(b, b.getClass());
			list.get(0).setCodigo(b.getCodigo());
			i=dao.saveOrUpdate(list.get(0), list.get(0).getClass());
		}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(Ws_Brief.class.getName()).log(Level.SEVERE, e.getMessage() );
		}
		return i;
	}
	
	@WebMethod(operationName = "insertaProgramacion")
	public int insertaProgramacion(SairBriProgramacion arg0, int arg1){
		int i=0;
		if(arg1==0){
			i=dao.saveOrUpdate(arg0, arg0.getClass());
		}else{
			i=dao.delete(arg0, arg0.getClass());
		}
		return i;
	}
	
	@WebMethod(operationName = "consulta_programacion")
	public List<SairBriProgramacion> consulta_programacion(String hql){
		@SuppressWarnings("unchecked")
		List<SairBriProgramacion> list=dao.find(hql);
		return list;
	}
	
	@WebMethod(operationName = "consulta_brief")
	public List<SairBriBrief> consulta_brief(String hql){
		@SuppressWarnings("unchecked")
		List<SairBriBrief> list=dao.find(hql);
		return list;
	}
	
	@WebMethod(operationName = "consulta_anexo")
	public List<SairBriAnexos> consulta_anexo(String hql){
		@SuppressWarnings("unchecked")
		List<SairBriAnexos> list=dao.find(hql);
		return list;
	}
	
	@WebMethod(operationName = "generaCodigo")
	public String generaCodigo(@WebParam(name="idArea") BigDecimal idArea,@WebParam(name="user")String  user){
		UtilsDAO list=new UtilsDAO();
		return list.generaCodigo(idArea, user);
	}
	
	@WebMethod(operationName = "getCategoria")
	public List<String> getCategoria(String nombreTabla){
		@SuppressWarnings("unchecked")
		List<String> briRiesgos= dao.find("select r.nombre from "+nombreTabla+" r where r.estado='A' order by r.nombre");
		return briRiesgos;
	}
	
	@WebMethod(operationName = "insertaAcciones")
	public int insertaAcciones(SairBriAcciones arg0, int arg1){
		int i=0;
		if(arg1==0){
			i=dao.saveOrUpdate(arg0, arg0.getClass());
		}else{
			@SuppressWarnings("unchecked")
			List<SairBriAccionArea> accionAreas=dao.find("from SairBriAccionArea a where a.id.idAccion="+arg0.getIdAccion());
			for (SairBriAccionArea sairBriAccionArea : accionAreas) {
				i=dao.delete(sairBriAccionArea, sairBriAccionArea.getClass());
			}
			i=dao.delete(arg0, arg0.getClass());
		}
		return i;
	}
	
	@WebMethod(operationName = "consulta_acciones")
	public List<SairBriAcciones> consulta_acciones(String hql){
		@SuppressWarnings("unchecked")
		List<SairBriAcciones> list=dao.find(hql);
		return list;
	}
	
	@WebMethod(operationName = "getEstatus")
	public List<SairBriEstatus> getEstatus(){
		@SuppressWarnings("unchecked")
		List<SairBriEstatus> briRiesgos= dao.find("from SairBriEstatus r where r.estado='A' order by r.nombre");
		return briRiesgos;
	}
	
	@WebMethod(operationName = "insertaAccionesArea")
	public int insertaAccionesArea(SairBriAccionArea arg0, int arg1){
		int i=0;
		if(arg1==0){
			i=dao.saveOrUpdate(arg0, arg0.getClass());
		}else{
			i=dao.delete(arg0, arg0.getClass());
		}
		return i;
	}
	
	@WebMethod(operationName = "deleteAccionArea")
	public int deleteAccionArea(BigDecimal idAccion){
		@SuppressWarnings("unchecked")
		List<SairBriAccionArea> briRiesgos= dao.find("from SairBriAccionArea r where r.id.idAccion="+idAccion);
		int r=0;
		for (SairBriAccionArea sairBriAccionArea : briRiesgos) {
			r=dao.delete(sairBriAccionArea, sairBriAccionArea.getClass());
		}
		return r;
	}
	
	@WebMethod(operationName = "consulta_accionesArea")
	public List<SairBriAccionArea> consulta_accionesArea(String hql){
		@SuppressWarnings("unchecked")
		List<SairBriAccionArea> list=dao.find(hql);
		return list;
	}
	
	@WebMethod(operationName = "consulta_estados")
	public List<SairBriEstados> consulta_estados(String hql){
		@SuppressWarnings("unchecked")
		List<SairBriEstados> list=dao.find(hql);
		return list;
	}

}
