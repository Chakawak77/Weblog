package com.kurd.service_implement;
import com.kurd.entity.Comment;
import com.kurd.entity.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentServiceImplement {

    Comment save(Comment comment);
    Comment update(Comment comment);
    void delete(Long id);
    Comment getById(Long id);
    List<Comment> getAll();
    List<Comment> getAllByUserApp(Long userId);

    Page<Comment> paging(Integer page,Integer size);

}
