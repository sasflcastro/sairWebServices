package ec.com.rgt.sair.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairDocumentosDAO;
import ec.com.rgt.sair.hbm.SairDocAlcance;
import ec.com.rgt.sair.hbm.SairDocDestinatario;
import ec.com.rgt.sair.hbm.SairDocEscalamiento;
import ec.com.rgt.sair.hbm.SairDocInformes;
import ec.com.rgt.sair.hbm.SairDocPlantilla;
import ec.com.rgt.sair.hbm.SairDocReservacionCodigo;
import ec.com.rgt.sair.hbm.SairDocRiesgoDocumento;
import ec.com.rgt.sair.hbm.SairDocRiesgoInforme;
import ec.com.rgt.sair.hbm.SairDocTipoDocumento;
import ec.com.rgt.sair.hbm.SairDocTipoInforme;
import ec.com.rgt.sair.hbm.SairEstadoComplementario;
import ec.com.rgt.sair.hbm.SairEstadoReco;
import ec.com.rgt.sair.hbm.SairEstadosPrincipal;
import ec.com.rgt.sair.hbm.SairParRutina;
import ec.com.rgt.sair.hbm.SairPrioridad;

public class OperacionesSairDocComplementos {

	private DAO dao = new DAO();
	private SairDocumentosDAO ObjSairDocs = new SairDocumentosDAO();


	public List<SairDocReservacionCodigo> findReservacion(String hqlReservacion)
	{
		List<SairDocReservacionCodigo> lstSairFormato = new ArrayList<SairDocReservacionCodigo>();
		lstSairFormato = ObjSairDocs.findReservaCod(hqlReservacion);
		return lstSairFormato;
	}

	public List<SairDocTipoDocumento> findTipoDocumento(String hqlTipo)
	{
		List<SairDocTipoDocumento> lstSairFormato = new ArrayList<SairDocTipoDocumento>();
		lstSairFormato = ObjSairDocs.findTipoDoc(hqlTipo);
		return lstSairFormato;
	}

	public List<SairDocTipoInforme> findTipoInforme(String hqlTipoInf)
	{
		List<SairDocTipoInforme> lstSairTinforme = new ArrayList<SairDocTipoInforme>();
		lstSairTinforme = ObjSairDocs.findTipoInf(hqlTipoInf);
		return lstSairTinforme;
	}

	public List<SairEstadosPrincipal> findEstadosP(String hqlEstadosP)
	{
		List<SairEstadosPrincipal> lstSairEstadosP = new ArrayList<SairEstadosPrincipal>();
		lstSairEstadosP = ObjSairDocs.findEstadosP(hqlEstadosP);
		return lstSairEstadosP;
	}


	public List<SairDocRiesgoInforme> findRiesgInfo(String hqlRiesgInfo)
	{
		List<SairDocRiesgoInforme> lstSairRiesgInfo = new ArrayList<SairDocRiesgoInforme>();
		lstSairRiesgInfo = ObjSairDocs.findRiesgInf(hqlRiesgInfo);
		return lstSairRiesgInfo;
	}

	public List<SairDocDestinatario> findDestinatario(String hqlDestinatario)
	{
		List<SairDocDestinatario> lstSairDestinatario = new ArrayList<SairDocDestinatario>();
		lstSairDestinatario = ObjSairDocs.findDestinatario(hqlDestinatario);
		return lstSairDestinatario;
	}

	public List<SairDocRiesgoDocumento> findRiesgoDoc(String hqlRiesgoDoc)
	{
		List<SairDocRiesgoDocumento> lstSairRiesgoDoc = new ArrayList<SairDocRiesgoDocumento>();
		lstSairRiesgoDoc = ObjSairDocs.findRiesgoDoc(hqlRiesgoDoc);
		return lstSairRiesgoDoc;
	}
	
	private String clobToString(java.sql.Clob data)
	{
	    final StringBuilder sb = new StringBuilder();

	    try
	    {
	        final Reader         reader = data.getCharacterStream();
	        final BufferedReader br     = new BufferedReader(reader);

	        int b;
	        while(-1 != (b = br.read()))
	        {
	            sb.append((char)b);
	        }

	        br.close();
	    }
	    catch (SQLException e)
	    {
	    	System.out.println("SQL. Could not convert CLOB to string");
	        return e.toString();
	    }
	    catch (IOException e)
	    {
	        System.out.println("IO. Could not convert CLOB to string");
	        return e.toString();
	    }

	    return sb.toString();
	}

