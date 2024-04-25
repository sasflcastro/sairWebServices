package ec.com.rgt.sair.dao;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("rawtypes")
public class GruposRolesDAO  extends DAO{
	
	String hqlGruposRoles = "";
	
	 public List ListaGruposRoles() {
		 hqlGruposRoles = "from GruposRoles where estado = 'A'";
	     return find(hqlGruposRoles);
    }
	 
	 public List ConsultaGruposRoles(BigDecimal IdGrupo, BigDecimal IdRol) {
		 hqlGruposRoles = "from GruposRoles where id.idGrupo = " + IdGrupo + " and id.idRol = " + IdRol ;
	     return find(hqlGruposRoles);
    }
	 
	 public List ConsultaGruposRoles(String hqlGruposRoles) {
	     return find(hqlGruposRoles);
    }
	 
	 public List ConsultaGruposRoles1(BigDecimal IdGrupo, BigDecimal IdRol) {
		 hqlGruposRoles = "from GruposRoles where id.idGrupo = " + IdGrupo + " and id.idRol = " + IdRol + " and estado = 'A'";
	     return find(hqlGruposRoles);
    }
	 	 

}
