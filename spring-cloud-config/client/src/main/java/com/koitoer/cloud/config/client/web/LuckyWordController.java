package com.koitoer.cloud.config.client.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mauricio.mena on 08/06/2016.
 */
@RestController
@ConfigurationProperties(prefix = "wordConfig")
public class LuckyWordController {

    String luckyWord;
    String preamble;

    @RequestMapping(value = "/luckyworld", method = RequestMethod.GET)
    public String getLucky(){
        return "luc:"+luckyWord;
    }

    public String getLuckyWord() {
        return luckyWord;
    }

    public void setLuckyWord(String luckyWord) {
        this.luckyWord = luckyWord;
    }

    public String getPreamble() {
        return preamble;
    }

    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }
}
