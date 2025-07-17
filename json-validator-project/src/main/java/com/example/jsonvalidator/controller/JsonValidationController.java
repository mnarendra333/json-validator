package com.example.jsonvalidator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/json")
public class JsonValidationController {

    private final ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/validate")
    public ResponseEntity<?> validateJson(@RequestBody String json) {
        try {
            JsonNode node = mapper.readTree(json);
            return ResponseEntity.ok(node);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid JSON: " + e.getMessage());
        }
    }
}