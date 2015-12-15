package controller;

import businessSessionBean.PokemonManagerLocal;
import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelPokemonLangue;

@ManagedBean(name = "pokemonController")
@SessionScoped
public class PokemonController implements Serializable {

    @EJB
    private PokemonManagerLocal pokemonSessionBean;
    
    private HashMap<Integer, ModelPokemonLangue> hashMapPokemon = new HashMap<>();
    private ModelPokemonLangue currentPokemon = null;

    public PokemonController() {
    }

    public PokemonManagerLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public HashMap<Integer, ModelPokemonLangue> getListPokemonByLangue() {
        //if (list == null) {
        //Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        if (hashMapPokemon.isEmpty())
            hashMapPokemon = getPokemonSessionBean().getListPokemonByLangue(1);
        //}
        return hashMapPokemon;
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
    
    public ModelPokemonLangue getNext() {
        int i = getCurrentPokemon().getPokemon().getIdPokemon().intValue() + 1;
        if (i >= getListPokemonByLangue().size()) i = 1;
        return getListPokemonByLangue().get(i);
    }
    
    public ModelPokemonLangue getPrevious() {
        int i = getCurrentPokemon().getPokemon().getIdPokemon().intValue() - 1;
        if (i <= 0) i = getListPokemonByLangue().size();
        return getListPokemonByLangue().get(i);
    }
    
    public int getStatsPourc(int points) {
        return (100 - (points * 10));
    }
    
    public ModelPokemonLangue getOnePokemonByLangue(int idPokemon) {
        return getListPokemonByLangue().get(idPokemon);
    }
}
