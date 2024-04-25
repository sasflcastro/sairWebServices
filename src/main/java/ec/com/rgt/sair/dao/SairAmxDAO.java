package ec.com.rgt.sair.dao;

import java.util.List;

import ec.com.rgt.sair.hbm.SairAmxDocumento;
import ec.com.rgt.sair.hbm.SairAmxUnidMedMacro;
import ec.com.rgt.sair.hbm.SairAmxUnidadMedida;
@SuppressWarnings("unchecked")
public class SairAmxDAO extends DAO{
	String hql = "";
	public List<SairAmxUnidadMedida> findSairAmxUnidadMedida(String hqlSairAmxUnidadMedida){
		hql=hqlSairAmxUnidadMedida;
		return find(hql);
	}
	
	public List<SairAmxDocumento> findSairAmxDocumento(String hqlSairAmxDocumento){
		hql=hqlSairAmxDocumento;
		return find(hql);
	}
	
	public List<SairAmxUnidMedMacro> findSairAmxUnidMedMacro(String hqlSairAmxUnidMed){
		hql=hqlSairAmxUnidMed;
		return find(hql);
	}
}
