package com.simran.presentation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simran.presentation.model.Grade;
@Service
public class GradeService {
	@Autowired
	private  GradeOperations db;
	
	public List<Grade> findAll() {
		return db.listAllGrade();
	}

	public void addGrade(Grade g) {
		db.save(g);
	}

	public String deleteGrade(Integer gradeId) {
		Grade g = getGrade(gradeId);
		if(g== null) 
			return "Grade Not Found!";
		db.delete(g);
		return "Employee Removed!";
	}
	public Grade getGrade(Integer gradeId) {
		Grade g = null;
		Optional<Grade> opt = db.findById(gradeId);
		if(!opt.isEmpty())
			g = opt.get();
		return g;
	}

}
