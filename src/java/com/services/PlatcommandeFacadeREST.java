/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.config.Platcommande;
import com.config.PlatcommandePK;
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
@Path("platcommande")
public class PlatcommandeFacadeREST extends AbstractFacade<Platcommande> {
    @PersistenceContext(unitName = "RestaurantPU")
    private EntityManager em;

    private PlatcommandePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idpropose=idproposeValue;idcommande=idcommandeValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.config.PlatcommandePK key = new com.config.PlatcommandePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idpropose = map.get("idpropose");
        if (idpropose != null && !idpropose.isEmpty()) {
            key.setIdpropose(new java.lang.Integer(idpropose.get(0)));
        }
        java.util.List<String> idcommande = map.get("idcommande");
        if (idcommande != null && !idcommande.isEmpty()) {
            key.setIdcommande(new java.lang.Integer(idcommande.get(0)));
        }
        return key;
    }

    public PlatcommandeFacadeREST() {
        super(Platcommande.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Platcommande entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") PathSegment id, Platcommande entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.config.PlatcommandePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Platcommande find(@PathParam("id") PathSegment id) {
        com.config.PlatcommandePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Platcommande> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Platcommande> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
