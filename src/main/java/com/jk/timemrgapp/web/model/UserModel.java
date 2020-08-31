package com.jk.timemrgapp.web.model;

import com.jk.timemrgapp.dto.entity.security.AuthorityEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel {

    private Long userId;
    private String username;
    private String hashPass;
    private Set<AuthorityEntity> authorities;
}
