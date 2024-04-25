package ec.com.rgt.sair.hbm;

// Generated 23/10/2013 02:35:47 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SairParRutina generated by hbmjava
 */
@SuppressWarnings("serial")
public class SairParRutina implements java.io.Serializable {

	private BigDecimal idRutina;
	private SairParComentarioRutina sairParComentarioRutina;
	private SairTipoPlan sairTipoPlan;
	private SairParDeficiencia sairParDeficiencia;
	private SairPoliticaProcedimiento sairPoliticaProcedimiento;
	private SairArea sairArea;
	private SairFrecuencia sairFrecuencia;
	private SairParPeriodicidad sairPeriocidad;
	private String idResponsable,AreaEvaluada,idejecutor;
	private String nombre;
	private String procesosAmx;
	private BigDecimal mesInicio;
	private BigDecimal anio;
	private String amx;
	private String suspend;
	private String entregaPropuesta;
	private String codigoRutina;
	private BigDecimal tiempoLogistica;
	private BigDecimal tiempoAnalisis;
	private BigDecimal tiempoDepuracion;
	private BigDecimal tiempoSeguimiento;
	private String url;
	private BigDecimal codigo;
	private BigDecimal rutId;
	private String estado,revision,revision2;
	private String tipoRutina;
	private BigDecimal semana1;
	private BigDecimal semana2;
	private BigDecimal semana3;
	private BigDecimal semana4;
	private BigDecimal semanaEmitirse;
	private String codigoetica;

	public SairParRutina() {
	}

	public SairParRutina(BigDecimal idRutina) {
		this.idRutina = idRutina;
	}

	public SairParRutina(BigDecimal idRutina,
			SairParComentarioRutina sairParComentarioRutina,
			SairTipoPlan sairTipoPlan, SairParDeficiencia sairParDeficiencia,
			SairPoliticaProcedimiento sairPoliticaProcedimiento,
			SairArea sairArea, SairFrecuencia sairFrecuencia,SairParPeriodicidad sairPeriocidad,
			String idResponsable, String nombre, String procesosAmx,
			BigDecimal mesInicio, BigDecimal anio, String amx, String suspend,
			String entregaPropuesta, String codigoRutina,
			BigDecimal tiempoLogistica, BigDecimal tiempoAnalisis,
			BigDecimal tiempoDepuracion, BigDecimal tiempoSeguimiento,
			String url, BigDecimal codigo, BigDecimal rutId, String estado,String tipoRutina,
			BigDecimal semana1, BigDecimal semana2, BigDecimal semana3, 
			BigDecimal semana4, BigDecimal semanaEmitirse,String idejecutor,String AreaEvaluada,String revision,String revision2) {
		this.idRutina = idRutina;
		this.sairParComentarioRutina = sairParComentarioRutina;
		this.sairTipoPlan = sairTipoPlan;
		this.sairParDeficiencia = sairParDeficiencia;
		this.sairPoliticaProcedimiento = sairPoliticaProcedimiento;
		this.sairArea = sairArea;
		this.sairFrecuencia = sairFrecuencia;
		this.sairPeriocidad = sairPeriocidad;
		this.idResponsable = idResponsable;
		this.nombre = nombre;
		this.procesosAmx = procesosAmx;
		this.mesInicio = mesInicio;
		this.anio = anio;
		this.amx = amx;
		this.suspend = suspend;
		this.entregaPropuesta = entregaPropuesta;
		this.codigoRutina = codigoRutina;
		this.tiempoLogistica = tiempoLogistica;
		this.tiempoAnalisis = tiempoAnalisis;
		this.tiempoDepuracion = tiempoDepuracion;
		this.tiempoSeguimiento = tiempoSeguimiento;
		this.url = url;
		this.codigo = codigo;
		this.rutId = rutId;
		this.estado = estado;
		this.tipoRutina = tipoRutina;
		this.semana1 = semana1;
		this.semana2 = semana2;
		this.semana3 = semana3;
		this.semana4 = semana4;		
		this.semanaEmitirse = semanaEmitirse;
		this.idejecutor = idejecutor;
		this.AreaEvaluada = AreaEvaluada;
		this.revision = revision;
		this.revision2 = revision2;
	}
		

