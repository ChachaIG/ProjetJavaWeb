package controller;

import businessSessionBean.PokemonManagerLocal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelCategorie;
import model.ModelCategorieLangue;

@ManagedBean(name = "categorieController")
@SessionScoped
public class CategorieController implements Serializable {

    @EJB
    private PokemonManagerLocal pokemonSessionBean;
    
    private HashMap<Integer, ModelCategorieLangue> listCategorie = new HashMap<>();
    
    public CategorieController() {
    }

    public PokemonManagerLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public HashMap<Integer, ModelCategorieLangue> getListCategorieByLangue() {
        if (listCategorie.isEmpty())
            listCategorie = getPokemonSessionBean().getListCategorieByLangue(1);
        return listCategorie;
    }
    
    public ModelCategorieLangue getOneCategorieByLangue(int idCategorie) {
        return getListCategorieByLangue().get(idCategorie);
    }

}
