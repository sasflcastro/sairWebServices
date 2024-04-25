package ec.com.rgt.sair.dao;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("rawtypes")
public class RolesPermisosDAO extends DAO{
	
	String hqlRolesPermisos = "";
	
	 public List ListaRolesPermisos() {
		 hqlRolesPermisos = "from RolesPermisos";
	     return find(hqlRolesPermisos);
   }
	 
	 public List ConsultaRolesPermisos(BigDecimal IdRol, BigDecimal IdPermiso ) {
		 hqlRolesPermisos = "from RolesPermisos where id.idRol = " + IdRol +" and id.IdPermiso = "+IdPermiso;
	     return find(hqlRolesPermisos);
   }
	 
	 public List findRolesPermisos(String hqlRolesPermisos) {
	     return find(hqlRolesPermisos);
   }

}
