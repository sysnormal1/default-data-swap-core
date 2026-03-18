package com.sysnormal.commons.core;

import java.util.Objects;


/**
 * Default class for represent generic data swap between processes.
 *
 * @author aalencarvz1
 * @version 1.0.0
 */
public class DefaultDataSwap {


    /**
     * the success indicative
     */
    public boolean success = false;

    /**
     * the data to swap
     */
    public Object data = null;

    /**
     * the message, if necessary
     */
    public String message = null;

    /**
     * the http status code
     */
    public Integer httpStatusCode = null;

    /**
     * the exception if occurs
     */
    public Exception exception = null;

    public DefaultDataSwap() {}

    public DefaultDataSwap(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public void setException(Exception exception) {
        System.out.println("setting exception");
        if (Objects.nonNull(exception)) {
            exception.printStackTrace();
        }
        this.success = false;
        this.httpStatusCode = Objects.requireNonNullElse(this.httpStatusCode, 500);
        this.exception = exception;
        if (!(this.message != null && !this.message.isEmpty()) && this.exception != null) {
            this.message = this.exception.getMessage();
        }
    }
}
