/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elcam
 */
@Entity
@Table(name = "master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Master.findAll", query = "SELECT m FROM Master m")
    , @NamedQuery(name = "Master.findById", query = "SELECT m FROM Master m WHERE m.id = :id")
    , @NamedQuery(name = "Master.findByNombre", query = "SELECT m FROM Master m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Master.findByDescripcion", query = "SELECT m FROM Master m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Master.findByHabilitado", query = "SELECT m FROM Master m WHERE m.habilitado = :habilitado")
    , @NamedQuery(name = "Master.findByDependencia", query = "SELECT m FROM Master m WHERE m.dependenciaId = :dependencia")})
public class Master implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private short habilitado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcaId")
    private List<Vehiculo> vehiculoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoId")
    private List<Vehiculo> vehiculoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaId")
    private List<Vehiculo> vehiculoList2;
    @OneToMany(mappedBy = "dependenciaId")
    private List<Master> masterList;
    @JoinColumn(name = "dependencia_id", referencedColumnName = "id")
    @ManyToOne
    private Master dependenciaId;

    public Master() {
    }

    public Master(Integer id) {
        this.id = id;
    }

    public Master(Integer id, String nombre, String descripcion, short habilitado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.habilitado = habilitado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(short habilitado) {
        this.habilitado = habilitado;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList1() {
        return vehiculoList1;
    }

    public void setVehiculoList1(List<Vehiculo> vehiculoList1) {
        this.vehiculoList1 = vehiculoList1;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList2() {
        return vehiculoList2;
    }

    public void setVehiculoList2(List<Vehiculo> vehiculoList2) {
        this.vehiculoList2 = vehiculoList2;
    }

    @XmlTransient
    public List<Master> getMasterList() {
        return masterList;
    }

    public void setMasterList(List<Master> masterList) {
        this.masterList = masterList;
    }

    public Master getDependenciaId() {
        return dependenciaId;
    }

    public void setDependenciaId(Master dependenciaId) {
        this.dependenciaId = dependenciaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Master)) {
            return false;
        }
        Master other = (Master) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Master[ id=" + id + " ]";
    }
    
}
