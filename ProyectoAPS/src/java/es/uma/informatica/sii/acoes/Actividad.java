
package es.uma.informatica.sii.acoes;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Actividad
 *
 */
@Entity

public class Actividad implements Serializable {



	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private String descripcion;
	@Temporal(TemporalType.DATE)
	private Date fecha_inicio;
	@Temporal(TemporalType.DATE)
	private Date fecha_fin;
	private String estado;
	private String tipo;
	private String lugar;

	@ManyToOne
	@JoinColumn(name="Responsable_id")
	private Responsable_actividad responsable_actividad;

	@ManyToOne
	@JoinColumn(name="ONG_id")
	private ONG ong;

	@OneToMany(mappedBy="actividad")
	private Collection<Solicitud_Actividad> solicitud_Actividad;

	@OneToMany(mappedBy="actividad")
	private Collection<Informe> informes;

	private static final long serialVersionUID = 1L;

	public Actividad() {
		super();
	}

	public Actividad (Integer id, String nombre ,String descripcion, Date fecha_inicio, Date fecha_fin, String estado, String tipo, String lugar) {
		this.id = id;
                this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.estado = estado;
		this.tipo = tipo;
		this.lugar = lugar;
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

	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_inicio() {
		return this.fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return this.fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Actividad other = (Actividad) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Actividad [id=" + id + ", nombre=" + nombre + ", estado=" + estado + ", tipo=" + tipo + "]";
	}



}
