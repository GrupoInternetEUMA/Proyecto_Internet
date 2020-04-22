package es.uma.informatica.jpa.proyect;

import es.uma.informatica.jpa.proyect.Usuario;
import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: responsable
 *
 */
@Entity

public class Responsable_actividad extends Usuario implements Serializable {

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((actividades == null) ? 0 : actividades.hashCode());
		result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
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
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

	private String departamento;
	
	@ManyToMany
	private Collection<Usuario> usuarios;
	
	@OneToMany(mappedBy="responsable_actividad")
	private Collection<Actividad> actividades;
	private static final long serialVersionUID = 1L;

	public Responsable_actividad() {
		super();
	}   
	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
   
}
