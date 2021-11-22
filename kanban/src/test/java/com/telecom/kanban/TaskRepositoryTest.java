package com.telecom.kanban;

import java.util.Collection;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.telecom.kanban.domain.Task;
import com.telecom.kanban.repository.TaskRepository;
import com.telecom.kanban.repository.TaskStatusRepository;
import com.telecom.kanban.repository.TaskTypeRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
public class TaskRepositoryTest {
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskTypeRepository taskTypeRepository;
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Test
	public void testFindAllTasks() {
		Collection<Task> tasks = this.taskRepository.findAll();
		Assert.assertEquals(1, tasks.size());
	}	
	
	@Test
	public void testSaveTask() {
		Task task = new Task();
		taskRepository.save(task);
		
		
	}
	
	@Test
	public void testFindTask() {
		Task task = taskRepository.
	}
}
