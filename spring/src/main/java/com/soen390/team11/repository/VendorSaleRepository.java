package com.soen390.team11.repository;

import com.soen390.team11.entity.VendorSale;
import com.soen390.team11.entity.VendorSaleId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VendorSaleRepository extends CrudRepository<VendorSale, VendorSaleId> {
    Optional<VendorSale> findByVendorSaleIdSaleID(String rid);
}