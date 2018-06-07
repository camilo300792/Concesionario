/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Persona;
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
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "ConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
 
    public Boolean validarUsuario(String _correo) throws Exception{
        Query query = em.createNamedQuery("Persona.findByCorreo");
        query.setParameter("correo", _correo);
        List<Persona> resultado = query.getResultList();
        if(!resultado.isEmpty()) throw new Exception("Ya existe un usuario registrado con este correo");
        return true;
    }
}
