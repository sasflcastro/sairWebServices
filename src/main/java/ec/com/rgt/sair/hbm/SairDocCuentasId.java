package ec.com.rgt.sair.hbm;
// Generated 03/10/2017 15:24:44 by Hibernate Tools 3.6.0.Final

import java.math.BigDecimal;

/**
 * SairDocCuentasId generated by hbm2java
 */
public class SairDocCuentasId implements java.io.Serializable {

	private BigDecimal idTipoDocumento;
	private BigDecimal idTipoInforme;
	private BigDecimal idCampo;

	public SairDocCuentasId() {
	}

	public SairDocCuentasId(BigDecimal idTipoDocumento, BigDecimal idTipoInforme, BigDecimal idCampo) {
		this.idTipoDocumento = idTipoDocumento;
		this.idTipoInforme = idTipoInforme;
		this.idCampo = idCampo;
	}

	public BigDecimal getIdTipoDocumento() {
		return this.idTipoDocumento;
	}

	public void setIdTipoDocumento(BigDecimal idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public BigDecimal getIdTipoInforme() {
		return this.idTipoInforme;
	}

	public void setIdTipoInforme(BigDecimal idTipoInforme) {
		this.idTipoInforme = idTipoInforme;
	}

	public BigDecimal getIdCampo() {
		return this.idCampo;
	}

	public void setIdCampo(BigDecimal idCampo) {
		this.idCampo = idCampo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SairDocCuentasId))
			return false;
		SairDocCuentasId castOther = (SairDocCuentasId) other;

		return ((this.getIdTipoDocumento() == castOther.getIdTipoDocumento())
				|| (this.getIdTipoDocumento() != null && castOther.getIdTipoDocumento() != null
						&& this.getIdTipoDocumento().equals(castOther.getIdTipoDocumento())))
				&& ((this.getIdTipoInforme() == castOther.getIdTipoInforme())
						|| (this.getIdTipoInforme() != null && castOther.getIdTipoInforme() != null
								&& this.getIdTipoInforme().equals(castOther.getIdTipoInforme())))
				&& ((this.getIdCampo() == castOther.getIdCampo()) || (this.getIdCampo() != null
						&& castOther.getIdCampo() != null && this.getIdCampo().equals(castOther.getIdCampo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdTipoDocumento() == null ? 0 : this.getIdTipoDocumento().hashCode());
		result = 37 * result + (getIdTipoInforme() == null ? 0 : this.getIdTipoInforme().hashCode());
		result = 37 * result + (getIdCampo() == null ? 0 : this.getIdCampo().hashCode());
		return result;
	}

}
