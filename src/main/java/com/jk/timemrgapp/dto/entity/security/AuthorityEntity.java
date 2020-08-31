package com.jk.timemrgapp.dto.entity.security;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "authorities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "authority_desc")
    private String role;

    @Column(name = "user_id")
    @ManyToMany(mappedBy = "authorities")
    private Set<UserEntity> users;

}
