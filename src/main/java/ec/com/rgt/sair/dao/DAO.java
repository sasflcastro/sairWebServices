package ec.com.rgt.sair.dao;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.jdbc.Work;

import oracle.jdbc.OracleConnection;
@SuppressWarnings("rawtypes")
public class DAO {
	// private Transaction tx;

	private static Session currentSession() {
		return HibernateUtiles.getSessionFactory().openSession();//getSessionFactory().openSession();
	}

	public static  Session getSession() {
		return currentSession();
	}

	public int Update(Object Objeto, Class type) {

		int estado = 0;
		try {
			Session sess = getSession();
			sess.beginTransaction();
			sess.update(type.cast(Objeto));
			sess.getTransaction().commit();
			sess.close();
			estado = 1;
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return (estado);
	}

	public int saveOrUpdate(Object obj, Class type) {
		int estado = 0;
		Session sess = getSession();
		//System.out.println("Dentro de saveOrUpdate(SOU)");
		try {
			sess.beginTransaction(); 
			sess.saveOrUpdate(type.cast(obj)); 
			sess.getTransaction().commit();
			estado = 1;
		} catch (HibernateException he) {
			System.out.println("SOU-Se genero error en la TRX");
			he.printStackTrace();
			UtilsDAO dao=new UtilsDAO();
			he.getStackTrace();
			dao.savelog("DAO", "DAO", "saveOrUpdate", "HibernateException "+type.getSimpleName(), 49, he.getMessage(), "SEGURIDAD", 3);
		}finally{
			if(sess!=null)
				sess.close();
		}
		return estado;
	}

	public int delete(Object obj, Class type) {
		int estado = 0;
		Session sess = getSession();
		try {
			sess.beginTransaction();
			sess.delete(type.cast(obj));
			sess.getTransaction().commit();
			estado = 1;
		} catch (HibernateException he) {
			UtilsDAO dao=new UtilsDAO();
			dao.savelog("DAO", "DAO", "delete", "HibernateException "+type.getSimpleName(), 66, he.getMessage(), "SEGURIDAD", 3);
		}finally{
			if(sess!=null)
				sess.close();
		}
		return estado;
	}

	public List find(String hql) {
		List lista = null;
		Session sess = getSession();
		UtilsDAO dao=new UtilsDAO();
		try {
			sess.beginTransaction();
			Query query = sess.createQuery(hql);
			lista = query.list();
			sess.getTransaction().commit();
		} catch (QueryException e) {
			// TODO: handle exception
			dao.savelog("DAO", "DAO", "find", "QueryException "+hql, 49, e.getMessage()+ " y el "+hql, "SEGURIDAD", 3);
		} catch (GenericJDBCException e) {
			dao.savelog("DAO", "DAO", "find", "QueryException "+hql, 49, e.getMessage()+ " y el "+hql, "SEGURIDAD", 3);
		}finally{
			if(sess!=null)
				sess.close();
		}
		
		return lista;
	}

	public List findNRow(String hql, int r) {
		List lista = null;
		Session sess = getSession();
		sess.beginTransaction();
		Query query = sess.createQuery(hql).setMaxResults(r);
		lista = query.list();
		sess.getTransaction().commit();
		sess.close();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findNative(String hql) {
		List<Object[]> lista = null;
		Session sess = getSession();
		try {
			sess.beginTransaction();
			Query query = sess.createSQLQuery(hql);
			lista = query.list();
			sess.getTransaction().commit();
		} catch (Exception e) {			
			UtilsDAO dao=new UtilsDAO();
			dao.savelog("DAO", "DAO", "find", "QueryException", 49, e.getMessage()+ " "+hql, "SEGURIDAD", 3);
		}finally{
			if(sess!=null)
				sess.close();
		}
		return lista;
	}
	
	public  ArrayList<String> Sqlquery(String sql) {
		ArrayList<String> f=new ArrayList<String>();
		List<?> result=findNative(sql);
		if(result!=null){
			if (!(result.isEmpty() || result.get(0) instanceof Object[])) {
				@SuppressWarnings("unchecked")
				List<Object> resultList = (List<Object>) result;
				for (Object object : resultList) {
					if(object!=null) {
						if(object instanceof Clob) {
							f.add(getAsString((Clob)object));
						}else
							f.add(object.toString());
					}
						
				}
			}else{
				List<Object[]> resultList = (List<Object[]>) result;
				for (Object[] objects : resultList) {
					if(objects[0]!=null)
					f.add(objects[0].toString());
				}
			}
			return f;
		}else{
			return null;
		}
	}
	
	private static String getAsString(Clob clob) {
	    Reader reader = null;
	    BufferedReader bufferedReader = null;
	    try {
	        reader = clob.getCharacterStream();
	        bufferedReader = new BufferedReader(reader);
	        return IOUtils.toString(bufferedReader);

	    } catch (Exception e) {
	        throw new RuntimeException("Error while reading String from CLOB", e);
	    } finally {
	        IOUtils.closeQuietly(reader);
	        IOUtils.closeQuietly(bufferedReader);
	    }
	}
	
	public int deleteAllTable(String tabla){
		Session sess = getSession();
		sess.beginTransaction();
		int i=sess.createSQLQuery("delete from "+tabla).executeUpdate();
		sess.getTransaction().commit();
		sess.close();
		return i;
	}
	
	public int deleteMasivoSQL(String sql){
		Session sess = getSession();
		sess.beginTransaction();
		int i=sess.createSQLQuery(sql).executeUpdate();
		sess.getTransaction().commit();
		sess.close();
		return i;
	}
}