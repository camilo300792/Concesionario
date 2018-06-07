package Entity;

import Entity.Permiso;
import Entity.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-07T13:32:24")
@StaticMetamodel(RolPermiso.class)
public class RolPermiso_ { 

    public static volatile SingularAttribute<RolPermiso, Rol> rolId;
    public static volatile SingularAttribute<RolPermiso, Integer> id;
    public static volatile SingularAttribute<RolPermiso, Short> habilitado;
    public static volatile SingularAttribute<RolPermiso, Permiso> permisoId;

}