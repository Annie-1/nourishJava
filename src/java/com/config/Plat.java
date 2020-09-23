/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "plat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plat.findAll", query = "SELECT p FROM Plat p"),
    @NamedQuery(name = "Plat.findByIdplat", query = "SELECT p FROM Plat p WHERE p.idplat = :idplat"),
    @NamedQuery(name = "Plat.findByNom", query = "SELECT p FROM Plat p WHERE p.nom = :nom"),
    @NamedQuery(name = "Plat.findByPrix", query = "SELECT p FROM Plat p WHERE p.prix = :prix"),
    @NamedQuery(name = "Plat.findByInfo", query = "SELECT p FROM Plat p WHERE p.info = :info"),
    @NamedQuery(name = "Plat.findByImage", query = "SELECT p FROM Plat p WHERE p.image = :image")})
public class Plat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplat")
    private Integer idplat;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Column(name = "prix")
    private BigInteger prix;
    @Size(max = 254)
    @Column(name = "info")
    private String info;
    @Size(max = 254)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplat")
    private Collection<Proposer> proposerCollection;

    public Plat() {
    }

    public Plat(Integer idplat) {
        this.idplat = idplat;
    }

    public Integer getIdplat() {
        return idplat;
    }

    public void setIdplat(Integer idplat) {
        this.idplat = idplat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigInteger getPrix() {
        return prix;
    }

    public void setPrix(BigInteger prix) {
        this.prix = prix;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<Proposer> getProposerCollection() {
        return proposerCollection;
    }

    public void setProposerCollection(Collection<Proposer> proposerCollection) {
        this.proposerCollection = proposerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplat != null ? idplat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plat)) {
            return false;
        }
        Plat other = (Plat) object;
        if ((this.idplat == null && other.idplat != null) || (this.idplat != null && !this.idplat.equals(other.idplat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Plat[ idplat=" + idplat + " ]";
    }
    
}
