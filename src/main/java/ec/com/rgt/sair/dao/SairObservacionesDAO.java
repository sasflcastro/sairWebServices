package ec.com.rgt.sair.dao;

import java.util.List;


import ec.com.rgt.sair.hbm.SairCiudad;
import ec.com.rgt.sair.hbm.SairObsAccionAdm;
import ec.com.rgt.sair.hbm.SairObsComentarioAic;
import ec.com.rgt.sair.hbm.SairObsDetallesFaltas;
import ec.com.rgt.sair.hbm.SairObsTipoFalta;
import ec.com.rgt.sair.hbm.SairObservaciones;
import ec.com.rgt.sair.hbm.SairPlantillas;

@SuppressWarnings("unchecked")
public class SairObservacionesDAO extends DAO{
	
	String hql = "";

	public List<SairObservaciones> findObservaciones(String hqlObserv){
		hql=hqlObserv;
		return find(hql);
	}
	
	public List<SairObservaciones> findReporteBrief(String hqlObserv){
		hql=hqlObserv;
		return find(hql);
	}
	
	public List<SairPlantillas> findPlantillas(String hqlPlantilla){
		hql=hqlPlantilla;
		return find(hql);
	}
	
	public List<SairObsComentarioAic> findObsComentarioAic(String hqlObsComentarioAic){
		hql=hqlObsComentarioAic;
		return find(hql);
	}
	
	public List<SairObsDetallesFaltas> findObsDetallesFaltas(String hqlObsDetallesFaltas){
		hql=hqlObsDetallesFaltas;
		return find(hql);
	}
	
	public List<SairObsAccionAdm> findObsAccionAdm(String hqlObsAccionAdm){
		hql=hqlObsAccionAdm;
		return find(hql);
	}
	
	public List<SairCiudad> findCiudad(String hqlObsCiudad){
		hql=hqlObsCiudad;
		return find(hql);
	}
	
	
	public List<SairObsTipoFalta> findObsTipoFalta(String hqlObsTipoFalta){
		hql=hqlObsTipoFalta;
		return find(hql);
	}
	
}
