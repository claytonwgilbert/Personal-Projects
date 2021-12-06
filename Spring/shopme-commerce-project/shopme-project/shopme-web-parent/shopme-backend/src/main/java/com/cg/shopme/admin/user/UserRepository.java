package com.cg.shopme.admin.user;

import com.cg.shopme.common.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    User findByEmail(String email);

    Long countById(int id);

    @Query("UPDATE User u SET u.enabled = ?2 WHERE u.id = ?1")
    @Modifying // - Have to have when modifying db with update query statement
    void updateEnabledStatus(int userId, boolean isEnabled);

    @Query("SELECT u FROM User u WHERE CONCAT(u.id, ' ', u.firstName, ' ', u.lastName, ' ', u.email) LIKE %?1%")
    Page<User> findUsersThroughSearch(String searchField, Pageable pageable);
}
