package es.uma.informatica.jpa.proyect;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Actividad
 *
 */
@Entity

public class Actividad implements Serializable {

	   
	@Id @GeneratedValue
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date fecha_inicio;
	@Temporal(TemporalType.DATE)
	private Date fecha_fin;
	private String estado;
	private String tipo;
	private String lugar;
	
	@ManyToMany(mappedBy="actividades")
	private Collection<Alumno> alumnos;
	
	@ManyToOne
	@JoinColumn(name="Responsable_id")
	private Responsable_actividad responsable_actividad;
	
	@ManyToOne
	@JoinColumn(name="ONG_id")
	private ONG ong;
	
	@OneToMany(mappedBy="actividad")
	private Collection<Informe> informes;
	
	private static final long serialVersionUID = 1L;

	public Actividad() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Date getFecha_inicio() {
		return this.fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}   
	public Date getFecha_fin() {
		return this.fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}   
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}   
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}   
	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
   
}
