package com.henrique.controllers;

import com.henrique.models.Course;
import com.henrique.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course add(@RequestBody Course c) {
        return courseRepository.save(c);
        //return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(c));
    }
}
