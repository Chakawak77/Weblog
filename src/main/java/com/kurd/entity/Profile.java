package com.kurd.entity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "image")
    private String image;

    @Column(name = "bio")
    private String bio;

    @Column(name = "cv")
    private String cv;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private UserApp user;

}
