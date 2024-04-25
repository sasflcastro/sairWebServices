package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.hbm.SairEstados;
import ec.com.rgt.sair.hbm.SairParUnidadRutina;
import ec.com.rgt.sair.hbm.SairUnidadGerente;

public class OperacionesUnidad extends DAO{

	public int deleteUnidadRutina(BigDecimal idSubArea,BigDecimal idRutina){
		@SuppressWarnings("unchecked")
		List<SairParUnidadRutina> list=find("from SairParUnidadRutina u where u.id.idSubArea="+idSubArea+" and u.id.idRutina="+idRutina);
		int res=0;
		for (int i = 0; i < list.size(); i++) {
			res=delete(list.get(i), list.get(i).getClass());
		}
		return res;
	}
	
	public List<SairParUnidadRutina> findUnidadRutina(String hql){
		@SuppressWarnings("unchecked")
		List<SairParUnidadRutina> list=find(hql);
		return list;
	}
	
	public int insertUnidadRutina(SairParUnidadRutina parUnidadRutina){
		return saveOrUpdate(parUnidadRutina, parUnidadRutina.getClass());
	}
	
	public int insertUnidadGerente(SairUnidadGerente unidadGerente){
		return saveOrUpdate(unidadGerente, unidadGerente.getClass());
	}
	
	public int deleteUnidadGerente(BigDecimal idSubArea){
		@SuppressWarnings("unchecked")
		List<SairUnidadGerente> list=find("from SairUnidadGerente u where u.idSubArea="+idSubArea);
		int res=0;
		for (int i = 0; i < list.size(); i++) {
			res=delete(list.get(i), list.get(i).getClass());
		}
		return res;
	}
	
	public List<SairUnidadGerente> findUnidadGerente(String hql){
		@SuppressWarnings("unchecked")
		List<SairUnidadGerente> list=find(hql);
		return list;
	}
	
	//Estado General de la Recomendación [Abierto/Cerrado]
	public List<SairEstados> buscarEstadosReco(){
		@SuppressWarnings("unchecked")
		List<SairEstados> list=find("from SairEstados se where se.estado='A'");
		return list;
	}
}
