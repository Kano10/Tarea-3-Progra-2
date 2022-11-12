package tarea3;

public class PagoIncorrectoException extends Exception {

    public PagoIncorrectoException(String comentario){
        super("PagoIncorrectoException: "  + comentario);
    }
}