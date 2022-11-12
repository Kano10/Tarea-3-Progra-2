package tarea3;

public class NoHayBebidaException extends Exception {

    public NoHayBebidaException(String comentario) {
        super("NoHayBebidaException: " + comentario);
    }
}