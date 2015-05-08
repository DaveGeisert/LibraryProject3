package ui;

import java.util.List;
import java.util.Scanner;

import db.project3.core.SearchBook;
import db.project3.dto.Book;

public class SearchByAuthor {

	public static void main(String[] args) {
		try {
			System.out.println("Enter Author First Name");
			Scanner in = new Scanner(System.in);
			String firstName = in.nextLine();
			System.out.println("Enter Author Last name");
			String lastName = in.nextLine();
			SearchBook bookSearch = new SearchBook();
		
			List<Book> results = bookSearch.byAuthor(firstName, lastName);
			for(Book book : results){
				System.out.println("     " + book.getIsbn() + " " + book.getTitle() + " " + book.getSubject());
			}
			in.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
