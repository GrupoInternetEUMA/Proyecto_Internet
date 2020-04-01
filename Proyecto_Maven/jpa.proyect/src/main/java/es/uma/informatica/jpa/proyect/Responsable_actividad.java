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