	public SairParRutina(BigDecimal idRutina,
			SairParComentarioRutina sairParComentarioRutina,
			SairTipoPlan sairTipoPlan, SairParDeficiencia sairParDeficiencia,
			SairPoliticaProcedimiento sairPoliticaProcedimiento,
			SairArea sairArea, SairFrecuencia sairFrecuencia,SairParPeriodicidad sairPeriocidad,
			String idResponsable, String nombre, String procesosAmx,
			BigDecimal mesInicio, BigDecimal anio, String amx, String suspend,
			String entregaPropuesta, String codigoRutina,
			BigDecimal tiempoLogistica, BigDecimal tiempoAnalisis,
			BigDecimal tiempoDepuracion, BigDecimal tiempoSeguimiento,
			String url, BigDecimal codigo, BigDecimal rutId, String estado,String tipoRutina,
			BigDecimal semana1, BigDecimal semana2, BigDecimal semana3, 
			BigDecimal semana4, BigDecimal semanaEmitirse,String idejecutor,String AreaEvaluada,String revision,String revision2,
			String codigoetica) {
		this.idRutina = idRutina;
		this.sairParComentarioRutina = sairParComentarioRutina;
		this.sairTipoPlan = sairTipoPlan;
		this.sairParDeficiencia = sairParDeficiencia;
		this.sairPoliticaProcedimiento = sairPoliticaProcedimiento;
		this.sairArea = sairArea;
		this.sairFrecuencia = sairFrecuencia;
		this.sairPeriocidad = sairPeriocidad;
		this.idResponsable = idResponsable;
		this.nombre = nombre;
		this.procesosAmx = procesosAmx;
		this.mesInicio = mesInicio;
		this.anio = anio;
		this.amx = amx;
		this.suspend = suspend;
		this.entregaPropuesta = entregaPropuesta;
		this.codigoRutina = codigoRutina;
		this.tiempoLogistica = tiempoLogistica;
		this.tiempoAnalisis = tiempoAnalisis;
		this.tiempoDepuracion = tiempoDepuracion;
		this.tiempoSeguimiento = tiempoSeguimiento;
		this.url = url;
		this.codigo = codigo;
		this.rutId = rutId;
		this.estado = estado;
		this.tipoRutina = tipoRutina;
		this.semana1 = semana1;
		this.semana2 = semana2;
		this.semana3 = semana3;
		this.semana4 = semana4;		
		this.semanaEmitirse = semanaEmitirse;
		this.idejecutor = idejecutor;
		this.AreaEvaluada = AreaEvaluada;
		this.revision = revision;
		this.revision2 = revision2;
		this.codigoetica = codigoetica;
	}
	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}
	
	public String getRevision2() {
		return revision2;
	}

	public void setRevision2(String revision2) {
		this.revision2 = revision2;
	}

	public SairParPeriodicidad getSairPeriocidad() {
		return sairPeriocidad;
	}

	public void setSairPeriocidad(SairParPeriodicidad sairPeriocidad) {
		this.sairPeriocidad = sairPeriocidad;
	}

	public String getAreaEvaluada() {
		return AreaEvaluada;
	}

	public void setAreaEvaluada(String areaEvaluada) {
		AreaEvaluada = areaEvaluada;
	}

	public String getIdejecutor() {
		return idejecutor;
	}

	public void setIdejecutor(String idejecutor) {
		this.idejecutor = idejecutor;
	}

	public BigDecimal getIdRutina() {
		return this.idRutina;
	}

	public void setIdRutina(BigDecimal idRutina) {
		this.idRutina = idRutina;
	}

	public SairParComentarioRutina getSairParComentarioRutina() {
		return this.sairParComentarioRutina;
	}

	public void setSairParComentarioRutina(
			SairParComentarioRutina sairParComentarioRutina) {
		this.sairParComentarioRutina = sairParComentarioRutina;
	}

	public SairTipoPlan getSairTipoPlan() {
		return this.sairTipoPlan;
	}

	public void setSairTipoPlan(SairTipoPlan sairTipoPlan) {
		this.sairTipoPlan = sairTipoPlan;
	}

	public SairParDeficiencia getSairParDeficiencia() {
		return this.sairParDeficiencia;
	}

	public void setSairParDeficiencia(SairParDeficiencia sairParDeficiencia) {
		this.sairParDeficiencia = sairParDeficiencia;
	}

	public SairPoliticaProcedimiento getSairPoliticaProcedimiento() {
		return this.sairPoliticaProcedimiento;
	}

	public void setSairPoliticaProcedimiento(
			SairPoliticaProcedimiento sairPoliticaProcedimiento) {
		this.sairPoliticaProcedimiento = sairPoliticaProcedimiento;
	}

	public SairArea getSairArea() {
		return this.sairArea;
	}

	public void setSairArea(SairArea sairArea) {
		this.sairArea = sairArea;
	}

	public SairFrecuencia getSairFrecuencia() {
		return this.sairFrecuencia;
	}

	public void setSairFrecuencia(SairFrecuencia sairFrecuencia) {
		this.sairFrecuencia = sairFrecuencia;
	}

	public String getIdResponsable() {
		return this.idResponsable;
	}

	public void setIdResponsable(String idResponsable) {
		this.idResponsable = idResponsable;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProcesosAmx() {
		return this.procesosAmx;
	}

	public void setProcesosAmx(String procesosAmx) {
		this.procesosAmx = procesosAmx;
	}

	public BigDecimal getMesInicio() {
		return this.mesInicio;
	}

	public void setMesInicio(BigDecimal mesInicio) {
		this.mesInicio = mesInicio;
	}

	public BigDecimal getAnio() {
		return this.anio;
	}

	public void setAnio(BigDecimal anio) {
		this.anio = anio;
	}

	public String getAmx() {
		return this.amx;
	}

	public void setAmx(String amx) {
		this.amx = amx;
	}

	public String getSuspend() {
		return this.suspend;
	}

	public void setSuspend(String suspend) {
		this.suspend = suspend;
	}

	public String getEntregaPropuesta() {
		return this.entregaPropuesta;
	}

	public void setEntregaPropuesta(String entregaPropuesta) {
		this.entregaPropuesta = entregaPropuesta;
	}

	public String getCodigoRutina() {
		return this.codigoRutina;
	}

	public void setCodigoRutina(String codigoRutina) {
		this.codigoRutina = codigoRutina;
	}

	public BigDecimal getTiempoLogistica() {
		return this.tiempoLogistica;
	}

	public void setTiempoLogistica(BigDecimal tiempoLogistica) {
		this.tiempoLogistica = tiempoLogistica;
	}

	public BigDecimal getTiempoAnalisis() {
		return this.tiempoAnalisis;
	}

	public void setTiempoAnalisis(BigDecimal tiempoAnalisis) {
		this.tiempoAnalisis = tiempoAnalisis;
	}

	public BigDecimal getTiempoDepuracion() {
		return this.tiempoDepuracion;
	}

	public void setTiempoDepuracion(BigDecimal tiempoDepuracion) {
		this.tiempoDepuracion = tiempoDepuracion;
	}

	public BigDecimal getTiempoSeguimiento() {
		return this.tiempoSeguimiento;
	}

	public void setTiempoSeguimiento(BigDecimal tiempoSeguimiento) {
		this.tiempoSeguimiento = tiempoSeguimiento;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BigDecimal getCodigo() {
		return this.codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getRutId() {
		return this.rutId;
	}

	public void setRutId(BigDecimal rutId) {
		this.rutId = rutId;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoRutina() {
		return this.tipoRutina;
	}

	public void setTipoRutina(String tipoRutina) {
		this.tipoRutina = tipoRutina;
	}
	
	public BigDecimal getSemana1() {
		return this.semana1;
	}

	public void setSemana1(BigDecimal semana1) {
		this.semana1 = semana1;
	}
	
	public BigDecimal getSemana2() {
		return this.semana2;
	}

	public void setSemana2(BigDecimal semana2) {
		this.semana2 = semana2;
	}
	
	public BigDecimal getSemana3() {
		return this.semana3;
	}

	public void setSemana3(BigDecimal semana3) {
		this.semana3 = semana3;
	}
	
	public BigDecimal getSemana4() {
		return this.semana4;
	}

	public void setSemana4(BigDecimal semana4) {
		this.semana4 = semana4;
	}
	
	public BigDecimal getSemanaEmitirse() {
		return this.semanaEmitirse;
	}

	public void setSemanaEmitirse(BigDecimal semanaEmitirse) {
		this.semanaEmitirse = semanaEmitirse;
	}

	
	public String getCodigoetica() {
		return codigoetica;
	}


	public void setCodigoetica(String codigoetica) {
		this.codigoetica = codigoetica;
	}
	
}