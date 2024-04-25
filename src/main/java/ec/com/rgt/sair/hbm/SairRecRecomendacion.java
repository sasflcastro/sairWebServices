package ec.com.rgt.sair.hbm;

// Generated 14-oct-2013 14:03:09 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import ec.com.rgt.sair.hbm.SairEstadoComplementario;
import ec.com.rgt.sair.hbm.SairAreasAdam;
import ec.com.rgt.sair.hbm.SairDocReservacionCodigo;

/**
 * SairRecRecomendacion generated by hbmjava
 */
@SuppressWarnings("serial")
public class SairRecRecomendacion implements java.io.Serializable {

	private BigDecimal idRecomendacion;
	private SairEstadoReco sairEstadoReco;
	private SairArea sairArea;
	private SairDocReservacionCodigo sairDocReservacionCodigo;
	private SairEstadoComplementario sairEstadoComplementario;
	private SairAreasAdam sairAreasAdam;
	private String personaEncargada;
	private String gerenteEncargado;
	private String gerenteAnt;
	private String descripcion,respuestaAuditada;
	private BigDecimal diasSinRespuesta,bandera;
	private Date fechaAtencionTotal;
	private Date fechaCompromiso;
	private Date fechaRespuesta;
	private Date fechaDeBaja;
	private Date fechaDeEmision,fechaActualiza,fechaResAud;
	private Date fechaRespuestaRevision;
	private String dependeProveedor;
	private String codigo;
	private BigDecimal numero;
	private BigDecimal automatica;
	private String comentario;
	private Date fechaIngreso;
	private BigDecimal ano,idRecoPadre,rc,idTemp,infDefinitivo;
	private String areaEvaluada;
	private String estado;
	private String opTodos;
	private String personaAsignada,codigoProyecto;	
	private String revisionpolitica;
	private String codigoetica;
	
	public SairRecRecomendacion() {
	}

	
	public BigDecimal getInfDefinitivo() {
		return infDefinitivo;
	}


	public void setInfDefinitivo(BigDecimal infDefinitivo) {
		this.infDefinitivo = infDefinitivo;
	}


	public String getRespuestaAuditada() {
		return respuestaAuditada;
	}


	public void setRespuestaAuditada(String respuestaAuditada) {
		this.respuestaAuditada = respuestaAuditada;
	}


	public Date getFechaResAud() {
		return fechaResAud;
	}


	public void setFechaResAud(Date fechaResAud) {
		this.fechaResAud = fechaResAud;
	}


	public BigDecimal getIdTemp() {
		return idTemp;
	}


	public void setIdTemp(BigDecimal idTemp) {
		this.idTemp = idTemp;
	}


	public SairRecRecomendacion(BigDecimal idRecomendacion, SairArea sairArea,
			SairEstadoComplementario sairEstadoComplementario, String codigo, BigDecimal numero) {
		this.idRecomendacion = idRecomendacion;
		this.sairArea = sairArea;
		this.sairEstadoComplementario = sairEstadoComplementario;
		this.codigo = codigo;
		this.numero = numero;
	}

	public SairRecRecomendacion(BigDecimal idRecomendacion,
			SairDocReservacionCodigo sairDocReservacionCodigo,
			SairArea sairArea, 
			SairEstadoComplementario sairEstadoComplementario,SairAreasAdam sairAreasAdam, String personaEncargada,
			String gerenteEncargado, String gerenteAnt, String descripcion,
			Date fechaAtencionTotal, Date fechaCompromiso, Date fechaRespuesta,
			Date fechaDeBaja, String dependeProveedor, String codigo,
			BigDecimal numero, String comentario, Date fechaIngreso,
			BigDecimal ano, String areaEvaluada,Date fechaDeEmision, String estado, String opTodos,
			Date fechaRespuestaRevision,BigDecimal automatica,BigDecimal diasSinRespuesta,
			SairEstadoReco sairEstadoReco,BigDecimal idRecoPadre,BigDecimal rc,BigDecimal idTemp,Date fechaActualiza,
			String personaAsignada,String codigoProyecto,Date fechaResAud,String respuestaAuditada,BigDecimal bandera,BigDecimal infDefinitivo) {
		this.idRecomendacion = idRecomendacion;
		this.sairArea = sairArea;
		this.sairDocReservacionCodigo = sairDocReservacionCodigo;
		this.sairEstadoComplementario = sairEstadoComplementario;
		this.personaEncargada = personaEncargada;
		this.gerenteEncargado = gerenteEncargado;
		this.gerenteAnt = gerenteAnt;
		this.descripcion = descripcion;
		this.fechaAtencionTotal = fechaAtencionTotal;
		this.fechaCompromiso = fechaCompromiso;
		this.fechaRespuesta = fechaRespuesta;
		this.fechaDeBaja = fechaDeBaja;
		this.dependeProveedor = dependeProveedor;
		this.codigo = codigo;
		this.numero = numero;
		this.comentario = comentario;
		this.fechaIngreso = fechaIngreso;
		this.ano = ano;
		this.areaEvaluada = areaEvaluada;
		this.estado = estado;
		this.sairAreasAdam = sairAreasAdam;
		this.fechaDeEmision = fechaDeEmision;
		this.fechaRespuestaRevision = fechaRespuestaRevision;
		this.automatica=automatica;
		this.diasSinRespuesta= diasSinRespuesta;
		this.sairEstadoReco= sairEstadoReco;
		this.idRecoPadre = idRecoPadre;
		this.opTodos=opTodos;
		this.rc = rc;
		this.idTemp = idTemp;
		this.fechaActualiza = fechaActualiza;
		this.personaAsignada=personaAsignada;
		this.codigoProyecto= codigoProyecto;
		this.fechaResAud=fechaResAud;
		this.respuestaAuditada=respuestaAuditada;
		this.bandera=bandera;
		this.infDefinitivo = infDefinitivo;
	}


