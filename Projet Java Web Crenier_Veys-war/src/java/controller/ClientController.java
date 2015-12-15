package controller;

import businessSessionBean.PokemonManagerLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
        String postCodeString = Integer.toString(getPostCode());
        if (!postCodeString.isEmpty()) {
            if (!postCodeString.matches("[0-9]{4}")) {
                return new ArrayList<>();
            } else {
                if (getPostCode() < 1000 || getPostCode() > 9999) {
                   return new ArrayList<>();
                } else {
                    ArrayList<ModelLocalite> newLocalites = getPokemonSessionBean().getLocalitesByPostCode(getPostCode());
                    if (newLocalites.size() > 0) {
                        return newLocalites;
                    } else {
                        return new ArrayList<>();
                    }
                }
            }
        } else {
        return new ArrayList<>();
        }
    }

}
