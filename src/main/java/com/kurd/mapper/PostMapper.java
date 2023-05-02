package com.kurd.mapper;
import com.kurd.dto.PostDTO;
import com.kurd.entity.Post;
import com.kurd.entity.UserApp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Date;
import java.util.List;


@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface PostMapper {


    @Mapping(target = "date",source = "date",ignore = false,qualifiedByName = "convertToPost")
    Post postDtoToPost(PostDTO postDTO);

    @Mapping(target = "date",source = "date",ignore = false,qualifiedByName = "convertToPostDto")
    PostDTO postToPostDto(Post post);

    List<Post> convertPostDtoToPost(List<PostDTO> postDTOS);
    List<PostDTO> convertPostToPostDto(List<Post> posts);

    @Named("convertToPost")
    default Date longToDate(Long dateLong){
        if(dateLong != null)
            return  new Date(dateLong);
        return null;
    }
    @Named("convertToPostDto")
    default Long dateToLong(Date date){
        if(date != null)
            return date.getTime();
        return null;
    }
}
