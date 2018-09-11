package ua.net.ost.AlexanderOstrovskij.exceptions;

/*
 * Used when not getting correct status from HTTP server
 */
public class HttpWrongStatusException extends Exception {
    public HttpWrongStatusException(String message) {
        super(message);
    }

    public HttpWrongStatusException() {
        super();
    }

    public HttpWrongStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpWrongStatusException(Throwable cause) {
        super(cause);
    }

}
