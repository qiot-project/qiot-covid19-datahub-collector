package org.qiot.covid19.datahub.collector.pollution.service;

import javax.enterprise.context.ApplicationScoped;

import org.qiot.covid19.datahub.collector.commons.service.AbstractTelemetryValidator;
import org.qiot.covid19.datahub.collector.pollution.domain.PollutionTelemetryIn;

@ApplicationScoped
public class PollutionTelemetryValidator
        extends AbstractTelemetryValidator<PollutionTelemetryIn> {

    @Override
    protected Class<PollutionTelemetryIn> getTelemetryType() {
        return PollutionTelemetryIn.class;
    }
}
