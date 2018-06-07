/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Master;
import Facade.MasterFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author elcam
 */
@Named(value = "masterController")
@SessionScoped
public class MasterController implements Serializable {

    /**
     * Creates a new instance of MasterController
     */
    public MasterController() {
        master = new Master();
    }
    
    @EJB
    private MasterFacade mf;
    private Master master;

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
    
    public List<Master> listarCategorias(){
        return mf.listarMasterXDependencia(mf.find(1));
    }
    public List<Master> listarMarcas(){
        return mf.listarMasterXDependencia(mf.find(2));
    }
    public List<Master> listarEstados(){
        return mf.listarMasterXDependencia(mf.find(3));
    }
    public List<Master> listarAccion(){
        return mf.listarMasterXDependencia(mf.find(4));
    }
    
}
