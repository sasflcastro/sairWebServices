package ec.com.rgt.sair.hbm;
import java.io.Serializable;
import java.util.Date;

public class Reportexls  implements Serializable {

		private static final long serialVersionUID = 1L;

		public String id_det_novedades_turnos;

		public int mes;

		public String anio;

		public String cedula;

		public String claseNovedad;
		
		public String tipoNovedadId;
		
		public String cacsNovedades;
		
		public String novedadId;
		
		public Date fechaInicio;

		public Date fechaFin;
		
		public String observacion;

		public String usuarioIngreso;
		
		public Date fechaIngreso;
		
		public String usuarioModificacion;
		
		public Date fechaModificacion;
		
		public String item;

		public String estado;
		
		public int numcolumnas;
		
		public int numcargo;
		
		public int numper;
		
		public String descripnov;
		
		private String tipoNovedad;
		
		public Date primerD;

		private Date segundoD;

		private Date terceroD;

		private Date cuartoD;

		private Date quintoD;

		private Date sextoD;

		private Date septimoD;

		private Date octavoD;

		private Date novenoD;

		private Date decimoD;
		
		private String turnosp;
		
		private String ciudad;
		
		private String nombre;
		
		private String cac;
		
		private String cacId;
		
		private String cedulac;
		
		private int contnovedad;
		
		private String cacregion;

		private String caczona;

		private String cacciudad;

		private int artificionov;

		private String tipodecac;

		public String dat1;

		public String dat2;

		public String dat3;

		public String dat4;

		public String dat5;

		
		public String dat6;

		public String dat7;

		public String dat8;

		public String dat9;

		public String dat10;
		public String dat11;
		public String dat12;
		public String dat13;
		public String dat14;
		public String dat15;
		public String dat16;
		
		public double numjor1;
		
		public double numjor2;

		public int numjor3;
		
		public int numjor4;

		public int numjor5;
		
		public int numjor6;

		public double numjor7;
		
		public double numjor8;

		public Reportexls() {
			
		}


		public String getId_det_novedades_turnos() {
			return id_det_novedades_turnos;
		}


		public Reportexls(int mes, String anio, String cedula, String tipoNovedadId,
				 String novedadId, Date fechaInicio, Date fechaFin, String observacion,
				String usuarioIngreso, String item, int artificionov) {
			super();
			this.mes = mes;
			this.anio = anio;
			this.cedula = cedula;
			this.tipoNovedadId = tipoNovedadId;
			this.novedadId = novedadId;
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
			this.observacion = observacion;
			this.usuarioIngreso = usuarioIngreso;
			this.item = item;
			this.artificionov = artificionov;
		}


		
		


		public Reportexls(int numcolumnas) {
			super();
			this.numcolumnas = numcolumnas;
		}


		public Reportexls(int mes, String anio, String cedula, String tipoNovedadId, String novedadId,
				Date fechaInicio, Date fechaFin, String observacion, String usuarioIngreso, String item, Date segundoD,
				int artificionov ,Date terceroD, Date cuartoD, Date quintoD, Date sextoD, Date septimoD, Date octavoD, Date novenoD,
				Date decimoD) {
			super();
			this.mes = mes;
			this.anio = anio;
			this.cedula = cedula;
			this.tipoNovedadId = tipoNovedadId;
			this.novedadId = novedadId;
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
			this.observacion = observacion;
			this.usuarioIngreso = usuarioIngreso;
			this.item = item;
			this.artificionov = artificionov;
			this.segundoD = segundoD;
			this.terceroD = terceroD;
			this.cuartoD = cuartoD;
			this.quintoD = quintoD;
			this.sextoD = sextoD;
			this.septimoD = septimoD;
			this.octavoD = octavoD;
			this.novenoD = novenoD;
			this.decimoD = decimoD;
		}


		public Date getTerceroD() {
			return terceroD;
		}


		public void setTerceroD(Date terceroD) {
			this.terceroD = terceroD;
		}


		public Date getCuartoD() {
			return cuartoD;
		}


		public void setCuartoD(Date cuartoD) {
			this.cuartoD = cuartoD;
		}


		public Date getQuintoD() {
			return quintoD;
		}


		public void setQuintoD(Date quintoD) {
			this.quintoD = quintoD;
		}


		public Date getSextoD() {
			return sextoD;
		}


		public void setSextoD(Date sextoD) {
			this.sextoD = sextoD;
		}


