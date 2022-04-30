package com.internship.demo.domain.task.service;

import com.internship.demo.domain.project.repository.ProjectRepository;
import com.internship.demo.domain.task.entity.Task;
import com.internship.demo.domain.task.model.TaskDto;
import com.internship.demo.domain.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImplementation implements TaskService{


    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Task createTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTaskName(taskDto.getTaskName());
        task.setTaskDescription(taskDto.getTaskDescription());
        task.setTaskDone(taskDto.getTaskDone());
        task.setProject(projectRepository.findById(taskDto.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("task does not exist")));
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElse(new Task());
    }

    @Override
    public Task updateTaske(Long id, TaskDto taskDto) {
        taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("task does not exist"));
        Task task = taskRepository.getById(id);
        task.setTaskName(taskDto.getTaskName());
        task.setTaskDescription(taskDto.getTaskDescription());
        task.setTaskDone(taskDto.getTaskDone());
        task.setProject(projectRepository.getById(taskDto.getProjectId()));
        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("task does not exist"));

        taskRepository.deleteById(id);
    }
}
