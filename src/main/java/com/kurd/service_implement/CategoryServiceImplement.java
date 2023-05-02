package com.kurd.service_implement;
import com.kurd.entity.Category;
import org.springframework.data.domain.Page;
import java.util.List;

public interface CategoryServiceImplement {

    Category save(Category category);
    Category update(Category category);
    void delete(Long id);
    Category getById(Long id);
    List<Category> getAll();

    Page<Category> paging(Integer page,Integer size);

}
