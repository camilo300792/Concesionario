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
        try {
            pf.validarUsuario(persona.getCorreo());
            persona.setHabilitado((short) 1);
            pf.create(persona);
            persona = new Persona();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String datosPersona(Persona p){
        persona = p;
        return "/Usuario/datos-vendedor?faces-redirect=true";
    }
    
}
