package librarysystem.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckOutRecordEntry implements Serializable {
    
	private static final long serialVersionUID = -1359858381766289758L;
	private LocalDate dueDate;
    private LocalDate checkOutDate;
    private BookCopy bookCopy;
    
    public CheckOutRecordEntry(LocalDate dueDate, LocalDate checkOutDate, BookCopy bookCopy){
        this.dueDate = dueDate;
        this.checkOutDate = checkOutDate;
        this.bookCopy = bookCopy;
        		
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
    
    public BookCopy getBookCopy() {
        return bookCopy;
    }

}
