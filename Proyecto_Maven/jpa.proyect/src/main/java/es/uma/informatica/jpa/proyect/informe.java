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
public class informe implements Serializable {

	   
	@id @GeneratedValue
	private Integer id;
	private String evaluacion;
	private String tiempo_empleado;
	private String tareas_realizadas;
	private static final long serialVersionUID = 1L;

	public informe() {
		super();
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
   
}
