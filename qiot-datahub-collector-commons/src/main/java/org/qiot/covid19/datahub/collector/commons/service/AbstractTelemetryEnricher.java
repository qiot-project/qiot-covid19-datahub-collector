package org.qiot.covid19.datahub.collector.commons.service;

import org.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryIn;
import org.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryOut;
import org.qiot.covid19.datahub.collector.commons.domain.Station;

public abstract class AbstractTelemetryEnricher<I extends AbstractTelemetryIn, O extends AbstractTelemetryOut> {


    public O mergeData(I in, Station station) {
        O out = getOutInstance();
        out.stationId = in.stationId;
        out.time = in.time;
        out.serial = station.serial;

        out.serial = station.serial;
        out.name = station.name;
        out.longitude = station.longitude;
        out.latitude = station.latitude;
        out.city = station.city;
        out.country = station.country;
        out.countryCode = station.countryCode;

        mergeTelemetryData(in, out);

        return out;
    }

    protected abstract void mergeTelemetryData(I in, O out);

    protected abstract O getOutInstance();

}