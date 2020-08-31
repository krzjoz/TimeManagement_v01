package com.jk.timemrgapp.dto.entity.security;


import com.jk.timemrgapp.dto.entity.security.AuthorityEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "user_name")
    private String username;

    @Column(name = "hash_pass")
    private String hashPass;

    @Singular
    @Column(name = "authorities")
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<AuthorityEntity> authorities;

    @Builder.Default
    @Column(name = "account_non_expired")
    private Boolean accountNonExpired = true;

    @Builder.Default
    @Column(name= "account_non_locked")
    private Boolean accountNonLocked = true;

    @Builder.Default
    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired = true;

    @Builder.Default
    @Column(name = "enable")
    private Boolean enable = true;






}
