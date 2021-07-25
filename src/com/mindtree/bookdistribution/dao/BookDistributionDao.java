package com.mindtree.bookdistribution.dao;

import java.util.Set;

import com.mindtree.bookdistribution.entity.Book;
import com.mindtree.bookdistribution.entity.Student;
import com.mindtree.bookdistribution.exception.DaoException;

public interface BookDistributionDao {

	public Student checkStudentDetails(byte studentId) throws DaoException;

	public Book assignBookToStudent(Book book) throws DaoException;

	public Set<Book> getAllBooksForAParticularClassInSortingOrderOfBookName(String studentClassName) throws DaoException;

	public Set<Student> displayStudentWhoHaveNotRecievedAnyBook() throws DaoException;

}
