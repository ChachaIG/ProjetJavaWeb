package businessSessionBean;

import facade.CategorieLangueFacadeLocal;
import facade.LocaliteFacadeLocal;
import facade.PokemonLangueFacadeLocal;
import facade.TalentLangueFacadeLocal;
import facade.TypeLangueFacadeLocal;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.ModelCategorieLangue;
import model.ModelLocalite;
import model.ModelPokemonLangue;
import model.ModelTalentLangue;
import model.ModelTypeLangue;

@Stateless
public class PokemonManager implements PokemonManagerLocal {

    @EJB
    private TypeLangueFacadeLocal typeLangue;
    @EJB
    private PokemonLangueFacadeLocal pokemonLangue;
    @EJB
    private CategorieLangueFacadeLocal categorieLangue;
    @EJB
    private TalentLangueFacadeLocal talentLangue;
    @EJB
    private LocaliteFacadeLocal localite;

    @Override
    public HashMap<Integer, ModelTypeLangue> getListTypeByLangue(Integer idLangue) {
        return typeLangue.getListTypeByLangue(idLangue);
    }

    @Override
    public HashMap<Integer, ModelPokemonLangue> getListPokemonByLangue(Integer idLangue) {
        return pokemonLangue.getListPokemonByLangue(idLangue);
    }

    @Override
    public HashMap<Integer, ModelCategorieLangue> getListCategorieByLangue(Integer idLangue) {
        return categorieLangue.getListCategorieByLangue(idLangue);
    }

    @Override
    public HashMap<Integer, ModelTalentLangue> getListTalentByLangue(Integer idLangue) {
        return talentLangue.getListTalentByLangue(idLangue);
    }

    @Override
    public ArrayList<ModelLocalite> getLocalitesByPostCode(int postCode) {
        return localite.getLocalitesByPostCode(postCode);
    }

}
