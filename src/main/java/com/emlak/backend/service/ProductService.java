package com.emlak.backend.service;

import com.emlak.backend.entity.District;
import com.emlak.backend.entity.ProductEntity;
import com.emlak.backend.entity.ProductImages;
import com.emlak.backend.input.ProductInput;
import com.emlak.backend.repository.DistrcitRepository;
import com.emlak.backend.repository.ProductRepository;
import com.emlak.backend.repository.projections.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class ProductService extends BaseService<ProductEntity> {

    private final ProductRepository productRepository;
    private final ProductImagesService productImagesService;

    private final DistrcitRepository distrcitRepository;
    public ProductService(ProductRepository productRepository, ProductImagesService productImagesService, DistrcitRepository distrcitRepository) {
        super(productRepository);
        this.productRepository = productRepository;
        this.productImagesService = productImagesService;
        this.distrcitRepository = distrcitRepository;
    }


    public ProductEntity handleInput(ProductInput input) {
        Set<ProductImages> productImagesSet = new HashSet<>();
        for(String i : input.getImageList()) {
            ProductImages images = new ProductImages();
            images.setBase64String(i);
            productImagesSet.add(images);
        }
        Optional<District> district = this.distrcitRepository.findById(input.getDisctrictId());

        return district.isPresent() ?  ProductEntity.builder()
                .productImages(productImagesSet)
                .adress(input.getAdress())
                .description(input.getDescription())
                .productSize(input.getProductSize())
                .flows(input.getFlows())
                .price(input.getPrice())
                .rooms(input.getRooms())
                .sellerName(input.getSellerName())
                .sellerPhoneNumber(input.getSellerPhone())
                .title(input.getTitle())
                .district(district.get())
                .build():null;
    }

    public List<ProductInfo> productsViewList() {
        return this.productRepository.findProductViews();
    }

    public ProductInfo productView(String id) {
        Optional<ProductInfo> p = this.productRepository.findProductView(id);
       return p.isPresent()? p.get() : null;
    }


}
