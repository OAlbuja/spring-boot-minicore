package com.tempoquito.springboot.backend.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;

@SpringBootApplication
public class SpringBootBackendApirestApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootBackendApirestApplication.class);
        
        // Use PORT provided in environment or default to 8080
        String port = System.getenv("PORT");
        if (port != null) {
            app.setDefaultProperties(Collections.singletonMap("server.port", port));
        }
        
        app.run(args);
    }
}
