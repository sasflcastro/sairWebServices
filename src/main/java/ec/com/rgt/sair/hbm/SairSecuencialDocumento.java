package ec.com.rgt.sair.hbm;

// Generated 14-oct-2013 14:03:09 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SairSecuencialDocumento generated by hbmjava
 */
public class SairSecuencialDocumento implements java.io.Serializable {

	private SairSecuencialDocumentoId id;
	private SairDocTipoDocumento sairDocTipoDocumento;
	private SairArea sairArea;
	private String descripcion;
	private BigDecimal secuencia;
	private String estado;

	public SairSecuencialDocumento() {
	}

	public SairSecuencialDocumento(SairSecuencialDocumentoId id,
			SairDocTipoDocumento sairDocTipoDocumento, SairArea sairArea,
			String descripcion, BigDecimal secuencia, String estado) {
		this.id = id;
		this.sairDocTipoDocumento = sairDocTipoDocumento;
		this.sairArea = sairArea;
		this.descripcion = descripcion;
		this.secuencia = secuencia;
		this.estado = estado;
	}

	public SairSecuencialDocumentoId getId() {
		return this.id;
	}

	public void setId(SairSecuencialDocumentoId id) {
		this.id = id;
	}

	public SairDocTipoDocumento getSairDocTipoDocumento() {
		return this.sairDocTipoDocumento;
	}

	public void setSairDocTipoDocumento(
			SairDocTipoDocumento sairDocTipoDocumento) {
		this.sairDocTipoDocumento = sairDocTipoDocumento;
	}

	public SairArea getSairArea() {
		return this.sairArea;
	}

	public void setSairArea(SairArea sairArea) {
		this.sairArea = sairArea;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
