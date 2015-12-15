
package businessSessionBean;

import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.Local;
import model.ModelCategorieLangue;
import model.ModelLocalite;
import model.ModelPokemonLangue;
import model.ModelTalentLangue;
import model.ModelTypeLangue;

@Local
public interface PokemonManagerLocal {

    HashMap<Integer, ModelTypeLangue> getListTypeByLangue(Integer idLangue);

    HashMap<Integer, ModelPokemonLangue> getListPokemonByLangue(Integer idLangue);

    HashMap<Integer, ModelCategorieLangue> getListCategorieByLangue(Integer idLangue);

    HashMap<Integer, ModelTalentLangue> getListTalentByLangue(Integer idLangue);

    ArrayList<ModelLocalite> getLocalitesByPostCode(int postCode);
    
}
