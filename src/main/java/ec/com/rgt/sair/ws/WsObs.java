package ec.com.rgt.sair.ws;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.controller.OperacionesObs;
import ec.com.rgt.sair.controller.OperacionesSairObservaciones;
import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.UtilsDAO;
import ec.com.rgt.sair.hbm.Reportexls;
import ec.com.rgt.sair.hbm.SairObsLocalidad;
import ec.com.rgt.sair.hbm.SairObsTipoJustificacion;
import ec.com.rgt.sair.hbm.SairObservaciones;


@WebService()
public class WsObs {
OperacionesObs forum= new OperacionesObs();
Boolean aux=false;
LdapAutenticationWS ws=new LdapAutenticationWS();
	
	@WebMethod(operationName = "findLocalidad")
	public List<SairObsLocalidad> findLocalidad(@WebParam(name="hql")String hql){
		return forum.findLocalidad(hql);
	}
	
	@WebMethod(operationName = "findTipoJustificacion")
	public List<SairObsTipoJustificacion> findTipoJustificacion(@WebParam(name="hql")String hql){
		return forum.findTipoJustificacion(hql);
	}
	
	
	@WebMethod(operationName = "findObservaciones")
    public List<SairObservaciones> findObservaciones(@WebParam(name="hqlObservaciones")String hqlObservaciones,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion) {
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
		OperacionesSairObservaciones ObjSairObservaciones = new OperacionesSairObservaciones();
    	List<SairObservaciones> ListSairObs = new ArrayList<SairObservaciones>();
    	try {
    		ListSairObs = ObjSairObservaciones.FindSairObservaciones(hqlObservaciones);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    	aux=false;
    	return ListSairObs;
    	}else{
        	return null;
        }
	}
	
	
	 private static void close(ResultSet rs, Statement s, Connection c) {
	        try { if (rs != null) rs.close(); } catch (Exception e) {}
	        try { if (s != null) s.close(); } catch (Exception e) {}
	        try { if (c != null) c.close(); } catch (Exception e) {}
	    }
	 

	 
	 @WebMethod(operationName = "findObservaciones2")
	    public List<SairObservaciones> findObservaciones2(@WebParam(name="hqlObservaciones") final String hqlObservaciones,
	   		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion) {
			final UtilsDAO dao=new UtilsDAO();
			dao.savelog("DAO", "DAO", "find", "QueryException "+"LLEGO ", 49, ""+"LLEGO ", "SEGURIDAD", 3);
	    	final List<SairObservaciones> ListSairObs = new ArrayList<SairObservaciones>();
			dao.savelog("DAO", "DAO", "find", "QueryException "+hqlObservaciones, 49," ttt "+hqlObservaciones, "SEGURIDAD", 3);
			Session sess =DAO.getSession();
			//System.out.prinntln(hqlObservaciones+" "+usuario+" "+password+" "+Autenticacion);
	    	sess.doWork(new Work() {
				@Override
				public void execute(Connection con) throws SQLException {
					Statement stmt=null;
					ResultSet rs=null;
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Calendar c = Calendar.getInstance();   // this takes current date
				    c.set(Calendar.DAY_OF_MONTH, 1);
				    String sql = "";
				    if(hqlObservaciones.equals("1")) {
				    	sql = " select * from vw_reporte_brief l "
								+" where l.FECHA_PROGRAMADA  between to_date('"+formatter.format(c.getTime())+"','dd/mm/yyyy') "
								+" and to_date('"+formatter.format(date)+"','dd/mm/yyyy')"
								;
				    }else {
				    	sql = " select * from vw_reporte_brief l "
								//+" where l.FECHA_PROGRAMADA  between to_date('"+formatter.format(c.getTime())+"','dd/mm/yyyy') "
								//+" and to_date('"+formatter.format(date)+"','dd/mm/yyyy')"
								;
				    }
					////System.out.prinntln("sql "+sql);
					try {
						stmt = con.createStatement();
						rs = stmt.executeQuery(sql);
						while(rs.next()){
							SairObservaciones p = new SairObservaciones();
							if(rs.getBytes(1) == null) {
								p.setDat1("");
							}else {
								p.setDat1(new String(rs.getBytes(1), "ISO-8859-1"));
							}
							if(rs.getBytes(2) == null) {
								p.setDat2("");
							}else {
								p.setDat2(new String(rs.getBytes(2), "ISO-8859-1"));
							}
							if(rs.getBytes(3) == null) {
								p.setDat3("");
							}else {
								p.setDat3(new String(rs.getBytes(3), "ISO-8859-1"));
							}
							if(rs.getBytes(4) == null) {
								p.setDat4("");
							}else {
								p.setDat4(new String(rs.getBytes(4), "ISO-8859-1"));
							}
							if(rs.getBytes(5) == null) {
								p.setDat5("");
							}else {
								p.setDat5(new String(rs.getBytes(5), "ISO-8859-1"));
							}
							if(rs.getBytes(6) == null) {
								p.setDat6("");
							}else {
								p.setDat6(new String(rs.getBytes(6), "ISO-8859-1"));
							}
							if(rs.getBytes(7) == null) {
								p.setDat7("");
							}else {
								p.setDat7(new String(rs.getBytes(7), "ISO-8859-1"));
							}
							if(rs.getBytes(8) == null) {
								p.setDat8("");
							}else {
								p.setDat8(new String(rs.getBytes(8), "ISO-8859-1"));
							}
							if(rs.getBytes(9) == null) {
								p.setDat9("");
							}else {
								p.setDat9(new String(rs.getBytes(9), "ISO-8859-1"));
							}
							if(rs.getBytes(10) == null) {
								p.setDat10("");
							}else {
								p.setDat10(new String(rs.getBytes(10), "ISO-8859-1"));
							}
							if(rs.getBytes(11) == null) {
								p.setDat11("");
							}else {
								p.setDat11(new String(rs.getBytes(11), "ISO-8859-1"));
							}
							if(rs.getBytes(12) == null) {
								p.setDat12("");
							}else {
								p.setDat12(new String(rs.getBytes(12), "ISO-8859-1"));
							}
							if(rs.getDate(13) == null) {
								p.setFechaCreacion1(null);
							}else {
								p.setFechaCreacion1(rs.getDate(13));
							}
							if(rs.getBytes(14) == null) {
								p.setDat14("");
							}else {
								p.setDat14(new String(rs.getBytes(14), "ISO-8859-1"));
							}
							if(rs.getDate(15) == null) {
								p.setFechaRespOpe1(null);
							}else {
								p.setFechaRespOpe1(rs.getDate(15));
							}
							if(rs.getBytes(16) == null) {
								p.setDat16("");
							}else {
								p.setDat16(new String(rs.getBytes(16), "ISO-8859-1"));
							}
							ListSairObs.add(p);
							dao.savelog("DAO", "DAO", "ListSairObs", "ListSairObs "+ListSairObs.size(), 49, ""+p.getDat1(), "SEGURIDAD", 3);
						}
						if(ListSairObs.size() ==0){
							SairObservaciones p = new SairObservaciones();
								p.setDat1("");
								p.setDat2("");
								p.setDat3("");
								p.setDat4("");
								p.setDat5("");
								p.setDat6("");
								p.setDat7("");
								p.setDat8("");
								p.setDat9("");
								p.setDat10("");
								p.setDat11("");
								p.setDat12("");
								p.setFechaCreacion1(null);
								p.setDat14("");
								p.setFechaRespOpe1(null);
								p.setDat16("");
							ListSairObs.add(p);
						}
					}catch (SQLException | UnsupportedEncodingException e) {
							dao.savelog("DAO", "DAO", "find", "QUERY ERROR YO "+sql, 49, e.getMessage()+ " y el "+sql, "SEGURIDAD", 3);
					}finally {
						close(rs, stmt, null);
					}
				}
			});

	    	aux=false;
	    	return ListSairObs;
		
		}		
	
