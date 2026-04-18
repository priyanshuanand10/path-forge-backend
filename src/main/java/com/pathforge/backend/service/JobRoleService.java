package com.pathforge.backend.service;

import com.pathforge.backend.entity.JobRole;
import com.pathforge.backend.repository.JobRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobRoleService {

    @Autowired
    private JobRoleRepository repository;

    public List<JobRole> findAll() {
        return repository.findAll();
    }

    public JobRole save(JobRole jobRole) {
        return repository.save(jobRole);
    }

    public JobRole findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
