package ec.com.rgt.sair.hbm;

// Generated 14-oct-2013 14:03:09 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SairTipoPlan generated by hbmjava
 */
@SuppressWarnings("serial")
public class SairTipoPlan implements java.io.Serializable {

	private BigDecimal idTipoPlan;
	private String nombreTipoPlan;
	private String estado;


	public SairTipoPlan() {
	}

	public SairTipoPlan(BigDecimal idTipoPlan) {
		this.idTipoPlan = idTipoPlan;
	}

	public SairTipoPlan(BigDecimal idTipoPlan, String nombreTipoPlan,
			String estado) {
		this.idTipoPlan = idTipoPlan;
		this.nombreTipoPlan = nombreTipoPlan;
		this.estado = estado;

	}

	public BigDecimal getIdTipoPlan() {
		return this.idTipoPlan;
	}

	public void setIdTipoPlan(BigDecimal idTipoPlan) {
		this.idTipoPlan = idTipoPlan;
	}

	public String getNombreTipoPlan() {
		return this.nombreTipoPlan;
	}

	public void setNombreTipoPlan(String nombreTipoPlan) {
		this.nombreTipoPlan = nombreTipoPlan;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}