		public Date getSeptimoD() {
			return septimoD;
		}


		public void setSeptimoD(Date septimoD) {
			this.septimoD = septimoD;
		}


		public Date getOctavoD() {
			return octavoD;
		}


		public void setOctavoD(Date octavoD) {
			this.octavoD = octavoD;
		}


		public Date getNovenoD() {
			return novenoD;
		}


		public void setNovenoD(Date novenoD) {
			this.novenoD = novenoD;
		}


		public Date getDecimoD() {
			return decimoD;
		}


		public void setDecimoD(Date decimoD) {
			this.decimoD = decimoD;
		}


		public void setId_det_novedades_turnos(String id_det_novedades_turnos) {
			this.id_det_novedades_turnos = id_det_novedades_turnos;
		}


		public int getMes() {
			return mes;
		}


		public void setMes(int mes) {
			this.mes = mes;
		}


		public String getAnio() {
			return anio;
		}

		public void setAnio(String anio) {
			this.anio = anio;
		}

		public String getCedula() {
			return cedula;
		}

		public void setCedula(String cedula) {
			this.cedula = cedula;
		}

		public String getClaseNovedad() {
			return claseNovedad;
		}

		public void setClaseNovedad(String claseNovedad) {
			this.claseNovedad = claseNovedad;
		}

		public String getTipoNovedadId() {
			return tipoNovedadId;
		}

		public void setTipoNovedadId(String tipoNovedadId) {
			this.tipoNovedadId = tipoNovedadId;
		}

		public String getCacsNovedades() {
			return cacsNovedades;
		}

		public void setCacsNovedades(String cacsNovedades) {
			this.cacsNovedades = cacsNovedades;
		}

		public String getNovedadId() {
			return novedadId;
		}

		public void setNovedadId(String novedadId) {
			this.novedadId = novedadId;
		}

		public Date getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(Date fechaInicio) {
			this.fechaInicio = fechaInicio;
		}

		public Date getFechaFin() {
			return fechaFin;
		}

		public void setFechaFin(Date fechaFin) {
			this.fechaFin = fechaFin;
		}

		public String getObservacion() {
			return observacion;
		}

		public void setObservacion(String observacion) {
			this.observacion = observacion;
		}

		public String getUsuarioIngreso() {
			return usuarioIngreso;
		}

		public void setUsuarioIngreso(String usuarioIngreso) {
			this.usuarioIngreso = usuarioIngreso;
		}

		public Date getFechaIngreso() {
			return fechaIngreso;
		}

		public void setFechaIngreso(Date fechaIngreso) {
			this.fechaIngreso = fechaIngreso;
		}

		public String getUsuarioModificacion() {
			return usuarioModificacion;
		}

		public void setUsuarioModificacion(String usuarioModificacion) {
			this.usuarioModificacion = usuarioModificacion;
		}

		public Date getFechaModificacion() {
			return fechaModificacion;
		}

		public void setFechaModificacion(Date fechaModificacion) {
			this.fechaModificacion = fechaModificacion;
		}

		public String getItem() {
			return item;
		}

		public void setItem(String item) {
			this.item = item;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}


		public int getNumcolumnas() {
			return numcolumnas;
		}


		public void setNumcolumnas(int numcolumnas) {
			this.numcolumnas = numcolumnas;
		}


		public int getNumcargo() {
			return numcargo;
		}


		public void setNumcargo(int numcargo) {
			this.numcargo = numcargo;
		}


		public int getNumper() {
			return numper;
		}


		public void setNumper(int numper) {
			this.numper = numper;
		}


		public String getDescripnov() {
			return descripnov;
		}


		public void setDescripnov(String descripnov) {
			this.descripnov = descripnov;
		}


		public String getTipoNovedad() {
			return tipoNovedad;
		}


		public void setTipoNovedad(String tipoNovedad) {
			this.tipoNovedad = tipoNovedad;
		}


		public Date getPrimerD() {
			return primerD;
		}


		public void setPrimerD(Date primerD) {
			this.primerD = primerD;
		}


		public Date getSegundoD() {
			return segundoD;
		}


		public void setSegundoD(Date segundoD) {
			this.segundoD = segundoD;
		}


		public String getTurnosp() {
			return turnosp;
		}


