package ec.com.rgt.sair.hbm;

// Generated 14-oct-2013 14:03:09 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SairIncComentario generated by hbmjava
 */
public class SairIncComentario implements java.io.Serializable {

	private BigDecimal idComentario;
	private String idUsuarioCreacion;
	private String detalle;
	private Date fecha;
	private String estado;


	public SairIncComentario() {
	}

	public SairIncComentario(BigDecimal idComentario) {
		this.idComentario = idComentario;
	}

	public SairIncComentario(BigDecimal idComentario, String idUsuarioCreacion,
			String detalle, Date fecha, String estado) {
		this.idComentario = idComentario;
		this.idUsuarioCreacion = idUsuarioCreacion;
		this.detalle = detalle;
		this.fecha = fecha;
		this.estado = estado;

	}

	public BigDecimal getIdComentario() {
		return this.idComentario;
	}

	public void setIdComentario(BigDecimal idComentario) {
		this.idComentario = idComentario;
	}

	public String getIdUsuarioCreacion() {
		return this.idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(String idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
