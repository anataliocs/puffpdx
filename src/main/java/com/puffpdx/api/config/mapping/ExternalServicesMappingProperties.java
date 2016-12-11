package com.puffpdx.api.config.mapping;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chris.anatalio on 12/10/16.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(locations = "classpath:config/external-service.yml", ignoreUnknownFields = false, prefix = "services")
public class ExternalServicesMappingProperties {

    private ThreadPoolTaskExecutorConfig threadPoolTaskExecutorConfig;

    private ExternalServiceUri eventRegistrationServiceUri;
    private ExternalServiceUri eventPublicationServiceUri;

    public ExternalServiceUri getEventRegistrationServiceUri() {
        return eventRegistrationServiceUri;
    }

    public ExternalServiceUri getEventPublicationServiceUri() {
        return eventPublicationServiceUri;
    }

    public ThreadPoolTaskExecutorConfig getThreadPoolTaskExecutorConfig() {
        return threadPoolTaskExecutorConfig;
    }

    public void setEventRegistrationServiceUri(ExternalServiceUri eventRegistrationServiceUri) {
        this.eventRegistrationServiceUri = eventRegistrationServiceUri;
    }

    public void setEventPublicationServiceUri(ExternalServiceUri eventPublicationServiceUri) {
        this.eventPublicationServiceUri = eventPublicationServiceUri;
    }

    public void setThreadPoolTaskExecutorConfig(ThreadPoolTaskExecutorConfig threadPoolTaskExecutorConfig) {
        this.threadPoolTaskExecutorConfig = threadPoolTaskExecutorConfig;
    }
}
