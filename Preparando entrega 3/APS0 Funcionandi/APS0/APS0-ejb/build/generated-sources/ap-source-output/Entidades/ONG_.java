package Entidades;

import Entidades.Actividad;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-06-02T20:47:29")
=======
@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-06-02T19:51:00")
>>>>>>> 2356d023572e19f6a239d321f2feaf03e3e2584d
@StaticMetamodel(ONG.class)
public class ONG_ { 

    public static volatile SingularAttribute<ONG, String> descripcion;
    public static volatile SingularAttribute<ONG, String> direccion;
    public static volatile SingularAttribute<ONG, String> contrasenia;
    public static volatile SingularAttribute<ONG, Integer> id;
    public static volatile SingularAttribute<ONG, Integer> telefono;
    public static volatile CollectionAttribute<ONG, Actividad> actividades;
    public static volatile SingularAttribute<ONG, String> nombre;
    public static volatile SingularAttribute<ONG, String> email;
    public static volatile SingularAttribute<ONG, String> pais;

}