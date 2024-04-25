package ec.com.rgt.sair.hbm;

// Generated 16-ene-2015 10:22:34 by Hibernate Tools 3.4.0.CR1

/**
 * TblProceAmx generated by hbmjava
 */
public class TblProceAmx implements java.io.Serializable {

	private String id;
	private String codprocedimiento;
	private String procedimiento;
	private String fechainicioejecucion;
	private String fechafinejecucion;
	private String premisa;
	private String objetivo;
	private String rojo;
	private String unidadmedida;
	private String tamanomuestra;
	private String inconsistencia;
	private String porcConsistencia;
	private String impactoeconomico;
	private String valorrealproyectado;
	private String recuperableajustable;
	private String causaraiz;
	private String accionesdesolucion;
	private String fechacompromiso;
	private String responsablesolucion;
	private String estatus;
	private String observaciones;
	private String gerencia;
	private String director;
	private String direccion;

	public TblProceAmx() {
	}

	public TblProceAmx(String id) {
		this.id = id;
	}

	public TblProceAmx(String id, String codprocedimiento,
			String procedimiento, String fechainicioejecucion,
			String fechafinejecucion, String premisa, String objetivo,
			String rojo, String unidadmedida, String tamanomuestra,
			String inconsistencia, String porcConsistencia,
			String impactoeconomico, String valorrealproyectado,
			String recuperableajustable, String causaraiz,
			String accionesdesolucion, String fechacompromiso,
			String responsablesolucion, String estatus, String observaciones,
			String gerencia, String director, String direccion) {
		this.id = id;
		this.codprocedimiento = codprocedimiento;
		this.procedimiento = procedimiento;
		this.fechainicioejecucion = fechainicioejecucion;
		this.fechafinejecucion = fechafinejecucion;
		this.premisa = premisa;
		this.objetivo = objetivo;
		this.rojo = rojo;
		this.unidadmedida = unidadmedida;
		this.tamanomuestra = tamanomuestra;
		this.inconsistencia = inconsistencia;
		this.porcConsistencia = porcConsistencia;
		this.impactoeconomico = impactoeconomico;
		this.valorrealproyectado = valorrealproyectado;
		this.recuperableajustable = recuperableajustable;
		this.causaraiz = causaraiz;
		this.accionesdesolucion = accionesdesolucion;
		this.fechacompromiso = fechacompromiso;
		this.responsablesolucion = responsablesolucion;
		this.estatus = estatus;
		this.observaciones = observaciones;
		this.gerencia=gerencia;
		this.direccion=direccion;
		this.director=director;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodprocedimiento() {
		return this.codprocedimiento;
	}

	public void setCodprocedimiento(String codprocedimiento) {
		this.codprocedimiento = codprocedimiento;
	}

	public String getProcedimiento() {
		return this.procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getFechainicioejecucion() {
		return this.fechainicioejecucion;
	}

	public void setFechainicioejecucion(String fechainicioejecucion) {
		this.fechainicioejecucion = fechainicioejecucion;
	}

	public String getFechafinejecucion() {
		return this.fechafinejecucion;
	}

	public void setFechafinejecucion(String fechafinejecucion) {
		this.fechafinejecucion = fechafinejecucion;
	}

	public String getPremisa() {
		return this.premisa;
	}

	public void setPremisa(String premisa) {
		this.premisa = premisa;
	}

	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getRojo() {
		return this.rojo;
	}

	public void setRojo(String rojo) {
		this.rojo = rojo;
	}

	public String getUnidadmedida() {
		return this.unidadmedida;
	}

	public void setUnidadmedida(String unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	public String getTamanomuestra() {
		return this.tamanomuestra;
	}

	public void setTamanomuestra(String tamanomuestra) {
		this.tamanomuestra = tamanomuestra;
	}

	public String getInconsistencia() {
		return this.inconsistencia;
	}

	public void setInconsistencia(String inconsistencia) {
		this.inconsistencia = inconsistencia;
	}

	public String getPorcConsistencia() {
		return this.porcConsistencia;
	}

	public void setPorcConsistencia(String porcConsistencia) {
		this.porcConsistencia = porcConsistencia;
	}

	public String getImpactoeconomico() {
		return this.impactoeconomico;
	}

	public void setImpactoeconomico(String impactoeconomico) {
		this.impactoeconomico = impactoeconomico;
	}

	public String getValorrealproyectado() {
		return this.valorrealproyectado;
	}

	public void setValorrealproyectado(String valorrealproyectado) {
		this.valorrealproyectado = valorrealproyectado;
	}

	public String getRecuperableajustable() {
		return this.recuperableajustable;
	}

	public void setRecuperableajustable(String recuperableajustable) {
		this.recuperableajustable = recuperableajustable;
	}

	public String getCausaraiz() {
		return this.causaraiz;
	}

	public void setCausaraiz(String causaraiz) {
		this.causaraiz = causaraiz;
	}

	public String getAccionesdesolucion() {
		return this.accionesdesolucion;
	}

	public void setAccionesdesolucion(String accionesdesolucion) {
		this.accionesdesolucion = accionesdesolucion;
	}

	public String getFechacompromiso() {
		return this.fechacompromiso;
	}

	public void setFechacompromiso(String fechacompromiso) {
		this.fechacompromiso = fechacompromiso;
	}

	public String getResponsablesolucion() {
		return this.responsablesolucion;
	}

	public void setResponsablesolucion(String responsablesolucion) {
		this.responsablesolucion = responsablesolucion;
	}

	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public String getGerencia() {
		return this.gerencia;
	}

	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
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

}