	public SairRecRecomendacion(BigDecimal idRecomendacion,
			SairDocReservacionCodigo sairDocReservacionCodigo,
			SairArea sairArea, 
			SairEstadoComplementario sairEstadoComplementario,SairAreasAdam sairAreasAdam, String personaEncargada,
			String gerenteEncargado, String gerenteAnt, String descripcion,
			Date fechaAtencionTotal, Date fechaCompromiso, Date fechaRespuesta,
			Date fechaDeBaja, String dependeProveedor, String codigo,
			BigDecimal numero, String comentario, Date fechaIngreso,
			BigDecimal ano, String areaEvaluada,Date fechaDeEmision, String estado, String opTodos,
			Date fechaRespuestaRevision,BigDecimal automatica,BigDecimal diasSinRespuesta,
			SairEstadoReco sairEstadoReco,BigDecimal idRecoPadre,BigDecimal rc,BigDecimal idTemp,Date fechaActualiza,
			String personaAsignada,String codigoProyecto,Date fechaResAud,String respuestaAuditada,BigDecimal bandera,BigDecimal infDefinitivo
			,String revisionpolitica, String codigoetica) {
		this.idRecomendacion = idRecomendacion;
		this.sairArea = sairArea;
		this.sairDocReservacionCodigo = sairDocReservacionCodigo;
		this.sairEstadoComplementario = sairEstadoComplementario;
		this.personaEncargada = personaEncargada;
		this.gerenteEncargado = gerenteEncargado;
		this.gerenteAnt = gerenteAnt;
		this.descripcion = descripcion;
		this.fechaAtencionTotal = fechaAtencionTotal;
		this.fechaCompromiso = fechaCompromiso;
		this.fechaRespuesta = fechaRespuesta;
		this.fechaDeBaja = fechaDeBaja;
		this.dependeProveedor = dependeProveedor;
		this.codigo = codigo;
		this.numero = numero;
		this.comentario = comentario;
		this.fechaIngreso = fechaIngreso;
		this.ano = ano;
		this.areaEvaluada = areaEvaluada;
		this.estado = estado;
		this.sairAreasAdam = sairAreasAdam;
		this.fechaDeEmision = fechaDeEmision;
		this.fechaRespuestaRevision = fechaRespuestaRevision;
		this.automatica=automatica;
		this.diasSinRespuesta= diasSinRespuesta;
		this.sairEstadoReco= sairEstadoReco;
		this.idRecoPadre = idRecoPadre;
		this.opTodos=opTodos;
		this.rc = rc;
		this.idTemp = idTemp;
		this.fechaActualiza = fechaActualiza;
		this.personaAsignada=personaAsignada;
		this.codigoProyecto= codigoProyecto;
		this.fechaResAud=fechaResAud;
		this.respuestaAuditada=respuestaAuditada;
		this.bandera=bandera;
		this.infDefinitivo = infDefinitivo;
		this.revisionpolitica = revisionpolitica;
		this.codigoetica = codigoetica;
	}

	
	
	public BigDecimal getBandera() {
		return bandera;
	}


	public void setBandera(BigDecimal bandera) {
		this.bandera = bandera;
	}


	public String getCodigoProyecto() {
		return codigoProyecto;
	}


	public void setCodigoProyecto(String codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}


