package excepciones;

/**
 *
 * @author isabella
 */
public class StringVacio extends Exception {

    /**
     * Creates a new instance of <code>StringVacio</code> without detail
     * message.
     */
    public StringVacio() {
        super("El string está vacío");
    }

    /**
     * Constructs an instance of <code>StringVacio</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public StringVacio(String msg) {
        super(msg);
    }
}