package com.csi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csi.entity.StockPriceEntity;

public interface StockPriceRepository extends JpaRepository<StockPriceEntity, Serializable> {

	public StockPriceEntity findByCompanyName(String companyName);
}
