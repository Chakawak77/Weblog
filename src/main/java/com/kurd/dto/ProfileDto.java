package com.kurd.dto;
import lombok.Data;

import javax.persistence.*;

@Data
public class ProfileDto {

    private Long profileId;

    private String firstName;

    private String lastName;

    private String email;

    private String image;

    private String bio;

    private String cv;


}
