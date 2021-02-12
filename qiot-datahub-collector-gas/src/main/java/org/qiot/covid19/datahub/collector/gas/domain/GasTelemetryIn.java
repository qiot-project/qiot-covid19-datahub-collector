package org.qiot.covid19.datahub.collector.gas.domain;

import org.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryIn;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class GasTelemetryIn extends AbstractTelemetryIn {

    @JsonProperty(value = "adc")
    public Double adc;
    @JsonProperty(value = "nh3")
    public double nh3;
    @JsonProperty(value = "oxidising")
    public double oxidising;
    @JsonProperty(value = "reducing")
    public double reducing;

}
