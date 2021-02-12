/**
 * 
 */
package org.qiot.covid19.datahub.collector.commons.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty(value = "ccode")
    public String countryCode;
}
