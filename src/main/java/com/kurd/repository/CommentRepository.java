package com.kurd.repository;
import com.kurd.entity.Comment;
import com.kurd.entity.Post;
import com.kurd.entity.UserApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment,Long> {

    Page<Comment> findAll(Pageable pageable);
    List<Comment> findAllByUser(UserApp userId);
}
