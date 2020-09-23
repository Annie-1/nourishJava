package com.config;

import com.config.Commande;
import com.config.Livraison;
import com.config.PlatcommandePK;
import com.config.Proposer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Platcommande.class)
public class Platcommande_ { 

    public static volatile SingularAttribute<Platcommande, Livraison> idlivraison;
    public static volatile SingularAttribute<Platcommande, String> statutlivraison;
    public static volatile SingularAttribute<Platcommande, Proposer> proposer;
    public static volatile SingularAttribute<Platcommande, PlatcommandePK> platcommandePK;
    public static volatile SingularAttribute<Platcommande, Commande> commande;
    public static volatile SingularAttribute<Platcommande, Integer> quantite;

}