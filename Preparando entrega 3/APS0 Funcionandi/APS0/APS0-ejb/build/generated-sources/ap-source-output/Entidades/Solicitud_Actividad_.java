package Entidades;

import Entidades.Actividad;
import Entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-06-02T20:47:29")
=======
@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-06-02T19:51:00")
>>>>>>> 2356d023572e19f6a239d321f2feaf03e3e2584d
@StaticMetamodel(Solicitud_Actividad.class)
public class Solicitud_Actividad_ { 

    public static volatile SingularAttribute<Solicitud_Actividad, String> estado;
    public static volatile SingularAttribute<Solicitud_Actividad, Usuario> usuario;
    public static volatile SingularAttribute<Solicitud_Actividad, Integer> id;
    public static volatile SingularAttribute<Solicitud_Actividad, Date> fecha_solicitud;
    public static volatile SingularAttribute<Solicitud_Actividad, Actividad> actividad;

}