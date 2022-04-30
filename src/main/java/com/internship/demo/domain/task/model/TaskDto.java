package com.internship.demo.domain.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private String taskName;

    private String taskDescription;

    private Boolean taskDone;

    private Long projectId;
}
