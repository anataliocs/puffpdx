package com.puffpdx.api.config.mapping;

/**
 * Created by chris.anatalio on 12/10/16.
 */
public class ThreadPoolTaskExecutorConfig {

    private Boolean AllowCoreThreadTimeOut;
    private Integer CorePoolSize;
    private Integer KeepAliveSeconds;
    private Integer MaxPoolSize;
    private Integer QueueCapacity;

    public Boolean getAllowCoreThreadTimeOut() {
        return AllowCoreThreadTimeOut;
    }

    public void setAllowCoreThreadTimeOut(Boolean allowCoreThreadTimeOut) {
        AllowCoreThreadTimeOut = allowCoreThreadTimeOut;
    }

    public Integer getCorePoolSize() {
        return CorePoolSize;
    }

    public void setCorePoolSize(Integer corePoolSize) {
        CorePoolSize = corePoolSize;
    }

    public Integer getKeepAliveSeconds() {
        return KeepAliveSeconds;
    }

    public void setKeepAliveSeconds(Integer keepAliveSeconds) {
        KeepAliveSeconds = keepAliveSeconds;
    }

    public Integer getMaxPoolSize() {
        return MaxPoolSize;
    }

    public void setMaxPoolSize(Integer maxPoolSize) {
        MaxPoolSize = maxPoolSize;
    }

    public Integer getQueueCapacity() {
        return QueueCapacity;
    }

    public void setQueueCapacity(Integer queueCapacity) {
        QueueCapacity = queueCapacity;
    }
}
