/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.rgt.sair.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.AuthenticationException;
import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import ec.com.rgt.sair.dao.UtilsDAO;
import ec.com.rgt.sair.hbm.UsuariosAD;

//import ec.com.rgt.sair.ws.Usuarios;

/**
 *
 * @author Hector
 */
public class LdapAutenticationWS {
	static final ResourceBundle props = ResourceBundle.getBundle("AD");
    private  String server;
    Hashtable<String, String> env;
    /*configuracion de ldap */
    private   String auth_method ;
    private   String ldap_dn ; 
    //static SearchControls sc;
    //static DirContext ctx;
     String usuario, password;
    //static boolean login=false;
    
    // This is our access PW
    // private static final String base_dn = "DC=WS2008R2,DC=HOME";

  

	public LdapAutenticationWS() {
    
    }
	
	public static void main(String[] args) {
		LdapAutenticationWS ws=new LdapAutenticationWS();
		//System.out.print(ws.authenticateFS(props.getString("user"), props.getString("pass")));
		System.out.print(ws.authenticateFS("PACOSTA", "12345678"));
		//ws.getUsersAreaADPRueba("SAC", "SAC");
	}
	
	public void getUsersAreaADPRueba(String area,String codiAdam){
    	if(authenticate(props.getString("user"), props.getString("pass"))){
    		int countIng=0;//,countAct=0;
    		try {
    			DirContext ctx = new InitialDirContext(env);
				//String filter = "(&(Objectclass="+props.getString("user.class")+")(name=*"+area+"*))";
				String filter = "(&(name="+area+"*)(mail=*.ec))";
				//String filter = "(&(department="+area+")(mail=*.ec))";//"(&(name=*"+area+"*)(mail=*))";
	            String base = props.getString("user.base");//"CN=Users,DC=sair,DC=com";
	            SearchControls sc = new SearchControls();
	            //String[] attributeFilter = { "CN", "Users" };
	            //sc.setReturningAttributes(attributeFilter);
	            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
	            NamingEnumeration<SearchResult> results =ctx.search(base, filter, sc);
	            while (results.hasMore()) 
	            {
	              SearchResult result = (SearchResult)results.next();
	              Attributes attrs = result.getAttributes();
	              String usuAD="",nombAD="",mailAD="";
	              try{usuAD=subString(attrs.get("sAMAccountName"));}catch(Exception e){}
	              try{nombAD=subString(attrs.get("name"));}catch(Exception e){}
	              try{mailAD=subString(attrs.get("mail"));}catch(Exception e){}
	              UsuariosAD usuariosAD = new UsuariosAD();
            	  usuariosAD.setIdUsuariosAD(new BigDecimal(0));
	              usuariosAD.setNombresCompletos(nombAD);
	              usuariosAD.setEmail(mailAD==null?"":mailAD.toLowerCase());
	              if(usuAD==null){
	            	  usuAD=usuariosAD.getEmail().substring(0,usuariosAD.getEmail().indexOf("@"));
	              }
	              usuariosAD.setUsuario(usuAD);
	              usuariosAD.setAreaAdam(codiAdam);
	              usuariosAD.setEstado("A");
	              if(usuAD!=null)
	              usuariosAD.setUsuariosAdam(new UtilsDAO().getUsuarioAdam(usuAD));
	              countIng++;
	              if(usuariosAD.getUsuariosAdam()==null)
	              System.out.println(countIng+" "+ usuariosAD.getUsuario()+ " "+ usuariosAD.getNombresCompletos() +" "+usuariosAD.getEmail());
	            }
	            ctx.close();
			} catch (NamingException e) {
				//e.printStackTrace();
				// TODO Auto-generated catch block
			}
    	}
    }

