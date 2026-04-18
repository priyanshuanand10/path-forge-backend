package com.pathforge.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRoleRepository extends MongoRepository<JobRole, String> {
}
