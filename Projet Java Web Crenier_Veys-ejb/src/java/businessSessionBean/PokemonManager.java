
package businessSessionBean;

import facade.CategorieLangueFacadeLocal;
import facade.PokemonLangueFacadeLocal;
import facade.TypeLangueFacadeLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.ModelCategorieLangue;
import model.ModelPokemonLangue;
import model.ModelTypeLangue;

@Stateless
public class PokemonManager implements PokemonManagerLocal {

    @EJB
    private TypeLangueFacadeLocal typeLangue;
    @EJB
    private PokemonLangueFacadeLocal pokemonLangue;
    @EJB
    private CategorieLangueFacadeLocal categorieLangue;

    @Override
    public ArrayList<ModelTypeLangue> getListTypeByLangue(Integer idLangue) {
        return typeLangue.getListTypeByLangue(idLangue);
    }

    @Override
    public ArrayList<ModelPokemonLangue> getListPokemonByLangue(Integer idLangue) {
        return pokemonLangue.getListPokemonByLangue(idLangue);
    }

    @Override
    public ArrayList<ModelCategorieLangue> getListCategorieByLangue(Integer idLangue) {
        return categorieLangue.getListCategorieByLangue(idLangue);
    }

    
}
