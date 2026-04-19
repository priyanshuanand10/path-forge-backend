package com.pathforge.backend.controller;

import com.pathforge.backend.entity.Response;
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
    public ResponseEntity<Response> uploadResume(
            @RequestParam("resume") MultipartFile resume,
            @RequestParam("role") String role,
            @RequestParam("days") String days) {
        try {
            Response response = uploadService.processPdf(resume, role, days);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
//            throw  ResponseEntity.badRequest().body("Error processing PDF: " + e.getMessage());
            throw new  RuntimeException(e);
        }
    }
}
