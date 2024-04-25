package ec.com.rgt.sair.hbm;

// Generated 17-nov-2014 9:06:29 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SairConfiguraRutina generated by hbmjava
 */
public class SairConfiguraRutina implements java.io.Serializable {

	private BigDecimal idConfigura;
	private SairParRutina sairParRutinaByIdRutinaHija;
	private SairParRutina sairParRutinaByIdRutinaPadre;

	public SairConfiguraRutina() {
	}

	public SairConfiguraRutina(BigDecimal idConfigura) {
		this.idConfigura = idConfigura;
	}

	public SairConfiguraRutina(BigDecimal idConfigura,
			SairParRutina sairParRutinaByIdRutinaHija,
			SairParRutina sairParRutinaByIdRutinaPadre) {
		this.idConfigura = idConfigura;
		this.sairParRutinaByIdRutinaHija = sairParRutinaByIdRutinaHija;
		this.sairParRutinaByIdRutinaPadre = sairParRutinaByIdRutinaPadre;
	}

	public BigDecimal getIdConfigura() {
		return this.idConfigura;
	}

	public void setIdConfigura(BigDecimal idConfigura) {
		this.idConfigura = idConfigura;
	}

	public SairParRutina getSairParRutinaByIdRutinaHija() {
		return this.sairParRutinaByIdRutinaHija;
	}

	public void setSairParRutinaByIdRutinaHija(
			SairParRutina sairParRutinaByIdRutinaHija) {
		this.sairParRutinaByIdRutinaHija = sairParRutinaByIdRutinaHija;
	}

	public SairParRutina getSairParRutinaByIdRutinaPadre() {
		return this.sairParRutinaByIdRutinaPadre;
	}

	public void setSairParRutinaByIdRutinaPadre(
			SairParRutina sairParRutinaByIdRutinaPadre) {
		this.sairParRutinaByIdRutinaPadre = sairParRutinaByIdRutinaPadre;
	}

}
