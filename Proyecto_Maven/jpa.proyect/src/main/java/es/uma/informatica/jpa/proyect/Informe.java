package es.uma.informatica.jpa.proyect;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: informe
 *
 */
@Entity

public class Informe implements Serializable {


	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String evaluacion;
	private String tiempo_empleado;
	private String tareas_realizadas;
	
	@ManyToOne
	@JoinColumn(name="Actividad_id")
	private Actividad actividad;
	
	@ManyToOne
	@JoinColumn(name="Usuario_id")
	private Usuario usuario;
	
	private static final long serialVersionUID = 1L;

	public Informe() {
		super();
	}   
	
	public Informe(Integer id, String evaluacion, String tiempo_empleado, String tareas_realizacas) {
		this.id = id;
		this.evaluacion = evaluacion;
		this.tiempo_empleado = tiempo_empleado;
		this.tareas_realizadas = tareas_realizadas;
	}
	
	@Override
	public String toString() {
		return "Informe [id=" + id + ", evaluacion=" + evaluacion + ", actividad=" + actividad + ", usuario=" + usuario
				+ "]";
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getEvaluacion() {
		return this.evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}   
	public String getTiempo_empleado() {
		return this.tiempo_empleado;
	}

	public void setTiempo_empleado(String tiempo_empleado) {
		this.tiempo_empleado = tiempo_empleado;
	}   
	public String getTareas_realizadas() {
		return this.tareas_realizadas;
	}

	public void setTareas_realizadas(String tareas_realizadas) {
		this.tareas_realizadas = tareas_realizadas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Informe other = (Informe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
   
}
