package ec.com.rgt.sair.dao;

import java.util.List;

import ec.com.rgt.sair.hbm.SairFrecuencia;
import ec.com.rgt.sair.hbm.SairParComentarioRutina;

@SuppressWarnings("unchecked")
public class SairFrecuenciaComentarioDAO extends DAO{
	
	String hql = "";
	
	public List<SairFrecuencia> findFrecuencia(String hqlFrecuencia){
		hql=hqlFrecuencia;
		return find(hql);
	}
	
	public List<SairParComentarioRutina> findComentario(String hqlComentario){
		hql=hqlComentario;
		return find(hql);
	}

}
