package Entity;

import Entity.Master;
import Entity.RegistroVehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-07T13:32:24")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile ListAttribute<Vehiculo, RegistroVehiculo> registroVehiculoList;
    public static volatile SingularAttribute<Vehiculo, Integer> precio;
    public static volatile SingularAttribute<Vehiculo, String> color;
    public static volatile SingularAttribute<Vehiculo, Master> marcaId;
    public static volatile SingularAttribute<Vehiculo, Master> estadoId;
    public static volatile SingularAttribute<Vehiculo, Integer> id;
    public static volatile SingularAttribute<Vehiculo, Short> habilitado;
    public static volatile SingularAttribute<Vehiculo, String> placa;
    public static volatile SingularAttribute<Vehiculo, Master> categoriaId;

}