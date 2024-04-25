package ec.com.rgt.sair.hbm;

// Generated 14-oct-2013 14:03:09 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
//import java.sql.String;

import ec.com.rgt.sair.hbm.SairArea;


/**
 * SairDocReservacionCodigo generated by hbmjava
 */
//@XmlRootElement
//@XmlSeeAlso({SairDocReservacionCodigo.class})
@SuppressWarnings("serial")
public class SairDocReservacionCodigo implements java.io.Serializable {

	private BigDecimal idSecuenciaReservaCodigo;
	private SairParRutina sairParRutina;
	private SairDocTipoDocumento sairDocTipoDocumento;
	private SairArea sairArea;
	private SairEstadosPrincipal sairEstadosPrincipal;
	private String idUsuarioAic;
	private String usuarioUsaCod;
	private String codigoReservado;
	private Date fechaReserva;
	private String observacion;
	private String estado;
	private BigDecimal idEstadoComp;
	private BigDecimal anioReserva;
	private BigDecimal idSecuenciaReservaHijo;
	private BigDecimal codigo;
	private Date temFechaPreliModReco;
	private BigDecimal anioEmision;
	private BigDecimal prioridad;


	public BigDecimal getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(BigDecimal prioridad) {
		this.prioridad = prioridad;
	}

	public SairArea getSairArea() {
		return sairArea;
	}

	public void setSairArea(SairArea sairArea) {
		this.sairArea = sairArea;
	}

	public SairDocReservacionCodigo() {
	}
		
	public SairDocReservacionCodigo(BigDecimal idSecuenciaReservaCodigo, SairParRutina sairParRutina,
			SairDocTipoDocumento sairDocTipoDocumento, SairArea sairArea, SairEstadosPrincipal sairEstadosPrincipal,
			String idUsuarioAic, String usuarioUsaCod, String codigoReservado, Date fechaReserva, String observacion,
			String estado, BigDecimal idEstadoComp, BigDecimal anioReserva, BigDecimal idSecuenciaReservaHijo,
			BigDecimal codigo, Date temFechaPreliModReco, BigDecimal anioEmision, BigDecimal prioridad) {
		this.idSecuenciaReservaCodigo = idSecuenciaReservaCodigo;
		this.sairParRutina = sairParRutina;
		this.sairDocTipoDocumento = sairDocTipoDocumento;
		this.sairArea = sairArea;
		this.sairEstadosPrincipal = sairEstadosPrincipal;
		this.idUsuarioAic = idUsuarioAic;
		this.usuarioUsaCod = usuarioUsaCod;
		this.codigoReservado = codigoReservado;
		this.fechaReserva = fechaReserva;
		this.observacion = observacion;
		this.estado = estado;
		this.idEstadoComp = idEstadoComp;
		this.anioReserva = anioReserva;
		this.idSecuenciaReservaHijo = idSecuenciaReservaHijo;
		this.codigo = codigo;
		this.temFechaPreliModReco = temFechaPreliModReco;
		this.anioEmision = anioEmision;
		this.prioridad = prioridad;
	}

	
	public BigDecimal getAnioEmision() {
		return anioEmision;
	}

	public void setAnioEmision(BigDecimal anioEmision) {
		this.anioEmision = anioEmision;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getIdSecuenciaReservaHijo() {
		return idSecuenciaReservaHijo;
	}

	public void setIdSecuenciaReservaHijo(BigDecimal idSecuenciaReservaHijo) {
		this.idSecuenciaReservaHijo = idSecuenciaReservaHijo;
	}

	public BigDecimal getIdSecuenciaReservaCodigo() {
		return this.idSecuenciaReservaCodigo;
	}

	public void setIdSecuenciaReservaCodigo(BigDecimal idSecuenciaReservaCodigo) {
		this.idSecuenciaReservaCodigo = idSecuenciaReservaCodigo;
	}

	public SairParRutina getSairParRutina() {
		return this.sairParRutina;
	}

	public void setSairParRutina(SairParRutina sairParRutina) {
		this.sairParRutina = sairParRutina;
	}

	public SairDocTipoDocumento getSairDocTipoDocumento() {
		return this.sairDocTipoDocumento;
	}

	public void setSairDocTipoDocumento(
			SairDocTipoDocumento sairDocTipoDocumento) {
		this.sairDocTipoDocumento = sairDocTipoDocumento;
	}

	public SairEstadosPrincipal getSairEstadosPrincipal() {
		return this.sairEstadosPrincipal;
	}

	public void setSairEstadosPrincipal(
			SairEstadosPrincipal sairEstadosPrincipal) {
		this.sairEstadosPrincipal = sairEstadosPrincipal;
	}

	public String getIdUsuarioAic() {
		return this.idUsuarioAic;
	}

	public void setIdUsuarioAic(String idUsuarioAic) {
		this.idUsuarioAic = idUsuarioAic;
	}

	public String getUsuarioUsaCod() {
		return this.usuarioUsaCod;
	}

	public void setUsuarioUsaCod(String usuarioUsaCod) {
		this.usuarioUsaCod = usuarioUsaCod;
	}

	public String getCodigoReservado() {
		return this.codigoReservado;
	}

	public void setCodigoReservado(String codigoReservado) {
		this.codigoReservado = codigoReservado;
	}

	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	 
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public BigDecimal getIdEstadoComp() {
		return this.idEstadoComp;
	}

	public void setIdEstadoComp(BigDecimal idEstadoComp) {
		this.idEstadoComp = idEstadoComp;
	}

	public BigDecimal getAnioReserva() {
		return this.anioReserva;
	}

	public void setAnioReserva(BigDecimal anioReserva) {
		this.anioReserva = anioReserva;
	}

	public BigDecimal getCodigo() {
		return this.codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}
	
	public Date getTemFechaPreliModReco() {
		return this.temFechaPreliModReco;
	}

	public void setTemFechaPreliModReco(Date temFechaPreliModReco) {
		this.temFechaPreliModReco = temFechaPreliModReco;
	}
}