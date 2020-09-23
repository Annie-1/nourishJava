/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "categorieplat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorieplat.findAll", query = "SELECT c FROM Categorieplat c"),
    @NamedQuery(name = "Categorieplat.findByIdcategorieplat", query = "SELECT c FROM Categorieplat c WHERE c.idcategorieplat = :idcategorieplat"),
    @NamedQuery(name = "Categorieplat.findByLibelle", query = "SELECT c FROM Categorieplat c WHERE c.libelle = :libelle"),
    @NamedQuery(name = "Categorieplat.findByNom", query = "SELECT c FROM Categorieplat c WHERE c.nom = :nom")})
public class Categorieplat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategorieplat")
    private Integer idcategorieplat;
    @Size(max = 254)
    @Column(name = "libelle")
    private String libelle;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idcategorieplat")
    private Collection<Proposer> proposerCollection;

    public Categorieplat() {
    }

    public Categorieplat(Integer idcategorieplat) {
        this.idcategorieplat = idcategorieplat;
    }

    public Integer getIdcategorieplat() {
        return idcategorieplat;
    }

    public void setIdcategorieplat(Integer idcategorieplat) {
        this.idcategorieplat = idcategorieplat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        hash += (idcategorieplat != null ? idcategorieplat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorieplat)) {
            return false;
        }
        Categorieplat other = (Categorieplat) object;
        if ((this.idcategorieplat == null && other.idcategorieplat != null) || (this.idcategorieplat != null && !this.idcategorieplat.equals(other.idcategorieplat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Categorieplat[ idcategorieplat=" + idcategorieplat + " ]";
    }
    
}
