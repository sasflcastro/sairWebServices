package ec.com.rgt.sair.hbm;

// Generated 03-sep-2014 14:27:54 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SairRecConclusionReco generated by hbmjava
 */
public class SairRecAreas implements java.io.Serializable {
	private String areaAplica;
	private String unidad;
	private BigDecimal codUnidad;
	private String area;
	
	
	public SairRecAreas() {
		
	}


	public SairRecAreas(String areaAplica, String unidad, BigDecimal codUnidad, String area, BigDecimal codArea) {
		this.areaAplica = areaAplica;
		this.unidad = unidad;
		this.codUnidad = codUnidad;
		this.area = area;
	}


	public String getAreaAplica() {
		return areaAplica;
	}


	public void setAreaAplica(String areaAplica) {
		this.areaAplica = areaAplica;
	}


	public String getUnidad() {
		return unidad;
	}


	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	public BigDecimal getCodUnidad() {
		return codUnidad;
	}


	public void setCodUnidad(BigDecimal codUnidad) {
		this.codUnidad = codUnidad;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}
	
}