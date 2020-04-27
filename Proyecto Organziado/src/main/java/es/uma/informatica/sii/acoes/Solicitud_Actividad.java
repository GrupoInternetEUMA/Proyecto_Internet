package es.uma.informatica.sii.acoes;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Soicitud_Actividad
 *
 */
@Entity

public class Solicitud_Actividad implements Serializable {


	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String estado;
	@Temporal(TemporalType.DATE)
	private Date fecha_solicitud;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="Actividad_id")
	private Actividad actividad;

	@ManyToOne
	@JoinColumn(name="Usuario_id")
	private Usuario usuario;


	public Solicitud_Actividad() {
		super();
	}

	public Solicitud_Actividad(Integer id, String estado, Date fecha_solicitud) {
		this.id = id;
		this.estado = estado;
		this.fecha_solicitud = fecha_solicitud;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFecha_solicitud() {
		return this.fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
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
		Solicitud_Actividad other = (Solicitud_Actividad) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Solicitud_Actividad [id=" + id + ", estado=" + estado + ", actividad=" + actividad + ", usuario="
				+ usuario + "]";
	}
   
}
