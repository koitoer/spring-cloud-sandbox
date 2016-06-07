package com.koitoer.cloud.config.client.beans;

import com.netflix.client.IClient;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mauricio.mena on 07/06/2016.
 */
//@Configuration
public class SubjectConfig {

    @Bean
    public IPing ribbonPing(IClientConfig iClientConfig){
        return  new PingUrl();
    }
}
