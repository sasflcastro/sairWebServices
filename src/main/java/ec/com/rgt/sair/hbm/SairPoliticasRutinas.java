package ec.com.rgt.sair.hbm;

// Generated 03-sep-2014 14:27:54 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SairPoliticasRutinas generated by hbmjava
 */
public class SairPoliticasRutinas implements java.io.Serializable {
	
	private BigDecimal idPolRut;
	//private SairParPoliticas idPolitica;
	//private SairParRutina idRutina;
	private BigDecimal idPolitica;
	private BigDecimal idRutina;
	private String estado;
	
	public SairPoliticasRutinas() {
	}

	public SairPoliticasRutinas(BigDecimal idPolRut) {
		this.idPolRut = idPolRut;
	}

	public SairPoliticasRutinas(BigDecimal idPolRut, BigDecimal idPolitica, BigDecimal idRutina, String estado) {
		this.idPolRut = idPolRut;
		this.idPolitica = idPolitica;
		this.idRutina = idRutina;
		this.estado = estado;
	}

	public BigDecimal getIdPolRut() {
		return idPolRut;
	}

	public void setIdPolRut(BigDecimal idPolRut) {
		this.idPolRut = idPolRut;
	}

	public BigDecimal getIdPolitica() {
		return idPolitica;
	}

	public void setIdPolitica(BigDecimal idPolitica) {
		this.idPolitica = idPolitica;
	}

	public BigDecimal getIdRutina() {
		return idRutina;
	}

	public void setIdRutina(BigDecimal idRutina) {
		this.idRutina = idRutina;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}