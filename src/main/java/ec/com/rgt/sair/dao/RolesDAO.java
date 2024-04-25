package ec.com.rgt.sair.dao;

import java.util.List;

@SuppressWarnings("rawtypes")
public class RolesDAO  extends DAO{
	
	String hqlRoles = "";
	
	public List BuscaRoles(String HqlRoles) {
	     return find(HqlRoles);
   } 
	
	/*public List ListaRoles() {
		 hqlRoles = "from Roles";
	     return find(hqlRoles);
    }
	 
	 public List ConsultaRol(BigDecimal IdRol) {
		 hqlRoles = "from Roles where idRol = " + IdRol;
	     return find(hqlRoles);
    }*/
	 
	 public List findRol(String hqlRol) {
	     return find(hqlRol);
    }
	 
	 

}
