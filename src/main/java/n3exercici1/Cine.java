package n3exercici1;

import java.util.Iterator;
import n2exercici1.Entrada;


public class Cine {
    private int files;
    private int seientsPerFila;
    private GestioButaques gestioButaques;


    /* This method generates an instance of GestioButaques and calls the method
     * that initializes the number of seats in the cinema.
     * */
    public Cine() {
        this.gestioButaques = new GestioButaques();
        demanarDadesInicials();
    }

    /* This method is called at start of the app and initializes the number of rows 
     * and seats per row.
     * It uses the Entrada class from the n2exercici1 package to handle exceptions 
     * from the Scanner class.
     * */
    private void demanarDadesInicials() {
        this.files = Entrada.llegirInt("Introdueix el nombre de files del cinema: ");
        this.seientsPerFila = Entrada.llegirInt("Introdueix el nombre de seients per fila del cinema: ");
    }
    
    // Show menu options and returns the chosen option
    private byte menu() {
        System.out.println("Selecciona una opció:");
        System.out.println("  1.- Mostrar totes les butaques reservades.");
        System.out.println("  2.- Mostrar les butaques reservades per una persona.");
        System.out.println("  3.- Reservar una butaca.");
        System.out.println("  4.- Anul·lar la reserva d'una butaca.");
        System.out.println("  5.- Anul·lar totes les reserves d'una persona.");
        System.out.println("  0.- Sortir.");

        // Asks for a valid option 
        return Entrada.llegirByte("> ");
    }
    
    // Calls the menu and calls the method selected by the user
    public void iniciar() {
    	boolean sortir = false;
        byte opcio;
        
    	// Show menu
        do {
            opcio = menu();
            switch (opcio) {
                case 0:
                    sortir = true;
                    break;
                case 1:
                    // Show all reserved seats
                    mostrarButaques();
                    break;
                case 2:
                    // Show all reserved seats by a person
                	mostrarButaquesPersona();
                    break;
                case 3:
                    // Book a seat
                	reservarButaca();
                    break;
                case 4:
                    // Cancel a seat reservation
                	anularReserva();
                    break;
                case 5:
                    // Cancel all seats reservations by a person
                    anularReservaPersona();
                	break;
                default:
            }
        } while (!sortir);
    }
    
    // show all booked seats
    public void mostrarButaques() {
    	for (Butaca butaca: gestioButaques.getButaques()) {
    		System.out.println(butaca.toString());
    	}
    }
    
    // This method show all seats booked by one person
    public void mostrarButaquesPersona() {
    	String persona = Entrada.llegirString("Nom de la persona que té la reserva:");
    	// if seat is booked by the person, show it per console
    	for (Butaca butaca: gestioButaques.getButaques()) {
    		if (butaca.getNomPersonaReserva().equals(persona)) {
    			System.out.println(butaca.toString());
    		}
    	}
    }
    
    /* This method adds a new seat to the reserved seating list.
     * If the input data is correct, it adds new seat to the list, 
     * otherwise throw an exception.
     * */
    public void reservarButaca() {
    	try {
			int fila = introduirFila("Número de fila: ");
			int seient = introduirSeient("Número de seient: ");
			String persona = introduirPersona("Nom persona reserva: ");
		
			// If the input is correct, it add a new seat to the list
	    	gestioButaques.afegirButaca(new Butaca(fila, seient, persona));
    	} catch (ExcepcioFilaIncorrecta e) {
    		System.out.println("Fila incorrecta: " + e.getMessage());
		} catch (ExcepcioSeientIncorrecte e) {
			System.out.println("Seient incorrecte: " + e.getMessage());
		} catch (ExcepcioNomPersonaIncorrecte e) {
			System.out.println("Format nom incorrecte: " + e.getMessage());
		} catch (ExcepcioButacaOcupada e) {
			System.out.println("Butaca ocupada: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Excepció: " + e.getMessage());
		}
    }
    
    /* This method removes a seat from the list. If the seat does not exist 
     * catch an exception and show it by console.
     * */
    public void anularReserva() {
    	try {
    		int fila = introduirFila("Número de fila: ");
			int seient = introduirSeient("Número de seient: ");
			// If the input is a valid seat, it is removed.
			gestioButaques.eliminarButaca(fila, seient);
    	} catch (ExcepcioFilaIncorrecta e) {
    		System.out.println("Fila incorrecta: " + e.getMessage());
    	} catch (ExcepcioSeientIncorrecte e) {
    		System.out.println("Seient incorrecta: " + e.getMessage());
    	} catch (ExcepcioButacaLliure e) {
    		System.out.println("Excepció: " + e.getMessage());
    	}
    }
    
    // Cancel a person's booking
    public void anularReservaPersona() {
    	try {
    		String persona = introduirPersona("Persona que ha fet la reserva: ");
    		// Iterate the list of seats
    		Iterator<Butaca> it = gestioButaques.getButaques().iterator();
    		while(it.hasNext()) {
    			// Seat is removed if it is booked by the person
    			if (it.next().getNomPersonaReserva().equals(persona)) {
    				it.remove();
    			}
    		}
    	// If the entered name is not correct, catch the exception and show it by console
    	} catch (ExcepcioNomPersonaIncorrecte e) {
    		System.out.println("Format nom persona incorrecte: " + e.getMessage());
    	}
    }
    
    // if the input name is a correct value, returns it. Otherwise throw an exception
    public String introduirPersona(String message) throws ExcepcioNomPersonaIncorrecte {
    	String persona = Entrada.llegirString(message);
    	
    	// If the input contains a number throw the exception
    	if (persona.matches(".*[0-9]+.*")) {
    		throw new ExcepcioNomPersonaIncorrecte();
    	}
    	return persona;
    }
    
    /* Returns the number of rows if it is between 1 and the maximum of rows at the cinema.
     * Otherwise, throw exception
     *  */
    public int introduirFila(String message) throws ExcepcioFilaIncorrecta {
    	int nFiles = Entrada.llegirInt(message);
    	if (nFiles >= 1 && nFiles <= files) {
    		return nFiles;
    	} else {
    		throw new ExcepcioFilaIncorrecta();
    	}
    }
    
    /* Returns the number of seat in a row if it is between 1 and the maximum of seats in
     * a row. Otherwise, throw exception
     *  */
    public int introduirSeient(String message) throws ExcepcioSeientIncorrecte {
    	int nSeients = Entrada.llegirInt(message);
    	if (nSeients >= 1 && nSeients <= seientsPerFila) {
    		return nSeients;
    	} else {
    		throw new ExcepcioSeientIncorrecte();
    	}
    }
    

}
