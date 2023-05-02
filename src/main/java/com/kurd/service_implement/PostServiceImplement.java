package com.kurd.service_implement;
import com.kurd.entity.Post;
import com.kurd.entity.UserApp;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostServiceImplement {

    Post save(Post post);
    Post update(Post post);
    void delete(Long id);
    Post getById(Long id);
    List<Post> getAll();
    List<Post> getAllByUserApp(Long userId);

    Page<Post> paging(Integer page,Integer size);

}
