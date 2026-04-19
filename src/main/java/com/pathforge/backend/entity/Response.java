package com.pathforge.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    List<DayWiseAssignment> dayWiseAssignmentList = new ArrayList<>();
}
