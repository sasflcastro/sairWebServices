package ec.com.rgt.sair.hbm;

// Generated 08-jul-2013 0:41:27 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * Aplicaciones generated by hbmjava
 */
//@XmlSeeAlso(ec.com.rgt.sair.hbm.GruposAplicaciones.class)
@SuppressWarnings("serial")
public class SairUnidadGerente implements java.io.Serializable {

	private BigDecimal idUnidadGerente;
	private BigDecimal idSubArea;
	private String usuario;

	public SairUnidadGerente() {
	}

	public SairUnidadGerente(BigDecimal idUnidadGerente, BigDecimal idSubArea,
			String usuario) {
		super();
		this.idUnidadGerente = idUnidadGerente;
		this.idSubArea = idSubArea;
		this.usuario = usuario;
	}

	public BigDecimal getIdUnidadGerente() {
		return idUnidadGerente;
	}

	public void setIdUnidadGerente(BigDecimal idUnidadGerente) {
		this.idUnidadGerente = idUnidadGerente;
	}

	public BigDecimal getIdSubArea() {
		return idSubArea;
	}

	public void setIdSubArea(BigDecimal idSubArea) {
		this.idSubArea = idSubArea;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	

	
}
