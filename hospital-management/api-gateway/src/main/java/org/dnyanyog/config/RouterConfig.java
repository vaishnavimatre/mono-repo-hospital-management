package org.dnyanyog.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Appointment Service Routes
                .route("appointment_add_route", r -> r.path("/api/v1/appointment/add/**").uri("http://appointment-service:8080"))
                .route("appointment_patient_route", r -> r.path("/api/v1/appointment/{patient_id}/**").uri("http://appointment-service:8080"))
                .route("appointment_patient_root_route", r -> r.path("/api/v1/appointment/{patient_id}/**").uri("http://appointment-service:8080"))
                
                // Patient Service Routes
                .route("patient_add_route", r -> r.path("/api/v1/patient/add/**").uri("http://patient-service:8080"))
                .route("patient_id_route", r -> r.path("/api/v1/patient/{patient_id}/**").uri("http://patient-service:8080"))
                .route("patient_id_root_route", r -> r.path("/api/v1/patient/{patient_id}/**").uri("http://patient-service:8080"))
                
                // Case Service Routes
                .route("case_add_route", r -> r.path("/api/v1/case/add/**").uri("http://case-service:8080"))
                .route("case_patient_route", r -> r.path("/api/v1/case/{patient_id}/**").uri("http://case-service:8080"))
                .route("case_patient_root_route", r -> r.path("/api/v1/case/{patient_id}/**").uri("http://case-service:8080"))
                
                // Directory Service Routes
                .route("directory_add_route", r -> r.path("/api/v1/directory/add/**").uri("http://directory-service:8080"))
                .route("directory_user_route", r -> r.path("/api/v1/directory/{userid}/**").uri("http://directory-service:8080"))
                .route("directory_user_root_route", r -> r.path("/api/v1/directory/{userid}/**").uri("http://directory-service:8080"))
                .build();
    }
}
