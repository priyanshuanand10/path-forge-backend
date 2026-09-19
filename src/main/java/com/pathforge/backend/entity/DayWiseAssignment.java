package com.pathforge.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DayWiseAssignment {
    private int day;
    private String title;
    private List<String> taskToDo;
}
