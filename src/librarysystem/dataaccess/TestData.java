package librarysystem.dataaccess;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import librarysystem.domain.Address;
import librarysystem.domain.Author;
import librarysystem.domain.Book;
import librarysystem.domain.CheckOutRecord;
import librarysystem.domain.CheckOutRecordEntry;
import librarysystem.domain.LibraryMember;

/**
 * This class loads data into the data repository and also sets up the storage
 * units that are used in the application. The main method in this class must be
 * run once (and only once) before the rest of the application can work
 * properly. It will create three serialized objects in the dataaccess.storage
 * folder.
 * 
 *
 */
public class TestData {
	public static void main(String[] args) {
		TestData td = new TestData();
		td.bookData();
		td.libraryMemberData();
		td.userData();

		// Added by WinWin
		td.authorData();

		td.checkOutRecordData();

		DataAccess da = new DataAccessFacade();
		System.out.println(da.readBooksMap());
		System.out.println(da.readUserMap());
	}

	/// create books
	public void bookData() {
		allBooks.get(0).addCopy();
		allBooks.get(0).addCopy();
		allBooks.get(1).addCopy();
		allBooks.get(3).addCopy();
		allBooks.get(2).addCopy();
		allBooks.get(2).addCopy();
		DataAccessFacade.loadBookMap(allBooks);

	}

	public void userData() {
		DataAccessFacade.loadUserMap(allUsers);
	}

	// Added by WinWin
	public void authorData() {
		DataAccessFacade.loadAuthorMap(allAuthors);
	}

	public void checkOutRecordData() {
//		@SuppressWarnings("serial")
		LibraryMember libraryMember = new LibraryMember("1001", "Andrew", "Smiths", "444-333-2211", addresses.get(4));

		CheckOutRecordEntry entry = new CheckOutRecordEntry(LocalDate.now(), LocalDate.now(),
				allBooks.get(0).getCopy(0));
		CheckOutRecordEntry entry1 = new CheckOutRecordEntry(LocalDate.now(), LocalDate.now(),
				allBooks.get(0).getCopy(0));

		List<CheckOutRecordEntry> list = new ArrayList<CheckOutRecordEntry>();
		list.add(entry);
		list.add(entry1);
		@SuppressWarnings("serial")
		CheckOutRecord checkOutRecord = new CheckOutRecord(libraryMember, list);

		DataAccessFacade.loadCheckOutRecordMap(checkOutRecord);
	}

	// create library members
	public void libraryMemberData() {
		LibraryMember libraryMember = new LibraryMember("1001", "Andrew", "Smiths", "444-333-2211", addresses.get(4));
		members.add(libraryMember);
		libraryMember = new LibraryMember("1002", "AAAA", "TheAs", "777-999-2424", addresses.get(5));
		members.add(libraryMember);

		libraryMember = new LibraryMember("1003", "SSS", "TheSs", "456-789-0123", addresses.get(6));
		members.add(libraryMember);

		libraryMember = new LibraryMember("1004", "RRRR", "TheRs", "654-321-0000", addresses.get(2));
		members.add(libraryMember);

		DataAccessFacade.loadMemberMap(members);
	}

	///////////// DATA //////////////
	List<LibraryMember> members = new ArrayList<LibraryMember>();
	@SuppressWarnings("serial")

	List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("1000N 4th Street", "Fairfield", "IA", "52556"));
			add(new Address("5000N 5th Street", "Georgetown", "MI", "65434"));
			add(new Address("9000N 9th Street", "Palo Alto", "CA", "94301"));
			add(new Address("6000N 6th Street", "Seville", "Georgia", "41234"));
			add(new Address("8888E 8th Street", "Fairfield", "IA", "52556"));
			add(new Address("7777W 7th Street", "Los Angeles", "CA", "93736"));
			add(new Address("1010S 10th Street", "Ottumwa", "IA", "57789"));
		}
	};

	// Added authorId by WinWin
	@SuppressWarnings("serial")
	public List<Author> allAuthors = new ArrayList<Author>() {
		{
			add(new Author("A101", "Soe", "STD", "641-445-2123", addresses.get(0), "Independent Woman"));
			add(new Author("A102", "Sandra", "Park", "641-445-2123", addresses.get(0), "2NE1 is coming back"));
			add(new Author("A103", "Tamila", "Noah", "641-919-3223", addresses.get(1), "Just Kidding!"));
			add(new Author("A104", "Sandhya", "KMW", "976-445-2232", addresses.get(2),
					"Habits of Childrens"));
			add(new Author("A105", "Pooh", "Phoooh", "123-422-2663", addresses.get(3), "Honey Pool is paradise!"));
		}
	};

	@SuppressWarnings("serial")
	List<Book> allBooks = new ArrayList<Book>() {
		{
			add(new Book("23-11111", "Habit of Children", 21, Arrays.asList(allAuthors.get(0), allAuthors.get(1))));
			add(new Book("28-12345", "Oceans via Earth", 7, Arrays.asList(allAuthors.get(2))));
			add(new Book("99-22222", "Thinking Java", 21, Arrays.asList(allAuthors.get(3))));
			add(new Book("48-44444", "Dance School", 7, Arrays.asList(allAuthors.get(4))));
		}
	};

	@SuppressWarnings("serial")
	List<User> allUsers = new ArrayList<User>() {
		{
			add(new User("Sandhya", "sandhya", Auth.LIBRARIAN));
			add(new User("Phyo", "phyo", Auth.ADMIN));
			add(new User("Soe", "soe", Auth.BOTH));
		}
	};

}
