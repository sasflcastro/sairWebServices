package ec.com.rgt.sair.hbm;

// Generated 03-sep-2014 14:27:54 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SairRecConclusionReco generated by hbmjava
 */
public class SairRecConclusionReco implements java.io.Serializable {

	private BigDecimal idConReco;
	private SairRecRecomendacion sairRecRecomendacion;
	private SairDocConclusionDocumento sairDocConclusionDocumento;

	public SairRecConclusionReco() {
	}

	public SairRecConclusionReco(BigDecimal idConReco,
			SairRecRecomendacion sairRecRecomendacion,
			SairDocConclusionDocumento sairDocConclusionDocumento) {
		this.idConReco = idConReco;
		this.sairRecRecomendacion = sairRecRecomendacion;
		this.sairDocConclusionDocumento = sairDocConclusionDocumento;
	}

	public BigDecimal getIdConReco() {
		return this.idConReco;
	}

	public void setIdConReco(BigDecimal idConReco) {
		this.idConReco = idConReco;
	}

	public SairRecRecomendacion getSairRecRecomendacion() {
		return this.sairRecRecomendacion;
	}

	public void setSairRecRecomendacion(
			SairRecRecomendacion sairRecRecomendacion) {
		this.sairRecRecomendacion = sairRecRecomendacion;
	}

	public SairDocConclusionDocumento getSairDocConclusionDocumento() {
		return this.sairDocConclusionDocumento;
	}

	public void setSairDocConclusionDocumento(
			SairDocConclusionDocumento sairDocConclusionDocumento) {
		this.sairDocConclusionDocumento = sairDocConclusionDocumento;
	}

}