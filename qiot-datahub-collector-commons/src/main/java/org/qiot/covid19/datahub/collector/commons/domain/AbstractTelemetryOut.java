/**
 * 
 */
package org.qiot.covid19.datahub.collector.commons.domain;

import javax.json.bind.annotation.JsonbProperty;

/**
 * @author abattagl
 *
 */
public abstract class AbstractTelemetryOut extends AbstractTelemetry {
    public String serial;
    public String name;
    public double longitude;
    public double latitude;
    public String city;
    public String country;
    @JsonbProperty(value = "ccode")
    public String countryCode;
}
