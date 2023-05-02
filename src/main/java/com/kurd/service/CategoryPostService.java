package com.kurd.service;
import com.kurd.common.exeption.NotFoundException;
import com.kurd.entity.Category;
import com.kurd.entity.CategoryPost;
import com.kurd.entity.Post;
import com.kurd.repository.CategoryPostRepository;
import com.kurd.service_implement.CategoryPostServiceImplement;
import com.kurd.service_implement.CategoryServiceImplement;
import com.kurd.service_implement.PostServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryPostService implements CategoryPostServiceImplement {

    private final CategoryPostRepository repository;

    private final CategoryServiceImplement categoryServiceImplement;
    private final PostServiceImplement postServiceImplement;

    @Override
    public CategoryPost save(CategoryPost categoryPost) {
        Long postId=categoryPost.getPost().getPostId();
        Long categoryId=categoryPost.getCategory().getId();

        Post savePost=postServiceImplement.getById(postId);
        Category saveCategory=categoryServiceImplement.getById(categoryId);

        categoryPost.setCategory(saveCategory);
        categoryPost.setPost(savePost);
        return repository.save(categoryPost);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CategoryPost getById(Long id) {
        Optional<CategoryPost> optionalCategoryPost=repository.findById(id);
        if (optionalCategoryPost.isEmpty())
            throw new NotFoundException("Error");

        return optionalCategoryPost.get();

    }

    @Override
    public List<CategoryPost> getAll() {
        return (List<CategoryPost>) repository.findAll();
    }

    @Override
    public List<CategoryPost> getByPost(Long id) {
        Post post=postServiceImplement.getById(id);
        List<CategoryPost> categoryPostList=repository.findAllByPost(post);
        return categoryPostList;
    }


//  public Page<CategoryPost> paging(Integer page, Integer size) {
//        return null;
//    }
}
