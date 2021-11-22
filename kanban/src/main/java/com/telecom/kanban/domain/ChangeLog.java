package com.telecom.kanban.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class ChangeLog {

	@Id
	@GeneratedValue
	private Long id;
	
	private Date occured;
	
	@ManyToOne
	@ToString.Exclude
	private Task task;
	
	@ManyToOne
	private TaskStatus targetStatus;
	
	@ManyToOne
	private TaskStatus sourceStatus;
	
	public ChangeLog() {
	}
	
	
	
}
