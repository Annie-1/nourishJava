package com.config;

import com.config.Proposer;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Plat.class)
public class Plat_ { 

    public static volatile SingularAttribute<Plat, String> image;
    public static volatile CollectionAttribute<Plat, Proposer> proposerCollection;
    public static volatile SingularAttribute<Plat, BigInteger> prix;
    public static volatile SingularAttribute<Plat, Integer> idplat;
    public static volatile SingularAttribute<Plat, String> nom;
    public static volatile SingularAttribute<Plat, String> info;

}