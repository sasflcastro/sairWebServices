package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class ActaAvance implements java.io.Serializable{
	
	private BigDecimal idAvance;
	private String idProyecto;
	private Date  fechaIngresComentario;
	private String usuarioIngresoComentario;
	private String porcentaje;
	
	
	
	public ActaAvance() {
		
	}

	public ActaAvance(BigDecimal idAvance, String idProyecto, Date fechaIngresComentario, String usuarioIngresoComentario,
			String porcentaje) {	
		this.idAvance = idAvance;
		this.idProyecto = idProyecto;
		this.fechaIngresComentario = fechaIngresComentario;
		this.usuarioIngresoComentario = usuarioIngresoComentario;
		this.porcentaje = porcentaje;
	}
	
	public BigDecimal getIdAvance() {
		return idAvance;
	}
	public void setIdAvance(BigDecimal idAvance) {
		this.idAvance = idAvance;
	}
	public String getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	public Date getFechaIngresComentario() {
		return fechaIngresComentario;
	}
	public void setFechaIngresComentario(Date fechaIngresComentario) {
		this.fechaIngresComentario = fechaIngresComentario;
	}
	public String getUsuarioIngresoComentario() {
		return usuarioIngresoComentario;
	}
	public void setUsuarioIngresoComentario(String usuarioIngresoComentario) {
		this.usuarioIngresoComentario = usuarioIngresoComentario;
	}
	public String getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
	
}