		public void setTurnosp(String turnosp) {
			this.turnosp = turnosp;
		}


		
		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}

		

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getCac() {
			return cac;
		}

		public void setCac(String cac) {
			this.cac = cac;
		}

		public int getContnovedad() {
			return contnovedad;
		}

		public void setContnovedad(int contnovedad) {
			this.contnovedad = contnovedad;
		}

		public String getCedulac() {
			return cedulac;
		}

		public void setCedulac(String cedulac) {
			this.cedulac = cedulac;
		}

		public String getCacregion() {
			return cacregion;
		}

		public void setCacregion(String cacregion) {
			this.cacregion = cacregion;
		}

		public String getCaczona() {
			return caczona;
		}

		public void setCaczona(String caczona) {
			this.caczona = caczona;
		}

		public String getCacciudad() {
			return cacciudad;
		}

		public void setCacciudad(String cacciudad) {
			this.cacciudad = cacciudad;
		}


		public int getArtificionov() {
			return artificionov;
		}


		public void setArtificionov(int artificionov) {
			this.artificionov = artificionov;
		}


		public String getTipodecac() {
			return tipodecac;
		}


		public void setTipodecac(String tipodecac) {
			this.tipodecac = tipodecac;
		}


		public String getCacId() {
			return cacId;
		}


		public void setCacId(String cacId) {
			this.cacId = cacId;
		}


		public String getDat1() {
			return dat1;
		}


		public void setDat1(String dat1) {
			this.dat1 = dat1;
		}


		public String getDat2() {
			return dat2;
		}


		public void setDat2(String dat2) {
			this.dat2 = dat2;
		}


		public String getDat3() {
			return dat3;
		}


		public void setDat3(String dat3) {
			this.dat3 = dat3;
		}


		public String getDat4() {
			return dat4;
		}


		public void setDat4(String dat4) {
			this.dat4 = dat4;
		}


		public String getDat5() {
			return dat5;
		}


		public void setDat5(String dat5) {
			this.dat5 = dat5;
		}


		public String getDat6() {
			return dat6;
		}


		public void setDat6(String dat6) {
			this.dat6 = dat6;
		}


		public String getDat7() {
			return dat7;
		}


		public void setDat7(String dat7) {
			this.dat7 = dat7;
		}


		public String getDat8() {
			return dat8;
		}


		public void setDat8(String dat8) {
			this.dat8 = dat8;
		}


		public String getDat9() {
			return dat9;
		}


		public void setDat9(String dat9) {
			this.dat9 = dat9;
		}


		public String getDat10() {
			return dat10;
		}


		public void setDat10(String dat10) {
			this.dat10 = dat10;
		}

		public String getDat11() {
			return dat11;
		}

		public void setDat11(String dat11) {
			this.dat11 = dat11;
		}

		public String getDat12() {
			return dat12;
		}

		public void setDat12(String dat12) {
			this.dat12 = dat12;
		}

		public String getDat13() {
			return dat13;
		}

		public void setDat13(String dat13) {
			this.dat13 = dat13;
		}

		public String getDat14() {
			return dat14;
		}

		public void setDat14(String dat14) {
			this.dat14 = dat14;
		}

		public String getDat15() {
			return dat15;
		}

		public void setDat15(String dat15) {
			this.dat15 = dat15;
		}

		public String getDat16() {
			return dat16;
		}

		public void setDat16(String dat16) {
			this.dat16 = dat16;
		}
		public double getNumjor1() {
			return numjor1;
		}


		public void setNumjor1(double numjor1) {
			this.numjor1 = numjor1;
		}


		public double getNumjor2() {
			return numjor2;
		}


		public void setNumjor2(double numjor2) {
			this.numjor2 = numjor2;
		}


		public int getNumjor3() {
			return numjor3;
		}


		public void setNumjor3(int numjor3) {
			this.numjor3 = numjor3;
		}


		public int getNumjor4() {
			return numjor4;
		}


		public void setNumjor4(int numjor4) {
			this.numjor4 = numjor4;
		}


		public int getNumjor5() {
			return numjor5;
		}


		public void setNumjor5(int numjor5) {
			this.numjor5 = numjor5;
		}


		public int getNumjor6() {
			return numjor6;
		}


		public void setNumjor6(int numjor6) {
			this.numjor6 = numjor6;
		}


		public double getNumjor7() {
			return numjor7;
		}


		public void setNumjor7(double numjor7) {
			this.numjor7 = numjor7;
		}


		public double getNumjor8() {
			return numjor8;
		}


		public void setNumjor8(double numjor8) {
			this.numjor8 = numjor8;
		}
		

	}



