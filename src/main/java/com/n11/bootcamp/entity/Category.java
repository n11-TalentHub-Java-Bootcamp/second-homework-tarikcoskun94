package com.n11.bootcamp.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "categories")
public class Category {

    @SequenceGenerator(name = "generator", sequenceName = "category_id_seq")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "breakdown")
    private Long breakdown;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_super_category",
            foreignKey = @ForeignKey(name = "fk_category_category_id")
    )
    private Category superCategory;
}
