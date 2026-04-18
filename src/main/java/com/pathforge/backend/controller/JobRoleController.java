package com.pathforge.backend.controller;

import com.pathforge.backend.entity.JobRole;
import com.pathforge.backend.service.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/job-roles")
public class JobRoleController {

    @Autowired
    private JobRoleService service;

    @GetMapping
    public List<JobRole> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public JobRole getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public JobRole create(@RequestBody JobRole jobRole) {
        return service.save(jobRole);
    }

    @PutMapping("/{id}")
    public JobRole update(@PathVariable String id, @RequestBody JobRole jobRole) {
        jobRole.setId(id);
        return service.save(jobRole);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
