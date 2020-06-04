package Entidades;

import Entidades.Actividad;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-06-04T23:31:03")
@StaticMetamodel(ONG.class)
public class ONG_ extends Usuario_ {

    public static volatile SingularAttribute<ONG, String> descripcion;
    public static volatile SingularAttribute<ONG, String> direccion;
    public static volatile SingularAttribute<ONG, Integer> telefono;
    public static volatile CollectionAttribute<ONG, Actividad> actividades;
    public static volatile SingularAttribute<ONG, String> pais;

}