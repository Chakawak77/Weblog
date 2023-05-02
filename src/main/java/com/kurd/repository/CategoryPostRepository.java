package com.kurd.repository;
import com.kurd.entity.CategoryPost;
import com.kurd.entity.Comment;
import com.kurd.entity.Post;
import com.kurd.entity.UserApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryPostRepository extends PagingAndSortingRepository<CategoryPost,Long> {

//    Page<CategoryPost> findAll(Pageable pageable);
    List<CategoryPost> findAllByPost(Post post);
}
