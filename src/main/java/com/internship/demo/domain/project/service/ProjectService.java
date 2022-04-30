package com.internship.demo.domain.project.service;

import com.internship.demo.domain.project.entity.Project;
import com.internship.demo.domain.project.model.ProjectDto;

public interface ProjectService {

    Project createProject(ProjectDto projectDto);
    Project getProjectById(Long id);
    Project updateProject(Long id, ProjectDto projectDto);
    void deleteProjectById(Long id);

}
