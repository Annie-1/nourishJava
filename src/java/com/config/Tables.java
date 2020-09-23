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
@Table(name = "tables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tables.findAll", query = "SELECT t FROM Tables t"),
    @NamedQuery(name = "Tables.findByIdtable", query = "SELECT t FROM Tables t WHERE t.idtable = :idtable"),
    @NamedQuery(name = "Tables.findByNombreplace", query = "SELECT t FROM Tables t WHERE t.nombreplace = :nombreplace"),
    @NamedQuery(name = "Tables.findByNumero", query = "SELECT t FROM Tables t WHERE t.numero = :numero"),
    @NamedQuery(name = "Tables.findByType", query = "SELECT t FROM Tables t WHERE t.type = :type"),
    @NamedQuery(name = "Tables.findByPrix", query = "SELECT t FROM Tables t WHERE t.prix = :prix")})
public class Tables implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtable")
    private Integer idtable;
    @Column(name = "nombreplace")
    private Integer nombreplace;
    @Size(max = 254)
    @Column(name = "numero")
    private String numero;
    @Size(max = 254)
    @Column(name = "type")
    private String type;
    @Column(name = "prix")
    private Integer prix;

    public Tables() {
    }

    public Tables(Integer idtable) {
        this.idtable = idtable;
    }

    public Integer getIdtable() {
        return idtable;
    }

    public void setIdtable(Integer idtable) {
        this.idtable = idtable;
    }

    public Integer getNombreplace() {
        return nombreplace;
    }

    public void setNombreplace(Integer nombreplace) {
        this.nombreplace = nombreplace;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtable != null ? idtable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tables)) {
            return false;
        }
        Tables other = (Tables) object;
        if ((this.idtable == null && other.idtable != null) || (this.idtable != null && !this.idtable.equals(other.idtable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.config.Tables[ idtable=" + idtable + " ]";
    }
    
}
