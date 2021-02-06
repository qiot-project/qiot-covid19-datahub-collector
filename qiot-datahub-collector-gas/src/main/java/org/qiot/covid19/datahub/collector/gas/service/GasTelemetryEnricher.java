package org.qiot.covid19.datahub.collector.gas.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.qiot.covid19.datahub.collector.commons.service.AbstractTelemetryEnricher;
import org.qiot.covid19.datahub.collector.gas.domain.GasTelemetryIn;
import org.qiot.covid19.datahub.collector.gas.domain.GasTelemetryOut;
import org.slf4j.Logger;

@ApplicationScoped
public class GasTelemetryEnricher
        extends AbstractTelemetryEnricher<GasTelemetryIn, GasTelemetryOut> {

    @Inject
    Logger LOGGER;

    @Override
    protected GasTelemetryOut getOutInstance() {
        return new GasTelemetryOut();
    }

    @Override
    protected void mergeTelemetryData(GasTelemetryIn in, GasTelemetryOut out) {
        out.adc = in.adc;
        out.nh3 = in.nh3;
        out.oxidising = in.oxidising;
        out.reducing = in.reducing;
    }
}
