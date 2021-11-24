package com.telecom.kanban.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telecom.kanban.domain.Developer;

public interface DeveloperService {
	
	public List<Developer> findAllDevelopers();

}
