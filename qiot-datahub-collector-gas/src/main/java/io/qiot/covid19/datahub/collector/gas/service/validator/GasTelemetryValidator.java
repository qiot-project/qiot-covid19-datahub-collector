package io.qiot.covid19.datahub.collector.gas.service.validator;

import javax.enterprise.context.ApplicationScoped;

import io.qiot.covid19.datahub.collector.commons.service.AbstractTelemetryValidator;
import io.qiot.covid19.datahub.collector.gas.domain.GasTelemetryIn;

@ApplicationScoped
public class GasTelemetryValidator
        extends AbstractTelemetryValidator<GasTelemetryIn> {

    @Override
    protected Class<GasTelemetryIn> getTelemetryType() {
        return GasTelemetryIn.class;
    }
}
