package com.internship.demo.web;

import com.internship.demo.domain.task.entity.Task;
import com.internship.demo.domain.task.model.TaskDto;
import com.internship.demo.domain.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{taskId}")
    ResponseEntity<Task> taskResponseEntityGet(@PathVariable Long taskId){
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @PostMapping
    ResponseEntity<Task> taskResponseEntity(@Valid @RequestBody TaskDto taskDto){
        return ResponseEntity.ok(taskService.createTask(taskDto));
    }

    @PatchMapping("/{taskId}")
    ResponseEntity<Task> taskResponseEntity(@PathVariable Long taskId, @RequestBody TaskDto taskDto){
        return ResponseEntity.ok(taskService.updateTaske(taskId,taskDto));
    }

    @DeleteMapping("/{taskId}")
    ResponseEntity<Task> taskResponseEntity(@PathVariable Long taskId){
        taskService.deleteTaskById(taskId);
        return ResponseEntity.ok(null);
    }

}
