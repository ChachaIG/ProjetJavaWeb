/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.TalentLangue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author charlotte
 */
@Local
public interface TalentLangueFacadeLocal {

    void create(TalentLangue talentLangue);

    void edit(TalentLangue talentLangue);

    void remove(TalentLangue talentLangue);

    TalentLangue find(Object id);

    List<TalentLangue> findAll();

    List<TalentLangue> findRange(int[] range);

    int count();
    
}
