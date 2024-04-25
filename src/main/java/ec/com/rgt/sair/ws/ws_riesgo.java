package ec.com.rgt.sair.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.com.rgt.sair.controller.LdapAutenticationWS;
import ec.com.rgt.sair.controller.OperacionesSairDocumentos;
import ec.com.rgt.sair.hbm.SairDocDestinatario;
import ec.com.rgt.sair.hbm.SairDocRiesgoRc;

@WebService()
public class ws_riesgo {
	Boolean aux=false;
	LdapAutenticationWS ws=new LdapAutenticationWS();
	@WebMethod(operationName = "FindSairDocRiesgoRc")
    public List<SairDocRiesgoRc> FindSairDocRiesgoRc(@WebParam(name="Hqlrc")String Hqlrc,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
		if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
    	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
    	List<SairDocRiesgoRc> LstSairDocRiesgoRc = new ArrayList<SairDocRiesgoRc>();
    	LstSairDocRiesgoRc = Obj_Operaciones.FindSairDocRiesgoRc(Hqlrc);
    	aux=false;
        return LstSairDocRiesgoRc;
    	}else{
        	return null;
        }
        
	}
	
    @WebMethod(operationName = "FindSairDocDestinatario")
    public List<SairDocDestinatario> FindSairDocDestinatario(@WebParam(name="Hqldestinatario")String Hqldestinatario,
    		@WebParam(name="usuario")String usuario,
    		@WebParam(name="password")String password,
    		@WebParam(name="Autenticacion")String Autenticacion) throws Exception {
    	if(Autenticacion!=null&&usuario!=null&&password!=null)
    	{
		    if(Autenticacion.equals("AD"))
		    	aux=ws.authenticate(usuario, password);
		    if(Autenticacion.equals("FS"))
		    	aux=ws.authenticateFS(usuario, password);
    	}
    	if(aux){
       	OperacionesSairDocumentos Obj_Operaciones = new OperacionesSairDocumentos();
       	List<SairDocDestinatario> LstSairDocDestinatario = new ArrayList<SairDocDestinatario>();
       	LstSairDocDestinatario = Obj_Operaciones.findSairDocDestinatario(Hqldestinatario);
       	aux=false;
       	return LstSairDocDestinatario;	
    	}else{
        	return null;
        }
	}

}
