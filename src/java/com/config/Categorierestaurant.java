/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Clemy
 */
@Entity
@Table(name = "categorierestaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorierestaurant.findAll", query = "SELECT c FROM Categorierestaurant c"),
    @NamedQuery(name = "Categorierestaurant.findByIdcategorierestaurant", query = "SELECT c FROM Categorierestaurant c WHERE c.idcategorierestaurant = :idcategorierestaurant"),
    @NamedQuery(name = "Categorierestaurant.findByNom", query = "SELECT c FROM Categorierestaurant c WHERE c.nom = :nom"),
    @NamedQuery(name = "Categorierestaurant.findByString", query = "SELECT c FROM Categorierestaurant c WHERE c.string = :string")})
public class Categorierestaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategorierestaurant")
    private Integer idcategorierestaurant;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "string")
    private String string;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategorierestaurant")
    private Collection<Restaurant> restaurantCollection;

    public Categorierestaurant() {
    }

    public Categorierestaurant(Integer idcategorierestaurant) {
        this.idcategorierestaurant = idcategorierestaurant;
    }

    public Integer getIdcategorierestaurant() {
        return idcategorierestaurant;
    }

    public void setIdcategorierestaurant(Integer idcategorierestaurant) {
        this.idcategorierestaurant = idcategorierestaurant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @XmlTransient
    public Collection<Restaurant> getRestaurantCollection() {
        return restaurantCollection;
    }

    public void setRestaurantCollection(Collection<Restaurant> restaurantCollection) {
        this.restaurantCollection = restaurantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategorierestaurant != null ? idcategorierestaurant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorierestaurant)) {
            return false;
        }
        Categorierestaurant other = (Categorierestaurant) object;
        if ((this.idcategorierestaurant == null && other.idcategorierestaurant != null) || (this.idcategorierestaurant != null && !this.idcategorierestaurant.equals(other.idcategorierestaurant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Categorierestaurant[ idcategorierestaurant=" + idcategorierestaurant + " ]";
    }
    
}
