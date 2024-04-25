package ec.com.rgt.sair.dao;

import java.util.List;

import ec.com.rgt.sair.hbm.SairDocAjusteCorreccion;
import ec.com.rgt.sair.hbm.SairDocAnexoDocumento;
import ec.com.rgt.sair.hbm.SairDocArnp;
import ec.com.rgt.sair.hbm.SairDocConclusionDocumento;
import ec.com.rgt.sair.hbm.SairDocDestinatario;
import ec.com.rgt.sair.hbm.SairDocDiscusionInf;
import ec.com.rgt.sair.hbm.SairDocEscalamiento;
import ec.com.rgt.sair.hbm.SairDocEscalamientoDocument;
import ec.com.rgt.sair.hbm.SairDocInformes;
import ec.com.rgt.sair.hbm.SairDocMemorando;
import ec.com.rgt.sair.hbm.SairDocPasos;
import ec.com.rgt.sair.hbm.SairDocPlantilla;
import ec.com.rgt.sair.hbm.SairDocPlantillaDocumento;
import ec.com.rgt.sair.hbm.SairDocRequerimientoCorrecc;
import ec.com.rgt.sair.hbm.SairDocReservacionCodigo;
import ec.com.rgt.sair.hbm.SairDocRiesgoDocumento;
import ec.com.rgt.sair.hbm.SairDocRiesgoInforme;
import ec.com.rgt.sair.hbm.SairDocRiesgoRc;
import ec.com.rgt.sair.hbm.SairDocTipoDocumento;
import ec.com.rgt.sair.hbm.SairDocTipoEvento;
import ec.com.rgt.sair.hbm.SairDocTipoHallazgo;
import ec.com.rgt.sair.hbm.SairDocTipoInforme;
import ec.com.rgt.sair.hbm.SairEstadoComplementario;
import ec.com.rgt.sair.hbm.SairEstadoReco;
import ec.com.rgt.sair.hbm.SairEstadosPrincipal;
import ec.com.rgt.sair.hbm.SairRecConclusionReco;

@SuppressWarnings("unchecked")
public class SairDocumentosDAO extends DAO{
	
	String hql = "";
	
	
	public List<SairDocInformes> findInformes(String hqlInforme){
		hql=hqlInforme;
		return find(hql);
	}
	
	public List<SairDocMemorando> findMemorandos(String hqlMemorando){
		hql=hqlMemorando;
		return find(hql);
	}
	
	public List<SairDocArnp> findArnps(String hqlArnp){
		hql=hqlArnp;
		return find(hql);
	}
	
	public List<SairDocRequerimientoCorrecc> findRCs(String hqlRC){
		hql=hqlRC;
		return find(hql);
	}
	
	public List<SairDocRiesgoRc> findRiesRC(String hqlRsgRC){
		hql=hqlRsgRC;
		return find(hql);
	}
	
	public List<SairDocReservacionCodigo> findReservaCod(String hqlReservacod){
		hql=hqlReservacod;
		return find(hql);
	}
	
	public List<SairDocTipoInforme> findTipoInf(String hqlTpInfo){
		hql=hqlTpInfo;
		return find(hql);
	}
	
	public List<SairEstadosPrincipal> findEstadosP(String hqlEstP){
		hql=hqlEstP;
		return find(hql);
	}
	
	
	public List<SairDocRiesgoInforme> findRiesgInf(String hqlRsgInf){
		hql=hqlRsgInf;
		return find(hql);
	}
	
	public List<SairDocDestinatario> findDestinatario(String hqlDesti){
		hql=hqlDesti;
		return find(hql);
	}
	
	public List<SairDocTipoDocumento> findTipoDoc(String hqlTipoDoc){
		hql=hqlTipoDoc;
		return find(hql);
	}
	
	public List<SairDocRiesgoDocumento> findRiesgoDoc(String hqlRiesgoDoc){
		hql=hqlRiesgoDoc;
		return find(hql);
	}
	
	public List<SairDocPlantilla> findPlantilla(String hqlPlantilla){
		hql=hqlPlantilla;
		return find(hql);
	}
	
	public List<SairDocConclusionDocumento> findConclusion(String hqlConclusion){
		hql=hqlConclusion;
		return find(hql);
	}
	
	public List<SairDocAnexoDocumento> findAnexoDocumentos(String hqlAnexoDoc){
		hql=hqlAnexoDoc;
		return find(hql);
	}
	
	public List<SairDocPlantillaDocumento> findPlantillaDoc(String hqlPlantillaDoc){
		hql=hqlPlantillaDoc;
		return find(hql);
	}
	
	public List<SairEstadoComplementario> findSairEstadoComplementariol(String hqlSairEstadoComplementario){
		hql=hqlSairEstadoComplementario;
		return find(hql);
	}
	
	public List<SairEstadoReco> findSairEstadoReco(String hqlSairEstadoReco){
		hql=hqlSairEstadoReco;
		return find(hql);
	}
	
	public List<SairDocDiscusionInf> findSairDocDiscusionInf(String hqlSairDocDiscusionInf){
		hql=hqlSairDocDiscusionInf;
		return find(hql);
	}
	
	public List<SairDocPasos> findSairDocPasos(String hqlSairDocPasos){
		hql=hqlSairDocPasos;
		return find(hql);
	}
	
	public List<SairDocReservacionCodigo> findSairDocReservacionCodigo(String hqlReservacion){
		hql=hqlReservacion;
		return find(hql);
	}
	
	public List<SairDocDestinatario> findSairDocDestinatario(String hqlDestinatario){
		hql=hqlDestinatario;
		return find(hql);
	}
	
	public List<SairDocEscalamientoDocument> findSairDocEscalamientoDoc(String hqlEscalamiento){
		hql=hqlEscalamiento;
		return find(hql);
	}
	
	public List<SairDocEscalamiento> findSairDocEscalamiento(String hqlEscalamiento){
		hql=hqlEscalamiento;
		return find(hql);
	}
	
	public List<SairRecConclusionReco> findSairRecConclusionReco(String hqlRecCon){
		hql=hqlRecCon;
		return find(hql);
	}
	
	public List<SairDocAjusteCorreccion> findSairAjuste(String hql){
		return find(hql);
	}
	
	public List<SairDocTipoHallazgo> findTipoHallazgo(String hqlDestinatario){
		hql=hqlDestinatario;
		return find(hql);
	}
	
	public List<SairDocTipoEvento> findTipoEvento(String hqlDestinatario){
		hql=hqlDestinatario;
		return find(hql);
	}
}
