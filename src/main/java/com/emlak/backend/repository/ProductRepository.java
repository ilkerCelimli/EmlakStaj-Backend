package com.emlak.backend.repository;

import com.emlak.backend.entity.ProductEntity;
import com.emlak.backend.repository.projections.ProductInfo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends BaseRepository<ProductEntity> {

    @Query("select p from ProductEntity p inner join ProductImages images on p.id = images.id inner join District d on d.id = p.id")
    List<ProductInfo> findProductViews();

    @Query("select p from ProductEntity p inner join ProductImages images  on p.id = images.id inner join District d on d.id = p.id where p.id = ?1")
    Optional<ProductInfo> findProductView(String id);
}
