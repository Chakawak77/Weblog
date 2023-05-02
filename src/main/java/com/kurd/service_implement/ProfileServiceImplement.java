package com.kurd.service_implement;
import com.kurd.entity.Profile;
import com.kurd.entity.Profile;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProfileServiceImplement {

    Profile save(Profile profile);
    Profile update(Profile profile);
    void delete(Long id);
    Profile getById(Long id);
    List<Profile> getAll();

    Page<Profile> paging(Integer page,Integer size);

}
