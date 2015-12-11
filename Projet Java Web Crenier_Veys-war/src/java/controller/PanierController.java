
package controller;

import businessSessionBean.PokemonManagerLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import model.ModelCommande;
import model.ModelLigneCommande;
import model.ModelPokemon;

@ManagedBean(name = "panierController")
@SessionScoped
public class PanierController implements Serializable {

    @EJB
    private PokemonManagerLocal pokemonSessionBean;
    
    @Inject
    private PokemonController pokemonController;
    
    @Inject
    private ClientController clientController;
    
    private ModelCommande commande;    
    private HashMap <Integer, ModelLigneCommande> listPanier;
    private int iLigneCommande;
    private ModelPokemon currentPokemon;
    
    public PanierController() {
    }
    
    @PostConstruct
    public void init() {
        commande = new ModelCommande(new Date(), new Date(), clientController.getClient());
        listPanier = null;
        iLigneCommande = 1;
        currentPokemon = pokemonController.getCurrentPokemon().getPokemon();
    }
    
    public void ajoutPanier(int quantite) {        
        if (listPanier.containsKey(currentPokemon.getIdPokemon())) {
            int nouvelleQuantite = listPanier.get(currentPokemon.getIdPokemon()).getQuantite() + quantite;
            listPanier.get(currentPokemon.getIdPokemon()).setQuantite(nouvelleQuantite);
        } else {
            ModelLigneCommande newLigne = new ModelLigneCommande(commande, iLigneCommande, currentPokemon, quantite, currentPokemon.getPrix());
            listPanier.put(currentPokemon.getIdPokemon(), newLigne);
        }
    }
}
