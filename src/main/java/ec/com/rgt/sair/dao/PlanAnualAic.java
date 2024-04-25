package ec.com.rgt.sair.dao;

public class PlanAnualAic {
	
	private String unidadAic,orden, d_ejecutados1,d_ejecutados2,d_ejecutados3,d_ejecutados4, d_programados1,d_programados2,d_programados3,d_programados4;
	private String r_ejecutadas1,r_ejecutadas2,r_ejecutadas3,r_ejecutadas4,r_programada1,r_programada2,r_programada3,r_programada4;
	private String r_ejecutadas1E,r_ejecutadas2E,r_ejecutadas3E,r_ejecutadas4E;
	private String r_dee1,r_dee2,r_dee3,r_dee4,r_dee;
	private String porcentaje1,porcentaje2,porcentaje3,porcentaje4,r_porcentaje1,r_porcentaje2,r_porcentaje3,r_porcentaje4;
	private String r_ejecutada,r_ejecutadaE,r_programada,d_ejecutado,d_programado,r_porcentaje,porcentaje;
		
	public PlanAnualAic() {
	}
	
	public PlanAnualAic(String unidadAic, String orden, String d_ejecutados1,
			String d_ejecutados2, String d_ejecutados3, String d_ejecutados4,
			String d_programados1, String d_programados2,
			String d_programados3, String d_programados4, String r_ejecutadas1,
			String r_ejecutadas2, String r_ejecutadas3, String r_ejecutadas4,
			String r_programada1, String r_programada2, String r_programada3,
			String r_programada4, String r_ejecutadas1E, String r_ejecutadas2E,
			String r_ejecutadas3E, String r_ejecutadas4E, String r_dee1,
			String r_dee2, String r_dee3, String r_dee4, String r_dee, String porcentaje1,
			String porcentaje2, String porcentaje3, String porcentaje4,
			String r_porcentaje1, String r_porcentaje2, String r_porcentaje3,
			String r_porcentaje4, String r_ejecutada, String r_ejecutadaE,
			String r_programada, String d_ejecutado, String d_programado,
			String r_porcentaje, String porcentaje) {
		super();
		this.unidadAic = unidadAic;
		this.orden = orden;
		this.d_ejecutados1 = d_ejecutados1;
		this.d_ejecutados2 = d_ejecutados2;
		this.d_ejecutados3 = d_ejecutados3;
		this.d_ejecutados4 = d_ejecutados4;
		this.d_programados1 = d_programados1;
		this.d_programados2 = d_programados2;
		this.d_programados3 = d_programados3;
		this.d_programados4 = d_programados4;
		this.r_ejecutadas1 = r_ejecutadas1;
		this.r_ejecutadas2 = r_ejecutadas2;
		this.r_ejecutadas3 = r_ejecutadas3;
		this.r_ejecutadas4 = r_ejecutadas4;
		this.r_programada1 = r_programada1;
		this.r_programada2 = r_programada2;
		this.r_programada3 = r_programada3;
		this.r_programada4 = r_programada4;
		this.r_ejecutadas1E = r_ejecutadas1E;
		this.r_ejecutadas2E = r_ejecutadas2E;
		this.r_ejecutadas3E = r_ejecutadas3E;
		this.r_ejecutadas4E = r_ejecutadas4E;
		this.r_dee1 = r_dee1;
		this.r_dee2 = r_dee2;
		this.r_dee3 = r_dee3;
		this.r_dee4 = r_dee4;
		this.r_dee = r_dee;
		this.porcentaje1 = porcentaje1;
		this.porcentaje2 = porcentaje2;
		this.porcentaje3 = porcentaje3;
		this.porcentaje4 = porcentaje4;
		this.r_porcentaje1 = r_porcentaje1;
		this.r_porcentaje2 = r_porcentaje2;
		this.r_porcentaje3 = r_porcentaje3;
		this.r_porcentaje4 = r_porcentaje4;
		this.r_ejecutada = r_ejecutada;
		this.r_ejecutadaE = r_ejecutadaE;
		this.r_programada = r_programada;
		this.d_ejecutado = d_ejecutado;
		this.d_programado = d_programado;
		this.r_porcentaje = r_porcentaje;
		this.porcentaje = porcentaje;
	}


