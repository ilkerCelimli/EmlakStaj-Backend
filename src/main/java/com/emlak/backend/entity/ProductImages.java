package com.emlak.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ProductImages extends BaseEntity {

    @Column
    private String base64String;
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductEntity product;

}
