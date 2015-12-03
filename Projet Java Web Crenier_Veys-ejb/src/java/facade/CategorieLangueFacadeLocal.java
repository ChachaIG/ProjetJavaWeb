/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import data.CategorieLangue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author charlotte
 */
@Local
public interface CategorieLangueFacadeLocal {

    void create(CategorieLangue categorieLangue);

    void edit(CategorieLangue categorieLangue);

    void remove(CategorieLangue categorieLangue);

    CategorieLangue find(Object id);

    List<CategorieLangue> findAll();

    List<CategorieLangue> findRange(int[] range);

    int count();
    
}
