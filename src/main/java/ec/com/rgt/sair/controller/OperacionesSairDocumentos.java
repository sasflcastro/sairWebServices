package ec.com.rgt.sair.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.SairDocumentosDAO;
import ec.com.rgt.sair.hbm.SairDocAjusteCorreccion;
import ec.com.rgt.sair.hbm.SairDocAnexoDocumento;
import ec.com.rgt.sair.hbm.SairDocArnp;
import ec.com.rgt.sair.hbm.SairDocConclusionDocumento;
import ec.com.rgt.sair.hbm.SairDocDestinatario;
import ec.com.rgt.sair.hbm.SairDocDiscusionInf;
import ec.com.rgt.sair.hbm.SairDocInformes;
import ec.com.rgt.sair.hbm.SairDocMemorando;
import ec.com.rgt.sair.hbm.SairDocPasos;
import ec.com.rgt.sair.hbm.SairDocPlantillaDocumento;
import ec.com.rgt.sair.hbm.SairDocRequerimientoCorrecc;
import ec.com.rgt.sair.hbm.SairDocReservacionCodigo;
import ec.com.rgt.sair.hbm.SairDocRiesgoDocumento;
import ec.com.rgt.sair.hbm.SairDocRiesgoRc;
import ec.com.rgt.sair.hbm.SairDocTipoEvento;
import ec.com.rgt.sair.hbm.SairDocTipoHallazgo;
import ec.com.rgt.sair.hbm.SairEstadosPrincipal;
import ec.com.rgt.sair.hbm.SairRecConclusionReco;

public class OperacionesSairDocumentos {

	DAO dao = new DAO();
	SairDocumentosDAO ObjSairDocumentos = new SairDocumentosDAO();

	public List<SairDocInformes> FindSairDocInformes(String hqlInformes) {
		List<SairDocInformes> LstSairDocInformes = new ArrayList<SairDocInformes>();
		LstSairDocInformes = ObjSairDocumentos.findInformes(hqlInformes);
		return LstSairDocInformes;
	}

	public List<SairDocAjusteCorreccion> FindSairDocAjusteCorreccion(String hql) {
		List<SairDocAjusteCorreccion> LstSairDocInformes = new ArrayList<SairDocAjusteCorreccion>();
		LstSairDocInformes = ObjSairDocumentos.findSairAjuste(hql);
		return LstSairDocInformes;
	}

	public List<SairDocMemorando> FindSairDocMemorando(String hqlMemorandos) {
		List<SairDocMemorando> LstSairDocMemorando = new ArrayList<SairDocMemorando>();
		LstSairDocMemorando = ObjSairDocumentos.findMemorandos(hqlMemorandos);
		return LstSairDocMemorando;
	}

	public List<SairDocArnp> FindSairDocArnp(String hqlArnp) {
		List<SairDocArnp> LstSairDocArnp = new ArrayList<SairDocArnp>();
		LstSairDocArnp = ObjSairDocumentos.findArnps(hqlArnp);
		return LstSairDocArnp;
	}

	public List<SairDocRequerimientoCorrecc> FindSairDocRequerimientoC(String hqlRCs) {
		List<SairDocRequerimientoCorrecc> LstSairDocRequerimientoC = new ArrayList<SairDocRequerimientoCorrecc>();
		LstSairDocRequerimientoC = ObjSairDocumentos.findRCs(hqlRCs);
		return LstSairDocRequerimientoC;
	}

	public List<SairDocRiesgoRc> FindSairDocRiesgoRc(String hqlRsgRC) {
		List<SairDocRiesgoRc> LstSairDocRiesgoRc = new ArrayList<SairDocRiesgoRc>();
		LstSairDocRiesgoRc = ObjSairDocumentos.findRiesRC(hqlRsgRC);
		return LstSairDocRiesgoRc;
	}

	public List<SairDocConclusionDocumento> FindSairDocConclusionDocumento(String hqlConclusion) {
		List<SairDocConclusionDocumento> LstSairDocConclusionDocumento = new ArrayList<SairDocConclusionDocumento>();
		LstSairDocConclusionDocumento = ObjSairDocumentos.findConclusion(hqlConclusion);
		return LstSairDocConclusionDocumento;
	}

	public List<SairRecConclusionReco> FindSairRecConclusionReco(String hqlRecCon) {
		List<SairRecConclusionReco> LstSairRecConclusionReco = new ArrayList<SairRecConclusionReco>();
		LstSairRecConclusionReco = ObjSairDocumentos.findSairRecConclusionReco(hqlRecCon);
		return LstSairRecConclusionReco;
	}

