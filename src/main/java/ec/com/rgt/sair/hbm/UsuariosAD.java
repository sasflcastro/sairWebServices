package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;


public class UsuariosAD {
	private BigDecimal idUsuariosAD;
	private String nombresCompletos;
	private String usuario;
	private String email;
	private String estado;
	private String areaAdam;
	private String usuariosAdam;
	
    public UsuariosAD()
    {
    	/**/
    }
	
	public UsuariosAD(BigDecimal idUsuariosAD, String nombresCompletos, String usuario, String email, String estado,
			String areaAdam,String usuariosAdam) {
		this.idUsuariosAD=idUsuariosAD;
		this.nombresCompletos=nombresCompletos;
		this.usuario=usuario;
		this.email=email;
		this.estado=estado;
		this.areaAdam=areaAdam;
		this.usuariosAdam=usuariosAdam;
	}
	public BigDecimal getIdUsuariosAD() {
		return idUsuariosAD;
	}
	public void setIdUsuariosAD(BigDecimal idUsuariosAD) {
		this.idUsuariosAD = idUsuariosAD;
	}
	public String getNombresCompletos() {
		return nombresCompletos;
	}
	public void setNombresCompletos(String nombresCompletos) {
		this.nombresCompletos = nombresCompletos;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getAreaAdam() {
		return areaAdam;
	}
	public void setAreaAdam(String areaAdam) {
		this.areaAdam = areaAdam;
	}
	public String getUsuariosAdam() {
		return usuariosAdam;
	}
	public void setUsuariosAdam(String usuariosAdam) {
		this.usuariosAdam = usuariosAdam;
	}
	
}
