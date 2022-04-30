package com.internship.demo.domain.task.model;

import lombok.Data;

@Data
public class TaskDto {

    private String taskName;

    private String taskDescription;

    private Boolean taskDone;

    private Long projectId;
}
