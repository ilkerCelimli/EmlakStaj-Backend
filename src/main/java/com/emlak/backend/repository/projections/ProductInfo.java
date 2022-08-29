package com.emlak.backend.repository.projections;

import java.util.Set;

public interface ProductInfo {
    String getId();

    String getSellerName();

    String getSellerPhoneNumber();

    float getProductSize();

    int getFlows();

    String getRooms();

    String getDescription();

    float getPrice();

    String getTitle();

    String getAdress();

    Set<ProductImagesInfo> getProductImages();

    DistrictInfo getDistrict();
}
