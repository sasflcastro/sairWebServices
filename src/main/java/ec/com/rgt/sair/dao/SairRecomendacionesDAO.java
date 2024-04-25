package ec.com.rgt.sair.dao;

import java.util.List;

import ec.com.rgt.sair.hbm.RecomendacionHistorica;
import ec.com.rgt.sair.hbm.SairRecAreas;
import ec.com.rgt.sair.hbm.SairRecConclusionReco;
import ec.com.rgt.sair.hbm.SairRecDependencia;
import ec.com.rgt.sair.hbm.SairRecDiscusion;
import ec.com.rgt.sair.hbm.SairRecRecomendacion;

@SuppressWarnings("unchecked")
public class SairRecomendacionesDAO extends DAO{
	
	String hql = "";
	
	public List<SairRecRecomendacion> findRecomendaciones(String hqlRecomen){
		hql=hqlRecomen;
		return find(hql);
	}
	
	public List<SairRecDiscusion> findSairRecDiscusion(String hqlRecDiscusion){
		hql=hqlRecDiscusion;
		return find(hql);
	}
	
	public List<SairRecDependencia> findRecDependencia(String hqlDependencia){
		hql=hqlDependencia;
		return find(hql);
	}
	
	public List<RecomendacionHistorica> findRecomendacionH(String hqlRecoHis){
		hql=hqlRecoHis;
		return find(hql);
	}
	
	public List<SairRecConclusionReco> findRecConclusionesRec(String hqlRecoCon){
		hql=hqlRecoCon;
		return find(hql);
	}

	public List<SairRecAreas> findSairRecAreas(String hqlRecAreas) {
		hql=hqlRecAreas;
		return find(hql);
	}
	
		
}













