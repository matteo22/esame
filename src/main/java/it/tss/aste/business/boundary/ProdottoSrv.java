/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.aste.business.boundary;

import it.tss.aste.business.entity.Prodotto;
import it.tss.aste.business.entity.Utente;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Named(value = "prodottoService")
@Stateless
public class ProdottoSrv {
    @PersistenceContext
    private EntityManager em;

    @Inject
    Event<UtenteEvent> event;
    
     public List<Prodotto> findByUtente(Utente u) {
        return em.createNamedQuery("Prodotto.findByUtente", Prodotto.class)
                .setParameter("utente_proprietario", u)
                .getResultList();
        
                
    }

    
}
