package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Embeddable
public class Teacher {
	
	@Id
	@GeneratedValue
	@Column(name="t_id")
	private long teacherId;
	
	
	@Column(name="t_name")
	private String teachername;
	
	
	@OneToMany(mappedBy = "Teacher", cascade = CascadeType.ALL)
	private List<Classes> cla;

	
	
	public long getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}


	public String getTeachername() {
		return teachername;
	}


	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}


	public List<Classes> getCla() {
		return cla;
	}


	public void setCla(List<Classes> cla) {
		this.cla = cla;
	}


	
	
	
	
	
}
