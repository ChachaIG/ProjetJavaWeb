
package model;

import java.util.Date;

public class ModelCommande {
    private Integer numCommande;
    private Date dateCommande;
    private Date dateLivraison;
    private ModelClient client;

    public ModelCommande(Integer numCommande, Date dateCommande, Date dateLivraison, ModelClient client) {
        this.numCommande = numCommande;
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.client = client;
    }

    public Integer getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(Integer numCommande) {
        this.numCommande = numCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public ModelClient getClient() {
        return client;
    }

    public void setClient(ModelClient client) {
        this.client = client;
    }
    
    
    
}
