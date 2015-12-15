package controller;

import businessSessionBean.PokemonManagerLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelType;
import model.ModelTypeLangue;

@ManagedBean(name = "typeController")
@SessionScoped
public class TypeController implements Serializable {

    @EJB
    private PokemonManagerLocal pokemonSessionBean;

    private HashMap<Integer, ModelTypeLangue> listType = new HashMap<>();

    public TypeController() {
    }

    public PokemonManagerLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public HashMap<Integer, ModelTypeLangue> getListTypeByLangue() {
        //if (list == null) {
        //Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        if (listType.isEmpty())
            listType = getPokemonSessionBean().getListTypeByLangue(1);
//        Collections.sort(listType.values(), new Comparator<ModelTypeLangue>() {
//            @Override
//            public int compare(ModelTypeLangue o1, ModelTypeLangue o2) {
//                return o1.getLibelleType().compareTo(o2.getLibelleType());
//            }
//        }
//        );
        return listType;
    }

    public ModelTypeLangue getOneTypeByLangue(int idType) {
        return getListTypeByLangue().get(idType);
    }
}
