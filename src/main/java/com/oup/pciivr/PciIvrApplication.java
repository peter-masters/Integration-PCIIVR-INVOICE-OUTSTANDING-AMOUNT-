package com.oup.pciivr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:META-INF/spring/camel-sap-rfc-route.xml" })
public class PciIvrApplication {

	public static void main(String[] args) {

		SpringApplication.run(PciIvrApplication.class, args);

	}
}
