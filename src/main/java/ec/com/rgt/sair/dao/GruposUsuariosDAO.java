package ec.com.rgt.sair.dao;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("rawtypes")
public class GruposUsuariosDAO  extends DAO{
	
	String hqlGruposUsuarios = "";
	
	 public List ListaGruposUsuarios() {
		 hqlGruposUsuarios = "from GruposUsuarios";
	     return find(hqlGruposUsuarios);
    }
	 
	 public List ConsultaGruposUsuarios(BigDecimal IdGrupo, String IdUsuario) {
		 hqlGruposUsuarios = "from GruposUsuarios where id.idGrupo = " + IdGrupo + " and id.idUsuario = '" + IdUsuario+"'";
	     return find(hqlGruposUsuarios);
    }
	 	 

	 public List findGruposUsuarios(String hqlGruposUsuario) {
		 hqlGruposUsuarios = hqlGruposUsuario;
	     return find(hqlGruposUsuarios);
    }
}
