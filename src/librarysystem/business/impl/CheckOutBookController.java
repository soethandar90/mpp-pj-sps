package librarysystem.business.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import librarysystem.business.usecase.CheckMemberUseCase;
import librarysystem.business.usecase.CheckOutBookUseCase;
import librarysystem.business.usecase.SearchBookUseCase;
import librarysystem.dataaccess.DataAccess;
import librarysystem.dataaccess.DataAccessFacade;
import librarysystem.domain.Book;
import librarysystem.domain.BookCopy;
import librarysystem.domain.CheckOutRecord;
import librarysystem.domain.CheckOutRecordEntry;
import librarysystem.domain.LibraryMember;
import librarysystem.domain.exception.BookCopyNotAvailableException;
import librarysystem.domain.exception.BookNotFoundException;
import librarysystem.domain.exception.MemberNotFoundException;

public class CheckOutBookController implements CheckOutBookUseCase {
	
	private SearchBookUseCase searchBookUseCase;
	private CheckMemberUseCase checkMember;
	
	CheckOutBookController() {
		searchBookUseCase = ControllerFactory.createSearchBookUseCase();
		checkMember = ControllerFactory.createCheckMemberUseCase();
	}


	@Override
	public void checkOutBook(String memberId, String bookId) throws BookNotFoundException, MemberNotFoundException, BookCopyNotAvailableException {
		DataAccess da = new DataAccessFacade();

		Book book = searchBookUseCase.searchBook(bookId);

		if (book == null) {
			throw new BookNotFoundException("Book not found");
		}

		if (!checkMember.checkMember(memberId)) {
			throw new MemberNotFoundException("Member not found");
		}
		
		LibraryMember member = checkMember.getMember(memberId);
		
		
		// Check Book Available
	 	BookCopy bookCopy = book.getNextAvailableCopy();
	 	
	 	if(bookCopy == null) {
	 		throw new BookCopyNotAvailableException(book.getIsbn());
	 	}
	 	
	 	bookCopy.changeAvailability();
	 	
	 	LocalDate dueDate = LocalDate.now().plusDays(bookCopy.getBook().getMaxCheckoutLength());
	 	LocalDate checkOutDate = LocalDate.now();
	 	CheckOutRecordEntry checkOutEntry = new CheckOutRecordEntry(dueDate, checkOutDate, bookCopy);

	 	HashMap<String, CheckOutRecord> hmCheckOutRecord = da.readCheckOutRecordsMap();
	 	
	 	CheckOutRecord checkOutRecord = null;
	 	
	 	if(hmCheckOutRecord.get(member.getMemberId()) != null) {
	 		checkOutRecord = hmCheckOutRecord.get(member.getMemberId());
	 		
	 		checkOutRecord.addCheckOutRecordEntry(checkOutEntry);
	 	} else {

	 		ArrayList<CheckOutRecordEntry> list = new ArrayList<>();
	 		list.add(checkOutEntry);
	 		checkOutRecord = new CheckOutRecord(member, list);
	 	}
	 	
	 	// save checkoutrecord -> save to file
	 	hmCheckOutRecord.put(member.getMemberId(), checkOutRecord);
		da.saveCheckOutRecord(hmCheckOutRecord);
		
		// update book collection
		book.updateCopies(bookCopy);
		
		HashMap<String, Book> hmBooks = da.readBooksMap();
		Book bookFromDB = hmBooks.get(book.getIsbn());
		
		hmBooks.put(bookFromDB.getIsbn(), book);
		da.updateBookHM(hmBooks);
	}

	@Override
	public CheckOutRecord getCheckOutRecord(String memberId) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, CheckOutRecord> hmCheckOutRecord = da.readCheckOutRecordsMap();
	 	 	
	 	return hmCheckOutRecord.get(memberId); 
	 		
	}
}
