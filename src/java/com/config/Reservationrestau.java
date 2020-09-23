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
import javax.persistence.JoinColumns;
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
@Table(name = "reservationrestau")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservationrestau.findAll", query = "SELECT r FROM Reservationrestau r"),
    @NamedQuery(name = "Reservationrestau.findByIdreservation", query = "SELECT r FROM Reservationrestau r WHERE r.idreservation = :idreservation"),
    @NamedQuery(name = "Reservationrestau.findByHeuredebut", query = "SELECT r FROM Reservationrestau r WHERE r.heuredebut = :heuredebut"),
    @NamedQuery(name = "Reservationrestau.findByHeurefin", query = "SELECT r FROM Reservationrestau r WHERE r.heurefin = :heurefin"),
    @NamedQuery(name = "Reservationrestau.findByDate", query = "SELECT r FROM Reservationrestau r WHERE r.date = :date")})
public class Reservationrestau implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreservation")
    private Integer idreservation;
    @Size(max = 254)
    @Column(name = "heuredebut")
    private String heuredebut;
    @Size(max = 254)
    @Column(name = "heurefin")
    private String heurefin;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumns({
        @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur"),
        @JoinColumn(name = "idclient", referencedColumnName = "idclient")})
    @ManyToOne
    private Client client;
    @JoinColumn(name = "idrestaurant", referencedColumnName = "idrestaurant")
    @ManyToOne(optional = false)
    private Restaurant idrestaurant;
    @JoinColumn(name = "idtable", referencedColumnName = "idtable")
    @ManyToOne(optional = false)
    private com.config.Tables idtable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreservation")
    private Collection<Commentaire> commentaireCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreservation")
    private Collection<Vote> voteCollection;

    public Reservationrestau() {
    }

    public Reservationrestau(Integer idreservation) {
        this.idreservation = idreservation;
    }

    public Integer getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(Integer idreservation) {
        this.idreservation = idreservation;
    }

    public String getHeuredebut() {
        return heuredebut;
    }

    public void setHeuredebut(String heuredebut) {
        this.heuredebut = heuredebut;
    }

    public String getHeurefin() {
        return heurefin;
    }

    public void setHeurefin(String heurefin) {
        this.heurefin = heurefin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Restaurant getIdrestaurant() {
        return idrestaurant;
    }

    public void setIdrestaurant(Restaurant idrestaurant) {
        this.idrestaurant = idrestaurant;
    }

    public com.config.Tables getIdtable() {
        return idtable;
    }

    public void setIdtable(com.config.Tables idtable) {
        this.idtable = idtable;
    }

    @XmlTransient
    public Collection<Commentaire> getCommentaireCollection() {
        return commentaireCollection;
    }

    public void setCommentaireCollection(Collection<Commentaire> commentaireCollection) {
        this.commentaireCollection = commentaireCollection;
    }

    @XmlTransient
    public Collection<Vote> getVoteCollection() {
        return voteCollection;
    }

    public void setVoteCollection(Collection<Vote> voteCollection) {
        this.voteCollection = voteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreservation != null ? idreservation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservationrestau)) {
            return false;
        }
        Reservationrestau other = (Reservationrestau) object;
        if ((this.idreservation == null && other.idreservation != null) || (this.idreservation != null && !this.idreservation.equals(other.idreservation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Reservationrestau[ idreservation=" + idreservation + " ]";
    }
    
}
