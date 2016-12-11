package com.puffpdx.api.service.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puffpdx.api.config.WiremockResponses;
import com.puffpdx.api.config.mapping.ExternalServiceUri;
import com.puffpdx.api.model.strains.Effects;
import com.puffpdx.api.model.strains.Flowers;
import com.puffpdx.api.model.strains.Strains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import java.io.IOException;
import java.util.HashMap;

@Service
public class CannabisReportsServiceImpl implements CannabisReportsService {

    @Autowired
    AsyncRestTemplate asyncRestTemplate;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UriComponents eventRegistrationServiceUri;


    @Override
    public ResponseEntity<Strains> getStrains(String sort, String page) {
        Strains strains = null;

        ResponseEntity<Strains> response =
            restTemplate.getForEntity(
                eventRegistrationServiceUri.toUriString(),Strains.class);

        return response;
    }

    @Override
    public Effects getEffectsByUcpc(String ucpc) {
        Effects effects = null;

        try {
            effects = objectMapper.readValue(WiremockResponses.effectsResponseBody, Effects.class);
        } catch (IOException e) {
            //TODO Handle Parse exception
            e.printStackTrace();
        }

        return effects;
    }

    @Override
    public Flowers getFlowers(String sort, String page) {

        Flowers flowers = null;

        try {
            flowers = objectMapper.readValue(WiremockResponses.flowersResponseBody, Flowers.class);
        } catch (IOException e) {
            //TODO Handle Parse exception
            e.printStackTrace();
        }

        return flowers;
    }
}
