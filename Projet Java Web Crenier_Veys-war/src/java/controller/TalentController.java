package controller;

import businessSessionBean.PokemonManagerLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelTalent;
import model.ModelTalentLangue;

@ManagedBean(name = "talentController")
@SessionScoped
public class TalentController implements Serializable {

    @EJB
    private PokemonManagerLocal pokemonSessionBean;
    
    private HashMap<Integer, ModelTalentLangue> listTalent = new HashMap<>();
    
    public TalentController() {
    }

    public PokemonManagerLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public HashMap<Integer, ModelTalentLangue> getListTalentByLangue() {
        if (listTalent.isEmpty())
            listTalent = getPokemonSessionBean().getListTalentByLangue(1);
        return listTalent;
    }
    
    public ModelTalentLangue getOneTalentByLangue(int idTalent) {
        return getListTalentByLangue().get(idTalent);
    }

}
