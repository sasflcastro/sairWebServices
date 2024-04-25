package ec.com.rgt.sair.dao;

import java.util.List;

import ec.com.rgt.sair.hbm.SairAmxUnidadMedida;
import ec.com.rgt.sair.hbm.SairConfiguraRutina;
import ec.com.rgt.sair.hbm.SairMgConfigTablero;
import ec.com.rgt.sair.hbm.SairMgDetalleProcesos;
import ec.com.rgt.sair.hbm.SairMgRutinas;
import ec.com.rgt.sair.hbm.SairMgTableroProcesos;
import ec.com.rgt.sair.hbm.SairParDeficiencia;
import ec.com.rgt.sair.hbm.SairParDetalleRutina;
import ec.com.rgt.sair.hbm.SairParPeriodicidad;
import ec.com.rgt.sair.hbm.SairParPoliticas;
import ec.com.rgt.sair.hbm.SairParProgramaRutina;
import ec.com.rgt.sair.hbm.SairParRutina;
import ec.com.rgt.sair.hbm.SairPoliticaProcedimiento;
import ec.com.rgt.sair.hbm.SairPoliticaProceso;
import ec.com.rgt.sair.hbm.SairPoliticaSubProceso;
import ec.com.rgt.sair.hbm.SairPoliticasRutinas;
import ec.com.rgt.sair.hbm.SairRutinaProceso;
import ec.com.rgt.sair.hbm.SairTipoPlan;

@SuppressWarnings("unchecked")
public class SairParRutinaDAO extends DAO{
	
	String hql = "";
	
	public List<SairParRutina> findRutina(String hqlRutina){
		hql=hqlRutina;
		return find(hql);
	}
	
	public List<SairParDeficiencia> findDefiencia(String hqlDeficiencia){
		hql=hqlDeficiencia;
		return find(hql);
	}
	
	public List<SairTipoPlan> findTipoPlan(String hqlTipoPlan){
		hql=hqlTipoPlan;
		return find(hql);
	}
	
	public List<SairPoliticaProcedimiento> findProcedimiento(String hqlProcedimiento){
		hql=hqlProcedimiento;
		return find(hql);
	}
	public List<SairPoliticaProceso> findProceso(String hqlProceso){
		hql=hqlProceso;
		return find(hql);
	}
	public List<SairPoliticaSubProceso> findSubProceso(String hqlSubProceso){
		hql=hqlSubProceso;
		return find(hql);
	}
	
	public List<SairParProgramaRutina> findProgramaRutina(String hqlPrograma){
		hql=hqlPrograma;
		return find(hql);
	}
	
	public List<SairParDetalleRutina> findDetalleRutina(String hqlDetalle){
		hql=hqlDetalle;
		return find(hql);
	}
	
	public List<SairParPeriodicidad> findPeriodicidad(String hqlPeriodicidad){
		hql=hqlPeriodicidad;
		return find(hql);
	}
	
	public List<SairRutinaProceso> findRutinaProceso(String hqlRutPro){
		hql=hqlRutPro;
		return find(hql);
	}
	
	public List<SairConfiguraRutina> findConfiguraRutina(String hqlConRut){
		return find(hqlConRut);
	}
	
	public List<SairMgRutinas> findMgRutina(String hqlMgRutina){
		hql=hqlMgRutina;
		return find(hql);
	}
	
	public List<SairMgTableroProcesos> findMgTableroProceso(String hqlMgTabProceso){
		hql=hqlMgTabProceso;
		return find(hql);
	}
	
	public List<SairMgDetalleProcesos> findMgDetalleProceso(String hqlMgDetaProceso){
		hql=hqlMgDetaProceso;
		return find(hql);
	}
	
	public List<SairMgConfigTablero> findMgConfigTablero(String hqlMgConfigTablero){
		hql=hqlMgConfigTablero;
		return find(hql);
	}

	public List<SairParPoliticas> findSairParPoliticas(String hqlParPltc) {
		hql=hqlParPltc;
		return find(hql);
	}

	public List<SairPoliticasRutinas> findSairPoliticasRutinas(String hqlSairPoliticasRutinas){
		hql=hqlSairPoliticasRutinas;
		return find(hql);
	}
	
}
