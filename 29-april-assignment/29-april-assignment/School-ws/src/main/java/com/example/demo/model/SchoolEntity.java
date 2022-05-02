package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="school_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolEntity {
	@Id
	@Column(name="school_id")
	private int schoolId;
	@Column(name="school_name")
	private String schoolName;

}
