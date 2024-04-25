package ec.com.rgt.sair.hbm;

// Generated 14/11/2016 03:24:01 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SairBriSolicitud generated by hbmjava
 */
public class SairBriSolicitud implements java.io.Serializable {

	private BigDecimal idSolicitud;
	private String idUsuario;
	private Date fechaCreacion;
	private String comentarioSolicita;
	private String comentarioResive;
	private Set sairBriProgramacions = new HashSet(0);

	public SairBriSolicitud() {
	}

	public SairBriSolicitud(BigDecimal idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public SairBriSolicitud(BigDecimal idSolicitud, String idUsuario,
			Date fechaCreacion, String comentarioSolicita,
			String comentarioResive, Set sairBriProgramacions) {
		this.idSolicitud = idSolicitud;
		this.idUsuario = idUsuario;
		this.fechaCreacion = fechaCreacion;
		this.comentarioSolicita = comentarioSolicita;
		this.comentarioResive = comentarioResive;
		this.sairBriProgramacions = sairBriProgramacions;
	}

	public BigDecimal getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(BigDecimal idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getComentarioSolicita() {
		return this.comentarioSolicita;
	}

	public void setComentarioSolicita(String comentarioSolicita) {
		this.comentarioSolicita = comentarioSolicita;
	}

	public String getComentarioResive() {
		return this.comentarioResive;
	}

	public void setComentarioResive(String comentarioResive) {
		this.comentarioResive = comentarioResive;
	}

	public Set getSairBriProgramacions() {
		return this.sairBriProgramacions;
	}

	public void setSairBriProgramacions(Set sairBriProgramacions) {
		this.sairBriProgramacions = sairBriProgramacions;
	}

}
