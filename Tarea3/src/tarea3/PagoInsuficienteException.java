
package tarea3;

public class PagoInsuficienteException extends Exception {
    
    public PagoInsuficienteException(String comentario) {
        super("PagoInsuficienteException: " + comentario);
    }
}