package com.config;

import com.config.Client;
import com.config.Proposer;
import com.config.Reservationrestau;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Commentaire.class)
public class Commentaire_ { 

    public static volatile SingularAttribute<Commentaire, Integer> idcommentaire;
    public static volatile SingularAttribute<Commentaire, Reservationrestau> idreservation;
    public static volatile SingularAttribute<Commentaire, String> libelle;
    public static volatile SingularAttribute<Commentaire, Client> client;
    public static volatile SingularAttribute<Commentaire, Proposer> idpropose;

}