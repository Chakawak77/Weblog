package com.kurd.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "tbl_user")
@Data

public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> postList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private Profile profile;

}
