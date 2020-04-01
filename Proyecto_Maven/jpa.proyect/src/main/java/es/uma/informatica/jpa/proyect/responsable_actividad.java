package es.uma.informatica.jpa.proyect;

import es.uma.informatica.jpa.proyect.usuario;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: responsable
 *
 */
@Entity

public class responsable_actividad extends usuario implements Serializable {

	
	private String departamento;
	private static final long serialVersionUID = 1L;

	public responsable_actividad() {
		super();
	}   
	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
   
}
