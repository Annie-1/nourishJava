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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Clemy
 */
@Entity
@Table(name = "proposer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proposer.findAll", query = "SELECT p FROM Proposer p"),
    @NamedQuery(name = "Proposer.findByIdpropose", query = "SELECT p FROM Proposer p WHERE p.idpropose = :idpropose"),
    @NamedQuery(name = "Proposer.findByEtat", query = "SELECT p FROM Proposer p WHERE p.etat = :etat"),
    @NamedQuery(name = "Proposer.findByQuantiteseuille", query = "SELECT p FROM Proposer p WHERE p.quantiteseuille = :quantiteseuille"),
    @NamedQuery(name = "Proposer.findByQuantiteproposee", query = "SELECT p FROM Proposer p WHERE p.quantiteproposee = :quantiteproposee")})
public class Proposer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpropose")
    private Integer idpropose;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat")
    private boolean etat;
    @Column(name = "quantiteseuille")
    private Integer quantiteseuille;
    @Column(name = "quantiteproposee")
    private Integer quantiteproposee;
    @JoinColumn(name = "idrestaurant", referencedColumnName = "idrestaurant")
    @ManyToOne(optional = false)
    private Agence idrestaurant;
    @JoinColumn(name = "idcategorieplat", referencedColumnName = "idcategorieplat")
    @ManyToOne
    private Categorieplat idcategorieplat;
    @JoinColumn(name = "idplat", referencedColumnName = "idplat")
    @ManyToOne(optional = false)
    private Plat idplat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proposer")
    private Collection<Platcommande> platcommandeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpropose")
    private Collection<Commentaire> commentaireCollection;

    public Proposer() {
    }

    public Proposer(Integer idpropose) {
        this.idpropose = idpropose;
    }

    public Proposer(Integer idpropose, boolean etat) {
        this.idpropose = idpropose;
        this.etat = etat;
    }

    public Integer getIdpropose() {
        return idpropose;
    }

    public void setIdpropose(Integer idpropose) {
        this.idpropose = idpropose;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Integer getQuantiteseuille() {
        return quantiteseuille;
    }

    public void setQuantiteseuille(Integer quantiteseuille) {
        this.quantiteseuille = quantiteseuille;
    }

    public Integer getQuantiteproposee() {
        return quantiteproposee;
    }

    public void setQuantiteproposee(Integer quantiteproposee) {
        this.quantiteproposee = quantiteproposee;
    }

    public Agence getIdrestaurant() {
        return idrestaurant;
    }

    public void setIdrestaurant(Agence idrestaurant) {
        this.idrestaurant = idrestaurant;
    }

    public Categorieplat getIdcategorieplat() {
        return idcategorieplat;
    }

    public void setIdcategorieplat(Categorieplat idcategorieplat) {
        this.idcategorieplat = idcategorieplat;
    }

    public Plat getIdplat() {
        return idplat;
    }

    public void setIdplat(Plat idplat) {
        this.idplat = idplat;
    }

    @XmlTransient
    public Collection<Platcommande> getPlatcommandeCollection() {
        return platcommandeCollection;
    }

    public void setPlatcommandeCollection(Collection<Platcommande> platcommandeCollection) {
        this.platcommandeCollection = platcommandeCollection;
    }

    @XmlTransient
    public Collection<Commentaire> getCommentaireCollection() {
        return commentaireCollection;
    }

    public void setCommentaireCollection(Collection<Commentaire> commentaireCollection) {
        this.commentaireCollection = commentaireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpropose != null ? idpropose.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proposer)) {
            return false;
        }
        Proposer other = (Proposer) object;
        if ((this.idpropose == null && other.idpropose != null) || (this.idpropose != null && !this.idpropose.equals(other.idpropose))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Proposer[ idpropose=" + idpropose + " ]";
    }
    
}