	public String getR_dee() {
		return r_dee;
	}

	public void setR_dee(String r_dee) {
		this.r_dee = r_dee;
	}

	public String getR_dee1() {
		return r_dee1;
	}

	public void setR_dee1(String r_dee1) {
		this.r_dee1 = r_dee1;
	}

	public String getR_dee2() {
		return r_dee2;
	}

	public void setR_dee2(String r_dee2) {
		this.r_dee2 = r_dee2;
	}

	public String getR_dee3() {
		return r_dee3;
	}

	public void setR_dee3(String r_dee3) {
		this.r_dee3 = r_dee3;
	}

	public String getR_dee4() {
		return r_dee4;
	}

	public void setR_dee4(String r_dee4) {
		this.r_dee4 = r_dee4;
	}

	public String getR_ejecutadas1E() {
		return r_ejecutadas1E;
	}

	public void setR_ejecutadas1E(String r_ejecutadas1E) {
		this.r_ejecutadas1E = r_ejecutadas1E;
	}

	public String getR_ejecutadas2E() {
		return r_ejecutadas2E;
	}

	public void setR_ejecutadas2E(String r_ejecutadas2E) {
		this.r_ejecutadas2E = r_ejecutadas2E;
	}

	public String getR_ejecutadas3E() {
		return r_ejecutadas3E;
	}

	public void setR_ejecutadas3E(String r_ejecutadas3E) {
		this.r_ejecutadas3E = r_ejecutadas3E;
	}

	public String getR_ejecutadas4E() {
		return r_ejecutadas4E;
	}

	public void setR_ejecutadas4E(String r_ejecutadas4E) {
		this.r_ejecutadas4E = r_ejecutadas4E;
	}

	public String getR_ejecutadaE() {
		return r_ejecutadaE;
	}

	public void setR_ejecutadaE(String r_ejecutadaE) {
		this.r_ejecutadaE = r_ejecutadaE;
	}

	public String getR_porcentaje1() {
		return r_porcentaje1;
	}


	public void setR_porcentaje1(String r_porcentaje1) {
		this.r_porcentaje1 = r_porcentaje1;
	}


	public String getR_porcentaje2() {
		return r_porcentaje2;
	}


	public void setR_porcentaje2(String r_porcentaje2) {
		this.r_porcentaje2 = r_porcentaje2;
	}


	public String getR_porcentaje3() {
		return r_porcentaje3;
	}


	public void setR_porcentaje3(String r_porcentaje3) {
		this.r_porcentaje3 = r_porcentaje3;
	}


	public String getR_porcentaje4() {
		return r_porcentaje4;
	}


	public void setR_porcentaje4(String r_porcentaje4) {
		this.r_porcentaje4 = r_porcentaje4;
	}


	public String getR_porcentaje() {
		return r_porcentaje;
	}



	public void setR_porcentaje(String r_porcentaje) {
		this.r_porcentaje = r_porcentaje;
	}



	public String getR_ejecutada() {
		return r_ejecutada;
	}



	public void setR_ejecutada(String r_ejecutada) {
		this.r_ejecutada = r_ejecutada;
	}



	public String getR_programada() {
		return r_programada;
	}



	public void setR_programada(String r_programada) {
		this.r_programada = r_programada;
	}



	public String getD_ejecutado() {
		return d_ejecutado;
	}



	public void setD_ejecutado(String d_ejecutado) {
		this.d_ejecutado = d_ejecutado;
	}



	public String getD_programado() {
		return d_programado;
	}



	public void setD_programado(String d_programado) {
		this.d_programado = d_programado;
	}



