/**
 * 
 */
package org.qiot.covid19.datahub.collector.commons.domain;

import java.time.Instant;

import javax.json.bind.annotation.JsonbProperty;

/**
 * @author abattagl
 *
 */
public abstract class AbstractTelemetry {
    @JsonbProperty(value = "station_id")
    public String stationId;

    public Instant time;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((stationId == null) ? 0 : stationId.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractTelemetry other = (AbstractTelemetry) obj;
        if (stationId == null) {
            if (other.stationId != null)
                return false;
        } else if (!stationId.equals(other.stationId))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        return true;
    }
}
