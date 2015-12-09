
package model;

public class ModelClient {
    private Integer numClient;
    private String nomClient;
    private String prenomClient;
    private String adrNumRue;
    private String adrNomRue;
    private ModelLocalite localite;
    private int numTel;
    private String email;

    public ModelClient(Integer numClient, String nomClient, String prenomClient, String adrNumRue, String adrNomRue, ModelLocalite localite, Integer numTel, String email) {
        this.numClient = numClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adrNumRue = adrNumRue;
        this.adrNomRue = adrNomRue;
        this.localite = localite;
        this.numTel = numTel;
        this.email = email;
    }

    public Integer getNumClient() {
        return numClient;
    }

    public void setNumClient(Integer numClient) {
        this.numClient = numClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getAdrNumRue() {
        return adrNumRue;
    }

    public void setAdrNumRue(String adrNumRue) {
        this.adrNumRue = adrNumRue;
    }

    public String getAdrNomRue() {
        return adrNomRue;
    }

    public void setAdrNomRue(String adrNomRue) {
        this.adrNomRue = adrNomRue;
    }

    public ModelLocalite getLocalite() {
        return localite;
    }

    public void setLocalite(ModelLocalite localite) {
        this.localite = localite;
    }

    public Integer getNumTel() {
        return numTel;
    }

    public void setNumTel(Integer numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
