package ec.com.rgt.sair.hbm;

// Generated 14-oct-2013 14:03:09 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * SairDocRequerimientoCorrecc generated by hbmjava
 */
@SuppressWarnings("serial")
public class SairDocRequerimientoCorrecc implements java.io.Serializable {

	private BigDecimal idRc,p,i,casosSinAfectacion;
	private SairDocReservacionCodigo sairDocReservacionCodigo;
	private SairEstadosPrincipal sairEstadosPrincipal;
	private SairDocRiesgoDocumento sairDocRiesgoDocumento;
	private String asunto;
	private String antecedente;
	private String prioridad;
	private Date fechaElaboracion;
	private Date fechaEmision, fechaEmisionReal;
	private String imagen;
	private BigDecimal cantidadRecomendaciones;
	private BigDecimal cantidadCasosRecuperar;
	private String errorOperativoTecnologico,errorTecnologico;
	private BigDecimal valorRecuperar;
	private BigDecimal valorDevolver;
	private BigDecimal cantidadCasosDevolver;
	private String revisionSupervisor;
	private String revisionJefe;
	private BigDecimal idEstadoComp;
	private String estado;
	private String comentario;
	private String alcance;
	private SairDocAjusteCorreccion sairDocAjusteCorreccion;
	private String prioridadAjuste;

	public SairDocRequerimientoCorrecc() {
	}

	public SairDocRequerimientoCorrecc(BigDecimal idRc,
			SairDocReservacionCodigo sairDocReservacionCodigo,
			SairEstadosPrincipal sairEstadosPrincipal, 
			SairDocAjusteCorreccion sairDocAjusteCorreccion, 
			SairDocRiesgoDocumento sairDocRiesgoDocumento,String asunto,
			String antecedente, String prioridad, Date fechaElaboracion,
			Date fechaEmision, String imagen, BigDecimal cantidadRecomendaciones,
			BigDecimal cantidadCasosRecuperar,
			String errorOperativoTecnologico, BigDecimal valorRecuperar,
			BigDecimal valorDevolver, BigDecimal cantidadCasosDevolver,
			String revisionSupervisor, String revisionJefe,String estado,String comentario,
			String alcance,String prioridadAjuste,BigDecimal p,BigDecimal i,
			BigDecimal casosSinAfectacion,String errorTecnologico, Date fechaEmisionReal) {
		this.idRc = idRc;
		this.sairDocReservacionCodigo = sairDocReservacionCodigo;
		this.sairEstadosPrincipal = sairEstadosPrincipal;
		this.asunto = asunto;
		this.antecedente = antecedente;
		this.prioridad = prioridad;
		this.fechaElaboracion = fechaElaboracion;
		this.fechaEmision = fechaEmision;
		this.imagen = imagen;
		this.cantidadRecomendaciones = cantidadRecomendaciones;
		this.cantidadCasosRecuperar = cantidadCasosRecuperar;
		this.errorOperativoTecnologico = errorOperativoTecnologico;
		this.valorRecuperar = valorRecuperar;
		this.valorDevolver = valorDevolver;
		this.cantidadCasosDevolver = cantidadCasosDevolver;
		this.revisionSupervisor = revisionSupervisor;
		this.revisionJefe = revisionJefe;
		this.estado = estado;
		this.comentario = comentario;
		this.alcance = alcance;
		this.sairDocRiesgoDocumento=sairDocRiesgoDocumento;
		this.sairDocAjusteCorreccion =sairDocAjusteCorreccion;
		this.prioridadAjuste = prioridadAjuste;
		this.p= p;
		this.i= i;
		this.casosSinAfectacion= casosSinAfectacion;
		this.errorTecnologico = errorTecnologico;
		this.fechaEmisionReal = fechaEmisionReal;
	}

	public BigDecimal getCasosSinAfectacion() {
		return casosSinAfectacion;
	}

	public void setCasosSinAfectacion(BigDecimal casosSinAfectacion) {
		this.casosSinAfectacion = casosSinAfectacion;
	}

	public String getErrorTecnologico() {
		return errorTecnologico;
	}

	public void setErrorTecnologico(String errorTecnologico) {
		this.errorTecnologico = errorTecnologico;
	}

	public Date getFechaEmisionReal() {
		return fechaEmisionReal;
	}

	public void setFechaEmisionReal(Date fechaEmisionReal) {
		this.fechaEmisionReal = fechaEmisionReal;
	}

