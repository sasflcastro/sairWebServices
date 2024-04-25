package ec.com.rgt.sair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import ec.com.rgt.sair.dao.DAO;
import ec.com.rgt.sair.dao.HistorialClaveDAO;
import ec.com.rgt.sair.hbm.HistoricoClaves;
import ec.com.rgt.sair.hbm.SairParametros;

public class OperacionesHistorialClave {
	DAO dao = new DAO();
	HistorialClaveDAO historialClaveDAO=new HistorialClaveDAO();
	//BlowfishCipher cifrado = new BlowfishCipher();
	
	
	@SuppressWarnings({ "rawtypes" })
	public String ValidaHistorialClave(String Clave,String idUsuario)throws Exception {
		String res=null;
		List Lsthistorial = historialClaveDAO.ConsultaHistorial(idUsuario);
		if(Lsthistorial.isEmpty()){
			
		}else{
			int tamano=Lsthistorial.size();
			int valida=ConsultaTamano();
			if(tamano>valida){
				tamano=valida;
			}else{
				
			}
		for(int i=0;i<tamano;i++){
			HistoricoClaves historicoClaves=new HistoricoClaves();
			historicoClaves=(HistoricoClaves) Lsthistorial.get(i);
			//if(historicoClaves.getClaveAnterior().equals(cifrado.encripta(Clave))){
			if(historicoClaves.getClaveAnterior().equals(JBlowfish.encrypt(Clave))){
				res="OK";i=tamano+1;
			}
		}
		}
		return res;
	}
	
	//consulta el tamano de validacion de las ultimas claves ingresadas
	@SuppressWarnings("rawtypes")
	public int ConsultaTamano(){
		List lista=dao.find("from SairParametros hc where hc.idParametro=61 and hc.estado='A'");
		int res=4;
		if(lista.size()>0){
			SairParametros claves=(SairParametros) lista.get(0);
			res=Integer.parseInt(claves.getValor());
		}
		return res;
	}
	

	@SuppressWarnings("unchecked")
	public List<HistoricoClaves> findHistorial(String HqlHistorial)
			throws Exception {
		List<HistoricoClaves> Lsthistorial = new ArrayList<HistoricoClaves>();
		Lsthistorial = historialClaveDAO.findHistorial(HqlHistorial);
		return Lsthistorial;
	}
	
	
	public List<Mensaje> IngresaHistorialClave(BigDecimal idHistorico,String idUsuario,String claveAnterior,String claveNueva,Date fechaCambio,String usuarioCambio,int TipoTransc){
		List<Mensaje> LstMensaje = new ArrayList<Mensaje>();
		HistoricoClaves historicoClaves=new HistoricoClaves();
		historicoClaves.setIdHistorico(idHistorico);
		historicoClaves.setIdUsuario(idUsuario);
		//historicoClaves.setClaveAnterior(cifrado.encripta(claveAnterior));
		//historicoClaves.setClaveNueva(cifrado.encripta(claveNueva));
		historicoClaves.setClaveAnterior(JBlowfish.encrypt(claveAnterior));
		historicoClaves.setClaveNueva(JBlowfish.encrypt(claveNueva));
		historicoClaves.setUsuarioCambio(usuarioCambio);
		historicoClaves.setFechaCambio(fechaCambio);
		int estado = dao.saveOrUpdate(historicoClaves,
				historicoClaves.getClass());
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

}
