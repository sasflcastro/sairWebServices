
package ec.com.rgt.sair.hbm;

//Generated 17-jul-2013 9:02:10 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
* Menues generated by hbmjava
*/

/*@XmlSeeAlso(ec.com.rgt.sair.hbm.Menues.class)
 * @ManyToOne
@JoinColumn(name="menues")
@XmlTransient*/
@SuppressWarnings("serial")
public class Menues implements java.io.Serializable {

	private BigDecimal idMenu;
	private BigDecimal idMenuPadre,idAplicacion;
	private String descripcion;
	private String rutaAcceso;
	private BigDecimal orden;
	private String usuarioIngreso;
	private Date fechaInicio;
	private String usuarioModificacion;
	private Date fechaBaja;
	private String estado;


	public Menues() {
	}

	public Menues(BigDecimal idMenu, String descripcion, BigDecimal orden,
			String usuarioIngreso, Date fechaInicio, String estado,BigDecimal idAplicacion) {
		this.idMenu = idMenu;
		this.descripcion = descripcion;
		this.orden = orden;
		this.usuarioIngreso = usuarioIngreso;
		this.fechaInicio = fechaInicio;
		this.estado = estado;
		this.idAplicacion = idAplicacion;
	}

	public Menues(BigDecimal idMenu, BigDecimal idMenuPadre,
			String descripcion, String rutaAcceso, BigDecimal orden,
			String usuarioIngreso, Date fechaInicio,
			String usuarioModificacion, Date fechaBaja, String estado,BigDecimal idAplicacion) {
		this.idMenu = idMenu;
		this.idMenuPadre = idMenuPadre;
		this.descripcion = descripcion;
		this.rutaAcceso = rutaAcceso;
		this.orden = orden;
		this.usuarioIngreso = usuarioIngreso;
		this.fechaInicio = fechaInicio;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
		this.idAplicacion = idAplicacion;
	}

	public BigDecimal getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(BigDecimal idMenu) {
		this.idMenu = idMenu;
	}

	public BigDecimal getIdMenuPadre() {
		return this.idMenuPadre;
	}

	public void setIdMenuPadre(BigDecimal idMenuPadre) {
		this.idMenuPadre = idMenuPadre;
	}

	public BigDecimal getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(BigDecimal idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRutaAcceso() {
		return this.rutaAcceso;
	}

	public void setRutaAcceso(String rutaAcceso) {
		this.rutaAcceso = rutaAcceso;
	}

	public BigDecimal getOrden() {
		return this.orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	public String getUsuarioIngreso() {
		return this.usuarioIngreso;
	}

	public void setUsuarioIngreso(String usuarioIngreso) {
		this.usuarioIngreso = usuarioIngreso;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}

