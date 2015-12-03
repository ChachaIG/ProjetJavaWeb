/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import data.TypeLangue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author charlotte
 */
@Local
public interface TypeLangueFacadeLocal {

    void create(TypeLangue typeLangue);

    void edit(TypeLangue typeLangue);

    void remove(TypeLangue typeLangue);

    TypeLangue find(Object id);

    List<TypeLangue> findAll();

    List<TypeLangue> findRange(int[] range);

    int count();
    
}
