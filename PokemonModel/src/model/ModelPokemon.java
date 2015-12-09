
package model;

import java.util.ArrayList;

public class ModelPokemon {
    private Integer idPokemon;
    private String cheminImg;
    private double taille;
    private double poids;
    private int pointsVie;
    private int pointsAttaque;
    private int pointsDefense;
    private int pointsAttaqueSpeciale;
    private int pointsDefenseSpeciale;
    private int pointsVitesse;
    private double prix;
    private ModelCategorie categorie;
    private ArrayList<ModelType> types;
    private ArrayList<ModelType> faiblesses;

    public ModelPokemon(Integer idPokemon, String cheminImg, double taille, double poids, int pointsVie, int pointsAttaque, int pointsDefense, int pointsAttaqueSpeciale, int pointsDefenseSpeciale, int pointsVitesse, double prix, ModelCategorie categorie, ArrayList<ModelType> types, ArrayList<ModelType> faiblesses) {
        this.idPokemon = idPokemon;
        this.cheminImg = cheminImg;
        this.taille = taille;
        this.poids = poids;
        this.pointsVie = pointsVie;
        this.pointsAttaque = pointsAttaque;
        this.pointsDefense = pointsDefense;
        this.pointsAttaqueSpeciale = pointsAttaqueSpeciale;
        this.pointsDefenseSpeciale = pointsDefenseSpeciale;
        this.pointsVitesse = pointsVitesse;
        this.prix = prix;
        this.categorie = categorie;
        this.types = types;
        this.faiblesses = faiblesses;
    }

    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getCheminImg() {
        return cheminImg;
    }

    public void setCheminImg(String cheminImg) {
        this.cheminImg = cheminImg;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public int getPointsVie() {
        return pointsVie;
    }

    public void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
    }

    public int getPointsAttaque() {
        return pointsAttaque;
    }

    public void setPointsAttaque(int pointsAttaque) {
        this.pointsAttaque = pointsAttaque;
    }

    public int getPointsDefense() {
        return pointsDefense;
    }

    public void setPointsDefense(int pointsDefense) {
        this.pointsDefense = pointsDefense;
    }

    public int getPointsAttaqueSpeciale() {
        return pointsAttaqueSpeciale;
    }

    public void setPointsAttaqueSpeciale(int pointsAttaqueSpeciale) {
        this.pointsAttaqueSpeciale = pointsAttaqueSpeciale;
    }

    public int getPointsDefenseSpeciale() {
        return pointsDefenseSpeciale;
    }

    public void setPointsDefenseSpeciale(int pointsDefenseSpeciale) {
        this.pointsDefenseSpeciale = pointsDefenseSpeciale;
    }

    public int getPointsVitesse() {
        return pointsVitesse;
    }

    public void setPointsVitesse(int pointsVitesse) {
        this.pointsVitesse = pointsVitesse;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public ModelCategorie getCategorie() {
        return categorie;
    }

    public void setCategorie(ModelCategorie categorie) {
        this.categorie = categorie;
    }

    public ArrayList<ModelType> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<ModelType> types) {
        this.types = types;
    }

    public ArrayList<ModelType> getFaiblesses() {
        return faiblesses;
    }

    public void setFaiblesses(ArrayList<ModelType> faiblesses) {
        this.faiblesses = faiblesses;
    }
    
    public String getFullIdPokemon() {
        return ((idPokemon < 100) ? ((idPokemon < 10) ? "00" + idPokemon : "0" + idPokemon) : idPokemon.toString());
    }
    
    public String getCheminImgDetails() {
        int taille = cheminImg.length();
        String chemin = cheminImg.substring(0, taille - 7);
        String img = cheminImg.substring(taille - 7, taille);
        return chemin + "details/" + img;
    }
}
