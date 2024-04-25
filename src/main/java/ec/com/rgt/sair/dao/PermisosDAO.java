package ec.com.rgt.sair.dao;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("rawtypes")
public class PermisosDAO  extends DAO{
	
	String hqlRoles = "";
	
	 public List ListaPermisos() {
		 hqlRoles = "from Permisos";
	     return find(hqlRoles);
    }
	 
	 public List ConsultaPermiso(BigDecimal IdPermiso) {
		 hqlRoles = "from Permisos where idPermiso = " + IdPermiso;
	     return find(hqlRoles);
    }
	 
	 public List findPermisos(String hqlPermiso) {
	     return find(hqlPermiso);
    }
	 

}
