package n3exercici1;

import java.util.ArrayList;

public class GestioButaques {
    private ArrayList<Butaca> butaques;

    
    // Initializes a list of seats
    public GestioButaques() {
        this.butaques = new ArrayList<Butaca>();
    }
    
    // Get all reserved seats
    public ArrayList<Butaca> getButaques() {
        return butaques;
    }

    // If input seat is not booked, then adds it to the seats list
    public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada {
        int value = cercarButaca(butaca.getNombreFila(), butaca.getNombreSeient());
        // If the seat is free it is added to the list. 
        if (value == -1) {
            butaques.add(butaca);
        } else {
        	// throws an exception if seat is not free
            throw new ExcepcioButacaOcupada("Aquesta butaca ja es troba reservada.");
        }
    }

    // Remove from the list by number of seat
    public void eliminarButaca(int nFila, int nSeient) throws ExcepcioButacaLliure {
        int value = cercarButaca(nFila, nSeient);
        if (value != -1) {
            butaques.remove(value);
        } else {
            throw new ExcepcioButacaLliure("Aquesta butaca no ha sigut reservada.");
        }
    }

    // This method return position of seat or -1 if it not exists at cinema
    public int cercarButaca(int nFila, int nSeient) {
        return butaques.indexOf(new Butaca(nFila, nSeient, null));
    }

}
