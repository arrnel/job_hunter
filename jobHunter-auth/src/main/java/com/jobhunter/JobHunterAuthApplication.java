package com.jobhunter;

import com.jobhunter.service.PropertiesLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobHunterAuthApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(JobHunterAuthApplication.class);
        springApplication.addListeners(new PropertiesLogger());
        springApplication.run(args);
    }

}
