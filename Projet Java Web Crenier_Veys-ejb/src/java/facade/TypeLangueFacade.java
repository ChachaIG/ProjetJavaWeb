
package facade;

import entity.TypeLangue;
import entity.TypePokemon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ModelLangue;
import model.ModelPromo;
import model.ModelType;
import model.ModelTypeLangue;

@Stateless
public class TypeLangueFacade extends AbstractFacade<TypeLangue> implements TypeLangueFacadeLocal {

    @PersistenceContext(unitName = "Projet_Java_Web_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeLangueFacade() {
        super(TypeLangue.class);
    }

    @Override
    public HashMap<Integer, ModelTypeLangue> getListTypeByLangue(Integer idLangue) {
        Query query;
        query = em.createNamedQuery("TypeLangue.findByIdlangue");
        query.setParameter("idlangue", idLangue);

        List<TypeLangue> result = query.getResultList();

        return createModelTypeLangue(result);
    }

    private HashMap<Integer, ModelTypeLangue> createModelTypeLangue(List<TypeLangue> list) {

        HashMap<Integer, ModelTypeLangue> listType = new HashMap<>();

        for (TypeLangue l : list) {
            ModelTypeLangue newTypeLangue = convertToModelTypeLangue(l);
            listType.put(l.getTypePokemon().getIdtype(), newTypeLangue);
        }
        
        return listType;
    }

    private ModelTypeLangue convertToModelTypeLangue(TypeLangue typeLangue) {
        ModelType newType = convertToModelType(typeLangue.getTypePokemon());
        ModelLangue newLangue = new ModelLangue(typeLangue.getLangue().getIdlangue(), typeLangue.getLangue().getCodelangue(), typeLangue.getLangue().getLibellelangue());
        return new ModelTypeLangue(newType, newLangue, typeLangue.getLibelletype());
    }

    private ModelType convertToModelType(TypePokemon type) {
        ModelPromo newPromo;
        try {
            newPromo = new ModelPromo(type.getCodepromotion().getCodepromo(), type.getCodepromotion().getPourcentagepromo().doubleValue());
        } catch (NullPointerException e) {
            newPromo = null;
        }
        return new ModelType(type.getIdtype(), newPromo);
    }

}
