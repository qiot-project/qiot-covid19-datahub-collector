package io.qiot.covid19.datahub.collector.gas.service.collector;

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
import io.qiot.covid19.datahub.collector.gas.domain.GasTelemetryIn;
import io.qiot.covid19.datahub.collector.gas.domain.GasTelemetryOut;
import io.qiot.covid19.datahub.collector.gas.service.enricher.GasTelemetryEnricher;
import io.qiot.covid19.datahub.collector.gas.service.station.StationServiceClient;
import io.qiot.covid19.datahub.collector.gas.service.validator.GasTelemetryValidator;

/**
 * Message coming from MQTT have a byte[] payload
 */
@ApplicationScoped
public class GasCollectorService extends
        AbstractTelemetryCollector<GasTelemetryIn, GasTelemetryOut, GasTelemetryValidator, GasTelemetryEnricher> {

    @Inject
    Logger LOGGER;

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
        LOGGER.debug("collect(byte[] json={}) - start", json);

        String returnString = super.collect(json);
        LOGGER.debug("collect(byte[] json={}) - end - return value={}", json,
                returnString);
        return returnString;
    }

    @Override
    protected GasTelemetryIn validate(String data)
            throws TelemetryDataValidationException {
        LOGGER.debug("validate(String data={}) - start", data);

        GasTelemetryIn returnGasTelemetryIn = validator.validateData(data);
        LOGGER.debug("validate(String data={}) - end - return value={}", data,
                returnGasTelemetryIn);
        return returnGasTelemetryIn;
    }

    @Override
    protected GasTelemetryOut enrich(GasTelemetryIn telemetryIn) {
        LOGGER.debug("enrich(GasTelemetryIn telemetryIn={}) - start",
                telemetryIn);

        Station station = stationServiceClient.getById(telemetryIn.stationId);
        LOGGER.info("Station sending telemetry: {}", station);

        GasTelemetryOut returnGasTelemetryOut = enricher.mergeData(telemetryIn,
                station);
        LOGGER.debug(
                "enrich(GasTelemetryIn telemetryIn={}) - end - return value={}",
                telemetryIn, returnGasTelemetryOut);
        return returnGasTelemetryOut;
    }
}
