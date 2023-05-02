package com.kurd.repository;
import com.kurd.entity.Post;
import com.kurd.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends PagingAndSortingRepository<Profile,Long> {

    Page<Profile> findAll(Pageable pageable);
}
