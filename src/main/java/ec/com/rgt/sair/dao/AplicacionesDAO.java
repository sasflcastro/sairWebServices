package ec.com.rgt.sair.dao;

import java.math.BigDecimal;

import java.util.List;
@SuppressWarnings("rawtypes")
public class AplicacionesDAO  extends DAO{

	String hqlAplicaciones = "";

	public List ListaAplicaciones() {
		hqlAplicaciones = "from Aplicaciones";
		return find(hqlAplicaciones);
	}

	public List ConsultaAplicaciones(BigDecimal IdAplicacion) {
		hqlAplicaciones = "from Aplicaciones where idAplicacion = " + IdAplicacion ;
		return find(hqlAplicaciones);
	}

	public List findAplicaciones(String hqlAplicacion) {
		hqlAplicaciones = hqlAplicacion;
		return find(hqlAplicaciones);
	}

	public List findCalEvcorresponsableentos(String hqlCalEventos) {
		hqlAplicaciones = hqlCalEventos;
		return find(hqlAplicaciones);
	}

	public List findCalTipoEventos(String hqlCalTipoEv) {
		hqlAplicaciones = hqlCalTipoEv;
		return find(hqlAplicaciones);
	}
	
	  public List findCalEventos(String hqlCalEventos) {
		    this.hqlAplicaciones = hqlCalEventos;
		    return find(this.hqlAplicaciones);
		  }

	public List findSairRecoUsuarioInvitado(String hqlUsuarioInvitado) {
		hqlAplicaciones = hqlUsuarioInvitado;
		return find(hqlAplicaciones);
	}
	
	public List findSairRecoUsuarioMasivo(String hqlUsuarioMasivo) {
		hqlAplicaciones = hqlUsuarioMasivo;
		return find(hqlAplicaciones);
	}

}
