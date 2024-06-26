package ec.com.rgt.sair.hbm;

// Generated 08-jul-2013 0:41:27 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * GruposUsuarios generated by hbmjava
 */
@SuppressWarnings("serial")
public class SairParUnidadRutina implements java.io.Serializable {

	private SairParUnidadRutinaId id;
	private SairSubArea sairSubArea;
	private SairParRutina sairParRutina;
	private String personaAsignada;

	public SairParUnidadRutina() {
	}

	public SairParUnidadRutina(SairParUnidadRutinaId id,
			SairSubArea sairSubArea, SairParRutina sairParRutina,
			String personaAsignada) {
		super();
		this.id = id;
		this.sairSubArea = sairSubArea;
		this.sairParRutina = sairParRutina;
		this.personaAsignada = personaAsignada;
	}

	public SairParUnidadRutinaId getId() {
		return id;
	}

	public void setId(SairParUnidadRutinaId id) {
		this.id = id;
	}

	public SairSubArea getSairSubArea() {
		return sairSubArea;
	}

	public void setSairSubArea(SairSubArea sairSubArea) {
		this.sairSubArea = sairSubArea;
	}

	public SairParRutina getSairParRutina() {
		return sairParRutina;
	}

	public void setSairParRutina(SairParRutina sairParRutina) {
		this.sairParRutina = sairParRutina;
	}

	public String getPersonaAsignada() {
		return personaAsignada;
	}

	public void setPersonaAsignada(String personaAsignada) {
		this.personaAsignada = personaAsignada;
	}

	

}
