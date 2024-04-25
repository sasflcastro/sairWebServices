package ec.com.rgt.sair.dao;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("rawtypes")
public class SairAreaDAO  extends DAO{
	
	String hqlAreas = "";
	
	 public List ListaAreas() {
		 hqlAreas = "from SairArea";
	     return find(hqlAreas);
   }
	 
	 public List ConsultaArea(BigDecimal IdArea) {
		 hqlAreas = "from SairArea where idArea = " + IdArea ;
	     return find(hqlAreas);
   }
	 
	 public List findAreas(String hqlArea) {
		 hqlAreas = hqlArea;
	     return find(hqlAreas);
   }
	 public List ConsultaAreaAdam(BigDecimal IdAreaAdam) {
		 hqlAreas = "from SairAreasAdam where estado = 'A' and idDepartamento = " + IdAreaAdam ;
	     return find(hqlAreas);
   }

	 public List findAreasAdam(String hqlAreaAdam) {
		 hqlAreas = hqlAreaAdam;
	     return find(hqlAreas);
   }
	 
	 public List findSubAreas(String hqlSubArea) {
		 hqlAreas = hqlSubArea;
	     return find(hqlAreas);
   }
}
