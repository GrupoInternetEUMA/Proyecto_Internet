package es.uma.informatica.jpa.proyect;

import es.uma.informatica.jpa.proyect.Usuario;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: alumno
 *
 */
@Entity

public class Alumno extends Usuario implements Serializable {

	
	private String titulacion;
	@Column(nullable = false)
	private Integer num_expediente;
	
	
	private static final long serialVersionUID = 1L;

	public Alumno() {
		super();
	}   
	public String getTitulacion() {
		return this.titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}   
	public Integer getNum_expediente() {
		return this.num_expediente;
	}

	public void setNum_expediente(Integer num_expediente) {
		this.num_expediente = num_expediente;
	}
   
}
