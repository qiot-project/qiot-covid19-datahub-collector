package io.qiot.covid19.datahub.collector.gas.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryIn;
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
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GasTelemetryIn [stationId=");
        builder.append(stationId);
        builder.append(", time=");
        builder.append(time);
        builder.append(", adc=");
        builder.append(adc);
        builder.append(", nh3=");
        builder.append(nh3);
        builder.append(", oxidising=");
        builder.append(oxidising);
        builder.append(", reducing=");
        builder.append(reducing);
        builder.append("]");
        return builder.toString();
    }

    
}
