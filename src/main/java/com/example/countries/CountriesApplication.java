package com.example.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@RestController
public class CountriesApplication {
	static RestClient restClient = new RestClient();
	static CountryService countryService = new CountryService();

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
		return restClient.capital(code);
	}


/* 	@RequestMapping(value = "/country_codes_rx")
    public Single<ResponseEntity<String>> codes_rx() {
		return countryService.codes()
				.subscribeOn(Schedulers.io())
				.toSingle(response -> ResponseEntity.ok(response));
				
	}
	
	@RequestMapping(value = "/capital_rx/{code}")
    public Single<ResponseEntity<String>> getCapital_rx(@PathVariable("code") String code) {
		return countryService.capital(code)
				.subscribeOn(Schedulers.io())
				.toSingle(response -> ResponseEntity.ok(response));
    }
 */
}
