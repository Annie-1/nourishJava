package com.config;

import com.config.Platcommande;
import com.config.Responsablerestaurant;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Livraison.class)
public class Livraison_ { 

    public static volatile SingularAttribute<Livraison, Date> date;
    public static volatile SingularAttribute<Livraison, Responsablerestaurant> idutilisateur;
    public static volatile SingularAttribute<Livraison, Integer> idlivraison;
    public static volatile CollectionAttribute<Livraison, Platcommande> platcommandeCollection;
    public static volatile SingularAttribute<Livraison, String> code;
    public static volatile SingularAttribute<Livraison, Integer> prixlivraison;
    public static volatile SingularAttribute<Livraison, String> lieux;

}