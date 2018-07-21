/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Rol;
import Entity.RolUsuario;
import Entity.Usuario;
import Facade.RolFacade;
import Facade.RolUsuarioFacade;
import Facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author elcam
 */
@Named(value = "rolUsuarioController")
@SessionScoped
public class RolUsuarioController implements Serializable {

    /**
     * Creates a new instance of RolUsuarioController
     */
    public RolUsuarioController() {
        rolUsuario = new RolUsuario();
        rol = new Rol();
        usuario = new Usuario();
    }
    
    @EJB
    private RolUsuarioFacade ruf;
    private RolUsuario rolUsuario;
    @EJB
    private RolFacade rf;
    private Rol rol;
    @EJB 
    private UsuarioFacade uf;
    private Usuario usuario;

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void asignarRol(){
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ruf.verificarRolUsuario(rf.find(rol.getId()), uf.find(usuario.getId()));
            rolUsuario.setHabilitado((short) 1);
            rolUsuario.setUsuarioId(uf.find(usuario.getId()));
            rolUsuario.setRolId(rf.find(rol.getId()));
            ruf.create(rolUsuario);
            rolUsuario = new RolUsuario();
            context.addMessage(null, new FacesMessage("Exito", "La información ha sido almacenada satisfactoriamente"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Info", e.getMessage()));
        }
    }
    
}
