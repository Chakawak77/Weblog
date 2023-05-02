package com.kurd.controller;
import com.kurd.common.Paging;
import com.kurd.dto.PostDTO;
import com.kurd.dto.ProfileDto;
import com.kurd.entity.Post;
import com.kurd.entity.Profile;
import com.kurd.mapper.ProfileMapper;
import com.kurd.service_implement.ProfileServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/profile-controller/")
public class ProfileController {

    private final ProfileServiceImplement profileServiceImplement;
    private final ProfileMapper profileMapper;

    @PostMapping(value = "save/version1")
    public ResponseEntity save(@RequestBody ProfileDto profileDto){
        Profile saveProfile= profileMapper.profileDtoToProfile(profileDto);
        profileServiceImplement.save(saveProfile);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping(value = "update/version1")
    public ResponseEntity update(@RequestBody ProfileDto profileDto){
        Profile updateProfile= profileMapper.profileDtoToProfile(profileDto);
        profileServiceImplement.update(updateProfile);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "getById/version1/{id}")
    public ResponseEntity<ProfileDto> getById(@RequestBody Long id){
         Profile profile= profileServiceImplement.getById(id);
         ProfileDto getProfile= profileMapper.profileToProfileDto(profile);
        return ResponseEntity.ok(getProfile);
    }

    @GetMapping("version1/{page}/{size}")
    public ResponseEntity<Paging<ProfileDto>> profilePageing(@PathVariable Integer page, Integer size) {
        Page<Profile> profilePage= profileServiceImplement.paging(page,size);
        int allPage=profilePage.getTotalPages() ;
        List<Profile> date=profilePage.getContent();

        List<ProfileDto> profileDtos= profileMapper.convertListProfileToProfileDto(date);

        Paging<ProfileDto> profileDtoPaging=new Paging<>(allPage,page,profileDtos);
        return ResponseEntity.ok(profileDtoPaging);
    }
    @GetMapping("getAll/version1/")
    public ResponseEntity<List<ProfileDto>> getAll() {
        List<Profile> profiles = profileServiceImplement.getAll();
        List<ProfileDto> profileDtos = profileMapper.convertListProfileToProfileDto(profiles);
        return ResponseEntity.ok(profileDtos);
    }

    @DeleteMapping("version1/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        profileServiceImplement.delete(id);
        return ResponseEntity.ok().build();
    }
}
