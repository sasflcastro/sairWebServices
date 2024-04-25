package ec.com.rgt.sair.controller;

import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.hbm.SairObsLocalidad;
import ec.com.rgt.sair.hbm.SairObsTipoJustificacion;

public class OperacionesObs extends DAO {
	
	public List<SairObsLocalidad> findLocalidad(String hql){
		@SuppressWarnings("unchecked")
		List<SairObsLocalidad> localida= find(hql);
		return localida;
	}
	
	public List<SairObsTipoJustificacion> findTipoJustificacion(String hql){
		@SuppressWarnings("unchecked")
		List<SairObsTipoJustificacion> justificacions= find(hql);
		return justificacions;
	}
	
}
