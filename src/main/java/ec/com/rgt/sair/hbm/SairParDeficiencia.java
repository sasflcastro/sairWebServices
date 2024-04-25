package ec.com.rgt.sair.hbm;

// Generated 14-oct-2013 14:03:09 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SairParDeficiencia generated by hbmjava
 */
public class SairParDeficiencia implements java.io.Serializable {

	private BigDecimal idDeficiencia;
	private String deficiencia;
	private String estado;

	public SairParDeficiencia() {
	}

	public SairParDeficiencia(BigDecimal idDeficiencia) {
		this.idDeficiencia = idDeficiencia;
	}

	public SairParDeficiencia(BigDecimal idDeficiencia, String deficiencia,
			String usuarioIngreso, Date fechaIngreso, String estado) {
		this.idDeficiencia = idDeficiencia;
		this.deficiencia = deficiencia;
		this.estado = estado;

	}

	public BigDecimal getIdDeficiencia() {
		return this.idDeficiencia;
	}

	public void setIdDeficiencia(BigDecimal idDeficiencia) {
		this.idDeficiencia = idDeficiencia;
	}

	public String getDeficiencia() {
		return this.deficiencia;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}