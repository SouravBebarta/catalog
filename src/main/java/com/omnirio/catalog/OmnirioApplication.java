package com.omnirio.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StringUtils;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {
        "com.omnirio.catalog"
})

@ComponentScans({
        @ComponentScan("com.omnirio.catalog")
})

public class OmnirioApplication {

    public static void main(String[] args) {
        if (StringUtils.isEmpty(System.getenv(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME))
                && System.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME) == null) {
            System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
        }
        SpringApplication.run(OmnirioApplication.class, args);
    }
}
