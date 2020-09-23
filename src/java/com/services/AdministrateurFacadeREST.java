/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.config.Administrateur;
import com.config.AdministrateurPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Clemy
 */
@Stateless
@Path("administrateur")
public class AdministrateurFacadeREST extends AbstractFacade<Administrateur> {
    @PersistenceContext(unitName = "RestaurantPU")
    private EntityManager em;

    private AdministrateurPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idutilisateur=idutilisateurValue;idadministrateur=idadministrateurValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.config.AdministrateurPK key = new com.config.AdministrateurPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idutilisateur = map.get("idutilisateur");
        if (idutilisateur != null && !idutilisateur.isEmpty()) {
            key.setIdutilisateur(new java.lang.Integer(idutilisateur.get(0)));
        }
        java.util.List<String> idadministrateur = map.get("idadministrateur");
        if (idadministrateur != null && !idadministrateur.isEmpty()) {
            key.setIdadministrateur(new java.lang.Integer(idadministrateur.get(0)));
        }
        return key;
    }

    public AdministrateurFacadeREST() {
        super(Administrateur.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Administrateur entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") PathSegment id, Administrateur entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.config.AdministrateurPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Administrateur find(@PathParam("id") PathSegment id) {
        com.config.AdministrateurPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Administrateur> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Administrateur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
