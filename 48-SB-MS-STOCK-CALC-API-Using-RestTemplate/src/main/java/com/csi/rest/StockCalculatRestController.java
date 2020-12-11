package com.csi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StockCalculatRestController {

	@GetMapping("/calculate/{name}/{qty}")
	public ResponseEntity<String> calculate(@PathVariable("name") String companyName,
			@PathVariable("qty") Integer qty) {

		String endPointUrl = "http://localhost:1111/getCost/{companyName}";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<Double> forEntity = rt.getForEntity(endPointUrl, Double.class, companyName);

		if (forEntity.getStatusCodeValue() == 200) {
			Double body = forEntity.getBody();
			String response = "Total Cost : " + body * qty;
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		return null;
	}
}
