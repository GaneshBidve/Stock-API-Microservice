package com.csi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.csi.client.StockPriceClient;

@RestController
public class StockCalculatRestController {

	@Autowired
	private StockPriceClient priceClient;

	@GetMapping("/calculate/{name}/{qty}")
	public ResponseEntity<String> calculate(@PathVariable("name") String companyName,
			@PathVariable("qty") Integer qty) {

		ResponseEntity<Double> stockPrice = priceClient.getStockPrice(companyName);

		if (stockPrice.getStatusCodeValue() == 200) {
			Double body = stockPrice.getBody();
			String response = "Total Cost : " + body * qty;
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		return null;
	}
}
