package com.taskzs.service;

import com.taskzs.entity.Task;
import com.taskzs.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final LocalDate date = LocalDate.now();
    private final TaskRepository repository;

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task saveTask(Task task) {
        if(!task.getDeadline().isBefore(date)) {
            if(findMaxOrder().isPresent()) {
                Integer i = findMaxOrder().get();
                task.setOrder(i+1);
                return repository.save(task);
            }

            task.setOrder(1);
            return repository.save(task);
        }


        return null;

    }

    private Optional<Integer> findMaxOrder() {
        return repository.findAll().stream()
                .map(Task::getOrder)
                .max(Comparator.naturalOrder());
    }

    public void deleteById(String id) {

       repository.deleteById(id);

    }

    public Optional<Task> findById(String id) {
       return repository.findById(id);
    }
}
