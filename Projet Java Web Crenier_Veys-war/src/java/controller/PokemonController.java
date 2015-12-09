package controller;

import businessSessionBean.PokemonManagerLocal;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelPokemonLangue;

@ManagedBean(name = "pokemonController")
@SessionScoped
public class PokemonController implements Serializable {

    @EJB
    private PokemonManagerLocal pokemonSessionBean;

    private ArrayList<ModelPokemonLangue> listPokemon = null;
    private ModelPokemonLangue currentPokemon = null;

    public PokemonController() {
    }

    public PokemonManagerLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public ArrayList<ModelPokemonLangue> getListPokemonByLangue() {
        //if (list == null) {
        //Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        listPokemon = getPokemonSessionBean().getListPokemonByLangue(1);
        //}
        return listPokemon;
    }
    
    public String details(ModelPokemonLangue pokemon) {
        currentPokemon = pokemon;
        return "details?faces-redirect=true";
    }
    
    public String type() {
        return "Type";
    }

    public ModelPokemonLangue getCurrentPokemon() {
        return currentPokemon;
    }

    public void setCurrentPokemon(ModelPokemonLangue currentPokemon) {
        this.currentPokemon = currentPokemon;
    }

    public ArrayList<ModelPokemonLangue> getListPokemon() {
        return listPokemon;
    }

    public void setListPokemon(ArrayList<ModelPokemonLangue> listPokemon) {
        this.listPokemon = listPokemon;
    }
    
    public ModelPokemonLangue getNext() {
        int i = listPokemon.indexOf(currentPokemon) + 1;
        if (i >= listPokemon.size()) i = 0;
        return listPokemon.get(i);
    }
    
    public ModelPokemonLangue getPrevious() {
        int i = listPokemon.indexOf(currentPokemon) - 1;
        if (i < 0) i = listPokemon.size() - 1;
        return listPokemon.get(i);
    }
}
