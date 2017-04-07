package com.bjy.lotus.common.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * Spring Application Context Configuration
 * @author biejunyang
 *
 */
@Configuration
@ComponentScan(basePackages="com.bjy.lotus", excludeFilters=@ComponentScan.Filter(Controller.class))
public class AppConfiguration {

}
