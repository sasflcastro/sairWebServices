package ec.com.rgt.sair.dao;

import java.util.List;
import ec.com.rgt.sair.controller.*;

@SuppressWarnings("rawtypes")
public class UsuariosDAO  extends DAO{
	
	String hqlUsuarios = "";
	BlowfishCipher Obj_Encripta = new BlowfishCipher();
	String Ls_ClaveEncriptada;
	
	 
	public List ListaUsuarios() {
		 hqlUsuarios = "from Usuarios";
	     return find(hqlUsuarios);
    }
	 
	 public List ConsultaUsuario(String IdUsuario) {
		 hqlUsuarios = "from Usuarios where idUsuario = '" + IdUsuario + "'";
	     return find(hqlUsuarios);
    }
	 
	 public List findUsuarios(String hqlUsuario) {
	     return find(hqlUsuario);
    }
	 
	/*Carlos Panta*/
	 public List findUsuariosAD(String hqlUsuarioAD) {
	     return find(hqlUsuarioAD);
    }
}
