/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.aste.business.boundary;


import it.tss.aste.business.entity.Utente;
import it.tss.aste.presentation.SessionData;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author tss
 */
@Named
    @Stateless
public class Security {

    @Inject
    private UtenteSrv utenteSrv;

    @Inject
    UsersCache usersCache;

    @Inject
    SessionData sessionData;

    public boolean login(String usr, String pwd) {
        try {
            Utente u = utenteSrv.findByUsrPwd(usr, pwd);
            usersCache.addUser(u);
           
            return true;
        } catch (EJBException ex) {
            return false;
        }

    }

    public void logout() {
        logout(
            utenteSrv.findByNick(sessionData.getLoggedUser()));
    }

    public void logout(Utente u) {
        usersCache.removeUser(u);
        
    }
}

    

