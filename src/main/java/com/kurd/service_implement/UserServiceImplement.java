package com.kurd.service_implement;
import com.kurd.dto.UserAppDTO;
import com.kurd.entity.UserApp;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserServiceImplement {

    UserApp save(UserApp userApp);
    UserApp update(UserApp userApp);
    void delete(Long id);
    UserApp getById(Long id);
    List<UserApp> getAll();

    Page<UserApp> paging(Integer page,Integer size);

}
