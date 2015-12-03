/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import data.CategoriePokemon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author charlotte
 */
@Local
public interface CategoriePokemonFacadeLocal {

    void create(CategoriePokemon categoriePokemon);

    void edit(CategoriePokemon categoriePokemon);

    void remove(CategoriePokemon categoriePokemon);

    CategoriePokemon find(Object id);

    List<CategoriePokemon> findAll();

    List<CategoriePokemon> findRange(int[] range);

    int count();
    
}
