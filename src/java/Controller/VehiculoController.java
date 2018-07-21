/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Master;
import Entity.RegistroVehiculo;
import Entity.Usuario;
import Entity.Vehiculo;
import Facade.MasterFacade;
import Facade.RegistroVehiculoFacade;
import Facade.VehiculoFacade;
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
@Named(value = "vehiculoController")
@SessionScoped
public class VehiculoController implements Serializable {

    /**
     * Creates a new instance of VehiculoController
     */
    public VehiculoController() {
        vehiculo = new Vehiculo();
        marca = new Master();
        estado = new Master();
        categoria = new Master();
        registroVehiculo = new RegistroVehiculo();
    }
    
    @EJB
    private VehiculoFacade vf;
    private Vehiculo vehiculo;
    @EJB
    private MasterFacade mf;
    private Master marca;
    private Master estado;
    private Master categoria;
    @EJB
    private RegistroVehiculoFacade rvf;
    private RegistroVehiculo registroVehiculo;
    private Usuario usuario;

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Master getMarca() {
        return marca;
    }

    public void setMarca(Master marca) {
        this.marca = marca;
    }

    public Master getEstado() {
        return estado;
    }

    public void setEstado(Master estado) {
        this.estado = estado;
    }

    public Master getCategoria() {
        return categoria;
    }

    public void setCategoria(Master categoria) {
        this.categoria = categoria;
    }

    public RegistroVehiculo getRegistroVehiculo() {
        return registroVehiculo;
    }

    public void setRegistroVehiculo(RegistroVehiculo registroVehiculo) {
        this.registroVehiculo = registroVehiculo;
    }
    
    public void registrarVehiculo(){
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioSesion");
        try {
            vf.validarVehiculo(vehiculo.getPlaca());
            vehiculo.setCategoriaId(mf.find(categoria.getId()));
            vehiculo.setEstadoId(mf.find(estado.getId()));
            vehiculo.setMarcaId(mf.find(marca.getId()));
            vehiculo.setHabilitado((short) 1);
            vf.create(vehiculo);
            registroVehiculo.setVehiculoId(vehiculo);
            registroVehiculo.setUsuarioId(usuario);
            registroVehiculo.setHabilitado((short) 1);
            rvf.create(registroVehiculo);
            context.addMessage(null, new FacesMessage("Exito", "La información ha sido almacenada satisfactoriamente"));
            vehiculo = new Vehiculo();
            registroVehiculo = new RegistroVehiculo();
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error", e.getMessage()));
        }
    }
}
