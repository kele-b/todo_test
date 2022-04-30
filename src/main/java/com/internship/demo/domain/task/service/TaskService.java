package com.internship.demo.domain.task.service;

import com.internship.demo.domain.task.entity.Task;
import com.internship.demo.domain.task.model.TaskDto;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {

    Task createTask(TaskDto taskDto);
    Task getTaskById(Long id);
    Task updateTaske(Long id, TaskDto taskDto);
    void deleteTaskById(Long id);
}
