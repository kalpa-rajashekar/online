package com.simplilearn.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	@Id
	@GeneratedValue
	@Column(name="s_id")
	private long studentId;
	
	@Column(name="s_name")
	private String studentName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_class_link", joinColumns = @JoinColumn(name = "s_id"), inverseJoinColumns = @JoinColumn(name = "c_id"))
	private List<Classes> classes;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	
	public String getclasses() {
		StringBuilder sb = new StringBuilder();
		if (classes != null) {
			for (Classes c : classes) {
				sb.append(c.getCname()  + ", ");
			}
		}
		return sb.toString();
	}

	public void setclasses(List<Course> course) {
		this.classes= classes;
	}


	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@ManyToMany(cascade=CascadeType.ALL, mappedBy="course")
	private List<Classes> cla;

	

	

	

	

	

	public List<Classes> getClasses() {
		return cla;
	}

	public void setClasses(List<Classes> cla) {
		this.cla = cla;
	}
}
