package com.taskzs.controller.mapper;

import com.taskzs.controller.request.TaskRequest;
import com.taskzs.controller.response.TaskResponse;
import com.taskzs.entity.Task;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TaskMapper {
    public static Task toTask(TaskRequest request) {
        return Task.builder()
                .name(request.name())
                .description(request.description())
                .deadline(request.deadline())
                .build();
    }

    public static TaskResponse toTaskResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .deadline(task.getDeadline())
                .order(task.getOrder())
                .build();
    }
}
