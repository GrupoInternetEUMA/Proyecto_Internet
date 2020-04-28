package es.uma.informatica.sii.acoes;

import es.uma.informatica.sii.acoes.Actividad;
import es.uma.informatica.sii.acoes.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-28T16:46:51")
@StaticMetamodel(Informe.class)
public class Informe_ { 

    public static volatile SingularAttribute<Informe, String> evaluacion;
    public static volatile SingularAttribute<Informe, Usuario> usuario;
    public static volatile SingularAttribute<Informe, Integer> id;
    public static volatile SingularAttribute<Informe, String> tiempo_empleado;
    public static volatile SingularAttribute<Informe, String> tareas_realizadas;
    public static volatile SingularAttribute<Informe, Actividad> actividad;

}