package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

public class SairEstados implements java.io.Serializable {
	private String nombre;
	private String descripcion;
	private String estado;
	private BigDecimal idEstadoSair;
	
	public SairEstados(){
		
	}
	
	public SairEstados(BigDecimal idEstadoSair, String nombre,
			String estado, String descripcion) {
		this.idEstadoSair = idEstadoSair;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public BigDecimal getIdEstadoSair() {
		return idEstadoSair;
	}
	public void setIdEstadoSair(BigDecimal idEstadoSair) {
		this.idEstadoSair = idEstadoSair;
	}

}
