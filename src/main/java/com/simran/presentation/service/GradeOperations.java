package com.simran.presentation.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simran.presentation.model.Grade;

@Repository
public interface GradeOperations extends JpaRepository<Grade, Integer>{
	@Query("select g from Grade g")
	public List<Grade> listAllGrade();
}
