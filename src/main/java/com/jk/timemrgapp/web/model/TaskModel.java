package com.jk.timemrgapp.web.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TaskModel {

    private Long id;
    private String taskName;
    private String taskDesc;
    private Integer statusId;
    private Integer categoryId;
    private LocalDateTime taskAddDate;
    private String taskFromDate;
    private String taskToDate;
    private Long userId;
}
