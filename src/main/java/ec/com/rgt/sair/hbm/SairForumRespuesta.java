package ec.com.rgt.sair.hbm;

// Generated 24-ago-2015 9:51:38 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;

/**
 * SairForumRespuesta generated by hbmjava
 */
public class SairForumRespuesta implements java.io.Serializable {

	private BigDecimal idRespuesta;
	private Usuarios usuarios;
	private SairForumQuestions sairForumQuestions;
	private String respuesta;
	private Date fechaIngreso;
	private String estado;
	private BigDecimal correcta;

	public SairForumRespuesta() {
	}

	public SairForumRespuesta(BigDecimal idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public SairForumRespuesta(BigDecimal idRespuesta, Usuarios usuarios,
			SairForumQuestions sairForumQuestions, String respuesta,
			Date fechaIngreso, String estado, BigDecimal correcta) {
		this.idRespuesta = idRespuesta;
		this.usuarios = usuarios;
		this.sairForumQuestions = sairForumQuestions;
		this.respuesta = respuesta;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
		this.correcta = correcta;
	}

	public BigDecimal getIdRespuesta() {
		return this.idRespuesta;
	}

	public void setIdRespuesta(BigDecimal idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public SairForumQuestions getSairForumQuestions() {
		return this.sairForumQuestions;
	}

	public void setSairForumQuestions(SairForumQuestions sairForumQuestions) {
		this.sairForumQuestions = sairForumQuestions;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getCorrecta() {
		return this.correcta;
	}

	public void setCorrecta(BigDecimal correcta) {
		this.correcta = correcta;
	}

}
