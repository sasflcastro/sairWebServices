package ec.com.rgt.sair.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.UsuariosDAO;
import ec.com.rgt.sair.hbm.SairArea;
import ec.com.rgt.sair.hbm.SairDocCuentas;
import ec.com.rgt.sair.hbm.Usuarios;
import ec.com.rgt.sair.hbm.UsuariosAD;

@SuppressWarnings("unchecked")
public class OperacionesUsuario {
	
	DAO dao = new DAO();
	UsuariosDAO Obj_UsuariosDAO = new UsuariosDAO();
	//BlowfishCipher Obj_Cripta = new BlowfishCipher();
	
	public List<SairDocCuentas> getCuentas(String hql){
		return dao.find(hql);
	}
	
	public int guardarCuenta(SairDocCuentas cuentas){
		return dao.saveOrUpdate(cuentas, cuentas.getClass());
	}
	
	public int borrarCuentas(String hql){
		List<SairDocCuentas> cuentas= dao.find(hql);
		int res=0;
		if(cuentas!=null)
			for (SairDocCuentas sairDocCuentas : cuentas) {
				res=dao.delete(sairDocCuentas, sairDocCuentas.getClass());
			}
		return res;
	}
	
	public List<Usuarios> ListaUsuarios()  {
        List<Usuarios> LstUsuarios = new ArrayList<Usuarios>();
        LstUsuarios = Obj_UsuariosDAO.ListaUsuarios();
        return LstUsuarios;
    }
	
	public List<Usuarios> ConsultaUsuario(String IdUsuario)  {
        List<Usuarios> LstUsuarios = new ArrayList<Usuarios>();
        LstUsuarios = Obj_UsuariosDAO.ConsultaUsuario(IdUsuario);
        return LstUsuarios;
    }

	public List<Usuarios> findUsuarios(String hqlUsuarios) throws IllegalBlockSizeException, BadPaddingException, IOException  {
        List<Usuarios> LstUsuarios = new ArrayList<Usuarios>();
        List<Usuarios> LstUsuarios1 = new ArrayList<Usuarios>();
        LstUsuarios = Obj_UsuariosDAO.findUsuarios(hqlUsuarios);
        for (int i = 0; i < LstUsuarios.size(); i++) {
        	
        	Usuarios usuar = (Usuarios) LstUsuarios.get(i);
        	//usuar.setClave(Obj_Cripta.desencripta(usuar.getClave()));
        	//usuar.setClave(stripNonValidXMLCharacters(Obj_Cripta.desencripta(usuar.getClave())));
        	usuar.setClave(stripNonValidXMLCharacters(JBlowfish.decrypt(usuar.getClave())));
        	LstUsuarios1.add(usuar);
        	
        }
        return LstUsuarios;
	}
	
	public String stripNonValidXMLCharacters(String in) {
	    StringBuffer out = new StringBuffer(); // Used to hold the output.
	    char current; // Used to reference the current character.
	 
	    if (in == null || ("".equals(in))) return ""; // vacancy test.
	    for (int i = 0; i < in.length(); i++) {
	        current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught here; it should not happen.
	        if ((current == 0x9) ||
	            (current == 0xA) ||
	            (current == 0xD) ||
	            ((current >= 0x20) && (current <= 0xD7FF)) ||
	            ((current >= 0xE000) && (current <= 0xFFFD)) ||
	            ((current >= 0x10000) && (current <= 0x10FFFF)))
	            out.append(current);
	    }
	    return out.toString();
	}
		
