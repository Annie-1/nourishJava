create table administrateur (
   idutilisateur        serial                 not null,
   idadministrateur     serial                 not null,
   constraint pk_administrateur primary key (idutilisateur, idadministrateur)
);

create table agence (
   idrestaurant         serial                 not null,
   res_idrestaurant     int4                 null,
   libelle              varchar(254)         null,
   constraint pk_agence primary key (idrestaurant)
);

create table categorieplat (
   idcategorieplat      serial               not null,
   libelle              varchar(254)         null,
   nom                  varchar(254)         null,
   constraint pk_categorieplat primary key (idcategorieplat)
);

create table categorierestaurant (
   idcategorierestaurant serial                 not null,
   nom                  varchar(254)         null,
   string               varchar(254)         null,
   constraint pk_categorierestaurant primary key (idcategorierestaurant)
);

create table client (
   idutilisateur        serial                 not null,
   idclient             serial                 not null,
   constraint pk_client primary key (idutilisateur, idclient)
);

create table commande (
   idcommande           serial                 not null,
   idutilisateur        int4                 not null,
   idclient             int4                 not null,
   datecommande         date                 null,
   heurecommande        varchar(254)         null,
   constraint pk_commande primary key (idcommande)
);

create table commentaire (
   idcommentaire        serial                 not null,
   idutilisateur        int4                 not null,
   idclient             int4                 not null,
   idreservation        int4                 not null,
   idpropose            int4                 not null,
   libelle              varchar(254)         null,
   constraint pk_commentaire primary key (idcommentaire)
);

create table livraison (
   idlivraison          serial                 not null,
   idutilisateur        int4                 not null,
   lieux                varchar(254)         null,
   date                 date                 null,
   code                 varchar(254)         null,
   prixlivraison        int4                 null,
   constraint pk_livraison primary key (idlivraison)
);

create table plat (
   idplat               serial                 not null,
   nom                  varchar(254)         null,
   prix                 numeric              null,
   info                 varchar(254)         null,
   image                varchar(254)         null,
   constraint pk_plat primary key (idplat)
);

create table platcommande (
   idpropose            serial                 not null,
   idcommande           serial                 not null,
   idlivraison          int4                 not null,
   quantite             int4                 null,
   statutlivraison      varchar(254)         null,
   constraint pk_platcommande primary key (idpropose, idcommande)
);

create table proposer (
   idpropose            serial               not null,
   idplat               int4                 not null,
   idrestaurant         int4                 not null,
   idcategorieplat      int4                 null,
   etat                 bool                 not null,
   quantiteseuille      int4                 null,
   quantiteproposee     int4                 null,
   constraint pk_proposer primary key (idpropose)
);

create table reservationrestau (
   idreservation        serial                 not null,
   idtable              int4                 not null,
   idrestaurant         int4                 not null,
   idutilisateur        int4                 null,
   idclient             int4                 null,
   heuredebut           varchar(254)         null,
   heurefin             varchar(254)         null,
   date                 date                 null,
   constraint pk_reservationrestau primary key (idreservation)
);

create table responsablerestaurant (
   idutilisateur        serial                 not null,
   idrestaurant         int4                 not null,
   cni                  varchar(254)         null,
   constraint pk_responsablerestaurant primary key (idutilisateur)
);

create table restaurant (
   idrestaurant         serial                 not null,
   idcategorierestaurant int4                 not null,
   nom                  varchar(254)         null,
   siteweb              varchar(254)         null,
   image                varchar(254)         null,
   constraint pk_restaurant primary key (idrestaurant)
);

create table "table" (
   idtable              serial                 not null,
   nombreplace          int4                 null,
   numero               varchar(254)         null,
   type                 varchar(254)         null,
   prix                 int4                 null,
   constraint pk_table primary key (idtable)
);

create table utilisateur (
   idutilisateur        serial                 not null,
   nom                  varchar(254)         null,
   prenom               varchar(254)         null,
   telephone            varchar(254)         null,
   login                varchar(254)         null,
   motdepasse           varchar(254)         null,
   image                varchar(254)         null,
   constraint pk_utilisateur primary key (idutilisateur)
);

