package controller;

import businessSessionBean.PokemonManagerLocal;
import java.io.Serializable;
import java.util.ArrayList;
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
    
    private ArrayList<ModelTalentLangue> listTalent = null;
    
    public TalentController() {
    }

    public PokemonManagerLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public ArrayList<ModelTalentLangue> getListTalentByLangue() {
        listTalent = getPokemonSessionBean().getListTalentByLangue(1);
        return listTalent;
    }
    
    public ModelTalentLangue getOneTalentByLangue(ModelTalent talent) {
        if (listTalent == null){
            listTalent = getListTalentByLangue();
        }
        
        Iterator<ModelTalentLangue> iterator = listTalent.iterator();
        int i = 0;
        while (iterator.hasNext() && !iterator.next().getTalent().getIdTalent().equals(talent.getIdTalent())) {
            i++;
        }
        return listTalent.get(i);
    }

}
