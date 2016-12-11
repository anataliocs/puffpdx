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
    ObjectMapper objectMapper;

    @Autowired
    UriComponents eventRegistrationServiceUri;


    @Override
    public Strains getStrains(String sort, String page) {
        Strains strains = null;

        //TODO Implement wiremocking
        //strains = restTemplate.getForObject("https://www.cannabisreports.com/api/v1.0/strains?sort=name&page=3", Strains.class);

        System.out.println();
        System.out.println("=====");
        System.out.println("Making rest call to cr");

        ListenableFuture<ResponseEntity<String>> response =
            asyncRestTemplate.getForEntity(
                eventRegistrationServiceUri.toUriString(),String.class, new HashMap<String, Object>());

        response.addCallback(onSuccess -> {
                System.out.println();
                System.out.println("-----");
                System.out.println("onSuccess = " + onSuccess.getBody());
                System.out.println();
        },
            failure -> {
                System.out.println();
                System.out.println("-----");
                failure.printStackTrace();
                System.out.println();
            });

        try {
            strains = objectMapper.readValue(WiremockResponses.strainsResponseBody, Strains.class);
        } catch (IOException e) {
            //TODO Handle Parse exception
            e.printStackTrace();
        }

        return strains;
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
