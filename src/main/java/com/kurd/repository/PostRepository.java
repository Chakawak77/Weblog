package com.kurd.repository;
import com.kurd.entity.Post;
import com.kurd.entity.UserApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post,Long> {

    Page<Post> findAll(Pageable pageable);
    //List<Post> findAllByUser_UserId(Long userId);
    List<Post> findAllByUser(UserApp userApp);
}
