
import com.jakewharton.fliptables.FlipTableConverters;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static ArrayList<uf> llistaUF = new ArrayList<>();
    public static ArrayList<modul> llistaModuls = new ArrayList<>();

    static String groc = "\u001B[33m";
    static String normal = "\u001B[0m";
    static String roig = "\u001B[31m";
    public static void main(String[] args) {
        menuInicial();
    }

    public static void menuInicial() {
        Scanner teclat = new Scanner(System.in);

        int opcioInicial = 0;
        do {
            System.out.println();
            System.out.println("QUE VOLS GESTIONAR?");
            System.out.println("1. UFs");
            System.out.println("2. Moduls");
            System.out.println("3. Expedients");
            System.out.println("4. Sortir");
            System.out.print("Opcio: ");
            try {
                opcioInicial = teclat.nextInt();
                if (opcioInicial < 1 || opcioInicial > 4) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcio incorrecta");
                System.out.println();
                teclat.nextLine();
            }

            switch (opcioInicial) {
                case 1 -> menuUF();
                case 2 -> menuModul();
            }
        } while (opcioInicial != 4);
    }

    public static void menuUF() {
        Scanner teclat = new Scanner(System.in);

        int opcioUf = 0;

        do {
            System.out.println("-----UF-----");
            System.out.println("1. Crear");
            System.out.println("2. Llistar");
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("5. Guardar llista");
            System.out.println("6. Sortir");

            try {
                System.out.print("Opcio: ");
                opcioUf = teclat.nextInt();
                if (opcioUf < 1 || opcioUf > 6) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcio incorrecta");
                System.out.println();
                teclat.nextLine();
            }
            switch (opcioUf) {
                case 1 -> crearUF();
                case 2 -> llistarUFs();
                case 3 -> modificarUF();
                case 4 -> eliminarUF();
                case 5 -> guardarLlistaUF();
            }
        } while (opcioUf != 6);
    }

    public static void crearUF() {
        Scanner teclat = new Scanner(System.in);

        //VARIABLES
        int codi = -1;
        String nom;
        int hores = 0;
        int nota = 0;

        System.out.println("CREAR UF");
        System.out.println("--------");

        //CODI
        do {
            try {
                System.out.print("Codi: ");
                codi = teclat.nextInt();
                if (codi < 0) {
                    throw new InputMismatchException();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Codi incorrecte");
                teclat.nextLine();
            }
        } while (!validarCodiGeneratUF(codi));
        teclat.nextLine();
        //NOM
        System.out.print("Nom: ");
        nom = teclat.nextLine();

        //HORES
        do {
            try {
                System.out.print("Hores: ");
                hores = teclat.nextInt();
                teclat.nextLine();
                if (hores < 0) {
                    System.out.println("Hores incorrectes");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Hores incorrectes");
                teclat.nextLine();
            }
        } while (!ufValidarhores(hores));

        //NOTA
        do {
            try {
                System.out.print("Nota: ");
                nota = teclat.nextInt();
                teclat.nextLine();
                if (nota < 0 || nota > 10) {
                    System.out.println("Nota incorrecta");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Nota incorrecta");
                teclat.nextLine();
            }
        } while (!ufValidarNota(nota));

        //CONSTRUCTOR UF
        uf ufCreada = new uf(codi, nom, hores, nota);

        llistaUF.add(ufCreada);
        if (!Fitxer.isFitxer("uf.xml")) Fitxer.crearFitxerUF();


        Fitxer.escriureFitxerUF(codi, nom, hores, nota);
        System.out.println(groc+"UF CREADA"+normal);
        System.out.println();
    }

    public static void llistarUFs() {
        if (llistaUF.isEmpty() || !Fitxer.isFitxer("uf.xml")) {
            System.out.println("!!! No hi ha cap UF creada !!!");
            System.out.println();
        } else {
            System.out.println(FlipTableConverters.fromIterable(llistaUF, uf.class));
        }
    }

    public static void modificarUF() {
        Scanner teclat = new Scanner(System.in);

        int codiUfModificar = 0;
        int opcioModificar = 0;
        uf ufModificar;


        if (llistaUF.isEmpty()) {
            System.out.println("No hi ha cap UF creada");
            System.out.println();
        } else {
            do {
                System.out.print("Codi de la UF a modificar: ");
                try {
                    codiUfModificar = teclat.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Codi incorrecte");
                    System.out.println();
                    teclat.nextLine();
                }
            } while (!validarCodi(codiUfModificar));

            for (int i = 0; i < llistaUF.size(); i++) {
                if (codiUfModificar == llistaUF.get(i).getCodi()) {
                    ufModificar = llistaUF.get(i);
                    do {
                        System.out.println("Que vols modificar de la UF?");
                        System.out.println("1. Nom   2. Hores   3. Nota   4. Sortir");
                        System.out.print("Opcio: ");
                        try {
                            opcioModificar = teclat.nextInt();
                            if (opcioModificar < 1 || opcioModificar > 4) {
                                throw new InputMismatchException();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Opcio incorrecta");
                            System.out.println();
                            teclat.nextLine();
                        }
                        switch (opcioModificar) {
                            case 1:
                                String nomNou;

                                teclat.nextLine();
                                System.out.print("Nom actual-> ");
                                System.out.println(ufModificar.getNom());
                                System.out.print("Nom: ");

                                nomNou = teclat.nextLine();
                                ufModificar.setNom(nomNou);
                                System.out.println("NOM MODIFICAT");
                                break;
                            case 2:
                                int horesNoves;

                                System.out.print("Hores actuals-> ");
                                System.out.println(ufModificar.getHores());
                                System.out.print("Hores: ");
                                try {
                                    horesNoves = teclat.nextInt();
                                    if (horesNoves < 0) {
                                        throw new InputMismatchException();
                                    }
                                    ufModificar.setHores(horesNoves);
                                    System.out.println("Hores modificades");
                                } catch (InputMismatchException e) {
                                    System.out.println("Hores incorrectes");
                                    teclat.nextLine();
                                }
                                break;
                            case 3:
                                int notaNova;

                                System.out.print("Nota actual-> ");
                                System.out.println(ufModificar.getNota());
                                System.out.print("Nota: ");
                                try {
                                    notaNova = teclat.nextInt();
                                    if (notaNova < 0 || notaNova > 10) {
                                        throw new InputMismatchException();
                                    }
                                    ufModificar.setHores(notaNova);
                                    System.out.println("Nota modificada");
                                } catch (InputMismatchException e) {
                                    System.out.println("Nota incorrecta");
                                    teclat.nextLine();
                                }
                                break;
                        }
                    } while (opcioModificar != 4);
                } else {
                    System.out.println("UF no trobada");
                    break;
                }
            }
        }

    }

    public static void eliminarUF() {
        Scanner teclat = new Scanner(System.in);

        int codiUfEliminar = 0;


        if (llistaUF.isEmpty()) {
            System.out.println("No hi ha cap UF creada");
        } else {
            System.out.print("Codi de la UF a eliminar: ");
            try {
                codiUfEliminar = teclat.nextInt();
                if (codiUfEliminar < 0) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Codi incorrecte");
                System.out.println();
                teclat.nextLine();
            }
            for (int i = 0; i < llistaUF.size(); i++) {
                if (codiUfEliminar == llistaUF.get(i).getCodi()) {
                    llistaUF.remove(i);
                    System.out.println("UF eliminada");
                    break;
                }
            }
        }
    }

    public static void guardarLlistaUF() {

        Fitxer fitxer = new Fitxer();

        Fitxer.crearFitxerUF();


    }

    public static boolean validarCodi(int codi) {
        boolean valid = false;

        if (codi > 0) valid = true;
        return valid;

    }

    public static boolean validarCodiGeneratUF(int codi) {
        boolean valid = false;

        ArrayList<Integer> codis = new ArrayList<>();

        if (llistaUF.isEmpty()) {
            valid = true;
        } else {
            for (int i = 0; i < llistaUF.size(); i++) {
                codis.add(llistaUF.get(i).getCodi());
            }
            if (codis.contains(codi)) {
                System.out.println("Codi no disponible");
            } else {
                valid = true;
            }
        }
        if (codi < 0) valid = false;
        return valid;
    }

    public static boolean ufValidarhores(int hores) {
        boolean valid = false;

        if (hores > 0) valid = true;

        return valid;
    }

    public static boolean ufValidarNota(int nota) {
        boolean valid = false;

        if (nota >= 0 && nota <= 10) valid = true;

        return valid;
    }

    public static void menuModul() {

        Scanner teclat = new Scanner(System.in);

        int opcioModul = 0;
        do {
            System.out.println("-----MODULS-----");
            System.out.println("1. Crear");
            System.out.println("2. Llistar");
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("5. Sortir");
            System.out.print("Opcio: ");

            try {
                opcioModul = teclat.nextInt();
                if (opcioModul < 1 || opcioModul > 5) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcio incorrecta");
                System.out.println();
                teclat.nextLine();
            }
            switch (opcioModul) {
                case 1 -> crearModul();
            }

        } while (opcioModul != 5);

    }

    public static void crearModul() {
        Scanner teclat = new Scanner(System.in);

        int codi = 0;
        String nom;
        char respostaAfegirUF;

        System.out.println("CREAR MODUL");
        System.out.println("-----------");

        //CODI
        do {
            try {
                System.out.print("Codi: ");
                codi = teclat.nextInt();
                if (codi < 0) {
                    throw new InputMismatchException();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Codi incorrecte");
                teclat.nextLine();
            }
        } while (!validarCodiGeneratModul(codi));
        teclat.nextLine();
        //NOM
        System.out.print("Nom: ");
        nom = teclat.nextLine();

        modul modulCreat = new modul(codi, nom);
        llistaModuls.add(modulCreat);

        do {
            System.out.println("Vols afegir ara UFs al modul?  Si (S)  No (N)");
            System.out.print("Opcio: ");
            respostaAfegirUF = teclat.nextLine().toUpperCase().charAt(0);
        } while (!validarRespostaAgefirUF(respostaAfegirUF));
        if (respostaAfegirUF == 'S') {

            if (llistaUF.isEmpty()) {
                System.out.println("No hi ha cap UF creada");
                System.out.println();
            } else {
                for (uf uf : llistaUF) {
                    System.out.println();
                    System.out.print("Codi---> ");
                    System.out.println(uf.getCodi());
                    System.out.print("Nom----> ");
                }
                System.out.println("Quines UF vols afegir?");

            }
        }
    }

    public static boolean validarCodiGeneratModul(int codi) {
        boolean valid = false;

        ArrayList<Integer> codis = new ArrayList<>();

        if (llistaModuls.isEmpty() && codi > 0) {
            valid = true;
        } else {
            for (int i = 0; i < llistaModuls.size(); i++) {
                codis.add(llistaModuls.get(i).getCodi());
            }
            if (codis.contains(codi)) {
                System.out.println("Codi no disponible");
            } else {
                valid = true;
            }
        }
        if (codi < 0) valid = false;
        return valid;
    }

    public static boolean validarRespostaAgefirUF(char resposta) {
        boolean valid = false;

        if (resposta == 'S' || resposta == 'N') valid = true;

        return valid;
    }
}