package controller;

import businessSessionBean.PokemonManagerLocal;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.ValidatorException;
import model.ModelClient;
import model.ModelLocalite;

@ManagedBean
@SessionScoped
public class ClientController {

    @EJB
    private PokemonManagerLocal pokemonSessionBean;

    private ModelClient client = null;

    private int postCode = 1000;

    public ClientController() {
    }

    public ModelClient getClient() {
        return client;
    }

    public void setClient(ModelClient client) {
        this.client = client;
    }

    public PokemonManagerLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public ArrayList<ModelLocalite> getLocaliteByPostCode() {
        ArrayList<ModelLocalite> newLocalites = getPokemonSessionBean().getLocalitesByPostCode(getPostCode());
        if (newLocalites.size() > 0) {
            return newLocalites;
        } else {
            return new ArrayList<>();
        }
    }
}
