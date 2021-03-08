/**
 * 
 */
package io.qiot.covid19.datahub.collector.commons.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * @author andreabattaglia
 *
 */
@RegisterForReflection
public abstract class AbstractTelemetryOut extends AbstractTelemetry {
    @JsonProperty(value = "serial")
    public String serial;
    @JsonProperty(value = "name")
    public String name;
    @JsonProperty(value = "longitude")
    public double longitude;
    @JsonProperty(value = "latitude")
    public double latitude;
    @JsonProperty(value = "city")
    public String city;
    @JsonProperty(value = "country")
    public String country;
    @JsonProperty(value = "ccode")
    public String countryCode;
}
