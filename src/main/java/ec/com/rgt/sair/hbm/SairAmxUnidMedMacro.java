package ec.com.rgt.sair.hbm;

// Generated 24-ene-2015 10:38:16 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * SairAmxUnidMedMacro generated by hbmjava
 */
public class SairAmxUnidMedMacro implements java.io.Serializable {

	private BigDecimal idSairAmxUnidMedMacro;
	private String detalle;
	private String estado;

	public SairAmxUnidMedMacro() {
	}

	public SairAmxUnidMedMacro(BigDecimal idSairAmxUnidMedMacro) {
		this.idSairAmxUnidMedMacro = idSairAmxUnidMedMacro;
	}

	public SairAmxUnidMedMacro(BigDecimal idSairAmxUnidMedMacro,
			String detalle, String estado) {
		this.idSairAmxUnidMedMacro = idSairAmxUnidMedMacro;
		this.detalle = detalle;
		this.estado = estado;
	}

	public BigDecimal getIdSairAmxUnidMedMacro() {
		return this.idSairAmxUnidMedMacro;
	}

	public void setIdSairAmxUnidMedMacro(BigDecimal idSairAmxUnidMedMacro) {
		this.idSairAmxUnidMedMacro = idSairAmxUnidMedMacro;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}