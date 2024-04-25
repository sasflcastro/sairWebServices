package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;


public class UsuariosMapeados {
	private String nombresCompletos,nombresCompletos2;
	private String usuario1,usuario2;
	private String email1,email2;
	private String usuariosAdam;
	
    public UsuariosMapeados()
    {
    	/**/
    }
	
	public UsuariosMapeados(String nombresCompletos, String usuario1,
			String usuario2, String email1, String email2, String usuariosAdam,String nombresCompletos2) {
		this.nombresCompletos = nombresCompletos;
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
		this.email1 = email1;
		this.email2 = email2;
		this.usuariosAdam = usuariosAdam;
		this.nombresCompletos2 = nombresCompletos2;
	}


	public String getNombresCompletos2() {
		return nombresCompletos2;
	}

	public void setNombresCompletos2(String nombresCompletos2) {
		this.nombresCompletos2 = nombresCompletos2;
	}

	public String getNombresCompletos() {
		return nombresCompletos;
	}


	public void setNombresCompletos(String nombresCompletos) {
		this.nombresCompletos = nombresCompletos;
	}


	public String getUsuario1() {
		return usuario1;
	}


	public void setUsuario1(String usuario1) {
		this.usuario1 = usuario1;
	}


	public String getUsuario2() {
		return usuario2;
	}


	public void setUsuario2(String usuario2) {
		this.usuario2 = usuario2;
	}


	public String getEmail1() {
		return email1;
	}


	public void setEmail1(String email1) {
		this.email1 = email1;
	}


	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
	}


	public String getUsuariosAdam() {
		return usuariosAdam;
	}
	public void setUsuariosAdam(String usuariosAdam) {
		this.usuariosAdam = usuariosAdam;
	}
	
}
