package com.koitoer.cloud.config.client.beans;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mauricio.mena on 07/06/2016.
 */
@Configuration
//This will only affect one of the ribbon cients.
//@RibbonClient(name = "koitoerclient", configuration = SubjectConfig.class)
public class MainConfig {
}
