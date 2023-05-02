package com.kurd.mapper;
import com.kurd.dto.CommentDto;
import com.kurd.dto.PostDTO;
import com.kurd.entity.Comment;
import com.kurd.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Date;
import java.util.List;


@Mapper(componentModel = "spring",uses = CommentMapper.class)
public interface CommentMapper {


    @Mapping(target = "date",source = "date",ignore = false,qualifiedByName = "convertToComment")
    Comment commentDtoToComment(CommentDto commentDto);

    @Mapping(target = "date",source = "date",ignore = false,qualifiedByName = "convertToCommentDto")
    CommentDto commentToCommentDto(Comment comment);

    List<Comment> convertCommentDtoListToComment(List<CommentDto> commentDtos);
    List<CommentDto> convertCommentListToCommentDto(List<Comment> comments);

    @Named("convertToComment")
    default Date longToDate(Long dateLong){
        if(dateLong != null)
            return  new Date(dateLong);
        return null;
    }
    @Named("convertToCommentDto")
    default Long dateToLong(Date date){
        if(date != null)
            return date.getTime();
        return null;
    }
}
