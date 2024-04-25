package ec.com.rgt.sair.dao;

import java.util.List;

import ec.com.rgt.sair.controller.*;
import ec.com.rgt.sair.hbm.SairGerente;

@SuppressWarnings("rawtypes")
public class GerenteDAO  extends DAO{
		
		String hqlGerente = "";
		BlowfishCipher Obj_Encripta = new BlowfishCipher();
		String Ls_ClaveEncriptada;
		
		 public List ListaGerente() {
			 hqlGerente = "from Usuarios";
		     return find(hqlGerente);
	    }
		 
		 public List ConsultaGerente(String IdGerente) {
			 hqlGerente = "from Usuarios where idUsuario = '" + IdGerente + "'";
		     return find(hqlGerente);
	    }
		 
		 public List findGerente(String hqlGerente) {
		     return find(hqlGerente);
	    }
		 
		public int SaveorUpdateGerente(SairGerente gerente){
			return saveOrUpdate(gerente, gerente.getClass());
		}

	}

