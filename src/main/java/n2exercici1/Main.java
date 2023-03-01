package n2exercici1;


public class Main {
    public static void main(String[] args) {

        // Llegir byte
        byte resultByte = Entrada.llegirByte("Introdueix la teva edad");
        System.out.println("El valor retornat és: " + resultByte);

        // Llegir enter
        int resultInt = Entrada.llegirInt("Introdueix l'any de naixement");
        System.out.println("El valor retornat és: " + resultInt);

        // Llegir float
        float resultFloat = Entrada.llegirFloat("Introdueix un float");
        System.out.println("El valor retornat és: " + resultFloat);

        // llegir double
        double resultDouble = Entrada.llegirDouble("Introdueix un double");
        System.out.println("El valor retornat és: " + resultDouble);

        
        // Llegir char
        char charResult = Entrada.llegirChar("Introdueix un caracter");
        System.out.println("El valor retornat és: " + charResult);

        // Llegir String
        String text = Entrada.llegirString("Escriu una cadena de caracters");
        System.out.println("Text:\n" + text);

        // Llegir si-no
        boolean opcio = Entrada.llegirSiNo("Vol sortir del programa? (s\\n)");
        System.out.println("Ha escollit: " + opcio);

    }
}
