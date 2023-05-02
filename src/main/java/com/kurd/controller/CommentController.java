package com.kurd.controller;
import com.kurd.common.Paging;
import com.kurd.dto.CommentDto;
import com.kurd.entity.Comment;
import com.kurd.mapper.CommentMapper;
import com.kurd.service_implement.CommentServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/comment-controller/")
public class CommentController {

    private final CommentServiceImplement commentServiceImplement;
    private final CommentMapper commentMapper;

    @PostMapping(value = "save/version1/")
    public ResponseEntity save(@RequestBody CommentDto commentDto){
        Comment saveComment= commentMapper.commentDtoToComment(commentDto);
        commentServiceImplement.save(saveComment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping(value = "update/version1")
    public ResponseEntity update(@RequestBody CommentDto commentDto){
        Comment saveComment= commentMapper.commentDtoToComment(commentDto);
        commentServiceImplement.update(saveComment);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "get/version1/{id}")
    public ResponseEntity<CommentDto> getById(@RequestBody Long id){
         Comment comment= commentServiceImplement.getById(id);
         CommentDto getComment= commentMapper.commentToCommentDto(comment);
        return ResponseEntity.ok(getComment);
    }

    @GetMapping("version1/{page}/{size}")
    public ResponseEntity<Paging<CommentDto>> postPageing(@PathVariable Integer page, Integer size) {
        Page<Comment> commentPage= commentServiceImplement.paging(page,size);
        int allPage=commentPage.getTotalPages() ;
        List<Comment> date=commentPage.getContent();

        List<CommentDto> commentDtos= commentMapper.convertCommentListToCommentDto(date);

        Paging<CommentDto> commentDtoPaging=new Paging<>(allPage,page,commentDtos);
        return ResponseEntity.ok(commentDtoPaging);
    }
    @GetMapping("getAll/version1/")
    public ResponseEntity<List<CommentDto>> getAll() {
        List<Comment> comments = commentServiceImplement.getAll();
        List<CommentDto> commentDtos = commentMapper.convertCommentListToCommentDto(comments);
        return ResponseEntity.ok(commentDtos);
    }

    @DeleteMapping("version1/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        commentServiceImplement.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("getAll/getBy_userId/{userId}")
    public ResponseEntity<List<CommentDto>> getAllByUserId(@PathVariable Long userId) {
        List<Comment> comments = commentServiceImplement.getAllByUserApp(userId);
        List<CommentDto> commentDtos = commentMapper.convertCommentListToCommentDto(comments);
        return ResponseEntity.ok(commentDtos);
    }
}
