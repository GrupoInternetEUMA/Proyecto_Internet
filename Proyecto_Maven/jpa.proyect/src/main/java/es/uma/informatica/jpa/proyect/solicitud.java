package es.uma.informatica.jpa.proyect;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: solicitud
 *
 */
@Entity

public class solicitud implements Serializable {

	   
	@Id @GeneratedValue
	private Integer id;
	private String descripcion;
	private Date fecha_solicitud;
	private static final long serialVersionUID = 1L;

	public solicitud() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public Date getFecha_solicitud() {
		return this.fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}
   
}
