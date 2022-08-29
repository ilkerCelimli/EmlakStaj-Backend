package com.emlak.backend.api;

import com.emlak.backend.input.ProductInput;
import com.emlak.backend.repository.projections.ProductInfo;
import com.emlak.backend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/product")
public class ProductApi {

    private final ProductService productService;

    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductInfo>> findAllProducts() {
        return ResponseEntity.ok(this.productService.productsViewList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductInfo> findProduct(@PathVariable String id) {
        ProductInfo productInfo = this.productService.productView(id);
        if (Objects.nonNull(productInfo)) {
            return ResponseEntity.ok(productInfo);
        } else return ResponseEntity.noContent().build();
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Void> createProduct(@RequestBody ProductInput productInput) {
        boolean result = this.productService.save(this.productService.handleInput(productInput));
        return result ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id) {
        this.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}


