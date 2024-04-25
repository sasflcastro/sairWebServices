package ec.com.rgt.sair.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import ec.com.rgt.sair.hbm.SairActaProyecto;
import oracle.jdbc.OracleTypes;


public class Conexion {
	
	public static boolean CallProcessRecMono() {
		Session sess = DAO.getSession();
		sess.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				CallableStatement statement = null;
				try{
					statement = connection.prepareCall("{call PR_REP_SAIR_REP_MONO_REC}");
					statement.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					close(null, statement, null);
				}
			}
		});
		sess.close();
		return true;
	}
	
	public static  boolean CallProcess(){
		
		Session sess =DAO.getSession();
		sess.doWork(new Work() {
				
			@Override
			public void execute(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				CallableStatement statement = null;
				try{
					statement = connection.prepareCall("{ call reset_sequence(?, ?, ?)}");
					statement.setString(1, "S_SAIR_CODIGO_RESERVDO");
					statement.setInt(2, 1);
					statement.setInt(3, 0);
					statement.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					close(null, statement, null);
				}
			}
		});
		sess.close();
		return true;
	}
	

	public static boolean CallProcessResetSecUsuariosAD(){
		Session sess =DAO.getSession();
		sess.doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				CallableStatement statement = null;
				try {
					statement = connection.prepareCall("{ call reset_sequence(?, ?, ?)}");
					statement.setString(1, "S_USUARIOS_AD");
					statement.setInt(2, 1);
					statement.setInt(3, 0);
					statement.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					close(null, statement, null);
				}
			}
		});
		sess.close();
		return true;
		
	}
	

	/*public  ArrayList<String> Sqlquery(String sql) {
		ArrayList<String> f=new ArrayList<String>();
		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		try {
			con = DAO.getSession().connection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				f.add(rs.getString(1));
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			UtilsDAO dao=new UtilsDAO();
			dao.savelog("CONEXION", "CONEXION", "Sqlquery", "SQLException "+sql, 80, e.getMessage(), "SEGURIDAD", 3);
		}finally {
			close(rs, stmt, con);
		}
		return f;
		
	}*/
	
	
	public  String llenaTblAmxEnvio(final String fecha, final int numCap) {
		
		Session sess =DAO.getSession();
		sess.doWork(new Work() {
			
			@Override
			public void execute(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				Statement stmt=null;
				ResultSet rs=null;
				try {
					stmt = con.createStatement();
					stmt.executeQuery("begin clp_carga_procedimiento('"+fecha+"',"+numCap+"); commit; end;");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					close(rs, stmt, null);
				}
			}
		});
		sess.close();
		return "Proceso exitoso";
	}
	
	
	public  String llenaTblAmx() {
		Session sess =DAO.getSession();
		sess.doWork(new Work() {
			
			@Override
			public void execute(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				Statement stmt=null;
				ResultSet rs=null;
				try {
					stmt = con.createStatement();
					stmt.executeQuery("begin inserta_tbl_proce_amx; end;");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}finally {
					close(rs, stmt, null);
				}
			}
		});
		sess.close();
		return "Proceso exitoso";
	}

	
	public  String ejecutarRepContravencion(final String feca, final String fecb) {
		Session sess =DAO.getSession();
		sess.doWork(new Work() {
			
			@Override
			public void execute(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				Statement stmt=null;
				ResultSet rs=null;
				try {
					stmt = con.createStatement();
					stmt.executeQuery("begin mr_mensual_contra_paso2_fecha('"+feca+"','"+fecb+"'); commit; end;");
					//System.out.println(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					close(rs, stmt, null);
				}
			}
		});
		sess.close();
		return "Proceso exitoso";
	}
	
	
	public  String PresentaAmx() {
		final List<String> list=new ArrayList<>();
		Session sess =DAO.getSession();
		sess.doWork(new Work() {
			
			@Override
			public void execute(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				Statement stmt=null;
				ResultSet rs=null;
				String mensaje="Tipo\tUsuario\tNumCaptura\tNumIncidencia\tNumAC\tOperadora\tFechaProcedimiento\tProcedimiento\tProceso\tSubproceso\tUnidadMuestra\tMuestraDefinida\tMuestraRevisada\tInconsistencias\tRangoMuestra\tOtro\tFechaInicio\tFechaFin\tIncidencia\tProblematica\tCausa\tTipoImpacto\tImpactoNegativo\tAccionCorrectiva\tGerencia\tGerente\tDireccion\tDirector\tFechaSolucion\tEstatus\tImpactoPositivoAC\t\n";
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery("select case when rpad(t.orden,(select max(length(at1.orden)) from reporte_amx_txt at1)+5,' ') is null then rpad(' ',(select max(length(at1.orden)) from reporte_amx_txt at1)+5,' ') else rpad(t.orden,(select max(length(at1.orden)) from reporte_amx_txt at1)+5,' ') end,\t\n"+
											"case when rpad(t.TIPO,(select max(length(at2.TIPO)) from reporte_amx_txt at2)+5,' ') is null then rpad(' ',(select max(length(at2.TIPO)) from reporte_amx_txt at2)+5,' ') else rpad(t.TIPO,(select max(length(at2.TIPO)) from reporte_amx_txt at2)+5,' ') end,\t\n" + 
											"case when rpad(t.USUARIO,(select max(length(at3.USUARIO)) from reporte_amx_txt at3)+5,' ') is null then rpad(' ',(select max(length(at3.USUARIO)) from reporte_amx_txt at3)+5,' ') else rpad(t.USUARIO,(select max(length(at3.USUARIO)) from reporte_amx_txt at3)+5,' ') end,\t\n" + 
											"case when rpad(t.NUMCAPTURA,(select max(length(at4.NUMCAPTURA)) from reporte_amx_txt at4)+5,' ') is null then rpad(' ',(select max(length(at4.NUMCAPTURA)) from reporte_amx_txt at4)+5,' ') else rpad(t.NUMCAPTURA,(select max(length(at4.NUMCAPTURA)) from reporte_amx_txt at4)+5,' ') end,\t\n"+ 
											"case when rpad(t.NUMINCIDENCIA,(select max(length(at5.NUMINCIDENCIA)) from reporte_amx_txt at5)+5,' ') is null then rpad(' ',(select max(length(at5.NUMINCIDENCIA)) from reporte_amx_txt at5)+5,' ') else rpad(t.NUMINCIDENCIA,(select max(length(at5.NUMINCIDENCIA)) from reporte_amx_txt at5)+5,' ') end,\t\n"+ 
											"case when rpad(t.NUMAC,(select max(length(at6.NUMAC)) from reporte_amx_txt at6)+5,' ') is null then rpad(' ',(select max(length(at6.NUMAC)) from reporte_amx_txt at6)+5,' ') else rpad(t.NUMAC,(select max(length(at6.NUMAC)) from reporte_amx_txt at6)+5,' ') end,\t\n"+ 
											"case when rpad(t.OPERADORA,(select max(length(at7.OPERADORA)) from reporte_amx_txt at7)+5,' ') is null then rpad(' ',(select max(length(at7.OPERADORA)) from reporte_amx_txt at7)+5,' ') else rpad(t.OPERADORA,(select max(length(at7.OPERADORA)) from reporte_amx_txt at7)+5,' ') end,\t\n"+ 
											"case when rpad(to_char(t.FECHAPROCEDIMIENTO,'dd/MM/YYYY'),(select max(length(to_char(at8.FECHAPROCEDIMIENTO,'dd/MM/YYYY'))) from reporte_amx_txt at8)+5,' ') is null then rpad(' ',(select max(length(to_char(at8.FECHAPROCEDIMIENTO,'dd/MM/YYYY'))) from reporte_amx_txt at8)+5,' ') else rpad(to_char(t.FECHAPROCEDIMIENTO,'dd/MM/YYYY'),(select max(length(to_char(at8.FECHAPROCEDIMIENTO,'dd/MM/YYYY'))) from reporte_amx_txt at8)+5,' ') end,\t\n"+ 
											"case when rpad(t.PROCEDIMIENTO,(select max(length(at9.PROCEDIMIENTO)) from reporte_amx_txt at9)+5,' ') is null then rpad(' ',(select max(length(at9.PROCEDIMIENTO)) from reporte_amx_txt at9)+5,' ') else rpad(t.PROCEDIMIENTO,(select max(length(at9.PROCEDIMIENTO)) from reporte_amx_txt at9)+5,' ') end,\t\n"+ 
											"case when rpad(t.PROCESO,(select max(length(at10.PROCESO)) from reporte_amx_txt at10)+5,' ') is null then rpad('',(select max(length(at10.PROCESO)) from reporte_amx_txt at10)+5,' ') else rpad(t.PROCESO,(select max(length(at10.PROCESO)) from reporte_amx_txt at10)+5,' ') end,\t\n" + 
											"case when rpad(t.SUBPROCESO,(select max(length(at11.SUBPROCESO)) from reporte_amx_txt at11)+5,' ') is null then rpad(' ',(select max(length(at11.SUBPROCESO)) from reporte_amx_txt at11)+5,' ') else rpad(t.SUBPROCESO,(select max(length(at11.SUBPROCESO)) from reporte_amx_txt at11)+5,' ') end,\t\n" + 
											"case when rpad(t.UNIDADMUESTRA,(select max(length(at12.UNIDADMUESTRA)) from reporte_amx_txt at12)+5,' ') is null then rpad(' ',(select max(length(at12.UNIDADMUESTRA)) from reporte_amx_txt at12)+5,' ') else rpad(t.UNIDADMUESTRA,(select max(length(at12.UNIDADMUESTRA)) from reporte_amx_txt at12)+5,' ') end,\t\n"+ 
											"case when rpad(t.muestradefinida,(select max(length(at13.muestradefinida)) from reporte_amx_txt at13)+5,' ') is null then rpad(' ',(select max(length(at13.muestradefinida)) from reporte_amx_txt at13)+5,' ') else rpad(t.muestradefinida,(select max(length(at13.muestradefinida)) from reporte_amx_txt at13)+5,' ') end,\t\n"+ 
											"case when rpad(t.muestrarevisada,(select max(length(at14.muestrarevisada)) from reporte_amx_txt at14)+5,' ') is null then rpad(' ',(select max(length(at14.muestrarevisada)) from reporte_amx_txt at14)+5,' ') else rpad(t.muestrarevisada,(select max(length(at14.muestrarevisada)) from reporte_amx_txt at14)+5,' ') end,\t\n"+ 
											"case when rpad(t.inconsistencias,(select max(length(at15.inconsistencias)) from reporte_amx_txt at15)+5,' ') is null then rpad(' ',(select max(length(at15.inconsistencias)) from reporte_amx_txt at15)+5,' ') else rpad(t.inconsistencias,(select max(length(at15.inconsistencias)) from reporte_amx_txt at15)+5,' ') end,\t\n"+ 
											"case when rpad(t.RANGOMUESTRA,(select max(length(at16.RANGOMUESTRA)) from reporte_amx_txt at16)+5,' ') is null then rpad(' ',(select max(length(at16.RANGOMUESTRA)) from reporte_amx_txt at16)+5,' ') else rpad(t.RANGOMUESTRA,(select max(length(at16.RANGOMUESTRA)) from reporte_amx_txt at16)+5,' ') end,\t\n"+ 
											"case when rpad(t.OTRO,(select max(length(at17.OTRO)) from reporte_amx_txt at17)+5,' ') is null then rpad(' ',(select max(length(at17.OTRO)) from reporte_amx_txt at17)+5,' ') else rpad(t.OTRO,(select max(length(at17.OTRO)) from reporte_amx_txt at17)+5,' ') end,\t\n"+ 
											"case when rpad(to_char(t.FECHAINICIO,'dd/MM/YYYY'),(select max(length(to_char(at18.FECHAINICIO,'dd/MM/YYYY'))) from reporte_amx_txt at18)+5,' ') is null then rpad(' ',(select max(length(to_char(at18.FECHAINICIO,'dd/MM/YYYY'))) from reporte_amx_txt at18)+5,' ') else rpad(to_char(t.FECHAINICIO,'dd/MM/YYYY'),(select max(length(to_char(at18.FECHAINICIO,'dd/MM/YYYY'))) from reporte_amx_txt at18)+5,' ') end,\t\n"+ 
											"case when rpad(to_char(t.FECHAFIN,'dd/MM/YYYY'),(select max(length(to_char(at19.FECHAFIN,'dd/MM/YYYY'))) from reporte_amx_txt at19)+5,' ') is null then rpad(' ',(select max(length(to_char(at19.FECHAFIN,'dd/MM/YYYY'))) from reporte_amx_txt at19)+5,' ') else rpad(to_char(t.FECHAFIN,'dd/MM/YYYY'),(select max(length(to_char(at19.FECHAFIN,'dd/MM/YYYY'))) from reporte_amx_txt at19)+5,' ') end,\t\n"+ 
											"case when rpad(t.INCIDENCIA,(select max(length(at20.INCIDENCIA)) from reporte_amx_txt at20)+5,' ') is null then rpad(' ',(select max(length(at20.INCIDENCIA)) from reporte_amx_txt at20)+5,' ') else rpad(t.INCIDENCIA,(select max(length(at20.INCIDENCIA)) from reporte_amx_txt at20)+5,' ') end,\t\n"+ 
											"case when rpad(t.PROBLEMATICA,(select max(length(at21.PROBLEMATICA)) from reporte_amx_txt at21)+5,' ') is null then rpad(' ',(select max(length(at21.PROBLEMATICA)) from reporte_amx_txt at21)+5,' ') else rpad(t.PROBLEMATICA,(select max(length(at21.PROBLEMATICA)) from reporte_amx_txt at21)+5,' ') end,\t\n"+ 
											"case when rpad(t.CAUSA,(select max(length(at22.CAUSA)) from reporte_amx_txt at22)+5,' ') is null then rpad(' ',(select max(length(at22.CAUSA)) from reporte_amx_txt at22)+5,' ') else rpad(t.CAUSA,(select max(length(at22.CAUSA)) from reporte_amx_txt at22)+5,' ') end,\t\n"+ 
											"case when rpad(t.TIPOIMPACTO,(select max(length(at23.TIPOIMPACTO)) from reporte_amx_txt at23)+5,' ') is null then rpad(' ',(select max(length(at23.TIPOIMPACTO)) from reporte_amx_txt at23)+5,' ') else rpad(t.TIPOIMPACTO,(select max(length(at23.TIPOIMPACTO)) from reporte_amx_txt at23)+5,' ') end,\t\n"+ 
											"case when rpad(t.impactonegativo,(select max(length(at24.impactonegativo)) from reporte_amx_txt at24)+5,' ') is null then rpad(' ',(select max(length(at24.impactonegativo)) from reporte_amx_txt at24)+5,' ') else rpad(t.impactonegativo,(select max(length(at24.impactonegativo)) from reporte_amx_txt at24)+5,' ') end,\t\n"+ 
											"case when rpad(t.ACCIONCORRECTIVA,(select max(length(at25.ACCIONCORRECTIVA)) from reporte_amx_txt at25)+5,' ') is null then rpad(' ',(select max(length(at25.ACCIONCORRECTIVA)) from reporte_amx_txt at25)+5,' ') else rpad(t.ACCIONCORRECTIVA,(select max(length(at25.ACCIONCORRECTIVA)) from reporte_amx_txt at25)+5,' ') end,\t\n"+ 
											"case when rpad(t.GERENCIA,(select max(length(at26.GERENCIA)) from reporte_amx_txt at26)+5,' ') is null then rpad(' ',(select max(length(at26.GERENCIA)) from reporte_amx_txt at26)+5,' ') else rpad(t.GERENCIA,(select max(length(at26.GERENCIA)) from reporte_amx_txt at26)+5,' ') end,\t\n"+ 
											"case when rpad(t.GERENTE,(select max(length(at27.GERENTE)) from reporte_amx_txt at27)+5,' ') is null then rpad(' ',(select max(length(at27.GERENTE)) from reporte_amx_txt at27)+5,' ') else rpad(t.GERENTE,(select max(length(at27.GERENTE)) from reporte_amx_txt at27)+5,' ') end,\t\n"+ 
											"case when rpad(t.DIRECCION,(select max(length(at28.DIRECCION)) from reporte_amx_txt at28)+5,' ') is null then rpad(' ',(select max(length(at28.DIRECCION)) from reporte_amx_txt at28)+5,' ') else rpad(t.DIRECCION,(select max(length(at28.DIRECCION)) from reporte_amx_txt at28)+5,' ') end,\t\n"+ 
											"case when rpad(t.DIRECTOR,(select max(length(at29.DIRECTOR)) from reporte_amx_txt at29)+5,' ') is null then rpad(' ',(select max(length(at29.DIRECTOR)) from reporte_amx_txt at29)+5,' ') else rpad(t.DIRECTOR,(select max(length(at29.DIRECTOR)) from reporte_amx_txt at29)+5,' ') end ,\t\n"+ 
											"case when rpad(to_char(t.FECHASOLUCION,'dd/MM/YYYY'),(select max(length(to_char(at30.FECHASOLUCION,'dd/MM/YYYY'))) from reporte_amx_txt at30)+5,' ') is null then rpad(' ',(select max(length(to_char(at30.FECHASOLUCION,'dd/MM/YYYY'))) from reporte_amx_txt at30)+5,' ') else rpad(to_char(t.FECHASOLUCION,'dd/MM/YYYY'),(select max(length(to_char(at30.FECHASOLUCION,'dd/MM/YYYY'))) from reporte_amx_txt at30)+5,' ') end,\t\n"+ 
											"case when rpad(t.ESTATUS,(select max(length(at31.ESTATUS)) from reporte_amx_txt at31)+5,' ') is null then rpad(' ',(select max(length(at31.ESTATUS)) from reporte_amx_txt at31)+5,' ') else rpad(t.ESTATUS,(select max(length(at31.ESTATUS)) from reporte_amx_txt at31)+5,' ') end,\t\n"+ 
											"case when rpad(t.IMPACTOPOSITIVOAC,(select max(length(at32.IMPACTOPOSITIVOAC)) from reporte_amx_txt at32)+5,' ') is null then rpad(' ',(select max(length(at32.IMPACTOPOSITIVOAC)) from reporte_amx_txt at32)+5,' ') else rpad(t.IMPACTOPOSITIVOAC,(select max(length(at32.IMPACTOPOSITIVOAC)) from reporte_amx_txt at32)+5,' ') end\t\n"+ 
											"from reporte_amx_txt t");

					while(rs.next()){
						mensaje+=(rs.getString(2)==null?"     \t":rs.getString(2)+"\t")
								+(rs.getString(3)==null?"     \t":rs.getString(3)+"\t")+(rs.getString(4)==null?"     \t":rs.getString(4)+"\t")
								+(rs.getString(5)==null?"     \t":rs.getString(5)+"\t")+(rs.getString(6)==null?"     \t":rs.getString(6)+"\t")
								+(rs.getString(7)==null?"     \t":rs.getString(7)+"\t")+(rs.getString(8)==null?"     \t":rs.getString(8)+"\t")
								+(rs.getString(9)==null?"     \t":rs.getString(9)+"\t")+(rs.getString(10)==null?"     \t":rs.getString(10)+"\t")
								+(rs.getString(11)==null?"     \t":rs.getString(11)+"\t")+(rs.getString(12)==null?"     \t":rs.getString(12)+"\t")
								+(rs.getString(13)==null?"     \t":rs.getString(13)+"\t")+(rs.getString(14)==null?"     \t":rs.getString(14)+"\t")
								+(rs.getString(15)==null?"     \t":rs.getString(15)+"\t")+(rs.getString(16)==null?"     \t":rs.getString(16)+"\t")
								+(rs.getString(17)==null?"     \t":rs.getString(17)+"\t")+(rs.getString(18)==null?"     \t":rs.getString(18)+"\t")
								+(rs.getString(19)==null?"     \t":rs.getString(19)+"\t")+(rs.getString(20)==null?"     \t":rs.getString(20)+"\t")
								+(rs.getString(21)==null?"     \t":rs.getString(21)+"\t")+(rs.getString(22)==null?"     \t":rs.getString(22)+"\t")
								+(rs.getString(23)==null?"     \t":rs.getString(23)+"\t")+(rs.getString(24)==null?"     \t":rs.getString(24)+"\t")
								+(rs.getString(25)==null?"     \t":rs.getString(25)+"\t")+(rs.getString(26)==null?"     \t":rs.getString(26)+"\t")
								+(rs.getString(27)==null?"     \t":rs.getString(27)+"\t")+(rs.getString(28)==null?"     \t":rs.getString(28)+"\t")
								+(rs.getString(29)==null?"     \t":rs.getString(29)+"\t")+(rs.getString(30)==null?"     \t":rs.getString(30)+"\t")
								+(rs.getString(31)==null?"     \t":rs.getString(31)+"\t")+(rs.getString(32)==null?"     \t":rs.getString(32))+"\n";
					}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
				  e.printStackTrace();
				}finally {
					close(rs, stmt, null);
				}
				list.add(mensaje);
			}
		});
		sess.close();
		return list.isEmpty()?"":list.get(0);
		
	}
	
	public  boolean CallProcessLlenarRecoAbiertas(){
		Session sess =DAO.getSession();
		sess.doWork(new Work() {
			
			@Override
			public void execute(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				CallableStatement statement = null;
				try {
					statement = con.prepareCall("{ call inorup_rec_abiert_temp()}");
					statement.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					close(null, statement, null);
				}
			}
		});
		sess.close();
		return true;
	}

	public static List<PlanAnualAic> getPlanAnualAIC(final int anio, final int mes) {
	   
	    final List<PlanAnualAic> list= new ArrayList<>();
	    Session sess =DAO.getSession();
		sess.doWork(new Work() {
			
			@Override
			public void execute(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				ResultSet rs = null;
				CallableStatement cs = null;
				try {
			        cs = con.prepareCall(buildProcedureCall("PlanAnualAic", 3));
			        int pos = 0;
			        
			        // Cargamos los parametros de entrada IN
			        cs.setInt(++pos, anio);
			        cs.setInt(++pos, mes);
			        
			        // Registramos los parametro de salida OUT
			        cs.registerOutParameter(++pos, OracleTypes.CURSOR);
			        
			        // Ejecutamos
			        cs.execute();
			        
			        // Cosechamos los parametros de salida OUT
			        // Nuestro number
			        rs = (ResultSet) cs.getObject(3);   // Nuestro cursor, convertido en ResultSet
			        while (rs.next()) {
			            // Aqui hacemos lo que queramos...
			        	PlanAnualAic aic=new PlanAnualAic();
			        	aic.setOrden(rs.getString(1));
			        	aic.setUnidadAic(rs.getString(2));
			        	aic.setR_ejecutadas1(rs.getString(3));
			        	aic.setR_programada1(rs.getString(4));
			        	aic.setD_ejecutados1(rs.getString(5));
			        	aic.setD_programados1(rs.getString(6));
			        	aic.setR_ejecutadas1E(rs.getString(7));
			        	aic.setR_dee1(rs.getString(8));
			        	aic.setR_porcentaje1(rs.getString(9));
			        	aic.setPorcentaje1(rs.getString(10));
			        	
			        	aic.setR_ejecutadas2(rs.getString(11));
			        	aic.setR_programada2(rs.getString(12));
			        	aic.setD_ejecutados2(rs.getString(13));
			        	aic.setD_programados2(rs.getString(14));
			        	aic.setR_ejecutadas2E(rs.getString(15));
			        	aic.setR_dee2(rs.getString(16));
			        	aic.setR_porcentaje2(rs.getString(17));
			        	aic.setPorcentaje2(rs.getString(18));
			        	
			        	aic.setR_ejecutadas3(rs.getString(19));
			        	aic.setR_programada3(rs.getString(20));
			        	aic.setD_ejecutados3(rs.getString(21));
			        	aic.setD_programados3(rs.getString(22));
			        	aic.setR_ejecutadas3E(rs.getString(23));
			        	aic.setR_dee3(rs.getString(24));
			        	aic.setR_porcentaje3(rs.getString(25));
			        	aic.setPorcentaje3(rs.getString(26));
			        	
			        	aic.setR_ejecutadas4(rs.getString(27));
			        	aic.setR_programada4(rs.getString(28));
			        	aic.setD_ejecutados4(rs.getString(29));
			        	aic.setD_programados4(rs.getString(30));
			        	aic.setR_ejecutadas4E(rs.getString(31));
			        	aic.setR_dee4(rs.getString(32));
			        	aic.setR_porcentaje4(rs.getString(33));
			        	aic.setPorcentaje4(rs.getString(34));
			        	
			        	aic.setR_ejecutada(rs.getString(35));
			        	aic.setR_programada(rs.getString(36));
			        	aic.setD_ejecutado(rs.getString(37));
			        	aic.setD_programado(rs.getString(38));
			        	aic.setR_ejecutadaE(rs.getString(39));
			        	aic.setR_dee(rs.getString(40));
			        	aic.setR_porcentaje(rs.getString(41));
			        	aic.setPorcentaje(rs.getString(42));
			        	list.add(aic);
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    } finally {
			        close(rs, cs, null);
			    }
			}
		});
	    sess.close();
	    return list;
	  }
	

	public static List<SairActaProyecto> getNotificaComentario(final String Usuario) {
	   
	    final List<SairActaProyecto> list= new ArrayList<>();
	    Session sess =DAO.getSession();
		sess.doWork(new Work() {
			
			@Override
			public void execute(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				DAO dao=new DAO();
				ResultSet rs = null;
				CallableStatement cs = null;
			    try {
			        cs = con.prepareCall("{?=call FN_ACTA_COMENTARIO(?)}");
			        int pos = 0;
			        // Registramos los parametro de salida OUT
			        cs.registerOutParameter(++pos, OracleTypes.CURSOR);
			        // Cargamos los parametros de entrada IN
			        cs.setString(++pos, Usuario);
			        // Ejecutamos
			        cs.execute();
			        // Cosechamos los parametros de salida OUT
			        // Nuestro number
			        rs = (ResultSet) cs.getObject(1); 
			        while (rs.next()) {
			            // Aqui hacemos lo que queramos...
			        	String idActa=rs.getString(1);
			        	@SuppressWarnings("unchecked")
						List<SairActaProyecto> list2=dao.find("from SairActaProyecto a where a.idProyecto="+idActa);
			        	@SuppressWarnings("unchecked")
			        	List<String> listCo=dao.find("select distinct c.id.idCorresponsable from SairActaCorresponsable c where c.id.idProyecto="+idActa);
			        	String corresponsable="";
			        	for (String string : listCo) {
			        		corresponsable+=string+"/";
						}
			        	list2.get(0).setComentarioSolicitud(corresponsable);
			        	list.add(list2.get(0));
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    } finally {
			        close(rs, cs, null);
			    }
			}
		});
	    sess.close();
	    return list;
	  }
	
	public static String getReporte(final String Usuario, final String idEstado,final String idSubarea,final String idArea) {
		final ArrayList<String> ruta=new ArrayList<>();   
		Session sess=DAO.getSession();
		sess.doWork(new Work() {
			
			@Override
			public void execute(Connection con) throws SQLException {
				CallableStatement cs = null;
			    try {
			        cs = con.prepareCall("{call rpt_auditado(?,?,?,?,?)}");
			        int pos = 0;
			        // Registramos los parametro de salida OUT
			        cs.registerOutParameter(5, OracleTypes.CLOB);
			        // Cargamos los parametros de entrada IN
			        cs.setString(++pos, idEstado);
			        cs.setString(++pos, idSubarea);
			        cs.setString(++pos, idArea);
			        cs.setString(++pos, Usuario);
			        // Ejecutamos
			        cs.execute();
			        Clob bin=cs.getClob(5);
			        ResourceBundle prop = ResourceBundle.getBundle("EIS");
			        String rutaReporte=prop.getString("rutaReporte")+"rptAuditado"+(idSubarea!=null?idSubarea:"")+".xls";
			        ruta.add(rutaReporte);
			        File file22 = new File(rutaReporte);
					InputStream inStream = null;
					FileOutputStream fos = null;
					int size = 0;
					try {
						fos = new FileOutputStream(file22);
						inStream = bin.getAsciiStream();
						size = (int) bin.length();
						byte[] buffer = new byte[size];
						int length = -1;
						while ((length = inStream.read(buffer)) != -1) {
							fos.write(buffer, 0, length);
						}
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{
						try {
							if(inStream!=null)
							inStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							if(fos!=null)
								fos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			    } catch (Exception e) {
			        e.printStackTrace();
			    } finally {
			        close(null, cs, null);
			    }
			}
		});
		sess.close();
	    return ruta.isEmpty()?null:ruta.get(0);
	  }
		
	public static boolean CallProcessRegularizaDiscusion(){
		Session sess =DAO.getSession();
		sess.doWork(new Work() {
			
			@Override
			public void execute(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				CallableStatement statement = null;
				try {
					statement = con.prepareCall("{ call ins_regulariza_disc()}");
					statement.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					 close(null, statement, null);
				}
			}
		});
		sess.close();
		return true;
	}
	
	public boolean callPrimerSeguimiento(final String fecha){
		Session sess =DAO.getSession();
		sess.doWork(new Work() {
			
			@Override
			public void execute(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				CallableStatement statement = null;
				try {
					statement = con.prepareCall("{?=call fn_primer_seguimiento(?)}");
					statement.registerOutParameter(1, OracleTypes.VARCHAR);
					statement.setString(2, fecha);
					statement.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					 close(null, statement, null);
				}
			}
		});
		sess.close();
		return true;
	}
	
	private static String buildProcedureCall(String procedureName, int paramCount) {
        StringBuffer sb = new StringBuffer("{call "+procedureName+"(");
        for (int n = 1; n <= paramCount; n++) {
            sb.append("?");
            if (n < paramCount) sb.append(",");
        }
        return sb.append(")}").toString();
    }
    
    private static void close(ResultSet rs, Statement s, Connection c) {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (s != null) s.close(); } catch (Exception e) {}
        try { if (c != null) c.close(); } catch (Exception e) {}
    }
    
    private static void close(ResultSet rs, CallableStatement s, Connection c) {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (s != null) s.close(); } catch (Exception e) {}
        try { if (c != null) c.close(); } catch (Exception e) {}
    }
    
    public String getMasivoConclusionRec(final String Usuario, final BigDecimal idAreaev,final BigDecimal idSubarea, final String grtEnc, final String prsEnc, final String item,final BigDecimal idReservacion) {
		final ArrayList<String> ruta=new ArrayList<>();   
		Session sess=DAO.getSession();
		sess.doWork(new Work() {   
			
			@Override
			public void execute(Connection con) throws SQLException {
				CallableStatement cs = null;
			    try {
			        cs = con.prepareCall("{call ins_masivo_conclusion_rec(?,?,?,?,?,?,?,?)}");
			        int pos = 0;
			        // Registramos los parametro de salida OUT
			        cs.registerOutParameter(8, OracleTypes.VARCHAR);
			        // Cargamos los parametros de entrada IN
			        cs.setString(++pos, Usuario);
			        cs.setBigDecimal(++pos, idAreaev);
			        cs.setBigDecimal(++pos, idSubarea);
			        cs.setString(++pos, grtEnc);
			        cs.setString(++pos, prsEnc);
			        cs.setString(++pos, item);
			        cs.setBigDecimal(++pos, idReservacion);
			        // Ejecutamos
			        cs.execute();
			        String bin=cs.getString(8);
			        ruta.add(bin);
			    } catch (Exception e) {
			        e.printStackTrace();
			    } finally {
			        close(null, cs, null);
			    }
			}
		});
		sess.close();
	    return ruta.isEmpty()?null:ruta.get(0);
	  }
	
    public static boolean CallProcessRecMonoInf(){
			Session sess =DAO.getSession();
			sess.doWork(new Work() {
				
				@Override
				public void execute(Connection con) throws SQLException {
					// TODO Auto-generated method stub
					CallableStatement statement = null;
					try {
						statement = con.prepareCall("{ call ins_rec_mono_inf()}");
						statement.execute();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						 close(null, statement, null);
					}
				}
			});
			sess.close();
			return true;
		}
}
