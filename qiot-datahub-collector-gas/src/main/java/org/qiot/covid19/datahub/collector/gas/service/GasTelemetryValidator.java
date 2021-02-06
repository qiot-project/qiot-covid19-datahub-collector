package org.qiot.covid19.datahub.collector.gas.service;

import javax.enterprise.context.ApplicationScoped;

import org.qiot.covid19.datahub.collector.commons.service.AbstractTelemetryValidator;
import org.qiot.covid19.datahub.collector.gas.domain.GasTelemetryIn;

@ApplicationScoped
public class GasTelemetryValidator
        extends AbstractTelemetryValidator<GasTelemetryIn> {

    @Override
    protected Class<GasTelemetryIn> getTelemetryType() {
        return GasTelemetryIn.class;
    }
}
