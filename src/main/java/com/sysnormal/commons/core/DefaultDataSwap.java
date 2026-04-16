package com.sysnormal.commons.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


/**
 * Default class for represent generic data swap between processes.
 *
 * @author aalencarvz1
 * @version 1.0.0
 */
public class DefaultDataSwap {

    private static final Logger logger = LoggerFactory.getLogger(DefaultDataSwap.class);

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
        logger.debug("INIT {}.{}",this.getClass().getSimpleName(), "setException");
        this.success = false;
        this.httpStatusCode = Objects.requireNonNullElse(this.httpStatusCode, 500);
        this.exception = exception;
        if (200 == this.httpStatusCode) {
            this.httpStatusCode = 500;
        }
        if (Objects.nonNull(this.exception)) {
            if (!(this.message != null && !this.message.isEmpty()) && this.exception != null) {
                this.message = this.exception.getMessage();
            }
            this.exception.printStackTrace();
        }
        logger.debug("END {}.{}",this.getClass().getSimpleName(), "setException");
    }

    public void throwError() throws Exception {
        if (this.exception != null) {
            throw this.exception;
        } else {
            throw new Exception(this.message);
        }
    }
}
