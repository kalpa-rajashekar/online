package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSES")
public class Classes {

	@Id
	@GeneratedValue
	@Column(name = "c_id")
	private long class_id;

	@Column(name = "c_name")
	private String cname;

	//@Column(name = "l_name")
	//private String lname;

	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}

	@OneToMany(mappedBy = "classes", cascade = CascadeType.ALL)
	private List<Course> sub;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "class_student_link", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "s_id"))
	private List<Student> student;

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="t_id")
	private Teacher teacher;

	

	

	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public String getCourse() {
		StringBuilder sb = new StringBuilder();
		if (sub != null) {
			for (Course c :sub ) {
				sb.append(c.getCourseName() + ", ");
			}
		}
		return sb.toString();
	}

	
	public String getstudent() {
		StringBuilder sb = new StringBuilder();
		if (student != null) {
			for (Student s : student) {
				sb.append(s.getStudentName()+ ", ");
			}
		}
		return sb.toString();
	}

	public void setstudent(List<Course> course) {
		this.student = student;
	}
	public long getClass_id() {
		return class_id;
	}

	public void setClass_id(long class_id) {
		this.class_id = class_id;
	}

	

	
	
	

	

	public String getsub() {
		StringBuilder sb = new StringBuilder();

		if (sub != null && sub.size() > 0) {
			for (Course subjects : sub) {
				sb.append(subjects.getCourseName() + " ");
			}
		}
		return sb.toString();
	}

	public void setsub(List<Course> sub) {
		this.sub = sub;
	}
}