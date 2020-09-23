package com.config;

import com.config.Proposer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-19T16:14:28")
@StaticMetamodel(Categorieplat.class)
public class Categorieplat_ { 

    public static volatile SingularAttribute<Categorieplat, Integer> idcategorieplat;
    public static volatile CollectionAttribute<Categorieplat, Proposer> proposerCollection;
    public static volatile SingularAttribute<Categorieplat, String> libelle;
    public static volatile SingularAttribute<Categorieplat, String> nom;

}