package com.bandb.cas.boot;

/**
 * @author buddika on 4/7/19
 * @project bandb-cas
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaAuditing
@ComponentScan({"com.bandb.cas.controller"})
@EntityScan("com.bandb.cas.model")
@EnableJpaRepositories("com.bandb.cas.repository")
public class CASServerStarter extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CASServerStarter.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(CASServerStarter.class, args);

    }
}

