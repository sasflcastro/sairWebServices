package ec.com.rgt.sair.hbm;
// Generated 10-nov-2015 9:38:15 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;

/**
 * SairPantallaUsuario generated by hbmjava
 */
public class SairPantallaUsuario implements java.io.Serializable {

	private SairPantallaUsuarioId id;
	private SairPantalla sairPantalla;
	private Usuarios usuarios;
	private BigDecimal div,orden;

	public SairPantallaUsuario() {
	}

	public SairPantallaUsuario(SairPantallaUsuarioId id, SairPantalla sairPantalla, Usuarios usuarios) {
		this.id = id;
		this.sairPantalla = sairPantalla;
		this.usuarios = usuarios;
	}

	public SairPantallaUsuario(SairPantallaUsuarioId id, SairPantalla sairPantalla, Usuarios usuarios, BigDecimal div,BigDecimal orden) {
		this.id = id;
		this.sairPantalla = sairPantalla;
		this.usuarios = usuarios;
		this.div = div;
		this.orden = orden;
	}

	public BigDecimal getOrden() {
		return orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	public SairPantallaUsuarioId getId() {
		return this.id;
	}

	public void setId(SairPantallaUsuarioId id) {
		this.id = id;
	}

	public SairPantalla getSairPantalla() {
		return this.sairPantalla;
	}

	public void setSairPantalla(SairPantalla sairPantalla) {
		this.sairPantalla = sairPantalla;
	}

	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public BigDecimal getDiv() {
		return this.div;
	}

	public void setDiv(BigDecimal div) {
		this.div = div;
	}

}
