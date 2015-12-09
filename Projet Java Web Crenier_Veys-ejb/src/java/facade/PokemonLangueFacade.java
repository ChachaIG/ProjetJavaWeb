package facade;

import entity.Pokemon;
import entity.PokemonLangue;
import entity.TypePokemon;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ModelCategorie;
import model.ModelLangue;
import model.ModelPokemon;
import model.ModelPokemonLangue;
import model.ModelPromo;
import model.ModelType;

@Stateless
public class PokemonLangueFacade extends AbstractFacade<PokemonLangue> implements PokemonLangueFacadeLocal {

    @PersistenceContext(unitName = "Projet_Java_Web_Crenier_Veys-ejbPU")
    private EntityManager em;

    ;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PokemonLangueFacade() {
        super(PokemonLangue.class);
    }

    @Override
    public ArrayList<ModelPokemonLangue> getListPokemonByLangue(Integer idLangue) {
        Query query;
        query = em.createNamedQuery("PokemonLangue.findByIdlangue");
        query.setParameter("idlangue", idLangue);
        List<PokemonLangue> result = query.getResultList();

        ArrayList<ModelPokemonLangue> listPokemon = new ArrayList<>();
        for (PokemonLangue r : result) {
            Pokemon p = r.getPokemon();

            ArrayList<ModelType> listType = new ArrayList<>();
            for (TypePokemon type : p.getTypePokemonCollection()) {
                ModelType newType = convertToModelType(type);
                listType.add(newType);
            }

            ArrayList<ModelType> listFaiblesse = new ArrayList<>();
            for (TypePokemon faiblesse : p.getTypePokemonCollection1()) {
                ModelType newType = convertToModelType(faiblesse);
                listFaiblesse.add(newType);
            }

            ModelCategorie newCategorie = new ModelCategorie(p.getIdcategorie().getIdcategorie());
            ModelPokemon newPokemon = new ModelPokemon(p.getIdpokemon(), p.getCheminImg(), p.getTaille().doubleValue(), p.getPoids().doubleValue(), p.getPointsVie(), p.getPointsAttaque(), p.getPointsDefense(), p.getPointsASpeciale(), p.getPointsDSpeciale(), p.getPointsVitesse(), p.getPrix().doubleValue(), newCategorie, listType, listFaiblesse);
            ModelLangue newLangue = new ModelLangue(r.getLangue().getIdlangue(), r.getLangue().getCodelangue(), r.getLangue().getLibellelangue());
            ModelPokemonLangue newPokemonLangue = new ModelPokemonLangue(newLangue, newPokemon, r.getLibellepokemon(), r.getDescriptionpokemon());
            listPokemon.add(newPokemonLangue);
        }

        return listPokemon;
    }

    private ModelType convertToModelType(TypePokemon type) {
        ModelPromo newPromo;
        try {
            newPromo = new ModelPromo(type.getCodepromotion().getCodepromo(), type.getCodepromotion().getPourcentagepromo().doubleValue());
        } catch (NullPointerException e) {
            newPromo = null;
        }
        return new ModelType(type.getIdtype(), newPromo);
    }
}
