package ec.com.rgt.sair.hbm;

// Generated 08-jul-2013 0:41:27 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Grupos generated by hbmjava
 */
//@XmlSeeAlso(ec.com.rgt.sair.hbm.GruposAplicaciones.class)
public class SairReportes implements java.io.Serializable {

	private BigDecimal idReporte;
	private String nombre;
	private String descripcion;
	private Date fechaIngreso;
	private String idUsuario;
	private String url;
	private String estado;
	private String tipo;

	public SairReportes() {
	}

	public SairReportes(BigDecimal idReporte, String nombre, String descripcion ,String url,
			String idUsuario, Date fechaIngreso, String estado,String tipo) {
		this.idReporte = idReporte;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.idUsuario = idUsuario;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
		this.tipo = tipo;
	}



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(BigDecimal idReporte) {
		this.idReporte = idReporte;
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

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}

