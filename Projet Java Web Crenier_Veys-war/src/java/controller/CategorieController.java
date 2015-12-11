package controller;

import businessSessionBean.PokemonManagerLocal;
import java.io.Serializable;
import java.util.ArrayList;
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
    
    private ArrayList<ModelCategorieLangue> listCategorie = null;
    
    public CategorieController() {
    }

    public PokemonManagerLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public ArrayList<ModelCategorieLangue> getListCategorieByLangue() {
        listCategorie = getPokemonSessionBean().getListCategorieByLangue(1);
        return listCategorie;
    }
    
    public ModelCategorieLangue getOneCategorieByLangue(ModelCategorie categorie) {
        if (listCategorie == null){
            listCategorie = getListCategorieByLangue();
        }
        
        Iterator<ModelCategorieLangue> iterator = listCategorie.iterator();
        int i = 0;
        while (iterator.hasNext() && !iterator.next().getCategorie().getIdCategorie().equals(categorie.getIdCategorie())) {
            i++;
        }
        return listCategorie.get(i);
    }

}
