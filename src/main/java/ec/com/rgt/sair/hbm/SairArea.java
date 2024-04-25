package ec.com.rgt.sair.hbm;

// Generated 14-oct-2013 14:03:09 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * SairArea generated by hbmjava
 */
@SuppressWarnings("serial")
public class SairArea implements java.io.Serializable {

	private BigDecimal idArea;
	private String descripcion;
	private String estado;
	private String abreviaturaDep;
	private String abreviaturaArea;
	private String abreviaturaGeneral;
	private String orden,email;
	private Date fechaIngreso;
	private String jefeArea,codBrief,idOperacion;

	public SairArea() {
	}

	public SairArea(BigDecimal idArea) {
		this.idArea = idArea;
	}

	public SairArea(BigDecimal idArea, String descripcion, String estado,
			String abreviaturaDep, String abreviaturaArea,
			String abreviaturaGeneral, String orden, Date fechaIngreso, String jefeArea,String email,String codBrief,String idOperacion) {
		this.idArea = idArea;
		this.descripcion = descripcion;
		this.estado = estado;
		this.abreviaturaDep = abreviaturaDep;
		this.abreviaturaArea = abreviaturaArea;
		this.abreviaturaGeneral = abreviaturaGeneral;
		this.orden = orden;
		this.fechaIngreso = fechaIngreso;
		this.jefeArea = jefeArea;
		this.email = email;
		this.codBrief = codBrief;
		this.idOperacion = idOperacion;
	}

	
	public String getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(String idOperacion) {
		this.idOperacion = idOperacion;
	}

	public String getCodBrief() {
		return codBrief;
	}

	public void setCodBrief(String codBrief) {
		this.codBrief = codBrief;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getIdArea() {
		return this.idArea;
	}

	public void setIdArea(BigDecimal idArea) {
		this.idArea = idArea;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAbreviaturaDep() {
		return this.abreviaturaDep;
	}

	public void setAbreviaturaDep(String abreviaturaDep) {
		this.abreviaturaDep = abreviaturaDep;
	}

	public String getAbreviaturaArea() {
		return this.abreviaturaArea;
	}

	public void setAbreviaturaArea(String abreviaturaArea) {
		this.abreviaturaArea = abreviaturaArea;
	}

	public String getAbreviaturaGeneral() {
		return this.abreviaturaGeneral;
	}

	public void setAbreviaturaGeneral(String abreviaturaGeneral) {
		this.abreviaturaGeneral = abreviaturaGeneral;
	}

	public String getOrden() {
		return this.orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public String getJefeArea() {
		return this.jefeArea;
	}

	public void setJefeArea(String jefeArea) {
		this.jefeArea = jefeArea;
	}


}
