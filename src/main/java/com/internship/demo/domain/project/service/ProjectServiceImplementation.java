package com.internship.demo.domain.project.service;

import com.internship.demo.domain.project.entity.Project;
import com.internship.demo.domain.project.model.ProjectDto;
import com.internship.demo.domain.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceImplementation implements ProjectService{


    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImplementation(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setProjectName(projectDto.getProjectName());
        return projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElse(new Project());
    }

    @Override
    public Project updateProject(Long id, ProjectDto projectDto) {

        //checking if project exist in repository
        //if not trow exception
        projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project id does not exist"));

        Project project = projectRepository.getById(id);
        project.setProjectName(projectDto.getProjectName());
        return projectRepository.save(project);
    }

    @Override
    public void deleteProjectById(Long id) {
        //checking if project exist in repository
        //if not trow exception
        projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project id does not exist"));

        projectRepository.deleteById(id);
    }
}
