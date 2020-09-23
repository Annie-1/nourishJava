package com.config;

import com.config.Agence;
import com.config.Categorieplat;
import com.config.Commentaire;
import com.config.Plat;
import com.config.Platcommande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Proposer.class)
public class Proposer_ { 

    public static volatile CollectionAttribute<Proposer, Platcommande> platcommandeCollection;
    public static volatile SingularAttribute<Proposer, Categorieplat> idcategorieplat;
    public static volatile SingularAttribute<Proposer, Agence> idrestaurant;
    public static volatile CollectionAttribute<Proposer, Commentaire> commentaireCollection;
    public static volatile SingularAttribute<Proposer, Integer> quantiteproposee;
    public static volatile SingularAttribute<Proposer, Plat> idplat;
    public static volatile SingularAttribute<Proposer, Integer> idpropose;
    public static volatile SingularAttribute<Proposer, Integer> quantiteseuille;
    public static volatile SingularAttribute<Proposer, Boolean> etat;

}