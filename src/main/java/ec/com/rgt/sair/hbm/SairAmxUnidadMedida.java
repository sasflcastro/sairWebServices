package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;
@SuppressWarnings("serial")
public class SairAmxUnidadMedida implements java.io.Serializable{
	private BigDecimal idSairAmxUnidadMedida;
	private String nombre;
	private String estado;
	private SairAmxUnidMedMacro sairAmxUnidMedMacro;
	public SairAmxUnidadMedida() {
		
	}
	public SairAmxUnidadMedida(BigDecimal idSairAmxUnidadMedida,String nombre, String estado, SairAmxUnidMedMacro sairAmxUnidMedMacro)
	{
		this.idSairAmxUnidadMedida=idSairAmxUnidadMedida;
		this.nombre=nombre;
		this.estado=estado;
		this.sairAmxUnidMedMacro=sairAmxUnidMedMacro;
	}
	
	public BigDecimal getIdSairAmxUnidadMedida() {
		return idSairAmxUnidadMedida;
	}
	public void setIdSairAmxUnidadMedida(BigDecimal idSairAmxUnidadMedida) {
		this.idSairAmxUnidadMedida = idSairAmxUnidadMedida;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public SairAmxUnidMedMacro getSairAmxUnidMedMacro() {
		return sairAmxUnidMedMacro;
	}
	public void setSairAmxUnidMedMacro(SairAmxUnidMedMacro sairAmxUnidMedMacro) {
		this.sairAmxUnidMedMacro = sairAmxUnidMedMacro;
	}
}
