
package es.uma.informatica.sii.acoes;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: usuario
 *
 */
@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )

public class Usuario implements Serializable {
	
	public enum Rol {
	      ADMINISTRADOR,
	      ONG,
	      RESPONSABLE,
	      ALUMNO
	    };


	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer dni; 
	private String nombre;
	private String apellidos;
	private String estudios;
	private String idioma;
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;
	@Column(nullable = false)
	private String email;
	private String contrasenia;
	@Enumerated(EnumType.STRING)
	private Rol rol;
	@Id
	private String usuario;

	@ManyToMany(mappedBy="usuarios")
	private Collection<Responsable_actividad> responsables;

	@OneToMany(mappedBy="usuario")
	private Collection<Informe> informes;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="Usuario")
	private Collection<Solicitud_Actividad> Solicitud_Actividad;

	public Usuario() {
		super();
	}
	
	public Usuario (String usuario, String contrasenia, Rol rol)
    {
        setUsuario(usuario);
        setContrasenia(contrasenia);
        setRol(rol);
    }

	public Usuario(Integer id, Integer dni, String nombre, String apellidos, String estudios, String idioma, Date fecha_nacimiento, String email, String contrasenia, Rol rol, String usuario) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.estudios = estudios;
		this.idioma = idioma;
		this.fecha_nacimiento = fecha_nacimiento;
		this.email = email;
		this.contrasenia = contrasenia;
		this.rol = rol;
		this.usuario = usuario;
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
	
	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + " usuario: " + usuario + " nombre=" + nombre + ", apellidos=" + apellidos + " rol: " + rol + ", estudios=" + estudios + "]";
	}

}
