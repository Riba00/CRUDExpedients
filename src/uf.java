import java.util.Scanner;

public class uf {

    int codi;
    String nom;
    int hores;
    int nota;

    //CONSTRUCTOR
    public uf(int codi, String nom, int hores, int nota) {
        this.codi = codi;
        this.nom = nom;
        this.hores = hores;
        this.nota = nota;
    }

    //GETTERS I SETTERS
    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHores() {
        return hores;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }



}
