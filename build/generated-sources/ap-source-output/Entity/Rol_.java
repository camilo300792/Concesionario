package Entity;

import Entity.RolPermiso;
import Entity.RolUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-07T13:32:24")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> descripcion;
    public static volatile ListAttribute<Rol, RolUsuario> rolUsuarioList;
    public static volatile ListAttribute<Rol, RolPermiso> rolPermisoList;
    public static volatile SingularAttribute<Rol, Integer> id;
    public static volatile SingularAttribute<Rol, Short> habilitado;
    public static volatile SingularAttribute<Rol, String> nombre;

}