package ec.com.rgt.sair.dao;

import java.math.BigDecimal;

import java.util.List;
@SuppressWarnings("rawtypes")
public class SairParametrosDAO  extends DAO{
	
	String hqlParametros = "";
	
	 
	public List ListaParametros() {
		 hqlParametros = "from SairParametros";
	     return find(hqlParametros);
    }
	 
	 public List ConsultaParametros(BigDecimal IdParametro) {
		 hqlParametros = "from SairParametros where idParametro = " + IdParametro ;
	     return find(hqlParametros);
    }
	 
	 public List ConsultaPadre(BigDecimal IdPadre) {
		 hqlParametros = "from SairParametros where idPadre = " + IdPadre ;
	     return find(hqlParametros);
    }
	 
	 public List findParametros(String HqlParametros) {
		 hqlParametros = HqlParametros;
	     return find(hqlParametros);
    }

}
