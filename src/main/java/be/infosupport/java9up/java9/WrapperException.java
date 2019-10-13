package be.infosupport.java9up.java9;

public class WrapperException extends Exception {
    public WrapperException(String message) {
        super(message);
    }

    public WrapperException(String message, Throwable cause) {
        super(message, cause);
    }
}
