/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.aste.business.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author tss
 */
@Entity
public class Offerta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Prodotto id_prodotto;
    
    @ManyToOne
    private Utente id_utente;
    
        
    private float prezzo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prodotto getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(Prodotto id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public Utente getId_utente() {
        return id_utente;
    }

    public void setId_utente(Utente id_utente) {
        this.id_utente = id_utente;
    }

   

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offerta)) {
            return false;
        }
        Offerta other = (Offerta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.tss.aste.business.entity.Offerta[ id=" + id + " ]";
    }
    
}
