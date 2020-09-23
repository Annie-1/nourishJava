/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Clemy
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.config.GenericResource.class);
        resources.add(com.services.AdministrateurFacadeREST.class);
        resources.add(com.services.AgenceFacadeREST.class);
        resources.add(com.services.CategorieplatFacadeREST.class);
        resources.add(com.services.CategorierestaurantFacadeREST.class);
        resources.add(com.services.ClientFacadeREST.class);
        resources.add(com.services.CommandeFacadeREST.class);
        resources.add(com.services.CommentaireFacadeREST.class);
        resources.add(com.services.LivraisonFacadeREST.class);
        resources.add(com.services.PlatFacadeREST.class);
        resources.add(com.services.PlatcommandeFacadeREST.class);
        resources.add(com.services.ProposerFacadeREST.class);
        resources.add(com.services.ReservationrestauFacadeREST.class);
        resources.add(com.services.ResponsablerestaurantFacadeREST.class);
        resources.add(com.services.RestaurantFacadeREST.class);
        resources.add(com.services.TablesFacadeREST.class);
        resources.add(com.services.UtilisateurFacadeREST.class);
        resources.add(com.services.VoteFacadeREST.class);
    }
    
}
