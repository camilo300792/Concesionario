package Entity;

import Entity.Rol;
import Entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-07T13:32:24")
@StaticMetamodel(RolUsuario.class)
public class RolUsuario_ { 

    public static volatile SingularAttribute<RolUsuario, Rol> rolId;
    public static volatile SingularAttribute<RolUsuario, Integer> id;
    public static volatile SingularAttribute<RolUsuario, Short> habilitado;
    public static volatile SingularAttribute<RolUsuario, Usuario> usuarioId;

}