package n3exercici1;

public class ExcepcioFilaIncorrecta extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String message = "El número de fila és incorrecte.";

	public ExcepcioFilaIncorrecta() {
		// get default message and calls the constructor with the same parameters.
		this(message);
	}

	// This constructor also allows a custom message
	public ExcepcioFilaIncorrecta(String message) {
		super(message);
	}
}
