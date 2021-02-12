package io.qiot.covid19.datahub.collector.pollution.service.validator;

import javax.enterprise.context.ApplicationScoped;

import io.qiot.covid19.datahub.collector.commons.service.AbstractTelemetryValidator;
import io.qiot.covid19.datahub.collector.pollution.domain.PollutionTelemetryIn;

@ApplicationScoped
public class PollutionTelemetryValidator
        extends AbstractTelemetryValidator<PollutionTelemetryIn> {

    @Override
    protected Class<PollutionTelemetryIn> getTelemetryType() {
        return PollutionTelemetryIn.class;
    }
}
