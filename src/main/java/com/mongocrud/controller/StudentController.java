package com.mongocrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongocrud.model.Student;
import com.mongocrud.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public List<Student> getStudnets() throws Exception {
		return studentService.findAllStudent();

	}

	@GetMapping(value = "/{name}")
	public Student getProductById(@PathVariable("name") String name) {
		return studentService.findByName(name);
	}

	@DeleteMapping
	public void deleteAllStudent() {
		studentService.deleteAllStudent();
	}

	@DeleteMapping("/{name}")
	public void deleteStudent(@PathVariable("name") String name) {
		studentService.deleteStudentByName(name);
	}

	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@PutMapping
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

}
