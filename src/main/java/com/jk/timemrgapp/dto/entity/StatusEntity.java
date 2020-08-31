package com.jk.timemrgapp.dto.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "status")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StatusEntity {

    @Id
    @Column(name = "status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusId;

    @Column(name = "status_desc")
    private String statusDesc;
}
