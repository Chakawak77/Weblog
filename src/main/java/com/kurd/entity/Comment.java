package com.kurd.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserApp user;
}
