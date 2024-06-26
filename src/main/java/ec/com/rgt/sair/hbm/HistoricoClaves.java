package ec.com.rgt.sair.hbm;

// Generated 05/08/2013 10:07:40 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * HistoricoClaves generated by hbmjava
 */
@SuppressWarnings("serial")
public class HistoricoClaves implements java.io.Serializable {

	private BigDecimal idHistorico;
	private String idUsuario;
	private String claveAnterior;
	private String claveNueva;
	private Date fechaCambio;
	private String usuarioCambio;

	public HistoricoClaves() {
	}

	public HistoricoClaves(BigDecimal idHistorico, String idUsuario,
			String usuarioCambio) {
		this.idHistorico = idHistorico;
		this.idUsuario = idUsuario;
		this.usuarioCambio = usuarioCambio;
	}

	public HistoricoClaves(BigDecimal idHistorico, String idUsuario,
			String claveAnterior, String claveNueva, Date fechaCambio,
			String usuarioCambio) {
		this.idHistorico = idHistorico;
		this.idUsuario = idUsuario;
		this.claveAnterior = claveAnterior;
		this.claveNueva = claveNueva;
		this.fechaCambio = fechaCambio;
		this.usuarioCambio = usuarioCambio;
	}

	public BigDecimal getIdHistorico() {
		return this.idHistorico;
	}

	public void setIdHistorico(BigDecimal idHistorico) {
		this.idHistorico = idHistorico;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClaveAnterior() {
		return this.claveAnterior;
	}

	public void setClaveAnterior(String claveAnterior) {
		this.claveAnterior = claveAnterior;
	}

	public String getClaveNueva() {
		return this.claveNueva;
	}

	public void setClaveNueva(String claveNueva) {
		this.claveNueva = claveNueva;
	}

	public Date getFechaCambio() {
		return this.fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	public String getUsuarioCambio() {
		return this.usuarioCambio;
	}

	public void setUsuarioCambio(String usuarioCambio) {
		this.usuarioCambio = usuarioCambio;
	}

}
