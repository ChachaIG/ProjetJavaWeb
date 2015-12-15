
package controller;

import businessSessionBean.PokemonManagerLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelCommande;
import model.ModelLigneCommande;
import model.ModelPokemon;

@ManagedBean(name = "panierController")
@SessionScoped
public class PanierController implements Serializable {

    @EJB
    private PokemonManagerLocal pokemonSessionBean;
    
    private ModelCommande commande;    
    private HashMap <Integer, ModelLigneCommande> hashMapPanier;
    private int iLigneCommande;
    
    public PanierController() {
    }
    
    @PostConstruct
    public void init() {
        commande = new ModelCommande(new Date(), new Date(), null);
        hashMapPanier = new HashMap<>();
        iLigneCommande = 1;
    }
    
    public void getAjoutPanier(ModelPokemon currentPokemon, int quantite) {  
        if (!hashMapPanier.isEmpty() && hashMapPanier.containsKey(currentPokemon.getIdPokemon())) {
                int nouvelleQuantite = hashMapPanier.get(currentPokemon.getIdPokemon()).getQuantite() + quantite;
                hashMapPanier.get(currentPokemon.getIdPokemon()).setQuantite(nouvelleQuantite);
        } else {
            ModelLigneCommande newLigne = new ModelLigneCommande(commande, iLigneCommande, currentPokemon, quantite, currentPokemon.getPrix());
            hashMapPanier.put(currentPokemon.getIdPokemon(), newLigne);
            iLigneCommande++;
        }
    }
    
    public boolean isEmptyListPanier() {
        return hashMapPanier.isEmpty();
    }
 
    public ArrayList<ModelLigneCommande> getPanier() {
        ArrayList<ModelLigneCommande> panier = new ArrayList<>(hashMapPanier.values());
        
        Collections.sort(panier, new Comparator<ModelLigneCommande>() {

            @Override
            public int compare(ModelLigneCommande o1, ModelLigneCommande o2) {
                return o1.getNumLigne() - o2.getNumLigne();
            }
            
        });
        
        return panier;
    }
    
}
