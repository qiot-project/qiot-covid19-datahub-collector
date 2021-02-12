package io.qiot.covid19.datahub.collector.pollution.service.collector;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;

import io.qiot.covid19.datahub.collector.commons.domain.Station;
import io.qiot.covid19.datahub.collector.commons.exceptions.TelemetryDataValidationException;
import io.qiot.covid19.datahub.collector.commons.exceptions.TelemetryTransformationException;
import io.qiot.covid19.datahub.collector.commons.service.AbstractTelemetryCollector;
import io.qiot.covid19.datahub.collector.pollution.domain.PollutionTelemetryIn;
import io.qiot.covid19.datahub.collector.pollution.domain.PollutionTelemetryOut;
import io.qiot.covid19.datahub.collector.pollution.service.enricher.PollutionTelemetryEnricher;
import io.qiot.covid19.datahub.collector.pollution.service.station.StationServiceClient;
import io.qiot.covid19.datahub.collector.pollution.service.validator.PollutionTelemetryValidator;

/**
 * Message coming from MQTT have a byte[] payload
 */
@ApplicationScoped
public class PollutionCollectorService extends
        AbstractTelemetryCollector<PollutionTelemetryIn, PollutionTelemetryOut, PollutionTelemetryValidator, PollutionTelemetryEnricher> {

    @Inject
    Logger LOGGER;

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
        LOGGER.debug("collect(byte[] json={}) - start", json);

        String returnString = super.collect(json);
        LOGGER.debug("collect(byte[] json={}) - end - return value={}", json,
                returnString);
        return returnString;
    }

    @Override
    protected PollutionTelemetryIn validate(String data)
            throws TelemetryDataValidationException {
        LOGGER.debug("validate(String data={}) - start", data);

        PollutionTelemetryIn returnPollutionTelemetryIn = validator
                .validateData(data);
        LOGGER.debug("validate(String data={}) - end - return value={}", data,
                returnPollutionTelemetryIn);
        return returnPollutionTelemetryIn;
    }

    @Override
    protected PollutionTelemetryOut enrich(PollutionTelemetryIn telemetryIn) {
        LOGGER.debug("enrich(PollutionTelemetryIn telemetryIn={}) - start",
                telemetryIn);

        Station station = stationServiceClient.getById(telemetryIn.stationId);
        LOGGER.info("Station sending telemetry: {}", station);

        PollutionTelemetryOut returnPollutionTelemetryOut = enricher
                .mergeData(telemetryIn, station);
        LOGGER.debug(
                "enrich(PollutionTelemetryIn telemetryIn={}) - end - return value={}",
                telemetryIn, returnPollutionTelemetryOut);
        return returnPollutionTelemetryOut;
    }
}
