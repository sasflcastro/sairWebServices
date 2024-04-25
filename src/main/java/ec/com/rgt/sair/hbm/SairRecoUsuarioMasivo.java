package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

@SuppressWarnings("serial")
public class SairRecoUsuarioMasivo implements java.io.Serializable {

	private BigDecimal idRecoUm;
	private BigDecimal idRecomendacion;
	private String idUsuario;

	public SairRecoUsuarioMasivo() {
	}

	public SairRecoUsuarioMasivo(BigDecimal idRecoUm) {
		this.idRecoUm = idRecoUm;
	}

	public SairRecoUsuarioMasivo(BigDecimal idRecoUm,
			BigDecimal idRecomendacion, String idUsuario) {
		this.idRecoUm = idRecoUm;
		this.idRecomendacion = idRecomendacion;
		this.idUsuario = idUsuario;
	}

	public BigDecimal getIdRecoUm() {
		return this.idRecoUm;
	}

	public void setIdRecoUm(BigDecimal idRecoUm) {
		this.idRecoUm = idRecoUm;
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
