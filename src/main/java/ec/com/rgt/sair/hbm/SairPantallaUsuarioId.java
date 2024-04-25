package ec.com.rgt.sair.hbm;
// Generated 10-nov-2015 9:38:15 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;

/**
 * SairPantallaUsuarioId generated by hbmjava
 */
public class SairPantallaUsuarioId implements java.io.Serializable {

	private String idUsuario;
	private BigDecimal idPantalla;

	public SairPantallaUsuarioId() {
	}

	public SairPantallaUsuarioId(String idUsuario, BigDecimal idPantalla) {
		this.idUsuario = idUsuario;
		this.idPantalla = idPantalla;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public BigDecimal getIdPantalla() {
		return this.idPantalla;
	}

	public void setIdPantalla(BigDecimal idPantalla) {
		this.idPantalla = idPantalla;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SairPantallaUsuarioId))
			return false;
		SairPantallaUsuarioId castOther = (SairPantallaUsuarioId) other;

		return ((this.getIdUsuario() == castOther.getIdUsuario()) || (this.getIdUsuario() != null
				&& castOther.getIdUsuario() != null && this.getIdUsuario().equals(castOther.getIdUsuario())))
				&& ((this.getIdPantalla() == castOther.getIdPantalla())
						|| (this.getIdPantalla() != null && castOther.getIdPantalla() != null
								&& this.getIdPantalla().equals(castOther.getIdPantalla())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdUsuario() == null ? 0 : this.getIdUsuario().hashCode());
		result = 37 * result + (getIdPantalla() == null ? 0 : this.getIdPantalla().hashCode());
		return result;
	}

}