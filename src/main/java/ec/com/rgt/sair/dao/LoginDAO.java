package ec.com.rgt.sair.dao;

import java.math.BigDecimal;
import java.util.List;

import ec.com.rgt.sair.controller.BlowfishCipher;
import ec.com.rgt.sair.controller.JBlowfish;


@SuppressWarnings("rawtypes")
public class LoginDAO extends DAO{

	//BlowfishCipher encripta = new BlowfishCipher();
	static String claveCifrada;
    static String sentencia7 = "from Usuarios u where u.idUsuario = ";
    static String hqlUsuarios;
	
	static String sentencia = "select gr.idGrupo from Grupos gr where gr.estado = 'A' and gr.idGrupo in (select g.id.idGrupo from GruposUsuarios g where g.id.idUsuario = ";
	static String sentencia1 = "select g.nombreGrupo from Grupos g where g.idGrupo = ";
	static String sentencia2 = "from Menues m where m.idMenu in (select g.id.idMenu from GruposMenu g where g.id.idGrupo = ";
	static String sentencia3 = "select g.idGrupo from Grupos g where g.nombreGrupo = ";
	static String sentencia4 = "from Permisos p where p.idPermiso in (select r.id.idPermiso from RolesPermisos r where r.id.idRol = (select g.id.idRol from GruposRoles g where g.id.idGrupo = ";
	static String sentencia5 = "select a.idAplicacion from Aplicaciones a where a.estado = 'A' and a.idAplicacion in (select g.id.idAplicacion from GruposAplicaciones g where g.id.idGrupo = ";
	static String sentencia6 = "from Usuarios u where u.idUsuario = ";
	static String hqlUsuariosGrupos = "";
	
	static String hqlLogin = "";
	BlowfishCipher Obj_Encripta = new BlowfishCipher();
	static String Ls_ClaveEncriptada;
	
	
	public List buscarGruposDeUsuario(String usuario, BigDecimal idAplicacion) {
        hqlUsuariosGrupos = sentencia + "'" + usuario.trim() + "' and g.id.idGrupo in (select ga.id.idGrupo from GruposAplicaciones ga where ga.id.idAplicacion = " + idAplicacion + " and ga.aplicaciones.estado = 'A')) order by estado";
        return find(hqlUsuariosGrupos);
    }

    public List obtenerNombreDeGrupo(BigDecimal idGrupo) {
        hqlUsuariosGrupos = sentencia1 + "" + idGrupo + " and g.estado = 'A'";
        return find(hqlUsuariosGrupos);
    }

    public List obtenerArbolMenu(BigDecimal idGrupo,BigDecimal idAplicacion) {
        hqlUsuariosGrupos = sentencia2 + "" + idGrupo + ") and m.estado = 'A' and m.idAplicacion="+idAplicacion+" order by m.orden";
        return find(hqlUsuariosGrupos);
    }

    public List obtenerIdGrupo(String nombreGrupo) {
        hqlUsuariosGrupos = sentencia3 + "'" + nombreGrupo.trim() + "' and g.estado = 'A'";
        return find(hqlUsuariosGrupos);
    }

    public List obtenerPermisos(BigDecimal idGrupo) {
        hqlUsuariosGrupos = sentencia4 + "" + idGrupo + ")) and p.estado = 'A'";
        return find(hqlUsuariosGrupos);
    }

    public List obtenerAplicacion(BigDecimal idGrupo) {
        hqlUsuariosGrupos = sentencia5 + "" + idGrupo+ " and g.aplicaciones.estado = 'A')";
        return find(hqlUsuariosGrupos);
    }
    
    public List obtenerAplicacion() {
        hqlUsuariosGrupos = "from Aplicaciones a where a.estado = 'A' order by a.descripcion desc";
        return find(hqlUsuariosGrupos);
    }

    public List obtenerIp(String idUsuario) {
        hqlUsuariosGrupos = sentencia6 + "'" + idUsuario.trim() + "' and u.ip is not null";
        return find(hqlUsuariosGrupos);
    }

    public List obtenerServPublico(String idUsuario) {
        hqlUsuariosGrupos = sentencia6 + "'" + idUsuario.trim() + "' and u.estado = 'A'";
        return find(hqlUsuariosGrupos);
    }
    
    public List validarUsuario(String usuario, String clave) {
        //claveCifrada = encripta.encripta(clave.trim());
        claveCifrada = JBlowfish.encrypt(clave.trim());
        hqlUsuarios = sentencia7 + "'" + usuario + "' and u.clave= '" + claveCifrada + "' and u.estado = 'A'";
        //System.out.println(clave+" "+hqlUsuarios);
        return find(hqlUsuarios);
    }
	
}
