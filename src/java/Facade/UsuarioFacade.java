/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "ConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
   
    public Usuario verificarUsuario(String _username, String _contrasena) throws Exception{
        Usuario usuario;
        Query query = em.createNamedQuery("Usuario.findByLogin");
        query.setParameter("username", _username);
        query.setParameter("contrasena", _contrasena);
        List<Usuario> resultado = query.getResultList();
        if(resultado.isEmpty()) throw new Exception("Usuario o contraseña incorrectos");
        usuario = resultado.get(0);
        return usuario;
    }
    
    public List getPermisosUsuario(int _idUsuario){
        Query query = em.createNativeQuery("CALL get_permisos_usuario("+_idUsuario+");");
        List result = query.getResultList();
        return result;
    }
}
