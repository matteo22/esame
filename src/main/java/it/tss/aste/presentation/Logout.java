/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.aste.presentation;


import it.tss.aste.business.boundary.Security;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tss
 */
@Named
@RequestScoped
public class Logout implements Serializable {

    @Inject
    Security security;

    public String onLogout() {
        
        security.logout();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.jsf?faces-redirect-true";
        
    }
}
