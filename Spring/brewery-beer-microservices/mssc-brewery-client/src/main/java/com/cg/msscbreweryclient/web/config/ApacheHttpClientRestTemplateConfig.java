package com.cg.msscbreweryclient.web.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Configuring Apache HttpClient for Spring RestTemplate instead of the default jvm implementation
@Component
public class ApacheHttpClientRestTemplateConfig implements RestTemplateCustomizer {

    private final Integer maxTotalConnections;
    private final Integer maxDefaultMaxPerRoute;
    private final Integer connectionRequestTimeoutTime;
    private final Integer socketTimeoutTime;

    public ApacheHttpClientRestTemplateConfig(@Value("${sfg.setmaxtotalconnection}") Integer maxTotalConnections,
                                              @Value("${sfg.setdefaultmaxperroute}") Integer maxDefaultMaxPerRoute,
                                              @Value("${sfg.setconnectionrequesttimeout}") Integer connectionRequestTimeoutTime,
                                              @Value("${sfg.setsockettimeout}") Integer socketTimeoutTime) {
        this.maxTotalConnections = maxTotalConnections;
        this.maxDefaultMaxPerRoute = maxDefaultMaxPerRoute;
        this.connectionRequestTimeoutTime = connectionRequestTimeoutTime;
        this.socketTimeoutTime = socketTimeoutTime;
    }

    public ClientHttpRequestFactory clientHttpRequestFactory() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotalConnections);
        connectionManager.setDefaultMaxPerRoute(maxDefaultMaxPerRoute);

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectionRequestTimeout(connectionRequestTimeoutTime)
                .setSocketTimeout(socketTimeoutTime)
                .build();

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }
}
