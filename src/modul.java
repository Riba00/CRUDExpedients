import java.util.ArrayList;
import java.util.Objects;

public class modul {
    int codi;
    String nom;
    ArrayList<uf> llistaUFs = new ArrayList<uf>();

    //CONSTRUCTOR
    public modul(int codi, String nom) {
        this.codi = codi;
        this.nom = nom;
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

    public void afegirUf (uf uf){
        this.llistaUFs.add(uf);
    }

    public void treureUf (uf uf){
        this.llistaUFs.remove(uf);
    }

//    public double calcularNota(){
//
//
//    }
}
