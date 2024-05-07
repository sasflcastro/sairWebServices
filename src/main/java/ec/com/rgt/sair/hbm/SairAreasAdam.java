package ec.com.rgt.sair.hbm;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SairAreasAdam implements Serializable
{
	@SerializedName("area")
    private BigDecimal idDepartamento;
    @SerializedName("nombre")
    private String descripcion;
    private String codiAdam;
    private String estado;
    private String cuenta;
    private String inicial;
	@SerializedName("codigo_sf")
    private String codigosf;

    
    public SairAreasAdam() {
    }
    
    public SairAreasAdam(final BigDecimal idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public SairAreasAdam(final BigDecimal idDepartamento, final String descripcion, final String codiAdam, final String estado, final String cuenta, final String inicial,final String codigosf) {
        this.idDepartamento = idDepartamento;
        this.descripcion = descripcion;
        this.codiAdam = codiAdam;
        this.estado = estado;
        this.cuenta = cuenta;
        this.inicial = inicial;
        this.codigosf = codigosf;
    }
    
    public String getInicial() {
        return this.inicial;
    }
    
    public void setInicial(final String inicial) {
        this.inicial = inicial;
    }
    
    public BigDecimal getIdDepartamento() {
        return this.idDepartamento;
    }
    
    public void setIdDepartamento(final BigDecimal idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getCodiAdam() {
        return this.codiAdam;
    }
    
    public void setCodiAdam(final String codiAdam) {
        this.codiAdam = codiAdam;
    }
    
   
	public String getCodigosf() {
		return codigosf;
	}

	public void setCodigosf(String codigosf) {
		this.codigosf = codigosf;
	}

	public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(final String estado) {
        this.estado = estado;
    }
    
    public String getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(final String cuenta) {
        this.cuenta = cuenta;
    }
}


