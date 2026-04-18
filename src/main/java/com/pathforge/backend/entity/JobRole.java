package com.pathforge.backend.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobRoles")
@Data
public class JobRole {
    @Id
    private String id;
    private String title;
    private String description;
    private boolean active;
}
