package com.zohocrm.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix="swagger.data")
public class SwaggerProperties {
    private String title;
    private String description;
    private String version;
    private String group;
    private String packagesToScan;

}
