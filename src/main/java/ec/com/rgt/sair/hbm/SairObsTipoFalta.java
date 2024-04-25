package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

public class SairObsTipoFalta {
	private BigDecimal idTipoFalta;
	private String nombre;
	private String valorAsociado;
	private String estado;

	public SairObsTipoFalta() {
	}

	public SairObsTipoFalta(BigDecimal idTipoFalta,
	String nombre,
	String valorAsociado,
	String estado) {
		this.idTipoFalta=idTipoFalta;
		this.nombre=nombre;
		this.valorAsociado=valorAsociado;
		this.estado=estado;
	}

	public BigDecimal getIdTipoFalta() {
		return idTipoFalta;
	}

	public void setIdTipoFalta(BigDecimal idTipoFalta) {
		this.idTipoFalta = idTipoFalta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValorAsociado() {
		return valorAsociado;
	}

	public void setValorAsociado(String valorAsociado) {
		this.valorAsociado = valorAsociado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
