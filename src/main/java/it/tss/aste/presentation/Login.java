/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.aste.presentation;


import it.tss.aste.business.boundary.Security;
import it.tss.aste.business.boundary.UsersCache;
import it.tss.aste.business.boundary.UtenteSrv;
import it.tss.aste.presentation.SessionData;
import it.tss.aste.presentation.util.JsfUtil;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Inject;

import javax.inject.Named;

/**
 *
 * @author tss
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    private String email;
    private String pwd;

    @Inject
    Security security;

    @Inject
    SessionData sessiondata;

    @Inject
    UsersCache userscache;

    @Inject
    UtenteSrv utentesrv;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String onLogin() {

        boolean login = security.login(email, pwd);

        if (login) {

            sessiondata.setLoggedUser(email);

            JsfUtil.addSuccessMessage("Login effettuata!!");
            return "utente/List.jsf/faces-redirect=true";

        } else {
            FacesContext.getCurrentInstance().
                    addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Login non effettuato.",
                            ""));
        }

        return "";

    }

}
