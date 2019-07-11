package com.ucx.training.shop.repository;

import com.ucx.training.shop.entity.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface BaseRepository<T extends BaseModel<U>,U> extends JpaRepository<T,U> {

}
//@Repository
//public interface BaseRepository<T extends BaseModel<U>,U> extends ReactiveCrudRepository<T,U>{
//
//}
