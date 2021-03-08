/**
 * 
 */
package io.qiot.covid19.datahub.collector.commons.exceptions;

/**
 * @author andreabattaglia
 *
 */
public class TelemetryTransformationException extends Exception {

    public TelemetryTransformationException() {
        super();
    }

    public TelemetryTransformationException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TelemetryTransformationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TelemetryTransformationException(String message) {
        super(message);
    }

    public TelemetryTransformationException(Throwable cause) {
        super(cause);
    }

}