		@WebMethod(operationName = "findReporteBrief")
	    public List<SairObservaciones> findReporteBrief(@WebParam(name="hqlObservaciones")String hqlObservaciones,
	    		@WebParam(name="usuario")String usuario,
	    		@WebParam(name="password")String password,
	    		@WebParam(name="Autenticacion")String Autenticacion) {
			/*VALIDACION*/
	    	if(Autenticacion!=null&&usuario!=null&&password!=null)
	    	{
			    if(Autenticacion.equals("AD"))
			    	aux=ws.authenticate(usuario, password);
			    if(Autenticacion.equals("FS"))
			    	aux=ws.authenticateFS(usuario, password);
	    	}
	    	/*VALIDACION*/
	    	if(aux){
			OperacionesSairObservaciones ObjSairObservaciones = new OperacionesSairObservaciones();
	    	List<SairObservaciones> ListSairObs = new ArrayList<SairObservaciones>();
	    	Session sess =DAO.getSession();
			UtilsDAO dao=new UtilsDAO();
	    	sess.doWork(new Work() {
				
				@Override
				public void execute(Connection con) throws SQLException {
					Statement stmt=null;
					ResultSet rs=null;
					String sql = " select * from brief_cumplio_prueba";
					try {
						stmt = con.createStatement();
						rs = stmt.executeQuery(sql);
						while(rs.next()){
							/*dao.savelog("DAO", "DAO", "find", "QueryException "+rs.getString(1), 49, ""+rs.getString(1), "SEGURIDAD", 3);
							dao.savelog("DAO", "DAO", "find", "QueryException "+rs.getString(2), 49, ""+rs.getString(2), "SEGURIDAD", 3);
							dao.savelog("DAO", "DAO", "find", "QueryException "+rs.getString(3), 49, ""+rs.getString(3), "SEGURIDAD", 3);
							dao.savelog("DAO", "DAO", "find", "QueryException "+rs.getString(4), 49, ""+rs.getString(4), "SEGURIDAD", 3);
							dao.savelog("DAO", "DAO", "find", "QueryException "+rs.getString(5), 49, ""+rs.getString(5), "SEGURIDAD", 3);
							*///ListSairObs.add(null);
						}
					}catch (SQLException e) {
					//		dao.savelog("DAO", "DAO", "find", "QUERY ERROR YO "+sql, 49, e.getMessage()+ " y el "+sql, "SEGURIDAD", 3);
					}finally {
						close(rs, stmt, null);
					}
				}
			});

			dao.savelog("DAO", "DAO", "find", "QueryException "+hqlObservaciones, 49," ttt "+hqlObservaciones, "SEGURIDAD", 3);
			ListSairObs = ObjSairObservaciones.FindSairObservaciones(hqlObservaciones);
	    	aux=false;
	    	return ListSairObs;
	    	}else{
	        	return null;
	        }
		}




		 
		 @WebMethod(operationName = "saveorupdateRut_Polit")
		    public List<SairObservaciones> saveorupdateRut_Polit(
		    		@WebParam(name="hqlObservaciones") final String cod_poli,
		    		@WebParam(name="usuario")final String cod_rut,
		    		@WebParam(name="password")final String password,
		    		@WebParam(name="Autenticacion")final String Autenticacion) {
				final UtilsDAO dao=new UtilsDAO();
				final List<SairObservaciones> ListSairObs = new ArrayList<SairObservaciones>();
				Session sess =DAO.getSession();
				sess.doWork(new Work() {
					@Override
					public void execute(Connection con) throws SQLException {
						Statement stmt=null;
						ResultSet rs=null;
					    String sql = "";
					    if(password.equals("2")) {
				    		sql = " delete from sair_politicas_rutinas d where d.id_rutina = '"+cod_rut+"'";
				    	}else {
				    		sql = "insert into sair_politicas_rutinas values(null,'"+cod_poli+"','"+cod_rut+"','A')"; 
					    }
						try {
							stmt = con.createStatement();
							rs = stmt.executeQuery(sql);
							con.commit();
							System.out.println(sql);
						}catch (SQLException e) {
								dao.savelog("DAO", "DAO", "find", "QUERY ERROR YO "+sql, 49, e.getMessage()+ " y el "+sql, "SEGURIDAD", 3);
						}finally {
							close(rs, stmt, null);
						}
					}
				});
		    	aux=false;
		    	return ListSairObs;
			
			}		
		 

