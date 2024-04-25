package ec.com.rgt.sair.dao;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//import org.zkoss.zk.ui.Executions;*****

import ec.com.rgt.sair.controller.Mensaje;
import ec.com.rgt.sair.hbm.SairGerente;
import ec.com.rgt.sair.hbm.SairLog;
import ec.com.rgt.sair.hbm.SairParametros;
import ec.com.rgt.sair.hbm.SairTipoLog;
import ec.com.rgt.sair.hbm.UsuariosMapeados;
import getaccountiam.GetAccount;
//import getaccountiam.GetAccount;***

public class UtilsDAO extends DAO{
	@SuppressWarnings("unchecked")
	public void savelog(String modulo,String menu,String metodo, String descripcion,int linea,String log,String usuario,int idTipo){
		 SairLog sairlog=new SairLog();
		 sairlog.setIdLog(BigDecimal.ZERO);
		 sairlog.setEstado("A");
		 sairlog.setFechaIngreso(new Date());
		 try {
			 //sairlog.setIpUsuario(Executions.getCurrent().getRemoteAddr());*****
		} catch (Exception e) {
			// TODO: handle exception
			try {
				sairlog.setIpUsuario(InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				sairlog.setIpUsuario("0.0.0.0");
			}
		}
		 
		 sairlog.setDescripcion(descripcion);
		 sairlog.setLinea(new BigDecimal(linea));
		 sairlog.setLog(log);
		 sairlog.setMenu(menu);
		 sairlog.setMetodo(metodo);
		 sairlog.setModulo(modulo);
		 List<SairTipoLog> tipoLog= find("from SairTipoLog l where l.idTipo="+idTipo);
		 try {
			 sairlog.setSairTipoLog(tipoLog.get(0));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error de autenticacion del WSsairTipoLog");
		}
		 
		 sairlog.setUsuario(usuario);
		 saveOrUpdate(sairlog,sairlog.getClass());
	 }

	public String getUsuarioAdam(String idUsuario){
		
		System.out.println("---> DENTRO DE GET USUARIO ADAM");
		String usuarioAdam=null;
		
		System.out.println("---> CONSULTAR TIPO DE MAPEO");
		if(getTipoMapeo()){//parametro de tipo mapeo IAM o BD Operaciones  --295
			DAO dao=new DAO();
			System.out.println("--> MAPEO OPERDB");
			System.out.println("-->[OPE] CONSULTA A TABLA SAIR GERENTE FILTRANDO ARGUMENTO idUsuario CON USUARIO EXTRAIDO DE CORREO EN SAIR_GERENTE");
			@SuppressWarnings("unchecked")
			List<SairGerente> list=dao.find("from SairGerente g where upper(substr(g.email,0,instr(g.email,'@')-1))=upper('"+idUsuario+"')");
			
			
	        if(list==null||list.isEmpty()){
	        	System.out.println("-->[OPE] SI CONSULTA A SAIR_GERENTE NO DEVOLVIO RESULTADO");
	        	System.out.println("-->[OPE] VALIDA SI EXISTE ESPACIOS INTERMEDIOS EN ARGUMENTO idUsuario");
	        	if(idUsuario.trim().indexOf(" ")==-1){
	        		System.out.println("-->[OPE] SI NO EXISTEN ESPACIOS, CONSULTA USUARIOS_MAPEADOS CON ARG isUsuario y USUARIO EXTRAIDO DE CORREO EN USUARIOS_MAPEADOS");
	        		@SuppressWarnings("unchecked")
					List<UsuariosMapeados> mapeados=dao.find("from UsuariosMapeados u where upper(substr(u.email1,0,instr(u.email1,'@')-1))=upper('"+idUsuario+"')");
	        		System.out.println("RESULTADOS DE LA CONSULTA");
	        		
	        		//TRY CATCH AÑADIDO JGILCES, SOLO PARA FASE DE PRUEBA
	        		try {
	        			for(int i = 0 ;i<mapeados.size();i++) {
		    				
		    				System.out.println("==> " + mapeados.get(i).getUsuariosAdam());
		    				System.out.println("==> " + mapeados.get(i).getNombresCompletos());
		    				System.out.println("==> " + mapeados.get(i).getEmail1());
		    			}
	        		}catch(Exception w) {
	        			return idUsuario;
	        		}//FIN JGILCES
	        		
	        		if(mapeados!=null&&!mapeados.isEmpty())
	        			System.out.println("-->[OPE] SI CONSULTA DEVOLVIO RESULTADOS RETORNA EL USUARIO ADAM");
	        		    try {//JGILCES SE AÑADE BLOQUE TRY CATCH POR PRUEBAS
	        		    	usuarioAdam=mapeados.get(0).getUsuariosAdam();
	        		    }catch(Exception e) {
	        		    	;;
	        		    }
	        			
	        	}
	        		//System.out.println(usuarioAdam);//usuarioAdam=getAccount(idUsuario);
	        }else{
	        	System.out.println("-->[OPE] SI CONSULTA A SAIR_GERENTE DEVOLVIO RESULTADO");
	        	usuarioAdam=list.get(0).getUsuario();
	        	System.out.println("-->[OPE] RETORNA USUARIO ADAM: " + usuarioAdam);
	        }
		}else{
			System.out.println("-->[IAM] MAPEO IAM");
			System.out.println("-->[IAM] CONSULTA USUARIO USANDO EL JAR GET ACCOUNT IAM");
			usuarioAdam=getAccount(idUsuario);
			System.out.println("-->[IAM] RETORNA USUARIO ADAM: " + usuarioAdam);
        }
		return usuarioAdam==null?idUsuario:usuarioAdam;
	}
	
	private  String getAccount(String idUsuario){
		GetAccount ga = new GetAccount();
        String usuarioAdam=ga.get(idUsuario);
        if(usuarioAdam==null){
        	savelog("AUDITADO", "GENERAL", "getUsuarioAdam", "El usuario "+idUsuario+" no existe en ADAM", 712, "Puede que el usuario "+idUsuario+" no exista en el ADAM, o que la conexion desde sairWebService hacia el ADAM tenga inconvenientes", idUsuario, 2);
        }
        return usuarioAdam;
	}
	
	public static Date RestarDias(int dias){
		Calendar calendar = Calendar.getInstance();	
		calendar.add(Calendar.DATE, -dias);//resta los dias
		return calendar.getTime();
	}
	
	public static int getDias(){
		int dir=0;
		DAO dao=new DAO();
		@SuppressWarnings("unchecked")
		List<SairParametros> parametros= dao.find("from SairParametros p where p.idParametro="+289);
		if(!parametros.isEmpty()){
			dir=Integer.parseInt(parametros.get(0).getValorNumerico().toString());
		}
		return dir;
	}
	
	private static boolean getTipoMapeo(){
		System.out.println("----> DENTRO DE GET TIPO MAPEO");
		boolean dir=false;
		DAO dao=new DAO();
		System.out.println("----> CONSULTA VALOR NUMERICO DE LA TABLA SAIR_PARAMETROS CON ID 295");
		@SuppressWarnings("unchecked")
		List<SairParametros> parametros= dao.find("from SairParametros p where p.idParametro="+295);
		if(!parametros.isEmpty()){
			System.out.println("----> CONSULTA DEVOLVIO RESULTADOS: ");
			System.out.println("-----> RESULTADO: " + parametros.get(0).getValorNumerico());
			if(parametros.get(0).getValorNumerico()!=null)
				dir=Integer.parseInt(parametros.get(0).getValorNumerico().toString())==1;
		}
		System.out.println("----> TIPO PARAMETRO DEVUELVE " + dir + " (TRUE - MAPEO OPERACIONES; FALSE: MAPEO IAM)");
		return dir;
		
	}
	
	public static Mensaje eliminarLog(){
		Mensaje aplicacionesList = new Mensaje();
		DAO dao=new DAO();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date date=RestarDias(getDias());
		System.out.println("Eliminacion Masiva de Log desde "+dateFormat.format(date));
		//List<SairLog> log=dao.find("from SairLog l where to_date(to_char(l.fechaIngreso,'dd/MM/yyyy'),'dd/MM/yyyy') <= to_date('"+dateFormat.format(date)+"','dd/MM/yyyy')");
		int i=dao.deleteMasivoSQL("delete from Sair_Log l where to_date(to_char(l.fecha_Ingreso,'dd/MM/yyyy'),'dd/MM/yyyy') <= to_date('"+dateFormat.format(date)+"','dd/MM/yyyy')");
		System.out.println("---------------------------------> "+i);
		/*if(!log.isEmpty()){
			System.out.println("Eliminacion Masiva de Log desde "+dateFormat.format(date));
			LogDAO Obj_Operaciones = new LogDAO();
			for (int i = 0; i < log.size(); i++) {
				aplicacionesList=Obj_Operaciones.deleteLog(log.get(0));
			}
		}else{
			System.out.println("No existen log");
		}*/
		return aplicacionesList;
	}
	
	public String generaCodigo (BigDecimal idArea,String user){//genera automatico el codigo del documento
		ArrayList<String> secuencia ;
		String codigo = null;
		try {
			DAO dao=new DAO();
			String sql="select (select a.cod_Brief || '-' || a.abreviatura_general\n" +
							"          from sair_area a\n" + 
							"         where a.id_area = "+idArea+") || '-' || b.numero\n" + 
							"  from (select lpad(count(*) + 1, 3, 0) || '-' || to_char(sysdate, 'YY') numero\n" + 
							"          from sair_bri_brief r\n" + 
							"         where to_char(r.fecha_creacion, 'YYYY') = to_char(sysdate, 'YYYY')\n" + 
							"           and r.id_area = "+idArea+") b";
			secuencia = dao.Sqlquery(sql);
			codigo = secuencia.get(0).trim();
		} catch (Exception e) {
			Logger.getLogger(UtilsDAO.class.getName()).log(Level.WARNING,"generaCodigo "+ e.getMessage() );
			savelog("BRIEF", "CrearBrief", "generaCodigo", "CrearBrief:ERROR Problema para generar codigo "+codigo,362, e.getMessage(),user, 1);
		}
		return codigo;
	}
}
