package com.internship.demo.domain.project.entity;

import com.internship.demo.domain.task.entity.Task;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @NotBlank
    @Size(min = 3)
    private String projectName;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;




}