	public List<Mensaje> IngresaUsuario(String IdUsuario, String Clave, String NombresCompletos, String UsuarioIngreso, String UsuarioModificacion, Date FechaIngreso, Date FechaBaja, String Estado, String Nombre, String Apellido, String Email1, String Email2, String firma,  String Codigo, String JefeInmediato, SairArea sairArea, String Cargo, String PrimerIngreso,  Date fechaExpiracionClave, BigDecimal numIntentos, int TipoTransc)  {
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
        Usuarios Obj_Usuario = new Usuarios();
        Obj_Usuario.setIdUsuario(IdUsuario);
        Obj_Usuario.setClave(JBlowfish.encrypt(Clave.trim()));
        Obj_Usuario.setNombresCompletos(NombresCompletos);
        Obj_Usuario.setUsuarioIngreso(UsuarioIngreso);
        Obj_Usuario.setUsuarioModificacion(UsuarioModificacion);
        Obj_Usuario.setFechaIngreso(FechaIngreso);
        Obj_Usuario.setFechaBaja(FechaBaja);
        Obj_Usuario.setEstado(Estado);
        Obj_Usuario.setNombre(Nombre);
        Obj_Usuario.setApellido(Apellido);
        Obj_Usuario.setEmail1(Email1);
        Obj_Usuario.setEmail2(Email2);
        Obj_Usuario.setFirma(firma);
        Obj_Usuario.setCodigo(Codigo);
        Obj_Usuario.setJefeInmediato(JefeInmediato);
        Obj_Usuario.setSairArea(sairArea);
        Obj_Usuario.setCargo(Cargo);
        Obj_Usuario.setPrimerIngreso(PrimerIngreso);
        Obj_Usuario.setFechaExpiracionClave(fechaExpiracionClave);
        Obj_Usuario.setNumIntentos(numIntentos);
        int estado = dao.saveOrUpdate(Obj_Usuario, Obj_Usuario.getClass());
        Mensaje Obj_Mensaje = new Mensaje();
        if (estado == 1) {
			Obj_Mensaje.setIdMensaje(1);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Ingreso Exitoso");

			} else {

				Obj_Mensaje.setMensaje("Actualizacion Exitosa");

			}

		} else {
			Obj_Mensaje.setIdMensaje(0);
			if (TipoTransc == 0) {

				Obj_Mensaje.setMensaje("Ingreso Fallido");

			} else {

				Obj_Mensaje.setMensaje("Actualizacion Fallida");

			}
		}
        LstMensaje.add(Obj_Mensaje);
        return LstMensaje;
    }
		/*
		 * *
		 * 
		 * *
		 */
	/*Carlos Panta*/
		/**
		 * 
		 * 
		 * 
		 */
	public List<UsuariosAD> FindUsuarioAD(String hqlInformes){
		List<UsuariosAD> listUsuariosAD = new ArrayList<UsuariosAD>();
		List<UsuariosAD> LstUsuarios1 = new ArrayList<UsuariosAD>();
		try{
		listUsuariosAD = Obj_UsuariosDAO.findUsuariosAD(hqlInformes);
		}catch(Exception e)
		{ }
		if(listUsuariosAD!=null)
	        for (int i = 0; i < listUsuariosAD.size(); i++) {
	        	
	        	UsuariosAD usuar = (UsuariosAD) listUsuariosAD.get(i);
	        	usuar.setNombresCompletos(stripNonValidXMLCharacters(usuar.getNombresCompletos()));
	        	LstUsuarios1.add(usuar);
	        	
	        }
        return LstUsuarios1;
		//return listUsuariosAD;
	}
		
	public List<Mensaje> SaveOrUpdateAD(UsuariosAD usuarioAD, int TipoTransc){
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		try{
        	int estado = dao.saveOrUpdate(usuarioAD, usuarioAD.getClass());
        	Mensaje Obj_Mensaje = new Mensaje();
	        if (estado == 1) {
				Obj_Mensaje.setIdMensaje(1);
				if (TipoTransc == 0) {
	
					Obj_Mensaje.setMensaje("Ingreso Exitoso");
					//System.out.println("Ingreso xq es: "+ TipoTransc);
	
				} else {
	
					Obj_Mensaje.setMensaje("Actualizacion Exitosa");
					//System.out.println("Actualizacion xq es: "+ TipoTransc);
	
				}
	
			} else {
				Obj_Mensaje.setIdMensaje(0);
				if (TipoTransc == 0) {
	
					Obj_Mensaje.setMensaje("Ingreso Fallido");
	
				} else {
	
					Obj_Mensaje.setMensaje("Actualizacion Fallida");
	
				}
			}
        LstMensaje.add(Obj_Mensaje);
        return LstMensaje;
		}catch(Exception e)
		{return LstMensaje;}
	}
	
	
	
}
