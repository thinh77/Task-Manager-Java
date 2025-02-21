package com.taskmanager.controller;

import com.taskmanager.dto.request.TaskRequestDto;
import com.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.saveTask(taskRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.updateTask(id, taskRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
