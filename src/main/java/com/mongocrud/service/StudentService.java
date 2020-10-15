package com.mongocrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongocrud.model.Student;
import com.mongocrud.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	// Create Student
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	// Find all Student
	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}

	// Find by Properties <Name>
	public Student findByName(String name) {
		return studentRepository.findByName(name);
	}

	// Update Student
	public Student updateStudent(Student updatedStudent) {
		Student student = studentRepository.findByName(updatedStudent.getName());
		if (null != student) {
			student.setPhoneNumber(updatedStudent.getPhoneNumber());
		} else {
			student = updatedStudent;
		}
		return studentRepository.save(student);
	}

	// Delete Student by Properties <Name>
	public void deleteStudentByName(String name) {
		Student student = studentRepository.findByName(name);
		if (null != student)
			studentRepository.delete(student);
	}

	// delete all Student
	public void deleteAllStudent() {
		studentRepository.deleteAll();
	}
}
