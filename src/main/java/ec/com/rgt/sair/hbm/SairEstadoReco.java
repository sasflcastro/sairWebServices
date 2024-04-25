package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

public class SairEstadoReco implements java.io.Serializable{
	private BigDecimal idEstado;
	private String nombre;
	private String descripcion;
	private String estado;
	private SairEstados idEstadoSair;

	
	public SairEstados getIdEstadoSair() {
		return idEstadoSair;
	}

	public void setIdEstadoSair(SairEstados idEstadoSair) {
		this.idEstadoSair = idEstadoSair;
	}

	public SairEstadoReco() {
	}

	public SairEstadoReco(BigDecimal idEstado, String nombre,
			String descripcion, String estado, SairEstados idEstadoSair) {
		this.idEstado = idEstado;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.idEstadoSair= idEstadoSair;
	}
	
	public BigDecimal getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(BigDecimal idEstado) {
		this.idEstado = idEstado;
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
	

}
