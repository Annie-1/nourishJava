/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Clemy
 */
@Embeddable
public class AdministrateurPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idutilisateur")
    private int idutilisateur;
    @Basic(optional = false)
    @Column(name = "idadministrateur")
    private int idadministrateur;

    public AdministrateurPK() {
    }

    public AdministrateurPK(int idutilisateur, int idadministrateur) {
        this.idutilisateur = idutilisateur;
        this.idadministrateur = idadministrateur;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdadministrateur() {
        return idadministrateur;
    }

    public void setIdadministrateur(int idadministrateur) {
        this.idadministrateur = idadministrateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idutilisateur;
        hash += (int) idadministrateur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministrateurPK)) {
            return false;
        }
        AdministrateurPK other = (AdministrateurPK) object;
        if (this.idutilisateur != other.idutilisateur) {
            return false;
        }
        if (this.idadministrateur != other.idadministrateur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.AdministrateurPK[ idutilisateur=" + idutilisateur + ", idadministrateur=" + idadministrateur + " ]";
    }
    
}
