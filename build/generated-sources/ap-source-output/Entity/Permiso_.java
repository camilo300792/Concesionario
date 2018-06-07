package Entity;

import Entity.RolPermiso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-07T13:32:24")
@StaticMetamodel(Permiso.class)
public class Permiso_ { 

    public static volatile ListAttribute<Permiso, RolPermiso> rolPermisoList;
    public static volatile SingularAttribute<Permiso, Integer> id;
    public static volatile SingularAttribute<Permiso, Short> habilitado;
    public static volatile SingularAttribute<Permiso, String> nombre;
    public static volatile SingularAttribute<Permiso, String> url;

}