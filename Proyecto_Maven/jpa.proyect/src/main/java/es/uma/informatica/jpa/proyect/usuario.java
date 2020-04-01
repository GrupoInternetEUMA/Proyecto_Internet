package es.uma.informatica.jpa.proyect;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: usuario
 *
 */
@Entity
public class usuario implements Serializable {

	@id @GeneratedValue
	private Integer id;
	private Integer dni; // hace falta ponerla como clave unica
	private String nombre;
	private String apellidos;
	private String estudios;
	private String idioma;
	private Date fecha_nacimiento;
	private String email;
	private static final long serialVersionUID = 1L;

	public usuario() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Integer getDni() {
		return this.dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}   
	public String getEstudios() {
		return this.estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}   
	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}   
	public Date getFecha_nacimiento() {
		return this.fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
}
