package com.internship.demo.domain.task.service;

import com.internship.demo.domain.task.entity.Task;
import com.internship.demo.domain.task.model.TaskDto;

public interface TaskService {

    Task createTask(TaskDto taskDto);
    Task getTaskById(Long id);
    Task updateTaske(Long id, TaskDto taskDto);
    void deleteTaskById(Long id);
}
