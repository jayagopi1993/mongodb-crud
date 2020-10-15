package com.mongocrud.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.mongocrud.service.SequenceGeneratorService;

@Component
public class StudentModelListener extends AbstractMongoEventListener<Student> {

	@Autowired
	private SequenceGeneratorService sequenceGenerator;

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Student> event) {
		if (event.getSource().getId() < 1) {
			event.getSource().setId(sequenceGenerator.generateSequence(Student.SEQUENCE_NAME));
		}
	}

}
