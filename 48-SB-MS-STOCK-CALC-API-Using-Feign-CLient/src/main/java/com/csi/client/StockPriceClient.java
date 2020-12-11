package com.csi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STOCK-PRICE-API")
public interface StockPriceClient {

	@GetMapping("/getCost/{companyName}")
	public ResponseEntity<Double> getStockPrice(@PathVariable("companyName") String companyName);
}
