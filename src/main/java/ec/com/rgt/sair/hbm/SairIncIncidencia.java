package ec.com.rgt.sair.hbm;

// Generated 05-nov-2014 9:57:20 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SairIncIncidencia generated by hbmjava
 */
public class SairIncIncidencia implements java.io.Serializable {

	private BigDecimal idIncidencia;
	private SairIncComentario sairIncComentario;
	private SairAreasAdam sairAreasAdam;
	private SairIncTipo sairIncTipo;
	private SairSubArea sairSubArea;
	private String idGerente;
	private String detalle;
	private Date fechaIngreso;
	private Date fechaEmision;
	private Date generado;
	private String estado;
	private BigDecimal mes,cerrada,anterior,dentroTiempo,noAtendida,fueraTiempo;
	private String porcentaje;

	public SairIncIncidencia() {
	}

	public SairIncIncidencia(BigDecimal idIncidencia) {
		this.idIncidencia = idIncidencia;
	}
	
	public SairIncIncidencia(BigDecimal idIncidencia,
			SairIncComentario sairIncComentario, SairAreasAdam sairAreasAdam,
			SairIncTipo sairIncTipo, SairSubArea sairSubArea, String idGerente,
			String detalle, Date fechaIngreso, Date fechaEmision,
			Date generado, String estado, BigDecimal mes, BigDecimal cerrada,
			BigDecimal anterior, BigDecimal dentroTiempo,
			BigDecimal noAtendida, BigDecimal fueraTiempo, String porcentaje) {
		super();
		this.idIncidencia = idIncidencia;
		this.sairIncComentario = sairIncComentario;
		this.sairAreasAdam = sairAreasAdam;
		this.sairIncTipo = sairIncTipo;
		this.sairSubArea = sairSubArea;
		this.idGerente = idGerente;
		this.detalle = detalle;
		this.fechaIngreso = fechaIngreso;
		this.fechaEmision = fechaEmision;
		this.generado = generado;
		this.estado = estado;
		this.mes = mes;
		this.cerrada = cerrada;
		this.anterior = anterior;
		this.dentroTiempo = dentroTiempo;
		this.noAtendida = noAtendida;
		this.fueraTiempo = fueraTiempo;
		this.porcentaje = porcentaje;
	}

	public BigDecimal getCerrada() {
		return cerrada;
	}

	public void setCerrada(BigDecimal cerrada) {
		this.cerrada = cerrada;
	}

	public BigDecimal getAnterior() {
		return anterior;
	}

	public void setAnterior(BigDecimal anterior) {
		this.anterior = anterior;
	}

	public BigDecimal getDentroTiempo() {
		return dentroTiempo;
	}

	public void setDentroTiempo(BigDecimal dentroTiempo) {
		this.dentroTiempo = dentroTiempo;
	}

	public BigDecimal getNoAtendida() {
		return noAtendida;
	}

	public void setNoAtendida(BigDecimal noAtendida) {
		this.noAtendida = noAtendida;
	}

	public BigDecimal getFueraTiempo() {
		return fueraTiempo;
	}

	public void setFueraTiempo(BigDecimal fueraTiempo) {
		this.fueraTiempo = fueraTiempo;
	}

	public BigDecimal getIdIncidencia() {
		return this.idIncidencia;
	}

	public void setIdIncidencia(BigDecimal idIncidencia) {
		this.idIncidencia = idIncidencia;
	}

	public SairIncComentario getSairIncComentario() {
		return this.sairIncComentario;
	}

	public void setSairIncComentario(SairIncComentario sairIncComentario) {
		this.sairIncComentario = sairIncComentario;
	}

	public SairAreasAdam getSairAreasAdam() {
		return this.sairAreasAdam;
	}

	public void setSairAreasAdam(SairAreasAdam sairAreasAdam) {
		this.sairAreasAdam = sairAreasAdam;
	}

	public SairIncTipo getSairIncTipo() {
		return this.sairIncTipo;
	}

	public void setSairIncTipo(SairIncTipo sairIncTipo) {
		this.sairIncTipo = sairIncTipo;
	}

	public SairSubArea getSairSubArea() {
		return this.sairSubArea;
	}

	public void setSairSubArea(SairSubArea sairSubArea) {
		this.sairSubArea = sairSubArea;
	}

	public String getIdGerente() {
		return this.idGerente;
	}

	public void setIdGerente(String idGerente) {
		this.idGerente = idGerente;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getGenerado() {
		return this.generado;
	}

	public void setGenerado(Date generado) {
		this.generado = generado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getMes() {
		return this.mes;
	}

	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}

	public String getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	
}
