package org.qiot.covid19.datahub.collector.pollution.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.qiot.covid19.datahub.collector.commons.domain.Station;
import org.qiot.covid19.datahub.collector.commons.exceptions.TelemetryDataValidationException;
import org.qiot.covid19.datahub.collector.commons.exceptions.TelemetryTransformationException;
import org.qiot.covid19.datahub.collector.commons.service.AbstractTelemetryCollector;
import org.qiot.covid19.datahub.collector.pollution.domain.PollutionTelemetryIn;
import org.qiot.covid19.datahub.collector.pollution.domain.PollutionTelemetryOut;

/**
 * Message coming from MQTT have a byte[] payload
 */
@ApplicationScoped
public class PollutionCollectorService extends
        AbstractTelemetryCollector<PollutionTelemetryIn, PollutionTelemetryOut, PollutionTelemetryValidator, PollutionTelemetryEnricher> {

    @Inject
    PollutionTelemetryValidator validator;

    @Inject
    PollutionTelemetryEnricher enricher;

    @Inject
    @RestClient
    StationServiceClient stationServiceClient;

    @Incoming("pollution-external")
    @Outgoing("pollution-internal")
    public String collect(byte[] json) throws TelemetryDataValidationException,
            TelemetryTransformationException {
        return super.collect(json);
    }

    @Override
    protected PollutionTelemetryIn validate(String data)
            throws TelemetryDataValidationException {
        return validator.validateData(data);
    }

    @Override
    protected PollutionTelemetryOut enrich(PollutionTelemetryIn telemetryIn) {
        Station station = stationServiceClient.getById(telemetryIn.stationId);
        return enricher.mergeData(telemetryIn, station);
    }
}
