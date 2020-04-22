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

public class Solicitud implements Serializable {

	   
	@Id @GeneratedValue
	private Integer id;
	private String descripcion;
	@Temporal(TemporalType.DATE)
	private Date fecha_solicitud;
	
	
	@ManyToOne
	@JoinColumn(name="Responsable_id")
	private Responsable_actividad responsable_actividad;
	
	@ManyToOne
	@JoinColumn(name="ONG_id")
	private ONG ong;
	
	private static final long serialVersionUID = 1L;

	public Solicitud() {
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
