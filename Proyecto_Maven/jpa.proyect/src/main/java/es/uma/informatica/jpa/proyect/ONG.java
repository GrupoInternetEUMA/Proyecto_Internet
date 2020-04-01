package es.uma.informatica.jpa.proyect;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ONG
 *
 */
@Entity
public class ONG implements Serializable {

	   
	@id @GeneratedValue
	private Integer id;
	private String nombre;
	private String descripcion;
	private String email;
	private Integer telefono;
	private String direccion;
	private String pais;
	private static final long serialVersionUID = 1L;

	public ONG() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}   
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}   
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
   
}
