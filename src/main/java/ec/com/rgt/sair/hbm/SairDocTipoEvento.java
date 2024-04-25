package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

@SuppressWarnings("serial")
public class SairDocTipoEvento implements java.io.Serializable {
	
	private BigDecimal idTipoEvento;
	private String nombre;
	private String estado;
	
	public SairDocTipoEvento() {
	}
	
	public SairDocTipoEvento(BigDecimal idTipoEvento, String nombre, String estado) {
		this.idTipoEvento=idTipoEvento;
		this.nombre=nombre;
		this.estado=estado;
	}

	public BigDecimal getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(BigDecimal idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