	public List<SairDocPlantilla> findPlantilla(String hqlPlantilla)
	{
		List<SairDocPlantilla> lstSairPlantilla = new ArrayList<SairDocPlantilla>();
		lstSairPlantilla = ObjSairDocs.findPlantilla(hqlPlantilla);
		
		/*List<SairDocPlantilla> lstSairPlantillaFinal = new ArrayList<SairDocPlantilla>();
		
		Connection conn;
		SairConnection objConnSair = new SairConnection();
		
		try {
			objConnSair.conectar();
			conn = objConnSair.getConnection();
			PreparedStatement pstm = null;
			ResultSet rs = null;
			for(SairDocPlantilla item: lstSairPlantilla) {
				if (conn != null) {
					pstm = conn.prepareStatement("Select plantilla from usrsair.sair_doc_plantilla where id_plantilla = ?");
					pstm.setInt(1,item.getIdPlantilla().intValue());
					
					rs = pstm.executeQuery();
					while(rs.next()) {
						Clob res = rs.getClob(1);
						String resFinal = res!=null?clobToString(res):null;
						if(resFinal!=null && !resFinal.isEmpty()) {
							if(item.getPlantilla()==null) {
								item.setPlantilla(resFinal); 
							}
						}
						lstSairPlantillaFinal.add(item);
					}
				}
			}
			
		} catch (SQLException e) {
			System.out.println("ERROR: " + e.getMessage());
		}finally {
			try {
				objConnSair.closeConnection();
				if(objConnSair.isClose()) {
					System.out.println("Conexion cerrada");
				}else {
					System.out.println("Problemas al cerrar conexion");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}*/
		
		return lstSairPlantilla;
	}

	public List<SairEstadoComplementario> findSairEstadoComplementariol(String hqlSairEstadoComplementario){
		List<SairEstadoComplementario> lstSairPlantilla = new ArrayList<SairEstadoComplementario>();
		lstSairPlantilla = ObjSairDocs.findSairEstadoComplementariol(hqlSairEstadoComplementario);
		return lstSairPlantilla;
	}

	public List<SairEstadoReco> findSairEstadoReco(String hqlSairEstadoReco){
		List<SairEstadoReco> lstSairPlantilla = new ArrayList<SairEstadoReco>();
		lstSairPlantilla = ObjSairDocs.findSairEstadoReco(hqlSairEstadoReco);
		return lstSairPlantilla;
	}

	public List<SairDocEscalamiento> findSairDocEscalamiento(String hqlEscalamiento){
		List<SairDocEscalamiento> lstSairPlantilla = new ArrayList<SairDocEscalamiento>();
		lstSairPlantilla = ObjSairDocs.findSairDocEscalamiento(hqlEscalamiento);
		return lstSairPlantilla;
	}

