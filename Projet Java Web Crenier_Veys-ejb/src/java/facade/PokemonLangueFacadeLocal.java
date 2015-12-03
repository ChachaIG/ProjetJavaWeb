/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import data.PokemonLangue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author charlotte
 */
@Local
public interface PokemonLangueFacadeLocal {

    void create(PokemonLangue pokemonLangue);

    void edit(PokemonLangue pokemonLangue);

    void remove(PokemonLangue pokemonLangue);

    PokemonLangue find(Object id);

    List<PokemonLangue> findAll();

    List<PokemonLangue> findRange(int[] range);

    int count();
    
}
