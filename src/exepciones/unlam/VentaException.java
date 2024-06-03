package exepciones.unlam;

public class VentaException extends Exception {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentaException(String message) {
	        super(message);
	    }

	    public VentaException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
