package ua.net.ost.AlexanderOstrovskij.exceptions;

/* *

 * Used when we do not receive pulse string for some reason.

 */

public class PulseReadErrorException extends Exception {
    public PulseReadErrorException() {
        super();
    }

    public PulseReadErrorException(String message) {
        super(message);
    }

    public PulseReadErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public PulseReadErrorException(Throwable cause) {
        super(cause);
    }
}
