package com.n11.bootcamp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "product_comments")
public class ProductComment {

    @SequenceGenerator(name = "generator", sequenceName = "product_comment_id_seq", allocationSize = 1)
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 500, name = "text", nullable = false)
    private String text;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product",
            foreignKey = @ForeignKey(name = "fk_comment_product_id")
    )
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user",
            foreignKey = @ForeignKey(name = "fk_comment_user_id")
    )
    private User user;
}
