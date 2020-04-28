package es.uma.informatica.sii.acoes;

import es.uma.informatica.sii.acoes.Actividad;
import es.uma.informatica.sii.acoes.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-28T16:46:51")
@StaticMetamodel(Solicitud_Actividad.class)
public class Solicitud_Actividad_ { 

    public static volatile SingularAttribute<Solicitud_Actividad, String> estado;
    public static volatile SingularAttribute<Solicitud_Actividad, Usuario> usuario;
    public static volatile SingularAttribute<Solicitud_Actividad, Integer> id;
    public static volatile SingularAttribute<Solicitud_Actividad, Date> fecha_solicitud;
    public static volatile SingularAttribute<Solicitud_Actividad, Actividad> actividad;

}