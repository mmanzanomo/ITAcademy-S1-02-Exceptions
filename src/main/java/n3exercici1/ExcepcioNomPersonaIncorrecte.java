package n3exercici1;

public class ExcepcioNomPersonaIncorrecte extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String message = "El nom no pot tenir números.";

	public ExcepcioNomPersonaIncorrecte() {
		// get message declared by default and call method with the same parameters
		this(message);
	}

	// This constructor allows a custom message.
	public ExcepcioNomPersonaIncorrecte(String message) {
		super(message);
	}
}
