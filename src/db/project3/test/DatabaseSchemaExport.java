package db.project3.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Random;

import org.hibernate.Session;
import org.junit.Test;

import db.project3.connections.ResetSchema;
import db.project3.dto.Address;
import db.project3.dto.Author;
import db.project3.dto.Book;
import db.project3.dto.Borrower;
import db.project3.dto.Copy;
import db.project3.dto.Staff;
import db.project3.dto.User;

public class DatabaseSchemaExport {

	@Test
	public void test() {
		ArrayList<Book> books = generateBooks();
		ArrayList<Staff> staffList = generateStaff();
		ArrayList<Borrower> borrowers = generateBorrowers();
		Session session = ResetSchema.openSession();
		session.beginTransaction();
		for(Book book : books){
			session.save(book);
		}
		
		for(Staff staff : staffList){
			session.save(staff);
		}
		
		for(Borrower borrower : borrowers){
			session.save(borrower);
		}
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	public ArrayList<Book> generateBooks(){
		int isbn = 1000000; 
		ArrayList<Book>	books = new ArrayList<Book>();
		
		Author author1 = new Author();
		author1.setFirstName("George");
		author1.setLastName("R. R. Martin");
		
		Book book1 = new Book();
		book1.setIsbn(isbn++);
		book1.setTitle("A Song of Ice and Fire: A Game of Thrones");
		book1.setSubject("Fantasy Fiction");
		book1.setAuthor(author1);
		books.add(book1);

		Book book2 = new Book();
		book2.setIsbn(isbn++);
		book2.setTitle("A Song of Ice and Fire: A Clash of Kings");
		book2.setSubject("Fantasy Fiction");
		book2.setAuthor(author1);
		books.add(book2);

		Book book3 = new Book();
		book3.setIsbn(isbn++);
		book3.setTitle("A Song of Ice and Fire: A Storm of Swords");
		book3.setSubject("Fantasy Fiction");
		book3.setAuthor(author1);
		books.add(book3);

		Book book4 = new Book();
		book4.setIsbn(isbn++);
		book4.setTitle("A Song of Ice and Fire: A Feast of Crows");
		book4.setSubject("Fantasy Fiction");
		book4.setAuthor(author1);
		books.add(book4);

		Book book5 = new Book();
		book5.setIsbn(isbn++);
		book5.setTitle("A Song of Ice and Fire: A Dance with Dragons");
		book5.setSubject("Fantasy Fiction");
		book5.setAuthor(author1);
		books.add(book5);

		Book book6 = new Book();
		book6.setIsbn(isbn++);
		book6.setTitle("A Song of Ice and Fire: The Winds of Winter");
		book6.setSubject("Fantasy Fiction");
		book6.setAuthor(author1);
		books.add(book6);

		Book book7 = new Book();
		book7.setIsbn(isbn++);
		book7.setTitle("A Song of Ice and Fire: A Dream of Spring");
		book7.setSubject("Fantasy Fiction");
		book7.setAuthor(author1);
		books.add(book7);
		
		author1.getBooksWritten().add(book1);
		author1.getBooksWritten().add(book2);
		author1.getBooksWritten().add(book3);
		author1.getBooksWritten().add(book4);
		author1.getBooksWritten().add(book5);
		author1.getBooksWritten().add(book6);
		author1.getBooksWritten().add(book7);
		
		Author author2 = new Author();
		author2.setFirstName("J. R. R.");
		author2.setLastName("Tolkien");		

		Book book8 = new Book();
		book8.setIsbn(isbn++);
		book8.setTitle("Lord of the Rings: Fellowship of the Ring");
		book8.setSubject("Fantasy Fiction");
		book8.setAuthor(author2);
		books.add(book8);
		
		Book book9 = new Book();
		book9.setIsbn(isbn++);
		book9.setTitle("Lord of the Rings: The Two Towers");
		book9.setSubject("Fantasy Fiction");
		book9.setAuthor(author2);
		books.add(book9);
		
		Book book10 = new Book();
		book10.setIsbn(isbn++);
		book10.setTitle("Lord of the Rings: The Return of the King");
		book10.setSubject("Fantasy Fiction");
		book10.setAuthor(author2);
		books.add(book10);
		
		author2.getBooksWritten().add(book8);
		author2.getBooksWritten().add(book9);
		author2.getBooksWritten().add(book10);
		
		Author author3 = new Author();
		author3.setFirstName("JK");
		author3.setLastName("Rowling");
		
		Book book11 = new Book();
		book11.setIsbn(isbn++);
		book11.setTitle("Harry Potter and the Sorcerer's Stone");
		book11.setSubject("Fantasy Fiction");
		book11.setAuthor(author3);
		books.add(book11);
		
		Book book12 = new Book();
		book12.setIsbn(isbn++);
		book12.setTitle("Harry Potter and the Chamber of Secrets");
		book12.setSubject("Fantasy Fiction");
		book12.setAuthor(author3);
		books.add(book12);
		
		Book book13 = new Book();
		book13.setIsbn(isbn++);
		book13.setTitle("Harry Potter and the Prisoner of Azkaban");
		book13.setSubject("Fantasy Fiction");
		book13.setAuthor(author3);
		books.add(book13);
		
		Book book14 = new Book();
		book14.setIsbn(isbn++);
		book14.setTitle("Harry Potter and the Goblet of Fire");
		book14.setSubject("Fantasy Fiction");
		book14.setAuthor(author3);
		books.add(book14);
		
		Book book15 = new Book();
		book15.setIsbn(isbn++);
		book15.setTitle("Harry Potter and the Order of the Phoenix");
		book15.setSubject("Fantasy Fiction");
		book15.setAuthor(author3);
		books.add(book15);
		
		Book book16 = new Book();
		book16.setIsbn(isbn++);
		book16.setTitle("Harry Potter and the Half-Blood Prince");
		book16.setSubject("Fantasy Fiction");
		book16.setAuthor(author3);
		books.add(book16);
		
		Book book17 = new Book();
		book17.setIsbn(isbn++);
		book17.setTitle("Harry Potter and the Deathly Hallows");
		book17.setSubject("Fantasy Fiction");
		book17.setAuthor(author3);
		books.add(book17);
		
		author3.getBooksWritten().add(book11);
		author3.getBooksWritten().add(book12);
		author3.getBooksWritten().add(book13);
		author3.getBooksWritten().add(book14);
		author3.getBooksWritten().add(book15);
		author3.getBooksWritten().add(book16);
		author3.getBooksWritten().add(book17);
		
		Author author4 = new Author();
		author4.setFirstName("DJ");
		author4.setLastName("MacHale");

		Book book18 = new Book();
		book18.setIsbn(isbn++);
		book18.setTitle("Pendragon: The Merchant of Death");
		book18.setSubject("Young-Adult Fiction");
		book18.setAuthor(author4);
		books.add(book18);
		
		Book book19 = new Book();
		book19.setIsbn(isbn++);
		book19.setTitle("Pendragon: The Lost City of Faar");
		book19.setSubject("Young-Adult Fiction");
		book19.setAuthor(author4);
		books.add(book19);
		
		Book book20 = new Book();
		book20.setIsbn(isbn++);
		book20.setTitle("Pendragon: The Never War");
		book20.setSubject("Young-Adult Fiction");
		book20.setAuthor(author4);
		books.add(book20);
		
		Book book21 = new Book();
		book21.setIsbn(isbn++);
		book21.setTitle("Pendragon: The Reality Bug");
		book21.setSubject("Young-Adult Fiction");
		book21.setAuthor(author4);
		books.add(book21);
		
		Book book22 = new Book();
		book22.setIsbn(isbn++);
		book22.setTitle("Pendragon: Black Water");
		book22.setSubject("Young-Adult Fiction");
		book22.setAuthor(author4);
		books.add(book22);
		
		Book book23 = new Book();
		book23.setIsbn(isbn++);
		book23.setTitle("Pendragon: The Rivers of Zadaa");
		book23.setSubject("Young-Adult Fiction");
		book23.setAuthor(author4);
		books.add(book23);
		
		Book book24 = new Book();
		book24.setIsbn(isbn++);
		book24.setTitle("Pendragon: The Quillan Games");
		book24.setSubject("Young-Adult Fiction");
		book24.setAuthor(author4);
		books.add(book24);
		
		Book book25 = new Book();
		book25.setIsbn(isbn++);
		book25.setTitle("Pendragon: The Pilgrims of Rayne");
		book25.setSubject("Young-Adult Fiction");
		book25.setAuthor(author4);
		books.add(book25);
		
		Book book26 = new Book();
		book26.setIsbn(isbn++);
		book26.setTitle("Pendragon: Raven Rise");
		book26.setSubject("Young-Adult Fiction");
		book26.setAuthor(author4);
		books.add(book26);
		
		Book book27 = new Book();
		book27.setIsbn(isbn++);
		book27.setTitle("Pendragon: The Soldiers of Halla");
		book27.setSubject("Young-Adult Fiction");
		book27.setAuthor(author4);
		books.add(book27);
		
		author3.getBooksWritten().add(book18);
		author3.getBooksWritten().add(book19);
		author3.getBooksWritten().add(book20);
		author3.getBooksWritten().add(book21);
		author3.getBooksWritten().add(book22);
		author3.getBooksWritten().add(book23);
		author3.getBooksWritten().add(book24);
		author3.getBooksWritten().add(book25);
		author3.getBooksWritten().add(book26);
		author3.getBooksWritten().add(book27);
		
		Author author5 = new Author();
		author5.setFirstName("Suzanne");
		author5.setLastName("Collins");
		
		Book book28 = new Book();
		book28.setIsbn(isbn++);
		book28.setTitle("Hunger Games");
		book28.setSubject("Young-Adult Sci-Fi");
		book28.setAuthor(author5);
		books.add(book28);
		
		Book book29 = new Book();
		book29.setIsbn(isbn++);
		book29.setTitle("Catching Fire");
		book29.setSubject("Young-Adult Sci-Fi");
		book29.setAuthor(author5);
		books.add(book29);
		
		Book book30 = new Book();
		book30.setIsbn(isbn++);
		book30.setTitle("Mockingjay");
		book30.setSubject("Young-Adult Sci-Fi");
		book30.setAuthor(author5);
		books.add(book30);
		
		author3.getBooksWritten().add(book28);
		author3.getBooksWritten().add(book29);
		author3.getBooksWritten().add(book30);
		
		Random randomGen = new Random();
		for(Book book: books){
			int rand = randomGen.nextInt(5) + 1;
			for(int i = 1; i <= rand; i++){
				Copy copy = new Copy();
				copy.setBook(book);
				book.getCopies().add(copy);
			}
		}
		
		return books;
	}
	
	public ArrayList<Staff> generateStaff(){

		ArrayList<Staff> staff = new ArrayList<Staff>();
		java.util.Date currentDate = Calendar.getInstance().getTime(); 
		Date today = new Date(currentDate.getTime());
		
		Address address1 = new Address();
		address1.setStreetAddress("123 Sesame St.");
		address1.setCity("Scranton");
		address1.setState("PA");
		address1.setZipCode(55555);
		
		Staff staff1 = new Staff();
		staff1.setFirstName("Michael");
		staff1.setLastName("Scott");
		staff1.setUserName("michaelscott");
		staff1.setHireDate(today);
		staff1.setPassword("Password123");
		staff1.setAddress(address1);
		staff.add(staff1);
		
		Address address2 = new Address();
		address2.setStreetAddress("224 Broadway Ave");
		address2.setCity("Scranton");
		address2.setState("PA");
		address2.setZipCode(44444);
		
		Staff staff2 = new Staff();
		staff2.setFirstName("Jim");
		staff2.setLastName("Halpert");
		staff2.setUserName("jimhalpert");
		staff2.setHireDate(today);
		staff2.setPassword("Password123");
		staff2.setAddress(address2);
		staff.add(staff2);
		
		Address address3 = new Address();
		address3.setStreetAddress("120 Main St");
		address3.setCity("Scranton");
		address3.setState("PA");
		address3.setZipCode(33333);
		
		Staff staff3 = new Staff();
		staff3.setFirstName("Dwight");
		staff3.setLastName("Schrute");
		staff3.setUserName("dwightschrute");
		staff3.setHireDate(today);
		staff3.setPassword("Password123");
		staff3.setAddress(address3);
		staff.add(staff3);
		
		Address address4 = new Address();
		address4.setStreetAddress("504 West 5th St.");
		address4.setCity("Scranton");
		address4.setState("PA");
		address4.setZipCode(22222);
		
		Staff staff4 = new Staff();
		staff4.setFirstName("Pam");
		staff4.setLastName("Beasley");
		staff4.setUserName("pambeasley");
		staff4.setHireDate(today);
		staff4.setPassword("Password123");
		staff4.setAddress(address4);
		staff.add(staff4);
		
		Address address5 = new Address();
		address5.setStreetAddress("550 Sycamore St.");
		address5.setCity("Scranton");
		address5.setState("PA");
		address5.setZipCode(11111);
		
		Staff staff5 = new Staff();
		staff5.setFirstName("Darryl");
		staff5.setLastName("Philbin");
		staff5.setUserName("darrylphilbin");
		staff5.setHireDate(today);
		staff5.setPassword("Password123");
		staff5.setAddress(address5);
		staff.add(staff5);
		
		return staff;
	}
	
	public ArrayList<Borrower> generateBorrowers(){
		ArrayList<Borrower> borrowers = new ArrayList<Borrower>();		
		java.util.Date currentDate = Calendar.getInstance().getTime(); 
		Date today = new Date(currentDate.getTime());
		
		Address address1 = new Address();
		address1.setStreetAddress("555 University Ave.");
		address1.setCity("Little Rock");
		address1.setState("AR");
		address1.setZipCode(77777);
		
		Borrower bo1 = new Borrower();
		bo1.setFirstName("John");
		bo1.setLastName("Smith");
		bo1.setUserName("johnsmith");
		bo1.setJoinDate(today);
		bo1.setPassword("Password123");
		bo1.setAddress(address1);
		borrowers.add(bo1);
		
		Address address2 = new Address();
		address2.setStreetAddress("546 Cantrell Rd");
		address2.setCity("Little Rock");
		address2.setState("AR");
		address2.setZipCode(77777);
		
		Borrower bo2 = new Borrower();
		bo2.setFirstName("John");
		bo2.setLastName("Smith");
		bo2.setUserName("johnsmith1");
		bo2.setJoinDate(today);
		bo2.setPassword("Password123");
		bo2.setAddress(address2);
		borrowers.add(bo2);
		
		Address address3 = new Address();
		address3.setStreetAddress("789 Chenal Pkwy");
		address3.setCity("Little Rock");
		address3.setState("AR");
		address3.setZipCode(55555);
		
		Borrower bo3 = new Borrower();
		bo3.setFirstName("Meridith");
		bo3.setLastName("Palmer");
		bo3.setUserName("meridithpalmer");
		bo3.setJoinDate(today);
		bo3.setPassword("Password123");
		bo3.setAddress(address3);
		borrowers.add(bo3);
		
		Address address4 = new Address();
		address4.setStreetAddress("2020 West Markham St.");
		address4.setCity("Little Rock");
		address4.setState("AR");
		address4.setZipCode(77777);
		
		Borrower bo4 = new Borrower();
		bo4.setFirstName("John");
		bo4.setLastName("Oliver");
		bo4.setUserName("johnoliver");
		bo4.setJoinDate(today);
		bo4.setPassword("Password123");
		bo4.setAddress(address4);
		borrowers.add(bo4);
		
		Address address5 = new Address();
		address5.setStreetAddress("155 Willow St.");
		address5.setCity("Little Rock");
		address5.setState("AR");
		address5.setZipCode(88888);
		
		Borrower bo5 = new Borrower();
		bo5.setFirstName("Eric");
		bo5.setLastName("Cartman");
		bo5.setUserName("ericcartman");
		bo5.setJoinDate(today);
		bo5.setPassword("Password123");
		bo5.setAddress(address5);
		borrowers.add(bo5);
		
		Address address6 = new Address();
		address6.setStreetAddress("556 Main St.");
		address6.setCity("Little Rock");
		address6.setState("AR");
		address6.setZipCode(77777);
		
		Borrower bo6 = new Borrower();
		bo6.setFirstName("Stan");
		bo6.setLastName("Marsh");
		bo6.setUserName("stanmarsh");
		bo6.setJoinDate(today);
		bo6.setPassword("Password123");
		bo6.setAddress(address6);
		borrowers.add(bo6);
		
		Address address7 = new Address();
		address7.setStreetAddress("5655 John Barrow Rd.");
		address7.setCity("Little Rock");
		address7.setState("AR");
		address7.setZipCode(77777);
		
		Borrower bo7 = new Borrower();
		bo7.setFirstName("Kyle");
		bo7.setLastName("Broflovski");
		bo7.setUserName("kylebroflovski");
		bo7.setJoinDate(today);
		bo7.setPassword("Password123");
		bo7.setAddress(address7);
		borrowers.add(bo7);
		
		Address address8 = new Address();
		address8.setStreetAddress("123 Green St");
		address8.setCity("South Park");
		address8.setState("CO");
		address8.setZipCode(11111);
		
		Borrower bo8  = new Borrower();
		bo8.setFirstName("Kenny");
		bo8.setLastName("McCormick");
		bo8.setUserName("kennymccormick");
		bo8.setJoinDate(today);
		bo8.setPassword("Password123");
		bo8.setAddress(address8);
		borrowers.add(bo8);
		
		Address address9 = new Address();
		address9.setStreetAddress("555 Red St.");
		address9.setCity("South Park");
		address9.setState("CO");
		address9.setZipCode(44444);
		
		Borrower bo9 = new Borrower();
		bo9.setFirstName("Wendy");
		bo9.setLastName("Testaburger");
		bo9.setUserName("wendytestaburger");
		bo9.setJoinDate(today);
		bo9.setPassword("Password123");
		bo9.setAddress(address9);
		borrowers.add(bo9);
		
		Address address10 = new Address();
		address10.setStreetAddress("666 Blue St.");
		address10.setCity("South Park");
		address10.setState("CO");
		address10.setZipCode(99999);
		
		Borrower bo10 = new Borrower();
		bo10.setFirstName("Jerome");
		bo10.setLastName("McElroy");
		bo10.setUserName("jeromemcelroy");
		bo10.setJoinDate(today);
		bo10.setPassword("Password123");
		bo10.setAddress(address10);
		borrowers.add(bo10);
		
		return borrowers;
	}

}
