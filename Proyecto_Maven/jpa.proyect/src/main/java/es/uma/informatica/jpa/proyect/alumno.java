package es.uma.informatica.jpa.proyect;

import es.uma.informatica.jpa.proyect.usuario;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: alumno
 *
 */
@Entity

public class alumno extends usuario implements Serializable {

	
	private String titulacion;
	@Column(nullable = false)
	private Integer num_expediente;
	private static final long serialVersionUID = 1L;

	public alumno() {
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
