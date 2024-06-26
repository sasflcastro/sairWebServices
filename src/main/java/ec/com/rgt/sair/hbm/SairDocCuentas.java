package ec.com.rgt.sair.hbm;
// Generated 03/10/2017 15:24:44 by Hibernate Tools 3.6.0.Final

import ec.com.rgt.sair.hbm.SairDocCuentasId;

/**
 * SairDocCuentas generated by hbm2java
 */
public class SairDocCuentas implements java.io.Serializable {

	private SairDocCuentasId id;
	private String destinatario;

	public SairDocCuentas() {
	}

	public SairDocCuentas(SairDocCuentasId id) {
		this.id = id;
	}

	public SairDocCuentas(SairDocCuentasId id, String destinatario) {
		this.id = id;
		this.destinatario = destinatario;
	}

	public SairDocCuentasId getId() {
		return this.id;
	}

	public void setId(SairDocCuentasId id) {
		this.id = id;
	}

	public String getDestinatario() {
		return this.destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

}
