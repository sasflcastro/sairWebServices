package ec.com.rgt.sair.hbm;

// Generated 16-ene-2015 10:22:34 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TblProceAmxEnvia generated by hbmjava
 */
public class TblProceAmxEnvia implements java.io.Serializable {

	private String id;
	private String tipo;
	private String usuario;
	private String numcaptura;
	private String numincidencia;
	private String numac;
	private String operadora;
	private Date fechaprocedimiento;
	private String procedimiento;
	private String proceso;
	private String subproceso;
	private String unidadmuestra;
	private String muestradefinida;
	private String muestrarevisada;
	private String inconsistencias;
	private String rangomuestra;
	private String otro;
	private Date fechainicio;
	private Date fechafin;
	private String incidencia;
	private String problematica;
	private String causa;
	private String tipoimpacto;
	private String impactonegativo;
	private String accioncorrectiva;
	private String gerencia;
	private String gerente;
	private String direccion;
	private String director;
	private Date fechasolucion;
	private String estatus;
	private String impactopositivoac;

	public TblProceAmxEnvia() {
	}

	public TblProceAmxEnvia(String id) {
		this.id = id;
	}

	public TblProceAmxEnvia(String id, String tipo, String usuario,
			String numcaptura, String numincidencia, String numac,
			String operadora, Date fechaprocedimiento, String procedimiento,
			String proceso, String subproceso, String unidadmuestra,
			String muestradefinida, String muestrarevisada,
			String inconsistencias, String rangomuestra, String otro,
			Date fechainicio, Date fechafin, String incidencia,
			String problematica, String causa, String tipoimpacto,
			String impactonegativo, String accioncorrectiva, String gerencia,
			String gerente, String direccion, String director,
			Date fechasolucion, String estatus, String impactopositivoac) {
		this.id = id;
		this.tipo = tipo;
		this.usuario = usuario;
		this.numcaptura = numcaptura;
		this.numincidencia = numincidencia;
		this.numac = numac;
		this.operadora = operadora;
		this.fechaprocedimiento = fechaprocedimiento;
		this.procedimiento = procedimiento;
		this.proceso = proceso;
		this.subproceso = subproceso;
		this.unidadmuestra = unidadmuestra;
		this.muestradefinida = muestradefinida;
		this.muestrarevisada = muestrarevisada;
		this.inconsistencias = inconsistencias;
		this.rangomuestra = rangomuestra;
		this.otro = otro;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.incidencia = incidencia;
		this.problematica = problematica;
		this.causa = causa;
		this.tipoimpacto = tipoimpacto;
		this.impactonegativo = impactonegativo;
		this.accioncorrectiva = accioncorrectiva;
		this.gerencia = gerencia;
		this.gerente = gerente;
		this.direccion = direccion;
		this.director = director;
		this.fechasolucion = fechasolucion;
		this.estatus = estatus;
		this.impactopositivoac = impactopositivoac;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNumcaptura() {
		return this.numcaptura;
	}

	public void setNumcaptura(String numcaptura) {
		this.numcaptura = numcaptura;
	}

	public String getNumincidencia() {
		return this.numincidencia;
	}

	public void setNumincidencia(String numincidencia) {
		this.numincidencia = numincidencia;
	}

	public String getNumac() {
		return this.numac;
	}

	public void setNumac(String numac) {
		this.numac = numac;
	}

	public String getOperadora() {
		return this.operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public Date getFechaprocedimiento() {
		return this.fechaprocedimiento;
	}

	public void setFechaprocedimiento(Date fechaprocedimiento) {
		this.fechaprocedimiento = fechaprocedimiento;
	}

	public String getProcedimiento() {
		return this.procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getProceso() {
		return this.proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getSubproceso() {
		return this.subproceso;
	}

	public void setSubproceso(String subproceso) {
		this.subproceso = subproceso;
	}

	public String getUnidadmuestra() {
		return this.unidadmuestra;
	}

	public void setUnidadmuestra(String unidadmuestra) {
		this.unidadmuestra = unidadmuestra;
	}

	public String getMuestradefinida() {
		return this.muestradefinida;
	}

	public void setMuestradefinida(String muestradefinida) {
		this.muestradefinida = muestradefinida;
	}

	public String getMuestrarevisada() {
		return this.muestrarevisada;
	}

	public void setMuestrarevisada(String muestrarevisada) {
		this.muestrarevisada = muestrarevisada;
	}

	public String getInconsistencias() {
		return this.inconsistencias;
	}

	public void setInconsistencias(String inconsistencias) {
		this.inconsistencias = inconsistencias;
	}

	public String getRangomuestra() {
		return this.rangomuestra;
	}

	public void setRangomuestra(String rangomuestra) {
		this.rangomuestra = rangomuestra;
	}

	public String getOtro() {
		return this.otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getIncidencia() {
		return this.incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}

	public String getProblematica() {
		return this.problematica;
	}

	public void setProblematica(String problematica) {
		this.problematica = problematica;
	}

	public String getCausa() {
		return this.causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getTipoimpacto() {
		return this.tipoimpacto;
	}

	public void setTipoimpacto(String tipoimpacto) {
		this.tipoimpacto = tipoimpacto;
	}

	public String getImpactonegativo() {
		return this.impactonegativo;
	}

	public void setImpactonegativo(String impactonegativo) {
		this.impactonegativo = impactonegativo;
	}

	public String getAccioncorrectiva() {
		return this.accioncorrectiva;
	}

	public void setAccioncorrectiva(String accioncorrectiva) {
		this.accioncorrectiva = accioncorrectiva;
	}

	public String getGerencia() {
		return this.gerencia;
	}

	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}

	public String getGerente() {
		return this.gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Date getFechasolucion() {
		return this.fechasolucion;
	}

	public void setFechasolucion(Date fechasolucion) {
		this.fechasolucion = fechasolucion;
	}

	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getImpactopositivoac() {
		return this.impactopositivoac;
	}

	public void setImpactopositivoac(String impactopositivoac) {
		this.impactopositivoac = impactopositivoac;
	}

}
