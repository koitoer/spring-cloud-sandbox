package com.koitoer.cloud.config.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.Map;

/**
 * Created by mauricio.mena on 08/06/2016.
 */
public interface Service {

    Object getWordHystrix(Map<String, Object> param) throws Exception;

    Object getDefaultWords(Map<String, Object> param, Throwable e);

    Object fallback2(Map<String, Object> param);
}
