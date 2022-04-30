package com.internship.demo.domain.task.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.internship.demo.domain.project.entity.Project;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @NotBlank
    @Size(min = 3)
    private String taskName;

    private String taskDescription;

    private Boolean taskDone;


    @ManyToOne
    @JoinColumn(name = "projectId")
    @JsonBackReference
    private Project project;
}
