package com.kurd.repository;
import com.kurd.entity.Category;
import com.kurd.entity.UserApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {

    Page<Category> findAll(Pageable pageable);
}
