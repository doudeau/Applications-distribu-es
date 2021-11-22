package com.telecom.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.kanban.domain.ChangeLog;


@Repository
public interface ChangeLogRepository extends JpaRepository<ChangeLog,Long>{

}

