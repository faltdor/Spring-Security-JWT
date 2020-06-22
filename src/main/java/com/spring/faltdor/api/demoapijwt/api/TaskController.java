package com.spring.faltdor.api.demoapijwt.api;

import com.spring.faltdor.api.demoapijwt.data.Task;
import com.spring.faltdor.api.demoapijwt.repository.TaskRepository;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskRepository.save(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @PutMapping("/{id}")
    public void editTask(@PathVariable long id, @RequestBody Task task) {
        Task existingTask = taskRepository.findById(id).get();
        Assert.notNull(existingTask, "Task not found");
        existingTask.setDescription(task.getDescription());
        taskRepository.save(existingTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        Task taskToDel = taskRepository.findById(id).get();
        taskRepository.delete(taskToDel);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable long id) {
        return taskRepository.findById(id).get();
    }
}
