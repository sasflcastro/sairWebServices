package ec.com.rgt.sair.hbm;

// Generated 08-jul-2013 0:41:27 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * Roles generated by hbmjava
 */
@SuppressWarnings("serial")
public class Roles implements java.io.Serializable {

	private BigDecimal idRol;
	private String nombreRol;
	private String usuarioIngreso;
	private Date fechaInicio;
	private String usuarioModificacion;
	private Date fechaBaja;
	private String estado;

	public Roles() {
	}

	public Roles(BigDecimal idRol, String nombreRol, String usuarioIngreso,
			Date fechaInicio, String estado) {
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.usuarioIngreso = usuarioIngreso;
		this.fechaInicio = fechaInicio;
		this.estado = estado;
	}

	public Roles(BigDecimal idRol, String nombreRol, String usuarioIngreso,
			Date fechaInicio, String usuarioModificacion, Date fechaBaja,
			String estado) {
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.usuarioIngreso = usuarioIngreso;
		this.fechaInicio = fechaInicio;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
	}

	public BigDecimal getIdRol() {
		return this.idRol;
	}

	public void setIdRol(BigDecimal idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
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
