package n1exercici1;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private double preuTotal;
    private List<Producte> productes = new ArrayList<Producte>();


    public Venda() {}

    /* Mètode que calcula el preu total dels productes. 
     * Si la llista de productes es buida, llança una excepció
     */
    public void calcularTotal() throws VendaBuidaException {
        if(productes.isEmpty()) {
            throw new VendaBuidaException();
        } else {
            for(Producte producte: productes) {
                preuTotal += producte.getPreu();
            }
        }
    }
    

    public double getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(double preuTotal) {
        this.preuTotal = preuTotal;
    }

    public List<Producte> getProductes() {
        return productes;
    }

    public void setProductes(List<Producte> productes) {
        this.productes = productes;
    }

    public void addProducte(Producte producte) {
        this.productes.add(producte);
    }

}
