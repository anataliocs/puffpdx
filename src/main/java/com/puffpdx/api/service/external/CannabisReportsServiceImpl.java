package com.puffpdx.api.service.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puffpdx.api.config.WiremockResponses;
import com.puffpdx.api.model.strains.Strains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class CannabisReportsServiceImpl implements CannabisReportsService {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public ObjectMapper objectMapper;


    @Override
    public Strains getStrains(String sort, String page) {
        Strains strains = null;

        try {
            strains = objectMapper.readValue(WiremockResponses.strainsResponseBody, Strains.class);
        } catch (IOException e) {
            //TODO Handle Parse exception
            e.printStackTrace();
        }

        return strains;
    }

    @Override
    public Strains getEffectsByUcpc(String ucpc) {
        Strains strains = null;

        try {
            strains = objectMapper.readValue(WiremockResponses.effectsResponseBody, Strains.class);
        } catch (IOException e) {
            //TODO Handle Parse exception
            e.printStackTrace();
        }

        return strains;
    }
}
