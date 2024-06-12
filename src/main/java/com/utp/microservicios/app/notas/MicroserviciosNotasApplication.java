package com.utp.microservicios.app.notas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.**.security,com.**.controller", "com.**.services" ,"com.**.services.impl", "com.**.repository"})
@EnableJpaRepositories(basePackages={"com.**.security,com.**.controller", "com.**.services" ,"com.**.services.impl", "com.**.repository"})
@EnableTransactionManagement
public class MicroserviciosNotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosNotasApplication.class, args);
	}

}
