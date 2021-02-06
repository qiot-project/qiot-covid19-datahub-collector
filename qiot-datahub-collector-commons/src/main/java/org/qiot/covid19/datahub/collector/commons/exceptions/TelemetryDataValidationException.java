/**
 * 
 */
package org.qiot.covid19.datahub.collector.commons.exceptions;

/**
 * @author abattagl
 *
 */
public class TelemetryDataValidationException extends Exception {

    public TelemetryDataValidationException() {
        super();
    }

    public TelemetryDataValidationException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TelemetryDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TelemetryDataValidationException(String message) {
        super(message);
    }

    public TelemetryDataValidationException(Throwable cause) {
        super(cause);
    }

}
