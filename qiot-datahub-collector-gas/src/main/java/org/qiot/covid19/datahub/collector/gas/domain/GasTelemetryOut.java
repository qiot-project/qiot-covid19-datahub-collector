package org.qiot.covid19.datahub.collector.gas.domain;

import javax.validation.constraints.NotNull;

import org.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryOut;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class GasTelemetryOut extends AbstractTelemetryOut {

    public Double adc;

    @NotNull
    public double nh3;

    @NotNull
    public double oxidising;

    @NotNull
    public double reducing;

}
