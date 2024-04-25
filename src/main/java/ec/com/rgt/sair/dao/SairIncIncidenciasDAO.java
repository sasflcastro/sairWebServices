package ec.com.rgt.sair.dao;

import java.util.List;

import ec.com.rgt.sair.hbm.SairIncIncidencia;
import ec.com.rgt.sair.hbm.SairIncTipo;
import ec.com.rgt.sair.hbm.TblProceAmx;
import ec.com.rgt.sair.hbm.TblProceAmxEnvia;

@SuppressWarnings("unchecked")
public class SairIncIncidenciasDAO extends DAO 
{
	String hql = "";
	public List<SairIncIncidencia> findIncIncidencias(String hqlInc)
	{
		hql=hqlInc;
		return find(hql);
	}
	public List<SairIncTipo> findIncTipo(String hqlIncTipo)
	{
		hql=hqlIncTipo;
		return find(hql);
	}
	public List<TblProceAmx> findAmxs(String hqlAmxs)
	{
		hql=hqlAmxs;
		return find(hql);
	}
	public List<TblProceAmxEnvia> findAmxEnvias(String hqlAmxEnvia)
	{
		hql=hqlAmxEnvia;
		return find(hql);
	}
}
