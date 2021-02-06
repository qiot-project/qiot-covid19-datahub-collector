package org.qiot.covid19.datahub.collector.gas.domain;

import javax.validation.constraints.NotNull;

import org.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryIn;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class GasTelemetryIn extends AbstractTelemetryIn {

    public Double adc;

    @NotNull
    public double nh3;

    @NotNull
    public double oxidising;

    @NotNull
    public double reducing;


}
