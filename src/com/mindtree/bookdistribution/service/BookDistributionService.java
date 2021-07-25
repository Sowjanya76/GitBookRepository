package com.mindtree.bookdistribution.service;

import java.util.Set;

import com.mindtree.bookdistribution.entity.Book;
import com.mindtree.bookdistribution.entity.Student;
import com.mindtree.bookdistribution.exception.ServiceException;

public interface BookDistributionService {

	
	public Student checkStudentDetails(byte studentId, String bookClass) throws ServiceException;

	public Book assignBookToStudent(Book book) throws ServiceException;

	public Set<Book> getAllBooksForAParticularClassInSortingOrderOfBookName(String studentClassName) throws ServiceException;

	public Set<Student> displayStudentWhoHaveNotRecievedAnyBook() throws ServiceException;

}
