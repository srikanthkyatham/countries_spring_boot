package com.example.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CountriesApplication {
	static RestClient restClient = new RestClient();

	public static void main(String[] args) {
		restClient.get();
		SpringApplication.run(CountriesApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping(value = "/country_codes")
	public String codes() {
		return restClient.getCodes();
	}

 	@RequestMapping(path = "/capital/{code}")
	public String getMessage(@PathVariable("code") String code) {
		String msg = String.format("code is %s", code);
		return restClient.capital(code);
	}

}
