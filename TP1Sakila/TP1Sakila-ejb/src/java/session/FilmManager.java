/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Film;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alejo
 */
@Stateless
@LocalBean
public class FilmManager {
    
    @PersistenceContext(unitName = "TP1Sakila-ejbPU")
    private EntityManager em;
    
    public void persist(Object object){
        em.persist(object);
    }
    
    public List<Film> getFilm(){
        Query query = em.createNamedQuery("Film.findAll");
        return query.getResultList();
    }
    
    public Film update(Film film){
        return em.merge(film);
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
