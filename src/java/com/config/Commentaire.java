/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "commentaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commentaire.findAll", query = "SELECT c FROM Commentaire c"),
    @NamedQuery(name = "Commentaire.findByIdcommentaire", query = "SELECT c FROM Commentaire c WHERE c.idcommentaire = :idcommentaire"),
    @NamedQuery(name = "Commentaire.findByLibelle", query = "SELECT c FROM Commentaire c WHERE c.libelle = :libelle")})
public class Commentaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcommentaire")
    private Integer idcommentaire;
    @Size(max = 254)
    @Column(name = "libelle")
    private String libelle;
    @JoinColumns({
        @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur"),
        @JoinColumn(name = "idclient", referencedColumnName = "idclient")})
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "idpropose", referencedColumnName = "idpropose")
    @ManyToOne(optional = false)
    private Proposer idpropose;
    @JoinColumn(name = "idreservation", referencedColumnName = "idreservation")
    @ManyToOne(optional = false)
    private Reservationrestau idreservation;

    public Commentaire() {
    }

    public Commentaire(Integer idcommentaire) {
        this.idcommentaire = idcommentaire;
    }

    public Integer getIdcommentaire() {
        return idcommentaire;
    }

    public void setIdcommentaire(Integer idcommentaire) {
        this.idcommentaire = idcommentaire;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Proposer getIdpropose() {
        return idpropose;
    }

    public void setIdpropose(Proposer idpropose) {
        this.idpropose = idpropose;
    }

    public Reservationrestau getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(Reservationrestau idreservation) {
        this.idreservation = idreservation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcommentaire != null ? idcommentaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentaire)) {
            return false;
        }
        Commentaire other = (Commentaire) object;
        if ((this.idcommentaire == null && other.idcommentaire != null) || (this.idcommentaire != null && !this.idcommentaire.equals(other.idcommentaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Commentaire[ idcommentaire=" + idcommentaire + " ]";
    }
    
}
