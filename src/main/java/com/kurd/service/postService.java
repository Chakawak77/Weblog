package com.kurd.service;
import com.kurd.common.exeption.NotFoundException;
import com.kurd.entity.Post;
import com.kurd.entity.UserApp;
import com.kurd.repository.PostRepository;
import com.kurd.service_implement.PostServiceImplement;
import com.kurd.service_implement.UserServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class postService implements PostServiceImplement {

    private final PostRepository postRepository;
    private final UserServiceImplement userServiceImplement;

    @Override
    public Post save(Post post) {
        Long userId=post.getUser().getUserId();
        var userSave=userServiceImplement.getById(userId);
        post.setUser(userSave);
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        Post updatePost=getById(post.getPostId());
//        updatePost.setTitle(post.getTitle());
        updatePost.setDescription(post.getDescription());
        updatePost.setImage(post.getImage());
        updatePost.setDate(post.getDate());
        updatePost.setLike(post.getLike());
        return postRepository.save(updatePost);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);

    }

    @Override
    public Post getById(Long id) {
        Optional<Post> optionalPost=postRepository.findById(id);
        if(optionalPost.isEmpty()){
            throw new NotFoundException("Not Found");
        }
        return optionalPost.get();
    }

    @Override
    public List<Post> getAll() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public List<Post> getAllByUserApp(Long userId) {
        UserApp getUser=userServiceImplement.getById(userId);
        List<Post> postList=postRepository.findAllByUser(getUser);
        return postList;
    }

    @Override
    public Page<Post> paging(Integer page, Integer size) {
        return postRepository.findAll(PageRequest.of(page,size, Sort.by("id")));
    }
}
