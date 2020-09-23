package com.config;

import com.config.Client;
import com.config.Platcommande;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, Date> datecommande;
    public static volatile CollectionAttribute<Commande, Platcommande> platcommandeCollection;
    public static volatile SingularAttribute<Commande, Integer> idcommande;
    public static volatile SingularAttribute<Commande, String> heurecommande;
    public static volatile SingularAttribute<Commande, Client> client;

}