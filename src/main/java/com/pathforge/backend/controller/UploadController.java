package com.pathforge.backend.controller;

import com.pathforge.backend.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadResume(
            @RequestParam("resume") MultipartFile resume,
            @RequestParam("role") String role,
            @RequestParam("days") String days) {
        try {
            uploadService.processPdf(resume, role, days);
            return ResponseEntity.ok("PDF processed successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error processing PDF: " + e.getMessage());
        }
    }
}