	public List<SairDocPlantillaDocumento> FindSairDocPlantillaDocumento(String hqlPlantillaDoc) {
		List<SairDocPlantillaDocumento> LstSairDocPlantillaDocumento = new ArrayList<SairDocPlantillaDocumento>();
		LstSairDocPlantillaDocumento = ObjSairDocumentos.findPlantillaDoc(hqlPlantillaDoc);
		return LstSairDocPlantillaDocumento;
	}

	public List<SairDocAnexoDocumento> FindAnexoDocumentos(String hqlAnexoDoc) {
		List<SairDocAnexoDocumento> LstSairDocAnexoDocumento = new ArrayList<SairDocAnexoDocumento>();
		LstSairDocAnexoDocumento = ObjSairDocumentos.findAnexoDocumentos(hqlAnexoDoc);
		return LstSairDocAnexoDocumento;
	}

	public List<SairDocDiscusionInf> findSairDocDiscusionInf(String hqlSairDocDiscusionInf) {
		List<SairDocDiscusionInf> LstSairDocDiscusionInf = new ArrayList<SairDocDiscusionInf>();
		LstSairDocDiscusionInf = ObjSairDocumentos.findSairDocDiscusionInf(hqlSairDocDiscusionInf);
		return LstSairDocDiscusionInf;
	}

	public List<SairDocPasos> findSairDocPasos(String hqlSairDocPasos) {
		List<SairDocPasos> LstSairDocPasos = new ArrayList<SairDocPasos>();
		LstSairDocPasos = ObjSairDocumentos.findSairDocPasos(hqlSairDocPasos);
		return LstSairDocPasos;
	}

	public List<SairDocReservacionCodigo> findSairDocReservacionCodigo(String hqlReservacion) {
		List<SairDocReservacionCodigo> LstSairDocPasos = new ArrayList<SairDocReservacionCodigo>();
		LstSairDocPasos = ObjSairDocumentos.findSairDocReservacionCodigo(hqlReservacion);
		return LstSairDocPasos;
	}

	public List<SairDocDestinatario> findSairDocDestinatario(String hqlDestinatario) {
		List<SairDocDestinatario> LstSairDocDestinatario = new ArrayList<SairDocDestinatario>();
		LstSairDocDestinatario = ObjSairDocumentos.findSairDocDestinatario(hqlDestinatario);
		return LstSairDocDestinatario;
	}
	
