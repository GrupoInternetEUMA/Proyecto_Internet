package es.uma.informatica.sii.acoes;

import es.uma.informatica.sii.acoes.Informe;
import es.uma.informatica.sii.acoes.Responsable_actividad;
import es.uma.informatica.sii.acoes.Solicitud_Actividad;
import es.uma.informatica.sii.acoes.Usuario.Rol;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-28T16:46:51")
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
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, Integer> dni;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile CollectionAttribute<Usuario, Informe> informes;

}