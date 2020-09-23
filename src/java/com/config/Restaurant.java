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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "restaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r"),
    @NamedQuery(name = "Restaurant.findByIdrestaurant", query = "SELECT r FROM Restaurant r WHERE r.idrestaurant = :idrestaurant"),
    @NamedQuery(name = "Restaurant.findByNom", query = "SELECT r FROM Restaurant r WHERE r.nom = :nom"),
    @NamedQuery(name = "Restaurant.findBySiteweb", query = "SELECT r FROM Restaurant r WHERE r.siteweb = :siteweb"),
    @NamedQuery(name = "Restaurant.findByImage", query = "SELECT r FROM Restaurant r WHERE r.image = :image")})
public class Restaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrestaurant")
    private Integer idrestaurant;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "siteweb")
    private String siteweb;
    @Size(max = 254)
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "idcategorierestaurant", referencedColumnName = "idcategorierestaurant")
    @ManyToOne(optional = false)
    private Categorierestaurant idcategorierestaurant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrestaurant")
    private Collection<Reservationrestau> reservationrestauCollection;
    @OneToMany(mappedBy = "resIdrestaurant")
    private Collection<Agence> agenceCollection;

    public Restaurant() {
    }

    public Restaurant(Integer idrestaurant) {
        this.idrestaurant = idrestaurant;
    }

    public Integer getIdrestaurant() {
        return idrestaurant;
    }

    public void setIdrestaurant(Integer idrestaurant) {
        this.idrestaurant = idrestaurant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Categorierestaurant getIdcategorierestaurant() {
        return idcategorierestaurant;
    }

    public void setIdcategorierestaurant(Categorierestaurant idcategorierestaurant) {
        this.idcategorierestaurant = idcategorierestaurant;
    }

    @XmlTransient
    public Collection<Reservationrestau> getReservationrestauCollection() {
        return reservationrestauCollection;
    }

    public void setReservationrestauCollection(Collection<Reservationrestau> reservationrestauCollection) {
        this.reservationrestauCollection = reservationrestauCollection;
    }

    @XmlTransient
    public Collection<Agence> getAgenceCollection() {
        return agenceCollection;
    }

    public void setAgenceCollection(Collection<Agence> agenceCollection) {
        this.agenceCollection = agenceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrestaurant != null ? idrestaurant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.idrestaurant == null && other.idrestaurant != null) || (this.idrestaurant != null && !this.idrestaurant.equals(other.idrestaurant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Restaurant[ idrestaurant=" + idrestaurant + " ]";
    }
    
}
