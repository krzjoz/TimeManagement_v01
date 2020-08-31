package com.jk.timemrgapp.dto.repository.security;

import com.jk.timemrgapp.dto.entity.security.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Integer> {
}
