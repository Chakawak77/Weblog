package com.kurd.entity;
import lombok.Data;
import lombok.NonNull;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name= "title",insertable = false,updatable = false)
    private Long like;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserApp user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CategoryPost> categoryPostList;

}
