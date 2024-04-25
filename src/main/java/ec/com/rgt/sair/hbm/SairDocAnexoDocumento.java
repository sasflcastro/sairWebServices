package ec.com.rgt.sair.hbm;

// Generated 14-oct-2013 14:03:09 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * SairDocAnexoDocumento generated by hbmjava
 */
@SuppressWarnings("serial")
public class SairDocAnexoDocumento implements java.io.Serializable {

	private BigDecimal idAnexoDocumento;
	private SairDocReservacionCodigo sairDocReservacionCodigo;
	private SairEstadosPrincipal sairEstadosPrincipal;
	private String descripcion;
	private String documentoAnexado;
	private String rutaCompartida;
	private Date fechaIngreso;
	private Date fechaActualizacion;
	private BigDecimal idEstadoComp;
	private String extension;

	
	public SairDocAnexoDocumento() {
	}

	public SairDocAnexoDocumento(BigDecimal idAnexoDocumento,
			SairDocReservacionCodigo sairDocReservacionCodigo,
			SairEstadosPrincipal sairEstadosPrincipal, String descripcion,
			String documentoAnexado, String rutaCompartida,
			Date fechaIngreso, Date fechaActualizacion, BigDecimal idEstadoComp,String extension) {
		this.idAnexoDocumento = idAnexoDocumento;
		this.sairDocReservacionCodigo = sairDocReservacionCodigo;
		this.sairEstadosPrincipal = sairEstadosPrincipal;
		this.descripcion = descripcion;
		this.documentoAnexado = documentoAnexado;
		this.rutaCompartida = rutaCompartida;
		this.fechaIngreso = fechaIngreso;
		this.fechaActualizacion = fechaActualizacion;
		this.idEstadoComp = idEstadoComp;
		this.extension = extension;
	}
	
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}


	public BigDecimal getIdAnexoDocumento() {
		return this.idAnexoDocumento;
	}

	public void setIdAnexoDocumento(BigDecimal idAnexoDocumento) {
		this.idAnexoDocumento = idAnexoDocumento;
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDocumentoAnexado() {
		return this.documentoAnexado;
	}

	public void setDocumentoAnexado(String documentoAnexado) {
		this.documentoAnexado = documentoAnexado;
	}

	public String getRutaCompartida() {
		return this.rutaCompartida;
	}

	public void setRutaCompartida(String rutaCompartida) {
		this.rutaCompartida = rutaCompartida;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public BigDecimal getIdEstadoComp() {
		return this.idEstadoComp;
	}

	public void setIdEstadoComp(BigDecimal idEstadoComp) {
		this.idEstadoComp = idEstadoComp;
	}

}