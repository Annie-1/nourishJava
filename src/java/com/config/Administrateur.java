/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Clemy
 */
@Entity
@Table(name = "administrateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrateur.findAll", query = "SELECT a FROM Administrateur a"),
    @NamedQuery(name = "Administrateur.findByIdutilisateur", query = "SELECT a FROM Administrateur a WHERE a.administrateurPK.idutilisateur = :idutilisateur"),
    @NamedQuery(name = "Administrateur.findByIdadministrateur", query = "SELECT a FROM Administrateur a WHERE a.administrateurPK.idadministrateur = :idadministrateur")})
public class Administrateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdministrateurPK administrateurPK;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Administrateur() {
    }

    public Administrateur(AdministrateurPK administrateurPK) {
        this.administrateurPK = administrateurPK;
    }

    public Administrateur(int idutilisateur, int idadministrateur) {
        this.administrateurPK = new AdministrateurPK(idutilisateur, idadministrateur);
    }

    public AdministrateurPK getAdministrateurPK() {
        return administrateurPK;
    }

    public void setAdministrateurPK(AdministrateurPK administrateurPK) {
        this.administrateurPK = administrateurPK;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (administrateurPK != null ? administrateurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrateur)) {
            return false;
        }
        Administrateur other = (Administrateur) object;
        if ((this.administrateurPK == null && other.administrateurPK != null) || (this.administrateurPK != null && !this.administrateurPK.equals(other.administrateurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Administrateur[ administrateurPK=" + administrateurPK + " ]";
    }
    
}
