package com.personal.project.theatre.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan("com.personal.project.theatre")
@PropertySources({
		@PropertySource(value = "file:./theatre.properties", ignoreResourceNotFound = true)
})
public class SpringConfig {


}
