package org.dnyanyog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "org.dnyanyog")
public class HospitalManagementMain {
    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementMain.class, args);
    }
}
