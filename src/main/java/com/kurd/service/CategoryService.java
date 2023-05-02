package com.kurd.service;

import com.kurd.common.exeption.NotFoundException;
import com.kurd.entity.Category;
import com.kurd.repository.CategoryRepository;
import com.kurd.service_implement.CategoryServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService implements CategoryServiceImplement {

    private final CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category updateCategory=getById(category.getId());
        updateCategory.setImage(category.getImage());
        updateCategory.setTitle(category.getTitle());
        return categoryRepository.save(updateCategory);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);

    }

    @Override
    public Category getById(Long id) {
        Optional<Category> optionalCategory=categoryRepository.findById(id);
        if (optionalCategory.isEmpty())
            throw  new NotFoundException("Error!");
        return optionalCategory.get();
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Page<Category> paging(Integer page, Integer size) {
        return categoryRepository.findAll(PageRequest.of(page,size, Sort.by("id")));
    }
}
