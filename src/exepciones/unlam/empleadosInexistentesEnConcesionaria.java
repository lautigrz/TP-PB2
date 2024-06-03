package exepciones.unlam;

public class empleadosInexistentesEnConcesionaria extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  empleadosInexistentesEnConcesionaria(String mensaje) {
        super(mensaje);
    }
	
}
