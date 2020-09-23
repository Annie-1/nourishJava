/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Clemy
 */
@Entity
@Table(name = "livraison")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livraison.findAll", query = "SELECT l FROM Livraison l"),
    @NamedQuery(name = "Livraison.findByIdlivraison", query = "SELECT l FROM Livraison l WHERE l.idlivraison = :idlivraison"),
    @NamedQuery(name = "Livraison.findByLieux", query = "SELECT l FROM Livraison l WHERE l.lieux = :lieux"),
    @NamedQuery(name = "Livraison.findByDate", query = "SELECT l FROM Livraison l WHERE l.date = :date"),
    @NamedQuery(name = "Livraison.findByCode", query = "SELECT l FROM Livraison l WHERE l.code = :code"),
    @NamedQuery(name = "Livraison.findByPrixlivraison", query = "SELECT l FROM Livraison l WHERE l.prixlivraison = :prixlivraison")})
public class Livraison implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlivraison")
    private Integer idlivraison;
    @Size(max = 254)
    @Column(name = "lieux")
    private String lieux;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 254)
    @Column(name = "code")
    private String code;
    @Column(name = "prixlivraison")
    private Integer prixlivraison;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlivraison")
    private Collection<Platcommande> platcommandeCollection;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false)
    private Responsablerestaurant idutilisateur;

    public Livraison() {
    }

    public Livraison(Integer idlivraison) {
        this.idlivraison = idlivraison;
    }

    public Integer getIdlivraison() {
        return idlivraison;
    }

    public void setIdlivraison(Integer idlivraison) {
        this.idlivraison = idlivraison;
    }

    public String getLieux() {
        return lieux;
    }

    public void setLieux(String lieux) {
        this.lieux = lieux;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrixlivraison() {
        return prixlivraison;
    }

    public void setPrixlivraison(Integer prixlivraison) {
        this.prixlivraison = prixlivraison;
    }

    @XmlTransient
    public Collection<Platcommande> getPlatcommandeCollection() {
        return platcommandeCollection;
    }

    public void setPlatcommandeCollection(Collection<Platcommande> platcommandeCollection) {
        this.platcommandeCollection = platcommandeCollection;
    }

    public Responsablerestaurant getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Responsablerestaurant idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlivraison != null ? idlivraison.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.idlivraison == null && other.idlivraison != null) || (this.idlivraison != null && !this.idlivraison.equals(other.idlivraison))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Livraison[ idlivraison=" + idlivraison + " ]";
    }
    
}
