package n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Classe que controla les diferents excepcions que poden aparèixer a l'introduir dades per teclat
* mitjançant la classe Scanner
*
* */
public class Entrada {
    private static Scanner scanner = new Scanner(System.in);
    private static final String missatgeErrorFormat = " (Error de format)";

    
    /* Métodes a implementar capturant la excepció de la classe InputMismatchException */
 
    public static byte llegirByte(String missatge) {
        byte entrada = 0;
        boolean entradaOk = false;

        do {
        	// Es solicita la dada al usuari fins que sigui ben introduïda
        	System.out.println(missatge);
            try {
                entrada = scanner.nextByte();
                scanner.nextLine();
                // flag per indicar que la dada s'ha introduit correctament
                entradaOk = true;
            } catch (InputMismatchException ime) {
                System.out.println(missatge + Entrada.missatgeErrorFormat);
                // Saltem el valor que queda enmagatzemat en el buffer de scanner
                scanner.nextLine();
            }
        } while (!entradaOk);

        return entrada;
    }

    public static int llegirInt(String missatge) {
        int entrada = 0;
        boolean entradaOk = false;

        // Es solicita la dada al usuari fins que sigui ben introduïda
        System.out.println(missatge);
        do {
            try {
                entrada = scanner.nextInt();
                scanner.nextLine();
                // flag per indicar que la dada s'ha introduit correctament
                entradaOk = true;
            } catch (InputMismatchException ime) {
                System.out.println(missatge + Entrada.missatgeErrorFormat);
                scanner.nextLine();
            }
        } while (!entradaOk);

        return entrada;
    }

    public static float llegirFloat(String missatge) {
        float entrada = 0;
        boolean entradaOk = false;

        // Es solicita la dada al usuari fins que sigui ben introduïda
        System.out.println(missatge);
        do {
            try {
                entrada = scanner.nextFloat();
                scanner.nextLine();
                // flag per indicar que la dada s'ha introduit correctament
                entradaOk = true;
            } catch (InputMismatchException ime) {
                System.out.println(missatge + Entrada.missatgeErrorFormat);
                scanner.nextLine();
            }
        } while (!entradaOk);

        return entrada;
    }

    public static double llegirDouble(String missatge) {
        double entrada = 0;
        boolean entradaOk = false;

        // Es solicita la dada al usuari fins que sigui ben introduïda
        System.out.println(missatge);
        do {
            try {
                entrada = scanner.nextDouble();
                scanner.nextLine();
                // flag per indicar que la dada s'ha introduit correctament
                entradaOk = true;
            } catch (InputMismatchException ime) {
                System.out.println(missatge + Entrada.missatgeErrorFormat);
                scanner.nextLine();
            }
        } while (!entradaOk);

        return entrada;
    }


    /* Métodes a implementar capturant la excepció de la classe Exception */

    public static char llegirChar(String missatge) {
        char entrada = ' ';
        String entradaText;
        String noUnicCaracter = " (Ha d'introduïr un únic caracter)";
        boolean entradaOk = false;

        // Es solicita la dada al usuari fins que sigui ben introduïda
        System.out.println(missatge);
        do {
            try {
                // Es comproba que l'usuari ha introduït correctament un sol caràcter.
                entradaText = scanner.nextLine();
                if (entradaText.length() == 1) {
                    entrada = entradaText.charAt(0);
                    entradaOk = true;
                } else {
                    // Es retorna feedback a l'usuari que escriu més d'un caracter
                    System.out.println(missatge + noUnicCaracter);
                }
            } catch (Exception e) {
            	System.out.println("Excepció: " + e.getMessage());
                System.out.println(missatge + noUnicCaracter);
            }
            
        } while (!entradaOk);

        return entrada;
    }


    public static String llegirString(String missatge) {
        String entrada = null;
        boolean entradaOk = false;

        // Es solicita la dada al usuari fins que sigui ben introduïda
        System.out.println(missatge);
        do {
            try {
                entrada = scanner.nextLine();
                // flag per indicar que la dada s'ha introduit correctament
                entradaOk = true;
            } catch (Exception e) {
                System.out.println("Excepció: " + e.getMessage());
            }
        } while (!entradaOk);

        return entrada;
    }


    // Mètode que retorna “true” si l'usuari/a introdueix "s" i "false" si l’usuari introdueix “n”.
    public static boolean llegirSiNo(String missatge) {
        boolean accepta = false;
        char opcio = ' ';

        while (opcio != 's' && opcio != 'n') {
        	try {
        		System.out.println(missatge);
        		opcio = scanner.next().charAt(0);
                if (opcio == 's') {
                    accepta = true;
                } else if (opcio == 'n'){
                    accepta = false;
                }
        	} catch (Exception e) {
        		System.out.println("Excepcio: " + e.getMessage());
        	}
            
        } 

        return accepta;
    }


}
