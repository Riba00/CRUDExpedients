import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Fitxer {

    public static void crearFitxerUF() {
        try {
            File fitxerDades = new File("uf.xml");
            //Si he aconseguit crear el fitxer
            if (fitxerDades.createNewFile()) {
                System.out.println("Fitxer '" + fitxerDades.getName() + "' creat");
            }
            //Si no he pogut
            else {
                System.out.println("No s'ha pogut crear.");
            }
        } catch (IOException error) {
            System.out.println("Error al crear el fitxer.");
            error.printStackTrace();
        }
    }

    public static boolean isFitxer (String nomFitxer){
        File fitxer = new File(nomFitxer);

        return fitxer.isFile();

    }

    public static void escriureFitxerUF(int codi, String nom, int hores, int nota) {
        try {
            //escriptura:
            FileWriter escriptorDeFitxer = new FileWriter("uf.xml",true);
            //afegir al final:
            //FileWriter escriptorDeFitxer = new FileWriter("uf.xml",true);
            escriptorDeFitxer.write("<UF>" +
                    "<CODI>" + codi + "</CODI>" +
                    "<NOM>" + nom + "</NOM>" +
                    "<HORES>" + hores + "</HORES>" +
                    "<NOTA>" + nota + "</NOTA>" +
                    "</UF>");
            escriptorDeFitxer.close();
//            System.out.println("Fitxer modificat amb èxit");
        } catch (IOException error) {
            System.out.println("Error al crear el fitxer");
            error.printStackTrace();
        }
    }

    public static void llegirFitxerUF() {
        try {
            File fitxerDades = new File("uf.xml");
            Scanner lectorDades = new Scanner(fitxerDades);
            while (lectorDades.hasNextLine()) {
                String dades = lectorDades.nextLine();
                System.out.println(dades);
            }
            lectorDades.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error a l'obrir el fitxer per lectura.");
            error.printStackTrace();
        }


    }


}
