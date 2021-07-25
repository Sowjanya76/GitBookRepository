package com.mindtree.bookdistribution.client;


import java.util.Scanner;
import java.util.Set;
import com.mindtree.bookdistribution.entity.Book;
import com.mindtree.bookdistribution.entity.Student;
import com.mindtree.bookdistribution.exception.ApplicationException;
import com.mindtree.bookdistribution.exception.ServiceException;
import com.mindtree.bookdistribution.service.BookDistributionService;
import com.mindtree.bookdistribution.service.impl.BookDistributionServiceImpl;


public class BookDistributionApp {
	private static Scanner scanner = new Scanner(System.in);
	static BookDistributionService bookService=new BookDistributionServiceImpl();
	public static void main(String args[])
	{
		
		byte choice;
		do {
			System.out.println("1.Assign book to student");
			System.out.println("2.get all the books of a particular class in sorting order of books name");
			System.out.println("3.display student who have not recived any of the books");
			System.out.println("4.exit");
			System.out.println("enter your choice");
			choice=scanner.nextByte();
			try{
			switch(choice) {
		case 1:assignBookToStudent();
			   break;
		case 2:getAllBooksForAParticularClassInSortingOrderOfBookName();
			   break;
		case 3:displayStudentWhoHaveNotRecievedAnyBook();
			   break;	
	     case 4:System.out.println("you are exited");
		        break;
		default: System.out.println("Invalid choice");
			}}catch (ApplicationException e) {
				System.out.println(e.getMessage());
			}
		}while(choice!=4);
}

private static void assignBookToStudent() throws ApplicationException {
	System.out.println("Enter student id");
	byte studentId = scanner.nextByte();
	Student student=null;
	Book book=null;
	try {
		book=BookDistributionApp.createBook(studentId);
		student = bookService.checkStudentDetails(studentId,book.getBookClass());
		if (student !=null&&student.getClassName().equalsIgnoreCase(book.getBookClass())) {
			book = bookService.assignBookToStudent(book);
			System.out.println("Name: "+book.getBookName()+"\n"+"class "+book.getBookClass()+"\n"+"studentId "+book.getStudent().getStudentId());
		}

	} catch (ServiceException e) {
		throw new ApplicationException(e.getMessage());
	}
	
	}

private static void getAllBooksForAParticularClassInSortingOrderOfBookName() throws ApplicationException {
	try {
		System.out.println("enter student class");
		String studentClassName=scanner.next();
		Set<Book> bookDetailsByStudnetClassName=bookService.getAllBooksForAParticularClassInSortingOrderOfBookName(studentClassName);
		displayBook(bookDetailsByStudnetClassName);
	}catch (ServiceException e) {
		throw new ApplicationException(e.getMessage());
	}
	}

private static void displayStudentWhoHaveNotRecievedAnyBook() throws ApplicationException {
	try {
	Set<Student> studentDetailsWhoHaveNotRecievedAnyBooks=bookService.displayStudentWhoHaveNotRecievedAnyBook();
	displayStudent(studentDetailsWhoHaveNotRecievedAnyBooks);
}catch (ServiceException e) {
	throw new ApplicationException(e.getMessage());
	}
}



private static void displayStudent(Set<Student> studentDetailsWhoHaveNotRecievedAnyBooks) {
	for (Student student : studentDetailsWhoHaveNotRecievedAnyBooks) {
		System.out.println("student name: "+student.getStudentName());
		System.out.println("student age: "+student.getAge());
		System.out.println("student class name: "+student.getClassName());
	}
	
}

private static void displayBook(Set<Book> bookDetailsByStudnetClassName) {
	for (Book book : bookDetailsByStudnetClassName) {
		System.out.println("Book name: "+book.getBookName());
		System.out.println("Book language: "+book.getLanguage());
		System.out.println("Book class name: "+book.getBookClass());
		System.out.println("Book assigning to the student with Id: "+book.getStudent().getStudentId());
	}
}


	public static Book createBook(byte studentId) {
		Book book = new Book();
			System.out.println("enter book name");
			String bookName = scanner.next();
			System.out.println("enter book language");
			String bookLanguage = scanner.next();
			System.out.println("Enter book class");
			String bookClass = scanner.next();
			book = new Book(bookName, bookLanguage, bookClass, new Student(studentId));
		return book;
	}

}
