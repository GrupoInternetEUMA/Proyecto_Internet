package es.uma.informatica.sii.acoes;

import es.uma.informatica.sii.acoes.Informe;
import es.uma.informatica.sii.acoes.ONG;
import es.uma.informatica.sii.acoes.Responsable_actividad;
import es.uma.informatica.sii.acoes.Solicitud_Actividad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-28T16:46:51")
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, String> descripcion;
    public static volatile SingularAttribute<Actividad, String> estado;
    public static volatile SingularAttribute<Actividad, String> tipo;
    public static volatile SingularAttribute<Actividad, Date> fecha_inicio;
    public static volatile SingularAttribute<Actividad, Date> fecha_fin;
    public static volatile SingularAttribute<Actividad, Responsable_actividad> responsable_actividad;
    public static volatile SingularAttribute<Actividad, String> lugar;
    public static volatile CollectionAttribute<Actividad, Solicitud_Actividad> solicitud_Actividad;
    public static volatile SingularAttribute<Actividad, ONG> ong;
    public static volatile SingularAttribute<Actividad, Integer> id;
    public static volatile SingularAttribute<Actividad, String> nombre;
    public static volatile CollectionAttribute<Actividad, Informe> informes;

}