package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

@SuppressWarnings("serial")
public class SairMgTableroProcesos implements java.io.Serializable {
	
	private BigDecimal id;
	private SairMgRutinas sairMgRutinaPadre;
	private SairMgRutinas sairMgRutinaHijo;
	private BigDecimal idRutinaSair;
	private BigDecimal nivel;
	private String estado;
	
	public SairMgTableroProcesos() {		
	}
	
	public SairMgTableroProcesos(BigDecimal id, SairMgRutinas idRutinaPadre, SairMgRutinas idRutinaHijo, BigDecimal idRutinaSair, BigDecimal nivel, String estado) {
		this.id = id;
		this.sairMgRutinaPadre = idRutinaPadre;
		this.sairMgRutinaHijo = idRutinaHijo;
		this.idRutinaSair = idRutinaSair;
		this.nivel = nivel;
		this.estado = estado;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	public SairMgRutinas getSairMgRutinaPadre() {
		return sairMgRutinaPadre;
	}

	public void setSairMgRutinaPadre(SairMgRutinas idRutinaPadre) {
		this.sairMgRutinaPadre = idRutinaPadre;
	}

	public SairMgRutinas getSairMgRutinaHijo() {
		return sairMgRutinaHijo;
	}

	public void setSairMgRutinaHijo(SairMgRutinas idRutinaHijo) {
		this.sairMgRutinaHijo = idRutinaHijo;
	}
	
	public BigDecimal getIdRutinaSair() {
		return idRutinaSair;
	}

	public void setIdRutinaSair(BigDecimal idRutinaSair) {
		this.idRutinaSair = idRutinaSair;
	}	
	
	public BigDecimal getNivel() {
		return nivel;
	}

	public void setNivel(BigDecimal nivel) {
		this.nivel = nivel;
	}	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
