package ec.com.rgt.sair.hbm;
// Generated 17/01/2017 14:24:19 by Hibernate Tools 3.5.0.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SairActaTipos generated by hbm2java
 */
public class SairActaTipos implements java.io.Serializable {

	private BigDecimal idTipoActa;
	private String nombre;
	private String descripcion;
	private String usuario;
	private Date fechaCreacion;
	private String estado;
	private Set sairActaProyectos = new HashSet(0);

	public SairActaTipos() {
	}

	public SairActaTipos(BigDecimal idTipoActa) {
		this.idTipoActa = idTipoActa;
	}

	public SairActaTipos(BigDecimal idTipoActa, String nombre, String descripcion, String usuario, Date fechaCreacion,
			String estado, Set sairActaProyectos) {
		this.idTipoActa = idTipoActa;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.sairActaProyectos = sairActaProyectos;
	}

	public BigDecimal getIdTipoActa() {
		return this.idTipoActa;
	}

	public void setIdTipoActa(BigDecimal idTipoActa) {
		this.idTipoActa = idTipoActa;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set getSairActaProyectos() {
		return this.sairActaProyectos;
	}

	public void setSairActaProyectos(Set sairActaProyectos) {
		this.sairActaProyectos = sairActaProyectos;
	}

}