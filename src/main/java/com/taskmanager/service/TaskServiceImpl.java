package com.taskmanager.service;

import com.taskmanager.dto.request.TaskRequestDto;
import com.taskmanager.entity.Task;
import com.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task saveTask(TaskRequestDto taskRequestDto) {
        Task task = new Task();
        task.setTitle(taskRequestDto.getTitle());
        task.setCompleted(taskRequestDto.isCompleted());
        taskRepository.save(task);
        return task;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Long id, TaskRequestDto taskRequestDto) {
        Task existedTask = taskRepository.findById(id).orElse(null);
        if (existedTask != null) {
            existedTask.setTitle(taskRequestDto.getTitle());
            existedTask.setCompleted(taskRequestDto.isCompleted());
            taskRepository.save(existedTask);
            return existedTask;
        }
        return null;
    }
}
