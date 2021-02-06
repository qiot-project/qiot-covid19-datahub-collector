package org.qiot.covid19.datahub.collector.pollution.domain;

import org.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryIn;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class PollutionTelemetryIn extends AbstractTelemetryIn {

    public int pm1_0;

    public int pm2_5;

    public int pm10;

    public int pm1_0_atm;

    public int pm2_5_atm;

    public int pm10_atm;

    public int gt0_3um;

    public int gt0_5um;

    public int gt1_0um;

    public int gt2_5um;

    public int gt5_0um;

    public int gt10um;

}
