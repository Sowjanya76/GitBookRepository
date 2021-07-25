package com.mindtree.bookdistribution.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.mindtree.bookdistribution.dao.BookDistributionDao;
import com.mindtree.bookdistribution.entity.Book;
import com.mindtree.bookdistribution.entity.Student;
import com.mindtree.bookdistribution.exception.DaoException;
import com.mindtree.bookdistribution.utility.DbConnector;

public class BookDistributionDaoImpl implements BookDistributionDao{

	@Override
	public Student checkStudentDetails(byte studentId) throws DaoException {
		Student student=null;
		String query = "select* from student where id="+ studentId;
		try(Connection connection = DbConnector.connectionToDatabase();
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()){
			if (resultSet.next())
				student = new Student(resultSet.getByte(1),resultSet.getString(2),resultSet.getByte(3),resultSet.getString(4));
		} catch (SQLException e) {
			throw new DaoException("problem with sql query");
		}
	    return student;
	}

	@Override
	public Book assignBookToStudent(Book book) throws DaoException {
		Book bookResult=null;
		String Query="{call insertbook(?,?,?,?)}";
			try (Connection connection = DbConnector.connectionToDatabase();
					CallableStatement callableStatement = connection.prepareCall(Query)) {
				callableStatement.setString(1, book.getBookName());
				callableStatement.setString(2, book.getLanguage());
				callableStatement.setString(3, book.getBookClass());
				callableStatement.setByte(4, book.getStudent().getStudentId());
				try (ResultSet resultSet = callableStatement.executeQuery()) {
					if(resultSet.next())
					bookResult=book;
				}	
			} catch (SQLException e) {
				throw new DaoException("problem with sql query");
			}
		return bookResult;
	}

	@Override
	public Set<Book> getAllBooksForAParticularClassInSortingOrderOfBookName(String studentClassName) throws DaoException {
		Set<Book> allBookDetails = new LinkedHashSet<>();
		String Query = "select * from book where class='"+studentClassName+"' order by name";
		try (Connection connection = DbConnector.connectionToDatabase();
				PreparedStatement preparedStatement = connection.prepareCall(Query);
				ResultSet resultSet = preparedStatement.executeQuery();) {
				while (resultSet.next()) {
				String bookName = resultSet.getString(2);
				String language = resultSet.getString(3);
				String bookClassName = resultSet.getString(4);
				byte studentId = resultSet.getByte(5);
				allBookDetails.add(new Book(bookName, language, bookClassName,
						new Student(studentId)));
			}
		} catch (SQLException e) {
			throw new DaoException("problem with sql query");
		}
		return allBookDetails;
	}

	@Override
	public Set<Student> displayStudentWhoHaveNotRecievedAnyBook() throws DaoException {
		Set<Student> allStudentDetails = new LinkedHashSet<>();
		String Query = "select * from Student where id not in ( select studentId from Book) ";
		try (Connection connection = DbConnector.connectionToDatabase();
				PreparedStatement preparedStatement = connection.prepareCall(Query);
				ResultSet resultSet = preparedStatement.executeQuery();) {
				while (resultSet.next()) {
				String studentName = resultSet.getString(2);
				byte age = resultSet.getByte(3);
				String studentClassName = resultSet.getString(4);
				allStudentDetails.add(new Student(studentName, age, studentClassName));
			}} catch (SQLException e) {
				throw new DaoException("problem with sql query");
		}
		return allStudentDetails;
	}

}
