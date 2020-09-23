/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.config.Utilisateur;
import com.entities.LoginRequest;
import com.sun.xml.internal.ws.api.message.Packet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Clemy
 */
@Stateless
@Path("utilisateur")
public class UtilisateurFacadeREST extends AbstractFacade<Utilisateur> {
    @PersistenceContext(unitName = "RestaurantPU")
    private EntityManager em;

    public UtilisateurFacadeREST() {
        super(Utilisateur.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Utilisateur entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Utilisateur entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Utilisateur find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Utilisateur> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Utilisateur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Path("login")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response login(LoginRequest data){
        Utilisateur user;
        try {
            Query q=this.getEntityManager().createNamedQuery("Utilisateur.findByLogin",Utilisateur.class);
        q.setParameter("login", data.getLogin());
        q.setParameter("motdepasse", data.getPassword());
        user=(Utilisateur) q.getSingleResult();
        } catch (Exception e) {
            return Response.noContent().entity("UNAUTHORIZED").status(Response.Status.UNAUTHORIZED).build();
        }
        return Response.ok(user).build();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
