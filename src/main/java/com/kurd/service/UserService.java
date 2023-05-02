package com.kurd.service;
import com.kurd.common.exeption.NotFoundException;
import com.kurd.entity.UserApp;
import com.kurd.repository.UserRepository;
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
public class UserService implements UserServiceImplement {

    private final UserRepository userRepository;

    @Override
    public UserApp save(UserApp user) {
        return userRepository.save(user);
    }

    @Override
    public UserApp update(UserApp user) {
        UserApp updateUser=getById(user.getUserId());
        updateUser.setUserName(user.getUserName());
        updateUser.setPassword(user.getPassword());
        updateUser.setEmail(user.getEmail());
        return userRepository.save(updateUser);
    }

    @Override
    public void delete(Long id) {
     userRepository.deleteById(id);
    }

    @Override
    public UserApp getById(Long id) {
        Optional<UserApp> optionalUser= userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw  new NotFoundException("Not Found");
        }
        return optionalUser.get();
    }

    @Override
    public List<UserApp> getAll() {
        return (List<UserApp>) userRepository.findAll();
    }

    @Override
    public Page<UserApp> paging(Integer page, Integer size) {
        return userRepository.findAll(PageRequest.of(page,size, Sort.by("id")));
    }
}
