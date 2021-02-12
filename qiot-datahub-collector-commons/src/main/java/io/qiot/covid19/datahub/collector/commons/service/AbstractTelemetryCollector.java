package io.qiot.covid19.datahub.collector.commons.service;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryIn;
import io.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryOut;
import io.qiot.covid19.datahub.collector.commons.exceptions.TelemetryDataValidationException;
import io.qiot.covid19.datahub.collector.commons.exceptions.TelemetryTransformationException;

public abstract class AbstractTelemetryCollector<I extends AbstractTelemetryIn, O extends AbstractTelemetryOut, V extends AbstractTelemetryValidator<I>, E extends AbstractTelemetryEnricher<I, O>> {

    @Inject
    Logger LOGGER;

    @Inject
    ObjectMapper mapper;

    @Inject
    protected V validator;

    @Inject
    protected E enricher;

    public String collect(byte[] json) throws TelemetryDataValidationException,
            TelemetryTransformationException {

        String data = new String(json);
        LOGGER.info("MQTT: Received telemetry message {}", data);

        I telemetryIn = validate(data);
        LOGGER.info("Validated Telemetry {}", telemetryIn);

        AbstractTelemetryOut telemetryOut = enrich(telemetryIn);
        LOGGER.info("Enriched Telemetry {}", telemetryOut);

        String telemetryJson;
        try {
            telemetryJson = mapper.writeValueAsString(telemetryOut);
        } catch (JsonProcessingException e) {
            LOGGER.error("collect(byte[])", e);

            throw new TelemetryTransformationException(e);
        }
        LOGGER.info("Output telemetry: {}", telemetryJson);
        return telemetryJson;
    }

    protected abstract I validate(String data)
            throws TelemetryDataValidationException;

    protected abstract O enrich(I telemetryIn)
            throws TelemetryTransformationException;
}
