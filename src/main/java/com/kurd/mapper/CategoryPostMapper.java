package com.kurd.mapper;
import com.kurd.dto.CategoryPostDto;
import com.kurd.entity.CategoryPost;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring",uses = {PostMapper.class,CategoryMapper.class})
public interface CategoryPostMapper {


     CategoryPost categoryPostDtoToCategoryPost(CategoryPostDto categoryPostDto);
     CategoryPostDto categoryPostToCategoryPostDto(CategoryPost categoryPost);

     List<CategoryPost> convertCategoryPostDtoToCategoryPost(List<CategoryPostDto> categoryPostDtos);
     List<CategoryPostDto> convertCategoryPostToCategoryPostDto(List<CategoryPost> categoryPostList);


}
