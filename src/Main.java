import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static ArrayList<uf> llistaUF = new ArrayList<uf>();


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
                case 1:
                    menuUF();
                    break;


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
            System.out.println("5. Sortir");

            try {
                System.out.print("Opcio: ");
                opcioUf = teclat.nextInt();
                if (opcioUf < 1 || opcioUf > 5) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcio incorrecta");
                System.out.println();
                teclat.nextLine();
            }
            switch (opcioUf) {
                case 1:
                    crearUF();
                    break;
                case 2:
                    llistarUFs();
                    break;
                case 3:
                    modificarUF();
                    break;
                case 4:
                    eliminarUF();
                    break;
            }


        } while (opcioUf != 5);


    }

    public static void crearUF() {
        Scanner teclat = new Scanner(System.in);

        //VARIABLES
        int codi = 0;
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
                teclat.nextLine();
                if (codi < 0) {
                    System.out.println("Codi incorrecte");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Codi incorrecte");
                teclat.nextLine();
            }
        } while (!validarCodiGenerat(codi));

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
        System.out.println("UF CREADA");
        llistaUF.add(ufCreada);

    }

    public static void llistarUFs() {
        if (llistaUF.isEmpty()) {
            System.out.println("No hi ha cap UF creada");
            System.out.println();
        } else {
            for (int i = 0; i < llistaUF.size(); i++) {
                System.out.println();
                System.out.print("Codi---> ");
                System.out.println(llistaUF.get(i).getCodi());
                System.out.print("Nom----> ");
                System.out.println(llistaUF.get(i).getNom());
                System.out.print("Hores--> ");
                System.out.println(llistaUF.get(i).getHores());
                System.out.print("Nota --> ");
                System.out.println(llistaUF.get(i).getNota());
            }
        }
    }

    public static void modificarUF() {
        Scanner teclat = new Scanner(System.in);

        int codiUfModificar = 0;
        int opcioModificar = 0;
        uf ufModificar = null;


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
                }
            }
        }
    }

    public static boolean validarCodi(int codi) {
        boolean valid = false;

        if (codi > 0) valid = true;
        return valid;

    }

    public static boolean validarCodiGenerat(int codi) {
        boolean valid = false;

        ArrayList<Integer> codis = new ArrayList<Integer>();

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

}