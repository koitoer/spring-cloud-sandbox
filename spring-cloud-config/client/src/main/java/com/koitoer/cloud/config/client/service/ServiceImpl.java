package com.koitoer.cloud.config.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by mauricio.mena on 08/06/2016.
 */
@Component
public class ServiceImpl implements Service {

    @Override
    @HystrixCommand(fallbackMethod = "fallback2")
    public Object getWordHystrix(Map<String, Object> param)  {
        throw new RuntimeException("Impossible");
    }


    @Override
    public Object getDefaultWords(Map<String, Object> param, Throwable e) {
        System.out.println(e.getMessage());
        return param.get("client-id");
    }

    @Override
    public Object fallback2(Map<String, Object> param) {
        return param.get("client-id");
    }
}
