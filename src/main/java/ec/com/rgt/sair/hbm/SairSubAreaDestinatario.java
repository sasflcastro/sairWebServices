package ec.com.rgt.sair.hbm;

// Generated 18-jul-2014 14:23:05 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SairSubArea generated by hbmjava
 */
public class SairSubAreaDestinatario implements java.io.Serializable {

	private BigDecimal idDestinatario,idSubArea;
	private String usuarioAd;

	public SairSubAreaDestinatario() {
	}

	
	public SairSubAreaDestinatario(BigDecimal idDestinatario,
			BigDecimal idSubArea, String usuarioAd) {
		super();
		this.idDestinatario = idDestinatario;
		this.idSubArea = idSubArea;
		this.usuarioAd = usuarioAd;
	}


	public BigDecimal getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(BigDecimal idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public BigDecimal getIdSubArea() {
		return idSubArea;
	}

	public void setIdSubArea(BigDecimal idSubArea) {
		this.idSubArea = idSubArea;
	}

	public String getUsuarioAd() {
		return usuarioAd;
	}

	public void setUsuarioAd(String usuarioAd) {
		this.usuarioAd = usuarioAd;
	}

	
	
	
}