	public SairDocPlantillaDocumento ObtenerPlantillaDocumento(SairDocPlantillaDocumento objSairDocDocumento) {
		SairDocPlantillaDocumento tmpFinalObj = objSairDocDocumento;
		
		Connection conn = null;
		SairConnection objConnSair = new SairConnection();
		
		int secuenciaCodigo = objSairDocDocumento.getSairDocReservacionCodigo().getIdSecuenciaReservaCodigo().intValue();
		int tipoDocumento = objSairDocDocumento.getSairDocTipoDocumento().getIdTipoDocumento().intValue();
		int tipoInforme = 0;
		
		try {
			objConnSair.conectar();
			conn = objConnSair.getConnection();

			if (conn != null) {
				
				System.out.println("Conexion Exitosa.");
				
				String sentencia = "SELECT DETALLE, PLANTILLA_ENVIO FROM USRSAIR.SAIR_DOC_PLANTILLA_DOCUMENTO "
						+ "WHERE ID_TIPO_DOCUMENTO = " + tipoDocumento + " AND ID_SECUENCIA_RESERVA_CODIGO = " + secuenciaCodigo +
						(tipoDocumento==1?" AND ID_TIPO_INFORME = " + tipoInforme : "");
				
				PreparedStatement pstm = conn.prepareStatement(sentencia);
				ResultSet rs = pstm.executeQuery();
				
				Clob detalleResp = null;
				Clob plantillaEnvioResp = null;
				while(rs.next()) {
					detalleResp = rs.getClob(1);
					plantillaEnvioResp = rs.getClob(2);
				}
				
				String detalleFinal = detalleResp!=null?clobToString(detalleResp):null;
				String plantillaEnvioFinal = plantillaEnvioResp!=null?clobToString(plantillaEnvioResp):null;
				
				if(detalleFinal!=null && !detalleFinal.isEmpty()) tmpFinalObj.setDetalle(detalleFinal);
				if(plantillaEnvioFinal!=null && !plantillaEnvioFinal.isEmpty()) tmpFinalObj.setPlantillaEnvio(plantillaEnvioFinal);
 
			} else {
				System.out.println("No fue posible conectar a la base de datos.");
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
		}
		
		return tmpFinalObj;
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

	/**
	 * @param cadena
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void IngresaClobDataOnTableUpdate(SairDocPlantillaDocumento cadena)
			throws IOException, InterruptedException {
		Connection conn;
		SairConnection objConnSair = new SairConnection();
		int secuenciaCodigo = cadena.getSairDocReservacionCodigo().getIdSecuenciaReservaCodigo().intValue();
		int tipoDocumento = cadena.getSairDocTipoDocumento().getIdTipoDocumento().intValue();
		int tipoInforme = 0;
		try {
			tipoInforme = cadena.getSairDocTipoInforme().getIdTipoInforme().intValue();
		} catch (NullPointerException e) {
		    tipoInforme = 0;
		}

		try {
			objConnSair.conectar();
			conn = objConnSair.getConnection();

			if (conn != null) {
				System.out.println("Conexion Exitosa.");
				StringReader sr = new StringReader(cadena.getDetalle());
				StringReader sr2 = new StringReader(cadena.getPlantillaEnvio());
				CallableStatement pstm = conn.prepareCall("{call usrsair.PRC_INSERTA_PLANTILLA_DOC(?,?,?,?,?,?)}");
				pstm.setCharacterStream(1, sr, cadena.getDetalle().length());
				pstm.setCharacterStream(2, sr2, cadena.getPlantillaEnvio().length());
				pstm.setInt(3, tipoDocumento);
				pstm.setInt(4,tipoInforme);
				pstm.setInt(5, secuenciaCodigo);
				pstm.registerOutParameter(6, Types.VARCHAR);
				
				boolean respuesta = pstm.execute();
				
				String proceso = pstm.getString(6);
				
				System.out.println(proceso);
 
			} else {
				System.out.println("No fue posible conectar a la base de datos.");
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
		}

	}

	public List<Mensaje> IngresaSairDocInformes(SairDocInformes obj_SairInformes, int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int est = dao.saveOrUpdate(obj_SairInformes, obj_SairInformes.getClass());
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

	public List<Mensaje> IngresaSairDocMemorando(SairDocMemorando obj_SairDocMemorando, int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado1 = dao.saveOrUpdate(obj_SairDocMemorando, obj_SairDocMemorando.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado1 == 1) {
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

	public List<Mensaje> IngresaSairDocArnp(SairDocArnp obj_SairArnp, int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado1 = dao.saveOrUpdate(obj_SairArnp, obj_SairArnp.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado1 == 1) {
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

	public List<Mensaje> IngresaSairDocRC(SairDocRequerimientoCorrecc obj_SairDocRC, int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado1 = dao.saveOrUpdate(obj_SairDocRC, obj_SairDocRC.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado1 == 1) {
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

	public List<Mensaje> IngresaSairDocRiesgoRC(

			BigDecimal idReisgoRc, SairDocRequerimientoCorrecc sairDocRequerimientoCorrecc,
			SairDocRiesgoDocumento sairDocRiesgoDocumento, int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocRiesgoRc obj_SairDocRiesgoRc = new SairDocRiesgoRc();
		obj_SairDocRiesgoRc.setIdReisgoRc(idReisgoRc);
		obj_SairDocRiesgoRc.setSairDocRequerimientoCorrecc(sairDocRequerimientoCorrecc);
		obj_SairDocRiesgoRc.setSairDocRiesgoDocumento(sairDocRiesgoDocumento);

		int resultado = dao.saveOrUpdate(obj_SairDocRiesgoRc, obj_SairDocRiesgoRc.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (resultado == 1) {
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

	public List<Mensaje> IngresaSairDocConclusionDocumento(SairDocConclusionDocumento obj_SairDocConclusionD,
			int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.saveOrUpdate(obj_SairDocConclusionD, obj_SairDocConclusionD.getClass());
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

	public List<Mensaje> deleteSairDocConclusionDocumento(SairDocConclusionDocumento obj_SairDocConclusionD,
			int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado = dao.delete(obj_SairDocConclusionD, obj_SairDocConclusionD.getClass());
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

	public List<Mensaje> IngresaSairDocPlantillaDocumento(SairDocPlantillaDocumento obj_SairDocPlantillaD,
			int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		int estado1 = dao.saveOrUpdate(obj_SairDocPlantillaD, obj_SairDocPlantillaD.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado1 == 1) {
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

	public List<Mensaje> IngresaSairDocAnexoDocumento(BigDecimal idAnexoDocumento,
			SairDocReservacionCodigo sairDocReservacionCodigo, SairEstadosPrincipal sairEstadosPrincipal,
			String descripcion, String documentoAnexado, String rutaCompartida, Date fechaIngreso,
			Date fechaActualizacion, BigDecimal idEstadoComp, String extension, int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocAnexoDocumento obj_SairDocAnexo = new SairDocAnexoDocumento();
		obj_SairDocAnexo.setIdAnexoDocumento(idAnexoDocumento);
		obj_SairDocAnexo.setSairDocReservacionCodigo(sairDocReservacionCodigo);
		obj_SairDocAnexo.setSairEstadosPrincipal(sairEstadosPrincipal);
		obj_SairDocAnexo.setDescripcion(descripcion);
		obj_SairDocAnexo.setDocumentoAnexado(documentoAnexado);
		obj_SairDocAnexo.setRutaCompartida(rutaCompartida);
		obj_SairDocAnexo.setFechaIngreso(fechaIngreso);
		obj_SairDocAnexo.setFechaActualizacion(fechaActualizacion);
		obj_SairDocAnexo.setIdEstadoComp(idEstadoComp);
		obj_SairDocAnexo.setExtension(extension);

		int estado1 = dao.saveOrUpdate(obj_SairDocAnexo, obj_SairDocAnexo.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (estado1 == 1) {
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

	public List<Mensaje> deleteSairDocAnexoDocumento(BigDecimal idAnexoDocumento,
			SairDocReservacionCodigo sairDocReservacionCodigo, SairEstadosPrincipal sairEstadosPrincipal,
			String descripcion, String documentoAnexado, String rutaCompartida, Date fechaIngreso,
			Date fechaActualizacion, BigDecimal idEstadoComp, String extension, int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocAnexoDocumento obj_SairDocAnexo = new SairDocAnexoDocumento();
		obj_SairDocAnexo.setIdAnexoDocumento(idAnexoDocumento);
		obj_SairDocAnexo.setSairDocReservacionCodigo(sairDocReservacionCodigo);
		obj_SairDocAnexo.setSairEstadosPrincipal(sairEstadosPrincipal);
		obj_SairDocAnexo.setDescripcion(descripcion);
		obj_SairDocAnexo.setDocumentoAnexado(documentoAnexado);
		obj_SairDocAnexo.setRutaCompartida(rutaCompartida);
		obj_SairDocAnexo.setFechaIngreso(fechaIngreso);
		obj_SairDocAnexo.setFechaActualizacion(fechaActualizacion);
		obj_SairDocAnexo.setIdEstadoComp(idEstadoComp);
		obj_SairDocAnexo.setExtension(extension);

		int estado = dao.delete(obj_SairDocAnexo, obj_SairDocAnexo.getClass());
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

	public List<Mensaje> IngresaSairDocDiscusionInf(BigDecimal idDiscusion,
			SairDocReservacionCodigo sairDocReservacionCodigo, String idUsuario, String estados, String discusion,
			Date fechaIngreso, String url, String extencion, int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocDiscusionInf obj_SairDocConclusionD = new SairDocDiscusionInf();
		obj_SairDocConclusionD.setIdDiscusion(idDiscusion);
		obj_SairDocConclusionD.setSairDocReservacionCodigo(sairDocReservacionCodigo);
		obj_SairDocConclusionD.setDiscusion(discusion);
		obj_SairDocConclusionD.setEstado(estados);
		obj_SairDocConclusionD.setIdUsuario(idUsuario);
		obj_SairDocConclusionD.setFechaIngreso(fechaIngreso);
		obj_SairDocConclusionD.setUrl(url);
		obj_SairDocConclusionD.setExtencion(extencion);
		int estado = dao.saveOrUpdate(obj_SairDocConclusionD, obj_SairDocConclusionD.getClass());
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

	public List<Mensaje> IngresaSairDocPasos(BigDecimal idPasos, SairDocReservacionCodigo sairDocReservacionCodigo,
			String idUsuario, Date fechaIngreso, String estado, String pasos, int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocPasos obj_SairDocPasosD = new SairDocPasos();
		obj_SairDocPasosD.setIdPasos(idPasos);
		obj_SairDocPasosD.setSairDocReservacionCodigo(sairDocReservacionCodigo);
		obj_SairDocPasosD.setIdUsuario(idUsuario);
		obj_SairDocPasosD.setFechaIngreso(fechaIngreso);
		obj_SairDocPasosD.setEstado(estado);
		obj_SairDocPasosD.setPasos(pasos);

		int resultado = dao.saveOrUpdate(obj_SairDocPasosD, obj_SairDocPasosD.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (resultado == 1) {
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

	public List<Mensaje> deleteSairDocDiscusionInf(BigDecimal idDiscusion,
			SairDocReservacionCodigo sairDocReservacionCodigo, String idUsuario, String estados, String discusion,
			Date fechaIngreso, int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocDiscusionInf obj_SairDocConclusionD = new SairDocDiscusionInf();
		obj_SairDocConclusionD.setIdDiscusion(idDiscusion);
		obj_SairDocConclusionD.setSairDocReservacionCodigo(sairDocReservacionCodigo);
		obj_SairDocConclusionD.setDiscusion(discusion);
		obj_SairDocConclusionD.setEstado(estados);
		obj_SairDocConclusionD.setIdUsuario(idUsuario);
		obj_SairDocConclusionD.setFechaIngreso(fechaIngreso);

		int estado = dao.delete(obj_SairDocConclusionD, obj_SairDocConclusionD.getClass());
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

	public List<Mensaje> deleteSairDocPasos(BigDecimal idPasos, SairDocReservacionCodigo sairDocReservacionCodigo,
			String idUsuario, Date fechaIngreso, String estado, String pasos, int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocPasos obj_SairDocPasos = new SairDocPasos();
		obj_SairDocPasos.setIdPasos(idPasos);
		obj_SairDocPasos.setSairDocReservacionCodigo(sairDocReservacionCodigo);
		obj_SairDocPasos.setIdUsuario(idUsuario);
		obj_SairDocPasos.setFechaIngreso(fechaIngreso);
		obj_SairDocPasos.setEstado(estado);
		obj_SairDocPasos.setPasos(pasos);

		int resultado = dao.delete(obj_SairDocPasos, obj_SairDocPasos.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (resultado == 1) {
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

	public List<Mensaje> deleteSairDocRiesgoRc(BigDecimal idReisgoRc,
			SairDocRequerimientoCorrecc sairDocRequerimientoCorrecc, SairDocRiesgoDocumento sairDocRiesgoDocumento,
			int TipoTransc) {

		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocRiesgoRc obj_SairDocRiesgoRc = new SairDocRiesgoRc();
		obj_SairDocRiesgoRc.setIdReisgoRc(idReisgoRc);
		obj_SairDocRiesgoRc.setSairDocRequerimientoCorrecc(sairDocRequerimientoCorrecc);
		obj_SairDocRiesgoRc.setSairDocRiesgoDocumento(sairDocRiesgoDocumento);

		int resultado = dao.delete(obj_SairDocRiesgoRc, obj_SairDocRiesgoRc.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (resultado == 1) {
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

	public List<SairDocTipoHallazgo> FindSairDocTipoHallazgo(String hqlArnp) {
		List<SairDocTipoHallazgo> LstSairDocTipoHallazgo = new ArrayList<SairDocTipoHallazgo>();
		LstSairDocTipoHallazgo = ObjSairDocumentos.findTipoHallazgo(hqlArnp);
		return LstSairDocTipoHallazgo;
	}

	public List<Mensaje> IngresaSairDocTipoHallazgoInf(BigDecimal idTipoHallazgo, String nombre, String estado,
			int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocTipoHallazgo obj_SairDocTipoHallazgo = new SairDocTipoHallazgo();
		obj_SairDocTipoHallazgo.setIdTipoHallazgo(idTipoHallazgo);
		obj_SairDocTipoHallazgo.setNombre(nombre);
		obj_SairDocTipoHallazgo.setEstado(estado);

		int resultado = dao.saveOrUpdate(obj_SairDocTipoHallazgo, obj_SairDocTipoHallazgo.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (resultado == 1) {
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

	public List<SairDocTipoEvento> FindSairDocTipoEvento(String hqlArnp) {
		List<SairDocTipoEvento> LstSairDocTipoHallazgo = new ArrayList<SairDocTipoEvento>();
		LstSairDocTipoHallazgo = ObjSairDocumentos.findTipoEvento(hqlArnp);
		return LstSairDocTipoHallazgo;
	}

	public List<Mensaje> IngresaSairDocTipoEventoInf(BigDecimal idTipoEvento, String nombre, String estado,
			int TipoTransc) {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		SairDocTipoEvento obj_SairDocTipoEvento = new SairDocTipoEvento();
		obj_SairDocTipoEvento.setIdTipoEvento(idTipoEvento);
		obj_SairDocTipoEvento.setNombre(nombre);
		obj_SairDocTipoEvento.setEstado(estado);

		int resultado = dao.saveOrUpdate(obj_SairDocTipoEvento, obj_SairDocTipoEvento.getClass());
		Mensaje Obj_Mensaje = new Mensaje();
		if (resultado == 1) {
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
