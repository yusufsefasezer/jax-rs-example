package com.yusufsezer.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(
            ContainerRequestContext requestContext,
            ContainerResponseContext response) {
        response
                .getHeaders()
                .putSingle("Access-Control-Allow-Origin", "*");
        response
                .getHeaders()
                .putSingle("Access-Control-Allow-Methods",
                        "OPTIONS, GET, POST, PUT, DELETE");
        response
                .getHeaders()
                .putSingle("Access-Control-Allow-Headers", "Content-Type");
    }

}
