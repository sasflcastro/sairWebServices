package ec.com.rgt.sair.dao;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("rawtypes")
public class GruposMenuDAO  extends DAO{
	
	String hqlGruposMenu = "";
	
	 public List ListaGruposMenu() {
		 hqlGruposMenu = "from GruposMenu";
	     return find(hqlGruposMenu);
    }
	 
	 public List ConsultaGruposMenu(BigDecimal IdGrupo, BigDecimal IdMenu) {
		 hqlGruposMenu = "from GruposMenu where id.idGrupo = " + IdGrupo + " and id.idMenu = " + IdMenu;
	     return find(hqlGruposMenu);
    }
	 
	 public List findGruposMenu(String hqlGruposMenues) {
		 hqlGruposMenu = hqlGruposMenues;
	     return find(hqlGruposMenu);
    }
	 
	 

}
