package ec.com.rgt.sair.dao;

import java.util.List;

import ec.com.rgt.sair.hbm.SairDocConRiesgo;
import ec.com.rgt.sair.hbm.SairDocImpacto;
import ec.com.rgt.sair.hbm.SairDocPrioridad;
import ec.com.rgt.sair.hbm.SairParCheckList;
import ec.com.rgt.sair.hbm.SairParCheckListCabecera;
import ec.com.rgt.sair.hbm.SairParDetalleCheckList;

@SuppressWarnings("unchecked")
public class SairParCheckListDAO  extends DAO{
	
	String hqlCheckList = "";
	
	 
	
	public List<SairParCheckList> findCheckList(String HqlCheckList) {
		 hqlCheckList = HqlCheckList;
	     return find(hqlCheckList);
    }
	 
	 /***********************************************/
	 
	 public List<SairParCheckListCabecera> findCabCheckList(String HqlCabCheckList) {
		 hqlCheckList = HqlCabCheckList;
	     return find(hqlCheckList);
    }
	 
	/***********************************************/
	 
	 
	 public List<SairParDetalleCheckList> findDetCheckList(String HqlDetCheckList) {
		 hqlCheckList = HqlDetCheckList;
	     return find(hqlCheckList);
    }
	 
	public List<SairDocPrioridad> findPrioridad(String HqlPrioridad) {
	     return find(HqlPrioridad);
    }
	 
	public List<SairDocImpacto> findImpacto(String HqlImpacto) {
	     return find(HqlImpacto);
    }
	
	public List<SairDocConRiesgo> findConclusionRiesgo(String HqlConRiesgo) {
	     return find(HqlConRiesgo);
    }

}


