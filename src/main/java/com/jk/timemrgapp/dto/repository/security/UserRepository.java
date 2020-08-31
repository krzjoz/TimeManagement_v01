package com.jk.timemrgapp.dto.repository.security;

import com.jk.timemrgapp.dto.entity.security.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

    @Query("SELECT u.userId FROM UserEntity u where u.username = :username")
    Long findUserIdByUsername(@Param("username") String username);
}
