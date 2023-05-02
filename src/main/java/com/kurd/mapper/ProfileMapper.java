package com.kurd.mapper;
import com.kurd.dto.ProfileDto;
import com.kurd.entity.Profile;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    Profile profileDtoToProfile(ProfileDto profileDto);
    ProfileDto profileToProfileDto(Profile profile);

    List<Profile> convertListProfileDtoToProfile(List<ProfileDto> profileDtoList);
    List<ProfileDto> convertListProfileToProfileDto(List<Profile> profiles);
}
