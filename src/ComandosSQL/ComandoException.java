package ComandosSQL;

public class ComandoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ComandoException(String msg) {
        super(msg);
    }
}
