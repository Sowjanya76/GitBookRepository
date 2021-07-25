package com.mindtree.bookdistribution.entity;

public class Student {

	private byte studentId;
	private String studentName;
	private byte age;
	private String className;
	
	
	public Student() {
		super();
	}


	
	public Student(String studentName, byte age, String className) {
		super();
		this.studentName = studentName;
		this.age = age;
		this.className = className;
	}



	public Student(byte studentId, String studentName, byte age, String className) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
		this.className = className;
	}


	public byte getStudentId() {
		return studentId;
	}


	public void setStudentId(byte studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public byte getAge() {
		return age;
	}


	public void setAge(byte age) {
		this.age = age;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public Student(byte studentId) {
		super();
		this.studentId = studentId;
	}
	
	

}