	public Date getFechaActualiza() {
		return fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	public BigDecimal getRc() {
		return rc;
	}

	public void setRc(BigDecimal rc) {
		this.rc = rc;
	}

	public BigDecimal getIdRecoPadre() {
		return idRecoPadre;
	}

	public void setIdRecoPadre(BigDecimal idRecoPadre) {
		this.idRecoPadre = idRecoPadre;
	}

	public Date getFechaDeEmision() {
		return fechaDeEmision;
	}

	public void setFechaDeEmision(Date fechaDeEmision) {
		this.fechaDeEmision = fechaDeEmision;
	}

	public SairDocReservacionCodigo getSairDocReservacionCodigo() {
		return sairDocReservacionCodigo;
	}

	public void setSairDocReservacionCodigo(
			SairDocReservacionCodigo sairDocReservacionCodigo) {
		this.sairDocReservacionCodigo = sairDocReservacionCodigo;
	}

	public BigDecimal getIdRecomendacion() {
		return this.idRecomendacion;
	}

	public void setIdRecomendacion(BigDecimal idRecomendacion) {
		this.idRecomendacion = idRecomendacion;
	}

	public SairArea getSairArea() {
		return this.sairArea;
	}

	public void setSairArea(SairArea sairArea) {
		this.sairArea = sairArea;
	}

	public SairEstadoComplementario getSairEstadoComplementario() {
		return sairEstadoComplementario;
	}

	public void setSairEstadoComplementario(
			SairEstadoComplementario sairEstadoComplementario) {
		this.sairEstadoComplementario = sairEstadoComplementario;
	}

	public String getPersonaEncargada() {
		return this.personaEncargada;
	}

	public void setPersonaEncargada(String personaEncargada) {
		this.personaEncargada = personaEncargada;
	}

	public String getGerenteEncargado() {
		return this.gerenteEncargado;
	}

	public void setGerenteEncargado(String gerenteEncargado) {
		this.gerenteEncargado = gerenteEncargado;
	}
	
	public String getGerenteAnt() {
		return this.gerenteAnt;
	}

	public void setGerenteAnt(String gerenteAnt) {
		this.gerenteAnt = gerenteAnt;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public SairEstadoReco getSairEstadoReco() {
		return sairEstadoReco;
	}

	public void setSairEstadoReco(SairEstadoReco sairEstadoReco) {
		this.sairEstadoReco = sairEstadoReco;
	}

	public BigDecimal getDiasSinRespuesta() {
		return diasSinRespuesta;
	}

	public void setDiasSinRespuesta(BigDecimal diasSinRespuesta) {
		this.diasSinRespuesta = diasSinRespuesta;
	}

	public Date getFechaRespuestaRevision() {
		return fechaRespuestaRevision;
	}

	public void setFechaRespuestaRevision(Date fechaRespuestaRevision) {
		this.fechaRespuestaRevision = fechaRespuestaRevision;
	}

	public BigDecimal getAutomatica() {
		return automatica;
	}

	public void setAutomatica(BigDecimal automatica) {
		this.automatica = automatica;
	}

	public Date getFechaAtencionTotal() {
		return this.fechaAtencionTotal;
	}

	public void setFechaAtencionTotal(Date fechaAtencionTotal) {
		this.fechaAtencionTotal = fechaAtencionTotal;
	}

	public Date getFechaCompromiso() {
		return this.fechaCompromiso;
	}

	public void setFechaCompromiso(Date fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}

	public Date getFechaRespuesta() {
		return this.fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public Date getFechaDeBaja() {
		return this.fechaDeBaja;
	}

	public void setFechaDeBaja(Date fechaDeBaja) {
		this.fechaDeBaja = fechaDeBaja;
	}

	public String getDependeProveedor() {
		return this.dependeProveedor;
	}

	public void setDependeProveedor(String dependeProveedor) {
		this.dependeProveedor = dependeProveedor;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getNumero() {
		return this.numero;
	}

	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}

	public SairAreasAdam getSairAreasAdam() {
		return sairAreasAdam;
	}

	public void setSairAreasAdam(SairAreasAdam sairAreasAdam) {
		this.sairAreasAdam = sairAreasAdam;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public BigDecimal getAno() {
		return this.ano;
	}

	public void setAno(BigDecimal ano) {
		this.ano = ano;
	}

	public String getAreaEvaluada() {
		return this.areaEvaluada;
	}

	public void setAreaEvaluada(String areaEvaluada) {
		this.areaEvaluada = areaEvaluada;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getOpTodos() {
		return opTodos;
	}

	public void setOpTodos(String opTodos) {
		this.opTodos = opTodos;
	}
	
	public String getPersonaAsignada() {
		return personaAsignada;
	}

	public void setPersonaAsignada(String personaAsignada) {
		this.personaAsignada = personaAsignada;
	}


	public String getRevisionpolitica() {
		return revisionpolitica;
	}


	public void setRevisionpolitica(String revisionpolitica) {
		this.revisionpolitica = revisionpolitica;
	}

	
	public String getCodigoetica() {
		return codigoetica;
	}


	public void setCodigoetica(String codigoetica) {
		this.codigoetica = codigoetica;
	}
	
	
}