package com.jk.timemrgapp.dto.entity;

import com.jk.timemrgapp.dto.entity.security.UserEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_desc")
    private String taskDesc;

    @OneToOne
    @JoinColumn(name = "status_id")
    private StatusEntity statusId;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryId;

    @CreationTimestamp
    @Column(name = "task_add_date")
    private LocalDateTime taskAddDate;

    @Column(name = "task_from_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime taskFromDate;


    @Column(name = "task_to_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime taskToDate;

    @ManyToOne
    @JoinColumn(name = "id")
    private UserEntity user;

}
