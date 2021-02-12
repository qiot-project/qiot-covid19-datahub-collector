package io.qiot.covid19.datahub.collector.commons.service;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryIn;
import io.qiot.covid19.datahub.collector.commons.exceptions.TelemetryDataValidationException;

public abstract class AbstractTelemetryValidator<T extends AbstractTelemetryIn> {
    @Inject
    ObjectMapper mapper;

    public T validateData(String data)
            throws TelemetryDataValidationException {
                try {
                    return mapper.readValue(data, getTelemetryType());
                    // } catch (JsonMappingException e) {
                    // e.printStackTrace();
                    // } catch (JsonProcessingException e) {
                    // e.printStackTrace();
                } catch (Exception e) {
                    throw new TelemetryDataValidationException(e);
                }
            }

    protected abstract Class<T> getTelemetryType();

}