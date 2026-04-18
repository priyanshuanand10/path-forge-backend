package com.pathforge.backend.repository;

import com.pathforge.backend.entity.JobRole;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRoleRepository extends MongoRepository<JobRole, String> {
}
