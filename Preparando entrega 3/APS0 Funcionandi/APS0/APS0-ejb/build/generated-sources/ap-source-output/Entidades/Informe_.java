package Entidades;

import Entidades.Actividad;
import Entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-06-02T20:47:29")
=======
@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-06-02T19:51:00")
>>>>>>> 2356d023572e19f6a239d321f2feaf03e3e2584d
@StaticMetamodel(Informe.class)
public class Informe_ { 

    public static volatile SingularAttribute<Informe, String> evaluacion;
    public static volatile SingularAttribute<Informe, Usuario> usuario;
    public static volatile SingularAttribute<Informe, Integer> id;
    public static volatile SingularAttribute<Informe, String> tiempo_empleado;
    public static volatile SingularAttribute<Informe, String> tareas_realizadas;
    public static volatile SingularAttribute<Informe, Actividad> actividad;

}