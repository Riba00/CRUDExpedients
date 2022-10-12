import java.util.ArrayList;

public class expedient {
    int codi;
    String nomAlumne;
    ArrayList<modul>llistamoduls = new ArrayList<modul>();

    //CONSTRUCTOR
    public expedient(int codi, String nomAlumne) {
        this.codi = codi;
        this.nomAlumne = nomAlumne;
    }

    //GETTERS I SETTERS
    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNomAlumne() {
        return nomAlumne;
    }

    public void setNomAlumne(String nomAlumne) {
        this.nomAlumne = nomAlumne;
    }






}
