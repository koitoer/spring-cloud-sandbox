package com.koitoer.cloud.config.client.feign;

import com.koitoer.cloud.config.client.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mauricio.mena on 07/06/2016.
 * Created by mauricio.mena on 07/06/2016.
 */
@FeignClient("KOITOERCLIENT")
public interface ServiceBase {

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody String getSentence();
}
