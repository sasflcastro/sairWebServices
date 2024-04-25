package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;
import java.util.Date;
@SuppressWarnings("serial")
public class SairAmxDocumento implements java.io.Serializable{
	private BigDecimal idSairAmxDocumento;
	private BigDecimal muestra;
	private BigDecimal inconsistencia;
	private BigDecimal recuperar;
	private BigDecimal devolver;
	private SairDocReservacionCodigo sairDocReservacionCodigo;
	private SairAmxUnidadMedida sairAmxUnidadMedida;
	private Date fechaEmision;
	private String estado;
	private SairPoliticaProcedimiento sairPoliticaProcedimiento;
	public SairAmxDocumento(){}
	public SairAmxDocumento(BigDecimal idSairAmxDocumento,BigDecimal muestra,BigDecimal inconsistencia,
			BigDecimal recuperar,BigDecimal devolver,SairDocReservacionCodigo sairDocReservacionCodigo,
			SairAmxUnidadMedida sairAmxUnidadMedida,Date fechaEmision,String estado, SairPoliticaProcedimiento sairPoliticaProcedimiento)
	{
		this.idSairAmxDocumento=idSairAmxDocumento;
		this.muestra=muestra;
		this.inconsistencia=inconsistencia;
		this.recuperar=recuperar;
		this.devolver=devolver;
		this.sairDocReservacionCodigo=sairDocReservacionCodigo;
		this.sairAmxUnidadMedida=sairAmxUnidadMedida;
		this.fechaEmision=fechaEmision;
		this.estado=estado;
		this.sairPoliticaProcedimiento=sairPoliticaProcedimiento;
	}
	
	public BigDecimal getIdSairAmxDocumento() {
		return idSairAmxDocumento;
	}
	public void setIdSairAmxDocumento(BigDecimal idSairAmxDocumento) {
		this.idSairAmxDocumento = idSairAmxDocumento;
	}
	public BigDecimal getMuestra() {
		return muestra;
	}
	public void setMuestra(BigDecimal muestra) {
		this.muestra = muestra;
	}
	public BigDecimal getInconsistencia() {
		return inconsistencia;
	}
	public void setInconsistencia(BigDecimal inconsistencia) {
		this.inconsistencia = inconsistencia;
	}
	public BigDecimal getRecuperar() {
		return recuperar;
	}
	public void setRecuperar(BigDecimal recuperar) {
		this.recuperar = recuperar;
	}
	public BigDecimal getDevolver() {
		return devolver;
	}
	public void setDevolver(BigDecimal devolver) {
		this.devolver = devolver;
	}
	public SairDocReservacionCodigo getSairDocReservacionCodigo() {
		return sairDocReservacionCodigo;
	}
	public void setSairDocReservacionCodigo(
			SairDocReservacionCodigo sairDocReservacionCodigo) {
		this.sairDocReservacionCodigo = sairDocReservacionCodigo;
	}
	public SairAmxUnidadMedida getSairAmxUnidadMedida() {
		return sairAmxUnidadMedida;
	}
	public void setSairAmxUnidadMedida(SairAmxUnidadMedida sairAmxUnidadMedida) {
		this.sairAmxUnidadMedida = sairAmxUnidadMedida;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public SairPoliticaProcedimiento getSairPoliticaProcedimiento() {
		return sairPoliticaProcedimiento;
	}
	public void setSairPoliticaProcedimiento(SairPoliticaProcedimiento sairPoliticaProcedimiento) {
		this.sairPoliticaProcedimiento = sairPoliticaProcedimiento;
	}
}
