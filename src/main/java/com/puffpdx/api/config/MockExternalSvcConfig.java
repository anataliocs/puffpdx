package com.puffpdx.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.http.UniformDistribution;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SocketUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

/**
 * Created by chris.anatalio on 12/10/16.
 */
@Configuration
public class MockExternalSvcConfig {

    public static final int LOWER_BOUND_DELAY_MS = 50;
    public static final int UPPER_BOUND_DELAY_MS = 150;

    @Bean
    public WireMockServer wireMockServer() {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String registerEventResponseBody = "";
        String publishEventResponseBody = "";

        try {
            registerEventResponseBody = ow.writeValueAsString("");
            publishEventResponseBody = ow.writeValueAsString("");
        } catch (IOException e) {
            //Do Nothing
        }

        WireMockServer wireMockServer = new WireMockServer(options().port(8089));
        wireMockServer.start();

        UniformDistribution simulatedLatency = new UniformDistribution(LOWER_BOUND_DELAY_MS, UPPER_BOUND_DELAY_MS);

        wireMockServer.stubFor(get(urlEqualTo("/api/v1.0/strains"))
            .willReturn(aResponse()
                .withStatus(HttpStatus.OK.value())
                .withHeader("Content-Type", TEXT_PLAIN_VALUE)
                .withBody("test1234")
                .withRandomDelay(simulatedLatency)));

        wireMockServer.stubFor(get(urlEqualTo("/api/v1.0/flowers"))
            .willReturn(aResponse()
                .withStatus(HttpStatus.OK.value())
                .withHeader("Content-Type", TEXT_PLAIN_VALUE)
                .withBody("test1234")
                .withRandomDelay(simulatedLatency)));


        return wireMockServer;
    }
}

