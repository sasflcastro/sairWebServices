package ec.com.rgt.sair.controller;

import java.util.Iterator;
import java.util.List;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.hbm.SairPantalla;
import ec.com.rgt.sair.hbm.SairPantallaUsuario;

public class OperacionesPantalla extends DAO{
	
	public List<SairPantalla> findPantalla(String hql){
		@SuppressWarnings("unchecked")
		List<SairPantalla> pantallas= find(hql);
		return pantallas;
	}
	
	public List<SairPantallaUsuario> findPantallaUsuario(String hql){
		@SuppressWarnings("unchecked")
		List<SairPantallaUsuario> pantallas= find(hql);
		return pantallas;
	}
	
	public int saveOrdatePantallaUsuario(SairPantallaUsuario pantallaUsuario){
		int r=saveOrUpdate(pantallaUsuario, pantallaUsuario.getClass());
		return r;
	}
	
	public int deletePantallaUsuario(String idUsuario){
		@SuppressWarnings("unchecked")
		List<SairPantallaUsuario> pantallas= find("from SairPantallaUsuario p where p.id.idUsuario='"+idUsuario+"'");
		int r=0;
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = pantallas.iterator(); iterator.hasNext();) {
			SairPantallaUsuario sairPantallaUsuario = (SairPantallaUsuario) iterator.next();
			r=delete(sairPantallaUsuario, sairPantallaUsuario.getClass());
		}
		return r;
	}
	
	public int deletePantallaUsuario(String idUsuario,String idPantalla){
		@SuppressWarnings("unchecked")
		List<SairPantallaUsuario> pantallas= find("from SairPantallaUsuario p where p.id.idUsuario='"+idUsuario+"' and p.id.idPantalla="+idPantalla);
		int r=0;
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = pantallas.iterator(); iterator.hasNext();) {
			SairPantallaUsuario sairPantallaUsuario = (SairPantallaUsuario) iterator.next();
			r=delete(sairPantallaUsuario, sairPantallaUsuario.getClass());
		}
		return r;
	}

}
