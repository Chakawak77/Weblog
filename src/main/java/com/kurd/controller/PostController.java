package com.kurd.controller;
import com.kurd.common.Paging;
import com.kurd.dto.CommentDto;
import com.kurd.dto.PostDTO;
import com.kurd.dto.UserAppDTO;
import com.kurd.entity.Comment;
import com.kurd.entity.Post;
import com.kurd.entity.UserApp;
import com.kurd.mapper.PostMapper;
import com.kurd.service_implement.PostServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/post-controller/")
public class PostController {

    private final PostServiceImplement postServiceImplement;
    private final PostMapper postMapper;

    @PostMapping(value = "save/version1")
    public ResponseEntity save(@RequestBody PostDTO postDTO){
        Post savePost=postMapper.postDtoToPost(postDTO);
        postServiceImplement.save(savePost);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping(value = "update/version1")
    public ResponseEntity update(@RequestBody PostDTO postDTO){
        Post savePost=postMapper.postDtoToPost(postDTO);
        postServiceImplement.update(savePost);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "get/version1/{id}")
    public ResponseEntity<PostDTO> getById(@RequestBody Long id){
         Post post=postServiceImplement.getById(id);
         PostDTO getPost=postMapper.postToPostDto(post);
        return ResponseEntity.ok(getPost);
    }

    @GetMapping("/version1/{page}/{size}")
    public ResponseEntity<Paging<PostDTO>> postPageing(@PathVariable Integer page, Integer size) {
        Page<Post> postPage=postServiceImplement.paging(page,size);
        int allPage=postPage.getTotalPages() ;
        List<Post> date=postPage.getContent();

        List<PostDTO> postDTOS=postMapper.convertPostToPostDto(date);

        Paging<PostDTO> postDTOPaging=new Paging<>(allPage,page,postDTOS);
        return ResponseEntity.ok(postDTOPaging);
    }
    @GetMapping("getAll/version1/")
    public ResponseEntity<List<PostDTO>> getAll() {
        List<Post> posts = postServiceImplement.getAll();
        List<PostDTO> postDTOS = postMapper.convertPostToPostDto(posts);
        return ResponseEntity.ok(postDTOS);
    }

    @DeleteMapping("version1/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        postServiceImplement.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("getAll/getBy_userId/{userId}")
    public ResponseEntity<List<PostDTO>> getAllByUserId(@PathVariable Long userId) {
        List<Post> posts = postServiceImplement.getAllByUserApp(userId);
        List<PostDTO> postDTOS = postMapper.convertPostToPostDto(posts);
        return ResponseEntity.ok(postDTOS);
    }
}
