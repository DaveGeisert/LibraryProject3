package db.project3.test;

import db.project3.crud.CreateBook;

public class CreatBookTest {
	public static void main (String[] args){
		CreateBook createBook = new CreateBook();		
		createBook.createBook("1234aaaa", "A Song of Ice and Fire: A Game of Thrones" , "Fantasy", "George", "R. R. Martin");
	}
}
