package com.taskzs.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Date;

@Builder
public record TaskRequest(String name,
                          String description,
                          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                          LocalDate deadline
                          ) {
}