		 @WebMethod(operationName = "saveorupdateRut_Sox")
		    public List<SairObservaciones> saveorupdateRut_Sox(
		    		@WebParam(name="hqlObservaciones") final String cod_sox,
		    		@WebParam(name="usuario")final String cod_rut,
		    		@WebParam(name="password")final String password,
		    		@WebParam(name="Autenticacion")final String Autenticacion) {
				final UtilsDAO dao=new UtilsDAO();
				final List<SairObservaciones> ListSairObs = new ArrayList<SairObservaciones>();
				Session sess =DAO.getSession();
				sess.doWork(new Work() {
					@Override
					public void execute(Connection con) throws SQLException {
						Statement stmt=null;
						ResultSet rs=null;
					    String sql = "";
					    if(password.equals("2")) {
				    		sql = " delete from sair_sox_rutinas d where d.id_rutina = '"+cod_rut+"'";
				    	}else {
				    		sql = "insert into sair_sox_rutinas values(null,'"+cod_sox+"','"+cod_rut+"',sysdate,'A')"; 
					    }
						try {
							stmt = con.createStatement();
							rs = stmt.executeQuery(sql);
							con.commit();
						    System.out.println(sql);
						}catch (SQLException e) {
								dao.savelog("DAO", "DAO", "find", "QUERY ERROR YO "+sql, 49, e.getMessage()+ " y el "+sql, "SEGURIDAD", 3);
						}finally {
							close(rs, stmt, null);
						}
					}
				});
		    	aux=false;
		    	return ListSairObs;
			
			}		
		 
		 
		 @WebMethod(operationName = "saveorupdateRec_Polit")
		    public List<SairObservaciones> saveorupdateRec_Polit(
		    		@WebParam(name="hqlObservaciones") final String cod_poli,
		    		@WebParam(name="usuario")final String cod_rec,
		    		@WebParam(name="password")final String password,
		    		@WebParam(name="Autenticacion")final String Autenticacion) {
				final UtilsDAO dao=new UtilsDAO();
				final List<SairObservaciones> ListSairObs = new ArrayList<SairObservaciones>();
				Session sess =DAO.getSession();
		    	sess.doWork(new Work() {
					@Override
					public void execute(Connection con) throws SQLException {
						Statement stmt=null;
						ResultSet rs=null;
					    String sql = "";
					    if(password.equals("2")) {
				    		sql = " delete from sair_politicas_recomendacion d where d.id_recomendacion = '"+cod_rec+"'";
				    	}else {
				    		sql = "insert into sair_politicas_recomendacion values(null,'"+cod_poli+"','"+cod_rec+"',sysdate,'A')"; 
				    	}
						try {
							stmt = con.createStatement();
							rs = stmt.executeQuery(sql);
							con.commit();
						}catch (SQLException e) {
								dao.savelog("DAO", "DAO", "find", "QUERY ERROR YO "+sql, 49, e.getMessage()+ " y el "+sql, "SEGURIDAD", 3);
						}finally {
							close(rs, stmt, null);
						}
					}
				});
		    	aux=false;
		    	return ListSairObs;
			
			}		
		    

