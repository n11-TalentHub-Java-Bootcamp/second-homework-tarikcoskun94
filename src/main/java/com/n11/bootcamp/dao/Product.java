package com.n11.bootcamp.dao;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Entity
@Table(name = "products")
public class Product {

    @SequenceGenerator(name = "generator", sequenceName = "product_id_seq")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 50, name = "name")
    private String name;

    @Column(name = "price", precision = 19, scale = 2)
    private BigDecimal price;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category",
            foreignKey = @ForeignKey(name = "fk_product_category_id")
    )
    private Category category;
}
