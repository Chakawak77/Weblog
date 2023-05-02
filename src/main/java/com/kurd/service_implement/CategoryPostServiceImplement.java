package com.kurd.service_implement;
import com.kurd.entity.CategoryPost;
import java.util.List;

public interface CategoryPostServiceImplement {

    CategoryPost save(CategoryPost categoryPost);
    void delete(Long id);
    CategoryPost getById(Long id);
    List<CategoryPost> getAll();
    List<CategoryPost> getByPost(Long id);
//    List<CategoryPost> getCategory(Long id);

//    Page<CategoryPost> paging(Integer page,Integer size);

}
