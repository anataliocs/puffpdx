package com.puffpdx.api.config;

import com.puffpdx.api.config.mapping.ExternalServiceUri;
import com.puffpdx.api.config.mapping.ExternalServicesMappingProperties;
import com.puffpdx.api.config.mapping.ThreadPoolTaskExecutorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by chris.anatalio on 12/10/16.
 */
@Configuration
@EnableConfigurationProperties(ExternalServicesMappingProperties.class)
public class ExternalServicesConfig {

    private static final String TEMPLATE_VARS_DELIMITER = ",";

    @Autowired
    private ExternalServicesMappingProperties externalServicesMappingProperties;

    @Bean
    public UriComponents eventRegistrationServiceUri() {

        ExternalServiceUri eventRegistrationServiceUri = externalServicesMappingProperties.getEventRegistrationServiceUri();

        return UriComponentsBuilder.newInstance()
            .scheme(eventRegistrationServiceUri.getScheme())
            .host(eventRegistrationServiceUri.getHost())
            .path(eventRegistrationServiceUri.getBasePath())
            .port(eventRegistrationServiceUri.getPort())
            .build()
            .expand(generateTemplateVariableList(eventRegistrationServiceUri))
            .encode();
    }

    @Bean
    public UriComponents eventPublicationServiceUri() {

        ExternalServiceUri eventPublicationServiceUri = externalServicesMappingProperties.getEventPublicationServiceUri();

        return UriComponentsBuilder.newInstance()
            .scheme(eventPublicationServiceUri.getScheme())
            .host(eventPublicationServiceUri.getHost())
            .path(eventPublicationServiceUri.getBasePath())
            .port(eventPublicationServiceUri.getPort())
            .build()
            .expand(generateTemplateVariableList(eventPublicationServiceUri)) //TODO: determine how to persist and retreive publishURI
            .encode();
    }

    @Bean
    public RestTemplate restTemplate() {return new RestTemplate();}

    @Bean
    public AsyncRestTemplate asyncRestTemplate() {

        ThreadPoolTaskExecutorConfig threadPoolTaskExecutorConfig = externalServicesMappingProperties.getThreadPoolTaskExecutorConfig();

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(threadPoolTaskExecutorConfig.getAllowCoreThreadTimeOut()); //Default: false
        threadPoolTaskExecutor.setCorePoolSize(threadPoolTaskExecutorConfig.getCorePoolSize()); //Default: 1
        threadPoolTaskExecutor.setKeepAliveSeconds(threadPoolTaskExecutorConfig.getKeepAliveSeconds()); //Default: 60
        threadPoolTaskExecutor.setMaxPoolSize(threadPoolTaskExecutorConfig.getMaxPoolSize()); //Default: Integer.MAX_VALUE
        threadPoolTaskExecutor.setQueueCapacity(threadPoolTaskExecutorConfig.getQueueCapacity()); //Default: Integer.MAX_VALUE
        threadPoolTaskExecutor.initialize();

        return new AsyncRestTemplate(threadPoolTaskExecutor);
    }

    private String[] generateTemplateVariableList(ExternalServiceUri extServiceUri) {
        return extServiceUri.getTemplateValues().split(TEMPLATE_VARS_DELIMITER);
    }
}
