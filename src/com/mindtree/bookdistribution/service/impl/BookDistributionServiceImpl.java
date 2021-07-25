package com.mindtree.bookdistribution.service.impl;

import java.util.Set;

import com.mindtree.bookdistribution.dao.BookDistributionDao;
import com.mindtree.bookdistribution.dao.impl.BookDistributionDaoImpl;
import com.mindtree.bookdistribution.entity.Book;
import com.mindtree.bookdistribution.entity.Student;
import com.mindtree.bookdistribution.exception.DaoException;
import com.mindtree.bookdistribution.exception.ServiceException;
import com.mindtree.bookdistribution.exception.service.NoSuchBookFoundException;
import com.mindtree.bookdistribution.exception.service.NoSuchStudentFoundException;
import com.mindtree.bookdistribution.exception.service.NoSuchStudentsFoundException;
import com.mindtree.bookdistribution.service.BookDistributionService;

public class BookDistributionServiceImpl implements BookDistributionService {
	BookDistributionDao dao=new BookDistributionDaoImpl();

	@Override
	public Student checkStudentDetails(byte studentId, String bookClass) throws ServiceException {
		Student student=null;
		try {
			student=dao.checkStudentDetails(studentId);
			if(student==null) {
				throw new NoSuchStudentFoundException("Student Not found");
		     }
		     else if(student.getClassName().equalsIgnoreCase(bookClass)==false)
					throw new NoSuchBookFoundException("Book Not found");
			
			
		} catch (DaoException e) {
			throw new ServiceException("problem with sql query");
		}
		return student;	
	}

	@Override
	public Book assignBookToStudent(Book book) throws ServiceException {
		Book bookResult=null;
		try {
			bookResult=dao.assignBookToStudent(book);
			
		} catch (DaoException e) {
			throw new ServiceException("problem with sql query");
		}
		return bookResult;
	}

	@Override
	public Set<Book> getAllBooksForAParticularClassInSortingOrderOfBookName(String studentClassName) throws ServiceException {
		try {
			Set<Book> bookDetailsByStudentClassName=dao.getAllBooksForAParticularClassInSortingOrderOfBookName(studentClassName);
			if(bookDetailsByStudentClassName.isEmpty())
				throw new NoSuchBookFoundException("No book Found");
			else 
				return bookDetailsByStudentClassName;
		} catch (DaoException e) {
			throw new ServiceException("problem with sql query");
		}
	}

	@Override
	public Set<Student> displayStudentWhoHaveNotRecievedAnyBook() throws ServiceException {
		try {
			Set<Student> studentDetails=dao.displayStudentWhoHaveNotRecievedAnyBook();
			if(studentDetails.isEmpty())
				throw new NoSuchStudentsFoundException("all students received books");
			else 
				return studentDetails;
		} catch (DaoException e) {
			throw new ServiceException("problem with sql query");
		}
	}

	

}
