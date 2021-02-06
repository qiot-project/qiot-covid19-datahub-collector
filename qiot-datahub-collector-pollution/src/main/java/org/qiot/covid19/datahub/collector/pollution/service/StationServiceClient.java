/**
 * 
 */

package org.qiot.covid19.datahub.collector.pollution.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.qiot.covid19.datahub.collector.commons.domain.Station;

/**
 * @author abattagl
 *
 */
@Path("/v1/station")
@RegisterRestClient(configKey = "station-api")
public interface StationServiceClient {
    
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Station getById(@QueryParam("id") String id);

}
