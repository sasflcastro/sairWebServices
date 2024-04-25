package ec.com.rgt.sair.dao;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("rawtypes")
public class MenuesDAO  extends DAO{
	
	String hqlMenues = "";
	
	 public List ListaMenues() {
		 hqlMenues = "from Menues";
	     return find(hqlMenues);
    }
	 
	 public List ConsultaMenues(BigDecimal IdMenu) {
		 hqlMenues = "from Menues where idMenu = " + IdMenu;
	     return find(hqlMenues);
    }
	 
	 public List findMenues(String hqlMenu) {
	     return find(hqlMenu);
    }
	 
	 

}
