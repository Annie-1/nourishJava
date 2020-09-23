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
@Table(name = "agence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agence.findAll", query = "SELECT a FROM Agence a"),
    @NamedQuery(name = "Agence.findByIdrestaurant", query = "SELECT a FROM Agence a WHERE a.idrestaurant = :idrestaurant"),
    @NamedQuery(name = "Agence.findByLibelle", query = "SELECT a FROM Agence a WHERE a.libelle = :libelle")})
public class Agence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrestaurant")
    private Integer idrestaurant;
    @Size(max = 254)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrestaurant")
    private Collection<Proposer> proposerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrestaurant")
    private Collection<Responsablerestaurant> responsablerestaurantCollection;
    @JoinColumn(name = "res_idrestaurant", referencedColumnName = "idrestaurant")
    @ManyToOne
    private Restaurant resIdrestaurant;

    public Agence() {
    }

    public Agence(Integer idrestaurant) {
        this.idrestaurant = idrestaurant;
    }

    public Integer getIdrestaurant() {
        return idrestaurant;
    }

    public void setIdrestaurant(Integer idrestaurant) {
        this.idrestaurant = idrestaurant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public Collection<Proposer> getProposerCollection() {
        return proposerCollection;
    }

    public void setProposerCollection(Collection<Proposer> proposerCollection) {
        this.proposerCollection = proposerCollection;
    }

    @XmlTransient
    public Collection<Responsablerestaurant> getResponsablerestaurantCollection() {
        return responsablerestaurantCollection;
    }

    public void setResponsablerestaurantCollection(Collection<Responsablerestaurant> responsablerestaurantCollection) {
        this.responsablerestaurantCollection = responsablerestaurantCollection;
    }

    public Restaurant getResIdrestaurant() {
        return resIdrestaurant;
    }

    public void setResIdrestaurant(Restaurant resIdrestaurant) {
        this.resIdrestaurant = resIdrestaurant;
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
        if (!(object instanceof Agence)) {
            return false;
        }
        Agence other = (Agence) object;
        if ((this.idrestaurant == null && other.idrestaurant != null) || (this.idrestaurant != null && !this.idrestaurant.equals(other.idrestaurant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Agence[ idrestaurant=" + idrestaurant + " ]";
    }
    
}
