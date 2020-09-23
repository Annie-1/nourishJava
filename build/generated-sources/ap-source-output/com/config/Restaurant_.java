package com.config;

import com.config.Agence;
import com.config.Categorierestaurant;
import com.config.Reservationrestau;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Restaurant.class)
public class Restaurant_ { 

    public static volatile CollectionAttribute<Restaurant, Agence> agenceCollection;
    public static volatile SingularAttribute<Restaurant, String> image;
    public static volatile SingularAttribute<Restaurant, Integer> idrestaurant;
    public static volatile SingularAttribute<Restaurant, String> siteweb;
    public static volatile SingularAttribute<Restaurant, Categorierestaurant> idcategorierestaurant;
    public static volatile SingularAttribute<Restaurant, String> nom;
    public static volatile CollectionAttribute<Restaurant, Reservationrestau> reservationrestauCollection;

}