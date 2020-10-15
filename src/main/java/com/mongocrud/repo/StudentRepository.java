package com.mongocrud.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongocrud.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

	public Student findByName(String name);
}
