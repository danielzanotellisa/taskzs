package com.taskzs.controller;

import com.taskzs.controller.mapper.TaskMapper;
import com.taskzs.controller.request.TaskRequest;
import com.taskzs.controller.response.TaskResponse;
import com.taskzs.entity.Task;
import com.taskzs.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream()
                .map(TaskMapper::toTaskResponse).toList());
    }

    @PostMapping("/create")
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest request) {
        Task saved = service.saveTask(TaskMapper.toTask(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(TaskMapper.toTaskResponse(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        Optional<Task> optionalTask = service.findById(id);
        if(optionalTask.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
