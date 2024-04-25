package ec.com.rgt.sair.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.controller.SairConnection;
import ec.com.rgt.sair.hbm.SairDocAlcance;
import ec.com.rgt.sair.hbm.SairDocAntecedente;
import ec.com.rgt.sair.hbm.SairLog;
import ec.com.rgt.sair.hbm.SairNotificacion;
import ec.com.rgt.sair.hbm.SairReportes;
import ec.com.rgt.sair.hbm.SairTipoLog;

@SuppressWarnings("unchecked")
public class LogDAO extends DAO{
	
	
	public List<SairTipoLog> findTipoLog(String hql_tipoLog){
		List<SairTipoLog> list=find(hql_tipoLog);
		return list;
	}
	
	public List<SairLog> findLog(String hql_Log){
		List<SairLog> list=find(hql_Log);
		return list;
	}
	
	public List<SairNotificacion> findSairNotificacion(String hql_notificacion){
		List<SairNotificacion> list=find(hql_notificacion);
		return list;
	}
	
	public List<SairReportes> findSairReportes(String hql_SairReportes){
		List<SairReportes> list=find(hql_SairReportes);
		return list;
	}
	
	public List<SairDocAlcance> findAlcance(String hql){
		List<SairDocAlcance> list=find(hql);
		/*List<SairDocAlcance> listFinal = new ArrayList<SairDocAlcance>();
		
		Connection conn;
		SairConnection objConnSair = new SairConnection();
		
		try {
			objConnSair.conectar();
			conn = objConnSair.getConnection();
			PreparedStatement pstm = null;
			ResultSet rs = null;
			for(SairDocAlcance item: list) {
				if (conn != null) {
					pstm = conn.prepareStatement("Select alcance from usrsair.sair_doc_alcance where id_alcance = ?");
					pstm.setInt(1, item.getIdAlcance().intValue());
					
					rs = pstm.executeQuery();
					while(rs.next()) {
						Clob res = rs.getClob(1);
						String resFinal = res!=null?clobToString(res):null;
						if(resFinal!=null && !resFinal.isEmpty()) {
							if(item.getAlcance()==null) {
								item.setAlcance(resFinal); 
							}
						}
						listFinal.add(item);
					}
				}
			}
			
		} catch (SQLException e) {
			System.out.println("ERROR: " + e.getMessage());
		}finally {
			try {
				objConnSair.closeConnection();
				if(objConnSair.isClose()) {
					System.out.println("Conexion cerrada");
				}else {
					System.out.println("Problemas al cerrar conexion");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}*/
		
		//return listFinal;
		return list;
	}
	
	private String clobToString(java.sql.Clob data)
	{
	    final StringBuilder sb = new StringBuilder();

	    try
	    {
	        final Reader         reader = data.getCharacterStream();
	        final BufferedReader br     = new BufferedReader(reader);

	        int b;
	        while(-1 != (b = br.read()))
	        {
	            sb.append((char)b);
	        }

	        br.close();
	    }
	    catch (SQLException e)
	    {
	    	System.out.println("SQL. Could not convert CLOB to string");
	        return e.toString();
	    }
	    catch (IOException e)
	    {
	        System.out.println("IO. Could not convert CLOB to string");
	        return e.toString();
	    }

	    return sb.toString();
	}
	
	public List<SairDocAntecedente> findAntecedente(String hql){
		List<SairDocAntecedente> list=find(hql);
		return list;
	}
	
	public Mensaje ingresaSairReportes(SairReportes sairReportes){
		Mensaje msn=new Mensaje();
		msn.setIdMensaje(saveOrUpdate(sairReportes, sairReportes.getClass()));
		if(msn.getIdMensaje().toString().equals("1")){
			msn.setMensaje("Ingreso Exitoso");
		}
		return msn;
		
	}
	
	public Mensaje ingresaSairDocAlcance(SairDocAlcance alcance){
		Mensaje msn=new Mensaje();
		msn.setIdMensaje(saveOrUpdate(alcance, alcance.getClass()));
		if(msn.getIdMensaje().toString().equals("1")){
			msn.setMensaje("Ingreso Exitoso");
		}
		return msn;
	}
	
	public Mensaje ingresaSairDocAntecedente(SairDocAntecedente antecedente){
		Mensaje msn=new Mensaje();
		msn.setIdMensaje(saveOrUpdate(antecedente, antecedente.getClass()));
		if(msn.getIdMensaje().toString().equals("1")){
			msn.setMensaje("Ingreso Exitoso");
		}
		return msn;
	}
	
	public Mensaje deleteSairReportes(SairReportes sairReportes){
		Mensaje msn=new Mensaje();
		msn.setIdMensaje(delete(sairReportes, sairReportes.getClass()));
		return msn;
		
	}
	
	public Mensaje deleteSairAlcance(SairDocAlcance alcance){
		Mensaje msn=new Mensaje();
		msn.setIdMensaje(delete(alcance, alcance.getClass()));
		return msn;	
	}
	
	public Mensaje deleteSairAntecedente(SairDocAntecedente antecedente){
		Mensaje msn=new Mensaje();
		msn.setIdMensaje(delete(antecedente, antecedente.getClass()));
		return msn;	
	}
	
	public Mensaje ingresaLog(SairLog sairlog){
		Mensaje msn=new Mensaje();
		msn.setIdMensaje(saveOrUpdate(sairlog, sairlog.getClass()));
		return msn;
		
	}
	
	public Mensaje deleteLog(SairLog sairlog){
		Mensaje msn=new Mensaje();
		msn.setIdMensaje(delete(sairlog, sairlog.getClass()));
		return msn;
		
	}
	
	public Mensaje deletesairNotificacion(SairNotificacion sairNotificacion){
		Mensaje msn=new Mensaje();
		msn.setIdMensaje(delete(sairNotificacion, sairNotificacion.getClass()));
		return msn;
		
	}
	
	public Mensaje ingresaNotificacion(SairNotificacion sairNotificacion){
		Mensaje msn=new Mensaje();
		msn.setIdMensaje(saveOrUpdate(sairNotificacion, sairNotificacion.getClass()));
		return msn;
		
	}
	
}
