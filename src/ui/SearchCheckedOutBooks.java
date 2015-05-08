package ui;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

import db.project3.core.SearchUser;
import db.project3.dto.Book;
import db.project3.dto.Copy;

public class SearchCheckedOutBooks {

	public static void main(String[] args) {
		try {
			System.out.println("Enter a Borrower User Name to View Books Checked Out");
			Scanner in = new Scanner(System.in);
			String borrower = in.nextLine();
			SearchUser userSearch = new SearchUser();
		
			List<Copy> booksCheckedOut = userSearch.getBooksCheckedOut(borrower);
		
			int index = 1;
			for (Copy copies : booksCheckedOut){
				Book book = copies.getBook();
				System.out.println(index + " " + copies.getBId() + " " + book.getIsbn() + " " + book.getTitle());
				System.out.println("     WrittenBy: " + book.getAuthor().getLastName() + ", " + 
								book.getAuthor().getFirstName());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
