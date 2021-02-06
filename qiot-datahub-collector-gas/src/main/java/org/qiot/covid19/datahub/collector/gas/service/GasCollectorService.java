package org.qiot.covid19.datahub.collector.gas.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.qiot.covid19.datahub.collector.commons.domain.Station;
import org.qiot.covid19.datahub.collector.commons.exceptions.TelemetryDataValidationException;
import org.qiot.covid19.datahub.collector.commons.exceptions.TelemetryTransformationException;
import org.qiot.covid19.datahub.collector.commons.service.AbstractTelemetryCollector;
import org.qiot.covid19.datahub.collector.gas.domain.GasTelemetryIn;
import org.qiot.covid19.datahub.collector.gas.domain.GasTelemetryOut;

/**
 * Message coming from MQTT have a byte[] payload
 */
@ApplicationScoped
public class GasCollectorService extends
        AbstractTelemetryCollector<GasTelemetryIn, GasTelemetryOut, GasTelemetryValidator, GasTelemetryEnricher> {

    @Inject
    GasTelemetryValidator validator;

    @Inject
    GasTelemetryEnricher enricher;

    @Inject
    @RestClient
    StationServiceClient stationServiceClient;

    @Incoming("gas-external")
    @Outgoing("gas-internal")
    public String collect(byte[] json) throws TelemetryDataValidationException,
            TelemetryTransformationException {
        return super.collect(json);
    }

    @Override
    protected GasTelemetryIn validate(String data)
            throws TelemetryDataValidationException {
        return validator.validateData(data);
    }

    @Override
    protected GasTelemetryOut enrich(GasTelemetryIn telemetryIn) {
        Station station = stationServiceClient.getById(telemetryIn.stationId);
        return enricher.mergeData(telemetryIn, station);
    }
}
