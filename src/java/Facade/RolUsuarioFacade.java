/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Rol;
import Entity.RolUsuario;
import Entity.Usuario;
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
public class RolUsuarioFacade extends AbstractFacade<RolUsuario> {

    @PersistenceContext(unitName = "ConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolUsuarioFacade() {
        super(RolUsuario.class);
    }
    
    /**
     * 
     * @param rolId
     * @param usuarioId
     * @return Boolean 
     * @throws Exception 
     */
    public Boolean verificarRolUsuario(Rol rolId, Usuario usuarioId) throws Exception{
        Query query = em.createNamedQuery("RolUsuario.findByRolUsuario");
        query.setParameter("rolId", rolId);
        query.setParameter("usuarioId", usuarioId);
        List<RolUsuario> result = query.getResultList();
        if(!result.isEmpty()) throw new Exception("Este usuario ya tiene este rol");
        return true;
    } 
    
}
