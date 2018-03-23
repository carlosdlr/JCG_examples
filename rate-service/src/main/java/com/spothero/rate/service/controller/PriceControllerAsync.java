package com.spothero.rate.service.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.spothero.rate.service.RateService;

@Path("/Async/price")
public class PriceControllerAsync {
   
	@Inject
    private RateService service;

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void asyncFindRates(@Suspended final AsyncResponse asyncResponse) {
    	asyncResponse.setTimeout(1000, TimeUnit.MILLISECONDS);
        asyncResponse.setTimeoutHandler(ar -> ar.resume(
                Response.status(Response.Status.SERVICE_UNAVAILABLE)
                        .entity("Operation timed out")
                        .build()));

        List<Double> result = service.findRatesByDateRange(new Date(), new Date());
        asyncResponse.resume(result);
    }
    
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Hello, World!!</body></h1></html>";
    }
}
