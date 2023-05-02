package com.kurd.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_category_post",uniqueConstraints = {@UniqueConstraint(columnNames = {"post_id","category_id"})})
public class CategoryPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryPostId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
