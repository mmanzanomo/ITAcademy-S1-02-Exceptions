package n1exercici1;

public class VendaBuidaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String message = "Per fer una venda primer has d'afegir productes";

	public VendaBuidaException() {
		// Crida al constructor que rep els parámetres passats al 'this'
		this(message);
	}

	// Es passa el missatge al constructor
	public VendaBuidaException(String message) {
		super(message);
	}
	
}
