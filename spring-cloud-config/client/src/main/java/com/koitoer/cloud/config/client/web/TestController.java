package com.koitoer.cloud.config.client.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by koitoer on 3/19/16.
 */
@RestController
public class TestController {

    @Value("${datasourceName}")
    private String databaseName;

    @RequestMapping(value = "/database", method = RequestMethod.GET)
    public String getDatabaseName() {
        return "The database Config name is " + databaseName;
    }


}
