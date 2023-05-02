package com.kurd.controller;

import com.kurd.dto.CategoryPostDto;
import com.kurd.entity.CategoryPost;
import com.kurd.mapper.CategoryPostMapper;
import com.kurd.service.CategoryPostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/category-post-controller/")
public class CategoryPostController {

    private final CategoryPostService service;
    private final CategoryPostMapper mapper;

    @PostMapping("save/version1")
    public ResponseEntity save(@RequestBody CategoryPostDto categoryPostDto) {
      CategoryPost saveCategoryPost= mapper.categoryPostDtoToCategoryPost(categoryPostDto);
      service.save(saveCategoryPost);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("get/version1/{id}")
    public ResponseEntity<CategoryPostDto> getById(@PathVariable Long id) {
        CategoryPost categoryPost = service.getById(id);
        CategoryPostDto categoryPostDto= mapper.categoryPostToCategoryPostDto(categoryPost);
        return ResponseEntity.ok(categoryPostDto);
    }
    @GetMapping("version1/")
    public ResponseEntity<List<CategoryPostDto>> getAll() {
        List<CategoryPost> categoryPostList = service.getAll();
        List<CategoryPostDto> categoryPostDtoList = mapper.convertCategoryPostToCategoryPostDto(categoryPostList);
        return ResponseEntity.ok(categoryPostDtoList);
    }

    @GetMapping("get/version1/{postId}")
    public ResponseEntity<List<CategoryPostDto>> getByPostId(@PathVariable Long postId) {
         List<CategoryPost> categoryPostList = service.getByPost(postId);
         List<CategoryPostDto> categoryPostDtoList= mapper.convertCategoryPostToCategoryPostDto(categoryPostList);
        return ResponseEntity.ok(categoryPostDtoList);
    }
    @DeleteMapping("version1/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
