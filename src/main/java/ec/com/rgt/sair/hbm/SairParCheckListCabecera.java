package ec.com.rgt.sair.hbm;

// Generated 14-oct-2013 14:03:09 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SairParCheckListCabecera generated by hbmjava
 */
public class SairParCheckListCabecera implements java.io.Serializable {

	private BigDecimal cabId;
	private String cabNombre;
	private Date cabFecha;
	private String estado;

	public SairParCheckListCabecera() {
	}

	public SairParCheckListCabecera(BigDecimal cabId, String cabNombre,
			Date cabFecha, String estado) {
		this.cabId = cabId;
		this.cabNombre = cabNombre;
		this.cabFecha = cabFecha;
		this.estado = estado;
	}

	public BigDecimal getCabId() {
		return this.cabId;
	}

	public void setCabId(BigDecimal cabId) {
		this.cabId = cabId;
	}

	public String getCabNombre() {
		return this.cabNombre;
	}

	public void setCabNombre(String cabNombre) {
		this.cabNombre = cabNombre;
	}

	public Date getCabFecha() {
		return this.cabFecha;
	}

	public void setCabFecha(Date cabFecha) {
		this.cabFecha = cabFecha;
	}
	
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}