package com.kurd.service;

import com.kurd.common.exeption.NotFoundException;
import com.kurd.entity.Profile;
import com.kurd.repository.ProfileRepository;
import com.kurd.service_implement.ProfileServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfileService implements ProfileServiceImplement {

    private final ProfileRepository profileRepository;
    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile update(Profile profile) {
        Profile updateProfile=getById(profile.getProfileId());

        updateProfile.setImage(profile.getImage());
        updateProfile.setCv(profile.getCv());
        updateProfile.setBio(profile.getBio());
        updateProfile.setEmail(profile.getEmail());
        updateProfile.setFirstName(profile.getFirstName());
        updateProfile.setLastName(profile.getLastName());

        return profileRepository.save(updateProfile);
    }

    @Override
    public void delete(Long id) {
        profileRepository.deleteById(id);

    }

    @Override
    public Profile getById(Long id) {
        Optional<Profile> optionalProfile=profileRepository.findById(id);
        if (optionalProfile.isEmpty())
            throw new NotFoundException("Not Found!!");
        return optionalProfile.get();
    }

    @Override
    public List<Profile> getAll() {
        return (List<Profile>) profileRepository.findAll();
    }

    @Override
    public Page<Profile> paging(Integer page, Integer size) {
        return profileRepository.findAll(PageRequest.of(page,size, Sort.by("id")));
    }
}
