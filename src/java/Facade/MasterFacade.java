/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Master;
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
public class MasterFacade extends AbstractFacade<Master> {

    @PersistenceContext(unitName = "ConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MasterFacade() {
        super(Master.class);
    }
 
    public List<Master> listarMasterXDependencia(Master m){
        Query query = em.createNamedQuery("Master.findByDependencia");
        query.setParameter("dependencia", m);
        List<Master> resultado = query.getResultList();
        return resultado;
    }
}
