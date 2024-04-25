package ec.com.rgt.sair.dao;

import java.util.List;

import ec.com.rgt.sair.hbm.SairForumQuestions;
import ec.com.rgt.sair.hbm.SairForumRespuesta;
import ec.com.rgt.sair.hbm.SairForumTag;

public class OperacionesForum extends DAO {
	
	@SuppressWarnings("unchecked")
	public List<SairForumTag> findTag(String hql){
		return find(hql);
	}
	
	@SuppressWarnings("unchecked")
	public List<SairForumQuestions> findQuestion(String hql){
		return find(hql);
	}
	
	@SuppressWarnings("unchecked")
	public List<SairForumRespuesta> findRespuesta(String hql){
		return find(hql);
	}
	
	public int SaveOrDateTag(SairForumTag tag){
		return saveOrUpdate(tag, tag.getClass());
	}
	
	public int SaveOrDateQuestions(SairForumQuestions questions){
		return saveOrUpdate(questions, questions.getClass());
	}
	
	public int SaveOrDateRespuesta(SairForumRespuesta respuesta){
		return saveOrUpdate(respuesta, respuesta.getClass());
	}
}
