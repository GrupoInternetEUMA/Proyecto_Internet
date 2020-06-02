package Entidades;

import Entidades.Informe;
import Entidades.ONG;
import Entidades.Responsable_actividad;
import Entidades.Solicitud_Actividad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-06-02T18:54:32")
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