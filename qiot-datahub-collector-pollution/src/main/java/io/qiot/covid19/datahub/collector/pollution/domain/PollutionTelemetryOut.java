package io.qiot.covid19.datahub.collector.pollution.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.qiot.covid19.datahub.collector.commons.domain.AbstractTelemetryOut;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class PollutionTelemetryOut extends AbstractTelemetryOut {

    @JsonProperty(value = "pm1_0")
    public int pm1_0;
    @JsonProperty(value = "pm2_5")
    public int pm2_5;
    @JsonProperty(value = "pm10")
    public int pm10;
    @JsonProperty(value = "pm1_0_atm")
    public int pm1_0_atm;
    @JsonProperty(value = "pm2_5_atm")
    public int pm2_5_atm;
    @JsonProperty(value = "pm10_atm")
    public int pm10_atm;
    @JsonProperty(value = "gt0_3um")
    public int gt0_3um;
    @JsonProperty(value = "gt0_5um")
    public int gt0_5um;
    @JsonProperty(value = "gt1_0um")
    public int gt1_0um;
    @JsonProperty(value = "gt2_5um")
    public int gt2_5um;
    @JsonProperty(value = "gt5_0um")
    public int gt5_0um;
    @JsonProperty(value = "gt10um")
    public int gt10um;
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PollutionTelemetryOut [stationId=");
        builder.append(stationId);
        builder.append(", time=");
        builder.append(time);
        builder.append(", serial=");
        builder.append(serial);
        builder.append(", name=");
        builder.append(name);
        builder.append(", longitude=");
        builder.append(longitude);
        builder.append(", latitude=");
        builder.append(latitude);
        builder.append(", city=");
        builder.append(city);
        builder.append(", country=");
        builder.append(country);
        builder.append(", countryCode=");
        builder.append(countryCode);
        builder.append(", pm1_0=");
        builder.append(pm1_0);
        builder.append(", pm2_5=");
        builder.append(pm2_5);
        builder.append(", pm10=");
        builder.append(pm10);
        builder.append(", pm1_0_atm=");
        builder.append(pm1_0_atm);
        builder.append(", pm2_5_atm=");
        builder.append(pm2_5_atm);
        builder.append(", pm10_atm=");
        builder.append(pm10_atm);
        builder.append(", gt0_3um=");
        builder.append(gt0_3um);
        builder.append(", gt0_5um=");
        builder.append(gt0_5um);
        builder.append(", gt1_0um=");
        builder.append(gt1_0um);
        builder.append(", gt2_5um=");
        builder.append(gt2_5um);
        builder.append(", gt5_0um=");
        builder.append(gt5_0um);
        builder.append(", gt10um=");
        builder.append(gt10um);
        builder.append("]");
        return builder.toString();
    }
    
    
}
