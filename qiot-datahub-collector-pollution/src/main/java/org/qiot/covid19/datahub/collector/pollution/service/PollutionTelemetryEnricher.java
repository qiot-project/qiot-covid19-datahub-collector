package org.qiot.covid19.datahub.collector.pollution.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.qiot.covid19.datahub.collector.commons.service.AbstractTelemetryEnricher;
import org.qiot.covid19.datahub.collector.pollution.domain.PollutionTelemetryIn;
import org.qiot.covid19.datahub.collector.pollution.domain.PollutionTelemetryOut;
import org.slf4j.Logger;

@ApplicationScoped
public class PollutionTelemetryEnricher extends
        AbstractTelemetryEnricher<PollutionTelemetryIn, PollutionTelemetryOut> {

    @Inject
    Logger LOGGER;

    @Override
    protected PollutionTelemetryOut getOutInstance() {
        return new PollutionTelemetryOut();
    }

    @Override
    protected void mergeTelemetryData(PollutionTelemetryIn in,
            PollutionTelemetryOut out) {
        out.pm1_0 = in.pm1_0;
        out.pm2_5 = in.pm2_5;
        out.pm10 = in.pm10;
        out.pm1_0_atm = in.pm1_0_atm;
        out.pm2_5_atm = in.pm2_5_atm;
        out.pm10_atm = in.pm10_atm;
        out.gt0_3um = in.gt0_3um;
        out.gt0_5um = in.gt0_5um;
        out.gt1_0um = in.gt1_0um;
        out.gt2_5um = in.gt2_5um;
        out.gt5_0um = in.gt5_0um;
        out.gt10um = in.gt10um;
    }
}
