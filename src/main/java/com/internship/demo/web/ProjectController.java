package com.internship.demo.web;

import com.internship.demo.domain.project.entity.Project;
import com.internship.demo.domain.project.model.ProjectDto;
import com.internship.demo.domain.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    ProjectService projectService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{projectId}")
    ResponseEntity<Project> projectResponseEntity(@PathVariable Long projectId){
        return ResponseEntity.ok(projectService.getProjectById(projectId));
    }

    @PostMapping
    ResponseEntity<Project> projectResponseEntity(@RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectService.createProject(projectDto));
    }

    @PatchMapping("/{projectId}")
    ResponseEntity<Project> projectResponseEntity(@PathVariable Long projectId, @RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectService.updateProject(projectId,projectDto));
    }

    @DeleteMapping("/{projectId}")
    ResponseEntity<Project> projectResponseEntityDelete(@PathVariable Long projectId){
        projectService.deleteProjectById(projectId);
        return ResponseEntity.ok(null);
    }
}
