package ui;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Hibernate;

import db.project3.core.SearchBook;
import db.project3.dto.Book;
import db.project3.dto.Copy;

public class SearchByTitleAllCopies {
	public static void main(String[] args){
		try {
			System.out.println("Enter a Book Title");
			Scanner in = new Scanner(System.in);
			String title = in.nextLine();
			SearchBook titleSearch = new SearchBook();
		
			List<Book> results = titleSearch.byTitle(title);	
			
			for(Book book : results){
				
				Collection<Copy> copies = book.getCopies();
				Hibernate.initialize(copies);
				for(Copy copy : copies){
					System.out.println(book.getIsbn() + " " + book.getTitle() + " Status: "
							+ copy.getCheckOutStatus().name());
				}
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
