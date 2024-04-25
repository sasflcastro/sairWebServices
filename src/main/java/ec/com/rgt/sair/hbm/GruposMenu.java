package ec.com.rgt.sair.hbm;

// Generated 08-jul-2013 0:41:27 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * GruposMenu generated by hbmjava
 */
@SuppressWarnings("serial")
public class GruposMenu implements java.io.Serializable {

	private GruposMenuId id;
	private Menues menues;
	private Grupos grupos;
	private String usuarioIngreso;
	private Date fechaInicio;
	private String usuarioModificacion;
	private Date fechaBaja;
	private String estado;

	public GruposMenu() {
	}

	public GruposMenu(GruposMenuId id, Menues menues, Grupos grupos,
			String usuarioIngreso, Date fechaInicio, String estado) {
		this.id = id;
		this.menues = menues;
		this.grupos = grupos;
		this.usuarioIngreso = usuarioIngreso;
		this.fechaInicio = fechaInicio;
		this.estado = estado;
	}

	public GruposMenu(GruposMenuId id, Menues menues, Grupos grupos,
			String usuarioIngreso, Date fechaInicio,
			String usuarioModificacion, Date fechaBaja, String estado) {
		this.id = id;
		this.menues = menues;
		this.grupos = grupos;
		this.usuarioIngreso = usuarioIngreso;
		this.fechaInicio = fechaInicio;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
	}

	public GruposMenuId getId() {
		return this.id;
	}

	public void setId(GruposMenuId id) {
		this.id = id;
	}

	public Menues getMenues() {
		return this.menues;
	}

	public void setMenues(Menues menues) {
		this.menues = menues;
	}

	public Grupos getGrupos() {
		return this.grupos;
	}

	public void setGrupos(Grupos grupos) {
		this.grupos = grupos;
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
