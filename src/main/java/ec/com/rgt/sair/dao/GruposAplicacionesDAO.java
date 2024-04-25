package ec.com.rgt.sair.dao;

import java.math.BigDecimal;

import java.util.List;
@SuppressWarnings("rawtypes")
public class GruposAplicacionesDAO  extends DAO{
	
	String hqlGruposAplicaciones = "";
	
	 public List ListaGruposAplicaciones() {
		 hqlGruposAplicaciones = "from GruposAplicaciones";
	     return find(hqlGruposAplicaciones);
    }
	 
	 public List ConsultaGruposAplicaciones(BigDecimal IdGrupo, BigDecimal IdAplicacion) {
		 hqlGruposAplicaciones = "from GruposAplicaciones where id.idGrupo = " + IdGrupo + " and id.idAplicacion = " + IdAplicacion;
	     return find(hqlGruposAplicaciones);
    }
	 
	 public List findGruposAplicaciones(String hqlGruposAplicacion) {
		 hqlGruposAplicaciones = hqlGruposAplicacion;
	     return find(hqlGruposAplicaciones);
    }
	 

}
