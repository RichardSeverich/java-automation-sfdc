package org.fundacionjala.sfdc.core;

/**
 * Class that personalize the Runtime Exception.
 */
public class MyRuntimeException extends RuntimeException {

    /**
     * Constructor for the custom Runtime Exception.
     *
     * @param message contains the message of exception.
     * @param cause   contains the runtime exception.
     */
    public MyRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
