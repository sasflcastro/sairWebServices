package ec.com.rgt.sair.hbm;

// Generated 08-jul-2013 0:41:27 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * GruposUsuariosId generated by hbmjava
 */
@SuppressWarnings("serial")
public class GruposUsuariosId implements java.io.Serializable {

	private String idUsuario;
	private BigDecimal idGrupo;

	public GruposUsuariosId() {
	}

	public GruposUsuariosId(String idUsuario, BigDecimal idGrupo) {
		this.idUsuario = idUsuario;
		this.idGrupo = idGrupo;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public BigDecimal getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(BigDecimal idGrupo) {
		this.idGrupo = idGrupo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GruposUsuariosId))
			return false;
		GruposUsuariosId castOther = (GruposUsuariosId) other;

		return ((this.getIdUsuario() == castOther.getIdUsuario()) || (this
				.getIdUsuario() != null && castOther.getIdUsuario() != null && this
				.getIdUsuario().equals(castOther.getIdUsuario())))
				&& ((this.getIdGrupo() == castOther.getIdGrupo()) || (this
						.getIdGrupo() != null && castOther.getIdGrupo() != null && this
						.getIdGrupo().equals(castOther.getIdGrupo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdUsuario() == null ? 0 : this.getIdUsuario().hashCode());
		result = 37 * result
				+ (getIdGrupo() == null ? 0 : this.getIdGrupo().hashCode());
		return result;
	}

}
