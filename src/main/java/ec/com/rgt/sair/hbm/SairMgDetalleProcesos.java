package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

@SuppressWarnings("serial")
public class SairMgDetalleProcesos implements java.io.Serializable {
	
	private BigDecimal id;
	private SairMgTableroProcesos sairMgTableroProcesos;
	private BigDecimal idSubSegmento;
	private String estado;
	
	public SairMgDetalleProcesos() {		
	}
	
	public SairMgDetalleProcesos(BigDecimal id, BigDecimal idSubSegmento, SairMgTableroProcesos sairMgTableroProcesos, String estado) {
		this.id = id;		
		this.idSubSegmento = idSubSegmento;
		this.sairMgTableroProcesos = sairMgTableroProcesos;
		this.estado = estado;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	public SairMgTableroProcesos getSairMgTableroProcesos() {
		return sairMgTableroProcesos;
	}

	public void setSairMgTableroProcesos(SairMgTableroProcesos sairMgTableroProcesos) {
		this.sairMgTableroProcesos = sairMgTableroProcesos;
	}
	
	public BigDecimal getIdSubSegmento() {
		return idSubSegmento;
	}

	public void setIdSubSegmento(BigDecimal idSubSegmento) {
		this.idSubSegmento = idSubSegmento;
	}	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
