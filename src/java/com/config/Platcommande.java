/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Clemy
 */
@Entity
@Table(name = "platcommande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platcommande.findAll", query = "SELECT p FROM Platcommande p"),
    @NamedQuery(name = "Platcommande.findByIdpropose", query = "SELECT p FROM Platcommande p WHERE p.platcommandePK.idpropose = :idpropose"),
    @NamedQuery(name = "Platcommande.findByIdcommande", query = "SELECT p FROM Platcommande p WHERE p.platcommandePK.idcommande = :idcommande"),
    @NamedQuery(name = "Platcommande.findByQuantite", query = "SELECT p FROM Platcommande p WHERE p.quantite = :quantite"),
    @NamedQuery(name = "Platcommande.findByStatutlivraison", query = "SELECT p FROM Platcommande p WHERE p.statutlivraison = :statutlivraison")})
public class Platcommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlatcommandePK platcommandePK;
    @Column(name = "quantite")
    private Integer quantite;
    @Size(max = 254)
    @Column(name = "statutlivraison")
    private String statutlivraison;
    @JoinColumn(name = "idcommande", referencedColumnName = "idcommande", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;
    @JoinColumn(name = "idlivraison", referencedColumnName = "idlivraison")
    @ManyToOne(optional = false)
    private Livraison idlivraison;
    @JoinColumn(name = "idpropose", referencedColumnName = "idpropose", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proposer proposer;

    public Platcommande() {
    }

    public Platcommande(PlatcommandePK platcommandePK) {
        this.platcommandePK = platcommandePK;
    }

    public Platcommande(int idpropose, int idcommande) {
        this.platcommandePK = new PlatcommandePK(idpropose, idcommande);
    }

    public PlatcommandePK getPlatcommandePK() {
        return platcommandePK;
    }

    public void setPlatcommandePK(PlatcommandePK platcommandePK) {
        this.platcommandePK = platcommandePK;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public String getStatutlivraison() {
        return statutlivraison;
    }

    public void setStatutlivraison(String statutlivraison) {
        this.statutlivraison = statutlivraison;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Livraison getIdlivraison() {
        return idlivraison;
    }

    public void setIdlivraison(Livraison idlivraison) {
        this.idlivraison = idlivraison;
    }

    public Proposer getProposer() {
        return proposer;
    }

    public void setProposer(Proposer proposer) {
        this.proposer = proposer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (platcommandePK != null ? platcommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platcommande)) {
            return false;
        }
        Platcommande other = (Platcommande) object;
        if ((this.platcommandePK == null && other.platcommandePK != null) || (this.platcommandePK != null && !this.platcommandePK.equals(other.platcommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Platcommande[ platcommandePK=" + platcommandePK + " ]";
    }
    
}
