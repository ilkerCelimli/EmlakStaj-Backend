package com.emlak.backend.input;

import com.emlak.backend.entity.District;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInput {


    private String sellerName;
    private String sellerPhone;
    private String title;
    private String description;
    private float productSize;
    private int flows;
    private float price;
    private String rooms;
    private String adress;
    private District district;
    private List<String> imageList;
    private Integer disctrictId;



}
