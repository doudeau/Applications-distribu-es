package com.telecom.kanban;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.telecom.kanban.domain.Developer;
import com.telecom.kanban.domain.Task;
import com.telecom.kanban.domain.TaskStatus;
import com.telecom.kanban.domain.TaskType;
import com.telecom.kanban.repository.DeveloperRepository;
import com.telecom.kanban.repository.TaskRepository;
import com.telecom.kanban.repository.TaskStatusRepository;
import com.telecom.kanban.repository.TaskTypeRepository;
import com.telecom.kanban.utils.Constants;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadData {
	
	@Bean
	@Profile("test")
	CommandLineRunner initDatabase(DeveloperRepository developerRepository, TaskRepository taskRepository,
			TaskStatusRepository taskStatusRepository, TaskTypeRepository taskTypeRepository) {
		return args -> {
			initTaskStatusAndTypes(taskStatusRepository, taskTypeRepository);
			initDevelopers(developerRepository);
			
			Developer dev2 = new Developer();
			dev2.setEmail("dev2@gmail.com");
			dev2.setFirstname("dev2");
			dev2.setLastname("dev2_1");
			dev2.setStartContract(LocalDate.of(2018, Month.NOVEMBER, 15));
			dev2.setPassword("dev2");
			developerRepository.save(dev2);
			
			Task task1 = new Task();
			task1.setCreated(LocalDate.now());
			task1.setTitle("task1");
			task1.setNbHoursForecast(0);
			task1.setNbHoursReal(0);
			task1.setTaskStatus(taskStatusRepository.findById(Constants.TASK_STATUS_FINISH_ID).orElse(null));
			task1.setTaskType(taskTypeRepository.findById(Constants.TASK_TYPE_1_ID).orElse(null));
			task1.addDeveloper(dev2);
			taskRepository.save(task1);
			
		};
	}
	
	private void initDevelopers(DeveloperRepository developerRepository) {
		Developer dev1 = new Developer();
		dev1.setEmail("dev1@gmail.com");
		dev1.setFirstname("dev1");
		dev1.setLastname("dev1_1");
		dev1.setStartContract(LocalDate.of(2020, Month.DECEMBER, 5));
		dev1.setPassword("dev1");
		developerRepository.save(dev1);
		
	}
	
	private void initTaskStatusAndTypes(TaskStatusRepository taskStatusRepository, TaskTypeRepository taskTypeRepository) {
		TaskStatus enDev = new TaskStatus(Constants.TASK_STATUS_DEV_ID,"en cours de developpement");
		taskStatusRepository.save(enDev);
		
		TaskStatus waiting = new TaskStatus(Constants.TASK_STATUS_WAITING_ID,"en attente");
		taskStatusRepository.save(waiting);
		
		TaskStatus finish = new TaskStatus(Constants.TASK_STATUS_FINISH_ID,"terminé");
		taskStatusRepository.save(finish);
		
		TaskType type1 = new TaskType(Constants.TASK_TYPE_1_ID,"type1");
		taskTypeRepository.save(type1);
		
		TaskType type2 = new TaskType(Constants.TASK_TYPE_2_ID,"type2");
		taskTypeRepository.save(type2);
	}
}

