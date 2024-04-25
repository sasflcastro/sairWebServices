package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

@SuppressWarnings("serial")
public class SairMgRutinas implements java.io.Serializable {
	
	private BigDecimal id;
	private BigDecimal orden;
	private String descripcion;
	private BigDecimal idPadre;
	private String estado;
	
	public SairMgRutinas() {		
	}
	
	public SairMgRutinas(BigDecimal id, BigDecimal orden, String descripcion, BigDecimal idPadre, String estado) {
		this.id = id;
		this.orden = orden;
		this.descripcion = descripcion;
		this.idPadre = idPadre;
		this.estado = estado;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	public BigDecimal getOrden() {
		return orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public BigDecimal getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(BigDecimal idPadre) {
		this.idPadre = idPadre;
	}	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
