package com.koitoer.cloud.config.client.feign;

import com.koitoer.cloud.config.client.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mauricio.mena on 07/06/2016.
 */
@FeignClient("KOITOERCLIENT")
public interface ServiceBase {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public @ResponseBody Word getWord();
}
