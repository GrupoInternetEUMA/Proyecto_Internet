package Entidades;

import static Entidades.Usuario_.usuario;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ONG
 *
 */
@Entity

public class ONG extends Usuario implements Serializable {

    
    
    private String descripcion;
    private Integer telefono;
    private String direccion;
    private String pais;
    
    
    @OneToMany(mappedBy = "ong")
    private Collection<Actividad> actividades;

    private static final long serialVersionUID = 1L;

    public ONG(){
        super();
    }

    public ONG(String descripcion,Integer telefono, String direccion, String pais) {
        
        
        this.descripcion = descripcion;
        
        this.telefono = telefono;
        this.direccion = direccion;
        this.pais = pais;
        
    }

   

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.descripcion);
        hash = 61 * hash + Objects.hashCode(this.telefono);
        hash = 61 * hash + Objects.hashCode(this.direccion);
        hash = 61 * hash + Objects.hashCode(this.pais);
        hash = 61 * hash + Objects.hashCode(this.actividades);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ONG other = (ONG) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.actividades, other.actividades)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ONG{" + "descripcion=" + descripcion + ", telefono=" + telefono + ", direccion=" + direccion + ", pais=" + pais + ", actividades=" + actividades + '}';
    }

   
   
}
