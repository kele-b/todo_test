package com.internship.demo.domain.task.entity;

import com.internship.demo.domain.project.entity.Project;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UniqueElements
    private Long taskId;

    @Size(min = 3)
    private String taskName;

    private String taskDescription;

    private Boolean taskDone;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;
}
