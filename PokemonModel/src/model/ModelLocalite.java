
package model;

public class ModelLocalite {
    private Integer codePostal;
    private String ville;

    public ModelLocalite(Integer codePostal, String ville) {
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
