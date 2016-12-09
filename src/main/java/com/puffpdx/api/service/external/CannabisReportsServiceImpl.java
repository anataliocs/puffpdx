package com.puffpdx.api.service.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puffpdx.api.config.WiremockResponses;
import com.puffpdx.api.model.strains.Effects;
import com.puffpdx.api.model.strains.Strains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CannabisReportsServiceImpl implements CannabisReportsService {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public ObjectMapper objectMapper;


    @Override
    public Strains getStrains(String sort, String page) {
        Strains strains = null;

        //TODO Implement wiremocking
        //strains = restTemplate.getForObject("https://www.cannabisreports.com/api/v1.0/strains?sort=name&page=3", Strains.class);

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
}
