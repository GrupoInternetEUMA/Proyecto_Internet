package es.uma.informatica.jpa.proyect;

import es.uma.informatica.jpa.proyect.Usuario;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Date;

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

	public Alumno(Integer id, Integer dni, String nombre, String apellidos, String estudios, String idioma, Date fecha_nacimiento, String email, String titulacion, Integer num_expediente) {
		super(id, dni, nombre, apellidos, estudios, idioma, fecha_nacimiento, email);
		this.titulacion = titulacion;
		this.num_expediente = num_expediente;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((num_expediente == null) ? 0 : num_expediente.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (num_expediente == null) {
			if (other.num_expediente != null)
				return false;
		} else if (!num_expediente.equals(other.num_expediente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alumno [titulacion=" + titulacion + ", num_expediente=" + num_expediente + ", getNombre()="
				+ getNombre() + ", getApellidos()=" + getApellidos() + "]";
	}
	   
}
