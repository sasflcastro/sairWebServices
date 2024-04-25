package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

@SuppressWarnings("serial")
public class SairDocTipoHallazgo implements java.io.Serializable {
	
	private BigDecimal idTipoHallazgo;
	private String nombre;
	private String estado;
	
	public SairDocTipoHallazgo() {		
	}
	
	public SairDocTipoHallazgo(BigDecimal idTipoHallazgo, String nombre, String estado) {
		this.idTipoHallazgo = idTipoHallazgo;
		this.nombre = nombre;
		this.estado = estado;
	}

	public BigDecimal getIdTipoHallazgo() {
		return idTipoHallazgo;
	}

	public void setIdTipoHallazgo(BigDecimal idTipoHallazgo) {
		this.idTipoHallazgo = idTipoHallazgo;
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
	
	

}
