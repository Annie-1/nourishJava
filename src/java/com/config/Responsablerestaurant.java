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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Clemy
 */
@Entity
@Table(name = "responsablerestaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsablerestaurant.findAll", query = "SELECT r FROM Responsablerestaurant r"),
    @NamedQuery(name = "Responsablerestaurant.findByIdutilisateur", query = "SELECT r FROM Responsablerestaurant r WHERE r.idutilisateur = :idutilisateur"),
    @NamedQuery(name = "Responsablerestaurant.findByCni", query = "SELECT r FROM Responsablerestaurant r WHERE r.cni = :cni")})
public class Responsablerestaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idutilisateur")
    private Integer idutilisateur;
    @Size(max = 254)
    @Column(name = "cni")
    private String cni;
    @JoinColumn(name = "idrestaurant", referencedColumnName = "idrestaurant")
    @ManyToOne(optional = false)
    private Agence idrestaurant;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Utilisateur utilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur")
    private Collection<Livraison> livraisonCollection;

    public Responsablerestaurant() {
    }

    public Responsablerestaurant(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public Agence getIdrestaurant() {
        return idrestaurant;
    }

    public void setIdrestaurant(Agence idrestaurant) {
        this.idrestaurant = idrestaurant;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @XmlTransient
    public Collection<Livraison> getLivraisonCollection() {
        return livraisonCollection;
    }

    public void setLivraisonCollection(Collection<Livraison> livraisonCollection) {
        this.livraisonCollection = livraisonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idutilisateur != null ? idutilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsablerestaurant)) {
            return false;
        }
        Responsablerestaurant other = (Responsablerestaurant) object;
        if ((this.idutilisateur == null && other.idutilisateur != null) || (this.idutilisateur != null && !this.idutilisateur.equals(other.idutilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Responsablerestaurant[ idutilisateur=" + idutilisateur + " ]";
    }
    
}
