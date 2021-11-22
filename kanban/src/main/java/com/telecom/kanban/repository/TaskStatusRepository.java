package com.telecom.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.kanban.domain.TaskStatus;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus,Long> {

}