	public String getPorcentaje() {
		return porcentaje;
	}



	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}



	public String getOrden() {
		return orden;
	}


	public void setOrden(String orden) {
		this.orden = orden;
	}


	public String getUnidadAic() {
		return unidadAic;
	}


	public void setUnidadAic(String unidadAic) {
		this.unidadAic = unidadAic;
	}


	public String getD_ejecutados1() {
		return d_ejecutados1;
	}


	public void setD_ejecutados1(String d_ejecutados1) {
		this.d_ejecutados1 = d_ejecutados1;
	}


	public String getD_ejecutados2() {
		return d_ejecutados2;
	}


	public void setD_ejecutados2(String d_ejecutados2) {
		this.d_ejecutados2 = d_ejecutados2;
	}


	public String getD_ejecutados3() {
		return d_ejecutados3;
	}


	public void setD_ejecutados3(String d_ejecutados3) {
		this.d_ejecutados3 = d_ejecutados3;
	}


	public String getD_ejecutados4() {
		return d_ejecutados4;
	}


	public void setD_ejecutados4(String d_ejecutados4) {
		this.d_ejecutados4 = d_ejecutados4;
	}


	public String getD_programados1() {
		return d_programados1;
	}


	public void setD_programados1(String d_programados1) {
		this.d_programados1 = d_programados1;
	}


	public String getD_programados2() {
		return d_programados2;
	}


	public void setD_programados2(String d_programados2) {
		this.d_programados2 = d_programados2;
	}


	public String getD_programados3() {
		return d_programados3;
	}


	public void setD_programados3(String d_programados3) {
		this.d_programados3 = d_programados3;
	}


	public String getD_programados4() {
		return d_programados4;
	}


	public void setD_programados4(String d_programados4) {
		this.d_programados4 = d_programados4;
	}


	public String getR_ejecutadas1() {
		return r_ejecutadas1;
	}


	public void setR_ejecutadas1(String r_ejecutadas1) {
		this.r_ejecutadas1 = r_ejecutadas1;
	}


	public String getR_ejecutadas2() {
		return r_ejecutadas2;
	}


	public void setR_ejecutadas2(String r_ejecutadas2) {
		this.r_ejecutadas2 = r_ejecutadas2;
	}


	public String getR_ejecutadas3() {
		return r_ejecutadas3;
	}


	public void setR_ejecutadas3(String r_ejecutadas3) {
		this.r_ejecutadas3 = r_ejecutadas3;
	}


	public String getR_ejecutadas4() {
		return r_ejecutadas4;
	}


	public void setR_ejecutadas4(String r_ejecutadas4) {
		this.r_ejecutadas4 = r_ejecutadas4;
	}


	public String getR_programada1() {
		return r_programada1;
	}


	public void setR_programada1(String r_programada1) {
		this.r_programada1 = r_programada1;
	}


	public String getR_programada2() {
		return r_programada2;
	}


	public void setR_programada2(String r_programada2) {
		this.r_programada2 = r_programada2;
	}


	public String getR_programada3() {
		return r_programada3;
	}


	public void setR_programada3(String r_programada3) {
		this.r_programada3 = r_programada3;
	}


	public String getR_programada4() {
		return r_programada4;
	}


	public void setR_programada4(String r_programada4) {
		this.r_programada4 = r_programada4;
	}


	public String getPorcentaje1() {
		return porcentaje1;
	}


	public void setPorcentaje1(String porcentaje1) {
		this.porcentaje1 = porcentaje1;
	}


	public String getPorcentaje2() {
		return porcentaje2;
	}


	public void setPorcentaje2(String porcentaje2) {
		this.porcentaje2 = porcentaje2;
	}


	public String getPorcentaje3() {
		return porcentaje3;
	}


	public void setPorcentaje3(String porcentaje3) {
		this.porcentaje3 = porcentaje3;
	}


	public String getPorcentaje4() {
		return porcentaje4;
	}


	public void setPorcentaje4(String porcentaje4) {
		this.porcentaje4 = porcentaje4;
	}
	

}