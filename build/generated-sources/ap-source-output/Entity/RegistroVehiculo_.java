package Entity;

import Entity.Usuario;
import Entity.Vehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-07T13:32:24")
@StaticMetamodel(RegistroVehiculo.class)
public class RegistroVehiculo_ { 

    public static volatile SingularAttribute<RegistroVehiculo, Vehiculo> vehiculoId;
    public static volatile SingularAttribute<RegistroVehiculo, Integer> id;
    public static volatile SingularAttribute<RegistroVehiculo, Short> habilitado;
    public static volatile SingularAttribute<RegistroVehiculo, Usuario> usuarioId;

}