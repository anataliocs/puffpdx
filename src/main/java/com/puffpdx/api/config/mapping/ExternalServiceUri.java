package com.puffpdx.api.config.mapping;

/**
 * Created by chris.anatalio on 12/10/16.
 */
public class ExternalServiceUri {

    private String scheme;
    private String host;
    private String port;
    private String basePath;
    private String templateValues;

    public String getScheme() {
        return scheme;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getBasePath() {
        return basePath;
    }

    public String getTemplateValues() {
        return templateValues;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public void setTemplateValues(String templateValues) {
        this.templateValues = templateValues;
    }
}
