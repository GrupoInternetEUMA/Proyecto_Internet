package Entidades;

import Entidades.Informe;
import Entidades.Responsable_actividad;
import Entidades.Solicitud_Actividad;
import Entidades.Usuario.Rol;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-06-02T19:51:00")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile CollectionAttribute<Usuario, Responsable_actividad> responsables;
    public static volatile SingularAttribute<Usuario, Date> fecha_nacimiento;
    public static volatile SingularAttribute<Usuario, String> idioma;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> estudios;
    public static volatile SingularAttribute<Usuario, Rol> rol;
    public static volatile SingularAttribute<Usuario, String> contrasenia;
    public static volatile SingularAttribute<Usuario, String> usuario;
    public static volatile CollectionAttribute<Usuario, Solicitud_Actividad> Solicitud_Actividad;
    public static volatile SingularAttribute<Usuario, Integer> dni;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile CollectionAttribute<Usuario, Informe> informes;

}