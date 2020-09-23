package com.config;

import com.config.Client;
import com.config.Commentaire;
import com.config.Restaurant;
import com.config.Tables;
import com.config.Vote;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Reservationrestau.class)
public class Reservationrestau_ { 

    public static volatile SingularAttribute<Reservationrestau, Date> date;
    public static volatile SingularAttribute<Reservationrestau, Tables> idtable;
    public static volatile CollectionAttribute<Reservationrestau, Vote> voteCollection;
    public static volatile SingularAttribute<Reservationrestau, Restaurant> idrestaurant;
    public static volatile SingularAttribute<Reservationrestau, Integer> idreservation;
    public static volatile CollectionAttribute<Reservationrestau, Commentaire> commentaireCollection;
    public static volatile SingularAttribute<Reservationrestau, Client> client;
    public static volatile SingularAttribute<Reservationrestau, String> heuredebut;
    public static volatile SingularAttribute<Reservationrestau, String> heurefin;

}