package com.emlak.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ProductEntity extends BaseEntity {

    @Column
    private String sellerName;
    @Column
    private String sellerPhoneNumber;
    @Column
    private float productSize;
    @Column
    int flows;
    @Column
    private String rooms;
    @Column
    private String description;
    @Column
    private float price;
    @Column
    private String title;
    @Column
    private String adress;
    /***
     * @param int 0 -> satılık
     *            1 -> kiralık
     */

    @Column
    private int type;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<ProductImages> productImages = new HashSet<>();

    @OneToOne
    private District district;



}
