package Entidades;

import Entidades.Actividad;
import Entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-06-04T23:38:06")
@StaticMetamodel(Responsable_actividad.class)
public class Responsable_actividad_ extends Usuario_ {

    public static volatile SingularAttribute<Responsable_actividad, String> departamento;
    public static volatile CollectionAttribute<Responsable_actividad, Usuario> usuarios;
    public static volatile CollectionAttribute<Responsable_actividad, Actividad> actividades;

}