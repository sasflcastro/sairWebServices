package ec.com.rgt.sair.hbm;

// Generated 07-mar-2014 10:30:42 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * SairDocDestinatario generated by hbmjava
 */
@SuppressWarnings("serial")
public class SairDocDestinatario implements java.io.Serializable {

	private BigDecimal idDestinatario;
	private SairDocReservacionCodigo sairDocReservacionCodigo;
	private String usuarioEnvio;
	private String emailPara;
	private Date fechaRegistro;
	private String emailCopia;

	public SairDocDestinatario() {
	}

	public SairDocDestinatario(BigDecimal idDestinatario,
			SairDocReservacionCodigo sairDocReservacionCodigo,
			String usuarioEnvio, String emailPara, Date fechaRegistro) {
		this.idDestinatario = idDestinatario;
		this.sairDocReservacionCodigo = sairDocReservacionCodigo;
		this.usuarioEnvio = usuarioEnvio;
		this.emailPara = emailPara;
		this.fechaRegistro = fechaRegistro;
	}

	public SairDocDestinatario(BigDecimal idDestinatario,
			SairDocReservacionCodigo sairDocReservacionCodigo,
			String usuarioEnvio, String emailPara, Date fechaRegistro,
			String emailCopia) {
		this.idDestinatario = idDestinatario;
		this.sairDocReservacionCodigo = sairDocReservacionCodigo;
		this.usuarioEnvio = usuarioEnvio;
		this.emailPara = emailPara;
		this.fechaRegistro = fechaRegistro;
		this.emailCopia = emailCopia;
	}

	public BigDecimal getIdDestinatario() {
		return this.idDestinatario;
	}

	public void setIdDestinatario(BigDecimal idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public SairDocReservacionCodigo getSairDocReservacionCodigo() {
		return this.sairDocReservacionCodigo;
	}

	public void setSairDocReservacionCodigo(
			SairDocReservacionCodigo sairDocReservacionCodigo) {
		this.sairDocReservacionCodigo = sairDocReservacionCodigo;
	}

	public String getUsuarioEnvio() {
		return this.usuarioEnvio;
	}

	public void setUsuarioEnvio(String usuarioEnvio) {
		this.usuarioEnvio = usuarioEnvio;
	}

	public String getEmailPara() {
		return this.emailPara;
	}

	public void setEmailPara(String emailPara) {
		this.emailPara = emailPara;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEmailCopia() {
		return this.emailCopia;
	}

	public void setEmailCopia(String emailCopia) {
		this.emailCopia = emailCopia;
	}

}