	public List<Mensaje> IngresaReservacionCodigo(SairDocReservacionCodigo sairDocReservacionCodigo, int TipoTransc)  {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado2 = dao.saveOrUpdate(sairDocReservacionCodigo, sairDocReservacionCodigo.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado2 == 1) {
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

	public List<Mensaje> IngresaDestinatario(BigDecimal idDestinatario,  SairDocReservacionCodigo sairDocReservacionCodigo,String emailPara, Date fechaRegistro,String emailCopia,String usuarioEnvio ,int TipoTransc)  {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocDestinatario obj_SairDestinatario = new SairDocDestinatario();
		obj_SairDestinatario.setIdDestinatario(idDestinatario);
		obj_SairDestinatario.setSairDocReservacionCodigo(sairDocReservacionCodigo);
		obj_SairDestinatario.setFechaRegistro(fechaRegistro);
		obj_SairDestinatario.setEmailPara(emailPara);
		obj_SairDestinatario.setEmailCopia(emailCopia);
		obj_SairDestinatario.setUsuarioEnvio(usuarioEnvio);
		int est = dao.saveOrUpdate(obj_SairDestinatario,
				obj_SairDestinatario.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (est == 1) {
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

	public List<Mensaje> IngresaRiesgoDoc(BigDecimal idRiesgo, String descripcion, Date fechaIngreso, Date fechaActualizacion, String usuarioIngreso, String usuarioActualizacion, String estado, int TipoTransc)  {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocRiesgoDocumento obj_SairRiesgoDoc = new SairDocRiesgoDocumento();
		obj_SairRiesgoDoc.setIdRiesgo(idRiesgo);
		obj_SairRiesgoDoc.setDescripcion(descripcion);
		obj_SairRiesgoDoc.setFechaIngreso(fechaIngreso);
		obj_SairRiesgoDoc.setFechaActualizacion(fechaActualizacion);
		obj_SairRiesgoDoc.setUsuarioIngreso(usuarioIngreso);
		obj_SairRiesgoDoc.setUsuarioActualizacion(usuarioActualizacion);
		obj_SairRiesgoDoc.setEstado(estado);
		int est = dao.saveOrUpdate(obj_SairRiesgoDoc,
				obj_SairRiesgoDoc.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (est == 1) {
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

	public List<Mensaje> IngresaEscalamiento(SairDocEscalamiento document, int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int est = dao.saveOrUpdate(document,
				document.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (est == 1) {
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

	public List<Mensaje> IngresaPlantilla(BigDecimal idPlantilla, BigDecimal idPlantillaHijo, String nombre, String plantilla, Date fechaIngreso, String usuarioIngreso, String estado, SairParRutina sairParRutina, int TipoTransc)  {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocPlantilla obj_SairPlantilla = new SairDocPlantilla();
		obj_SairPlantilla.setIdPlantilla(idPlantilla);
		obj_SairPlantilla.setIdPlantillaHijo(idPlantillaHijo);
		obj_SairPlantilla.setNombre(nombre);
		obj_SairPlantilla.setPlantilla(plantilla);
		obj_SairPlantilla.setFechaIngreso(fechaIngreso);
		obj_SairPlantilla.setUsuarioIngreso(usuarioIngreso);
		obj_SairPlantilla.setEstado(estado);
		obj_SairPlantilla.setSairParRutina(sairParRutina);
		int est = dao.saveOrUpdate(obj_SairPlantilla,
				obj_SairPlantilla.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (est == 1) {
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

	public List<Mensaje> deletePlantilla(BigDecimal idPlantilla, BigDecimal idPlantillaHijo, String nombre, String plantilla, Date fechaIngreso, String usuarioIngreso, String estado, int TipoTransc)  {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocPlantilla obj_SairPlantilla = new SairDocPlantilla();
		obj_SairPlantilla.setIdPlantilla(idPlantilla);
		obj_SairPlantilla.setIdPlantillaHijo(idPlantillaHijo);
		obj_SairPlantilla.setNombre(nombre);
		obj_SairPlantilla.setPlantilla(plantilla);
		obj_SairPlantilla.setFechaIngreso(fechaIngreso);
		obj_SairPlantilla.setUsuarioIngreso(usuarioIngreso);
		obj_SairPlantilla.setEstado(estado);
		int est = dao.delete(obj_SairPlantilla,
				obj_SairPlantilla.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (est == 1) {
			Obj_Mensaje.setIdMensaje(1);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Eliminacion Exitoso");

			} else {

				Obj_Mensaje.setMensaje("Actualizacion Exitosa");

			}

		} else {
			Obj_Mensaje.setIdMensaje(0);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Eliminacion Fallido");

			} else {

				Obj_Mensaje.setMensaje("Actualizacion Fallida");

			}
		}
		LstMensaje.add(Obj_Mensaje);
		return LstMensaje;
	}

	public List<Mensaje> IngresaSairDocRiesgoInforme(BigDecimal idRiesgoInforme, BigDecimal idEstadoComp, SairDocInformes sairDocInformes, SairDocRiesgoDocumento sairDocRiesgoDocumento, SairEstadosPrincipal sairEstadosPrincipal, int TipoTransc)  {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocRiesgoInforme obj_SairDestinatario = new SairDocRiesgoInforme();
		obj_SairDestinatario.setIdRiesgoInforme(idRiesgoInforme);
		obj_SairDestinatario.setIdEstadoComp(idEstadoComp);
		obj_SairDestinatario.setSairDocInformes(sairDocInformes);
		obj_SairDestinatario.setSairDocRiesgoDocumento(sairDocRiesgoDocumento);
		obj_SairDestinatario.setSairEstadosPrincipal(sairEstadosPrincipal);
		int est = dao.saveOrUpdate(obj_SairDestinatario,
				obj_SairDestinatario.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (est == 1) {
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

	public List<Mensaje> IngresaEstadoComplementario(SairEstadoComplementario complementario, int TipoTransc)  {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado2 = dao.saveOrUpdate(complementario, complementario.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado2 == 1) {
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
	
	public List<Mensaje> IngresaEstadoReco(SairEstadoReco estadoReco, int TipoTransc)  {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado2 = dao.saveOrUpdate(estadoReco, estadoReco.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado2 == 1) {
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
	
	public List<Mensaje> ingresaTipoDoc(SairDocTipoDocumento docTipoDocumento, int TipoTransc)  {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado2 = dao.saveOrUpdate(docTipoDocumento, docTipoDocumento.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado2 == 1) {
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
	
	public String ingresaSairPrioridad(String priorid,BigDecimal vRecuperar,BigDecimal vDevolver,BigDecimal cRecuperar,
			BigDecimal cDevolver,BigDecimal cSinAfectacion,String eOperativo,String eTecnologico,String usuario, int TipoTransc)  {
		SairPrioridad prioridad = new SairPrioridad();
		prioridad.setIdPrioridad(BigDecimal.ZERO);
		prioridad.setPrioridad(priorid);
		prioridad.setCasosDevolver(cDevolver);
		prioridad.setCasosRecuperar(cRecuperar);
		prioridad.setCasosSinAfectacion(cSinAfectacion);
		prioridad.setErrorOperativo(eOperativo);
		prioridad.setErrorTecnologico(eTecnologico);
		prioridad.setValorDevolver(vDevolver);
		prioridad.setValorRecuperar(vRecuperar);
		prioridad.setUsuario(usuario);
		prioridad.setFechaIngreso(new Date());
		int est = dao.saveOrUpdate(prioridad,prioridad.getClass());
		String msn="";
		if (est == 1) {
			try {
				msn= dao.Sqlquery("select max(t.id_prioridad) from SAIR_PRIORIDAD t where t.usuario='"+usuario+"'").get(0);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
		} 
		return msn;
	}
	

}
