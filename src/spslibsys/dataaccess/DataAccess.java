package spslibsys.dataaccess;

import java.util.HashMap;

import spslibsys.dom.Author;
import spslibsys.dom.Book;
import spslibsys.dom.CheckOutRecord;
import spslibsys.dom.LibraryMember;

public interface DataAccess {
	public HashMap<String, Book> readBooksMap(); // Added by WinWin

	public HashMap<String, User> readUserMap();

	public HashMap<String, LibraryMember> readMemberMap();

	public HashMap<String, Author> readAuthorMap(); // Added by WinWin

	public HashMap<String, CheckOutRecord> readCheckOutRecordsMap();

	public void saveNewMember(LibraryMember member);

	public void saveNewBook(Book book);

	public void updateBookHM(HashMap<String, Book> hmBooks);

	public void saveCheckOutRecord(HashMap<String, CheckOutRecord> hmCheckOutRecords);

}
