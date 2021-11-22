package com.telecom.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.kanban.domain.TaskType;

@Repository
public interface TaskTypeRepository extends JpaRepository<TaskType,Long>{

}
