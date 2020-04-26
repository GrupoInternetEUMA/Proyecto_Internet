package es.uma.informatica.jpa.proyect;

import es.uma.informatica.jpa.proyect.Usuario;
import java.io.Serializable;
import java.lang.String;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: responsable
 *
 */
@Entity

public class Responsable_actividad extends Usuario implements Serializable {

	private String departamento;
	@ManyToMany
	private Collection<Usuario>usuarios;
	
	@OneToMany(mappedBy="responsable_actividad")
	private Collection<Actividad> actividades;
	private static final long serialVersionUID = 1L;

	public Responsable_actividad() {
		super();
	}

	public Responsable_actividad(Integer id, Integer dni, String nombre, String apellidos, String estudios, String idioma, Date fecha_nacimiento, String email, String password, String rol, String departamento) {
		super(id, dni, nombre, apellidos, estudios, idioma, fecha_nacimiento, email, password, rol);
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((actividades == null) ? 0 : actividades.hashCode());
		result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
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
		Responsable_actividad other = (Responsable_actividad) obj;
		if (actividades == null) {
			if (other.actividades != null)
				return false;
		} else if (!actividades.equals(other.actividades))
			return false;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Responsable_actividad [departamento=" + departamento + ", Id: " + getId() + ", Nombre: "
				+ getNombre() + ", Apellidos: " + getApellidos() + " Rol: " + getRol() + "]";
	}

}
