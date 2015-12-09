
package businessSessionBean;

import java.util.ArrayList;
import javax.ejb.Local;
import model.ModelCategorieLangue;
import model.ModelPokemonLangue;
import model.ModelTypeLangue;

@Local
public interface PokemonManagerLocal {

    ArrayList<ModelTypeLangue> getListTypeByLangue(Integer idLangue);

    ArrayList<ModelPokemonLangue> getListPokemonByLangue(Integer idLangue);

    ArrayList<ModelCategorieLangue> getListCategorieByLangue(Integer idLangue);

   
    
}
