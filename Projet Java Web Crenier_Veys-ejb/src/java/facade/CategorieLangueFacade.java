/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.CategorieLangue;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ModelCategorie;
import model.ModelCategorieLangue;
import model.ModelLangue;

/**
 *
 * @author quentinveys
 */
@Stateless
public class CategorieLangueFacade extends AbstractFacade<CategorieLangue> implements CategorieLangueFacadeLocal {
    @PersistenceContext(unitName = "Projet_Java_Web_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorieLangueFacade() {
        super(CategorieLangue.class);
    }

    @Override
    public ArrayList<ModelCategorieLangue> getListCategorieByLangue(Integer idLangue) {
        Query query;
        query = em.createNamedQuery("CategorieLangue.findByIdlangue");
        query.setParameter("idlangue", idLangue);

        List<CategorieLangue> result = query.getResultList();

        return createArrayListModelCategorieLangue(result);
    }

    private ArrayList<ModelCategorieLangue> createArrayListModelCategorieLangue(List<CategorieLangue> list) {

        ArrayList<ModelCategorieLangue> listCategorie = new ArrayList<>();

        for (CategorieLangue l : list) {
            ModelCategorieLangue newCategorieLangue = convertToModelCategorieLangue(l);
            listCategorie.add(newCategorieLangue);
        }

        return listCategorie;
    }

    private ModelCategorieLangue convertToModelCategorieLangue(CategorieLangue categorie) {
        ModelLangue newLangue = new ModelLangue(categorie.getLangue().getIdlangue(), categorie.getLangue().getCodelangue(), categorie.getLangue().getLibellelangue());
        ModelCategorie newCategorie = new ModelCategorie(categorie.getCategoriePokemon().getIdcategorie());
        return new ModelCategorieLangue(newCategorie, newLangue, categorie.getLibellecategorie());
    }
}
