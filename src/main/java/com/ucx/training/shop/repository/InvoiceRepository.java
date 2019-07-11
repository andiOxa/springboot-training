package com.ucx.training.shop.repository;

import com.ucx.training.shop.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends BaseRepository<Invoice,Integer> {
}
