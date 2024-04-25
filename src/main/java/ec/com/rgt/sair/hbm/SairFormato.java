package ec.com.rgt.sair.hbm;

// Generated 17-oct-2013 13:40:15 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SairFormato generated by hbmjava
 */
public class SairFormato implements java.io.Serializable {

	private BigDecimal idFormato;
	private String tabla;
	private String campos;
	private BigDecimal orden;
	private String estado;
	private String obligatorio;

	public SairFormato() {
	}

	public SairFormato(BigDecimal idFormato, String tabla, String campos,
			BigDecimal orden, String estado, String obligatorio) {
		this.idFormato = idFormato;
		this.tabla = tabla;
		this.campos = campos;
		this.orden = orden;
		this.estado = estado;
		this.obligatorio = obligatorio;
	}

	public String getObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(String obligatorio) {
		this.obligatorio = obligatorio;
	}

	public BigDecimal getIdFormato() {
		return this.idFormato;
	}

	public void setIdFormato(BigDecimal idFormato) {
		this.idFormato = idFormato;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getCampos() {
		return this.campos;
	}

	public void setCampos(String campos) {
		this.campos = campos;
	}

	public BigDecimal getOrden() {
		return this.orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
