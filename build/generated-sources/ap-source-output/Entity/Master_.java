package Entity;

import Entity.Master;
import Entity.Vehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-07T13:32:24")
@StaticMetamodel(Master.class)
public class Master_ { 

    public static volatile SingularAttribute<Master, String> descripcion;
    public static volatile ListAttribute<Master, Vehiculo> vehiculoList2;
    public static volatile ListAttribute<Master, Vehiculo> vehiculoList1;
    public static volatile ListAttribute<Master, Master> masterList;
    public static volatile SingularAttribute<Master, Master> dependenciaId;
    public static volatile SingularAttribute<Master, Integer> id;
    public static volatile SingularAttribute<Master, Short> habilitado;
    public static volatile SingularAttribute<Master, String> nombre;
    public static volatile ListAttribute<Master, Vehiculo> vehiculoList;

}