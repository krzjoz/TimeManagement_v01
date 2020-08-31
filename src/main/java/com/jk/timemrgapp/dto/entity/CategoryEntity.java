package com.jk.timemrgapp.dto.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CategoryEntity {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "category_description")
    private String categoryDesc;

}
