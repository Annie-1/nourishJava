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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Clemy
 */
@Entity
@Table(name = "vote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vote.findAll", query = "SELECT v FROM Vote v"),
    @NamedQuery(name = "Vote.findByIdvote", query = "SELECT v FROM Vote v WHERE v.idvote = :idvote"),
    @NamedQuery(name = "Vote.findByNombre", query = "SELECT v FROM Vote v WHERE v.nombre = :nombre")})
public class Vote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvote")
    private Integer idvote;
    @Column(name = "nombre")
    private Integer nombre;
    @JoinColumns({
        @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur"),
        @JoinColumn(name = "idclient", referencedColumnName = "idclient")})
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "idreservation", referencedColumnName = "idreservation")
    @ManyToOne(optional = false)
    private Reservationrestau idreservation;

    public Vote() {
    }

    public Vote(Integer idvote) {
        this.idvote = idvote;
    }

    public Integer getIdvote() {
        return idvote;
    }

    public void setIdvote(Integer idvote) {
        this.idvote = idvote;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        hash += (idvote != null ? idvote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vote)) {
            return false;
        }
        Vote other = (Vote) object;
        if ((this.idvote == null && other.idvote != null) || (this.idvote != null && !this.idvote.equals(other.idvote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Vote[ idvote=" + idvote + " ]";
    }
    
}
