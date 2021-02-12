package io.qiot.covid19.datahub.collector.gas.service.enricher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import io.qiot.covid19.datahub.collector.commons.service.AbstractTelemetryEnricher;
import io.qiot.covid19.datahub.collector.gas.domain.GasTelemetryIn;
import io.qiot.covid19.datahub.collector.gas.domain.GasTelemetryOut;

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
