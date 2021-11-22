package com.telecom.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.kanban.domain.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}
