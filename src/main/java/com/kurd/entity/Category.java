package com.kurd.entity;
import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CategoryPost> categoryPostList;

}
