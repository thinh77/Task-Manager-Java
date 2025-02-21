package com.taskmanager.service;

import com.taskmanager.dto.request.TaskRequestDto;
import com.taskmanager.entity.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasks();
    public Task getTaskById(Long id);
    public Task saveTask(TaskRequestDto taskRequestDto);
    public void deleteTask(Long id);
    public Task updateTask(Long id, TaskRequestDto taskRequestDto);
}
