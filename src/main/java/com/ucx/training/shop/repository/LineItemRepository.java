package com.ucx.training.shop.repository;

import com.ucx.training.shop.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem,Integer> {
}