    public  boolean authenticate(String usuario , String password) {
    	System.out.println("DENTRO DE AUTENTICACIÓN USUARIO: " + usuario + " -- PASSWORD: " + password);
    	
    		//boolean login=false;
	        server=props.getString("server");
	        //String port=props.getString("port");
	        auth_method=props.getString("auth_method");
	        ldap_dn=props.getString("ldap_dn");
	        
	        System.out.println("--> SERVIDOR IP AD: " + server);
	        
	        
	        if(usuario!=null?usuario.trim().equals("")?true:false:false){
	        	usuario="*";
	        }else{
	        	usuario = usuario+ ldap_dn  ;
	        }
	        if(password!=null?password.trim().equals("")?true:false:false)
	    		password="*";
	        else
	        {
	        	if(password==null)
	        		password="*";
	        }
	        //Logger.getLogger(LdapAutenticationWS.class.getName()).log(Level.INFO, "conexion al usuario usando:"+ usuario );
	        try {
	            env = new Hashtable<String, String>();
	            env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
	            //env.put(Context.PROVIDER_URL, "ldap://" + server + ":" + port );
	            env.put(Context.PROVIDER_URL, "ldap://" + server );
	            //Logger.getLogger(LdapAutenticationWS.class.getName()).log(Level.INFO, "provider = "+ "ldap://" + server + ":" + port  );
	            env.put(Context.SECURITY_AUTHENTICATION, auth_method );
	            //Logger.getLogger(LdapAutenticationWS.class.getName()).log(Level.INFO, "SECURITY_AUTHENTICATION = "+ auth_method );
	
	            env.put(Context.SECURITY_PRINCIPAL, usuario);
	            env.put(Context.SECURITY_CREDENTIALS, password);
	            DirContext ctx = new InitialDirContext(env);
	            ctx.close();
	           // login=true;
	            return true;
	        } catch (CommunicationException comEx) {
	        	System.out.println("ERROR AL CONECTAR AL AD -- AD NO DISPONIBLE");
	        	UtilsDAO udao=new UtilsDAO();
	           // Logger.getLogger(LdapAutenticationWS.class.getName()).log(Level.SEVERE, errorMsg );
	            udao.savelog("SEGURIDAD", "AUTENTICACION", "authenticate", "CommunicationException", 94, comEx.getMessage(), usuario, 3);
	            return false;
	
	        } catch (AuthenticationException authEx) {
	        	//UtilsDAO udao=new UtilsDAO();
	        	System.out.println("ERROR AL CONECTAR AL AD -- AD NO DISPONIBLE");
	            //Logger.getLogger(LdapAutenticationWS.class.getName()).log(Level.SEVERE, errorMsg );
	            //udao.savelog("SEGURIDAD", "AUTENTICACION", "authenticate", "AuthenticationException", 94, authEx.getMessage(), usuario, 3);
	            return false;
	
	        } catch (NamingException nameEx) {
	        	System.out.println("ERROR AL CONECTAR AL AD -- AD NO DISPONIBLE");
	        	UtilsDAO udao=new UtilsDAO();
	            //Logger.getLogger(LdapAutenticationWS.class.getName()).log(Level.SEVERE, errorMsg );
	            udao.savelog("SEGURIDAD", "AUTENTICACION", "authenticate", "NamingException", 94, nameEx.getMessage(), usuario, 3);
	            return false;
	        }
    }
    
    
    public List<Mensaje> getUsersAreaAD(String area,String codiAdam){
    	List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
    	System.out.println("--> SE PROCEDE A AUTENTICACION AL AD");
    	
    	if(authenticate(props.getString("user"), props.getString("pass"))){
    		System.out.println("--> AUTENTICACION AL AD EXITOSA");
    		System.out.println("--> CONFIGURACION DE CONSULTA AL AD CON FILTRO " + "(&(name="+area+"*)(mail=*.ec))");
    		int countIng=0;//,countAct=0;
    		try {
    			DirContext ctx = new InitialDirContext(env);
				//String filter = "(&(Objectclass="+props.getString("user.class")+")(name=*"+area+"*))";
				String filter = "(&(name="+area+"*)(mail=*.ec))";
				//String filter = "(&(department="+area+")(mail=*.ec))";//"(&(name=*"+area+"*)(mail=*))";
	            String base = props.getString("user.base");//"CN=Users,DC=sair,DC=com";
	            SearchControls sc = new SearchControls();
	            //String[] attributeFilter = { "CN", "Users" };
	            //sc.setReturningAttributes(attributeFilter);
	            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
	            NamingEnumeration<SearchResult> results =ctx.search(base, filter, sc);
	            while (results.hasMore()) 
	            {
	            	System.out.println("--> AD DEVOLVIO RESULTADOS PARA EL AREA: " + area);
	              List<Mensaje> m= new ArrayList<Mensaje>();
	              SearchResult result = (SearchResult)results.next();
	              Attributes attrs = result.getAttributes();
	              String usuAD="",nombAD="",mailAD="",usuariotemp;
	              System.out.println("--> AD DEVOLVIO RESULTADOS PARA EL AREA: " + area);
	              System.out.println("----> usuAD: " + attrs.get("sAMAccountName"));
	              System.out.println("----> nombAD: " + attrs.get("name"));
	              System.out.println("----> mailAD: " + attrs.get("mail"));
	              try{usuAD=subString(attrs.get("sAMAccountName"));}catch(Exception e){}
	              try{nombAD=subString(attrs.get("name"));}catch(Exception e){}
	              try{mailAD=subString(attrs.get("mail"));}catch(Exception e){}
	              if(nombAD!=null) {
	            	  System.out.println("--> nombAD contiene información");
	            	  System.out.println("--> SE VALIDA LA INCLUSION DE -Contacto EN nombAD");
		              if(nombAD.indexOf("-Contacto")==-1){
		            	  System.out.println("-->nombAD CONTIENE -Contacto");
		            	  
			              OperacionesUsuario Obj_Operaciones = new OperacionesUsuario();
			              int band=0;
			              
			              System.out.println("--> CREANDO NUEVO INSTANCIA DE USUARIO_AD");
			              UsuariosAD usuariosAD = new UsuariosAD();
			              System.out.println("--> INSERTANDO INFORMACIÓN DE USUARIO_AD: ");
			              System.out.println("---> ID_USUARIO: " + new BigDecimal(0));
			              System.out.println("---> NOMBRES COMPLETOS: " + nombAD);
			              System.out.println("---> EMAIL: " + mailAD==null?"":mailAD.toLowerCase());
		            	  usuariosAD.setIdUsuariosAD(new BigDecimal(0));
			              usuariosAD.setNombresCompletos(nombAD);
			              usuariosAD.setEmail(mailAD==null?"":mailAD.toLowerCase());
			              
			              System.out.println("--> SE EXTRAE USUARIO ABREVIADO TMP DESDE EMAIL");
			              System.out.println("---> CORREO: " + usuariosAD.getEmail());
			              
			              usuariotemp=usuariosAD.getEmail().substring(0,usuariosAD.getEmail().indexOf("@"));
			              System.out.println("---> USUARIO TEMPORAL: " + usuariotemp);
			              
			              System.out.println("--> SE VALIDA SI usuAD ES NULO");
			              if(usuAD==null){
			            	  System.out.println("--> SI usuAD ES NULO, ASIGNAR USUARIO TEMPORAL.");
			            	  usuAD=usuariotemp;
			              }
			              
			              System.out.println("--> INSERTANDO INFORMACIÓN FALTANTE DE USUARIO AD: ");
			              System.out.println("---> USUARIO AD: " + usuAD);
			              System.out.println("---> AREA ADAM: " + codiAdam + " (AREA PASADA COMO ARGUMENTO AL PROCESO)");
			              System.out.println("---> ESTADO: 'A'");
			              usuariosAD.setUsuario(usuAD);
			              usuariosAD.setAreaAdam(codiAdam);
			              usuariosAD.setEstado("A");
			              
			              System.out.println("--> SI USUARIO AD NO ES NULO");
			              if(usuAD!=null) {
			            	  System.out.println("--> PROCEDE AL MAPEO CON USUARIO ADAM getUsuarioAdam");
			            	  usuariosAD.setUsuariosAdam(new UtilsDAO().getUsuarioAdam(usuariotemp));
			            	  System.out.println("-->ASIGNA A USUARIO ADAM A USUARIO AD: " + usuariosAD.getUsuariosAdam());
			              }
			              System.out.println("--> PROCEDE AL GUARDAR EL NUEVO USUARIO AD");
			              m = Obj_Operaciones.SaveOrUpdateAD(usuariosAD, band);
			              
			              if(m.get(0).getMensaje().equals("Ingreso Exitoso")) {
			            	  System.out.println("--> INGRESO EXITOSO, CONTINUAR SIGUIENTE");
		            		  countIng++;}
		              }}
	            }
	            ctx.close();
			} catch (NamingException e) {
				//e.printStackTrace();
				// TODO Auto-generated catch block
			}
    		
    		Mensaje Obj_Mensaje = new Mensaje();
    		Obj_Mensaje.setMensaje("Se ingresaron "+countIng+" con exito.");
    		LstMensaje.add(Obj_Mensaje);
    	}
    	return LstMensaje;
    }
    
    public  boolean authenticateFS(String usuario , String password) {
    	OperacionesLogin OpLog= new OperacionesLogin();
    	if(OpLog.validaUsuario(usuario, password).equals("Ok"))
    	{
    		return true;
    	}else
    		return false;
    }
    
    public static String subString(Attribute attribute){
    	String res=null;
    	if(attribute!=null){
    		String dato=attribute.toString();
    		try {	
    			res=dato.substring(dato.indexOf(":")+1, dato.length());
    			res=res.trim();
    		} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	
		return res;
    }
    
    
}
