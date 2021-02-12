package io.qiot.covid19.datahub.collector.commons.domain;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Station {
    public String id;
    public String serial;
    public String name;
    public double longitude;
    public double latitude;
    public String city;
    public String country;
    @JsonProperty(value = "ccode")
    public String countryCode;
    @JsonProperty(value = "registered_on")
    public Instant registeredOn;
    
    
}