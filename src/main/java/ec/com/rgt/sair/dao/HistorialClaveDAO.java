package ec.com.rgt.sair.dao;

import java.util.List;
import ec.com.rgt.sair.controller.BlowfishCipher;

@SuppressWarnings("rawtypes")
public class HistorialClaveDAO extends DAO{
	
	String hqlHistorial = "";
	BlowfishCipher cifrado = new BlowfishCipher();
	
	 
	public List ListaHistorial() {
		 hqlHistorial = "from HistoricoClaves";
	     return find(hqlHistorial);
   }
	 
	 public List ConsultaHistorial(String idUsuario) {
		 //String clave_cifrada=cifrado.encripta(Clave);
		 hqlHistorial = "from HistoricoClaves hc where hc.idUsuario='"+idUsuario+"' order by hc.idHistorico desc";
	     return find(hqlHistorial);
   }
	 
	 public List findHistorial(String HqlHistorial) {
		 hqlHistorial = HqlHistorial;
	     return find(hqlHistorial);
   }

}
