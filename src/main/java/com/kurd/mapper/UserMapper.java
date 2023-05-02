package com.kurd.mapper;
import com.kurd.dto.UserAppDTO;
import com.kurd.entity.UserApp;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserApp userDtoToUserApp(UserAppDTO userAppDTO);
    UserAppDTO userAppToUserAppDto(UserApp userApp);

    List<UserApp> userDtoListToListUser(List<UserAppDTO> userAppDTOList);
    List<UserAppDTO> userListToListDto(List<UserApp> userAppList);
}
