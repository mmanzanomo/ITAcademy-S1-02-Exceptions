package n3exercici1;

public class ExcepcioSeientIncorrecte extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String message = "El número de seient és incorrecte.";

	public ExcepcioSeientIncorrecte() {
		// get message declared by default and call method with the same parameters
		this(message);
	}

	// This constructor allows a custom message.
	public ExcepcioSeientIncorrecte(String message) {
		super(message);
	}
}
