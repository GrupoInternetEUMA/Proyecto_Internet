package Entidades;

import Entidades.Actividad;
import Entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-06-04T18:29:02")
@StaticMetamodel(Solicitud_Actividad.class)
public class Solicitud_Actividad_ { 

    public static volatile SingularAttribute<Solicitud_Actividad, String> estado;
    public static volatile SingularAttribute<Solicitud_Actividad, Usuario> usuario;
    public static volatile SingularAttribute<Solicitud_Actividad, Integer> id;
    public static volatile SingularAttribute<Solicitud_Actividad, Date> fecha_solicitud;
    public static volatile SingularAttribute<Solicitud_Actividad, Actividad> actividad;

}