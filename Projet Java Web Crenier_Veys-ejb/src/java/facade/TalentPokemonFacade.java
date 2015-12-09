
package facade;

import entity.TalentPokemon;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TalentPokemonFacade extends AbstractFacade<TalentPokemon> implements TalentPokemonFacadeLocal {
    @PersistenceContext(unitName = "Projet_Java_Web_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TalentPokemonFacade() {
        super(TalentPokemon.class);
    }
    
}
