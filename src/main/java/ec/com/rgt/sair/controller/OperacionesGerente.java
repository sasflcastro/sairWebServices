package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.GerenteDAO;
import ec.com.rgt.sair.hbm.SairGerente;

public class OperacionesGerente {
	DAO dao = new DAO();
	GerenteDAO Obj_GerenteDAO = new GerenteDAO();
	
	@SuppressWarnings("unchecked")
	public List<SairGerente> findGerente(String hqlGerente) {
		List<SairGerente> LstGerente = new ArrayList<SairGerente>();
		LstGerente = Obj_GerenteDAO.findGerente(hqlGerente);
		return LstGerente;

	}
	
	
	
	public int SaveorUpdateGerente(SairGerente gerente){
		int i = Obj_GerenteDAO.SaveorUpdateGerente(gerente);
		return i;

	}
	
	
	/**
	 * @param idGerente :es el id gerente
	 * @return retorna una lista de personas que estan bajo el cargo del gerente, jefes y supervisor
	 */
	@SuppressWarnings("unchecked")
	public List<SairGerente> findAllGerentes(BigDecimal idGerente){
		List<SairGerente> gerDefinitivo=new ArrayList<SairGerente>();
		List<SairGerente> gerentes= dao.find("from SairGerente e where e.idJefe="+idGerente+" and e.estado='A' order by e.nombresCompletos");
		for (int i = 0; i < gerentes.size(); i++) {
			SairGerente sairGerente=gerentes.get(i);
			gerDefinitivo.add(sairGerente);
			List<SairGerente> gerentes2= dao.find("from SairGerente e where e.idJefe="+sairGerente.getIdGerente()+" and e.estado='A' order by e.nombresCompletos");
			for (int j = 0; j < gerentes2.size(); j++) {
				SairGerente sairGerente2=gerentes2.get(j);
				gerDefinitivo.add(sairGerente2);
				List<SairGerente> gerentes3= dao.find("from SairGerente e where e.idJefe="+sairGerente2.getIdGerente()+" and e.estado='A' order by e.nombresCompletos");
				for (int k = 0; k < gerentes3.size(); k++) {
					SairGerente sairGerente3=gerentes3.get(k);
					gerDefinitivo.add(sairGerente3);
					List<SairGerente> gerentes4= dao.find("from SairGerente e where e.idJefe="+sairGerente3.getIdGerente()+" and e.estado='A' order by e.nombresCompletos");
					for (int p = 0; p < gerentes4.size(); p++) {
						SairGerente sairGerente4=gerentes4.get(p);
						gerDefinitivo.add(sairGerente4);
					}
				}
			}
		}
		Collections.sort(gerDefinitivo, new Comparator<SairGerente>() {
			public int compare(SairGerente us1, SairGerente us2)
			{
				return (us1.getNombresCompletos()==null?"":us1.getNombresCompletos().toUpperCase()).compareTo(us2.getNombresCompletos()==null?"":us2.getNombresCompletos().toUpperCase());
			}
            });
		return gerDefinitivo;
	}

}
