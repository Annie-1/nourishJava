package com.config;

import com.config.Proposer;
import com.config.Responsablerestaurant;
import com.config.Restaurant;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Agence.class)
public class Agence_ { 

    public static volatile SingularAttribute<Agence, Restaurant> resIdrestaurant;
    public static volatile CollectionAttribute<Agence, Proposer> proposerCollection;
    public static volatile SingularAttribute<Agence, Integer> idrestaurant;
    public static volatile SingularAttribute<Agence, String> libelle;
    public static volatile CollectionAttribute<Agence, Responsablerestaurant> responsablerestaurantCollection;

}