package com.kurd.dto;
import lombok.Data;

@Data
public class CategoryPostDto {

    private Long categoryPostId;


    private PostDTO post;

    private CategoryDto category;
}
