package com.kurd.service;

import com.kurd.common.exeption.NotFoundException;
import com.kurd.entity.Comment;
import com.kurd.entity.UserApp;
import com.kurd.repository.CommentRepository;
import com.kurd.service_implement.CommentServiceImplement;
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
public class CommentService implements CommentServiceImplement {

    private final CommentRepository commentRepository;
    private final UserServiceImplement userServiceImplement;
    @Override
    public Comment save(Comment comment) {
        Long userId=comment.getUser().getUserId();
        var saveUser=userServiceImplement.getById(userId);
        comment.setUser(saveUser);
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        Comment updateComment=getById(comment.getCommentId());
        updateComment.setDate(comment.getDate());
        updateComment.setImage(comment.getImage());
        updateComment.setDescription(comment.getDescription());
        return commentRepository.save(updateComment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);

    }

    @Override
    public Comment getById(Long id) {
        Optional<Comment> optionalComment=commentRepository.findById(id);
        if (optionalComment.isEmpty())
            throw new NotFoundException("Error!");
        return optionalComment.get();
    }

    @Override
    public List<Comment> getAll() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public List<Comment> getAllByUserApp(Long userId) {
        UserApp userApp=userServiceImplement.getById(userId);
        List<Comment> commentList=commentRepository.findAllByUser(userApp);
        return commentList;
    }

    @Override
    public Page<Comment> paging(Integer page, Integer size) {
        return commentRepository.findAll(PageRequest.of(page,size, Sort.by("id")));
    }
}
