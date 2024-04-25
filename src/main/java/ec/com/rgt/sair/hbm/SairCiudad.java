package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

public class SairCiudad implements java.io.Serializable{
	private BigDecimal idCiudad;
	private String nombre;
	private String provincia;
	private String codigo;
	private String estado;

	public SairCiudad() {
	}

	public SairCiudad(BigDecimal idCiudad,
	String nombre,
	String provincia,
	String codigo,
	String estado) {
		this.idCiudad=idCiudad;
		this.nombre=nombre;
		this.provincia=provincia;
		this.codigo=codigo;
		this.estado=estado;
	}

	public BigDecimal getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(BigDecimal idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
