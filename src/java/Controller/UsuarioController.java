/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Persona;
import Entity.Usuario;
import Facade.PersonaFacade;
import Facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author elcam
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
        usuario = new Usuario();
        usuarioSesion = new Usuario();
        persona = usuarioSesion.getPersonaId();
    }
    
    @EJB
    private UsuarioFacade uf;
    private Usuario usuario;
    private Usuario usuarioSesion;
    @EJB
    private PersonaFacade pf;
    private Persona persona;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }
    
    public void setUsuarioSesion(Usuario usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }
    
    public Persona getPersona() {
        persona = usuarioSesion.getPersonaId();
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public String iniciarSesion(){
        try {
            usuarioSesion = uf.verificarUsuario(usuarioSesion.getUsername(), usuarioSesion.getContrasena());
            if(usuarioSesion != null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioSesion", usuarioSesion);
            }
            return "/Usuario/index?faces-redirect=true";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "/index?faces-redirect=true";
        }
    }
    
    public Usuario usuarioSesion(){
        usuarioSesion = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioSesion");
        return usuarioSesion;
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }
    
    public List listarPermisosUsuario(){
        return uf.getPermisosUsuario(usuarioSesion.getId());
    }
    
    public List<Usuario> listarUsuarios(){
        return uf.findAll();
    }
    
    public String editarPerfil(){
        FacesContext context = FacesContext.getCurrentInstance();
        pf.edit(persona);
        usuarioSesion.setUsername(persona.getCorreo());
        usuarioSesion.setContrasena(persona.getDocumento());
        uf.edit(usuarioSesion);
        context.addMessage(null, new FacesMessage("Exito", "La información ha sido almacenada satisfactoriamente"));
        return "/Usuario/editar-perfil?faces-redirect=true";
    }
    
}
