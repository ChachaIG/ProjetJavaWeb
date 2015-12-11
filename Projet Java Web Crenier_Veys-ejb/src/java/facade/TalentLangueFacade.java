/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.TalentLangue;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ModelLangue;
import model.ModelTalent;
import model.ModelTalentLangue;

/**
 *
 * @author quentinveys
 */
@Stateless
public class TalentLangueFacade extends AbstractFacade<TalentLangue> implements TalentLangueFacadeLocal {
    @PersistenceContext(unitName = "Projet_Java_Web_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TalentLangueFacade() {
        super(TalentLangue.class);
    }

    @Override
    public ArrayList<ModelTalentLangue> getListTalentByLangue(Integer idLangue) {
        Query query;
        query = em.createNamedQuery("TalentLangue.findByIdlangue");
        query.setParameter("idlangue", idLangue);

        List<TalentLangue> result = query.getResultList();

        return createArrayListModelTypeLangue(result);
    }

    private ArrayList<ModelTalentLangue> createArrayListModelTypeLangue(List<TalentLangue> list) {

        ArrayList<ModelTalentLangue> listType = new ArrayList<>();

        for (TalentLangue l : list) {
            ModelTalentLangue newTypeLangue = convertToModelTalentLangue(l);
            listType.add(newTypeLangue);
        }

        return listType;
    }

    private ModelTalentLangue convertToModelTalentLangue(TalentLangue talentLangue) {
        ModelTalent newTalent = new ModelTalent(talentLangue.getTalentPokemon().getIdtalent());
        ModelLangue newLangue = new ModelLangue(talentLangue.getLangue().getIdlangue(), talentLangue.getLangue().getCodelangue(), talentLangue.getLangue().getLibellelangue());
        return new ModelTalentLangue(newTalent, newLangue, talentLangue.getLibelletalent(), talentLangue.getDescriptiontalent());
    }
}
