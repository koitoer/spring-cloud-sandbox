package com.koitoer.cloud.config.client.web;

import com.koitoer.cloud.config.client.Application;
import com.koitoer.cloud.config.client.feign.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Created by koitoer on 3/19/16.
 */
@RestController
public class TestController {

    @Value("${datasourceName}")
    private String databaseName;

    @Value("${words}")
    private String words;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    LoadBalancerClient loadBalancer;

    @Autowired
    private ServiceBase serviceBase;

    @RequestMapping(value = "/database", method = RequestMethod.GET)
    public String getDatabaseName() {
        return "The database Config name is " + databaseName;
    }

    @RequestMapping("/")
    public @ResponseBody
    String getWord() {
        String[] wordArray = words.split(",");
        int i = (int)Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }

    @RequestMapping(value = "/sentence", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getSentence() {
        return getWord3("KOITOERCLIENT") +".";
    }

    public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
            URI uri = list.get(0).getUri();
            if (uri !=null ) {
                return (new RestTemplate()).getForObject(uri,String.class);
            }
        }
        return null;
    }

    public String getWord3(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
            URI uri = list.get(0).getUri();
            if (uri !=null ) {

                return serviceBase.getSentence();
            }
        }
        return null;
    }

    public String getWordRibbon(String service) {
        ServiceInstance instance = loadBalancer.choose(service);
        return (new RestTemplate()).getForObject(instance.getUri(),String.class);
    }


}