		 @WebMethod(operationName = "saveorupdateRec_Sox")
		    public List<SairObservaciones> saveorupdateRec_Sox(
		    		@WebParam(name="hqlObservaciones") final String cod_Sox,
		    		@WebParam(name="usuario")final String cod_rec,
		    		@WebParam(name="password")final String password,
		    		@WebParam(name="Autenticacion")final String Autenticacion) {
				final UtilsDAO dao=new UtilsDAO();
				final List<SairObservaciones> ListSairObs = new ArrayList<SairObservaciones>();
				Session sess =DAO.getSession();
				System.out.println("Metodo2 "+cod_Sox+" y "+cod_rec+" y "+password+" y "+Autenticacion);
		    	sess.doWork(new Work() {
					@Override
					public void execute(Connection con) throws SQLException {
						Statement stmt=null;
						ResultSet rs=null;
					    String sql = "";
					    if(password.equals("2")) {
				    		sql = " delete from sair_sox_recomendacion d where d.id_recomendacion = '"+cod_rec+"'";
				    	}else {
				    		sql = "insert into sair_sox_recomendacion values(null,'"+cod_Sox+"','"+cod_rec+"',sysdate,'A')"; 
				    	}
						try {
							stmt = con.createStatement();
							rs = stmt.executeQuery(sql);
							con.commit();
							System.out.println("sql "+sql);
						}catch (SQLException e) {
								dao.savelog("DAO", "DAO", "find", "QUERY ERROR YO "+sql, 49, e.getMessage()+ " y el "+sql, "SEGURIDAD", 3);
						}finally {
							close(rs, stmt, null);
						}
					}
				});
		    	aux=false;
		    	return ListSairObs;
			
			}		
		    

		 
		 @WebMethod(operationName = "saveorupdateSox")
		    public List<SairObservaciones> saveorupdateSox(
		    		@WebParam(name="hqlObservaciones") final String id,
		    		@WebParam(name="usuario")final String nombre,
		    		@WebParam(name="password")final String descr,
		    		@WebParam(name="Autenticacion")final String comen) {
				final UtilsDAO dao=new UtilsDAO();
				final List<SairObservaciones> ListSairObs = new ArrayList<SairObservaciones>();
				Session sess =DAO.getSession();
		    	sess.doWork(new Work() {
					@Override
					public void execute(Connection con) throws SQLException {
						Statement stmt=null;
						ResultSet rs=null;
					    String sql = "";
					    
					    if(id.equals("G")) {
					    	sql = "insert into sair_normas_sox values(null,'"+nombre+"','"+descr+"','"+comen+"','A')"; 
					 	}else {

					 	if(id.split("---")[1].equals("M")) {
				    		sql = "update sair_normas_sox s "
					    			+ "set "
					    			//+" s.sox_nombre = '"+nombre+"' ,"
					    			+"  s.sox_descrip = '"+descr+"' "
							    	+" , s.sox_comentario = '"+comen+"' "
									+" , s.estado = 'A' "
					    			+"	where s.id_normas_sox = '"+id.split("---")[0]+"' " ;
						 }else {
					    		sql = "update sair_normas_sox s "
						    			+ "set s.estado = 'I' "
						    			+"	where s.id_normas_sox = '"+id.split("---")[0]+"' " ;
						    }
					    }
						try {
							stmt = con.createStatement();
							rs = stmt.executeQuery(sql);
							con.commit();
							System.out.println("sql "+sql);
						}catch (SQLException e) {
								dao.savelog("DAO", "DAO", "find", "QUERY ERROR YO "+sql, 49, e.getMessage()+ " y el "+sql, "SEGURIDAD", 3);
						}finally {
							close(rs, stmt, null);
						}
					}
				});
		    	aux=false;
		    	return ListSairObs;
			
			} 

}
