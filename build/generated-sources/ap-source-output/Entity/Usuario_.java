package Entity;

import Entity.Persona;
import Entity.RegistroVehiculo;
import Entity.RolUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-07T13:32:24")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, RegistroVehiculo> registroVehiculoList;
    public static volatile ListAttribute<Usuario, RolUsuario> rolUsuarioList;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, Short> habilitado;
    public static volatile SingularAttribute<Usuario, Persona> personaId;
    public static volatile SingularAttribute<Usuario, String> username;

}