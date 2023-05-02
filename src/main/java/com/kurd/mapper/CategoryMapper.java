package com.kurd.mapper;
import com.kurd.dto.CategoryDto;
import com.kurd.entity.Category;
import com.kurd.entity.UserApp;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryDtoToCategory(CategoryDto categoryDto);
    CategoryDto categoryToCategoryDto(Category category);

    List<Category> categoryDtoListToListCategory(List<CategoryDto> categoryDtoList);
    List<CategoryDto> categoryListToCategoryListDto(List<Category> categoryList);
}
