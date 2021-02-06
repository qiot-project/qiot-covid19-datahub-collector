package org.qiot.covid19.datahub.collector.commons.domain;

import java.time.Instant;
import java.util.Objects;

import javax.json.bind.annotation.JsonbProperty;

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
    @JsonbProperty(value = "ccode")
    public String countryCode;
    @JsonbProperty(value = "registered_on")
    public Instant registeredOn;
    
    
}