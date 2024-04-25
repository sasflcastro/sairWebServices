package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

public class SairParPoliticas implements java.io.Serializable {
	private BigDecimal idPolitica;
	private String area;
	private String secuenciaDocumento;
	private String macroproceso;
	private String proceso;
	private String subproceso;
	private String asunto;
	private String estado;
	private String idonbase;
    private String url;
    private String nombreDocumento;

	public SairParPoliticas() {
		
	}

	public SairParPoliticas(BigDecimal idPolitica, String area, String secuenciaDocumento,
			String macroproceso, String proceso, String subproceso, String asunto, String estado
			,String idonbase,String url,String nombreDocumento) {
		this.idPolitica = idPolitica;
		this.area = area;
		this.secuenciaDocumento = secuenciaDocumento;
		this.macroproceso = macroproceso;
		this.proceso = proceso;
		this.subproceso = subproceso;
		this.asunto = asunto;
		this.estado = estado;
		this.idonbase = idonbase;
		this.url = url;
		this.nombreDocumento = nombreDocumento;
	}


	public SairParPoliticas(BigDecimal idPolitica, String area, String secuenciaDocumento,
			String macroproceso, String proceso, String subproceso, String asunto, String estado) {
		this.idPolitica = idPolitica;
		this.area = area;
		this.secuenciaDocumento = secuenciaDocumento;
		this.macroproceso = macroproceso;
		this.proceso = proceso;
		this.subproceso = subproceso;
		this.asunto = asunto;
		this.estado = estado;
	}
	
	public BigDecimal getIdPolitica() {
		return idPolitica;
	}

	public void setIdPolitica(BigDecimal idPolitica) {
		this.idPolitica = idPolitica;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSecuenciaDocumento() {
		return secuenciaDocumento;
	}

	public void setSecuenciaDocumento(String secuenciaDocumento) {
		this.secuenciaDocumento = secuenciaDocumento;
	}

	public String getMacroproceso() {
		return macroproceso;
	}

	public void setMacroproceso(String macroproceso) {
		this.macroproceso = macroproceso;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getSubproceso() {
		return subproceso;
	}

	public void setSubproceso(String subproceso) {
		this.subproceso = subproceso;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdonbase() {
		return idonbase;
	}

	public void setIdonbase(String idonbase) {
		this.idonbase = idonbase;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}
	
	
	
}
