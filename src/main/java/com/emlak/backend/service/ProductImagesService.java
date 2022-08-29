package com.emlak.backend.service;

import com.emlak.backend.entity.ProductEntity;
import com.emlak.backend.entity.ProductImages;
import com.emlak.backend.input.ProductInput;
import com.emlak.backend.repository.BaseRepository;
import com.emlak.backend.repository.ProductImagesRepository;
import com.emlak.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductImagesService extends BaseService<ProductImages> {

    private ProductImagesRepository productRepository;

    public ProductImagesService(ProductImagesRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }


}
