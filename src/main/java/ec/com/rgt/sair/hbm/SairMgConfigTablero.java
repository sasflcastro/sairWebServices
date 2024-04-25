package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

@SuppressWarnings("serial")
public class SairMgConfigTablero implements java.io.Serializable {
	
	private BigDecimal id;
	private String producto;
	private SairMgRutinas sairMgRutinas;
	private BigDecimal idServicio;
	private BigDecimal idPadre;
	private String estado;
	
	public SairMgConfigTablero() {		
	}
	
	public SairMgConfigTablero(BigDecimal id, String producto, SairMgRutinas sairMgRutinas, BigDecimal idServicio, BigDecimal idPadre, String estado) {
		this.id = id;		
		this.producto = producto;
		this.sairMgRutinas = sairMgRutinas;
		this.idServicio = idServicio;
		this.idPadre = idPadre;
		this.estado = estado;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public SairMgRutinas getSairMgRutinas() {
		return sairMgRutinas;
	}

	public void setSairMgRutinas(SairMgRutinas sairMgRutinas) {
		this.sairMgRutinas = sairMgRutinas;
	}
	
	public BigDecimal getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(BigDecimal idServicio) {
		this.idServicio = idServicio;
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
