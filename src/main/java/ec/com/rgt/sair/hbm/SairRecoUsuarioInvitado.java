package ec.com.rgt.sair.hbm;

// Generated 17-jul-2015 18:29:58 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SairRecoUsuarioInvitado generated by hbmjava
 */
public class SairRecoUsuarioInvitado implements java.io.Serializable {

	private BigDecimal idRecoUi;
	private BigDecimal idRecomendacion;
	private String idUsuario;

	public SairRecoUsuarioInvitado() {
	}

	public SairRecoUsuarioInvitado(BigDecimal idRecoUi) {
		this.idRecoUi = idRecoUi;
	}

	public SairRecoUsuarioInvitado(BigDecimal idRecoUi,
			BigDecimal idRecomendacion, String idUsuario) {
		this.idRecoUi = idRecoUi;
		this.idRecomendacion = idRecomendacion;
		this.idUsuario = idUsuario;
	}

	public BigDecimal getIdRecoUi() {
		return this.idRecoUi;
	}

	public void setIdRecoUi(BigDecimal idRecoUi) {
		this.idRecoUi = idRecoUi;
	}

	public BigDecimal getIdRecomendacion() {
		return this.idRecomendacion;
	}

	public void setIdRecomendacion(BigDecimal idRecomendacion) {
		this.idRecomendacion = idRecomendacion;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

}