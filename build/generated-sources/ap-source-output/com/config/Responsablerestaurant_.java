package com.config;

import com.config.Agence;
import com.config.Livraison;
import com.config.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Responsablerestaurant.class)
public class Responsablerestaurant_ { 

    public static volatile SingularAttribute<Responsablerestaurant, Integer> idutilisateur;
    public static volatile SingularAttribute<Responsablerestaurant, Agence> idrestaurant;
    public static volatile SingularAttribute<Responsablerestaurant, Utilisateur> utilisateur;
    public static volatile CollectionAttribute<Responsablerestaurant, Livraison> livraisonCollection;
    public static volatile SingularAttribute<Responsablerestaurant, String> cni;

}