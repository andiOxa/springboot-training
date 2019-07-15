package com.ucx.training.shop.repository;

import com.ucx.training.shop.entity.Invoice;
import com.ucx.training.shop.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineItemRepository extends BaseRepository<LineItem,Integer> {

    List<LineItem> findAllByInvoice(Invoice invoice);
}
