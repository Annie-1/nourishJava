package com.config;

import com.config.ClientPK;
import com.config.Commande;
import com.config.Commentaire;
import com.config.Reservationrestau;
import com.config.Utilisateur;
import com.config.Vote;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, ClientPK> clientPK;
    public static volatile CollectionAttribute<Client, Vote> voteCollection;
    public static volatile SingularAttribute<Client, Utilisateur> utilisateur;
    public static volatile CollectionAttribute<Client, Commentaire> commentaireCollection;
    public static volatile CollectionAttribute<Client, Reservationrestau> reservationrestauCollection;
    public static volatile CollectionAttribute<Client, Commande> commandeCollection;

}