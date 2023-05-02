package com.kurd.controller;
import com.kurd.common.Paging;
import com.kurd.dto.UserAppDTO;
import com.kurd.entity.UserApp;
import com.kurd.mapper.UserMapper;
import com.kurd.service_implement.UserServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/user-controller/")
public class UserController {

    private final UserServiceImplement userService;
    private final UserMapper userMapper;

    @PostMapping("/save/version1")
    public ResponseEntity save(@RequestBody UserAppDTO userAppDTO) {
      UserApp saveUser=userMapper.userDtoToUserApp(userAppDTO);
      userService.save(saveUser);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/version1")
    public ResponseEntity update(@RequestBody UserAppDTO userAppDTO) {
        UserApp updateUser=userMapper.userDtoToUserApp(userAppDTO);
        userService.update(updateUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("get/version1/{id}")
    public ResponseEntity<UserAppDTO> getById(@PathVariable Long id) {
        UserApp user = userService.getById(id);
        UserAppDTO userAppDTO=userMapper.userAppToUserAppDto(user);
        return ResponseEntity.ok(userAppDTO);
    }
    @GetMapping("/version1/{page}/{size}")
    public ResponseEntity<Paging<UserAppDTO>> userPageing(@PathVariable Integer page, Integer size) {
        Page<UserApp> userAppPage=userService.paging(page,size);
        int allPage=userAppPage.getTotalPages() ;
        List<UserApp> date=userAppPage.getContent();

        List<UserAppDTO> userAppDTOS=userMapper.userListToListDto(date);

        Paging<UserAppDTO> userAppDTOPaging=new Paging<>(allPage,page,userAppDTOS);
        return ResponseEntity.ok(userAppDTOPaging);
    }
    @GetMapping("version1/")
    public ResponseEntity<List<UserAppDTO>> getAll() {
        List<UserApp> userList = userService.getAll();
        List<UserAppDTO> userAppDTOS = userMapper.userListToListDto(userList);
        return ResponseEntity.ok(userAppDTOS);
    }

    @DeleteMapping("version1/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
