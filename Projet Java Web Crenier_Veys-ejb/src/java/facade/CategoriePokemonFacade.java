/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import data.CategoriePokemon;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author charlotte
 */
@Stateless
public class CategoriePokemonFacade extends AbstractFacade<CategoriePokemon> implements CategoriePokemonFacadeLocal {
    @PersistenceContext(unitName = "Projet_Java_Web_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriePokemonFacade() {
        super(CategoriePokemon.class);
    }
    
}
