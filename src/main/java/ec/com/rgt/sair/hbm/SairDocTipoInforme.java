package ec.com.rgt.sair.hbm;

// Generated 14-oct-2013 14:03:09 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SairDocTipoInforme generated by hbmjava
 */
public class SairDocTipoInforme implements java.io.Serializable {

	private BigDecimal idTipoInforme;
	private String descripcion;
	private Date fechaIngreso;
	private String estado;


	public SairDocTipoInforme() {
	}

	public SairDocTipoInforme(BigDecimal idTipoInforme, String descripcion,
			Date fechaIngreso, String estado) {
		this.idTipoInforme = idTipoInforme;
		this.descripcion = descripcion;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}


	public BigDecimal getIdTipoInforme() {
		return this.idTipoInforme;
	}

	public void setIdTipoInforme(BigDecimal idTipoInforme) {
		this.idTipoInforme = idTipoInforme;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
