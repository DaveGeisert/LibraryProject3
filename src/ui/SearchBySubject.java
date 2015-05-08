package ui;

import java.util.List;
import java.util.Scanner;

import db.project3.core.*;
import db.project3.dto.Book;

public class SearchBySubject {
	public static void main(String[] args){
		try {
			System.out.println("Enter a Subject");
			Scanner in = new Scanner(System.in);
			String subject = in.nextLine();
			SearchBook subjSearch = new SearchBook();
		
			List<Book> results = subjSearch.bySubject(subject);
			System.out.println(subject + ":");
		
			for(Book book : results){
				System.out.println("    " + book.getTitle() + " by: " + book.getAuthor().getFirstName() + " " + 
						book.getAuthor().getLastName());
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
