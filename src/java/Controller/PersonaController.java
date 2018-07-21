/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Persona;
import Facade.PersonaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

/**
 *
 * @author elcam
 */
@Named(value = "personaController")
@SessionScoped
public class PersonaController implements Serializable {

    /**
     * Creates a new instance of PersonaController
     */
    public PersonaController() {
        persona = new Persona();
    }
    
    @EJB
    private PersonaFacade pf;
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void crearPersona(){
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            pf.validarUsuario(persona.getCorreo());
            persona.setHabilitado((short) 1);
            pf.create(persona);
            context.addMessage(null, new FacesMessage("Exito", "La información ha sido almacenada satisfactoriamente"));
            persona = new Persona();
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error", e.getMessage()));
        }
    }
    
    public String datosPersona(Persona p){
        persona = p;
        return "/Usuario/datos-vendedor?faces-redirect=true";
    }
    
}
