package com.project.shopapp.repositories;

import com.project.shopapp.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<UserEntity> findByPhoneNumber(String phoneNumber);
    //SELECT * FROM users WHERE phoneNumber=?

    @Query("SELECT u " +
            "FROM UserEntity u " +
            "WHERE u.isActive = true AND (:keyword IS NULL OR :keyword = '' " +
            "OR u.fullName like %:keyword% " +
            "OR u.phoneNumber like %:keyword%)")
    Page<UserEntity> searchUsers(@Param("keyword") String keyword,
                                 Pageable pageable);
}

