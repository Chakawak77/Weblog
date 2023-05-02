package com.kurd.dto;
import com.kurd.entity.UserApp;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
public class CommentDto {

    private Long commentId;

    private String image;

    private String description;

    private Long date;

    private UserAppDTO user;

}
