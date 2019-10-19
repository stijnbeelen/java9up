package be.infosupport.java9up.java9;

public class Java9Exception extends RuntimeException {
    public Java9Exception(String message) {
        super(message);
    }

    public Java9Exception(String message, Throwable cause) {
        super(message, cause);
    }
}
