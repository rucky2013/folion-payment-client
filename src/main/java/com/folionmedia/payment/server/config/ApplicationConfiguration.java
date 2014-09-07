package com.folionmedia.payment.server.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.folionmedia.payment.server.web")
@Import(PropertyPlaceholderAutoConfiguration.class)
public class ApplicationConfiguration {

}
