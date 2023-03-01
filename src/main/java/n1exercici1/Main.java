package n1exercici1;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Venda venda = new Venda();

        
        /* Mètode d'utilitat per no repetir codi. 
         * Crida al métode calcularTotal() de la classe Venda 
         * */
        calculaTotalVenda(venda);  // No hi ha cap producte a la llista i, per tant, llança excepció

        venda.addProducte(new Producte("producte 1", 25.0));
        venda.addProducte(new Producte("Producte 2", 100.0));
        venda.addProducte(new Producte("producte 3", 50.0));

        // Un cop afegits productes suma el preu total dels productes
        calculaTotalVenda(venda);


        // Generar i capturar una excepció de tipus ArrayIndexOutOfBoundsException
        List<Producte> productes = venda.getProductes();
        try {
            System.out.println("\nLlista de productes:");
            /* Cerquem els productes fins apuntar a una posició fora de la llista.
             * Això causa que es produeixi l'excepció IndexOutOfBoundException */
            for(int i = 0; i < productes.size() + 1; i++) {
                System.out.println("producte: "+ productes.get(i).getNom());
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException: " + e.getMessage());
        }

    }


    /* Crida al métode calcularTotal() de Venda i si captura l'excepció la mostra
     * per pantalla amb el mètode getMessage()
     * */
    public static void calculaTotalVenda(Venda venda) {
        try {
            venda.calcularTotal();
            System.out.println("Preu total: " + venda.getPreuTotal());
        } catch (VendaBuidaException e) {
            System.out.println("VendaBuidaException: " + e.getMessage());
        }
    }
    

}