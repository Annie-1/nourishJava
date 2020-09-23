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
public class PlatcommandePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idpropose")
    private int idpropose;
    @Basic(optional = false)
    @Column(name = "idcommande")
    private int idcommande;

    public PlatcommandePK() {
    }

    public PlatcommandePK(int idpropose, int idcommande) {
        this.idpropose = idpropose;
        this.idcommande = idcommande;
    }

    public int getIdpropose() {
        return idpropose;
    }

    public void setIdpropose(int idpropose) {
        this.idpropose = idpropose;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpropose;
        hash += (int) idcommande;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlatcommandePK)) {
            return false;
        }
        PlatcommandePK other = (PlatcommandePK) object;
        if (this.idpropose != other.idpropose) {
            return false;
        }
        if (this.idcommande != other.idcommande) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.PlatcommandePK[ idpropose=" + idpropose + ", idcommande=" + idcommande + " ]";
    }
    
}
