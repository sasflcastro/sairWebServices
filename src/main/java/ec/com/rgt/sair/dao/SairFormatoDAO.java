package ec.com.rgt.sair.dao;

import java.util.List;

import ec.com.rgt.sair.hbm.SairFormato;

public class SairFormatoDAO extends DAO{
	
	String hql = "";
	
	@SuppressWarnings("unchecked")
	public List<SairFormato> findFormato(String hqlFormato){
		hql=hqlFormato;
		return find(hql);
	}

}
