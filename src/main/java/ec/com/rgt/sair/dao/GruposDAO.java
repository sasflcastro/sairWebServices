package ec.com.rgt.sair.dao;

import java.util.List;

@SuppressWarnings("rawtypes")
public class GruposDAO extends DAO {

	String hqlGrupos = "";

	public List BuscaGrupos(String hqlGrupos) {
		return find(hqlGrupos);
	}

	/*public List ConsultaGrupo(BigDecimal IdGrupo) {
		hqlGrupos = "from Grupos where idGrupo = " + IdGrupo;
		return find(hqlGrupos);
	}
	
	public List BuscaGrupo(String NombreGrupo, String estado) {
		hqlGrupos = "from Grupos g where g.nombreGrupo like '"
				+ NombreGrupo+ "%' and g.estado='" + estado
				+ "' order by g.nombreGrupo";
		return find(hqlGrupos);
	}*/

}
