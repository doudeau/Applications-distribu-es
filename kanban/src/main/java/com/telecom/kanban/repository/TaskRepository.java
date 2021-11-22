package com.telecom.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.kanban.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}