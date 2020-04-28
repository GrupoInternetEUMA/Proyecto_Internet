package es.uma.informatica.sii.acoes;

import es.uma.informatica.sii.acoes.Actividad;
import es.uma.informatica.sii.acoes.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-28T16:46:51")
@StaticMetamodel(Responsable_actividad.class)
public class Responsable_actividad_ extends Usuario_ {

    public static volatile SingularAttribute<Responsable_actividad, String> departamento;
    public static volatile CollectionAttribute<Responsable_actividad, Usuario> usuarios;
    public static volatile CollectionAttribute<Responsable_actividad, Actividad> actividades;

}