package com.mindtree.bookdistribution.entity;

public class Book {
	private byte bookId;
	private String bookName;
	private String language;
	private String bookClass;
	
	private Student student;

	public Book(byte bookId, String bookName, String language, String bookClass, Student student) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.language = language;
		this.bookClass = bookClass;
		this.student = student;
	}
	

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(String bookName, String language, String bookClass, Student student) {
		super();
		this.bookName = bookName;
		this.language = language;
		this.bookClass = bookClass;
		this.student = student;
	}

	public byte getBookId() {
		return bookId;
	}

	public void setBookId(byte bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getBookClass() {
		return bookClass;
	}

	public void setBookClass(String bookClass) {
		this.bookClass = bookClass;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		return true;
	}
	
	
}
