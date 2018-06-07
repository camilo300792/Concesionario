/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author elcam
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> {

    @PersistenceContext(unitName = "ConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }
    
    public Boolean validarVehiculo (String _placa) throws Exception{
        Query query = em.createNamedQuery("Vehiculo.findByPlaca");
        query.setParameter("placa", _placa);
        List<Vehiculo> resultado = query.getResultList();
        if(!resultado.isEmpty()) throw new Exception("Ya existe un vehiculo registrado con está placa");
        return true;
    }
}