	public BigDecimal getP() {
		return p;
	}

	public void setP(BigDecimal p) {
		this.p = p;
	}

	public BigDecimal getI() {
		return i;
	}

	public void setI(BigDecimal i) {
		this.i = i;
	}

	public SairDocRiesgoDocumento getSairDocRiesgoDocumento() {
		return sairDocRiesgoDocumento;
	}

	public void setSairDocRiesgoDocumento(
			SairDocRiesgoDocumento sairDocRiesgoDocumento) {
		this.sairDocRiesgoDocumento = sairDocRiesgoDocumento;
	}

	public SairDocAjusteCorreccion getSairDocAjusteCorreccion() {
		return sairDocAjusteCorreccion;
	}

	public void setSairDocAjusteCorreccion(
			SairDocAjusteCorreccion sairDocAjusteCorreccion) {
		this.sairDocAjusteCorreccion = sairDocAjusteCorreccion;
	}

	public String getPrioridadAjuste() {
		return prioridadAjuste;
	}

	public void setPrioridadAjuste(String prioridadAjuste) {
		this.prioridadAjuste = prioridadAjuste;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getIdRc() {
		return this.idRc;
	}

	public void setIdRc(BigDecimal idRc) {
		this.idRc = idRc;
	}

	public SairDocReservacionCodigo getSairDocReservacionCodigo() {
		return this.sairDocReservacionCodigo;
	}

	public void setSairDocReservacionCodigo(
			SairDocReservacionCodigo sairDocReservacionCodigo) {
		this.sairDocReservacionCodigo = sairDocReservacionCodigo;
	}

	public SairEstadosPrincipal getSairEstadosPrincipal() {
		return this.sairEstadosPrincipal;
	}

	public void setSairEstadosPrincipal(
			SairEstadosPrincipal sairEstadosPrincipal) {
		this.sairEstadosPrincipal = sairEstadosPrincipal;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getAntecedente() {
		return this.antecedente;
	}

	public void setAntecedente(String antecedente) {
		this.antecedente = antecedente;
	}

	public String getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public Date getFechaElaboracion() {
		return this.fechaElaboracion;
	}

	public void setFechaElaboracion(Date fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}

	public Date getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public BigDecimal getCantidadRecomendaciones() {
		return this.cantidadRecomendaciones;
	}

	public void setCantidadRecomendaciones(BigDecimal cantidadRecomendaciones) {
		this.cantidadRecomendaciones = cantidadRecomendaciones;
	}

	public BigDecimal getCantidadCasosRecuperar() {
		return this.cantidadCasosRecuperar;
	}

	public void setCantidadCasosRecuperar(BigDecimal cantidadCasosRecuperar) {
		this.cantidadCasosRecuperar = cantidadCasosRecuperar;
	}

	public String getErrorOperativoTecnologico() {
		return this.errorOperativoTecnologico;
	}

	public void setErrorOperativoTecnologico(String errorOperativoTecnologico) {
		this.errorOperativoTecnologico = errorOperativoTecnologico;
	}

	public BigDecimal getValorRecuperar() {
		return this.valorRecuperar;
	}

	public void setValorRecuperar(BigDecimal valorRecuperar) {
		this.valorRecuperar = valorRecuperar;
	}

	public BigDecimal getValorDevolver() {
		return this.valorDevolver;
	}

	public void setValorDevolver(BigDecimal valorDevolver) {
		this.valorDevolver = valorDevolver;
	}

	public BigDecimal getCantidadCasosDevolver() {
		return this.cantidadCasosDevolver;
	}

	public void setCantidadCasosDevolver(BigDecimal cantidadCasosDevolver) {
		this.cantidadCasosDevolver = cantidadCasosDevolver;
	}

	public String getRevisionSupervisor() {
		return this.revisionSupervisor;
	}

	public void setRevisionSupervisor(String revisionSupervisor) {
		this.revisionSupervisor = revisionSupervisor;
	}

	public String getRevisionJefe() {
		return this.revisionJefe;
	}

	public void setRevisionJefe(String revisionJefe) {
		this.revisionJefe = revisionJefe;
	}

	public BigDecimal getIdEstadoComp() {
		return this.idEstadoComp;
	}

	public void setIdEstadoComp(BigDecimal idEstadoComp) {
		this.idEstadoComp = idEstadoComp;
	}
	
	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getAlcance() {
		return this.alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}
	
}
