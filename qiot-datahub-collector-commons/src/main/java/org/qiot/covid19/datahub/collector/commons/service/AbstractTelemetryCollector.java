package org.qiot.covid19.datahub.collector.commons.service;

import javax.inject.Inject;

import org.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryIn;
import org.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryOut;
import org.qiot.covid19.datahub.collector.commons.exceptions.TelemetryDataValidationException;
import org.qiot.covid19.datahub.collector.commons.exceptions.TelemetryTransformationException;
import org.slf4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        LOGGER.info("MQTT: Received GAS message {}", data);
        I telemetryIn = validate(data);
        AbstractTelemetryOut telemetryOut = enrich(telemetryIn);
        String telemetryJson;
        try {
            telemetryJson = mapper.writeValueAsString(telemetryOut);
        } catch (JsonProcessingException e) {
            throw new TelemetryTransformationException(e);
        }
        LOGGER.debug("Output telemetry: {}", telemetryJson);
        return telemetryJson;
    }

    protected abstract I validate(String data)
            throws TelemetryDataValidationException;

    protected abstract O enrich(I telemetryIn)
            throws TelemetryTransformationException;
}
