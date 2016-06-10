package com.koitoer.cloud.config.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mauricio.mena on 09/06/2016.
 */
@Controller
public class SentenceController {

    @RequestMapping("/mydemo")
    public ModelAndView sentence() {
        return new ModelAndView("sentencess");
    }
}