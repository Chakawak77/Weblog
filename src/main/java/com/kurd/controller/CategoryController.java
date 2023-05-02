package com.kurd.controller;

import com.kurd.common.Paging;
import com.kurd.dto.CategoryDto;
import com.kurd.dto.UserAppDTO;
import com.kurd.entity.Category;
import com.kurd.entity.UserApp;
import com.kurd.mapper.CategoryMapper;
import com.kurd.service_implement.CategoryServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/category-controller/")
public class CategoryController {

    private final CategoryServiceImplement categoryService;
    private final CategoryMapper categoryMapper;

    @PostMapping("save/version1")
    public ResponseEntity save(@RequestBody CategoryDto categoryDto) {
      Category saveCategory= categoryMapper.categoryDtoToCategory(categoryDto);
      categoryService.save(saveCategory);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("update/version1")
    public ResponseEntity update(@RequestBody CategoryDto categoryDto) {
        Category updateCategory= categoryMapper.categoryDtoToCategory(categoryDto);
        categoryService.update(updateCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("get/version1/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable Long id) {
        Category category = categoryService.getById(id);
        CategoryDto categoryDto= categoryMapper.categoryToCategoryDto(category);
        return ResponseEntity.ok(categoryDto);
    }
    @GetMapping("/version1/{page}/{size}")
    public ResponseEntity<Paging<CategoryDto>> categoryPageing(@PathVariable Integer page, Integer size) {
        Page<Category> categoryPage= categoryService.paging(page,size);
        int allPage=categoryPage.getTotalPages() ;
        List<Category> date=categoryPage.getContent();

        List<CategoryDto> categoryDTOS= categoryMapper.categoryListToCategoryListDto(date);

        Paging<CategoryDto> categoryDTOPaging=new Paging<>(allPage,page,categoryDTOS);
        return ResponseEntity.ok(categoryDTOPaging);
    }
    @GetMapping("version1/")
    public ResponseEntity<List<CategoryDto>> getAll() {
        List<Category> categoryList = categoryService.getAll();
        List<CategoryDto> categoryDtoList = categoryMapper.categoryListToCategoryListDto(categoryList);
        return ResponseEntity.ok(categoryDtoList);
    }

    @DeleteMapping("version1/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
