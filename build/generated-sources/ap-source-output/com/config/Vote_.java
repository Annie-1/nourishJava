package com.config;

import com.config.Client;
import com.config.Reservationrestau;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Vote.class)
public class Vote_ { 

    public static volatile SingularAttribute<Vote, Integer> idvote;
    public static volatile SingularAttribute<Vote, Reservationrestau> idreservation;
    public static volatile SingularAttribute<Vote, Client> client;
    public static volatile SingularAttribute<Vote, Integer> nombre;

}