/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Master;
import Entity.RegistroVehiculo;
import Facade.MasterFacade;
import Facade.RegistroVehiculoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author elcam
 */
@Named(value = "registroVehiculoController")
@SessionScoped
public class RegistroVehiculoController implements Serializable {

    /**
     * Creates a new instance of RegistroVehiculoController
     */
    public RegistroVehiculoController() {
        master = new Master();
    }
    
    @EJB
    private RegistroVehiculoFacade rvf;
    private MasterFacade mf;
    private Master master;

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
    
    public List<RegistroVehiculo> listarRegistros(){
        return rvf.findAll();
    }
    
    public void filtrarCategoria(){
        System.out.println("Categoria filtrada " + master.getNombre());
    } 
    
}
