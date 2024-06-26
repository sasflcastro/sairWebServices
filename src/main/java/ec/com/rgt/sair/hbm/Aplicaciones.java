package ec.com.rgt.sair.hbm;

// Generated 08-jul-2013 0:41:27 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * Aplicaciones generated by hbmjava
 */
//@XmlSeeAlso(ec.com.rgt.sair.hbm.GruposAplicaciones.class)
@SuppressWarnings("serial")
public class Aplicaciones implements java.io.Serializable {

	private BigDecimal idAplicacion;
	private String descripcion;
	private String usuarioIngreso;
	private Date fechaInicio;
	private String usuarioModificacion;
	private Date fechaBaja;
	private String estado;

	public Aplicaciones() {
	}

	public Aplicaciones(BigDecimal idAplicacion, String descripcion,
			String usuarioIngreso, Date fechaInicio, String estado) {
		this.idAplicacion = idAplicacion;
		this.descripcion = descripcion;
		this.usuarioIngreso = usuarioIngreso;
		this.fechaInicio = fechaInicio;
		this.estado = estado;
	}

	public Aplicaciones(BigDecimal idAplicacion, String descripcion,
			String usuarioIngreso, Date fechaInicio,
			String usuarioModificacion, Date fechaBaja, String estado) {
		this.idAplicacion = idAplicacion;
		this.descripcion = descripcion;
		this.usuarioIngreso = usuarioIngreso;
		this.fechaInicio = fechaInicio;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
	}

	public BigDecimal getIdAplicacion() {
		return this.idAplicacion;
	}

	public void setIdAplicacion(BigDecimal idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuarioIngreso() {
		return this.usuarioIngreso;
	}

	public void setUsuarioIngreso(String usuarioIngreso) {
		this.usuarioIngreso = usuarioIngreso;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