create table vote (
   idvote               int4                 not null,
   idutilisateur        int4                 not null,
   idclient             int4                 not null,
   idreservation        int4                 not null,
   nombre               int4                 null,
   constraint pk_vote primary key (idvote)
);

alter table administrateur
   add constraint fk_administ_generalis_utilisat foreign key (idutilisateur)
      references utilisateur (idutilisateur)
      on delete restrict on update restrict;

alter table agence
   add constraint fk_agence_associati_restaura foreign key (res_idrestaurant)
      references restaurant (idrestaurant)
      on delete restrict on update restrict;

alter table client
   add constraint fk_client_generalis_utilisat foreign key (idutilisateur)
      references utilisateur (idutilisateur)
      on delete restrict on update restrict;

alter table commande
   add constraint fk_commande_associati_client foreign key (idutilisateur, idclient)
      references client (idutilisateur, idclient)
      on delete restrict on update restrict;

alter table commentaire
   add constraint fk_commenta_associati_proposer foreign key (idpropose)
      references proposer (idpropose)
      on delete restrict on update restrict;

alter table commentaire
   add constraint fk_commenta_associati_client foreign key (idutilisateur, idclient)
      references client (idutilisateur, idclient)
      on delete restrict on update restrict;

alter table commentaire
   add constraint fk_commenta_associati_reservat foreign key (idreservation)
      references reservationrestau (idreservation)
      on delete restrict on update restrict;

alter table livraison
   add constraint fk_livraiso_associati_responsa foreign key (idutilisateur)
      references responsablerestaurant (idutilisateur)
      on delete restrict on update restrict;

alter table platcommande
   add constraint fk_platcomm_associati_commande foreign key (idcommande)
      references commande (idcommande)
      on delete restrict on update restrict;

alter table platcommande
   add constraint fk_platcomm_associati_proposer foreign key (idpropose)
      references proposer (idpropose)
      on delete restrict on update restrict;

alter table platcommande
   add constraint fk_platcomm_associati_livraiso foreign key (idlivraison)
      references livraison (idlivraison)
      on delete restrict on update restrict;

alter table proposer
   add constraint fk_proposer_associati_categori foreign key (idcategorieplat)
      references categorieplat (idcategorieplat)
      on delete restrict on update restrict;

alter table proposer
   add constraint fk_proposer_associati_plat foreign key (idplat)
      references plat (idplat)
      on delete restrict on update restrict;

alter table proposer
   add constraint fk_proposer_associati_agence foreign key (idrestaurant)
      references agence (idrestaurant)
      on delete restrict on update restrict;

alter table reservationrestau
   add constraint fk_reservat_associati_client foreign key (idutilisateur, idclient)
      references client (idutilisateur, idclient)
      on delete restrict on update restrict;

alter table reservationrestau
   add constraint fk_reservat_associati_restaura foreign key (idrestaurant)
      references restaurant (idrestaurant)
      on delete restrict on update restrict;

alter table reservationrestau
   add constraint fk_reservat_associati_table foreign key (idtable)
      references "table" (idtable)
      on delete restrict on update restrict;

alter table responsablerestaurant
   add constraint fk_responsa_generalis_utilisat foreign key (idutilisateur)
      references utilisateur (idutilisateur)
      on delete restrict on update restrict;

alter table responsablerestaurant
   add constraint fk_responsa_associati_agence foreign key (idrestaurant)
      references agence (idrestaurant)
      on delete restrict on update restrict;

alter table restaurant
   add constraint fk_restaura_associati_categori foreign key (idcategorierestaurant)
      references categorierestaurant (idcategorierestaurant)
      on delete restrict on update restrict;

alter table vote
   add constraint fk_vote_associati_reservat foreign key (idreservation)
      references reservationrestau (idreservation)
      on delete restrict on update restrict;

alter table vote
   add constraint fk_vote_associati_client foreign key (idutilisateur, idclient)
      references client (idutilisateur, idclient)
      on delete restrict on update restrict;

