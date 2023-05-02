package com.kurd.dto;
import com.kurd.entity.UserApp;
import lombok.Data;

import javax.persistence.Column;


@Data
public class PostDTO {


    private Long postId;

    private Long like;

    private String title;

    private String image;

    private String description;

    private Long date;

    private UserAppDTO user;


}
